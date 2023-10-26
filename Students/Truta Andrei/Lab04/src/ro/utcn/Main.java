package ro.utcn;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        //TODO: Would a singleton type Inventory be ok?
        //TODO: Could implement auto increment id if I go with inventory.createProduct but then with no reference to the
//      //TODO: products outside Inventory I cannot check if the product exists in the order class
//      //TODO: See the Order class please
//        inventory.createProduct("Banana", "5 banana bundle", 4);
//        inventory.createProduct("Apple", "1 red apple", 2);
//        inventory.createProduct("Orange", "1 fresh orange", 3);
//        inventory.createProduct("Pineapple", "1 big pineapple", 7);
//        inventory.updateProduct("Banana", 10);
//        inventory.updateProduct("Apple", 5);
//        inventory.updateProduct("Orange", 3);
//        inventory.updateProduct("Pineapple", 2, "1 small pineapple", 6);
        Product apple = new Product(1, "Appe", "1 red apple", 2);
        Product grapes = new Product(2, "Grapes", "3 grapes bundle", 10);
        apple.updateName("Apple");
        inventory.addProduct(grapes, 9);
        inventory.addProduct(apple, 5);
        inventory.removeProduct(apple, 1);
        inventory.getDetails();
        System.out.println();

        Customer customer1 = new Customer(1, "John Doe", "Bucharest", "jd@gmail.com", "0723456789");
        Customer customer2 = new Customer(2, "Jane Doe", "Braila", "jed@gmail.com", "0721156766");

        customer1.getDetails();
        System.out.println();

        Order order1 = new Order(1);
        order1.addProduct(grapes, 2);
        order1.getDetails();
        System.out.println();

        customer2.addOrder(order1);
        customer2.getDetails();
    }
}