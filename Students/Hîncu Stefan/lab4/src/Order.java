import java.util.ArrayList;

public class Order {
    private String ID;
    private Customer customer;
    ArrayList<Product> productList = new ArrayList<Product>();

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public int getOrderAmount(){
       return productList.size();
    }

    public void displayOrder() {
        System.out.println(this.getID());
        System.out.println(this.customer.getName());
        for (Product product : productList) {
            System.out.print(product.getName() + " ");
        }
    }
}
