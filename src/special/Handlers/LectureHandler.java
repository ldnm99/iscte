package special.Handlers;

import java.util.LinkedList;
import java.util.List;

import special.Models.Lecture;
import special.Models.Room;

public class LectureHandler {

    public static final List<Room> getWithCharacteristics(List<Room> rooms, String characteristics){
        final LinkedList<Room> output = new LinkedList<>();
		for (Room r :rooms){
			if (r.has_Characteristic(characteristics)){
				output.add(r);
			}
		}
		return output;
	}

	private static boolean verifyFeatures(Room r, Lecture l){
		//Verifies if its possible for all students to come to class
		boolean capacities = r.getNormal_capacity() < l.getN_students();
		//Verifies if the room has the characteristic that the lecture requires
		boolean characteristic = r.getCharacteristicsString().contains(l.getRequired_room_characteristics());
		return capacities && characteristic;
	}
}
