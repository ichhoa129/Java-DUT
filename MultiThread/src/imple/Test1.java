package imple;

public class Test1 {
    public static void main(String[] args) {
        Thread dt1 = new Thread(new MultiThread());
        dt1.setPriority(1);
        Thread dt2 = new Thread(new MultiThread());
        dt2.setPriority(5);
        dt1.start();
        dt2.start();
    }
}

