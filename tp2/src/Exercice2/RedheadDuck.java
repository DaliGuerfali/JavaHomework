package Exercice2;



public class RedheadDuck extends Duck implements Flyable, Quackable {
    @Override
    public void display() {
        System.out.println("Displaying Redhead Exercice2.Duck.");
    }

    @Override
    public void fly() {
        System.out.println("Redhead Exercice2.Duck is flying.");
    }

    @Override
    public void quack() {
        System.out.println("Redhead Exercice2.Duck Quack!");
    }
}
