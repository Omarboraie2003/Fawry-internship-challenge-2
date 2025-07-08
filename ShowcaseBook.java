public class ShowcaseBook extends Book {

    public ShowcaseBook(String isbn, String bookTitle, int releaseDate, double price, String author) {
        super(isbn, bookTitle, releaseDate, price, author);
    }

    @Override
    public boolean isAvailable() {
        return false; // not for sale
    }

    @Override
    public void processDelivery(String email, String address) {
        throw new UnsupportedOperationException("Quantum Bookstore: Showcase books are not for sale or delivery.");
    }
}
