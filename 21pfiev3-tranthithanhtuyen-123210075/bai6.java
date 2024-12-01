import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        final int startRate = 45000;
        final int lateRate = 60000;
        final int hoursInDay = 24;
        System.out.print("Nhap gio bat dau: ");
        a = scanner.nextInt();
        System.out.print("Nhap gio ket thuc: ");
        b = scanner.nextInt();
        if (a < 0 || a >= hoursInDay || b < 0 || b >= hoursInDay || a >= b) {
            System.out.println("Thoi gian nhap khong hop le.");
        } else {
            int totalHours = b - a;
            int totalCost = 0;
            if (b < 18) {
                totalCost = totalHours * startRate;
            } else {
                int earlyHours = (b < 18) ? totalHours : 18 - a;
                int lateHours = totalHours - earlyHours;
                totalCost = earlyHours * startRate + lateHours * lateRate;
            }
            System.out.println("Tien phai tra: " + totalCost + " VND.");
        }
        scanner.close();
    }
}