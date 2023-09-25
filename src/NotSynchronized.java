
//Program to demonstrate the unsynchronized thread

class Callme{
    //Method that revieces and tries to print the message in square brackets.
    void callMe(String msg){
//        It prints the opening bracket and message then the tread is put to sleep
        System.out.println("[" + msg);
        //Putting the thread to sleep
        //No other thread should be able to access this method while it's in ssleep to
        //ensure that the message is printed like [msg]
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("Interrupted.");
        }
        //Then printing the closing bracket.
        System.out.println("]");
    }
}

class Caller implements Runnable{
    String msg; //Stores the msg
    Callme target; //Creating an object of Callme function
    Thread t; //Creating an object of Thread

    //On creating an instance of Caller,
    public Caller(Callme targ, String txt){
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
public class NotSynchronized {
    public static void main(String[] args) {
        //Creating an instance of the object
        Callme target = new Callme();
        //Creating a caller and passing it the instance of the target object
        //The method in target object are called by multiple threads.
        Caller caller1 = new Caller(target, "Hello");
        Caller caller2 = new Caller(target, "Synchronized");
        Caller caller3 = new Caller(target, "World");

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
/*The output will be:
[Hello
[World
[Synchronized
]
]
]

It is because after the first threads msg is printed, it goes to sleep and 2nd thread comes to play.
Then after 2nd thread prints the msg, is goes to sleep and third comes to play before printing ].
Then after the threads wake up, they gain the CPU again and print the ].
*/