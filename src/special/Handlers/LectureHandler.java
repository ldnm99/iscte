package special.Handlers;

import java.util.LinkedList;
import java.util.List;

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
}
