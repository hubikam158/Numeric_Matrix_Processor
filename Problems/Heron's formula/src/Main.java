import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        double p = (double) (a + b + c) / 2;

        System.out.println(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }
}