import java.time.LocalDate;
import java.util.ArrayList;

public class Book extends Item {
    ArrayList<String> authors;

    // Constructors
    public Book(String title, double regularPrice, LocalDate releaseDate, int quantity, ArrayList<String> authors){
        super(title,regularPrice,releaseDate,quantity);
        this.authors = authors;
    }
    public Book(String title, double regularPrice, LocalDate releaseDate, int quantity, ArrayList<String> authors, int itemID){
        super(title, regularPrice, releaseDate, quantity, itemID);
        this.authors = authors;
    }

    // Methods
    public ArrayList<String> getAuthors(){
        ArrayList<String> copy = new ArrayList<String>();
        for(String s : authors) {
            copy.add(s);
        }
        return copy;
    }

    public String toString(){
        StringBuilder author = new StringBuilder();
        for(String s : authors) author.append("\n\t\t").append(s);
        return super.toString()  + "\tAuthors:" + author;
    }

    @Override
    public double getPrice(LocalDate sellDate) {
        return regularPrice - (regularPrice * super.getDiscount());
    }

    @Override
    public Item makeCopy() {
        Book copy = new Book(this.getTitle(),this.getRegularPrice(),this.getReleaseDate(), this.getQuantity(), this.authors, this.getItemID());
        return copy;
    }



}
