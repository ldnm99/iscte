package special;

import java.util.*;

import special.Models.Lecture;

public class Evaluation {
    Hashtable<String, Double> resultList = new Hashtable<String, Double>();
    String bestResult = "";

    public List<Double> Decider(List<Lecture> LectList, List<Metric> MetricList){
        List<Double> resultList = new ArrayList<Double>();
        for(Metric metric : MetricList){
            double score = metric.evaluate(LectList);
            if(score > highestScore){
                highestScore = score;
                highestMetric = metric.name;
            }
            this.resultList.put(metric.name, score);
        }
        
        int highestScorePos = resultList.indexOf(Collections.max(resultList));
        System.out.println("The scores were: " + resultList);
        System.out.println("The best metric was: " + MetricList.get(highestScorePos).name);
        return resultList;
    }

    
}