package ua.in.kupol.BasicIdea;

import java.util.concurrent.Callable;

/**
 * Created by pavelkulakovsky on 05.07.14.
 */
public class PoolThread extends Thread {
    private BlockingQueue taskQueue = null;
    private boolean       isStopped = false;

    public PoolThread(BlockingQueue queue){
        taskQueue = queue;
    }

    public void run(){
        while(!isStopped()){
            try{
                Callable callable = (Callable) taskQueue.dequeue();
                callable.call();
            } catch(Exception e){
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    public synchronized void shutdownNow(){
        isStopped = true;
        this.interrupt(); //break pool thread out of dequeue() call.
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}
