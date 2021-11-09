public class Dog {
    public void bark() {
         barkMany(1);  //repetitive: As a dog, I say:
    }
    public void barkMany(int N) {
        for (int i = 0; i < N; i++) {
            bark();
        }
    }
    public static void main(String[] args) {
        Dog d = new Dog();
        d.barkMany(3);
    }

}
