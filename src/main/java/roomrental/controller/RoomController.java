package roomrental.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import roomrental.domain.model.Client;
import roomrental.domain.model.Room;
import roomrental.model.FilterForm;
import roomrental.service.RoomService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/room")
@Slf4j
public class RoomController {

	private final RoomService roomService;

	@GetMapping("/create")
	public String createRoomForm(Model model) {
		model.addAttribute("room", new Room());
		return "room/form";
	}

	@PostMapping("/create")
	public String createRoom(@ModelAttribute("room") Room room) {
		//Atrybut @ModelAttribute na argumencie metody wskazuje, że argument należy pobrać z modelu.
		// Jeśli nie ma go w modelu, argument należy najpierw utworzyć, a następnie dodać do modelu.
		// Po wprowadzeniu do modelu pola argumentów powinny zostać wypełnione ze wszystkich parametrów żądań,
		// które mają pasujące nazwy. Jest to znane jako powiązanie danych w Spring MVC, bardzo przydatny mechanizm,
		// który pozwala uniknąć konieczności analizowania każdego pola formularza indywidualnie.
		roomService.createRoom(room);
		log.info("Created new room {}", room);

		return "redirect:/room/list";
	}

	@GetMapping("/edit/{id}")
	public String editRoomForm(@PathVariable("id") Integer id, Model model) {
		//@PathVariable nawiązuje do ścieżki zmiennej
		Optional<Room> maybeRoom = roomService.getRoomById(id);
		//Optional(T value) - konstruktor rzucający błąd w przypadku przekazania wartości null.
		//najczęściej używamy z:
		//isPresent() - zwraca boolean mówiący czy w środku znajduje się jakaś wartość czy też null.
		//get() - pobranie przechowywanego obiektu. Jeżeli takiego nie dostaniemy: NoSuchElementException

		if (!maybeRoom.isPresent()) {
			return "redirect:/room/create";
		} else {
			model.addAttribute("room", maybeRoom.get());
			//.addAttribute Dodaj dostarczony atrybut do tej mapy, używając wygenerowanej nazwy.
			return "room/edit-form";
		}
	}

	@PostMapping("/edit/{id}")
	public String editRoom(@ModelAttribute("room") Room room) {
		roomService.editRoom(room);

		return "redirect:/room/list";
	}

	@GetMapping("/list")
	public String roomList(Model model) {
		List<Room> rooms = roomService.getAllRooms();
		model.addAttribute("rooms", rooms);

		return "room/list";
	}

	@GetMapping("/find-by-room-name")
	public String findByRoomNameForm(Model model) {
		model.addAttribute("filterForm", new FilterForm());
		return "room/find";
	}

	@PostMapping("/find-by-room-name")
	public String findByRoomNameForm(@ModelAttribute("filterForm") FilterForm filterForm, Model model) {
		//Atrybut @ModelAttribute na argumencie metody wskazuje, że argument należy pobrać z modelu.
		// Jeśli nie ma go w modelu, argument należy najpierw utworzyć, a następnie dodać do modelu.
		// Po wprowadzeniu do modelu pola argumentu powinny zostać wypełnione ze wszystkich parametrów żądań,
		// które mają pasujące nazwy. Jest to znane jako powiązanie danych w Spring MVC, bardzo przydatny mechanizm,
		// który pozwala uniknąć konieczności analizowania każdego pola formularza indywidualnie.
		List<Room> rooms = roomService.findAllByRoomNameContaining(filterForm.getRoomName());
		model.addAttribute("rooms", rooms);
		return "room/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		roomService.deleteById(id);

		return "redirect:/room/list";
	}
}
