package common.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Deque;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyThread extends  Thread {
    public static final String[] encodes = new String[] { "UTF-8", "GBK", "GB2312", "ISO-8859-1", "ISO-8859-2" };
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

        String s1 = "Java application";
        char[] cc={'J','a','v','a','a','p','p','l','i','c','a','t','i','o','n'};
        int len=cc.length;
        int len1=s1.length();
        int len2="ABCD".length();
        int c1="1342GEEW".length();
        char c2=s1.charAt(2);
        int c3=s1.indexOf("l");
        System.out.println(c3);
        String s2=s1.substring(3);
        String s3=s1.substring(2,5);
        System.out.println(s2);
        System.out.println(s3);
        String s6="student";
        int d1=s6.compareTo("st");
        int d2=s6.compareTo("student");
        int d3=s6.compareTo("studentSt1");
        System.out.println("d1:"+d1+" d2: "+d2 + " d3:"+d3 );
        String s7=" I am ";
        String s8=s7.concat(" Steven ");
        String s9=s8.replace("Steven","Steven Lee");
        System.out.println(s9);
        System.out.println(s9.toLowerCase());
        System.out.println(s9.toUpperCase());
        char[] c5={'j','a','v','a'};
        System.out.println(String.valueOf(c5,2,2));

        StringBuilder sb = new StringBuilder("Hello steven");

        sb.setCharAt(0,'h');
        sb.setCharAt(6,'S');

        System.out.println(sb.toString());
        System.out.println(sb.insert(2," Lee "));


    }

    public static void main2(String[] args) {


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
    public static String getEncode(String str) {
        byte[] data = str.getBytes();
        byte[] b = null;
        a:for (int i = 0; i < encodes.length; i++) {
            try {
                b = str.getBytes(encodes[i]);
                if (b.length!=data.length){
                    continue;
                }
                for (int j = 0; j < b.length; j++) {
                    if (b[j] != data[j]) {
                        continue a;
                    }
                }
                return encodes[i];
            } catch (UnsupportedEncodingException e) {
                continue;
            }
        }
        return null;
    }
    public static String transcoding(String str, String encode) {
        String df = "ISO-8859-1";
        try {
            String en = getEncode(str);
            if (en == null){
                en = df;
            }
            return new String(str.getBytes(en), encode);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

}
