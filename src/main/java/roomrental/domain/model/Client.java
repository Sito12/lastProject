package roomrental.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
// jednostka reprezentuje tabelę w relacyjnej bazie danych
@Data
// tworzy publiczne POJO
public class Client {

	@Id
	//Id, co wskazuje, że pole członka poniżej jest kluczem podstawowym bieżącej jednostki. Stąd twoja struktura Hibernate i Spring
	@GeneratedValue
	//ma na celu skonfigurowanie sposobu przyrostu określonej kolumny (pola). Na przykład, gdy używasz Mysql, możesz określić auto_increment w definicji tabeli, aby uczynić ją przyrostową, a następnie użyć
	private Integer id;

	private String firstName;
	private String lastName;
	private boolean isCompany;
	private String companyName;
	private String email;
	private String telephone;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.ALL)
	private List<Event> Event;
}
//Znaczenie CascadeType.ALL polega na tym, że trwałość będzie propagować (kaskadowo) wszystkie operacje EntityManager (PERSIST, REMOVE, REFRESH, MERGE, DETACH) do powiązanych jednostek.
//mappedBy parametr ten mówi, które pole w drugiej klasie odpowiada tej samej relacji. Jest to używane do budowania obiektów na podstawie danych z bazy danych.
//domyślnie ma wartość LAZY dla @OneToMany oraz EAGER dla @ManyToOne.
//EAGER — pobierz w momencie wykonywania zapytania
//LAZY — pobierz dopiero kiedy będzie pierwsze odwołanie do tego obiektu
//Należy bardzo uważać z EAGER, ponieważ możemy przez przypadek spowodowac pobranie całej bazy danych w jednym zapytaniu. W przypadku LAZY, pobieranie ‘na żądanie’ zadziała tylko, jeżeli jesteśmy w ramach transakcji (