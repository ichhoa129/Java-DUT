package Bai3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String nhapString() throws IOException
    {
        InputStreamReader luongVao = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(luongVao);
        return br.readLine();
    }

    public String revertString(String text)
    {
        char[] charArray = text.toCharArray();
        String revertedText = "";
        for (int i = text.length()-1; i>=0; --i)
        {
            revertedText += charArray[i];
        }
        return revertedText;
    }

    public String upperString(String text)
    {
        String upperedString = "";
        for (int i = 0; i<text.length(); ++i)
        {
           if(text.charAt(i) >=97)
               upperedString += (char)(text.charAt(i)-32);
           else upperedString += text.charAt(i);
        }
        return upperedString;
    }
    public void tim(String m)
    {
        System.out.println("Chuoi dao nguoc: " + revertString(m));
        System.out.println("Chuoi in hoa: " + upperString(m));
    }

    public static void main(String[] args) {
        Bai3.Main main = new Bai3.Main();
        try {
            System.out.print("Nhap string: ");
            String text = main.nhapString();
            main.tim(text);
        } catch (Exception err) {
        }
    }
}
