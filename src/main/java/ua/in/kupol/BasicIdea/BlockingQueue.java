package ua.in.kupol.BasicIdea;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pavelkulakovsky on 05.07.14.
 */
public class BlockingQueue {
    private List queue = new LinkedList();
    private int  limit = 5;

    public BlockingQueue(int limit){
        this.limit = limit;
    }


    public synchronized void enqueue(Object item)
            throws InterruptedException  {
        while(this.queue.size() == this.limit) {
            wait();
        }
        if(this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }


    public synchronized Object dequeue()
            throws InterruptedException{
        while(this.queue.size() == 0){
//            System.out.println("WAIT");
            wait();
        }
        if(this.queue.size() == this.limit){
            notifyAll();
        }

        return this.queue.remove(0);
    }
}