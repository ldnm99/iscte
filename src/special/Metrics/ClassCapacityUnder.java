package special.Metrics;

import java.util.*;

import special.Metric;
import special.Models.Lecture;

public class ClassCapacityUnder extends Metric {

    public ClassCapacityUnder(){
        super("ClassCapacityUnder");
    }

    public Double evaluate(List<Lecture> LectList){
        double score = 0;
        double count = 0;
        for(Lecture lect : LectList){
            if(!lect.getRoom_name().isEmpty()){
                if(lect.getN_students() >= (lect.getRoom_lotation() / 2)){
                    score++;
                }
            }
            count++;
        }

        return (score/count) * 100;
    }
    
    
}
