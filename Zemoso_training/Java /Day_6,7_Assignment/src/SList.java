import java.util.*;
public class SList<T> {
    private Node<T> start, end; //pointers that points start and end of the linked list

    /**
     * converts the output of the list to String
     * @return returns the string
     */
    public String toString() {
        StringBuilder s = new StringBuilder("{");

        Node<T> next;
        if (start != null) {
            next = start;
            s.append(next);
            next = next.next;
            while (next != null) {
                s.append(", " + next);
                next = next.next;
            }
        }
        s.append("}");
        return s.toString();
    }

    /**
     * Creates a new iterator
     * @return reference to the SList_Iterator
     */
    public SList_Iterator<T> iterator() {
        return new iterator();
    }

    /**
     * class Node which contains a data holder and a reference to the next node
     * @param <T> represents a type
     */
    private class Node<T> {
        T data;
        Node<T> next = null;
        public Node(T data) {this.data = data;}
        Node() {}

        public String toString() {
            return data.toString();
        }
    }

    /**
     * Class iterator contains the methods which are initiazed in the SList_iterator
     */
    class iterator implements SList_Iterator<T> {
        Node<T> current; //pointer which points to the current node

        /**
         * constructor that gives the start reference to the current pointer whenever iterator is called
         */
        iterator(){current = start;}

        /**
         * Method to insert a node at the end of the linked list
         * @param value value that needs to be assigned in the new node
         */
        @Override
        public void insertAtEnd(T value) {
            Node<T> new_node = new Node<T>(value);
            if (start == null) {
                start = new_node;
            }
            if (end == null) {
                end = new_node;
            } else {
                end.next = new_node;
                end = new_node;
            }

        }
        /**
         * Method to insert a node at the beginning of the linked list
         */
        @Override
        public void insertAtBeginning(T value) {
            Node<T> new_node = new Node<>(value);
            new_node.next = start;
            start = new_node;
        }

        /**
         * Method to insert a node at the given index of the linked list
         * @param value value that needs to be assigned in the new node
         * @param index index value
         */
        @Override
        public void insertAtAnyPosition(T value, int index) {
            Node<T> new_node = new Node<>(value);
            if(index < 0)
                throw new IndexOutOfBoundsException();
            else if(index == 0){
                new_node.next = start;
                start = new_node;
            }else{
                Node<T> previous = start;
                for(int i =0;i<index-1;i++)
                {
                    previous = previous.next;
                }
                Node<T> curr = previous.next;
                new_node.next = curr;
                previous.next = new_node;
            }

        }

        /**
         * Method to delete a node at the end of the linked list
         */
        @Override
        public void deleteAtEnd() {
            Node<T> last = start;
            Node<T> lastButOne = null;
            while(last !=null){
                lastButOne = last;
                last = last.next;}
            lastButOne.next = null;
        }

        /**
         * Method to delete a node at the beginning of the linked list
         */
        @Override
        public void deleteAtBeginning() {
            Node<T> temp = start;
            start = start.next;
            temp.next = null;
        }

        /**
         * Method to delete a node at any given index of the linked list
         * @param index index value
         */
        @Override
        public void deleteAtAnyPosition(int index) {
            if(index < 0)
                throw new IndexOutOfBoundsException();
            else if(index == 0)
                deleteAtBeginning();
            else
            {
                Node<T> previous = start;
                for(int i =0 ;i<index-1;i++)
                    previous = previous.next;
                previous.next = previous.next.next;
            }
        }

        /**
         * Method to find if the next element on the list is present or not.
         * @return If the next element on the list is not null, then it returns true else false is returned
         */
        public boolean hasNext() {
            if (current.next != null) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * Method to return the next node on the list
         * @return next node on the list
         */
        @Override
        public T next() {
            current = current.next;
            return current.data;
        }
    }
}
