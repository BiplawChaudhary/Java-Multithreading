
/* fixing of the preceding NotSynchronzied program, we must serialize access to call( ).
* Simply add synchronized keyword in methods */

class Callmee {
    //Method that revieces and tries to print the message in square brackets.
    synchronized void callMe(String msg){
//        It prints the opening bracket and message then the tread is put to sleep
        System.out.print("[" + msg);
        //Putting the thread to sleep
        //No other thread should be able to access this method while it's in ssleep to
        //ensure that the message is printed like [msg]
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Interrupted.");
        }
        //Then printing the closing bracket.
        System.out.print("]");
    }
}

class Callerr implements Runnable{
    String msg; //Stores the msg
    Callmee target; //Creating an object of Callme function
    Thread t; //Creating an object of Thread

    //On creating an instance of Caller,
    public Callerr(Callmee targ, String txt){
        target = targ; //Assign the target to it
        msg = txt;
        t = new Thread(this); //Create a thread for the invoking object
    }

    @Override
    public void run() {
        //On multithreading, call the callMe method of the Callme object
        target.callMe(msg);
    }
}
public class SynchronizedMethod {
    public static void main(String[] args) {
        //Creating an instance of the object
        Callmee target = new Callmee();
        //Creating a caller and passing it the instance of the target object
        //The method in target object are called by multiple threads.
        Callerr caller1 = new Callerr(target, "Hello");
        Callerr caller2 = new Callerr(target, "Synchronized");
        Callerr caller3 = new Callerr(target, "World");

        //Starting allthe threads .
        caller1.t.start();
        caller2.t.start();
        caller3.t.start();

        //Waiting for the threads to end
        try{
            caller1.t.join();
            caller2.t.join();
            caller3.t.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }
}
