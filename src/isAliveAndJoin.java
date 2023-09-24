
//Creating a thread class
class ThreadClass implements Runnable{
    //Properties
    String name;
    Thread t;

    //Creating a constructor that creates an instance of Thread on
    //Creating an object of ThreadClass.
    public ThreadClass(String threadName){
        name = threadName; //Assigning the thread name
        //Creating the thread for the invoking object
        //with the name specified.
        t = new Thread(this, threadName);
        System.out.println(name + " Thread Created.");
    }

    //Overriding method contains the code for multithreading
    @Override
    public void run() {
        try{
            for(int i=1;i<=5;i++){
                System.out.println(name + " Thread Running: "+ i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException ex){
            System.out.println(name + " Thread Interrupted.");
        }
        System.out.println("Exiting "+ name + " thread.");
    }
}
public class isAliveAndJoin {
    public static void main(String[] args) {
        //Creating multiple threads.
        ThreadClass t1 = new ThreadClass("One");
        ThreadClass t2 = new ThreadClass("Two");
        ThreadClass t3 = new ThreadClass("Three");

        //Starting the threads
        t1.t.start();
        t2.t.start();
        t3.t.start();

        //Using isAlive() to check the status of the thread
        System.out.println("Status of thead One : "+ t1.t.isAlive());
        System.out.println("Status of thead Two : "+ t2.t.isAlive());
        System.out.println("Status of thead Three : "+ t3.t.isAlive());

        //The join() method waits till the execution of the thread finishes.
        try{
            System.out.println("Waiting for threads to finish.");
            t1.t.join();
            t2.t.join();
            t3.t.join();
        }catch (InterruptedException ex){
            System.out.println("Main Thread Interrupted.");
        }

        //Using isAlive() to check the status of the thread after thread complition
        System.out.println("Status of thead One : "+ t1.t.isAlive());
        System.out.println("Status of thead Two : "+ t2.t.isAlive());
        System.out.println("Status of thead Three : "+ t3.t.isAlive());

        System.out.println("Exiting main thread.");
    }


}
