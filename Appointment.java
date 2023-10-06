/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


public final class Appointment implements Confirm {
 private final int custID;
    private boolean avaliability;
    private Date date;
    private Time time;

    public Appointment() {
        this(0, null, null);
    }

    public Appointment(int custID, Date date, Time time) {
        this.custID = custID;
        setDate(date);
        setTime(time);
        setAvaliability(true);
    }

    public int getCustID() {
        return custID;
    }

    public boolean getAvaliability() {
        return avaliability;
    }

    public void setAvaliability(boolean avaliability) {
        this.avaliability = avaliability;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {

        return String.format("ID : %d\nDate : %s\nTime : %s\nAvailable : %s ", getCustID(), getDate(), getTime(), getAvaliability());
    }

    @Override
    public void confirm() {
        setAvaliability(false);
        System.out.println("your appointment has been confirmed !");
    }
}
