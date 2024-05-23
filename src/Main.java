import exception.UserNotFound;
import service.CourseServiceImp;
import view.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        CourseServiceImp service = new CourseServiceImp();
        Menu.view();
        while (true) {
            try {
                System.out.print("Choose your option: ");
                int op = new Scanner(System.in).nextInt();
                switch (op) {
                    case 1 -> service.addNewCourse();
                    case 2 -> service.listCourse();
                    case 3 -> {
                        System.out.println("=".repeat(55));
                        System.out.print("Find course by ID: ");
                        Integer id = new Scanner(System.in).nextInt();
                        service.findCourseByID(id);
                        System.out.println("=".repeat(55));
                    }
                    case 4 -> {
                        System.out.println("=".repeat(55));
                        try{
                            System.out.print("Find course by Title: ");
                            String title = new Scanner(System.in).nextLine().toLowerCase().trim();
                            service.findCourseByTitle(title);
                        }catch (UserNotFound userNotFound) {
                            System.out.println(userNotFound.getMessage());
                        }
                        System.out.println("=".repeat(55));
                    }
                    case 5 -> {
                        try {
                            System.out.print("Remove course by ID: ");
                            Integer id = new Scanner(System.in).nextInt();
                            service.removeCourseByID(id);
                        }catch (UserNotFound userNotFound) {
                            System.out.println(userNotFound.getMessage());
                        }
                    }
                    case 0,99 -> System.exit(0);
                }
            }catch (InputMismatchException inputMismatchException){
                System.out.println("=".repeat(55));
                System.out.println("Invalid input, please try again!");
                System.out.println("=".repeat(55));
            } catch (UserNotFound e) {
                throw new RuntimeException(e);
            }
        }
    }
}
