package edu.ukd;

import edu.ukd.util.DurationType;
import edu.ukd.util.Timer;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer();
        timer.start();

        ThreadGroup threadGroup = new ThreadGroup("My Group");

        FirstThread firstThread = new FirstThread(threadGroup, "First Thread");
        Thread secondThread = new Thread(threadGroup, new SecondThread(), "Second Thread");
        Thread thirdThread = new Thread(Main::printThreadInfo);

        firstThread.start();
        secondThread.start();
        thirdThread.start();

        Thread.sleep(2000);

        System.out.println("Main Thread started : ");

        Thread current = Thread.currentThread();
        System.out.println("\tName : " + current.getName());
        System.out.println("\tGroup : " + current.getThreadGroup());
        System.out.println("\tPriority : " + current.getPriority());

        firstThread.join();
        secondThread.join();
        thirdThread.join();

        System.out.println("Main Thread finished");

        timer.stop();
        System.out.println("Duration : " + timer.duration(DurationType.SECONDS) + " seconds");
    }

    public static void printThreadInfo() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Third Thread started : ");

        Thread current = Thread.currentThread();
        System.out.println("\tName : " + current.getName());
        System.out.println("\tGroup : " + current.getThreadGroup());
        System.out.println("\tPriority : " + current.getPriority());
    }
}

class FirstThread extends Thread {

    public FirstThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("First Thread started : ");

        Thread current = Thread.currentThread();
        System.out.println("\tName : " + current.getName());
        System.out.println("\tGroup : " + current.getThreadGroup());
        System.out.println("\tPriority : " + current.getPriority());
    }
}

class SecondThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Second Thread started : ");

        Thread current = Thread.currentThread();
        System.out.println("\tName : " + current.getName());
        System.out.println("\tGroup : " + current.getThreadGroup());
        System.out.println("\tPriority : " + current.getPriority());
    }
}