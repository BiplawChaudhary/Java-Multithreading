class NewThread implements Runnable{
    //Creating a property for thread.
    Thread t;

    //Constructor
    public NewThread(){
        //On creating instance of NewThread, automatically create a thread t
        //new Thread(
        t = new Thread(this, "New Thread");
//        Displaying the details of the child thread created
        System.out.println("Child Thread Created: " + t);
    }

    //Method in Runnable Interface that must be overrided by the implementing method
    //Every code for multithreading goes here
    @Override
    public void run() {
        //Trying to do something
        try{
            for(int i=1;i<=5;i++){
                System.out.println("Child Thread: "+ i);
                //Putting the child thread to sleep
                Thread.sleep(1000);
            }
        //Catching the interrupted exception
        }catch (InterruptedException e){
            System.out.println("Child Interrupted." + e.getMessage());
        }
        System.out.printf("Exiting Child Thread.");
    }
}
public class RunnableImplThread {
    public static void main(String[] args) {
        //Creating a new thread which in terms creates a thread.
        NewThread nt = new NewThread();

        //Starting the thread, which is a call to the overrided run method of class
        //object.property.method();
        //This starts the child thread
        nt.t.start();

        //Doing something in the main thread.
        try{
            for(int i=1;i<=5;i++){
                System.out.println("Main Thread: "+ i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Main Thread Interrupted"+ e.getMessage());
        }
        System.out.println("Exiting Main Thread.");
    }

}
