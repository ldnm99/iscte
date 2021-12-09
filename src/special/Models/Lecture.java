package special.Models;

import java.util.LinkedList;

public class Lecture {

	private final LinkedList<String> course;
	private final String name;
	private final String shift;
	private final String class_name;
	private final int n_students;
	private final boolean Free_Spots;
    private final boolean Capacity_Overflow;
	private final String week_day;
	private final Times start;
	private final Times end;
	private final Date date;
	private final String required_room_characteristics;
	private final int capacity;
	private final String real_characteristics;
    private Room room;

	public Lecture(LinkedList<String> course, String name, String shift, String class_name, int n_students, boolean Free_Spots, boolean Capacity_Overflow,
	String week_day, Times start, Times end, Date date2, String required_room_characteristics, int capacity, String real_characteristics) {
		this.course = course;
		this.name = name;
		this.shift = shift;
		this.class_name = class_name;
		this.n_students = n_students;
		this.Free_Spots = Free_Spots;
		this.Capacity_Overflow = Capacity_Overflow;
		this.week_day = week_day;
		this.start = start;
		this.end = end;
		this.date = date2;
		this.required_room_characteristics = required_room_characteristics;
		this.capacity = capacity;
		this.real_characteristics = real_characteristics;
	}

	public LinkedList<String> getCourse() {
		return course;
	}

	public String getName() {
		return name;
	}

	public String getShift() {
		return shift;
	}

	public String getClass_name() {
		return class_name;
	}

	public int getN_students() {
		return n_students;
	}

	public boolean getFree_Spots() {
		return Free_Spots;
	}

	public boolean getCapacity_Overflow() {
		return Capacity_Overflow;
	}

	public String getWeek_day() {
		return week_day;
	}

	public Times getStart() {
		return start;
	}

	public Times getEnd() {
		return end;
	}

	public Date getDate() {
		return date;
	}

	public String getRequired_room_characteristics() {
		return required_room_characteristics;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getReal_characteristics() {
		return real_characteristics;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}