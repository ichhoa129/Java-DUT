package Bai2;

/*
* Tim UCLN BCNN cua 2 so nguyen duong a va b
*
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public int nhapSo() throws IOException
    {
        InputStreamReader luongVao = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(luongVao);
        String s = br.readLine();
        return Integer.parseInt(s);
    }
    public int UCLN(int a, int b) {
        return (b==0) ? a : UCLN(b, a % b);
    }

    public int BCNN(int a, int b, int bcnn) {
        return (a * b) / bcnn;
    }
    public void TimUCLNBCNN(int a, int b)
    {
       int ucln = UCLN(a, b);
       int bcnn = BCNN(a, b , ucln);
        System.out.println("UCLN = " + ucln);
        System.out.println("BCNN = " + bcnn);
    }

    public static void main(String[] args) {
        Bai2.Main main = new Bai2.Main();
        try {
            System.out.print("Nhap a: ");
            int a = main.nhapSo();
            System.out.print("Nhap b: ");
            int b = main.nhapSo();
            main.TimUCLNBCNN(a, b);
        } catch (Exception err) {
        }
    }
}
