    import java.util.Scanner;

    public class bai7 {
        public static boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }

        public static int getDaysInMonth(int month, int year) {
            switch (month) {
                case 2:
                    return isLeapYear(year) ? 29 : 28;
                case 4:
                case 6:
                case 9:
                case 11:
                    return 30;
                default:
                    return 31;
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int month, year;
            System.out.print("Nhap thang: ");
            month = scanner.nextInt();
            System.out.print("Nhap nam: ");
            year = scanner.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Thang khong hop le.");
            } else {
                int daysInMonth = getDaysInMonth(month, year);
                System.out.println("So ngay trong thang " + month + ", nam " + year + " la: " + daysInMonth + " ngay.");
            }
            scanner.close();
        }
    }