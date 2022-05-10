package inout.bt44;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bai44 {
    int[] A;
    int size;

    public int readInt() throws IOException {
        InputStreamReader l = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(l);
        String str = br.readLine();
        return Integer.parseInt(str);
    }

    public int getTotalOdd(){
        int total = 0;
        for (int i : this.A) {
            if(i%2 !=0 && i > 0)
                total+=i;
        }
        return total;
    }

    public void findK() throws IOException {
        int k;
        System.out.print("Nhap so K: ");
        k = this.readInt();

        for (int i =0 ; i < this.size; ++i)
        {
            if (i == k)
            {
                System.out.println("So " + k + " nam o vi tri thu " + i);
                return;
            }
        }
        System.out.println("Khong tim thay so " + k);
    }
    public void sortArr(){
        for (int i =0 ; i< this.size - 1; ++i)
            for(int j = i+1; j<this.size; ++ j)
            {
                if (this.A[i] > this.A[j])
                {
                    int temp = this.A[i];
                    this.A[i] = this.A[j];
                    this.A[j] = temp;
                }
            }

        for (int num : this.A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public void insertP() throws IOException {
        int p;
        System.out.print("Nhap P: ");
        p = this.readInt();

        int[] newArr = new int[++this.size];

        System.arraycopy(this.A, 0, newArr, 0, this.size-1);

        newArr[this.size-1] = p;
        this.A = newArr;
        sortArr();
    }

    public void showAnswer()
    {
        try {
            System.out.println("Tong so le: " + getTotalOdd());
            findK();
            sortArr();
            insertP();
        }catch (Exception error)
        {
            System.out.println(error.getMessage());
        }

    }

    public void readArray() throws IOException {
        int[] tempArr = new int[this.size];
        for (int i = 0; i<this.size; ++i)
        {
            System.out.print("A[" + i + "]: ");
            tempArr[i] = this.readInt();
        }
        this.A = tempArr;
    }


    public static void main(String[] args) {
        bai44 m = new bai44();

        try {

            System.out.print("Nhap n: ");
            m.size = m.readInt();

            m.readArray();
            m.showAnswer();
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }
}
