/**
 * Created by zemoso on 20/7/17.
 */
public interface SList_Iterator<T> {
    void insertAtEnd(T value);
    void insertAtBeginning(T value);
    void insertAtAnyPosition(T value, int index);
    void deleteAtEnd() throws NullPointerException;
    void deleteAtBeginning();
    void deleteAtAnyPosition(int index);
    boolean hasNext();
    T next();
}
