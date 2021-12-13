package special;


import java.util.List;

import special.Algorithms.SimpleAlg;
import special.Loaders.LectureLoader;
import special.Loaders.RoomLoader;
import special.Models.Lecture;
import special.Models.Room;

class Worker{
    private static final String filename1 = "C:\\Users\\loure\\Cliente_Especial\\iscte-1\\src\\Local_Files\\ADS - Caracterizacao das salas.csv";
    private static final String filename2 = "C:\\Users\\loure\\Cliente_Especial\\iscte-1\\src\\Local_Files\\ADS - Exemplo de horario do 1o Semestre.csv";

    public Worker(){
        List<Room> rooms = RoomLoader.readRoomFile(filename1);
        List<Lecture> lectures = LectureLoader.readLecturePath(filename2);
        // File reading if fully operational   
        //System.out.println(rooms);
        //System.out.println(lectures);
    

        SimpleAlg sa = new SimpleAlg();
        sa.compute(lectures, rooms);
        
        // Should have the rooms allocated to each lecture instance
        
        
    }
    

    public static void main(String[] args) {
       new Worker();
    }
}