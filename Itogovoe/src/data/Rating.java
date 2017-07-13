package data;


public class Rating {
  
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" + "rating=" + rating + '}';
    }
    
    
}
