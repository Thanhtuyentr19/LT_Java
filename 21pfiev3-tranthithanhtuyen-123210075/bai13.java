import java.util.Scanner;

public class bai13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số b: ");
        int b = scanner.nextInt();

        int gcd = findGCD(a, b);
        int lcm = findLCM(a, b);

        System.out.println("Ước chung lớn nhất của " + a + " và " + b + " là: " + gcd);
        System.out.println("Bội chung nhỏ nhất của " + a + " và " + b + " là: " + lcm);
        scanner.close();

    }


    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int findLCM(int a, int b) {
        int gcd = findGCD(a, b);
        int lcm = (a * b) / gcd;
        return lcm;
    }
}