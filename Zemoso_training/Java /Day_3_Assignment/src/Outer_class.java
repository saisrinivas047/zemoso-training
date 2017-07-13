
public class Outer_class //Outer_Class
{
    class inner_class_1 //class inside the Outer_class
    {
        public inner_class_1(int a){} //constructor with an argument
    }
}

class Outer1 extends Outer_class{
    public class inner extends Outer_class.inner_class_1 { //class within inner_class_1
        public inner(int a) {
            super(a); //calling the super_class
        }
    }
}
