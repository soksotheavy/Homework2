package service;

import exception.UserNotFound;
import model.Course;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import repository.CourseRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CourseServiceImp {
    public void addNewCourse(){
        CourseRepository.getCourses();
    }
    public String localDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM dd yyyy", Locale.ENGLISH);
        String formatDateTime = LocalDateTime.now().format(formatter);
        return formatDateTime;
    }
    public void listCourse(){
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        for(int i=0;i<5;i++){
            table.setColumnWidth(i,30,30);
    }
        System.out.println("=".repeat(55));
        if (!(CourseRepository.storeCourse().isEmpty())){
            table.addCell("Course ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Instructor", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Requirement", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Start Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            for (Course course: CourseRepository.storeCourse()){
                table.addCell(String.valueOf(course.getId()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(course.getTitle(),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course.getInstructor()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course.getRequirements()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(course.getDate()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            }
            System.out.println(table.render());
        }else{
            System.out.println("[+] No Course !");;
        }
        System.out.println("=".repeat(55));
        }
    public Course findCourseByID(Integer id) throws UserNotFound {
        Table table = new Table(5,BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        for(int i=0;i<5;i++){
            table.setColumnWidth(i,30,30);
        }
        var course = CourseRepository.storeCourse().stream()
                .filter(a-> a.getId().equals(id)).toList();
        if (course.isEmpty()) {
            throw new UserNotFound("[+] Not found course with ID: " + id);
        }else {
            table.addCell("Course ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Instructor", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Requirement", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Start Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            for (Course course1: course) {
                table.addCell(String.valueOf(course1.getId()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(course1.getTitle(),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course1.getInstructor()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course1.getRequirements()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(course1.getDate()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            }
            System.out.println(table.render());
        }
        return course.getFirst();
    }
    public Course findCourseByTitle(String title) throws UserNotFound {
        Table table = new Table(5,BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        for(int i=0;i<5;i++){
            table.setColumnWidth(i,30,30);
        }
        var course = CourseRepository.storeCourse().stream()
                .filter(a-> a.getTitle().toLowerCase().contains(title)).toList();
        if (course.isEmpty()) {
            throw new UserNotFound("[+] Not found course with title: " + title);
        }else {
            table.addCell("Course ID",new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Title",new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Instructor",new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Requirement",new CellStyle(CellStyle.HorizontalAlign.CENTER));
            table.addCell("Start Date",new CellStyle(CellStyle.HorizontalAlign.CENTER));
            for (Course course1: course) {
                table.addCell(String.valueOf(course1.getId()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(course1.getTitle(),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course1.getInstructor()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(Arrays.toString(course1.getRequirements()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
                table.addCell(String.valueOf(course1.getDate()),new CellStyle(CellStyle.HorizontalAlign.CENTER));
            }
            System.out.println(table.render());
        }
        return course.getFirst();
    }
    public void removeCourseByID(Integer id) throws UserNotFound {
        List<Course> courses = CourseRepository.storeCourse();
        List<Course> removeCourse = courses.stream().filter(a -> a.getId().equals(id)).toList();
        courses.removeAll(removeCourse);
        if (!(removeCourse.isEmpty()) && courses.equals(id)) {
            System.out.println("[+] Removed course with ID[" + id + "] successfully !");
        } else {
            throw new UserNotFound("[+] Not found course with ID: " + id);
        }
    }
}
