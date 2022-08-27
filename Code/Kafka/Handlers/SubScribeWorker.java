package Kafka.Handlers;

import Kafka.Model.Topic;
import Kafka.Model.TopicSubscriber;

public class SubScribeWorker implements Runnable{
    TopicSubscriber subscriber;
    Topic topic;

    
    public SubScribeWorker(TopicSubscriber subscriber, Topic topic) {
        this.subscriber = subscriber;
        this.topic = topic;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            synchronized (subscriber){
                int offset = subscriber.getOffset().intValue();
                while(offset >= topic.getMessages().size()){
                    try{
                        subscriber.wait();
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                subscriber.getiSubscriber().consume(topic.getMessages().get(offset));
                subscriber.getOffset().compareAndSet(offset, offset+1);

            }
        }
    }

    public void wakeupIfNeeded(){
        synchronized (subscriber){
            subscriber.notify();
        }
    }
    
}
