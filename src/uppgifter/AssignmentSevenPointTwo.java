package uppgifter;

//Elis Lidberg elli6378
import java.util.ArrayList;
import java.util.List;

public class AssignmentSevenPointTwo{
    //@UnderTest(id="dogs")
    private List<Dog>listOfDogs = new ArrayList<>();
    private InputReader input = new InputReader();

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
