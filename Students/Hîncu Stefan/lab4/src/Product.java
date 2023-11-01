import java.util.ArrayList;

public class Product {
    private String ID;
    private String name;
    private String description;
    private double price;
    private int quantityInStock;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantityInStock;
    }

    public void setQuantity(int quantity) {
        this.quantityInStock = quantity;
    }

    public void displayProduct() {
        System.out.println(this.getID());
        System.out.println(this.getName());
        System.out.println(this.getDescription());
        System.out.println(this.getPrice());
        System.out.println(this.getQuantity());
    }

    public void addToInventory(ArrayList<Product> inventory, Product product) {
        if(product.quantityInStock>0){
            inventory.add(product);
            product.quantityInStock--;
        }
        else
            System.out.println("There is no more " + product.name);
    }
}
