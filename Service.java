
package service;



public abstract class Service {

 
    private final int custID;
    private String name;
    private double price;
    private Appointment[] appointments;
    private static int counter;

    public Service() {
        this(0, "", 0.0, null);
    }

    public Service(int custID, String name, double price, Appointment[] appointments) {
        this.custID = custID;
        setName(name);
        setPrice(price);
        setAppointments(appointments);
        counter++;
    }

    public String getName() {
        return name;
    }

    public int getCustID() {
        return custID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Appointment[] getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointment[] appointments) {
        this.appointments = appointments;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Service.counter = counter;
    }

    public abstract double caluPrice();

    public final void displayAppointments() {
        if (appointments == null) {
            System.out.println("all appointments have been registered!!!");
        } else {
            System.out.println(".......the available Appointments....... ");
            for (int i = 0; i < appointments.length; i++) {
                System.out.println("the index : " + i);
                System.out.println(appointments[i]);
                System.out.println(".....................");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("the ID is : %d%n the name is : %s%n the price is : %.1f riyal %n", getCustID(), getName(), getPrice());
    }

}