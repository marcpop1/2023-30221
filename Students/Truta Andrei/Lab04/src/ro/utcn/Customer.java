package ro.utcn;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Integer id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private List<Order> placedOrders = new ArrayList<Order>();

    public Customer(Integer id, String name, String address, String email, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public void getDetails() {
        System.out.println("Customer: " + name);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Id: " + id);
        System.out.println("Orders: ");
        for (int i = 0; i < placedOrders.size(); i++) {
            placedOrders.get(i).getDetails();
            System.out.println();;

        }
    }

    public void updateName(String newName) {
        name = newName;
    }
    public void updateAddress(String newAddress) {
        address = newAddress;
    }
    public void updateEmail(String newEmail) {
        email = newEmail;
    }
    public void updatePhone(String newPhone) {
        phone = newPhone;
    }
    public void addOrder(Order newOrder) {
        newOrder.setClientId(this.id);
        placedOrders.add(newOrder);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<Order> getPlacedOrders() {
        return placedOrders;
    }


}
