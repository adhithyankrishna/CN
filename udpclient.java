import java.net.*;
import java.io.*;
import java.util.*;


public class udpclient {
    
    public static void main(String args[])throws Exception{
        Scanner in = new Scanner(System.in);
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the url : ");
        String ur = rd.readLine();
        byte bytes[] = ur.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length,InetAddress.getByName("Localhost"),7800);
        DatagramSocket s = new DatagramSocket();
        s.send(packet);
        System.out.println("Sensdata"+bytes);
        s.receive(packet);
        String ip = new String(packet.getData());
        System.out.println("ip "+ip);
        s.close();
    }
}