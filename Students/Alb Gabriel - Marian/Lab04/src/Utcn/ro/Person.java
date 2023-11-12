package utcn.ro;
public class Person {
    private String name;//atribut privat
    private Person contactPerson;
    private Person instance;

    //Constructor
    public Person(String name){
        this.name = name;
    }

    public Person getInstance(){
        if(instance == null){
            instance = new Person("ABC");
        }
        return instance;
    }

    //Iar aici se poate vedea incapsularea
    //Getter and setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Person getContactPerson() {
        return contactPerson;
    }
    public void setContactPerson(Person contactPerson) {
        this.contactPerson = contactPerson;
    }
// Nefunctionabile
    /*public String processName(String name){
        // we are doing some stuff
        return removeVocals(name);
    }
    private String removeVocals(String value){
        //remove vocals from a string
    }*/

}
