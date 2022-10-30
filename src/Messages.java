public enum Messages {
    TITLE("Give the title: "),
    AUTHOR("Give the author: "),
    RELEASE_DATE("Give the release date: "),
    NUMBER_OF_PAGES("Give the number of pages: "),
    PRICE("Give the author: "),
    ELEMENT_TO_EDIT("""
                Give the element to be edited: ""
                [1] Title
                [2] Author
                [3] ReleaseDate
                [4] NumberOfPages
                [5] Price
                [6] Status"""),
    MENU("""
                Welcome to Librjava, select an action:
                [1] Add a book
                [2] Edit a book
                [3] Delete a book
                [4] Show books database
                [5] Exit the program""");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    void print(){
        System.out.println(message);
    }
}
