import java.util.UUID;

public class Book {

    private static int counter = 0;
    private int Id;
    private UUID Isbn;  // Code for every type of book
    private String Name;
    private String Author;
    private boolean Free;

    public Book() {
        counter += 1;
        Id = counter;
        Isbn = UUID.randomUUID() ;
    }

    public Book(String name, String author, boolean free) {
        counter += 1;
        Id = counter;
        Isbn = UUID.randomUUID() ;
        Name = name;
        Free = free;
        Author = author;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public UUID getIsbn() {
        return Isbn;
    }

    public void setIsbn(UUID isbn) {
        Isbn = isbn;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isFree() {
        return Free;
    }

    public void setFree(boolean free) {
        Free = free;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void show() {
        System.out.println("Nume: " + this.getName() + "Autor:" + this.getAuthor());
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", Isbn=" + Isbn +
                ", Name='" + Name + '\'' +
                ", Author='" + Author + '\'' +
                ", Free=" + Free +
                '}';
    }

    public String showBook(){
        return " Nume: " + this.getName() +
                ", Autor: " + this.getAuthor() +
                ", Imprumutabila: " + this.isFree();
    }
}
