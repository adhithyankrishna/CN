import java.io.*;
import java.net.*;
import java.util.*;



public class arpclient {
    public static void main(String args[])throws Exception{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the adress");
        String ip = in.nextLine();
        InetAddress ia  = InetAddress.getLocalHost();
        Socket s = new Socket(ia,6777);
        DataInputStream din = new  DataInputStream(s.getInputStream());
        DataOutput dout  = new DataOutputStream(s.getOutputStream());
        dout.writeBytes(ip+'\n');
        System.out.print("host");
        String ho = din.readLine();
        System.out.print(ho);

    }
}
