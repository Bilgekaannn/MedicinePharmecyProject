import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pharmacy pharmacy = new Pharmacy();
        Employee employee = new Employee("Ahmet");
        Customer customer = new Customer("Ali");


        pharmacy.addDrug(new Drug("Aspirin", 50, 15.5, LocalDate.of(2025, 6, 15)));
        pharmacy.addDrug(new Drug("Parol", 30, 10.0, LocalDate.of(2024, 12, 11)));
        pharmacy.addDrug(new Drug("Amoxicillin", 100, 20.0, LocalDate.of(2023, 12, 1)));

        while (true) {
            System.out.println("\nEczane Stok Yönetimi");
            System.out.println("1. İlaç Ekle");
            System.out.println("2. İlaç Sil");
            System.out.println("3. İlaç Güncelle");
            System.out.println("4. İlaç Ara");
            System.out.println("5. Eczanedeki İlaçları Görüntüle");
            System.out.println("6. Son Kullanma Tarihi Geçmiş İlaçları Kontrol Et");
            System.out.println("7. Kritik Stok Seviyesi Kontrol Et");
            System.out.println("8. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Satır sonu karakteri temizleme

            switch (choice) {
                case 1:

                    System.out.print("İlacın adını girin: ");
                    String name = scanner.nextLine();
                    System.out.print("İlacın miktarını girin: ");
                    int quantity = scanner.nextInt();
                    System.out.print("İlacın fiyatını girin: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();  // Satır sonu karakterini temizleme
                    System.out.print("İlacın son kullanma tarihini girin (yyyy-MM-dd): ");
                    String expiryDateInput = scanner.nextLine();
                    LocalDate expiryDate = LocalDate.parse(expiryDateInput);
                    pharmacy.addDrug(new Drug(name, quantity, price, expiryDate));
                    System.out.println("İlaç başarıyla eklendi.");
                    break;

                case 2:

                    System.out.print("Silmek istediğiniz ilacın adını girin: ");
                    String drugToDelete = scanner.nextLine();
                    boolean isDeleted = pharmacy.removeDrug(drugToDelete);
                    if (isDeleted) {
                        System.out.println("İlaç başarıyla silindi.");
                    } else {
                        System.out.println("İlaç bulunamadı.");
                    }
                    break;

                case 3:

                    System.out.print("Güncellemek istediğiniz ilacın adını girin: ");
                    String drugToUpdate = scanner.nextLine();
                    System.out.print("Yeni miktarını girin: ");
                    int newQuantity = scanner.nextInt();
                    System.out.print("Yeni fiyatını girin: ");
                    double newPrice = scanner.nextDouble();
                    pharmacy.updateDrug(drugToUpdate, newQuantity, newPrice);
                    System.out.println("İlaç başarıyla güncellendi.");
                    break;

                case 4:

                    System.out.print("Aradığınız ilacın adını girin: ");
                    String searchName = scanner.nextLine();
                    Drug foundDrug = pharmacy.searchDrug(searchName);
                    if (foundDrug != null) {
                        System.out.println("İlaç bulundu: " + foundDrug);
                    } else {
                        System.out.println("İlaç bulunamadı.");
                    }
                    break;

                case 5:

                    pharmacy.displayDrugs();
                    break;

                case 6:

                    pharmacy.checkExpiredDrugs(LocalDate.now());
                    break;

                case 7:

                    System.out.print("Kritik stok seviyesi için eşik değeri girin: ");
                    int stockThreshold = scanner.nextInt();
                    pharmacy.checkCriticalStockLevel(stockThreshold);
                    break;

                case 8:
                    System.out.println("Çıkılıyor...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }
}
