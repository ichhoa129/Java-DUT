package Sleepp;

public class B extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("vjp");
            try {
                Thread.sleep(2500);
            }
            catch (InterruptedException e ){}
        }
    }
}
