import java.util.ArrayList;
public class Customer {
    String ID;
    String name;
    String contactInfo;
    ArrayList<Order> orderHistory;

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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void createOrder(){
        Order order = new Order();
        order.setCustomer(this);
    }
}
