package Kafka.PublicInterface;

import Kafka.Model.Message;

public interface ISubscriber{
    String getId();
    void consume(Message message);
}