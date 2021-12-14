package special.Metrics;

import java.util.*;

import special.Metric;
import special.Models.Lecture;

public class ClassCapacityOver extends Metric{

    public ClassCapacityOver(){
        super("ClassCapacityOver");
    }

    public int evaluate(List<Lecture> LectList){
        int score = 0;
        for(Lecture lect : LectList){
            if(lect.getRoom() != null){
                if(lect.getN_students() <= lect.getRoom().getNormal_capacity()){
                    score++;
                }
            }
        }

        return score;
    }
    
    
}
