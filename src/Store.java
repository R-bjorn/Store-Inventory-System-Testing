import java.time.LocalDate;
import java.util.ArrayList;

public class Store {
    ArrayList<Item> inventory;
    private double totalSalesValue = 0.0;
    private int totalNumberOfSales = 0;

    // Constructor
    Store(){
        inventory = new ArrayList<Item>();
    }

    // Methods
    public void addItem(Item newItem){
        if(newItem == null)
            return;
        inventory.add(newItem);
    }

    public boolean makeSale(int itemId, int quantity, LocalDate sellDate){
        Item item = getItemByID(itemId);
        if(item == null){
//            System.out.println("====================ITEM DOES NOT EXIST=================");
            return false;
        }
        if(inventory.isEmpty() || getItemByID(itemId) == null){
            return false;
        }
        if(quantity > item.getQuantity()){
//            System.out.println("-----------------Quality is too much____________________");
            return false;
        }
//        System.out.println("___________________Consideration--------------------");
        double value = item.sell(quantity, sellDate);
//        System.out.println("Value : " + value);

        if(value > 0){
            totalNumberOfSales++;
            totalSalesValue += value;
//            System.out.println("-----------------SOLD____________________________");
            return true;
        }
//        System.out.println("-----------------Value is 0, Can't Sell the item____________________");
        return false;
    }

    private String getInventoryString(){
        String inventoryString = "";
        for(Item item : inventory){
            inventoryString += "\n" + item.toString() + "\n";
        }
        return inventoryString;
    }

    public void listInventory(){
        System.out.println("Here are all the inventory items:");
        System.out.println(getInventoryString());
    }

    public Item checkForItem(int itemId){
        for(Item e : inventory){
            if (e.getItemID() == itemId){
                return e.makeCopy();
            }
        }
        return null;
    }

    public Item getItemByID(int itemId){
        for(Item e : inventory){
            // Item's properties can be modified by store class
            // because we are returning the real copy of the item (original memory address)
            if (e.getItemID() == itemId){

                return e;
            }
        }
        return null;
    }

    public Double getTotalSalesValue(){
        return totalSalesValue;
    }

    public int getTotalNumberOfSales(){
        return totalNumberOfSales;
    }

    public String toString(){
        return "Store total sales value: " + totalSalesValue + "\nStore total number of sales: " + totalNumberOfSales + "\nStore current inventory:" + getInventoryString();
    }
}
