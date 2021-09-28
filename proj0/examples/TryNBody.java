public class TryNBody {
    static String fileName = "/Users/anita/cs61b/cs61b/proj0/data/planets.txt";
    static In in = new In(fileName);
    int num = in.readInt();

    static void readRadius(String fileName) {
        int num = in.readInt();
        double radius =  in.readDouble();
        System.out.println(radius);
    }

    static void readPlanets(String fileName) {
        for (int i = 0; i < 5; i ++) {
            double line = in.readDouble();
            double line2 = in.readDouble();
            double line3 = in.readDouble();
            double line4 = in.readDouble();
            double line5 = in.readDouble();
            String name = in.readString();

        }
    }

    public static void main(String[] args) {
        TryNBody.readRadius(fileName);
        TryNBody.readPlanets(fileName);
    }
}
