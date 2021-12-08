package uppgifter;
//Elis Lidberg elli6378

import java.util.Arrays;

public class Owner {
    private String name;
    private Dog dog;
    private Dog[] dogs = new Dog[0];
    private int indexCounter;

    public Owner(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return name + " ";
    }

    //@UnderTest(id="U8.3")
    public boolean checkDog(Dog dog){
        if (dog.getOwner() == null && checkArray(dog)){
            dog.setOwner(this);
            setDog(dog);
            return true;
        }
        return false;
    }

    public Dog[] getDog(){
        return dogs;
    }

    public void setDog(Dog dog){
        //this.dog = dog;
        Dog[] newDogArr = Arrays.copyOf(dogs, dogs.length +1);
        dogs = newDogArr;
        dogs[dogs.length-1] = dog;
    }

    public boolean checkArray(Dog dog){
        for (int i = 0; i < dogs.length;i++){
            if (dog == dogs[i]){
                return false;
            }
        } return true;
    }

    //UnderTest(id="U8.5")
    public boolean ownDog(Dog dog){
        if (!checkArray(dog)){
            return true;
        } return false;
    }

}