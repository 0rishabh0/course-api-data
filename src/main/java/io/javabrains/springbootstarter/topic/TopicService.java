package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {    // business service, will be singleton

    @Autowired
    private TopicRepository topicRepository;  // We will get an embedded DB by apache derby

//    private List<Topic> topics= new ArrayList<>(Arrays.asList(
//            new Topic("spring","Spring Framework","Spring Framework Description"),
//                new Topic("java","Core java","Core Java Description"),
//                new Topic("javascript","JavaScript","JavaScript Description")
//        ));

    public List<Topic> getAllTopics(){
        List<Topic> topics= new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
//       return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
//        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        for(int i=0;i<topics.size();i++){
//            Topic t=topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i,topic);
//                return;
//            }
//        }
        topicRepository.save(topic);       // save automatically manages INSERT/UPDATE
    }

    public void deleteTopic(String id) {
//        topics.removeIf(topic -> topic.getId().equals(id));

//        for(int i=0;i<topics.size();i++){
//            Topic t=topics.get(i);
//            if(t.getId().equals(id)){
//                topics.remove(i);
//                return;
//            }
//        }

        topicRepository.delete(id);
    }
}
