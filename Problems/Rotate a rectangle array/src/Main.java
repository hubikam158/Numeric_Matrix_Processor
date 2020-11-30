import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] inputArray = new int[n][m];
        int[][] outputArray = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                inputArray[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                outputArray[i][j] = inputArray[n - 1 - j][i];
                System.out.print(outputArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}