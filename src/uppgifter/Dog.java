package uppgifter;
//Elis Lidberg elli6378

public class Dog {
    private String name;
    private String breed;
    private Owner owner;
    private int age;
    private int weight;

    public Dog(String name, String breed, int age, int weight){
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    public Owner getOwner(){
        return this.owner;
    }

    public void setOwner(Owner owner){
        this.owner = owner;
    }

    public void removeOwnerFromDog(Owner owner){
        if (owner != null && !owner.checkArray(this))  {
            owner.removeDog(this);
        }
    }

    public void removeOwner(){
        this.owner = null;
    }

    //@UnderTest(id="U8.3")
    public boolean checkOwner(Owner owner){
        if (getOwner() == null && owner.checkArray(this)){
            setOwner(owner);
            owner.setDog(this);
            return true;
        }
        return false;
    }

    public String getName(){
        return this.name;
    }

    public String getBreed(){
        return this.breed;
    }

    public int getAge(){
        return this.age;
    }

    public int getWeight(){
        return this.weight;
    }

    public double getTailLength(){
        if (this.breed.toLowerCase().contains("tax") || this.breed.toLowerCase().contains("dachshund")){
            final double tailLen = 3.7;
            return tailLen;
        }else{
            return (double)((this.age*this.weight)/10.0);
        }
    }

    public void updateAge(int newAge){
        if (newAge >= 0){
            this.age += newAge;
        }
    }

    public String printOwner(){
        //if (owner != null){
            return ", owned by " + owner;
        //}
        //return "";
    }

    public String toString(){
        return "* " + name + " (" + breed +", "+ age + " years, " +
                weight + " kilo, " + getTailLength() + " cm tail " + printOwner() + ")";
    }
}