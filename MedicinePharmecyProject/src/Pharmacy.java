import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pharmacy {
    private List<Drug> drugs;

    public Pharmacy() {
        this.drugs = new ArrayList<>();
    }


    public void addDrug(Drug drug) {
        drugs.add(drug);
    }


    public boolean removeDrug(String drugName) {
        return drugs.removeIf(drug -> drug.getName().equalsIgnoreCase(drugName));
    }


    public void updateDrug(String drugName, int newQuantity, double newPrice) {
        for (Drug drug : drugs) {
            if (drug.getName().equalsIgnoreCase(drugName)) {
                drug.setQuantity(newQuantity);
                drug.setPrice(newPrice);
                return;
            }
        }
    }


    public Drug searchDrug(String drugName) {
        for (Drug drug : drugs) {
            if (drug.getName().equalsIgnoreCase(drugName)) {
                return drug;
            }
        }
        return null;
    }


    public void displayDrugs() {
        if (drugs.isEmpty()) {
            System.out.println("Eczanede ilaç bulunmamaktadır.");
        } else {
            for (Drug drug : drugs) {
                System.out.println(drug);
            }
        }
    }


    public void checkExpiredDrugs(LocalDate currentDate) {
        System.out.println("\nSon kullanma tarihi geçmiş ilaçlar:");
        for (Drug drug : drugs) {
            if (drug.getExpiryDate().isBefore(currentDate)) {
                System.out.println(drug);
            }
        }
    }


    public void checkCriticalStockLevel(int threshold) {
        System.out.println("\nKritik stok seviyesinde olan ilaçlar:");
        for (Drug drug : drugs) {
            if (drug.getQuantity() < threshold) {
                System.out.println(drug);
            }
        }
    }
}


