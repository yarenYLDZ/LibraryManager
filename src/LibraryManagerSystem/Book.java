package LibraryManagerSystem;

public class Book {

    private static int idCounter = 1; // Her kitabin benzersiz id si icin sayac
    private int id; //kitabin kimligi (benzersiz)
    private String name;
    private String author;
    private boolean isAvailable; //kitabin odunc verilip verilmeme durumu icin
    private String genre; // kitap turu
    private int publishYear;
    private int isbn;


    public Book(String name, String author, int isbn, String genre, int publishYear) {
        this.id = idCounter++;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.publishYear = publishYear;
        this.isAvailable = true; // default olarak ilk basta kitap odunc verilmemistir kabul edlir
    }

    // Degiskenler private oldugundan dolayi disardan erisim icin getter ve setter metotlari
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Title: " + name + "\n" +
                "Author: " + author + "\n" +
                "ISBN: " + isbn + "\n" +
                "Status: " + (isAvailable ? "Available" : "Not Available") + "\n" +
                "Genre: " + genre + "\n" +
                "Publish Year: " + publishYear + "\n" +
                "----------------------";
    }

}