package special.Metrics;

import java.util.*;

import special.Metric;
import special.Models.Lecture;

public class RoomAllocationChars extends Metric{

    public RoomAllocationChars(){
        super("RoomAllocationChars");
    }
    
    public Double evaluate(List<Lecture> LectList){
        double score = 0;
        double count = 0;
        for(Lecture lect : LectList){
            String caracter = lect.getRequired_room_characteristics();
            if(!caracter.isEmpty()){
                if(lect.getRoom_characteristics().contains(caracter))
                    score++; 
            }
            count++;
        }
        return (score/count) * 100;
    }
}
