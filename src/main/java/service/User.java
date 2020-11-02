package service;

public class User {

    private static int counter = 0;
    private int Id;
    private String Name;
    private String Location;
    private int NumberOfBorrowedBooks;

    public User(){
        counter += 1;
        Id = counter;
        NumberOfBorrowedBooks = 0;
    }

    public User(String name, String location) {
        counter += 1;
        Id = counter;
        Name = name;
        Location = location;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getNumberOfBorrowedBooks() {
        return NumberOfBorrowedBooks;
    }

    public void setNumberOfBorrowedBooks(int numberOfBorrowedBooks) {
        NumberOfBorrowedBooks = numberOfBorrowedBooks;
    }

    @Override
    public String toString() {
        return "service.User{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Location='" + Location + '\'' +
                ", NumberOfBorrowedBooks=" + NumberOfBorrowedBooks +
                '}';
    }
}
