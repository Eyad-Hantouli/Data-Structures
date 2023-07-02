package doublyLinkedList;

public class DoublyLinkedList {
    int size;
    Node head;
    Node tail;

    public DoublyLinkedList () {
        size = 0;
        head = null;
        tail = null;
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public void addOnHead (int value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addOnTail (int value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            tail = newNode;
            head = newNode;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addOnIndex (int value, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Invalid index at: " + index);
        if (index == 0)
            addOnHead(value);
        else if (index == size)
            addOnTail(value);
        else {
            Node newNode = new Node(value);
            Node current = getNodeAtIndex(index);
            Node prev = current.prev;

            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = current;
            current.prev = newNode;
            size++;
        }
    }

    public void deleteOnHead() {
        if (isEmpty())
            throw new RuntimeException("Linked-List is empty");

        head = head.next;

        if (head == null)
            tail = null;
        else
            head.prev = null;
        size--;
    }

    public void deleteOnTail() {
        if (isEmpty())
            throw new RuntimeException("Linked-List is empty");

        tail = tail.prev;

        if (tail == null)
            head = null;
        else
            tail.next = null;
        size--;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index at: " + index);

        if (index == 0)
            deleteOnHead();

        else if (index == size - 1)
            deleteOnTail();

        else {
            Node current = getNodeAtIndex(index);
            Node prev = current.prev;
            Node next = current.next;
            prev.next = next;
            next.prev = prev;

            size--;
        }
    }

    public int getHeadValue () {return head.value;}

    public int getTailValue () {return tail.value;}

    public int length () {return size;}

    private Node getNodeAtIndex(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.value + ", ");
            current = current.next;
        }

        System.out.println();
    }
}
