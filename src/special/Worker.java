package special;

import java.util.ArrayList;
import java.util.List;

import special.Algorithms.IdealAlg;
import special.Algorithms.MiddleAlg;
import special.Algorithms.SimpleAlg;
import special.Loaders.LectureLoader;
import special.Loaders.RoomLoader;
import special.Metrics.ClassCapacityOver;
import special.Metrics.ClassCapacityUnder;
import special.Metrics.RoomAllocationChars;
import special.Models.Lecture;
import special.Models.Response;
import special.Models.Room;

class Worker{
    private static final String filename1 = "src\\Local_Files\\ADS - Caracterizacao das salas.csv";
    private static final String filename2 = "src\\Local_Files\\ADS - Exemplo de horario do 1o Semestre.csv";

    public Worker(){
        List<Room> rooms = RoomLoader.readRoomFile(filename1);
        List<Lecture> lectures = LectureLoader.readLecturePath(filename2);

        // Metrics Initialization
        ClassCapacityOver metric1 = new ClassCapacityOver();
        ClassCapacityUnder metric2 = new ClassCapacityUnder();
        RoomAllocationChars metric3 = new RoomAllocationChars();

        List<Metric> MetricList = new ArrayList<Metric>();
        MetricList.add(metric1);
        MetricList.add(metric2);
        MetricList.add(metric3);

        // Response Initialization
        List<Response> output = new ArrayList<Response>();

        // Basic Alghoritm that acts as a FIFO
        SimpleAlg sa = new SimpleAlg();
        List<Lecture> Simple_lectures = new ArrayList<Lecture>();
        Simple_lectures.addAll(lectures);
        sa.compute(Simple_lectures, rooms);
        
        //Evaluation of metrics
        Evaluation simple_ev = new Evaluation(Simple_lectures, MetricList);
        // simple_ev.Decider(Simple_lectures, MetricList);

        Response out1 = new Response(Simple_lectures,simple_ev.resultList,simple_ev.bestResult);
        output.add(out1);

        for(Room r : rooms){
            r.clearLecture();
        }

        

        // Middle Algorithm that acts based on capacity and required characteristic
        MiddleAlg ma = new MiddleAlg();
        List<Lecture> Middle_lectures = new ArrayList<Lecture>();
        Middle_lectures.addAll(lectures);
        ma.compute(Middle_lectures, rooms);

        Evaluation middle_ev = new Evaluation(Middle_lectures, MetricList);
        Response out2 = new Response(Middle_lectures,middle_ev.resultList,middle_ev.bestResult);
        output.add(out2);

        for(Room r : rooms){
            r.clearLecture();
        }



        // Ideal Alghoritm that allocates room according to their capacity/characteristic/availabity
        IdealAlg ia = new IdealAlg();
        List<Lecture> Ideal_lectures = new ArrayList<Lecture>();
        Ideal_lectures.addAll(lectures);
        ia.compute(Ideal_lectures, rooms);

        Evaluation ideal_ev = new Evaluation(Ideal_lectures, MetricList);
        Response out3 = new Response(Ideal_lectures,ideal_ev.resultList,ideal_ev.bestResult);
        output.add(out3);

        for(Room r : rooms){
            r.clearLecture();
        } 
        
        ResponseToJSON transfer = new ResponseToJSON();
        transfer.ResToJSON(output);
    }
    

    public static void main(String[] args) {
       new Worker();
    }
}