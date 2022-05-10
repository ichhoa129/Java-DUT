package inout.bt42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bai42 {

    public int read() throws IOException {
        InputStreamReader l = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(l);
        String str = br.readLine();
        return Integer.parseInt(str);
    }
    public int gerReverseNumber(int n) {
        int num = 0;
        while (n != 0) {
            num *= 10;
            num += n % 10;
            n /= 10;
        }
        return num;
    }

    public boolean isSymmetry(int n) {
        return n == gerReverseNumber(n);
    }

    public void isFibonaci(int n) {
        int a = 0, a1 = 0, a2 = 1, count = 0;
        while (a < n) {
            a = a1 + a2;
            a1 = a2;
            a2 = a;
            ++count;
        }
        if (a == n) {
            System.out.println("So " + n + " la so fibonaci o vi tri " + count);
        } else {
            System.out.println("So " + n + " khong thuoc day fibonaci");
        }
    }

    public void showAnswer(int a)
    {
        System.out.println("So dao nguoc la : " + gerReverseNumber(a));
        System.out.println("a la so doi xung " + isSymmetry(a));
        isFibonaci(a);
    }

    public static void main(String[] args) {
        bai42 m = new bai42();
        int a = 0;

        try {
            do {
                System.out.print("Nhap a: ");
                a = m.read();
            }while (a<0);
            m.showAnswer(a);
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }
}
