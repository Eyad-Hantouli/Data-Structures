package queue;

import singlyLinkedList.SinglyLinkedList;

public class SingleEndedQueue {
    SinglyLinkedList queue;

    public SingleEndedQueue () {
        queue = new SinglyLinkedList();
    }

    public void enque (int item) {
        queue.add(item);
    }

    public int deque () {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        int item = queue.getHeadValue();
        queue.deleteHead();
        return item;
    }

    public boolean isEmpty () {return queue.length() == 0;}

    public int length () {return queue.length();}

    public void display () {
        queue.display();
    }

}
