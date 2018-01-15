package com.demo.springdubbo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private static Class CLAZZ = App.class;

    private static volatile boolean running = true;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_application.xml");
        context.start();
        addHook(context);
        keepAlive();
        System.out.println( "********* App Started ! *********" );
    }

    private  static void addHook(final ClassPathXmlApplicationContext context){
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                    try {
                        context.close();
                        context.stop();
                        System.out.println("Dubbo stopped!");
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                    synchronized (CLAZZ) {
                        running = false;
                        CLAZZ.notify();
                    }
            }
        });
    }

    private  static void keepAlive() {
        (new Thread() {
            public void run() {
                while(running) {
                    try {
                        Class ex = App.class;
                        synchronized(App.class) {
                            App.class.wait();
                        }
                    } catch (InterruptedException var4) {
                    }
                }

            }
        }).start();
    }
}
