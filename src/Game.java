import java.time.LocalDate;

public class Game extends Item{
    String studio;
    boolean discontinued;

    public Game(String title, double regularPrice, LocalDate releaseDate, int quantity, String studio, boolean discontinued){
        super(title, regularPrice, releaseDate, quantity);
        this.studio = studio;
        this.discontinued = discontinued;
    }
    public Game(String title, double regularPrice, LocalDate releaseDate, int quantity, String studio, boolean discontinued, int itemID){
        super(title, regularPrice, releaseDate, quantity, itemID);
        this.studio = studio;
        this.discontinued = discontinued;
    }

    // Methods

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }
    public boolean isDiscontinued(){
        return discontinued;
    }
    public String getStudio() {
        return this.studio;
    }

    public String toString(){
        return super.toString() + "\tStudio: " + studio + "\n\tDiscontinued: " + discontinued;
    }

    @Override
    public double getPrice(LocalDate sellDate) {
        return (!discontinued) ? this.regularPrice: this.regularPrice*20;
    }

    //    Make a copy function
    public Game makeCopy() {
        Game copy = new Game(this.getTitle(), this.getRegularPrice(), this.getReleaseDate(), this.getQuantity(), this.getStudio(), this.isDiscontinued(), this.getItemID());
        return copy;
    }
}
