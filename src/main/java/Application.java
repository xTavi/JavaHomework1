import configuration.ProjectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Library;
import service.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

//        Library library = new Library();

        User user1 = new User("Mihai", "Home1");
        User user2 = new User("Mihai", "Home1");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        Library library = context.getBean(Library.class);


        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome! Choose your option: \n" +
                    "1. See all books we have \n" +
                    "2. See all available books \n" +
                    "3. Delete a book by id \n" +
                    "4. Return a book \n" +
                    "5. Borrow a book \n" +
                    "6. Add a new book \n" +
                    "7. Exit \n");

            while(true){
                System.out.println("Your option: \n");
                int option = scanner.nextInt();
                if(option < 1 || option > 7) {
                    System.out.println("Please select a valid option \n");
                }

                switch (option){
                    case 1:
                        library.showAllBooks();
                        break;

                    case 2:
                        library.showAllAvailableBooks();
                        break;

                    case 3:
                        System.out.println("Enter the id of the book you want to delete: ");
                        int id = scanner.nextInt();
                        library.deleteBookById(id);
                        break;

                    case 4:
                        System.out.println("Enter the id of the book you want to return: ");
                        int borrowedBookId = scanner.nextInt();
                        library.returnBookById(borrowedBookId);
                        break;

                    case 5:
                        System.out.println("Enter the id of the book you want to borrow: ");
                        int bookToBorrowId = scanner.nextInt();
                        library.borrow(bookToBorrowId, user1);
                        break;
                    case 6:
                        library.addBook();
                        break;

                    case 7:
                        return;

                    default:
                        break;
                }
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Ati introdus ceva gresit! \n");
        }
        finally {
            System.out.println("Va dorim o zi buna! \n");
        }
    }

}
