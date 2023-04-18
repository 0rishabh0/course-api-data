package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping(value="/topics/{id}")  // having same name "id" in value and arguments to below function automatically maps them
    public Topic getTopic(@PathVariable String id){   // annotation tells Spring mvc that request params are passed as path variable in URI
        return topicService.getTopic(id);
    }

    @RequestMapping(value="/topics",method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic){    // annotation used to pick topic instance from request body
        topicService.addTopic(topic);
    }

    @RequestMapping(value="/topics/{id}",method = RequestMethod.PUT)
    public void updateTopic(@PathVariable String id,@RequestBody Topic topic){    // annotation used to pick topic instance from request body
        topicService.updateTopic(id,topic);                                       // and PathVariable maps id
    }

    @RequestMapping(value="/topics/{id}",method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }

}
