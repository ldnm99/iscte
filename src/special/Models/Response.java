package special.Models;

import java.util.Hashtable;
import java.util.List;

public class Response {

    private List<Lecture> lectures;
    private Hashtable<String, Double>  metrics;
    private String        best_metric;
    
    public Response(List<Lecture> lectures, Hashtable<String, Double> resultList, String best_metric) {
        this.lectures = lectures;
        this.metrics = resultList;
        this.best_metric = best_metric;
    }


    public List<Lecture> getLectures() {
        return lectures;
    }

    public Hashtable<String, Double> getMetrics() {
        return metrics;
    }

    public String getBest_metric() {
        return best_metric;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public void setMetrics(Hashtable<String, Double> metrics) {
        this.metrics = metrics;
    }

    public void setBest_metric(String best_metric) {
        this.best_metric = best_metric;
    }

    @Override    
    public String toString() {    
        // TODO Auto-generated method stub    
        return "\"Response [Lecture List "+ this.lectures + ", Metric results = " + this.metrics + ", Best Metric to use = " + this.best_metric + "]";    
    }  
}
