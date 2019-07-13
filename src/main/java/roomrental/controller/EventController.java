package roomrental.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import roomrental.domain.model.Client;
import roomrental.domain.model.Event;
import roomrental.model.FilterForm;
import roomrental.service.EventService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event")
@Slf4j
public class EventController {

	private final EventService eventService;

	@GetMapping("/create/{roomId}")
	public String createPetForm(Model model, @PathVariable("clientId") Integer clientId) {
		model.addAttribute("event", new Event());
		model.addAttribute("clientId", clientId);
		return "event/form";
	}

	@PostMapping("/create/{clientId}")
	public String createEvent(@ModelAttribute("event") Event event, @PathVariable("clientId") Integer clientId) {
		eventService.create(event, clientId);

		return "redirect:/client/list";
	}
	@GetMapping("/list")
	public String eventList(Model model) {
		List<Event> events = eventService.getAllEvents();
		model.addAttribute("events", events);

		return "event/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		eventService.deleteById(id);

		return "redirect:/event/list";
	}

	@GetMapping("/edit/{id}")
	public String editEventForm(@PathVariable("id") Integer id, Model model) {
		//@PathVariable nawiązuje do ścieżki zmiennej
		Optional<Event> maybeEvent = eventService.getEventById(id);
		//Optional(T value) - konstruktor rzucający błąd w przypadku przekazania wartości null.
		//najczęściej używamy z:
		//isPresent() - zwraca boolean mówiący czy w środku znajduje się jakaś wartość czy też null.
		//get() - pobranie przechowywanego obiektu. Jeżeli takiego nie dostaniemy: NoSuchElementException

		if (!maybeEvent.isPresent()) {
			return "redirect:/event/create";
		} else {
			model.addAttribute("event", maybeEvent.get());
			//.addAttribute Dodaj dostarczony atrybut do tej mapy, używając wygenerowanej nazwy.
			return "event/edit-form";
		}
	}

	@PostMapping("/edit/{id}")
	public String editEvent(@ModelAttribute("event") Event event) {
		eventService.editEvent(event);

		return "redirect:/event/list";
	}
	@GetMapping("/find-by-name")
	public String findByNameForm(Model model) {
		model.addAttribute("filterForm", new FilterForm());
		return "event/find";
	}

	@PostMapping("/find-by-name")
	public String findByNameForm(@ModelAttribute("filterForm") FilterForm filterForm, Model model) {
		//Atrybut @ModelAttribute na argumencie metody wskazuje, że argument należy pobrać z modelu.
		// Jeśli nie ma go w modelu, argument należy najpierw utworzyć, a następnie dodać do modelu.
		// Po wprowadzeniu do modelu pola argumentu powinny zostać wypełnione ze wszystkich parametrów żądań,
		// które mają pasujące nazwy. Jest to znane jako powiązanie danych w Spring MVC, bardzo przydatny mechanizm,
		// który pozwala uniknąć konieczności analizowania każdego pola formularza indywidualnie.
		List<Event> events = eventService.findAllByNameContaining(filterForm.getName());
		model.addAttribute("events", events);
		return "event/list";
	}


}
