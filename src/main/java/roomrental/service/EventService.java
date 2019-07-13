package roomrental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomrental.domain.model.Client;
import roomrental.domain.model.Event;
import roomrental.domain.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

	private final EventRepository eventRepository;
	private final ClientService clientService;

	public void create(Event event, Integer clientId) {
		Optional<Client> client = clientService.getClientById(clientId);

		client.ifPresent(event::setClient);

//		if (owner.isPresent()) {
//			pet.setOwner(owner.get());
//		}

		eventRepository.save(event);
	}

	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	public Optional<Event> getEventById(Integer id) {
		return eventRepository.findById(id);
	}

	public void editEvent(Event event) {
		eventRepository.save(event);
	}

	public List<Event> findAllByNameContaining(String name) {
		return eventRepository.findAllByNameContaining(name);
	}

	public void deleteById(Integer id) {
		eventRepository.deleteById(id);
	}
}

