package special;

import java.util.ArrayList;
import java.util.List;

import special.Models.Lecture;

public class Metric {
    final String name;
    final List<Double> results = new ArrayList<Double>();

    public Metric(String name){
        this.name = name;


    }

    public Double evaluate(List<Lecture> lectList) {
        return 0.0;
    }


}
