package roomrental.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import roomrental.domain.model.Client;
import roomrental.domain.model.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findAllByNameContaining(String name);
}
