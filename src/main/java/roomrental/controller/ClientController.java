package roomrental.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import roomrental.domain.model.Client;
import roomrental.model.FilterForm;
import roomrental.service.ClientService;

import java.util.List;
import java.util.Optional;

@Controller
//@Controller — oznaczamy nią kontrolery, tj. klasy, które będą obsługiwały zapytania wysyłane poprzez przeglądarkę od użytkowników.
@RequiredArgsConstructor
////Ta adnotacja wygeneruje konstruktor z wszystkimi wymaganymi polami
@RequestMapping("/client")
//@RequestMapping — mapuje adres URL i/lub metodę HTTP na metodę kontrolera
@Slf4j
//"Simple Logging Facade for Java" abstrakcja rejestrowania, która pomaga odłączyć aplikację od
// podstawowego rejestratora, umożliwiając jej podłączenie - w czasie wykonywania.
//Obsługuje wszystkie główne ramy logowania
//SLF4J jest po prostu API i nic nie wie o podstawowym rejestratorze, który zarządza dziennikami.
public class ClientController {

	private final ClientService clientService;

	@GetMapping("/create")
	public String createClientForm(Model model) {
		model.addAttribute("client", new Client());
		return "client/form";
	}

	@PostMapping("/create")
	public String createClient(@ModelAttribute("room") Client client) {
		//Atrybut @ModelAttribute na argumencie metody wskazuje, że argument należy pobrać z modelu.
		// Jeśli nie ma go w modelu, argument należy najpierw utworzyć, a następnie dodać do modelu.
		// Po wprowadzeniu do modelu pola argumentów powinny zostać wypełnione ze wszystkich parametrów żądań,
		// które mają pasujące nazwy. Jest to znane jako powiązanie danych w Spring MVC, bardzo przydatny mechanizm,
		// który pozwala uniknąć konieczności analizowania każdego pola formularza indywidualnie.
		clientService.createClient(client);
		log.info("Created new client {}", client);

		return "redirect:/client/list";
	}

	@GetMapping("/edit/{id}")
	public String editClientForm(@PathVariable("id") Integer id, Model model) {
		//@PathVariable nawiązuje do ścieżki zmiennej
		Optional<Client> maybeClient = clientService.getClientById(id);
		//Optional(T value) - konstruktor rzucający błąd w przypadku przekazania wartości null.
		//najczęściej używamy z:
		//isPresent() - zwraca boolean mówiący czy w środku znajduje się jakaś wartość czy też null.
		//get() - pobranie przechowywanego obiektu. Jeżeli takiego nie dostaniemy: NoSuchElementException

		if (!maybeClient.isPresent()) {
			return "redirect:/client/create";
		} else {
			model.addAttribute("client", maybeClient.get());
			//.addAttribute Dodaj dostarczony atrybut do tej mapy, używając wygenerowanej nazwy.
			return "client/edit-form";
		}
	}

	@PostMapping("/edit/{id}")
	public String editClient(@ModelAttribute("client") Client client) {
		clientService.editClient(client);

		return "redirect:/client/list";
	}

	@GetMapping("/list")
	public String ownerList(Model model) {
		List<Client> clients = clientService.getAllClients();
		model.addAttribute("clients", clients);

		return "client/list";
	}

	@GetMapping("/find-by-last-name")
	public String findByLastNameForm(Model model) {
		model.addAttribute("filterForm", new FilterForm());
		return "client/find";
	}

	@PostMapping("/find-by-last-name")
	public String findByLastNameForm(@ModelAttribute("filterForm") FilterForm filterForm, Model model) {
		//Atrybut @ModelAttribute na argumencie metody wskazuje, że argument należy pobrać z modelu.
		// Jeśli nie ma go w modelu, argument należy najpierw utworzyć, a następnie dodać do modelu.
		// Po wprowadzeniu do modelu pola argumentu powinny zostać wypełnione ze wszystkich parametrów żądań,
		// które mają pasujące nazwy. Jest to znane jako powiązanie danych w Spring MVC, bardzo przydatny mechanizm,
		// który pozwala uniknąć konieczności analizowania każdego pola formularza indywidualnie.
		List<Client> clients = clientService.findAllByLastNameContaining(filterForm.getLastName());
		model.addAttribute("clients", clients);
		return "client/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		clientService.deleteById(id);

		return "redirect:/client/list";
	}
}
