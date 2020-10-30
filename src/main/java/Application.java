

public class Application {
    public static void main(String[] args) {


        Library library = new Library();
        library.showAllBooks();
        library.addBook();
        library.deleteBookById(3);
        library.showAllBooks();
    }

}
