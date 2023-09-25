//This shows the correct way to implement the producer consumer problem.
class Queue{
    int n;
    //A variable to check if the value is set for the consumer to consume
    boolean valueSet = false ;

    synchronized int get(){
        //If no value is set then wait to get the value
        while (!valueSet){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("Interrupted Exception Caught.");
            }
        }
        //Else get the value and reset valueSet to false after getting the value.
        System.out.println("Got: "+ n);
        valueSet = false;
        //Notify the other thread to access the monitor on that object.
        notify();
        //Return the number
        return n;
    }

    synchronized void put(int n){
        //If the value is then, wait till you set the next value.
        while (valueSet){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("Interrupted Exception Caught.");
            }
        }
        //if no other value are set then set the value
        this.n = n;
        //Change set value to true
        valueSet = true;
        //Output the set value
        System.out.println("Put: " + n);
        //Notify the other threads for the monitor on the object, that the object is free now.
        notify();
    }
}

class Producerr implements Runnable{
    Queue q;
    Thread t;

    Producerr(Queue q){
        this.q = q;
        t = new Thread(this, "Producer");
    }

    @Override
    public void run() {
        int i=0;
        while (true){
            q.put(i++);
        }
    }
}

class Consumerr implements Runnable{
    Queue q;
    Thread t;

    Consumerr(Queue q){
        this.q = q;
        t = new Thread(this, "Consumer");
    }


    @Override
    public void run() {
        while(true){
            q.get();
        }
    }
}
//Using the same Producer and Consumer in ProducerConsumerWrong.java file
public class InterThreadCommunication {
    public static void main(String[] args) {
        Queue queue = new Queue();

        Producerr producerr = new Producerr(queue);
        Consumerr consumer = new Consumerr(queue);

        //Starting the thread
        producerr.t.start();
        consumer.t.start();

        System.out.printf("Press CTRL + C to break.");

    }
}
