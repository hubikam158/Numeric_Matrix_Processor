import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        calculateAverage(a, b);
    }

    private static void calculateAverage(int from, int to) {
        int sum = 0;
        int count = 0;
        for (int i = from + 3 - (from % 3); i <= to; i += 3) {
            sum += i;
            count ++;
        }
        System.out.println((double) sum / count);
    }
}