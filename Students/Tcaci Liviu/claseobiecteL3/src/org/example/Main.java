/*
 * Created by Tcaci Liviu
 */

package org.example;

public class Main { //can be abstract, final, or empty
    //usually one class per file
    public static void main(String[] args) { //this is the entry point of the program
        System.out.println("Hello world!");
        int a;
        //var with type Phone called firstPhone
        //obj is nothing more than a var that has a type
        // => obj = var + type; class = type
        // a obj is an instance = var of a class
        Phone firstPhone = new Phone("samsung"); //call the constructor
        firstPhone.imeiNumber = "123";
        Phone secondPhone = new Phone("apple");
        secondPhone.imeiNumber = "456";
        //why not two constructors? cuz it's not possible
        //why not two classes? it's possible but not recommended if they have the same behavior
        //implicit value for a class is NULL for int is 0

        Phone.commonAttribute = 10;
        Phone.commonAttribute = 20;
        System.out.println(firstPhone.commonAttribute);

        //obj name is the reference to the obj/memory address
        firstPhone = secondPhone; //point to the same memory address; zone that stores
        // the obj won`t be deleted until there are no more references to it
        System.out.println(firstPhone.imeiNumber);
        System.out.println(secondPhone.imeiNumber);
        System.out.println(firstPhone.brandName); //??why is underlined


        //how to call method powerOn or powerOff from class Phone but from main
        Main main = new Main(); // BUT WHY we do that?
        //how many instances of a class can be created? as many as you want
        //call method from non-static to static is possible but not the other way around

        Phone thirdPhone = new Phone();
        Main.doSmth(thirdPhone);
        System.out.println(thirdPhone.imeiNumber);
        System.out.println(thirdPhone.brandName);
        System.out.println(thirdPhone.volume);
        System.out.println(thirdPhone.batteryLevel);
        System.out.println(thirdPhone.isLocked);
        System.out.println(thirdPhone.repaired);
        System.out.println("\n");

        Phone fourthPhone = new Phone();
        fourthPhone.batteryLevel = 50;
        System.out.println(fourthPhone.checkBatteryLevel(50));
        fourthPhone.tweakVolume(50, true);
        System.out.println(fourthPhone.volume);
        fourthPhone.isLocked = true;
        System.out.println(fourthPhone.isLocked);
    }

    public static void doSmth(Phone phone) {
        phone.imeiNumber = "33123";
        phone.brandName = "Huawei";
        phone.volume = 10;
        phone.batteryLevel = 98;
        phone.isLocked = false;
        phone.repaired = true;
    }
}

/*
 * 1. play with the code
 * 2. create a new method in Phone class
 * 4. create a new object of type Phone in Main class and call the method from step 2
 */