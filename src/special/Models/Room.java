package special.Models;

import java.util.LinkedList;

public class Room {

	public static final int NUMBER_OF_CHARACTERISTICS = 30;
    public static final String[] CHARACTERISTICS_LIST = new String[]{"Anfiteatro aulas", "Apoio técnico eventos", "Arq 1", "Arq 2", "Arq 3", "Arq 4", "Arq 5", "Arq 6", "Arq 9", 
	"BYOD (Bring Your Own Device)", "Focus Group", "Horário sala visível portal público", "Laboratório de Arquitectura de Computadores I", 
	"Laboratório de Arquitectura de Computadores II", "Laboratório de Bases de Engenharia", "Laboratório de Electrónica", "Laboratório de Informática", 
	"Laboratório de Jornalismo", "Laboratório de Redes de Computadores I", "Laboratório de Redes de Computadores II", "Laboratório de Telecomunicações", "Sala Aulas Mestrado",
	 "Sala Aulas Mestrado Plus", "Sala NEE", "Sala Provas", "Sala Reunião", "Sala de Arquitectura", "Sala de Aulas normal", "videoconferencia", "Átrio"};

	private final String building;
	private final String name;
	private final int normal_capacity;
	private final int exam_capacity;
	private final LinkedList<Boolean> characteristics;

	public Room(String building, String name, int normal_capacity, int exam_capacity, LinkedList<Boolean> characteristics) { //List<String> characteristics) {
		this.building = building;
		this.name = name;
		this.normal_capacity = normal_capacity;
		this.exam_capacity = exam_capacity;
		this.characteristics = characteristics;
	}

	public String getBuilding() {
		return building;
	}

	public String getName() {
		return name;
	}

	public int getNormal_capacity() {
		return normal_capacity;
	}


	public int getExam_capacity() {
		return exam_capacity;
	}

	public LinkedList<Boolean> getCharacteristics() {
		return characteristics;
	}


	//Check if input of variables is the correct one
	public final boolean hasCharacteristic(final String characteristic) throws IllegalArgumentException {
        for (int i = 0; i < Room.CHARACTERISTICS_LIST.length; i++) {
            if (Room.CHARACTERISTICS_LIST[i].equals(characteristic)) {
                return this.characteristics.get(i);
            }
        }
        return false;
        //throw new IllegalArgumentException();
    }


}