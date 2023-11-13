package utcn.ro;

public class Main {


    public static void main(String[] args) {

        int a = 0;
        Phone firstPhone = new Phone();
        firstPhone.imeiNumber = "123";

        Phone secondPhone = new Phone();
        secondPhone.imeiNumber = "456";

        System.out.println(firstPhone.imeiNumber);
        System.out.println(secondPhone.imeiNumber);
        System.out.println(Phone.attributeSharingValueForAllInstances);

        //utcn.ro.Main main = new main();

        //newMain().doSomething();
        //newMain().doSomething();

    }

    public void doSomething(){

    }
}