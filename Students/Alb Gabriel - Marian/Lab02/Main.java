import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    int a=0;
    int b=0;
    void doSomething(){
        a=1;
        b=2;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the name, age and salary:");
        String name = obj.nextLine();
        int age = obj.nextInt();
        double salary = obj.nextDouble();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);

        for(int i=0; i<args.length; i++){
            System.out.println(args[i]);
        }
        System.out.println("Hello World!");
    }
}