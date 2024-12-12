import java.util.List;
import java.util.ArrayList;


public class Customer {
    private String name;
    private List<Drug> order;

    public Customer(String name) {
        this.name = name;
        this.order = new ArrayList<>();
    }


    public void createOrder(Drug drug) {
        order.add(drug);
    }


    public void showOrderDetails() {
        System.out.println(name + " için Sipariş Detayları:");
        double totalAmount = 0;
        for (Drug drug : order) {
            System.out.println(drug);
            totalAmount += drug.getPrice();
        }
        System.out.println("Toplam Tutar: " + totalAmount);
    }
}

