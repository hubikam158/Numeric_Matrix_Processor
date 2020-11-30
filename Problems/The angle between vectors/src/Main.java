import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double u1 = sc.nextDouble();
        double u2 = sc.nextDouble();
        double v1 = sc.nextDouble();
        double v2 = sc.nextDouble();

        double scalarProduct = u1 * v1 + u2 * v2;
        double uLength = Math.sqrt(Math.pow(u1, 2) + Math.pow(u2, 2));
        double vLength = Math.sqrt(Math.pow(v1, 2) + Math.pow(v2, 2));

        System.out.println(Math.toDegrees(Math.acos(scalarProduct / (uLength * vLength))));
    }
}