package Exercice1;

import java.util.ArrayList;

public class CustomStack<T> {
    private final ArrayList<T> elements;
    private final int capacity;

    public CustomStack(int capacity) {
        this.elements = new ArrayList<>(capacity);
        this.capacity = capacity;
    }
    public boolean StackIsFull() {
        return this.elements.size() == this.capacity;
    }

    public void addElement(T e) {
        if(StackIsFull()) {
         System.out.println("Cannot add element to stack.");
         return;
        }
        this.elements.add(e);
    }

    public void removeElement() {
        this.elements.remove(this.elements.size() - 1);
    }
    public boolean StackIsEmpty() {
        return this.elements.isEmpty();
    }
    public T LastInStack() {
        if(StackIsEmpty()) {
            return null;
        }
        return this.elements.get(this.elements.size() - 1);
    }
    public String toString() {
        return this.elements.toString();
    }

}
