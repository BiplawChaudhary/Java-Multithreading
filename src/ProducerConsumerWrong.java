/* INCORRECT implementation of Producer COnsumer problem.
It consists of four classes: Q, the queue that you’re trying to synchronize;
Producer, the threaded object that is producing queue entries; Consumer, the threaded
object that is consuming queue entries; and ProducerConsumerWrong, the tiny class that creates the single Q,
Producer, and Consumer.
*/

//Queue class
class Q{
    int n;

    synchronized int get(){
        System.out.println("Got: " + n);
        return n;
    }

    synchronized void put(int n){
        this.n = n;
        System.out.println("Put: "+n );
    }
}

class Producer implements Runnable{
    Q q;
    Thread t;

    Producer(Q q){
        this.q = q;
        t = new Thread(this, "Producer");
    }

    @Override
    public void run() {
        int i =0;

        while (true){
            q.put(i++);
        }
    }
}

class Consumer implements Runnable{
    Q q;
    Thread t;

    Consumer(Q q){
        this.q = q;
        t = new Thread(this, "Consumer");
    }

    @Override
    public void run() {
        while (true){
            q.get();
        }
    }
}
public class ProducerConsumerWrong {
    public static void main(String[] args) {
        Q q = new Q(); //Creating an instance of queue
        Producer producer = new Producer(q);  //Creating a producer to produce for the queue
        Consumer consumer = new Consumer(q);  //Creating a consumer to consume from the queue.

        //Starting the thread
        producer.t.start();
        consumer.t.start();

        System.out.println("Press CTRL + C to stop");
    }
}
