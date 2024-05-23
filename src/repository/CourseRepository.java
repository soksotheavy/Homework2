package repository;

import exception.UserNotFound;
import model.Course;
import service.CourseService;
import service.CourseServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CourseRepository {
    static List<Course> courses = new ArrayList<>();

    public static void getCourses() {
        CourseService courseService = new CourseService() {
            @Override
            public void addNewCourse() {

            }

            @Override
            public void listCourse() {

            }

            @Override
            public String localDate() {
                return "";
            }

            @Override
            public Course findCourseByID(Integer id) throws UserNotFound {
                return null;
            }

            @Override
            public Course findCourseByTitle(String title) throws UserNotFound {
                return null;
            }

            @Override
            public void removeCourseByID(Integer id) throws UserNotFound {

            }
        };
        Random random = new Random();
        String date = courseService.localDate();
        try {
            int arr[] = {0,1,2,3,4,5,6,7,8,9};
            System.out.print("[+] Insert course title: ");
            String title = new Scanner(System.in).nextLine();
            for (int arr1 : arr) {
                if (title.contains(String.valueOf(arr1))) {
                    throw new UserNotFound("Invalid input title: " + title);
                }
            }
            System.out.print("[+] Insert instructor names: ");
            String[] instructor = new Scanner(System.in).nextLine().split(",");
            for (int arr1 : arr) {
                for (String instructor1 : instructor) {
                    if (instructor1.contains(String.valueOf(arr1))) {
                        throw new UserNotFound("Invalid input instructor: " + instructor1);
                    }
                }
            }
            System.out.print("[+] Insert course requirement: ");
            String[] requirement = new Scanner(System.in).nextLine().split(",");
            for (int arr1 : arr) {
                for (String requirement1 : requirement) {
                    if (requirement1.contains(String.valueOf(arr1))) {
                        throw new UserNotFound("Invalid input requirement: " + requirement1);
                    }
                }
            }
            courses.add(new Course(random.nextInt(1000),title,instructor,requirement,date));
        }catch (UserNotFound userNotFound) {
            System.out.println(userNotFound.getMessage());
        }
    }
    public static List<Course> storeCourse() {
        return courses;
    }
}
