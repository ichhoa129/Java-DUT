package inout.bt41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bai41 {

    public int read() throws IOException {
        InputStreamReader l = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(l);
        String str = br.readLine();
        return Integer.parseInt(str);
    }
    public int UCLN(int a, int b) {
        return (b==0) ? a : this.UCLN(b, a % b);
    }

    public int BCNN(int a, int b) {
        return (a * b) / this.UCLN(a, b);
    }

    public void showAnswer(int a, int b)
    {
        System.out.print("UCLN: ");
        System.out.println(this.UCLN(a,b));
        System.out.print("BCNN: ");
        System.out.println(this.BCNN(a,b));
    }

    public static void main(String[] args) {
        bai41 m = new bai41();
        int a = 0;
        int b = 0;

        try {
            do {
                System.out.print("Nhap a: ");
                a = m.read();
                System.out.print("Nhap b: ");
                b = m.read();
            }while (a<=0 || b<=0);
            m.showAnswer(a, b);
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }
}
