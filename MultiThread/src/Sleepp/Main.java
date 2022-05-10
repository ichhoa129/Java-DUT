package Sleepp;

public class Main {
    public static void main(String[] args) {
        new A().start();
        new B().start();
    }
}

/*
* Thread status
*
* - Runable: dang chiem CPU de thuc hien
*   + khi goi ham sleep(), suspend(), wait() thi se thanh non runnable ( blocked )
* - waiting: khi dang o runnable ma goi wait() thi se thanh waiting
* - sleep: khi dang o runnable ma goi sleep() thi se thanh sleeping
* - blocked: khi dang o runnable ma block boi I/O thi se thanh blocked
*
*
* - suspend: Khi chan luong bang suspend() thi phai goi resume() moi tiep tuc duoc
*       + suspend ko nhả tài nguyên -> deadlock ( ít dùng )
* - exception: IllegalThreadStateException
* - stop: trong truong hop dac biet, gọi stop() để kill 1 thread
* - yield: nhuong quyen dieu khien
*
* - notify: dua 1 luong bat ky ra khoi danh sach
* - notifyAll: dua tat ca cac luong ra khoi danh sach
*
* - protected void finalize( ) throws Throwable garbage collection, chi don cac doi tuong
*
* */