package Discussion4Inheritance;

public class Animal {
    protected String name, noise;
    protected int age;
    public Animal() {}
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.noise = "Huh?";
    }

    public String makeNoise() {
        System.out.println("make noise!");
        if (age > 5) {
            return noise.toUpperCase();
        } else {
            return noise;
        }
    }

    public void greet() {
        System.out.println("Animal " + name + " says: " + makeNoise());
    }

    public static void main(String[] args) {
        Animal a = new Animal("Tom", 6);
        a.makeNoise();
        a.greet();

    }
}


