package uppgifter;

import java.util.ArrayList;
import java.util.List;

public class AssignmentEightPointSix {
    //@UnderTest(id="owners")
    private List<Owner> ownerList = new ArrayList();
    //@UnderTest(id="dogs")
    private List<Dog> listOfDogs = new ArrayList();
    private InputReader input = new InputReader();

    public AssignmentEightPointSix(){
        Dog dog1 = new Dog("elis", "tax", 7,7);
        Dog dog2 = new Dog("blis", "tax", 7,7);
        Dog dog3 = new Dog("hlis", "tax", 7,7);
        Owner owner1 = new Owner("Gustav");
        ownerList.add(owner1);
        listOfDogs.add(dog1);
        listOfDogs.add(dog2);
        listOfDogs.add(dog3);

        owner1.checkDog(dog1);
        owner1.checkDog(dog2);
        owner1.checkDog(dog3);

        removeDogFromOwner();
    }

    public void removeDogFromOwner(){
        String dogInput = input.string("Enter the name of the dog");
        Dog dog = findDogName(dogInput);
        if (dog == null) {
            System.out.println("Error: no dog with that name");
        } else if (dog.getOwner() == null) {
            System.out.println("Error: " + dog.getName() + "has no owner");
        } else {
            Owner owner = dog.getOwner();
            System.out.println(dog.getOwner());
            dog.removeOwnerFromDog(owner);
            System.out.print(dog.getOwner());
        }
    }

    //@UnderTest(id="U8.4")
    public void listOwner(){
        if (ownerList.size() != 0) {
            for (Owner owner : ownerList) {
                System.out.print(owner.getName() + " ");
                Dog[] newDogArr = owner.getDog();
                for (Dog dog : newDogArr) {
                    System.out.print(dog.getName() + " ");
                }
            }
        }else {
            System.out.print("Error: no owners in register");
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


    //@UnderTest(id="U7.2")
    public void takeUserTailInput(){
        if (listOfDogs.size() != 0){
            double tailLenght = input.doubleNr("Smallest tail length to display");
            listTailLength(tailLenght);
        } else{
            System.out.println("Error: No dogs in register!");
        }
    }

    private void listTailLength(double tailLenght){
        ArrayList<Dog>qualifyingDogs = new ArrayList<>();
        for(Dog dog:listOfDogs){
            if (dog.getTailLength()>tailLenght){
                qualifyingDogs.add(dog);
            }
        }

        if (qualifyingDogs.size() == 0){
            System.out.println("No dogs fulfill the reqs!");
        }else {
            for (Dog qualiDog:qualifyingDogs){
                System.out.println(qualiDog);
            }
        }
    }

}
