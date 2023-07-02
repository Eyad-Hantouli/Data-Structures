package stack;

import array.DynamicArray;

public class Stack {
    DynamicArray stack;

    public Stack () {
        stack = new DynamicArray();
    }

    public void add (Object item) {
        stack.add(item);
    }

    public Object remove () {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stack.pop();
    }

    public boolean isEmpty () {return stack.length() == 0;}

    public int length () {return stack.length();}

    public void display () {
        System.out.println(stack.toString());
    }
}
