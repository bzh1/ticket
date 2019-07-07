package com.atguigu;

import java.util.concurrent.TimeUnit;

class Phone {
    public synchronized static void sendEmail() throws Exception  {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送email");
    }

    public synchronized  void sendSms() throws Exception {
        System.out.println("发送sms");
    }

    public void hello() {
        System.out.println("hello");
    }
}

public class Lock8 {


    /**
     *  题目：多线程8锁
     *  * 1 标准访问，请问先打印邮件还是短信？
     *  * 2 邮件方法暂停4秒钟，请问先打印邮件还是短信？
     *  * 3 新增一个普通方法hello()，请问先打印邮件还是hello？
     *  * 4 两部手机，请问先打印邮件还是短信？
     *  * 5 两个静态同步方法，同一部手机，请问先打印邮件还是短信？
     *  * 6 两个静态同步方法，2部手机，请问先打印邮件还是短信？
     *  * 7 1个普通同步方法,1个静态同步方法，1部手机，请问先打印邮件还是短信？
     *  * 8 1个普通同步方法,1个静态同步方法，2部手机，请问先打印邮件还是短信？
     *
     *  注意：：：普通方法是给对象加锁   静态方法是给类加锁
     *
     */
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone1 = new Phone();

        new Thread(()->{
            try
                {
                    phone.sendEmail();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                }
            },"A").start();
        Thread.sleep(10);
        new Thread(()->{try
            {
               // phone.sendSms();
               // phone.hello();
                phone.sendSms();
            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
        },"B").start();
    }

}
