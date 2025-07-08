public class MailService {
    public static void send(String email, String bookTitle, String fileType) {
        System.out.println("Quantum Bookstore: MailService - '" + bookTitle + "' (" + fileType + ") sent to: " + email);
    }
}

