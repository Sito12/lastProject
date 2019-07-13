package roomrental.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomrental.domain.model.Client;
import roomrental.domain.model.Event;
import roomrental.domain.model.Room;
import roomrental.domain.repository.ClientRepository;
import roomrental.domain.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {

	private final RoomRepository roomRepository;

	public void createRoom(Room room) {
		roomRepository.save(room);
	}

	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

	public Optional<Room> getRoomById(Integer id) {
		return roomRepository.findById(id);
	}

	public void editRoom(Room room) {
		roomRepository.save(room);
	}

	public List<Room> findAllByRoomNameContaining(String roomName) {
		return roomRepository.findAllByRoomNameContaining(roomName);
	}

	public void deleteById(Integer id) {
		roomRepository.deleteById(id);
	}
}



