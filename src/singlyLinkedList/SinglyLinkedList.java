package singlyLinkedList;

public class SinglyLinkedList {
    Node head;
    int size;

    public SinglyLinkedList() {
        size = 0;
        this.head = null;
    }

    public void add (int value) {
        Node newNode = new Node(value);

        if (head == null)
            this.head = newNode;

        else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }

        size++;
    }

    public void delete (int value) {
        if (head == null)
            return;

        if (head.value == value) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        Node prev = null;

        while (current != null && current.value != value) {
            prev = current;
            current = current.next;
        }

        if (current == null) // singlyLinkedList.Node not found.
            return;

        prev.next = current.next;
        size--;
    }

    public int getHeadValue () {return head.value;}
    public void deleteHead () {
        head = head.next;
        size--;
    }

    public int length() {return size;}

    public void display () {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + ", ");
            current = current.next;
        }
        System.out.println();
    }
}
