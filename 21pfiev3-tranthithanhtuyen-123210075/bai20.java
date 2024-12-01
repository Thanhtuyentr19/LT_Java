import java.util.Scanner;

public class bai20 {
    public static boolean isFibonacci(int num) {
        if (num <= 1) {
            return num == 0 || num == 1;
        }
        int a = 0;
        int b = 1;
        while (b < num) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b == num;
    }

    public static int findFibonacciPosition(int num) {
        if (num <= 1) {
            return num;
        }
        int a = 0;
        int b = 1;
        int position = 1;
        while (b < num) {
            int temp = a + b;
            a = b;
            b = temp;
            position++;
        }
        return position;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K;
        System.out.print("Nhap so K: ");
        K = scanner.nextInt();
        if (isFibonacci(K)) {
            int position = findFibonacciPosition(K);
            System.out.println(K + " la phan tu thu " + position + " trong day Fibonacci.");
        } else {
            System.out.println(K + " khong thuoc day Fibonacci.");
        }
        scanner.close();

    }
}