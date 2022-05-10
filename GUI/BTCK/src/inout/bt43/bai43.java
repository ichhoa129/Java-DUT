package inout.bt43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bai43 {

    public String read() throws IOException {
        InputStreamReader l = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(l);
        return br.readLine();
    }
    public String getReversedString(String str) {
        StringBuilder tempString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            tempString.append(str.charAt(i));
        }
        return tempString.toString();
    }

    public String getUpperString(String str) {
        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                tempString.append((char) (str.charAt(i) - 32));
            } else {
                tempString.append(str.charAt(i));
            }
        }
        return tempString.toString();
    }

    public String getLowerString(String str) {
        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                tempString.append((char) (str.charAt(i) + 32));
            } else {
                tempString.append(str.charAt(i));
            }
        }
        return tempString.toString();
    }

    public String getCombinedString(String str) {
        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                tempString.append((char) (str.charAt(i) + 32));
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                tempString.append((char) (str.charAt(i) - 32));
            } else {
                tempString.append(str.charAt(i));
            }
        }
        return tempString.toString();
    }

    public void showAnswer(String str)
    {
        System.out.println("Chuoi dao nguoc la: " + getReversedString(str));
        System.out.println("Chuoi in hoa: " + getUpperString(str) );
        System.out.println("Chuoi in thuong: " + getLowerString(str) );
        System.out.println("Chuoi ket hop: " + getCombinedString(str) );

    }

    public static void main(String[] args) {
        bai43 m = new bai43();
        String str;

        try {
            do {
                System.out.print("Nhap chuoi: ");
                str = m.read();
            }while (str.isEmpty());
            m.showAnswer(str);
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }
}
