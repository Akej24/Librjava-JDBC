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
        String sql = String.format(SQLQueries.INSERT_INTO.getQuery(), title, author, releaseDate, numberOfPages, price);
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
            case 1 -> sql = SQLQueries.SET_TITLE_WHERE_ID.getQuery();
            case 2 -> sql = SQLQueries.SET_AUTHOR_WHERE_ID.getQuery();
            case 3 -> sql = SQLQueries.SET_RELEASE_DATE_WHERE_ID.getQuery();
            case 4 -> sql = SQLQueries.SET_NUMBER_OF_PAGES_WHERE_ID.getQuery();
            case 5 -> sql = SQLQueries.SET_PRICE_WHERE_ID.getQuery();
            case 6 -> sql = SQLQueries.SET_STATUS_WHERE_ID.getQuery();
            default -> System.out.println("Enter a valid ID or element to be edited!");
        }
        String result = String.format(sql, modifiedData, idOfBookToEdit);

        Statement editRecordWhereId = Main.databaseConnection.createStatement();
        editRecordWhereId.executeUpdate(result);
    }

    static void option3(Scanner scanner) throws SQLException {
        System.out.println("Give the ID of the book to be deleted");
        int id = scanner.nextInt();

        Statement removeFromDatabase = Main.databaseConnection.createStatement();
        String sql = String.format(SQLQueries.DELETE_WHERE_ID.getQuery(), id);
        removeFromDatabase.executeUpdate(sql);
    }

    static void option4() throws SQLException {
        Statement printDatabase = Main.databaseConnection.createStatement();
        ResultSet resultSet = printDatabase.executeQuery(SQLQueries.SELECT_ALL.getQuery());
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
