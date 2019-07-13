package roomrental.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import roomrental.domain.model.Client;
import roomrental.domain.model.Event;
import roomrental.domain.model.Room;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findAllByRoomNameContaining(String roomName);

}
