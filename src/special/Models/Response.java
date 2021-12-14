package special.Models;

import java.util.List;

import special.Metric;

public class Response {

    private List<Lecture> lectures;
    private List<Metric>  metrics;
    private String        best_metric;
    
    public Response(List<Lecture> lectures, List<Metric> metrics, String best_metric) {
        this.lectures = lectures;
        this.metrics = metrics;
        this.best_metric = best_metric;
    }


    public List<Lecture> getLectures() {
        return lectures;
    }

    public List<Metric> getMetrics() {
        return metrics;
    }

    public String getBest_metric() {
        return best_metric;
    }
}
