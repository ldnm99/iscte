package special.Loaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import special.Models.Room;

public class RoomLoader {

    public static final LinkedList<Room> readRoomFile(final String filepath) {
        
        final LinkedList<Room> rooms = new LinkedList<>();
        try {
            FileInputStream file = new FileInputStream(filepath);
            Scanner scanner = new Scanner(file, "UTF-8");

            /*
            final Reader reader = Files.newBufferedReader(Paths.get(filepath));
            final CSVReader csvReader = new CSVReader(reader)

            csvReader.readNext();
            String[] tokens;
            while ((tokens = csvReader.readNext()) != null) {
                rooms.add(creationRooms(tokens));
            }
            */

            //skips the headers
            scanner.nextLine();
            
            String[] tokens;

            while (scanner.hasNext() ){ 

                String data = scanner.nextLine(); 
                tokens = data.split(";");
                rooms.add(creationRooms(tokens));
            }   
            scanner.close();  //closes the scanner
        } catch (IOException   e) {
            e.printStackTrace();
        }
        return rooms;
    }
    
    private static Room creationRooms(String[] tokens){
        //Checks which characteristics the room has
        LinkedList<Boolean> characteristics = new LinkedList<>();
		for (int index = 5; index < tokens.length; index++) {
			if (tokens[index].equals("X") || tokens[index].equals("x")) {
				characteristics.add(true);
			} else {
				characteristics.add(false);
			}
		}
        Room r = new Room(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), characteristics);
        return r;
    } 
}