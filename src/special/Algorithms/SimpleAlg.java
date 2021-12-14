package special.Algorithms;

import java.util.*;

import special.Models.Lecture;
import special.Models.Room;

// Simple Algorithm that allocates rooms to lectures according to their order only
public class SimpleAlg {
    
    public void compute(List<Lecture> lectures, List<Room> rooms){
        int count = 0;
        for(Lecture l : lectures){
            Room r = rooms.get(count);
            l.setRoom(r);
            l.setCapacity(r.getNormal_capacity());
            l.setReal_characteristics(r.getCharacteristicsString());
            if(count == rooms.size()-1){
                count = 0;
            }else
                count++;
        }
    }
}
