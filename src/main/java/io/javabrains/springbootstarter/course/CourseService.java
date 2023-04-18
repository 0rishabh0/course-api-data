package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {    // business service, will be singleton

    @Autowired
    private CourseRepository courseRepository;  // We will get an embedded DB by apache derby

//    private List<Topic> topics= new ArrayList<>(Arrays.asList(
//            new Topic("spring","Spring Framework","Spring Framework Description"),
//                new Topic("java","Core java","Core Java Description"),
//                new Topic("javascript","JavaScript","JavaScript Description")
//        ));

    public List<Course> getAllCourses(String topicId){
        List<Course> courses = new ArrayList<>();
//        courseRepository.findAll().forEach(courses::add);
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){
//       return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        return courseRepository.findOne(id);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
//        topics.add(topic);
    }

    public void updateCourse(String id, Course course) {
//        for(int i=0;i<topics.size();i++){
//            Topic t=topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i,topic);
//                return;
//            }
//        }
        courseRepository.save(course);       // save automatically manages INSERT/UPDATE
    }

    public void deleteCourse(String id) {
//        topics.removeIf(topic -> topic.getId().equals(id));

//        for(int i=0;i<topics.size();i++){
//            Topic t=topics.get(i);
//            if(t.getId().equals(id)){
//                topics.remove(i);
//                return;
//            }
//        }

        courseRepository.delete(id);
    }
}
