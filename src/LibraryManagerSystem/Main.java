package LibraryManagerSystem;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n----- Kütüphane Yönetim Sistemi -----");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitapları Listele");
            System.out.println("3. Kitap Ara");
            System.out.println("4. Kitap Ödünç Al");
            System.out.println("5. Kitap İade Et");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminiz: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Kitap ekleme
                    System.out.print("Kitap adı: ");
                    String name = scanner.nextLine();
                    System.out.print("Yazar adı: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    int isbn = Integer.parseInt(scanner.nextLine());
                    System.out.print("Tür: ");
                    String genre = scanner.nextLine();
                    System.out.print("Yayın yılı: ");
                    int publishYear = Integer.parseInt(scanner.nextLine());

                    Book newBook = new Book(name, author, isbn, genre, publishYear);
                    library.addBook(newBook);
                    break;

                case "2":
                    // Kitapları listele
                    library.listBooks();
                    break;

                case "3":
                    // Kitap ara
                    System.out.print("Aranacak kitap adı: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> foundBooks = library.searchBookByTitle(searchTitle);
                    if (foundBooks.isEmpty()) {
                        System.out.println("Aradığınız kitap bulunamadı.");
                    } else {
                        System.out.println("Arama sonuçları:");
                        for (Book book : foundBooks) {
                            System.out.println(book);
                        }
                    }
                    break;

                case "4":
                    // Kitap ödünç al
                    System.out.print("Ödünç almak istediğiniz kitabın ISBN numarasını giriniz: ");
                    int borrowIsbn = Integer.parseInt(scanner.nextLine());
                    library.borrowBook(borrowIsbn);
                    break;

                case "5":
                    // Kitap iade et
                    System.out.print("İade etmek istediğiniz kitabın ISBN numarasını giriniz: ");
                    int returnIsbn = Integer.parseInt(scanner.nextLine());
                    library.returnBook(returnIsbn);
                    break;

                case "6":
                    System.out.println("Programdan çıkılıyor. İyi günler!");
                    exit = true;
                    break;

                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyiniz.");
            }
        }

        scanner.close();
    }
}
