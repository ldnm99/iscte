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

        for(Map.Entry<Date, EnumMap<Times, HashSet<Lecture>>> lecture_day: LectureDateMap.entrySet()){
            Date day = lecture_day.getKey();
            //System.out.println(day + " -> " + lecture_day.getValue().size());

            for(Map.Entry<Times, HashSet<Lecture>> lecture_dayOfTime : lecture_day.getValue().entrySet()){
                Times currHour = lecture_dayOfTime.getKey();

                //System.out.println(currHour + " -> " + lecture_dayOfTime.getValue().size());
                for(Lecture l : lecture_dayOfTime.getValue() ){
                    //System.out.println(classCourse.getAskedCharacteristics());

                    //List<Classroom> suitableClassRooms = ClassroomService.getWithCapacity(classrooms,classCourse.getCapacity());
                    List<Room> suitableClassRooms = LectureHandler.getWithCharacteristics(rooms,l.getRequired_room_characteristics());

                    for(Room r:suitableClassRooms){
                        if(checkClassRoomAvailability(r, day,currHour,classRoomAvailabilityMap)){
                            classRoomAvailabilityMap.get(day).get(currHour).add(r);
                            l.setRoom(r);
                            System.out.println(l.getName() + " Has the follwing room: " + r.getName());
                            break;
                        }
                    }
                }
            }
        }
    }

    private TreeMap<Date, EnumMap<Times, HashSet<Lecture>>> initLectureDateMap(List<Lecture> lectures) {
        TreeMap<Date, EnumMap<Times, HashSet<Lecture>>> LectureDateMap = new TreeMap<>();
        for(Lecture l: lectures)
        {
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
                System.out.println();
                classRoomDateMap.computeIfAbsent(date.getKey(), k ->new EnumMap<Times, HashSet<Room>>(Times.class));
                classRoomDateMap.get(date.getKey()).computeIfAbsent(hour.getKey(), k-> new HashSet<Room>());
            }
        }
        return classRoomDateMap;
    }

    private boolean checkClassRoomAvailability(Room classRoom, Date d, Times t, TreeMap<Date, EnumMap<Times, HashSet<Room>>> classRoomAvailabilityMap){
        return !classRoomAvailabilityMap.get(d).get(t).contains(classRoom);
    }



}
