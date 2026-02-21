import java.util.Scanner;

public class Main {
    public static boolean is_valid(String username, String password) {
        if (username.equals( "admin")) {
            return true;
        }
        if (username.equals("user")) {
            if (password.equals("qweasd")) {
                return true;
            }
            else  {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        String pass = scanner.nextLine();
        boolean res = is_valid(user, pass);
        System.out.println(res);
    }
}