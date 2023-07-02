package array;

public class DynamicArray {
    int size;
    int capacity = 10;
    Object[] array;
    public DynamicArray() {
        this.array = new Object[capacity];
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public void add(Object data) {
        if (size >= capacity)
            grow();

        array[size] = data;
        size++;
    }

    public void insert(int index, Object data) {
        if (size >= capacity)
            grow();

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = data;
        size++;
    }

    public void remove(Object data) {
        if (isEmpty())
            throw new IllegalStateException("Array is empty.");

        for (int i=0; i<size; i++) {
            if(array[i] == data) {
                for (int j = 0; j < (size - i - 1); j++) {
                    array[i + j] = array[i + j + 1];
                }
                array[size-1] = null;
                size--;
                if(size <= (int) (capacity/3))
                    shrink();
                break;
            }
        }
    }

    public Object pop () {
        if (isEmpty())
            throw new IllegalStateException("Array is empty.");

        Object item = array[size-1];
        array[size-1] = null;
        size--;
        if(size <= (int) (capacity/3))
            shrink();
        return item;
    }

    public int search(Object data) {
        for(int i = 0; i<size; i++) {
            if (array[i] == data)
                    return i;
        }
        return -1;
    }

    private void grow() {
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i<size; i++) {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    private void shrink() {
        int newCapacity = capacity / 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i<size; i++) {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    public int index(int index) {return (int) array[index];}

    public boolean isEmpty() {
        return size == 0;
    }

    public int length() {return size;}

    public String toString () {
        String string = "{";

        for (int i=0; i<size; i++) {
            if (i != size-1)
                string += array[i] + ", ";
            else
                string += array[i];
        }
        string += '}';

        return string;
    }
}