package roomrental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomrental.domain.model.Client;
import roomrental.domain.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
//W najprostszym rozumieniu adnotacje to wskazówki dla Springa w
// jaki sposób ma traktować poszczególne metody, klasy, pola i
// dzięki temu jest w stanie samodzielnie tworzyć beany
// @Service wskazuje serwis w warstwie logiki biznesowej
@RequiredArgsConstructor
//Ta adnotacja wygeneruje konstruktor z wszystkimi wymaganymi polami
public class ClientService {

	private final ClientRepository clientRepository;

	public void createClient(Client client) {
		clientRepository.save(client);
	}

	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	public Optional<Client> getClientById(Integer id) {
		return clientRepository.findById(id);
	}

	public void editClient(Client client) {
		clientRepository.save(client);
	}

	public List<Client> findAllByLastNameContaining(String lastName) {
		return clientRepository.findAllByLastNameContaining(lastName);
	}

	public void deleteById(Integer id) {
		clientRepository.deleteById(id);
	}
}

