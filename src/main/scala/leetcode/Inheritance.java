package leetcode;
class Food {}
abstract class Animal {
    public void eat(Food food) {
        System.out.println("Eating food");
    }
}
class Grass extends Food {}
class Cow extends Animal {
    public void eat(Grass Food) {
        System.out.println("Eating grass");
    }
}
public class Inheritance {
    public static void main(String args[]) {
        Cow cow = new  Cow();
        cow.eat(new Grass());

    }
}
