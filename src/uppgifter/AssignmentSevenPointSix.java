package uppgifter;

//Elis Lidberg elli6378
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssignmentSevenPointSix {
    //@UnderTest(id="dogs")
    private List<Dog> listOfDogs = new ArrayList<>();

    //@UnderTest(id="U7.6.1.1")
    private void changeTwoDogs(int i, int j){
        Dog dogOne = listOfDogs.get(i);
        Dog dogTwo = listOfDogs.get(j);
        listOfDogs.set(j, dogOne);
        listOfDogs.set(i, dogTwo);
    }

    //@UnderTest(id="U7.6.1.2")
    public void swapTwoDogs(int i, int j){
        Collections.swap(listOfDogs, i,j);
    }

    public int compTailLength(Dog i, Dog j) {
        if (i.getTailLength() > j.getTailLength()) {
            return 1;
        }
        if (i.getTailLength() < j.getTailLength()) {
            return -1;
        }
        return 0;
    }

    public int compName(Dog i, Dog j) {
        int comp = i.getName().compareToIgnoreCase(j.getName());
        if (comp > 0) {
            return 1;
        }
        return 0;
    }

    //@UnderTest(id="U7.6.2")
    public int compareTwoDogs(Dog i, Dog j) {
        int tailResult = compTailLength(i, j);
        if (tailResult != 0) {
            return tailResult;
        }
        return compName(i, j);
    }

    //@UnderTest(id="U7.6.3")
    public int findMinDog(int startIndex) {
        int minDogIndex = startIndex;
        for (int i = startIndex + 1; i < listOfDogs.size(); i++) {
            int compResult = compareTwoDogs(listOfDogs.get(minDogIndex), listOfDogs.get(i));
            if (compResult == 1) {
                minDogIndex = i;
            }
        }
        return minDogIndex;
    }

    //@UnderTest(id="U7.6.4")
    public int selectionSort() {
        int counter = 0;
        for (int i = 0; i < listOfDogs.size(); i++) {
            int swapIndex = findMinDog(i);
            swapTwoDogs(i, swapIndex);
            if (i != swapIndex) {
                counter++;
            }
        }
        return counter;
    }
}
