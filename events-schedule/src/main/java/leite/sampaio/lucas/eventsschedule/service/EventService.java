package leite.sampaio.lucas.eventsschedule.service;

import leite.sampaio.lucas.eventsschedule.model.Event;

import java.util.List;


public interface EventService {
    List<Event> findAll();

    Event findById(Long id);

    Event create(Event event);

    Event update(Long id, Event event);

    void delete(Long id);

}
