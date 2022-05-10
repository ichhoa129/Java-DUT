package inout.bt45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bai45 {
    int[][] A;
    int row;
    int col;
    int[] XI;
    public int readInt() throws IOException {
        InputStreamReader l = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(l);
        String str = br.readLine();
        return Integer.parseInt(str);
    }

    public int getMul3(){
        int res = 1;
        for (int i : this.A[0]) {
            if(i%3 ==0 && i > 0)
                res *=i;
        }
        return res;
    }

    public void createArrXi() throws IOException {
        int[] temp = new int[this.row];
        int max = 0;

       for (int i = 0; i< this.row; ++i)
       {
           for(int j = 0; j < this.col; ++j)
           {
               if(this.A[i][j] > max)
                   max = this.A[i][j];
           }
           temp[i] = max;
       }

        this.XI = temp;
    }

    public void deleteFirstElement(){
        int[] temp = new int[this.row - 1];

        System.arraycopy(this.XI, 1, temp, 0, this.row-1);

        this.XI = temp;

        for (int num : this.XI) {
            System.out.print(num + " ");
        }
    }



    public void showAnswer()
    {
        try {
            System.out.println("Tich so boi 3: " + getMul3());
            createArrXi();
            deleteFirstElement();
        }catch (Exception error)
        {
            System.out.println(error.getMessage());
        }

    }

    public void readArray() throws IOException {
        int[][] tempArr = new int[this.row][this.col];
        for (int i = 0; i<this.row; ++i)
        {
            for (int j = 0; j<this.col; ++j)
            {
                System.out.print("A[" + i + "][" + j + "]: ");
                tempArr[i][j] = this.readInt();
            }
            System.out.println();
        }
        this.A = tempArr;
    }


    public static void main(String[] args) {
        bai45 m = new bai45();

        try {

            System.out.print("Nhap row: ");
            m.row = m.readInt();
            System.out.print("Nhap col: ");
            m.col = m.readInt();

            m.readArray();
            m.showAnswer();
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }
}
