package uppgifter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignmentEightPointFour {
    //@UnderTest(id="owners")
    private List<Owner> ownerList = new ArrayList();
    //@UnderTest(id="dogs")
    private List<Dog> listOfDogs = new ArrayList();
    private InputReader input = new InputReader();

    public AssignmentEightPointFour(){
        Dog dog1 = new Dog("elis", "tax", 7,7);
        Dog dog2 = new Dog("august", "tax", 7,7);
        Dog dog3 = new Dog("clara", "tax", 7,7);
        Owner owner = new Owner("gustav");
        ownerList.add(owner);
        listOfDogs.add(dog1);
        listOfDogs.add(dog2);
        listOfDogs.add(dog3);
        owner.checkDog(dog1);
        owner.checkDog(dog2);
        owner.checkDog(dog3);

        listOwner();
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
