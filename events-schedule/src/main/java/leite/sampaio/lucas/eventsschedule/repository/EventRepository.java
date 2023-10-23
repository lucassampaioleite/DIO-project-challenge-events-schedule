package leite.sampaio.lucas.eventsschedule.repository;

import leite.sampaio.lucas.eventsschedule.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
