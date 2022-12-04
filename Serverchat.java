import java.io.*;
import java.net.*;


public class Serverchat {
    public static DatagramSocket ds;
   // public static DatagramPacket p;
    public static int serverport = 4001,clientport = 4000;
    public static byte buffer[] = new byte[1024];
    public static void main(String args[]) throws Exception{
        ds = new DatagramSocket(clientport);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InetAddress ia =  InetAddress.getLocalHost();
        while(true){
            DatagramPacket p = new  DatagramPacket(buffer,buffer.length);
            ds.receive(p);
            String psc = new String(p.getData(),0,p.getLength());
            System.out.println("Client: "+psc);
            psc = reader.readLine();
            buffer = psc.getBytes();
            ds.send(new DatagramPacket(buffer, psc.length(),ia,serverport));
        }

    }

}
