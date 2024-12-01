public class bai15 {
    public static void main(String[] args) {
        int P = 16;

        boolean isPerfectSquare = checkPerfectSquare(P);

        if (isPerfectSquare) {
            System.out.println(P + " là số chính phương.");
        } else {
            System.out.println(P + " không phải là số chính phương.");
        }
    }

    public static boolean checkPerfectSquare(int P) {
        int sqrt = (int) Math.sqrt(P);

        return sqrt * sqrt == P;
    }
}