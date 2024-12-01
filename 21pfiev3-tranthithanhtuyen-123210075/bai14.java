import java.util.Scanner;

public class bai14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một số nguyên m: ");
        int m = scanner.nextInt();

        if (isPrime(m)) {
            System.out.println(m + " là số nguyên tố.");
        } else {
            System.out.println(m + " không là số nguyên tố.");
        }
        scanner.close();

    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;

    }
}