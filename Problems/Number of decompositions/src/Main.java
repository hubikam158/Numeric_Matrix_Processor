import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        partition(n);
    }

    private static void partition(int n, int max, String str) {
        if (n == 0) {
            System.out.println(str);
        } else {
            for (int i = 1; i <= Math.min(n, max); i++) {
                partition(n - i, i, str + " " + i);
            }
        }
    }

    private static void partition(int n) {
        partition(n, n, "");
    }
}