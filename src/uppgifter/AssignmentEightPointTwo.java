package uppgifter;

//Elis Lidberg elli6378


import java.util.ArrayList;
import java.util.List;

public class AssignmentEightPointTwo {
    //@UnderTest(id="owners")
    private List<Owner> ownerList = new ArrayList();

    //@UnderTest(id="U8.2")
    private Owner findOwner(String ownerName){
        for (Owner owner: ownerList){
            if(owner.getName().equalsIgnoreCase(ownerName)){
                return owner;
            }
        }return null;
    }
}
