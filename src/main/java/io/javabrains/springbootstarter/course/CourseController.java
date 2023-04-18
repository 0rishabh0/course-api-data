package io.javabrains.springbootstarter.course;

import io.javabrains.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    } // get all courses for a topic by topic id

    @RequestMapping(value="/topics/{topicId}/courses/{id}")  // having same name "id" in value and arguments to below function automatically maps them
    public Course getCourse(@PathVariable String id){   // annotation tells Spring mvc that request params are passed as path variable in URI
        return courseService.getCourse(id);
    }

    @RequestMapping(value="/topics/{topicId}/courses",method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){    // annotation used to pick topic instance from request body
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(value="/topics/{topicId}/courses/{id}",method = RequestMethod.PUT)
    public void updateCourse(@PathVariable String topicId,@PathVariable String id,@RequestBody Course course){    // annotation used to pick topic instance from request body
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(id, course);                                       // and PathVariable maps id
    }

    @RequestMapping(value="/topics/{topicId}/courses/{id}",method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }

}
