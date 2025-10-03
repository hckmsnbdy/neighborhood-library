package com.pluralsight;

import java.util.Scanner;

public class HomeScreen {

    private static Book[] books = new Book[20];

    public static void main(String[] args) {
        //Bookshelf
        books[0]  = new Book(1, "9780140449334", "The Republic - Plato", false, "");
        books[1]  = new Book(2, "9780140449105", "Meditations - Marcus Aurelius", false, "");
        books[2]  = new Book(3, "9780140447941", "Nicomachean Ethics - Aristotle", false, "");
        books[3]  = new Book(4, "9780140444285", "Beyond Good and Evil - Friedrich Nietzsche", false, "");
        books[4]  = new Book(5, "9780140445893", "Thus Spoke Zarathustra - Friedrich Nietzsche", false, "");
        books[5]  = new Book(6, "9780140444278", "Critique of Pure Reason - Immanuel Kant", false, "");
        books[6]  = new Book(7, "9780140442106", "Groundwork of the Metaphysics of Morals - Immanuel Kant", false, "");
        books[7]  = new Book(8, "9780140440355", "Discourse on Method - René Descartes", false, "");
        books[8]  = new Book(9, "9780140439212", "Leviathan - Thomas Hobbes", false, "");
        books[9]  = new Book(10, "9780140444957", "The Social Contract - Jean-Jacques Rousseau", false, "");
        books[10] = new Book(11, "9780140444841", "A Treatise of Human Nature - David Hume", false, "");
        books[11] = new Book(12, "9780143105824", "Being and Nothingness - Jean-Paul Sartre", false, "");
        books[12] = new Book(13, "9780141184633", "Existentialism is a Humanism - Jean-Paul Sartre", false, "");
        books[13] = new Book(14, "9780143104919", "The Myth of Sisyphus - Albert Camus", false, "");
        books[14] = new Book(15, "9780679720201", "The Stranger - Albert Camus", false, "");
        books[15] = new Book(16, "9780140447576", "Confessions - St. Augustine", false, "");
        books[16] = new Book(17, "9780140444254", "On Liberty - John Stuart Mill", false, "");
        books[17] = new Book(18, "9780140449747", "Being and Time - Martin Heidegger", false, "");
        books[18] = new Book(19, "9780199536061", "The Symposium - Plato", false, "");
        books[19] = new Book(20, "9780199535767", "Phaedo - Plato", false, "");

        Scanner scanner = new Scanner(System.in);
        int choice;
        //--------------------------------------------------------------------------------------------------------------
        // Menu loop: keep showing until user exits
        do {
            // Home menu
            System.out.println("\nWelcome to the Neighborhood Library!");
            System.out.println("1 - Show Available Books");
            System.out.println("2 - Show Checked Out Books");
            System.out.println("3 - Exit");
            System.out.print("Enter your choice: ");

            //  Validating user input
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter 1, 2, or 3: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            // Run chosen option
            if (choice == 1) {

                showAvailableBooks(scanner);

            } else if (choice == 2) {

                showCheckedOutBooks(scanner);
            }

        } while (choice != 3); // loop until exit

        System.out.println("Goodbye!");
    }
    //------------------------------------------------------------------------------------------------------------------
    // Show all available books
    private static void showAvailableBooks(Scanner scanner) {
        System.out.println("\nAvailable Books:");
        boolean any = false;

        for (Book b : books) {
            if (b != null && !b.isCheckedOut()) {
                System.out.println(b.getId() + " - " + b.getIsbn() + " - " + b.getTitle());
                any = true;
            }
        }
        if (!any) {
            System.out.println("(No available books right now.)");
        }

        System.out.print("Enter book ID to check out, or X to go back: ");
        String input = scanner.nextLine().trim().toUpperCase();

        if (input.equals("X")) {
            System.out.println("Returning to home screen...");
            return; // go back to menu
        }
        int id = Integer.parseInt(input);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        boolean success = false;
        for (Book b : books) {
            if (b != null && b.getId() == id && !b.isCheckedOut()) {
                b.checkOut(name);
                System.out.println("Book checked out to " + name);
                success = true;
                break;
            }
        }
        if (!success) {
            System.out.println("ID not found or already checked out.");
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Show all borrowed books
    private static void showCheckedOutBooks(Scanner scanner) {
        // List all checked out books
        System.out.println("\nChecked Out Books:");
        for (Book b : books) {
            if (b != null && b.isCheckedOut()) {
                System.out.println(b.getId() + " - " + b.getIsbn() + " - "
                        + b.getTitle() + " (Checked out to: " + b.getCheckedOutTo() + ")");
            }
        }

        // Ask user what to do
        System.out.print("Enter C to check in a book, or X to go back: ");
        String choice = scanner.nextLine().trim().toUpperCase();

        if (choice.equals("C")) {
            System.out.print("Enter the ID of the book to check in: ");
            String input = scanner.nextLine().trim();
            int id = Integer.parseInt(input);

            for (Book b : books) {
                if (b != null && b.getId() == id && b.isCheckedOut()) {
                    b.checkIn();
                    System.out.println("Book checked in!");
                    break;
                }
            }
        }
        else if (choice.equals("X")) {
            // Explicitly go back to main menu
            System.out.println("Returning to home screen...");
        }
    }
}
