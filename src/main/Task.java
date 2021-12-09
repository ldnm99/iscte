package special;

import java.io.File;

class Task {

    private int id;
    private File rooms_file;
    private File lectures_file;

    public Task(int id, File rooms_file, File lectures_file){
        this.id = id;
        this.rooms_file = rooms_file;
        this.lectures_file = lectures_file;
    }
    
    public int getid(){
        return this.id;
    }

    public File getrooms_file(){
        return rooms_file;
    }
    
    public File getlectures_file(){
        return lectures_file;
    }
}