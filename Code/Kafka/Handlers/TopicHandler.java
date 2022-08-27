package Kafka.Handlers;

import java.util.HashMap;
import java.util.Map;

import Kafka.Model.Topic;
import Kafka.Model.TopicSubscriber;

public class TopicHandler {
    final Topic topic;
    Map<String, SubScribeWorker> subscribeWorkerMap;
    
    public TopicHandler(Topic topic){
        this.topic = topic;
        this.subscribeWorkerMap = new HashMap<>();
    }

    public void publish(){
        for(TopicSubscriber topicHandler: topic.getTopicSubscribers()){
            subscribeWorkerMap(topicHandler);
        }
    }

    public void subscribeWorkerMap(TopicSubscriber topicHandler) {
        if(!subscribeWorkerMap.containsKey(topicHandler.getiSubscriber().getId())){
            SubScribeWorker scribeWorker = new SubScribeWorker(topicHandler, topic);
            subscribeWorkerMap.put(topicHandler.getiSubscriber().getId(), scribeWorker);
            new Thread(scribeWorker).start();
        }
        subscribeWorkerMap.get(topicHandler.getiSubscriber().getId()).wakeupIfNeeded();
    }
}
