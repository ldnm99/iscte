package special.Loaders;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;

import com.opencsv.CSVReader;

import org.joda.time.DateTime;
import special.Models.Lecture;

public class LectureLoader {

    public static final LinkedList<Lecture> readLecturePath(final String filepath){

        LinkedList<Lecture> lectures = new LinkedList<>();

        try {
            final Reader reader = Files.newBufferedReader(Paths.get(filepath));
            final CSVReader csvReader = new CSVReader(reader);
            
            //saves the headers names for the correct allocation of values to variables
            String[] headers = csvReader.readNext(); 
            int[] order_headers = getOrder(headers);

            String[] tokens;
            
            while ((tokens = csvReader.readNext()) != null) {
                lectures.add(creationlectures(tokens,order_headers));
            }
            csvReader.close();
        } catch (Exception  e) {
            e.printStackTrace();
        }
        return lectures;
    }

    private static Lecture creationlectures(String[] tokens, int[] order_headers){

        // all variables in String form
        final String courseS = tokens[order_headers[0]];
        final String name = tokens[order_headers[1]];
        final String shift = tokens[order_headers[2]];
        final String class_name = tokens[order_headers[3]];
        final String n_studentsS = tokens[order_headers[4]];
        final String Free_SpotsS = tokens[order_headers[5]];
        final String Capacity_OverflowS = tokens[order_headers[6]];
        final String week_day = tokens[order_headers[7]];
        final String startS = tokens[order_headers[8]];
        final String endS = tokens[order_headers[9]];
        final String dateS = tokens[order_headers[10]];
        final String required_room_characteristics = tokens[order_headers[11]];

        // Converting to their correct form
        final LinkedList<String> course = new LinkedList<>(Arrays.asList(courseS.split(", ")));
        final int n_students = n_studentsS.isEmpty() ? -1 : Integer.parseInt(n_studentsS);

        boolean Free_Spots = true;
        if(Free_SpotsS.equals("FALSO")){
            Free_Spots = false;
        }

        boolean Capacity_Overflow = true;
        if(Capacity_OverflowS.equals("FALSO")){
           Capacity_Overflow = false;
        }
        
        if(!dateS.isEmpty() && !startS.isEmpty() && !endS.isEmpty()){
            String[] date  = dateS.split("/");
            String[] start = startS.split(":");
            String[] end   = endS.split(":");
            DateTime start_date = new DateTime(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]), Integer.parseInt(start[0]), Integer.parseInt(start[1]), Integer.parseInt(start[2]));
            DateTime end_date   = new DateTime(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]), Integer.parseInt(end[0]), Integer.parseInt(end[1]), Integer.parseInt(end[2]));
            Lecture lecture = new Lecture(course, name, shift, class_name, n_students, Free_Spots, Capacity_Overflow, week_day, start_date, end_date, required_room_characteristics);
            return lecture;
        }else if(dateS.isEmpty() && !startS.isEmpty() && !endS.isEmpty()){
            String[] start = startS.split(":");
            String[] end   = endS.split(":");
            DateTime start_date = new DateTime(0, 12, 31,Integer.parseInt(start[0]), Integer.parseInt(start[1]), Integer.parseInt(start[2]));
            DateTime end_date   = new DateTime(0, 12, 31,Integer.parseInt(end[0]), Integer.parseInt(end[1]), Integer.parseInt(end[2]));
            Lecture lecture = new Lecture(course, name, shift, class_name, n_students, Free_Spots, Capacity_Overflow, week_day, start_date, end_date, required_room_characteristics);
            return lecture;
        }else{
            Lecture lecture = new Lecture(course, name, shift, class_name, n_students, Free_Spots, Capacity_Overflow, week_day, null, null, required_room_characteristics);
            return lecture;
        }
    } 


    private static int[] getOrder(String[] headers){
        String[] order = Lecture.HEADERS;
        int[] indexes = new int[order.length];               
        int count1 = 0;
        for(String label : headers){
            int count2 = 0;
                for(String label2 : order){  
                    if(label2.equals(label)){
                        indexes[count1] = count2;
                        break;
                    }
                    count2++;
                }
            count1++;
        }
        return indexes;
    }

}
