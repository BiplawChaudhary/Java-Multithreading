//Class that extends the Thread class
class NewThread1 extends Thread{
    //Property of thread
    Thread t;

    //Default COnstructor that creates an instance of thread for each object.
    public NewThread1(){
        t = new Thread(this, "Child Thread");
        System.out.println("Child Thread Created: "+ t);
    }

    //Method in Thread Class that must be overrided by the extending method
    //Every code for multithreading goes here
    @Override
    public void run(){
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
public class ThreadClassImpl {
    public static void main(String[] args) {
        //Creating an instance of NewThread1 class which inturns creates a new thread.
        NewThread1 nt = new NewThread1();

        //Starting the new thread, which makes a call to run method in the thread
        nt.t.start();

        //Doing Something in the main thread.
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
