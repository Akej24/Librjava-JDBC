import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public interface Options {

    static void option1(Scanner scanner) throws SQLException {
        Messages.TITLE.print();
        String title = scanner.next();
        Messages.AUTHOR.print();
        String author = scanner.next();
        Messages.RELEASE_DATE.print();
        String releaseDate = scanner.next();
        Messages.NUMBER_OF_PAGES.print();
        int numberOfPages = scanner.nextInt();
        Messages.PRICE.print();
        int price = scanner.nextInt();
        Statement addToDatabase = Main.databaseConnection.createStatement();
        String sql = "INSERT INTO librjava(title, author, releaseDate, numberOfPages, price) " +
                "VALUES('"+title+"', '"+author+"', '"+releaseDate+"', "+numberOfPages+", "+price+");";
        addToDatabase.executeUpdate(sql);
    }

    static void option2(Scanner scanner) throws SQLException {
        System.out.println("Give the ID of the book to be edited: ");
        int idOfBookToEdit = scanner.nextInt();
        Messages.ELEMENT_TO_EDIT.print();
        int parameterOfBookToEdit = scanner.nextInt();
        System.out.println("Replace this data with: ");
        String modifiedData = scanner.next();
        String sql = "";
        switch (parameterOfBookToEdit) {
            case 1 -> sql = String.format("UPDATE librjava SET title = '%s' WHERE id = %d;", modifiedData, idOfBookToEdit);
            case 2 -> sql = String.format("UPDATE librjava SET author = '%s' WHERE id = %d;", modifiedData, idOfBookToEdit);
            case 3 -> sql = String.format("UPDATE librjava SET releaseDate = '%s' WHERE id = %d;", modifiedData, idOfBookToEdit);
            case 4 -> sql = String.format("UPDATE librjava SET numberOfPages = '%s' WHERE id = %d;", modifiedData, idOfBookToEdit);
            case 5 -> sql = String.format("UPDATE librjava SET price = '%s' WHERE id = %d;", modifiedData, idOfBookToEdit);
            case 6 -> sql = String.format("UPDATE librjava SET status = '%s' WHERE id = %d;", modifiedData, idOfBookToEdit);
            default -> System.out.println("Enter a valid ID or element to be edited!");
        }
        Statement editRecordWhereId = Main.databaseConnection.createStatement();
        editRecordWhereId.executeUpdate(sql);
    }

    static void option3(Scanner scanner) throws SQLException {
        System.out.println("Give the ID of the book to be deleted");
        int id = scanner.nextInt();
        Statement removeFromDatabase = Main.databaseConnection.createStatement();
        String sql = "DELETE FROM librjava WHERE id IN (" + id + ");";
        removeFromDatabase.executeUpdate(sql);
    }

    static void option4() throws SQLException {
        Statement printDatabase = Main.databaseConnection.createStatement();
        ResultSet resultSet = printDatabase.executeQuery("SELECT * FROM librjava;");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnsNumber = resultSetMetaData.getColumnCount();
        while (resultSet.next()) {
            for(int i = 1 ; i <= columnsNumber; i++){
                System.out.print(resultSet.getString(i) + " ");
            }
            System.out.println();
        }
    }
}
