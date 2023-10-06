/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


public class Detailing  extends Service {

    private String detail;

    public Detailing() {
        this(0, "", 0.0, null, "");
    }

    public Detailing(int custID, String name, double price, Appointment[] appointments, String detail) {
        super(custID, name, price, appointments);
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return
     */
    @Override
    public double caluPrice() {
        double price = getPrice();
        if (getDetail() == "Interior Detailing") {
            price = +3;
        } else if (getDetail() == "Exterior Detailing") {
            price = +7;
        }
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s the detailing is : %s", super.toString(), getDetail());
    }
}



    



