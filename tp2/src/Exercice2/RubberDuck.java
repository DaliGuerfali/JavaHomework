package Exercice2;


public class RubberDuck extends Duck implements Quackable {
    @Override
    public void display() {
        System.out.println("Displaying Rubber Exercice2.Duck.");
    }

    @Override
    public void quack() {
        System.out.println("Rubber Exercice2.Duck Quack!");
    }
}
