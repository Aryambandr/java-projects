package service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Service> Services = new ArrayList<>();
        List(Services);
        System.out.println("*Welcome to the Car Wash Services*");
        System.out.println("How may I help you ? ");
        System.out.println("+--------------------------------+");

        int choice;
        Registration registration = null;

        try {

            do {
                System.out.println("1-show all services");
                System.out.println("2-show wash services");
                System.out.println("3-show polish services");
                System.out.println("4-the details of name and price");
                System.out.println("5-add an appointment");
                System.out.println("6-new registration");
                System.out.println("7-show registration");
                System.out.println("8-cancel registration");
                System.out.println("9-show GUI");
                System.out.println("10-exit");

                choice = input.nextInt();
                switch (choice) {

                    case 1:
                        System.out.println(" all services ");
                        for (Service service : Services) {
                            System.out.println(service);
                            service.displayAppointments();
                            System.out.printf("total is: %.2f SAR\n", service.caluPrice());
                            System.out.println("+-----------------------------------+");
                        }
                        break;

                    case 2:
                        System.out.println(" wash services ");
                        for (Service service : Services) {
                            if (service instanceof Wash) {
                                System.out.println(service);
                                service.displayAppointments();
                                System.out.printf("total is: %.2f SAR\n", service.caluPrice());
                                System.out.println("-----------------------------------");
                            }

                        }
                        break;
                    case 3:
                        System.out.println(" wash services ");
                        for (Service service : Services) {
                            if (service instanceof Polish) {
                                System.out.println(service);
                                service.displayAppointments();
                                System.out.printf("total is: %.2f SAR\n", service.caluPrice());
                                System.out.println("-----------------------------------");
                            }
   
                        }
                        break;

                    case 4:
                        System.out.println(" the details ");
                        System.out.println("here we have four polish for your car ");
                        System.out.println("1 / Turtle Wax Hybrid Solutions Ceramic Polish and Wax%nthe price is : 2");
                        System.out.println("2 / Chemical Guys All-in-One Polish and Sealant%nthe price is : 4");
                        System.out.println("3 / Adam's One Step Polish%nthe price is : 6");
                        System.out.println("4 / Meguiar's Ultimate Polish%nthe price is : 8");
                        for (Service service : Services) {
                            if (service instanceof Detailing) {
                                System.out.println(service);
                                System.out.printf("total is: %.2f SAR\n", service.caluPrice());

                                System.out.println("+-----------------------------------+");
                            }

                        }
                        break;
                    case 5:
                        System.out.print("enter your service id: ");
                        int CustID = input.nextInt();
                        Service service = null;
                        for (Service s : Services) {
                            if (s.getCustID() == CustID) {
                                service = s;
                                break;
                            }
                        }

                        if (service == null) {
                            System.out.println("invalid");
                            break;
                        }

                        System.out.println("how many appointments to add?");
                        int size = input.nextInt();
                        if (size <= 0) {
                            System.out.println("invalid number!!!");
                            break;
                        }
                        // Appointment[] appointments
                       Appointment[] appointments = new Appointment[size];
                        System.out.println("enter appointments: " + size);

                        for (int i = 0; i < appointments.length; i++) {
                            System.out.println("enter appointment id: ");
                            int custID = input.nextInt();
                            System.out.println("enter year: ");
                            int year = input.nextInt();
                            if (year > 2023 || year < 2023 ) {
                                System.out.println("invalid year!");
                                break;
                            }
                            System.out.println("enter month: ");
                            int month = input.nextInt();
                            if (month < 1 || month > 12) {
                                System.out.println("invalid month!");
                                break;
                            }
                            System.out.println("enter day: ");
                            int day = input.nextInt();
                            if (day < 1 || day > 31) {
                                System.out.println("invalid day!");
                                break;
                            }

                            System.out.println("enter hour: ");
                            int hour = input.nextInt();
                            if (hour < 0 || hour > 24) {
                                System.out.println("invalid hour!");
                                break;
                            }
                            System.out.println("enter minute: ");
                            int minutes = input.nextInt();
                            if (minutes < 0 || minutes > 60) {
                                System.out.println("invalid minute!");
                                break;
                            }
                            System.out.println("enter second: ");
                            int second = input.nextInt();
                            if (second < 0 || second > 60) {
                                System.out.println("invalid second!");
                                break;
                            }
                            Date date = new Date(day, month, year);
                            Time time = new Time(hour, minutes, second);
                            Appointment appointment = new Appointment(custID, date, time);

                            appointments[i] = appointment;
                            System.out.println("---------------------------------");

                        }
                        service.setAppointments(appointments);
                        System.out.println("added successfully!");
                        break;

                    case 6:
                        System.out.println("enter service id: ");
                        int serviceId = input.nextInt();
                        service = null;
                        for (Service s : Services) {
                            if (s.getCustID() == serviceId) {
                                service = s;
                                break;
                            }
                        }
                        if (service == null) {
                            System.out.println("invalid!");
                            break;
                        }
                        if (service.getAppointments() == null) {
                            System.out.println("sorry all appointment are registered!");
                            break;
                        }
                        service.displayAppointments();
                        System.out.print("select appointment by index: ");
                        Appointment[] serviceAppointment = service.getAppointments();
                        int index = input.nextInt();
                        if (index < 0 || index >= serviceAppointment.length) {
                            System.out.println("invalid index!");
                            break;
                        }
                        Appointment appointment = serviceAppointment[index];
                        if (!appointment.getAvaliability()) {
                            System.out.println("sorry, your appointment is not available.");
                            break;
                        }
                        System.out.print("id: ");
                        int id = input.nextInt();
                        System.out.println("first name: ");
                        String name = input.next();
                        System.out.println("phone number: ");
                        String phone = input.next();
                        Customer customer = new Customer(id, name, phone);
                        registration = new Registration(customer, appointment, service);

                        System.out.print("confirm registration?(Y/N): ");
                        char answer = input.next().charAt(0);
                        if (answer == 'y' || answer == 'Y') {
                            registration.setStatus("confirmed");
                            registration.getAppointment().confirm();
                            System.out.println(registration);
                            System.out.printf("total is: %.2f SAR\n", registration.getService().caluPrice());
                            System.out.println("your registration has been confirmed!");

                        } else {
                            registration.getAppointment().setAvaliability(true);
                            registration = null;
                            System.out.println("your registration has been cancelled");
                        }
                        break;

                    case 7:
                        if (registration != null) {
                            System.out.println(registration);
                            System.out.printf("total is: %.2f SAR", registration.getService().caluPrice());
                        } else {
                            System.out.println("no registration yet!");
                        }
                        break;

                    case 8:
                        if (registration != null) {
                            System.out.print("are you sure you want to cancel booking? (Y/N): ");
                            answer = input.next().charAt(0);
                            if (answer == 'y' || answer == 'Y') {
                                registration.setStatus("cancelled");
                                System.out.println(registration);
                                registration.getAppointment().setAvaliability(true);
                                System.out.printf("total is: %.2f SAR\n", registration.getService().caluPrice());
                                System.out.println("your booking has been cancelled!");
                            } else {
                                System.out.println("your registration is still confirmed!");
                            }
                        } else {
                            System.out.println("no registration yet!");
                        }

                        break;
                    case 9:
                        UI.main(null);
                        break;
                    case 10:
                        System.out.println("thank you!");
                        break;
                    default:
                        System.out.println("invalid option!");
                }
            } while (choice != 10);
        } catch (InputMismatchException w) {
            System.err.println("wrong input!");

        } catch (NullPointerException w) {
            System.err.println("wrong object!");
        } catch (ClassCastException w) {
            System.err.println("wrong downcasting!");

        } catch (ArrayIndexOutOfBoundsException w) {
            System.err.println("invalid index!");
        }
    }

    public static void List(ArrayList<Service> list) {

        list.add(new Wash(1, "conveyor car wash", 25.0, null, "Automatic wash"));
        list.add(new Wash(2, "touchless car wash", 20.0, null, "Automatic wash"));
        list.add(new Wash(3, "hand car wash", 15.0, null, "Hand Wash"));
        list.add(new Wash(4, "full-service car wash", 10.0, null, "Hand Wash"));
        list.add(new Polish(5, "conveyor car wash", 25.0, null, "Automatic wash"));
        list.add(new Polish(6, "touchless car wash", 20, null, "Automatic wash"));
        list.add(new Polish(7, "hand car wash", 15, null, "Hand Wash"));
        list.add(new Polish(8, "Adam's One Step Polish", 10, null, "Hand Wash"));
        list.add(new Detailing(9, "conveyor car wash", 25.0, null, "Turtle Wax Hybrid Solutions Ceramic Polish and Wax"));
        list.add(new Detailing(10, "touchless car wash", 20.0, null, "Adam's One Step Polish"));
        list.add(new Detailing(11, "hand car wash", 15.0, null, "Chemical Guys All-in-One Polish and Sealant"));
        list.add(new Detailing(12, "full-service car wash", 10.0, null, "Meguiar's Ultimate Polish"));
    }
}
