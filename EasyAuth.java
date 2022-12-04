import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EasyAuth {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            URL url = new URL("https://easyauth.deta.dev");
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = br.readLine();
            System.out.println(line);

            if(line.equals("true")) {
                System.out.println("Choices: 1. Register 2. Login");
                int choice = input.nextInt();

                if(choice == 1) {
                    System.out.println("Enter username: ");
                    String username = input.next();
                    System.out.println("Enter password: ");
                    String password = input.next();

                    URL url2 = new URL("https://easyauth.deta.dev/createuser?username=" + username + "&password=" + password);
                    InputStream is2 = url2.openStream();
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
                    String line2 = br2.readLine();
                    System.out.println(line2);
                } else if(choice == 2) {
                    System.out.println("Enter username: ");
                    String username = input.next();
                    System.out.println("Enter password: ");
                    String password = input.next();

                    URL url2 = new URL("https://easyauth.deta.dev/login?username=" + username + "&password=" + password);
                    InputStream is2 = url2.openStream();
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
                    String line2 = br2.readLine();
                    System.out.println(line2);
                } else {
                    System.out.println("Invalid choice");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}