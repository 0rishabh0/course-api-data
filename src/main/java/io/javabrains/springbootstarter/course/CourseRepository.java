package io.javabrains.springbootstarter.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,String> { // All CRUD operations are handled in CrudRepository

    public List<Course> findByTopicId(String topicId);  // using a certain convention for naming methods will help Spring Data
                                                     // JPA identify its implementation like findByName, findByDescription,findByTopicId

}
