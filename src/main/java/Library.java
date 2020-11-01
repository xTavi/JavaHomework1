import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@ComponentScan
public class Library {

    private final Map<Integer, Book> books;

    public Library() {
        books = new HashMap<>();
        addBooks();
    }

    private void addBooks() {
        Book book1 = new Book("Casuta din padure", "Unknown", false);
        Book book2 = new Book("Alba ca Zapada", "Fratii Grimm", true);
        Book book3 = new Book("Amintiri din Copilarie", "Ion Creanga", false);
        Book book4 = new Book("Poezii", "Mihai Eminescu", true);
        Book book5 = new Book("D-l Goe", "Ion Luca Caragiale", true);

        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);
        books.put(book3.getId(), book3);
        books.put(book4.getId(), book4);
        books.put(book5.getId(), book5);

    }

    public void showAllBooks() {
        for (Map.Entry<Integer, Book> item : books.entrySet()) {
            System.out.println(item.getKey() + " --------" + item.getValue().showBook());
        }
    }

    public void showAllAvailableBooks() {
        for (Map.Entry<Integer, Book> item : books.entrySet()) {
            if(item.getValue().isFree())
                System.out.println(item.getKey() + " --------" + item.getValue().showBook());
        }
    }

    public void returnBookById(int id){
        books.get(id).setFree(true);
    }

    public void borrow(int id, User user){
        books.get(id).setFree(false);
        books.get(id).setOwner(user);
        user.setNumberOfBorrowedBooks(user.getNumberOfBorrowedBooks()+1);
    }

    public void addBook(String Name, String Author) {
        Book newBook = new Book(Name, Author, true);
        books.put(newBook.getId(), newBook);
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Title of The Book: ");
        String title = scanner.nextLine();  // Read user input

        System.out.println("Enter the Author of The Book: ");
        String author = scanner.nextLine();  // Read user input

        Book book = new Book(title, author, true);
        books.put(book.getId(), book);
        System.out.println("A fost adaugata cartea: " + book);
    }

    public void deleteBookById(int id){
        books.remove(id);
    }
}
