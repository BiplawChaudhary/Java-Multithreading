
//Say that we didn't code the NotSynchronized.java Callme method
//But we want its methods to be synchronized.
//We do it as below

import javax.swing.plaf.TableHeaderUI;
import java.lang.annotation.Target;

class Callee implements Runnable{
    String msg;
    Callme target;
    Thread t;

    public Callee(Callme targ, String txt){
        target = targ;
        msg = txt   ;
        t = new Thread(this);
    }

    @Override
    public void run() {
        //Synchronized calls to method
        synchronized (target){ //Synchronized method
            target.callMe(msg);
        }
    }
}

public class SynchronizedBlock {
    public static void main(String[] args) {
        //Creating an instance of the Callme class in NotSynchronized.java file
        Callme target = new Callme();

        //Crating the instance of Caller for threading
        Callee caller1 = new Callee(target, "Hello");
        Callee caller2 = new Callee(target, "Synchronzied");
        Callee caller3 = new Callee(target, "World");

        //Starting all the threads.
        caller1.t.start();
        caller2.t.start();
        caller3.t.start();

        //Waiting for the threads to end
        try {
            caller1.t.join();
            caller2.t.join();
            caller3.t.join();
        } catch (InterruptedException e) {
            System.out.println("INterrupted.");
        }
    }
}
