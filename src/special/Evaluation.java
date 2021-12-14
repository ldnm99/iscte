package special;

import java.util.*;

import special.Models.Lecture;

public class Evaluation {

    public void Decider(List<Lecture> LectList, List<Metric> MetricList){
        List<Integer> resultList = new ArrayList<Integer>();
        for(Metric metric : MetricList){
            int score = metric.evaluate(LectList);
            resultList.add(score);
        }
        
        int highestScorePos = resultList.indexOf(Collections.max(resultList));
        System.out.println("The scores were: " + resultList);
        System.out.println("The best metric was: " + MetricList.get(highestScorePos).name);

    }

    
}