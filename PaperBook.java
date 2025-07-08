public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String bookTitle, int releaseDate, double price, String author, int stock) {
        super(isbn, bookTitle, releaseDate, price, author);
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (stock < quantity) {
            throw new IllegalStateException("Quantum Bookstore: Not enough stock for book: " + getBookTitle());
        }
        stock -= quantity;
    }

    @Override
    public boolean isAvailable() {
        return stock > 0;
    }

    @Override
    public void processDelivery(String email, String address) {
        System.out.println("Quantum Bookstore: Shipping paper book '" + getBookTitle() + "' to address: " + address);
        // send address to Shipping services
         ShippingService.sendToShippingService(address,getBookTitle());
    }
}
