/**
 * Created by zemoso on 20/7/17.
 */
public class Main {
    public static void main(String args[])
    {
        SList<Integer> List = new SList<>(); //Object to call the Slist class
        SList_Iterator<Integer> itr = List.iterator();

        System.out.println(List);
        itr.insertAtEnd(10);
        System.out.println(List);
        itr.insertAtEnd(20);
        System.out.println(List);
        itr.insertAtAnyPosition(13,1);
        System.out.println(List);
        itr.insertAtBeginning(40);
        System.out.println(List);
        itr.insertAtBeginning(60);
        System.out.println(List);
        itr.deleteAtEnd();
        System.out.println(List);
        itr.deleteAtBeginning();
        System.out.println(List);
        itr.deleteAtAnyPosition(0);
        System.out.println(List);
    }
}
