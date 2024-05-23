package view;

public class Menu {
    public static void view(){
        System.out.println("" +
                " ██████╗███████╗████████╗ █████╗ ██████╗          ██╗ █████╗ ██╗   ██╗ █████╗     \n" +
                "██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗         ██║██╔══██╗██║   ██║██╔══██╗    \n" +
                "██║     ███████╗   ██║   ███████║██║  ██║         ██║███████║██║   ██║███████║    \n" +
                "██║     ╚════██║   ██║   ██╔══██║██║  ██║    ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║    \n" +
                "╚██████╗███████║   ██║   ██║  ██║██████╔╝    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║    \n" +
                " ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝      ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝    \n" +
                "==================================================================================\n");
        System.out.println("=".repeat(55));
        System.out.println("1. Add New Course");
        System.out.println("2. List Course");
        System.out.println("3. Find Course By ID");
        System.out.println("4. Find Course By Title");
        System.out.println("5. Remove Course By ID");
        System.out.println("0,99. Exit");
        System.out.println("=".repeat(55));
    }
}
