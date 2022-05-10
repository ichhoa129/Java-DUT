package Sleepp;

public class A extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50000 ; i++) {
            System.out.println("adu");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e ) {

            }
        }
    }

    public synchronized void test() {

    }
}

