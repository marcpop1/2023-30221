package ro.utcn;

import java.util.*;
//TODO: Pair<Product, Integer> instead of two lists
//import javafx.util.Pair;

public class Order {
    private Integer id;
    private Integer clientId = -1;
    List<Product> productList = new ArrayList<Product>();
    List<Integer> productQuantity = new ArrayList<Integer>();

    public Order(Integer id) {
        this.id = id;
    }

    public void addProduct(Product product, Integer quantity) {
        if (productList.indexOf(product) == -1) {
            productList.add(product);
            productQuantity.add(quantity);
        } else {
            productQuantity.set(productList.indexOf(product), productQuantity.get(productList.indexOf(product)) + quantity);
        }
    }

    //TODO: Can't access Inventory unless static but a singleton inventory seems a bit limiting, what if
    //TODO: I want to have multiple stores?
//    public void addProduct(String name, Integer quantity) {
//        for (int i = 0; i < Inventory.getProductList().size(); i++) {
//            if (Inventory.productList.get(i).getName().equals(name)) {
//                if (productList.indexOf(Inventory.productList.get(i)) == -1) {
//                    productList.add(Inventory.productList.get(i));
//                    productQuantity.add(quantity);
//                } else {
//                    productQuantity.set(productList.indexOf(Inventory.productList.get(i)), productQuantity.get(productList.indexOf(Inventory.productList.get(i))) + quantity);
//                }
//            }
//        }
//    }

    public void getDetails() {
        System.out.println("Order id: " + id);
        System.out.println("Client id: " + clientId);
        System.out.println("Products: ");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).getName() + " " + productQuantity.get(i));
        }
    }

    public void setClientId(Integer clientId) {
        this.clientId = id;
    }

    public void getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < productList.size(); i++) {
            totalPrice += productList.get(i).getPrice() * productQuantity.get(i);
        }
        System.out.println("Total price: " + totalPrice);
    }

}
