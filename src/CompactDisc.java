import java.time.LocalDate;

public class CompactDisc extends Item{
    String bandName;
    String recordLabel;

    public CompactDisc(String title, double regularPrice, LocalDate releaseDate, int quantity, String bandName, String recordLabel){
        super(title, regularPrice, releaseDate, quantity);
        this.bandName = bandName;
        this.recordLabel = recordLabel;
    }
    public CompactDisc(String title, double regularPrice, LocalDate releaseDate, int quantity, String bandName){
        this(title,regularPrice,releaseDate,quantity,bandName,"Indie");
    }
    //    3rd constructor
    public CompactDisc(String title, double regularPrice, LocalDate releaseDate, int quantity, String bandName, String recordLabel, int itemID){
        super(title, regularPrice, releaseDate, quantity, itemID);
        this.bandName = bandName;
        this.recordLabel = recordLabel;
    }


    public String toString(){
        return super.toString() + "\tBand: " + bandName + "\n\tRecord Label: " + recordLabel;
    }

    // Make a copy function
    @Override
    public Item makeCopy() {
        CompactDisc copy = new CompactDisc(this.getTitle(),this.getRegularPrice(),this.getReleaseDate(), this.getQuantity(),this.bandName, this.recordLabel, this.getItemID());
        return copy;
    }
}
