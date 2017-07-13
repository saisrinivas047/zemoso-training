
import java.util.*;
interface cycle
{
    void Spec();
}

class unicycle implements cycle
{
    public void Spec()
    {
        System.out.println("I have only one wheel");
    }
}
class bicycle implements cycle
{
    public void Spec()
    {
        System.out.println("I have two wheels");
    }
}
class tricycle implements cycle
{
    public void Spec()
    {
        System.out.println("I have three wheels");
    }
}



public interface CycleFactory //Factory for cycle
{
 cycle getCycle();

}

class unicycleFactory implements CycleFactory {  //Factory for unicycle
    public cycle getCycle() {
        unicycle unicycle = new unicycle();
        return unicycle;
    }
}

class bicycleFactory implements CycleFactory {   //Factory for bicycle
    public cycle getCycle()
    {
        bicycle bicycle=new bicycle();
        return bicycle;
    }
}

class tricycleFactory implements CycleFactory {  //Factory for tricycle
    public cycle getCycle() {
        tricycle tricycle = new tricycle();
        return tricycle;
    }

class Factory  //main factory class
        {
        public void cycle(CycleFactory cycleFactory) //Setting up the factory
        {
            cycle cycle = cycleFactory.getCycle();
            cycle.Spec();
        }

        public void main(String arg[])
        {
            cycle(new unicycleFactory());
            cycle(new bicycleFactory());
            cycle(new tricycleFactory());
        }
    }
}