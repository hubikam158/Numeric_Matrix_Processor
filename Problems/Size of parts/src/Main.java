import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ready = 0;
        int rejected = 0;
        int toBeFixed = 0;

        for (int i = 0; i < n; i++) {
            int choice = sc.nextInt();
            if (choice == 0) {
                ready++;
            } else if (choice == 1) {
                toBeFixed++;
            } else if (choice == -1) {
                rejected++;
            }
        }

        System.out.println(ready + " " + toBeFixed + " " + rejected);
    }
}