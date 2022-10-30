import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main implements Options {
    public static Connection databaseConnection = DatabaseConnection.connectToDataBase();
    static Scanner scanner;
    static boolean isProgramWorking = true;
    public static void main(String[] args) throws SQLException {
        while(isProgramWorking){
            scanner = new Scanner(System.in);
            try {
                runMenu();
            }catch(InputMismatchException | IndexOutOfBoundsException e){
                System.out.println("Invalid input, try again");
            }
        }
    }
    public static void runMenu() throws SQLException {
        System.out.println("""
                        Welcome to Librjava, select an action:
                        [1] Add a book
                        [2] Edit a book
                        [3] Delete a book
                        [4] Show books database
                        [5] Exit the program""");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> Options.option1(scanner);
            case 2 -> Options.option2(scanner);
            case 3 -> Options.option3(scanner);
            case 4 -> Options.option4();
            case 5 -> isProgramWorking = false;
            default -> System.out.println("Enter a valid number!");
        }
        System.out.println("----------------------");
    }
}
