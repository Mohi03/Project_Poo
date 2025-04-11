import java.util.Scanner;


public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1 - Add a Book");
            System.out.println("2 - Add a Borrower");
            System.out.println("3 - Borrow a Book");
            System.out.println("4 - Return a Book");
            System.out.println("5 - Display Books");
            System.out.println("6 - Display Borrowers");
            System.out.println("7 - Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Enter book type (Physical/Digital): ");
                    String type = scanner.nextLine();
                    library.addBook(new Book(title, author, ISBN, type));
                    break;

                case 2:
                    System.out.print("Enter borrower name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentID = scanner.nextLine();
                    library.addBorrower(new Borrower(name, studentID));
                    break;

                case 3:
                    System.out.print("Enter book ISBN: ");
                    String borrowISBN = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String borrowStudentID = scanner.nextLine();
                    library.borrowBook(borrowISBN, borrowStudentID);
                    break;

                case 4:
                    System.out.print("Enter book ISBN: ");
                    String returnISBN = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String returnStudentID = scanner.nextLine();
                    library.returnBook(returnISBN, returnStudentID);
                    break;

                case 5:
                    library.displayBooks();
                    break;

                case 6:
                    library.displayBorrowers();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
