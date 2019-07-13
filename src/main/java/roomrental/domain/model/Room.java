package roomrental.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class   Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue określa, że ​​dla tego pola zostanie automatycznie wygenerowana wartość. Jest to przede wszystkim przeznaczone dla pól klucza podstawowego,
	// ale ObjectDB obsługuje również tę adnotację również dla nieistotnych numerycznych pól trwałych.
	//Podczas zatwierdzania strategia AUTO używa globalnego generatora liczb do generowania klucza podstawowego dla każdego nowego obiektu encji.
	// Te wygenerowane wartości są unikalne na poziomie bazy danych i nigdy nie podlegają recyklingowi, jak wyjaśniono w poprzedniej sekcji.
	private Integer id;

	private String roomName;
	private Boolean isThereProjector;
	private Boolean isThereStage;
	private Boolean isThereAudio;
	private Integer price;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "room", cascade = CascadeType.ALL)
	private List<Event> Event;
}
