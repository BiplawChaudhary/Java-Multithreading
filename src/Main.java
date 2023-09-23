

public class Main {
    public static void main(String[] args) {
        //Getting the main Thread
        Thread t = Thread.currentThread();

        //Displaying the current thread info [threadName, Priority, GroupName]
        System.out.println("Current Thread: "+ t);

        //Setting the thread name to another name
        t.setName("MyThread");

        //Displaying the thread details again.
        System.out.println("Current Updated Thread: "+ t);

        //Trying to execute some method of thread
        //It can cause some exception, so it's in try catch
        try{
            //Printing some value in main thread.
            for(int i=1;i<=5;i++){
                System.out.println("Thread "+ i);
                //Putting the main thread to sleep for sometime
                Thread.sleep(2000);
            }


        //Catching the interrupted exception.
        }catch (InterruptedException e){
            System.out.println("Interrupted by another.");
        }

        //Block below the thread. Last line of main thread.
        System.out.println("Exiting Main Thread.");
    }
}


