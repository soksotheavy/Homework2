package service;

import exception.UserNotFound;
import model.Course;

public interface CourseService {
     void addNewCourse();
     void listCourse();
     String localDate();
     Course findCourseByID(Integer id) throws UserNotFound;
     Course findCourseByTitle(String title) throws UserNotFound;
     void removeCourseByID(Integer id) throws UserNotFound;
}
