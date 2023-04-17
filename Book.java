public class Book {
    private String isbn;
    private String status;
    private String author;
    private String title;
    private String publisher;

    public Book() {
        isbn = getIsbn();
        status = getStatus();
        author = getAuthor();
        title = getTitle();
        publisher = getPublisher();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void showDetails() {
        System.out.println(title + " " + publisher + " " + isbn + " " + status);
    }
}