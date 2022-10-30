import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public interface Options {

    static void option1(Scanner scanner) throws SQLException {
        System.out.println("Give the title: ");
        String title = scanner.next();
        System.out.println("Give the author: ");
        String author = scanner.next();
        System.out.println("Give the release date: ");
        String date = scanner.next();
        System.out.println("Give the number of pages: ");
        int numberOfPages = scanner.nextInt();
        System.out.println("Give the price: ");
        int price = scanner.nextInt();
        Statement addToDatabase = Main.databaseConnection.createStatement();
        String sql = "INSERT INTO librjava(title, author, releaseDate, numberOfPages, price) " +
                "VALUES('"+title+"', '"+author+"', '"+date+"', "+numberOfPages+", "+price+");";
        addToDatabase.executeUpdate(sql);
    }

    static void option2(Scanner scanner) throws SQLException {
        System.out.println("Give the ID of the book to be edited: ");
        int idOfBookToEdit = scanner.nextInt();
        System.out.println("""
                Give the element to be edited: ""
                [1] Title
                [2] Author
                [3] ReleaseDate
                [4] NumberOfPages
                [5] Price
                [6] Status""");
        int parameterOfBookToEdit = scanner.nextInt();
        System.out.println("Replace this data with: ");
        String modifiedData = scanner.next();
        String sql = "";
        switch (parameterOfBookToEdit) {
            case 1 -> sql = "UPDATE librjava SET title = '" + modifiedData + "' WHERE id = " +idOfBookToEdit+ ";";
            case 2 -> sql = "UPDATE librjava SET author = '" + modifiedData + "' WHERE id = " +idOfBookToEdit+ ";";
            case 3 -> sql = "UPDATE librjava SET releaseDate = '" + modifiedData + "' WHERE id = " +idOfBookToEdit+ ";";
            case 4 -> sql = "UPDATE librjava SET numberOfPages = " + modifiedData + " WHERE id = " +idOfBookToEdit+ ";";
            case 5 -> sql = "UPDATE librjava SET price = " + modifiedData + " WHERE id = " +idOfBookToEdit+ ";";
            case 6 -> sql = "UPDATE librjava SET status = " + modifiedData + " WHERE id = " +idOfBookToEdit+ ";";
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
