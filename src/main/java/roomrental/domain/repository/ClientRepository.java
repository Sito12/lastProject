package roomrental.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import roomrental.domain.model.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	//co to robi?
	List<Client> findAllByLastNameContaining(String lastName);
}
