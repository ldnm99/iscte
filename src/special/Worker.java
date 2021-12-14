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
import special.Models.Room;

class Worker{
    private static final String filename1 = "C:\\Users\\loure\\Cliente_Especial\\iscte-1\\src\\Local_Files\\ADS - Caracterizacao das salas.csv";
    private static final String filename2 = "C:\\Users\\loure\\Cliente_Especial\\iscte-1\\src\\Local_Files\\ADS - Exemplo de horario do 1o Semestre.csv";

    public Worker(){
        List<Room> rooms = RoomLoader.readRoomFile(filename1);
        List<Lecture> lectures = LectureLoader.readLecturePath(filename2);

        // Basic Alghoritm that acts as a FIFO
        SimpleAlg sa = new SimpleAlg();
        List<Lecture> Simple_lectures = new ArrayList<Lecture>();
        Simple_lectures.addAll(lectures);
        sa.compute(Simple_lectures, rooms);
        for(Room r : rooms){
            r.clearLecture();
        }

        // Middle Algorithm that acts based on capacity and required characteristic
        MiddleAlg ma = new MiddleAlg();
        List<Lecture> Middle_lectures = new ArrayList<Lecture>();
        Middle_lectures.addAll(lectures);
        ma.compute(Middle_lectures, rooms);
        for(Room r : rooms){
            r.clearLecture();
        }

        // Ideal Alghoritm that allocates room according to their capacity/characteristic/availabity
        IdealAlg ia = new IdealAlg();
        List<Lecture> Ideal_lectures = new ArrayList<Lecture>();
        Ideal_lectures.addAll(lectures);
        ia.compute(Ideal_lectures, rooms);

        /*
        //check if there are no conflitcs in the schedules
        for(Room r : rooms){
            System.out.println("Room: " + r.getName());
            for(Interval i : r.getLectures_times_booked()){
                System.out.println("Lecture: " + i.getStart() +" Ends at: "+ i.getEnd());
            }
        }
        
        
        for(Room r : rooms){
            r.clearLecture();
        }*/

        //Evaluation of metrics
        ClassCapacityOver metric1 = new ClassCapacityOver();
        ClassCapacityUnder metric2 = new ClassCapacityUnder();
        RoomAllocationChars metric3 = new RoomAllocationChars();

        List<Metric> MetricList = new ArrayList<Metric>();
        MetricList.add(metric1);
        MetricList.add(metric2);
        MetricList.add(metric3);
        
        Evaluation ev = new Evaluation();
        ev.Decider(Simple_lectures, MetricList);
        
        // Should have the rooms allocated to each lecture instance        
    }
    

    public static void main(String[] args) {
       new Worker();
    }
}