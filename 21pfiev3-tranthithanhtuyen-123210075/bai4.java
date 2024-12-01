import java.util.Scanner;

public class bai4 {
    public static double solve(double a1, double b1, double c1, double a2, double b2, double c2) {
        double D = (a1 * b2) - (a2 * b1);
        if (D == 0) {
            if (c1 * b2 - c2 * b1 == 0) {
                System.out.println("Hệ phương trình có vô số nghiệm.");
            } else {
                System.out.println("Hệ phương trình không có nghiệm.");
            }
            return 0;
        }

        double x = (c1 * b2 - c2 * b1) / D;
        double y = (a1 * c2 - a2 * c1) / D;

        System.out.println("Nghiệm hệ phương trình là:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the coefficients of the system of equations:");
        double a1 = scanner.nextDouble();
        double b1 = scanner.nextDouble();
        double c1 = scanner.nextDouble();
        double a2 = scanner.nextDouble();
        double b2 = scanner.nextDouble();
        double c2 = scanner.nextDouble();

        solve(a1, b1, c1, a2, b2, c2);

        scanner.close(); // Close the Scanner resource to avoid a resource leak.
    }
}