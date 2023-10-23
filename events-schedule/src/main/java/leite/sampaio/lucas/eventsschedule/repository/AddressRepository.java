package leite.sampaio.lucas.eventsschedule.repository;

import leite.sampaio.lucas.eventsschedule.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}