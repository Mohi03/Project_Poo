import java.util.ArrayList;
import java.util.List;

class Borrower {
    private String name;
    private String studentID;
    private List<Book> borrowedBooks;

    public Borrower(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getStudentID() { return studentID; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.borrowBook();
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.returnBook();
    }

    @Override
    public String toString() {
        return "Borrower: " + name + ", Student ID: " + studentID + ", Borrowed Books: " + borrowedBooks.size();
    }
}