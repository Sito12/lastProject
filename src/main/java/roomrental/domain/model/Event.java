package roomrental.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// @GeneratedValue określa, że ​​dla tego pola zostanie automatycznie wygenerowana wartość. Jest to przede wszystkim przeznaczone dla pól klucza podstawowego,
	// ale ObjectDB obsługuje również tę adnotację również dla nieistotnych numerycznych pól trwałych.
	//W przeciwieństwie do AUTO i IDENTITY, strategia SEQUENCE generuje wartość automatyczną, gdy tylko nowy obiekt encji zostanie utrwalony (tj. Przed zatwierdzeniem). Może to być przydatne, gdy wartość klucza podstawowego jest potrzebna wcześniej.
	// Aby zminimalizować liczbę podróży do serwera bazy danych, identyfikatory są przydzielane w grupach.
	private Integer id;

	private String name;
	private LocalDate date;
	private Boolean isFreeEnter;
	private Integer howManyHours;

	@ManyToOne
	private Client client;
	private Room room;
}
