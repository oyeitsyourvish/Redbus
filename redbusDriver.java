import java.net.SocketTimeoutException;
import java.rmi.StubNotFoundException;
import java.util.Scanner;

class redbusDriver {
    Redbus r;
    Account a;
    Scanner sc = new Scanner(System.in);
    private int vaccinated;

    public void logIn() {
        if (a == null) {
            System.out.println("Enter the Name");
            String name = sc.next();
            System.out.println("Enter the Address");
            String address = sc.next();
            System.out.println("Are you Vaccinated :- 1.Yes  2.No");
            if (sc.nextInt() == 1) {
                System.out.println("Welcome");
            } else {
                a = null;
                System.out.println("You are Not Allowded to Travel");
            }

            a = new Account(name, address, vaccinated);
            System.out.println("Account Created Successfully");
        } // end of if.
        else {
            System.out.println("Account has been Existed");
        }
    }
    // ----------------------------

    public void logOut() {
        if (a == null) {
            System.out.println("Create Account First");
        } else {
            a = null;
            {
                System.out.println("Logout Successfully...");
            }
        }

    }
    // ----------------------------

    public void bookTicket() {
        if (a == null) {
            System.out.println("Please Login First");
        } else {
            System.out.println("1.National  2.VRL  3.Sea Bird");
            switch (sc.nextInt()) {
                case 1: {
                    System.out.println("Enter Pickup City");
                    String from = sc.next();
                    System.out.println("Enter the Destination");
                    String to = sc.next();
                    System.out.println("Enter the Date");
                    String date = sc.next();
                    System.out.println("How many Kilo Meter");
                    int km = sc.nextInt();
                    r = new nationalTravel(from, to, date, km);
                    System.out.println("Your Choosed National Travel");
                    System.out.println("1.Confirm   2.Cancel");
                    if (sc.nextInt() == 1) {
                        payment();
                    } else {
                        r = null;
                        System.out.println("Sorry Cancelled");
                    }
                }
                    break;

                case 2: {
                    System.out.println("Enter Pickup City");
                    String from = sc.next();
                    System.out.println("Enter the Destination");
                    String to = sc.next();
                    System.out.println("Enter the Date");
                    String date = sc.next();
                    System.out.println("How many Kilo Meter");
                    int km = sc.nextInt();
                    r = new vrlTravel(from, to, date, km);
                    System.out.println("Your Choosed VRL Travel");
                    System.out.println("1.Confirm   2.Cancel");
                    if (sc.nextInt() == 1) {
                        payment();
                    } else {
                        r = null;
                        System.out.println("Sorry Cancelled");
                    }
                }
                    break;
                case 3: {
                    System.out.println("Enter Pickup City");
                    String from = sc.next();
                    System.out.println("Enter the Destination");
                    String to = sc.next();
                    System.out.println("Enter the Date");
                    String date = sc.next();
                    System.out.println("How many Kilo Meter");
                    int km = sc.nextInt();
                    r = new seabirdTravel(from, to, date, km);
                    System.out.println("Your Choosed Sea Bird Travel");
                    System.out.println("1.Confirm   2.Cancel");
                    if (sc.nextInt() == 1) {
                        payment();
                    } else {
                        r = null;
                        System.out.println("Sorry Cancelled");
                    }
                }
                    break;

            }
        }
    }

    // ----------------------------

    public void cancelTicket() {
        if (a == null) {
            System.out.println("LogIn Account First");
        } else {
            System.out.println("1.Confirm To Cancel Ticket  2.Denied");
            if (sc.nextInt() == 1) {
                r = null;
                System.out.println("Your Booking is Cancelled.. ");
            } else if (sc.nextInt() == 2) {
                System.out.println("Denied to cancel Ticket");
            }

        }
    }
    // -----------------------------

    public void changeDate() {
        if (a == null) {
            System.out.println("Login Account First");
        } else {
            System.out.println("1.Confirm to ChangeDate  2.Cancel");
            if (sc.nextInt() == 1) {
                System.out.println("Enter Next Date");
                r.date = sc.next();
                System.out.println("Date is Updated");

            }

        }
    }
    // ------------------------------

    public void payment() {
        if (r instanceof nationalTravel) {
            nationalTravel nt = (nationalTravel) r;
            int money = nt.km * nt.price;
            System.out.println("From :- " + nt.from);
            System.out.println("To   :- " + nt.to);
            System.out.println("Date :- " + nt.date);
            System.out.println("Total :- " + money);
            System.out.println("1.Payment  2.Cancel");
            if (sc.nextInt() == 1) {
                System.out.println("Enter the Amount");
                int amount = sc.nextInt();
                if (amount >= money) {
                    System.out.println("National Travel Ticket Booked Thank You.....");
                } else {
                    r = null;
                    System.out.println("National Travel Booking is Cancelled.. ");
                }
            } else {
                System.out.println("Cancel");
            }

        } else if (r instanceof vrlTravel) {
            vrlTravel nt = (vrlTravel) r;
            int money = nt.km * nt.price;
            System.out.println(nt.from);
            System.out.println(nt.to);
            System.out.println(nt.date);
            System.out.println("Total :- " + money);
            System.out.println("1.Payment  2.Cancel");
            if (sc.nextInt() == 1) {
                System.out.println("Enter the Amount");
                int amount = sc.nextInt();
                if (amount >= money) {
                    System.out.println("VRL Travel Ticket Booked Thank You.....");
                } else {
                    r = null;
                    System.out.println("Booking is Cancelled.. ");
                }
            } else {
                System.out.println("Cancelled...");
            }
        }

        else if (r instanceof seabirdTravel) {
            seabirdTravel nt = (seabirdTravel) r;
            int money = nt.km * nt.price;
            System.out.println(nt.from);
            System.out.println(nt.to);
            System.out.println(nt.date);
            System.out.println("Total :- " + money);
            System.out.println("1.Payment  2.Cancel");
            if (sc.nextInt() == 1) {
                System.out.println("Enter the Amount");
                int amount = sc.nextInt();
                if (amount >= money) {
                    System.out.println("Sea Bird Travel Ticket Booked Thank You.....");
                } else {
                    r = null;
                    System.out.println("Booking is Cancelled.. ");
                }
            } else {
                System.out.println("Cancelled...");
            }
        }

    }
    // ---------------
} // end of class
