


import java.util.ArrayList;


public class Root {
    private String name;
    private String location;
    private ArrayList<Students> students;

    @Override
    public String toString() {
        return "Root{" + "name=" + name + ", location=" + location + ", studList=" + students + '}';
    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Students> getStudList() {
        return students;
    }

    public void setStudList(ArrayList<Students> studList) {
        this.students = studList;
    }

    
    
    
}
