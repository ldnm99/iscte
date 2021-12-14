package special;

import java.util.List;

import special.Models.Lecture;

public class Metric {
    final String name;

    public Metric(String name){
        this.name = name;

    }

    public Double evaluate(List<Lecture> lectList) {
        return 0.0;
    }


}
