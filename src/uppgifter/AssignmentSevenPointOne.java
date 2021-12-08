package uppgifter;

import java.util.ArrayList;
import java.util.List;

public class AssignmentSevenPointOne {
    static List<Dog>listOfDogs = new ArrayList<>();
    Dog newDog;

    public void addDogToList(){
        AssignmentSixPointFour dogObj = new AssignmentSixPointFour();
        this.newDog = dogObj.createDog();
        listOfDogs.add(newDog);
        System.out.println(listOfDogs);
        System.out.println(listOfDogs.size());
    }
}
