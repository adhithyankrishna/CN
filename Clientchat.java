import java.io.*;
import java.net.*;

public class Clientchat {
    public static DatagramSocket ds;
    public static int clientport = 4000, serverport = 4001;
    public static void main(String args[])throws Exception{
        ds = new DatagramSocket(serverport);
        byte buffer[]  = new byte[1024];
        String line ;
        BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
        InetAddress ia = InetAddress.getLocalHost();
        while(true){
            System.out.println("Client: ");
            line = dis.readLine();
            if (line.equals("end")){
                break;
            }
            buffer = line.getBytes();
            ds.send(new DatagramPacket(buffer, buffer.length,ia,clientport));
            System.out.println(ia);
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            String psc = new String(p.getData(),0,p.getLength());
            System.out.println("Server: "+psc);
        }

    } 
}
