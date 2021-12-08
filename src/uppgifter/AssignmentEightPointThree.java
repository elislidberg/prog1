package uppgifter;

//Elis Lidberg elli6378

import java.util.ArrayList;
import java.util.List;

public class AssignmentEightPointThree {
    //@UnderTest(id="owners")
    private List<Owner> ownerList = new ArrayList();
    //@UnderTest(id="dogs")
    private List<Dog> listOfDogs = new ArrayList();
    private InputReader input = new InputReader();
    private String dogName;

    /*public void AssignmentEightPointThree() {
        Dog dog1 = new Dog("Gustav", "tax", 7, 7);
        Dog dog2 = new Dog("Elis", "hund", 8, 8);
        Owner owner1 = new Owner("August");
        Owner owner2 = new Owner("Diar");
        listOfDogs.add(dog1);
        listOfDogs.add(dog2);
        ownerList.add(owner1);
        ownerList.add(owner2);

        enterName();

    }*/
    //@UnderTest(id="U8.3")
    private void enterName() {

        String dogInput = input.string("Enter the name of the dog");
        Dog dog = findDogName(dogInput);
        if (dog == null) {
            System.out.println("Error: no dog with that name");
        } else if (dog.getOwner() != null) {
            System.out.println("Error: the dog already has an owner");
        } else {
            String ownerInput = input.string("Enter the name of the owner");
            Owner owner = findOwner(ownerInput);
            if (owner == null) {
                System.out.println("Error: no owner with that name");
            } else {
                if (owner.checkDog(dog)) {
                    System.out.println(owner.getName() + " now owns " + dog.toString());
                } else {
                    System.out.println("Error: the dog already has an owner");
                }
            }
        }
    }

    private Owner findOwner(String ownerName){
        for (Owner owner: ownerList){
            if(owner.getName().equalsIgnoreCase(ownerName)){
                return owner;
            }
        }return null;
    }

    private Dog findDogName(String dogName){
        for (Dog dog:listOfDogs){
            if (dog.getName().equalsIgnoreCase(dogName)){
                return dog;
            }
        }return null;
    }
}
