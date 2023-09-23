
//Class that implements the runnable interface
class NewThread2 implements Runnable{
    //Creating a thread property
    String name; //Name of thread
    Thread t;

    //Default COnstructor that creates a thread on each object creation
    public NewThread2(String threadName){
        name = threadName; //Assigningthe received name
        //Creating a thread of that name
        t = new Thread(this, threadName);
        System.out.println(threadName + " Thread Created: "+ t);
    }

    //Method that contains the code for multithreading
    @Override
    public void run() {
        //Trying and using methods in thread.
        try{
           for(int i = 1 ; i<=4 ; i++){
               System.out.println( name + " Thread: "+ i);
               //Putting the tread to sleep
               Thread.sleep(1000);
           }
        //Handling the exception that can occour
        }catch (Exception ex){
            System.out.println(name + "Exception: " + ex.getMessage());
        }
        System.out.println("Exiting "+ name + " Thread.");
    }
}
public class MultipleThreads {
    public static void main(String[] args) {
        //Creating multiple threads
        NewThread2 nt1 = new NewThread2("One");
        NewThread2 nt2 = new NewThread2("Two");
        NewThread2 nt3 = new NewThread2("Three");

        //Starting all the threads
        nt1.t.start();
        nt2.t.start();
        nt3.t.start();

        //waiting for other threads to end
        //Doing Something in the main thread.
        try{
            //Putting the main thread to more sleep to ensure that it finishes last.
            Thread.sleep(10000);
        }catch (InterruptedException ex){
            System.out.println("Main Thread Interrupted.");
        }
        System.out.println("Exiting Main Thread.");
    }
}
