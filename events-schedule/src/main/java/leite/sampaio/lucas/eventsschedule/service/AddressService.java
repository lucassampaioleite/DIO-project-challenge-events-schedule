package leite.sampaio.lucas.eventsschedule.service;

import leite.sampaio.lucas.eventsschedule.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacepapi", url = "https://viacep.com.br/ws")
public interface AddressService {

    @GetMapping("/{zipCode}/json")
    Address findZipCode(@PathVariable("zipCode") String zipCode);
}
