/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

public class Wash extends Service {
private String form;

    public Wash() {
        this(0, "", 0.0, null, "");
    }

    public Wash(int custID, String name, double price, Appointment[] appointments, String form) {
        super(custID, name, price, appointments);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public double caluPrice() {
        double price = getPrice();
        if (getForm() == "Hand Wash") {
            price += 15;
        } else if (getForm() == "Automatic wash") {
            price += 7;

        }
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s the wash form is : %s", super.toString(), getForm());
    }

}
