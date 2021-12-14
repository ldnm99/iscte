package special.Metrics;

import java.util.*;

import special.Metric;
import special.Models.Lecture;

public class ClassCapacityUnder extends Metric {

    public ClassCapacityUnder(){
        super("ClassCapacityUnder");
    }

    public int evaluate(List<Lecture> LectList){
        int score = 0;
        for(Lecture lect : LectList){
            if(lect.getRoom() != null){
                if(lect.getN_students() >= (lect.getRoom().getNormal_capacity() / 2)){
                    score++;
                }
            }
        }

        return score;
    }
    
    
}
