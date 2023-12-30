package Exercice2;


public class MallardDuck extends Duck implements Flyable, Quackable {
    @Override
    public void display() {
        System.out.println("Displaying Malllard Exercice2.Duck.");
    }

    @Override
    public void fly() {
        System.out.println("Malllard Exercice2.Duck is flying.");
    }

    @Override
    public void quack() {
        System.out.println("Malllard Exercice2.Duck Quack!");
    }
}
