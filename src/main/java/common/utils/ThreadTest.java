package common.utils;

import java.util.Calendar;

public class ThreadTest extends  Thread{

    String threadName;
    int pauseTime;

    public ThreadTest(int pauseTime,String threadName){
           this.threadName = threadName;
           this.pauseTime = pauseTime;
    }
    @Override
    public void run(){
        Calendar now;
        int year,month,date,hour,minute,second;
        for(int i = 0; i < 10; i++){

            try {
                now = Calendar.getInstance();
                year  = now.get(Calendar.YEAR);
                month = now.get(Calendar.MONTH) + 1;
                date  = now.get(Calendar.DATE);
                hour  = now.get(Calendar.HOUR_OF_DAY);
                minute= now.get(Calendar.MINUTE);
                second= now.get(Calendar.SECOND);

                System.out.println(threadName + ":时间：" + year + "年 " + month + "月 " + date + " 日 " + hour
                        + "时 " + minute + "分 " + second + " 秒");
                Thread.sleep(pauseTime);
            } catch (InterruptedException e) {
                System.out.println("线程错误：" + e);
            }

        }
    }

    public static void main(String[] args) {

        ThreadTest threadTest1 = new ThreadTest(2000,"线程A");
        threadTest1.start();

        ThreadTest threadTest2 = new ThreadTest(2000,"线程B");

        threadTest2.start();


    }
}