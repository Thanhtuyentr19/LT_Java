import java.util.Scanner;

public class bai19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Nhap so n: ");
        n = scanner.nextInt();
        long a = 0, b = 1;
        System.out.print("N so Fibonacci dau tien la: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            long temp = a;
            a = b;
            b = temp + b;
        }
        System.out.println();
        scanner.close();
    }
}