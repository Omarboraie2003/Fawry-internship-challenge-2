import java.util.*;

public class BookInventory {
    private Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }

    public boolean contains(String isbn) {
        return inventory.containsKey(isbn);
    }

    public Book removeBook(String isbn) {
        return inventory.remove(isbn);
    }

    public List<Book> removeOutdatedBooks(int maxAge, int currentYear) {
        List<Book> removed = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next().getValue();
            if (book.getAge(currentYear) > maxAge) {
                removed.add(book);
                iterator.remove();
            }
        }
        return removed;
    }

    public Collection<Book> getAllBooks() {
        return inventory.values();
    }
}

