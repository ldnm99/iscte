package special;


import java.util.List;

import special.Algorithms.SimpleAlg;
import special.Loaders.LectureLoader;
import special.Loaders.RoomLoader;
import special.Models.Lecture;
import special.Models.Room;

class Worker{
    private static final String filename1 = "C:\\Users\\loure\\Cliente_Especial\\iscte-1\\src\\Local_Files\\ADS _Caracterizacao_das_salas.csv";
    private static final String filename2 = "C:\\Users\\loure\\Cliente_Especial\\iscte-1\\src\\Local_Files\\ADS_Exemplo_de_horario_do_1oSemestre.csv";
    public Worker(){
        List<Room> rooms = RoomLoader.readRoomFile(filename1);
        List<Lecture> lectures = LectureLoader.readLectureFile(filename2);
        //System.out.println(rooms);
        System.out.println(lectures.get(0).getRoom());
        SimpleAlg sa = new SimpleAlg();
        sa.compute(lectures, rooms);
        // Should have the rooms allocated to each lecture instance
        System.out.println(lectures.get(0).getRoom());
    }
    

    public static void main(String[] args) {
       new Worker();
    }
}