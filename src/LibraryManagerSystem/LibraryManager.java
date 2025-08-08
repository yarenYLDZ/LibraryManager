package LibraryManagerSystem;

import java.util.ArrayList;
import java.util.List;


public class LibraryManager {

    private final List<Book> books; //kitaplari saklamak icin liste

    public LibraryManager(){
        books = new ArrayList<>();

    }

    // Kitap ekleme metodu
    public void addBook(Book book){
        books.add(book);
        System.out.println("ISLEM SONUCU : Kitap başarıyla eklendi");

    }

    //Kitaplari listeleme metodu
    public void listBooks(){
        if(books.isEmpty()){
            System.out.println("Kütüphanede listelenecek kitap bulunmamaktadır.");
        } else {
            System.out.println("----Kütüphanedeki Kitaplar----");
            for (Book book: books){
                System.out.println("Title: " + book.getName());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Status: " + (book.isAvailable() ? "Available" : "Not Available"));
                System.out.println("Genre: " + book.getGenre());
                System.out.println("Publish Year: " + book.getPublishYear());
                System.out.println("----------------------");
            }
        }
    }


    //Kitaplari isimleri ile arama metodu
    public List<Book> searchBookByTitle(String title){
        List<Book> foundBooks=new ArrayList<>();
        for(Book book:books){
            if(book.getName().toLowerCase().contains(title.toLowerCase())){
                foundBooks.add(book);
            }

        }
        return foundBooks;
    }


    //Kitaplari ISBN numarasi ile odunc alma
    public void borrowBook(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Kitap ödünç verildi: \n" + book);
                } else {
                    System.out.println("Bu kitap zaten ödünç verilmiş: \n" + book);
                }


                return; // İşlem tamamlandı, metottan çık
            }
        }
        System.out.println("ISBN numarası ile eşleşen kitap bulunamadı.");
    }


    //Kitaplari isbn numarasi ile iade etme
    public void returnBook(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Kitap iade edildi:\n" + book);
                    return;
                } else {
                    System.out.println("Bu kitap zaten iade edilmiş:\n" + book);
                    return;
                }
            }
        }
        System.out.println("ISBN numarasıyla eşleşen kitap bulunamadı.");
    }

}
