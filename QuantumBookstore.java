public class QuantumBookstore {
    private BookInventory inventory = new BookInventory();

    public void addBook(Book book) {
        inventory.addBook(book);
        System.out.println("Quantum Bookstore: Book added - " + book.getBookTitle());
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        if (!inventory.contains(isbn)) {
            throw new IllegalArgumentException("Quantum Bookstore: Book with ISBN " + isbn + " not found.");
        }

        Book book = inventory.getBook(isbn);

        if (!book.isAvailable()) {
            throw new IllegalStateException("Quantum Bookstore: Book '" + book.getBookTitle() + "' is not available for purchase.");
        }

        if (book instanceof PaperBook) {
            ((PaperBook) book).reduceStock(quantity);
        }

        double total = book.getPrice() * quantity;
        book.processDelivery(email, address);
        System.out.println("Quantum Bookstore: Purchase successful! Paid $" + total);

        return total;
    }

    public void removeOutdatedBooks(int maxAge, int currentYear) {
        var removed = inventory.removeOutdatedBooks(maxAge, currentYear);
        for (Book b : removed) {
            System.out.println("Quantum Bookstore: Removed outdated book - " + b.getBookTitle());
        }
    }

    public BookInventory getInventory() {
        return inventory;
    }
}
