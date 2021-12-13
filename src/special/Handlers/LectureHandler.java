package special.Handlers;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import special.Models.Date;
import special.Models.Lecture;
import special.Models.Room;
import special.Models.Times;

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

	//Check if the room is available for allocation
	private static boolean getAvailability(Room r, Date d, Times t, TreeMap<Date, EnumMap<Times, HashSet<Room>>> classRoomAvailabilityMap){
		return !classRoomAvailabilityMap.get(d).get(t).contains(r);
	}

	private static boolean verifyFeatures(Room r, Lecture l){
		//Verifies if its possible for all students to come to class
		boolean capacities = r.getNormal_capacity() < l.getN_students();
		//Verifies if the room has the characteristic that the lecture requires
		boolean characteristic = r.getCharacteristicsString().contains(l.getRequired_room_characteristics());
		
		return capacities && characteristic;
	}
	
	public static final Lecture setRoom(Lecture l, List<Room> rooms, TreeMap<Date, EnumMap<Times, HashSet<Room>>> classRoomAvailabilityMap){
		Date date = l.getDate();
		Times t = l.getStart();
		for( Room r: rooms){
			if(getAvailability(r,date,t,classRoomAvailabilityMap) &&
					verifyFeatures(r, l)
			){
				l.setRoom(r);
			}
		}
		return l;
	}




}
