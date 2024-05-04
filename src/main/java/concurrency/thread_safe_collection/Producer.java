package concurrency.thread_safe_collection;

import java.util.List;

class Producer implements Runnable
{
    private final List<Integer> taskQueue;
    private final int           MAX_CAPACITY;

    public Producer(List<Integer> sharedQueue, int size)
    {
        this.taskQueue = sharedQueue;
        this.MAX_CAPACITY = size;
    }

    @Override
    public void run()
    {
        int counter = 0;
        while (true)
        {
            try
            {
                produce(counter++);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException
    {
        synchronized (taskQueue)
        {
            while (taskQueue.size() == MAX_CAPACITY)
            {
                System.out.println("Producer: Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + taskQueue.size());
                taskQueue.wait();
            }

            //Thread.sleep(1000);
            if(!Thread.currentThread().isInterrupted()) {
                taskQueue.add(i);
                System.out.println("Produced order request : " + i);
            }
            if(i > 20)
                Thread.currentThread().interrupt();
            taskQueue.notifyAll();
        }
    }
}
