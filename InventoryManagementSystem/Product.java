public class Product {
    private String barcode;
    private String name;
    private double price;
    private int quantity;

    public Product(String barcode, String name, double price, int quantity) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }
}