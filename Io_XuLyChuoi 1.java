import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Io_XuLyChuoi {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhập chuỗi: ");
        String str = br.readLine();

        System.out.println("Chuỗi đảo ngược: " + daoNguoc(str));
        System.out.println("Chuỗi chữ hoa: " + chuHoa(str));
        System.out.println("Chuỗi chữ thường: " + chuThuong(str));
        System.out.println("Chuỗi chữ hoa và chữ thường: " + chuHoaThuong(str));
        System.out.println("Số từ trong chuỗi: " + demSoTu(str));
        System.out.println("Tần số xuất hiện của các từ: ");
        xuatTanSo(str);
    }

    private static String daoNguoc(String str) {
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        return sb.toString();
    }

    private static String chuHoa(String str) {
        return str.toUpperCase();
    }

    private static String chuThuong(String str) {
        return str.toLowerCase();
    }

    private static String chuHoaThuong(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                sb.append(Character.toLowerCase(str.charAt(i)));
            } else {
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
        }
        return sb.toString();
    }

    private static int demSoTu(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        return count + 1;
    }

    private static void xuatTanSo(String str) {
        String[] words = str.split(" ");

        int[] frequencies = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            frequencies[i] = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    frequencies[i]++;
                    frequencies[j] = 0;
                }
            }
        }

        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] != 0) {
                System.out.println(words[i] + " : " + frequencies[i]);
            }
        }
    }
}
