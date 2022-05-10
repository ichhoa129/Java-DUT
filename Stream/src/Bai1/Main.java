package Bai1;

/*
* Nhap so nguyen duong m. sau do in ra tong & tich cac chu so cua m
* ( m = 234 S = 9, P = 24
*
*
* */

import java.io.*;

public class Main {

    public int nhapSo() throws IOException
    {
        InputStreamReader luongVao = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(luongVao);
        String s = br.readLine();
        return Integer.parseInt(s);
    }

    public void TinhTongTich(int m)
    {
        int S = 0, P = 1;
        while (m != 0)
        {
            S += m%10;
            P *= m%10;
            m /= 10;
        }
        System.out.println("S = " + S);
        System.out.println("P = " + P);
    }

    public static void main(String[] args) {
        Main main = new Main();
        try {
            System.out.print("Nhap m: ");
            int m = main.nhapSo();
            main.TinhTongTich(m);
        } catch (Exception err) {
        }
    }
}
