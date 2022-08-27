package Kafka.PublicInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import Kafka.Handlers.TopicHandler;
import Kafka.Model.Message;
import Kafka.Model.Topic;
import Kafka.Model.TopicSubscriber;

public class Kafka {
    Map<String, TopicHandler> topicHandlerMap;

    public Kafka() {
        this.topicHandlerMap = new HashMap<>();
    }

    public void createTopic(String name){
        Topic topic = new Topic(name);
        topicHandlerMap.put(topic.getId(), new TopicHandler(topic));
    }

    public void subscribe(Topic topic, ISubscriber iSubscriber){
        topic.addSubscriber(new TopicSubscriber(iSubscriber));
    }

     public void publish(Topic topic, Message message){
        topic.addMessage(message);
        new Thread(() -> topicHandlerMap.get(topic.getId()).publish()).start();
     }

     public void resetOffset(Topic topic, ISubscriber iSubscriber, Integer offset){
        for(TopicSubscriber subscriber : topic.getTopicSubscribers()){
            if(subscriber.getiSubscriber().getId().equals(iSubscriber.getId())){
                subscriber.setOffset(new AtomicInteger(offset));
                new Thread(() -> topicHandlerMap.get(topic.getId()).subscribeWorkerMap(subscriber)).start();
                break;
            }
        }
     }
    
}
