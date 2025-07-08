public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String bookTitle, int releaseDate, double price, String author, String fileType) {
        super(isbn, bookTitle, releaseDate, price, author);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public boolean isAvailable() {
        return true; // eBooks are always available
    }

    @Override
    public void processDelivery(String email, String address) {
        MailService.send(email, getBookTitle(), fileType);
    }
}

