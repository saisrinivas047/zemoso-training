
import java.util.*;
abstract class Rodent
{
    abstract void hunt();
    abstract void eat();
    abstract void sleep();
}

class Mouse extends Rodent
{
    Mouse(){System.out.println("Behaviour of a Mouse :");}
    void hunt(){System.out.println("Mouse is Hunting");}
    void eat(){System.out.println("Mouse is Eating");}
    void sleep(){System.out.println("Mouse is Sleeping");}
}

class Gerbil extends Rodent
{
    Gerbil(){System.out.println("Behaviour of a Gerbil :");}
    void hunt(){System.out.println("Gerbil is Hunting");}
    void eat(){System.out.println("Gerbil is Eating");}
    void sleep(){System.out.println("Gerbil is Sleeping");}
}

class Hamster extends Rodent
{
    Hamster(){System.out.println("Behaviour of a Hamster :");}
    void hunt(){System.out.println("Hamster is Hunting");}
    void eat(){System.out.println("Hamster is Eating");}
    void sleep(){System.out.println("Hamster is Sleeping");}
}

class Rodents
{
    public static void main(String args[])
    {
        Rodent rodent[] = {new Mouse(), new Gerbil(), new Hamster()}; //Rodents Array

        for(Rodent i : rodent){	//Calling base-class methods
            i.eat();
            i.hunt();
            i.sleep();
        }
    }
}