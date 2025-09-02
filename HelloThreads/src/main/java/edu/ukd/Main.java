package edu.ukd;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FirstThread firstThread = new FirstThread();
        Thread secondThread = new Thread(new SecondThread());

        firstThread.start();
        secondThread.start();

        Thread.sleep(5000);

        Thread current = Thread.currentThread();
        System.out.println("Name : " + current.getName());
        System.out.println("Group : " + current.getThreadGroup());
        System.out.println("Priority : " + current.getPriority());
    }
}

class FirstThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("First Thread works");
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
        System.out.println("Second Thread works");
    }
}