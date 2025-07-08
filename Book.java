public abstract class Book {
    private String isbn;
    private String bookTitle;
    private int releaseDate;
    private double price;
    private String author;

    public Book(String isbn, String bookTitle, int releaseDate, double price, String author) {
        if (isbn == null || bookTitle == null || author == null || releaseDate < 0 || price < 0) {
            throw new IllegalArgumentException("Invalid book data provided.");
        }

        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.releaseDate = releaseDate;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public int getAge(int currentYear) {
        return currentYear - releaseDate;
    }

    // this methods will be overriden in subclasses
    public abstract boolean isAvailable();

    public abstract void processDelivery(String email, String address);
}
