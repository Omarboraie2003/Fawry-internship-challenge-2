import java.time.Year;

public class QuantumBookstoreTest {
    public static void main(String[] args) {
        QuantumBookstore store = new QuantumBookstore();
        int currentYear = Year.now().getValue();

        // ✅ Add different types of books
        Book paperBook = new PaperBook("ISBN001", "Volleyball", 2018, 350.0, "Omar boraie", 10);
        Book eBook = new EBook("ISBN002", "Cloud Engineering", 2023, 150.0, "zaki hassan", "PDF");
        Book showcaseBook = new ShowcaseBook("ISBN003", "Algorithms", 1950, 0.0, "yehia");

        store.addBook(paperBook);
        store.addBook(eBook);
        store.addBook(showcaseBook);

        System.out.println();

        // Try buying a PaperBook
        try {
            store.buyBook("ISBN001", 3, "omarboraie@example.com", "Cairo, Egypt");
        } catch (Exception e) {
            System.out.println("Quantum Bookstore: ERROR - " + e.getMessage());
        }

        System.out.println();

        // Try buying an EBook
        try {
            store.buyBook("ISBN002", 1, "yehia@example.com", "");
        } catch (Exception e) {
            System.out.println("Quantum Bookstore: ERROR - " + e.getMessage());
        }

        System.out.println();

        // Attempt to buy a ShowcaseBook (should fail)
        try {
            store.buyBook("ISBN003", 1, "zaki@example.com", "Nowhere");
        } catch (Exception e) {
            System.out.println("Quantum Bookstore: ERROR - " + e.getMessage());
        }

        System.out.println();

        // Remove outdated books older than 10 years
        store.removeOutdatedBooks(10, currentYear);

        System.out.println();

        // Show remaining inventory
        System.out.println("Quantum Bookstore: Remaining books in inventory:");
        for (Book b : store.getInventory().getAllBooks()) {
            System.out.println("- " + b.getBookTitle() + " by " + b.getAuthor() + " (" + b.getIsbn() + ")");
        }
    }
} 