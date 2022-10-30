public enum SQLQueries {
    SET_TITLE_WHERE_ID("UPDATE librjava SET title = '%s' WHERE id = %d;"),
    SET_AUTHOR_WHERE_ID("UPDATE librjava SET author = '%s' WHERE id = %d;"),
    SET_RELEASE_DATE_WHERE_ID("UPDATE librjava SET releaseDate = '%s' WHERE id = %d;"),
    SET_NUMBER_OF_PAGES_WHERE_ID("UPDATE librjava SET numberOfPages = '%s' WHERE id = %d;"),
    SET_PRICE_WHERE_ID("UPDATE librjava SET price = '%s' WHERE id = %d;"),
    SET_STATUS_WHERE_ID("UPDATE librjava SET status = '%s' WHERE id = %d;"),
    INSERT_INTO("INSERT INTO librjava(title, author, releaseDate, numberOfPages, price) VALUES('%s', '%s', '%s', %d, %d);"),
    DELETE_WHERE_ID("DELETE FROM librjava WHERE id IN (%d);"),
    SELECT_ALL("SELECT * FROM librjava;");

    private final String query;
    SQLQueries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
