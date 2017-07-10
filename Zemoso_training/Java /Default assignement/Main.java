package yourname.assignment.main;
import yourname.assignment.data.Data;
import yourname.assignment.singleton.Singleton;

public class Main {
    public static void main(String[] args)
    {
        Data class1_Obj = new Data();
        class1_Obj.print();
        class1_Obj.print_local();

        Singleton class2_Obj = new Singleton();
        class2_Obj.print_string();
    }
}
