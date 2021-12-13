package special.Algorithms;

import java.util.List;

import special.Models.Lecture;
import special.Models.Room;

public class MiddleAlg {

    public void compute(List<Lecture> lectures, List<Room> rooms){
        for(Lecture l : lectures){
            for(Room r : rooms){
                boolean capacity = r.getNormal_capacity() >= l.getCapacity();
                boolean characteristic = r.getCharacteristicsString().contains(l.getRequired_room_characteristics());
                if(capacity && characteristic){
                    l.setRoom(r);
                    l.setCapacity(r.getNormal_capacity());
                    l.setReal_characteristics(r.getCharacteristicsString());
                }else 
                    continue;
            }
        }
    }
}
