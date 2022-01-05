package uppgifter;

import java.util.ArrayList;
import java.util.List;

public class AssignmentEightPointSeven {
    //@UnderTest(id="owners")
    private List<Owner> ownerList = new ArrayList();
    //@UnderTest(id="dogs")
    private List<Dog> listOfDogs = new ArrayList();
    private InputReader input = new InputReader();

    public AssignmentEightPointSeven(){
        Dog dog1 = new Dog("gustav", "tax", 7, 7);
        Dog dog2 = new Dog("elis", "tax", 7, 7);

        Owner owner1 = new Owner("august");
        Owner owner2 = new Owner("clara");
        listOfDogs.add(dog1);
        listOfDogs.add(dog2);
        ownerList.add(owner1);
        ownerList.add(owner2);

        owner1.checkDog(dog1);
        owner2.checkDog(dog2);

        System.out.println(listOfDogs);
        System.out.println(ownerList);
        removeOwnerFromRegister();
        System.out.println(listOfDogs);
        System.out.println(ownerList);

    }
    //@UnderTest(id="8.7")
    public void removeOwnerFromRegister(){
        String ownerName = input.string("Enter the name of the user");
        Owner owner = confirmOwnerRemoval(ownerName);
        if (owner != null) {
            removeDogsFromRegister(owner);
            removeOwnerFromRegister(owner);
            System.out.println(owner.getName() + " is removed from register");
        } else {
            System.out.println("Error: no such owner");
        }
    }

    private Owner confirmOwnerRemoval(String ownerName){
        for (Owner owner: ownerList){
            if (owner.getName().equalsIgnoreCase(ownerName)){
                return owner;
            }
        }return null;
    }

    private void removeOwnerFromRegister(Owner owner){
        ownerList.remove(owner);
    }

    private void removeDogsFromRegister(Owner owner){
        for (Dog dog: owner.getDog()){
            listOfDogs.remove(dog);
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
