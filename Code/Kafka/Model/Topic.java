package Kafka.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Topic {
    String id;
    String name;
    List<Message> messages;
    List<TopicSubscriber> topicSubscribers; 

    public Topic(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.messages = new ArrayList<>();
        this.topicSubscribers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public List<TopicSubscriber> getTopicSubscribers() {
        return topicSubscribers;
    }

    public void addSubscriber(TopicSubscriber topicSubscriber) {
        this.topicSubscribers.add(topicSubscriber);
    }

    
}
