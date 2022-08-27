package Kafka.Model;

import java.util.concurrent.atomic.AtomicInteger;

import Kafka.PublicInterface.ISubscriber;

public class TopicSubscriber {
    private final ISubscriber iSubscriber;
    private AtomicInteger offset;


    
    public TopicSubscriber(ISubscriber iSubscriber) {
        this.iSubscriber = iSubscriber;
        this.offset = new AtomicInteger(0);
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public void setOffset(AtomicInteger offset) {
        this.offset = offset;
    }

    public ISubscriber getiSubscriber() {
        return iSubscriber;
    }
}
