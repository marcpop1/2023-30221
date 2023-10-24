package utcn.ro;

public class Phone{

    static int attributeSharingValueForAllInstances;
    String imeiNumber;
    String brandName;
    double displaySize;
    int volume=0;
    String contactPersonName;

    //Constructor
    public Phone()
    {
        displaySize = 5.5;

    }

    public Phone(String imeiNumber){
        this.imeiNumber = imeiNumber;
        this.powerOn();
    }

    public void powerOn(){
        System.out.println("Powering off...");
    }

    public void tweakVolume(int amount, boolean up){
        int realAmount = up ? amount : -amount;
        int newVolume = volume + realAmount;
        if((up && newVolume < 100) || (!up && newVolume > 0)){
            volume = newVolume;
        }
    }

}
