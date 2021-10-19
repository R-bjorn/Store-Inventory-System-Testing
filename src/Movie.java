import java.time.LocalDate;

public class Movie extends Item{
    String director;
    String producer;

    public Movie(String title, double regularPrice, LocalDate releaseDate, int quantity, String director, String producer){
        super(title, regularPrice, releaseDate, quantity);
        this.director = director;
        this.producer = producer;
    }
    public Movie(String title, double regularPrice, LocalDate releaseDate, int quantity, String director, String producer, int itemID){
        super(title, regularPrice, releaseDate, quantity, itemID);
        this.director = director;
        this.producer = producer;
    }

    // Methods
    public String getDirector() {
        return this.director;
    }
    public String getProducer() {
        return this.producer;
    }
    public String toString(){
        return super.toString() + "\tDirector: " + director + "\n\tProducer: " +producer;
    }

    //    Copy Function

    @Override
    public Item makeCopy() {
        Movie copy = new Movie(this.getTitle(),this.getRegularPrice(),this.getReleaseDate(), this.getQuantity(),this.getDirector(), this.getProducer(), this.getItemID());
        return copy;
    }
}
