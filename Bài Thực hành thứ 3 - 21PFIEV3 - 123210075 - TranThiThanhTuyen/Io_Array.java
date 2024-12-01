import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Io_Array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nhập số phần tử của mảng: ");
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            a[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Tổng các số dương lẻ của mảng a là: " + tinhTongSoDuongLe(a));
        System.out.println(" Phần tử k có xuất hiện trong mảng a hay không? " + kiemTraXuatHien(a, Integer.parseInt(br.readLine())));
        sapXepTangDan(a);
        System.out.println("Mảng a sau khi sắp xếp tăng dần: ");
        xuatMang(a);
        chenP(a, Integer.parseInt(br.readLine()));
        System.out.println(" Mảng a sau khi chèn phần tử p: ");
        xuatMang(a);
    }





        private static int tinhTongSoDuongLe(int[] a) {
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] > 0 && a[i] % 2 == 1) {
                    sum += a[i];
                }
            }
            return sum;
        }

        private static boolean kiemTraXuatHien(int[] a, int k) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == k) {
                    return true;
                }
            }
            return false;
        }

        private static void sapXepTangDan(int[] a) {
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] > a[j]) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
        }

        private static void chenP(int[] a, int p) {
            int i = 0;
            while (i < a.length && a[i] < p) {
                i++;
            }
            for (int j = a.length - 1; j > i; j--) {
                a[j] = a[j - 1];
            }
            a[i] = p;
        }

        private static void xuatMang(int[] a) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
