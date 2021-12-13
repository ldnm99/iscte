package special.Algorithms;

import java.util.*;

import special.Models.Lecture;
import special.Models.Room;
import special.Models.Times;
import special.Handlers.LectureHandler;
import special.Models.Date;


public class SimpleAlg {
    
    public void compute(List<Lecture> lectures, List<Room> rooms) {

        TreeMap<Date, EnumMap<Times, HashSet<Lecture>>> LectureDateMap = initLectureDateMap(lectures);
        TreeMap<Date, EnumMap<Times, HashSet<Room>>> classRoomAvailabilityMap = initRoomDateMap(LectureDateMap);

        for( Lecture l : lectures){
            LectureHandler.setRoom(l, rooms ,classRoomAvailabilityMap);
        }
    }

    private TreeMap<Date, EnumMap<Times, HashSet<Lecture>>> initLectureDateMap(List<Lecture> lectures) {
        TreeMap<Date, EnumMap<Times, HashSet<Lecture>>> LectureDateMap = new TreeMap<>();
        for(Lecture l: lectures){
            LectureDateMap.computeIfAbsent(l.getDate(), k -> new EnumMap<Times, HashSet<Lecture>>(Times.class));
            LectureDateMap.get(l.getDate()).computeIfAbsent(l.getStart(), k -> new HashSet<Lecture>());
            LectureDateMap.get(l.getDate()).get(l.getStart()).add(l);
        }
        return LectureDateMap;
    }


    private TreeMap<Date, EnumMap<Times, HashSet<Room>>> initRoomDateMap(TreeMap<Date, EnumMap<Times, HashSet<Lecture>>> LectureDateMap) {
        TreeMap<Date, EnumMap<Times, HashSet<Room>>>classRoomDateMap = new TreeMap<>();
        for (Map.Entry<Date, EnumMap<Times, HashSet<Lecture>>> date : LectureDateMap.entrySet()) {
            for (Map.Entry<Times, HashSet<Lecture>> hour : date.getValue().entrySet()) {
                classRoomDateMap.computeIfAbsent(date.getKey(), k ->new EnumMap<Times, HashSet<Room>>(Times.class));
                classRoomDateMap.get(date.getKey()).computeIfAbsent(hour.getKey(), k-> new HashSet<Room>());
            }
        }
        return classRoomDateMap;
    }
}
