package leite.sampaio.lucas.eventsschedule.service.impl;

import leite.sampaio.lucas.eventsschedule.exceptions.ResourceNotFoundException;
import leite.sampaio.lucas.eventsschedule.model.Address;
import leite.sampaio.lucas.eventsschedule.model.Event;
import leite.sampaio.lucas.eventsschedule.repository.AddressRepository;
import leite.sampaio.lucas.eventsschedule.repository.EventRepository;
import leite.sampaio.lucas.eventsschedule.service.AddressService;
import leite.sampaio.lucas.eventsschedule.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressService addressService;

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Event create(Event event) {
        return saveEventWithZipCode(event);
    }

    @Override
    public Event update(Long id, Event event) {
        Optional<Event> eventDb = eventRepository.findById(id);
        if (eventDb.isEmpty())
            throw new ResourceNotFoundException(id);
        return saveEventWithZipCode(event);
    }

    @Override
    public void delete(Long id) {
        if (eventRepository.existsById(id))
            eventRepository.deleteById(id);
        else
            throw new ResourceNotFoundException(id);
    }

    private Event saveEventWithZipCode(Event event) {
        String zipCode = event.getAddress().getZipCode();
        Address address = addressRepository.findById(zipCode).orElseGet(() -> {
            Address newAddress = addressService.findZipCode(zipCode);
            addressRepository.save(newAddress);
            return newAddress;
        });
        event.setAddress(address);
        return eventRepository.save(event);
    }
}




