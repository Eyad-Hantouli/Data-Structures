package queue;

import doublyLinkedList.DoublyLinkedList;

public class Deque {
    DoublyLinkedList deque;

    public Deque () {
        deque = new DoublyLinkedList();
    }

    public void enqueFront (int item) {
        deque.addOnHead(item);
    }

    public void enqueRear (int item) {
        deque.addOnTail(item);
    }

    public int dequeFront () {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        int item = deque.getHeadValue();
        deque.deleteOnHead();
        return item;
    }

    public int dequeRear () {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        int item = deque.getTailValue();
        deque.deleteOnTail();
        return item;
    }

    public boolean isEmpty () {return deque.length() == 0;}

    public int length () {return deque.length();}

    public void display () {
        deque.display();
    }
}
