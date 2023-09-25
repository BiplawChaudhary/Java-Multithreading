# Java-Multithreading
This repo contains the code done while learning multithreading in Java. 

## Topics Covered
<ul>
<li><b>The Main Thread: </b> Demonstration of the main thread of the program. Its in <b><i>Main.Java</i></b> file.</li>

<li><b>Creating a Thread</b>
    <ul>
        <li><b>Runnable Interface: </b> Implementing the thread using <b>Runnable</b> Interface. Its in <b><i>RunnableImplThread.Java</i></b> file.</li>
        <li><b>Thread Class: </b> Creating a Thread by extending the  <b>Thread</b> Class. Its in <b><i>ThreadClassImpl.Java</i></b> file.</li>
    </ul>
</li>

<li><b>Creating Multiple Threads: </b>Its in <b><i>MultipleThreads.java</i></b> file.</li>

<li><b>Using isAlive() and join(): </b>We want the main thread to finish last. Its in <b><i>isAliveAndJoin.Java</i></b> file.
    <ul>
        <li><b>isAlive(): </b> isAlive( ) method returns true if the thread upon which it is called is still running. 
            It returns false otherwise. </li>
        <li><b>join(): </b> This method waits until the thread on which it is called terminates</li>
    </ul>
</li>

<li><b>Thread Priorities:</b> To set a thread’s priority, use the <b><i>setPriority()</i></b> method, which is a member of Thread. </li>

<li><b>Synchronization:</b> When two or more threads need access to a shared resource, they need some way to ensure 
that the resource will be used by only one thread at a time. The process by which this is 
achieved is called <i>synchronization</i>. There is <b><i>NotSynchronized.java</i></b> file to demonstrate what happens when the methods are not synchronized.
    <ul>
        <li><b> Using Synchronized Methods:</b>To serialize access to methods, use synchronized keyword in front of methods.</li> Synchronization is shown in <b><i>SynchronizedMethod.java</i></b> file.
        <li><b> Synchronized Statements:</b> Imagine that we want to synchronize access to objects of a class that was not 
                designed for multithreaded access. Further, this class was not created by us, but by a third party, and we do not have access to 
                the source code. Thus, you can’t add synchronized to the appropriate methods within the 
                class. We simply put calls to the methods defined by this class inside a 
                synchronized block. Its in <b><i>SynchronizedBlock.java</i></b>file.</li>
    </ul>
</li>


<li><b>Interthread Communication: </b> The use of the implicit monitors in Java objects is powerful, but we can 
achieve a more subtle level of control through interprocess communication. All three methods below can be called only from 
within a synchronized context. It's in a file named <b><i>InterThreadCommunication.java</i></b>. The problem with not using ITC is shown in <b><i>ProducerConsumerWrong.java</i></b>
    <ul>
        <li><b>wait(): </b>tells the calling thread to give up the monitor and go to sleep until some other 
            thread enters the same monitor and calls <b><i>notify( )</i></b> or <b><i>notifyAll( )</i></b></li>
        <li><b>notify(): </b>wakes up a thread that called wait( ) on the same object.</li>
        <li><b>notifyAll(): </b>wakes up all the threads that called wait( ) on the same object. One of 
the threads will be granted access.</li>
    </ul>
</li>
</ul>

