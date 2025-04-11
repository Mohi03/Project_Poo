import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books;
    private List<Borrower> borrowers;

    public Library() {
        books = new ArrayList<>();
        borrowers = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
        System.out.println("Borrower added: " + borrower.getName());
    }

    public Book findBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) return book;
        }
        return null;
    }

    public Borrower findBorrowerByID(String studentID) {
        for (Borrower borrower : borrowers) {
            if (borrower.getStudentID().equals(studentID)) return borrower;
        }
        return null;
    }

    public void borrowBook(String ISBN, String studentID) {
        Book book = findBookByISBN(ISBN);
        Borrower borrower = findBorrowerByID(studentID);

        if (book == null) {
            System.out.println("Error: Book not found.");
            return;
        }
        if (borrower == null) {
            System.out.println("Error: Borrower not registered.");
            return;
        }
        if (book.isBorrowed()) {
            System.out.println("Error: Book is already borrowed.");
            return;
        }

        borrower.borrowBook(book);
        System.out.println("Book '" + book.getTitle() + "' borrowed by " + borrower.getName());
    }

    public void returnBook(String ISBN, String studentID) {
        Book book = findBookByISBN(ISBN);
        Borrower borrower = findBorrowerByID(studentID);

        if (book == null || borrower == null || !book.isBorrowed()) {
            System.out.println("Error: Unable to return the book.");
            return;
        }

        borrower.returnBook(book);
        System.out.println("Book '" + book.getTitle() + "' returned by " + borrower.getName());
    }

    public void displayBooks() {
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayBorrowers() {
        System.out.println("\nBorrowers List:");
        for (Borrower borrower : borrowers) {
            System.out.println(borrower);
        }
    }
}
