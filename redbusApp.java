import java.util.Scanner;

class redbusApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        redbusDriver rd = new redbusDriver();
        for (;;) {
            System.out.println("1.LogIn  2.LogOut  3.Book Ticket  4.Cancel Ticket  5.Change Date  6.Payment  7.Exit");
            switch (sc.nextInt()) {
                case 1:
                    rd.logIn();
                    break;
                case 2:
                    rd.logOut();
                    break;
                case 3:
                    rd.bookTicket();
                    break;
                case 4:
                    rd.cancelTicket();
                    break;
                case 5:
                    rd.changeDate();
                    break;
                case 6:
                    rd.payment();
                    break;
                case 7:
                    System.exit(1);
                    break;
            }
        }
    }
}
