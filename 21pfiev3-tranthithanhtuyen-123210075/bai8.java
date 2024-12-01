import java.util.Scanner;

public class bai8 {
    public static double find(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double kq = find(n);
        System.out.println(kq);

        scanner.close(); 
    }
}