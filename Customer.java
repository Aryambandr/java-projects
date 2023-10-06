
package service;


public final class Customer {

    
 private final int custID;
    private String name;
    private String phone;

    public Customer(int custID, String name, String phone) {
        this.custID = custID;
        setName(name);
        setPhone(phone);
    }

    public int getCustID() {
        return custID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Customer ID: %d\nName: %s\nPhone: %s", getCustID(), getName(), getPhone());
    }
}

