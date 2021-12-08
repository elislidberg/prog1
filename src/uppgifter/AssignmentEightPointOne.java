package uppgifter;

//Elis Lidberg elli6378
import java.util.ArrayList;
import java.util.List;


public class AssignmentEightPointOne {
    //@UnderTest(id="owners")
    private List<Owner> ownerList = new ArrayList();
    private InputReader userInput = new InputReader();
    private String name;
    private Owner newOwner;

    //@UnderTest(id="U8.1")
    public void addOwnerToList(){
        this.newOwner = createOwner();
        ownerList.add(newOwner);
        System.out.println(name + " added to register");
    }

    private Owner createOwner(){
        this.name = userInput.string("Name");
        Owner owner = new Owner(name);
        return owner;
    }
}
