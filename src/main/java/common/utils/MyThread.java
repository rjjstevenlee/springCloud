package common.utils;

public class MyThread extends  Thread {

    String message;
    MyThread(String message){
        this.message = message;
    }
    @Override
    public void run(){
        for(int i=0; i<3;i++){
            System.out.println(message + " " + this.getPriority());
        }
    }

    public static void main(String[] args) {

        MyThread myThread = new MyThread("A");

        myThread.setPriority(Thread.MIN_PRIORITY);

        MyThread myThread2 = new MyThread("B");

        myThread2.setPriority(Thread.NORM_PRIORITY);

        MyThread myThread3 = new MyThread("C");

        myThread3.setPriority(Thread.MAX_PRIORITY);

        myThread.start();
        myThread2.start();
        myThread3.start();

    }

}
