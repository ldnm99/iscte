package special.Algorithms;

import java.util.List;

import org.joda.time.Interval;

import special.Handlers.LectureHandler;
import special.Models.Lecture;
import special.Models.Room;

// Algorithm that takes in account the capacity/characteristics/availability of the rooms

public class IdealAlg {
    public void compute(List<Lecture> lectures, List<Room> rooms){
        for(Lecture l : lectures){

            //filters rooms with required characteristic
            List<Room> characteristic_filtered_rooms = LectureHandler.getWithCharacteristics(rooms, l.getRequired_room_characteristics());

            //filters rooms with required capacity
            List<Room> capacity_filtered_rooms = LectureHandler.getWithHighCapacity(characteristic_filtered_rooms, l.getCapacity());

            //Time interval of the lecture (includes date)
            Interval interval = new Interval(l.getStart_date(),l.getEnd_date());
            roomloop:
            for(Room r : capacity_filtered_rooms){
                if(r.getLectures_times_booked().isEmpty()){
                        l.setRoom(r);
                        l.setCapacity(r.getNormal_capacity());
                        l.setReal_characteristics(r.getCharacteristicsString());
                        r.addLecture(interval);
                        break roomloop;
                }
                for(Interval i : r.getLectures_times_booked()){
                    // checks if the interval of the lecture overlaps with those already booked in the classrom
                    if( !i.overlaps(interval) ){
                        l.setRoom(r);
                        l.setCapacity(r.getNormal_capacity());
                        l.setReal_characteristics(r.getCharacteristicsString());
                        r.addLecture(interval);
                        break roomloop;
                    }
                }
            }
        }
    }
}
