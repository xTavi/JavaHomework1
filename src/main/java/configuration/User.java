package configuration;

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
        Name = name;
        Location = location;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
