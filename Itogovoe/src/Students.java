
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class Students {
    private int id;
    private String name;
    private String degree;
    private Date dateOfBirth;
    private ArrayList <Integer> rating;
    private boolean visible;

    public ArrayList<Integer> getRatingList() {
        return rating;
    }

    public void setRatingList(ArrayList<Integer> ratingList) {
        this.rating = ratingList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Students other = (Students) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Students{" + "id=" + id + ", name=" + name + ", degree=" + degree + ", dateOfBirth=" + dateOfBirth + ", ratingList=" + rating + ", visible=" + visible + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

  

   
}
