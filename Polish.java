
package service;


public class Polish extends Service {
private String product;

    public Polish() {
        this(0, "", 0.0, null, "");
    }

    public Polish(int custID, String name, double price, Appointment[] appointments, String product) {
        super(custID, name, price, appointments);
        setProduct(product);
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public double caluPrice() {
        return getPrice();
    }

    @Override
    public String toString() {
        return String.format("%sThe polish product is : %s", super.toString(), getProduct());
    }
}
