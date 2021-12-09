package special;


import java.util.List;

import special.Loaders.LectureLoader;
import special.Loaders.RoomLoader;
import special.Models.Lecture;
import special.Models.Room;

class Worker{
    private static final String filename1 = "C:\\Users\\loure\\Cliente_Especial\\ADS_ClienteEspecial\\ClienteEspecial\\src\\special\\ADS _Caracterizacao_das_salas.csv";
    private static final String filename2 = "C:\\Users\\loure\\Cliente_Especial\\ADS_ClienteEspecial\\ClienteEspecial\\src\\special\\ADS_Exemplo_de_horario_do_1oSemestre.csv";

    public Worker(){
        List<Room> rooms = RoomLoader.readRoomFile(filename1);
        List<Lecture> lectures = LectureLoader.readLectureFile(filename2);
        System.out.println(rooms);
        System.out.println(lectures);
    }
    

    public static void main(String[] args) {
       new Worker();
    }
}