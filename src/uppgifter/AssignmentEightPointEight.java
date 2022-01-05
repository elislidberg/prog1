package uppgifter;

import java.util.ArrayList;
import java.util.List;

public class AssignmentEightPointEight {
    //@UnderTest(id="owners")
    private List<Owner> ownerList = new ArrayList();
    //@UnderTest(id="dogs")
    private List<Dog> listOfDogs = new ArrayList();
    private InputReader input = new InputReader();

    //@UnderTest(id="8.7")
    public void removeDog(){
        String userInput = input.string("Enter the name of the dog");
        Dog deletedDog = findDogName(userInput);
        if (deletedDog == null){
            System.out.println("Error: no such dog");
        } else {
            System.out.println(deletedDog.getName() +  " is removed from the register");
            if (deletedDog.getOwner() == null){
                listOfDogs.remove(deletedDog);
            }else{
                Owner owner = deletedDog.getOwner();
                owner.removeDog(deletedDog);
                listOfDogs.remove(deletedDog);
            }
        }
    }

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

