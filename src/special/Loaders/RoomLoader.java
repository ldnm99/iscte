package special.Loaders;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

import com.opencsv.CSVReader;

import special.Models.Room;

public class RoomLoader {

    public static final LinkedList<Room> readRoomFile(final String filepath) {
        
        final LinkedList<Room> rooms = new LinkedList<>();
        try {

            final Reader reader = Files.newBufferedReader(Paths.get(filepath));
            final CSVReader csvReader = new CSVReader(reader);
            

            //skips headers
            csvReader.readNext();

            String[] tokens;

            while ((tokens = csvReader.readNext()) != null) {
                rooms.add(creationRooms(tokens));
            }

            csvReader.close();
            
        } catch (Exception   e) {
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
        Room r = new Room(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), characteristics);
        return r;
    } 
}