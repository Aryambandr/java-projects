
package service;

public final class Registration {
//فاينل لان ماراح يكون لها سب كلاسيس
    private final int custID;
    private Customer customer;
    private Appointment appointment;
    private Service service;
    private String status;
    private static int counter;

    public Registration() {
        this(null, null, null);
    }

    public Registration(Customer customer, Appointment appointment, Service service) {
        this.custID = (int)(1000 * Math.random() + 1);
    
        setCustomer(customer);
        setAppointment(appointment);
        setService(service);
        setStatus("new");
        counter++;

    }

    public int getCustID() {
        return custID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Registration.counter = counter;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nService: %s\nAppointment: %s\nCustomer: %s\nStatus: %s", getCustID(), getService(), getAppointment(), getCustomer(), getStatus());
    }
}

   




