package uppgifter;

public class AssignmentSixPointFour {
    private String dogName;
    private String dogBreed;
    private int dogAge;
    private int dogWeight;
    private InputReader userInput = new InputReader();

    public Dog createDog() {
        this.dogName = userInput.string("Name");
        this.dogBreed = userInput.string("Breed");
        this.dogAge = userInput.intNr("Age");
        this.dogWeight = userInput.intNr("Weight");

        Dog newDog = new Dog(dogName, dogBreed, dogAge, dogWeight);

        return newDog;
    }
}
