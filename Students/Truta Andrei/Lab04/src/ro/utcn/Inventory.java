package ro.utcn;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> productList = new ArrayList<Product>();
    private List<Integer> productQuantity = new ArrayList<Integer>();

//    private static Inventory instance = null;
//
//    private Inventory() {}
//
//    static public Inventory getInstance() {
//        if (instance == null) {
//            instance = new Inventory();
//        }
//        return instance;
//    }

    void addProduct(Product product, Integer quantity) {
        if (productList.indexOf(product) == -1) {
            productList.add(product);
            productQuantity.add(quantity);
        } else {
            productQuantity.set(productList.indexOf(product), productQuantity.get(productList.indexOf(product)) + quantity);
        }
    }

    void removeProduct(Product product, Integer quantity) {
        if (productList.indexOf(product) == -1) {
            System.out.println("Product not found");
        } else {
            if (productQuantity.get(productList.indexOf(product)) < quantity) {
                System.out.println("Not enough products");
            } else {
                productQuantity.set(productList.indexOf(product), productQuantity.get(productList.indexOf(product)) - quantity);
            }
        }
    }

    void getDetails() {
        System.out.println("Products: ");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productQuantity.get(i) + " " + productList.get(i).getName() + " : " + productList.get(i).getDescription());
        }
    }

//    void createProduct(String name, String description, double price) {
//        Product newProduct = new Product(productList.size(), name, description, price);
//        productList.add(newProduct);
//        productQuantity.add(0);
//    }
//
//    void updateProduct(String name, Integer quantity) {
//        for (int i = 0; i < productList.size(); i++) {
//            if (productList.get(i).getName().equals(name)) {
//                productQuantity.set(i, quantity);
//            }
//        }
//    }
//    void updateProduct(String name, Integer quantity, String description, double price) {
//        for (int i = 0; i < productList.size(); i++) {
//            if (productList.get(i).getName().equals(name)) {
//                productQuantity.set(i, quantity);
//                productList.get(i).updateDescription(description);
//                productList.get(i).updatePrice(price);
//            }
//        }
//    }
//
//    void updateProduct(Integer id, Integer quantity) {
//        for (int i = 0; i < productList.size(); i++) {
//            if (productList.get(i).getId().equals(id)) {
//                productQuantity.set(i, quantity);
//            }
//        }
//    }


}
