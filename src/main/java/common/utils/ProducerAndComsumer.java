package common.utils;

public class ProducerAndComsumer {

    public static void main(String[] args) {
        HoldInt holdInt = new HoldInt();//holdint为监控器
        Producer producer = new Producer(holdInt);
        Consumer consumer = new Consumer(holdInt);
        producer.start();
        consumer.start();
    }
}
class HoldInt{

    private int sharedInt;
    private boolean writeAble=true;//writeAble=true 表示生产者线程能产生新数据

    public synchronized void set(int val){//临界区程序段，也称为同步方法
        while(!writeAble){
            //生产者线程不能生产新数据时进入等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //生产者被唤醒执行以下语句
        writeAble=false;
        sharedInt=val;
        notify();

    }
    public synchronized int get(){
        while(writeAble){
            //消费者线程不能消费数据时进入等待状态
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //消费者被唤醒后继续执行以下语句

        }
        writeAble=true;
        notify();
        return sharedInt;
    }
}
class Producer extends  Thread{
    private HoldInt hi;
    public Producer(HoldInt hiForm){
        hi=hiForm;
    }
    @Override
    public void run(){
        for (int i = 1; i<=4; i++) {
            hi.set(i);
            System.out.println("产生的新数据是："+i);
        }
    }
}
class Consumer extends  Thread{
    private HoldInt hi;
    public Consumer(HoldInt hiForm){
        hi = hiForm;
    }
    @Override
    public void run(){
        for (int i = 1; i<=4 ; i++) {
            int val = hi.get();
            System.out.println("读到的新数据是："+val);
        }
    }
}