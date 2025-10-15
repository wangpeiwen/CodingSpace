package main;
import java.util.concurrent.atomic.*;
public class Atom {
    private final AtomicInteger value = new AtomicInteger(0);

    public int getValue() {
        return value.get();
    }

    public void setValue(int newValue) {
        value.set(newValue);
    }

    public int increment() {
        return value.incrementAndGet();
    }

    public int decrement() {
        return value.decrementAndGet();
    }
    public int add(int delta) {
        return value.addAndGet(delta);
    }

    public static void main(String[] args) {
        Atom atom = new Atom();
        System.out.println("Initial Value: " + atom.getValue());
        atom.setValue(10);
        System.out.println("After setValue(10): " + atom.getValue());
        System.out.println("After increment(): " + atom.increment());
        System.out.println("After decrement(): " + atom.decrement());
        System.out.println("After add(5): " + atom.add(5));
    }
}

