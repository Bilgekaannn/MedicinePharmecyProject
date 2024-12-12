public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }


    public void addDrugToPharmacy(Pharmacy pharmacy, Drug drug) {
        pharmacy.addDrug(drug);
    }


    public void updateDrugInPharmacy(Pharmacy pharmacy, String name, int quantity, double price) {
        pharmacy.updateDrug(name, quantity, price);
    }


    public void approveOrder(Customer customer) {
        System.out.println(customer + " siparişi onaylandı.");
    }


    public void rejectOrder(Customer customer) {
        System.out.println(customer + " siparişi reddedildi.");
    }
}
