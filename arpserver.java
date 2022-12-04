import java.net.*;

import javax.xml.crypto.Data;

import java.io.*;


public class arpserver {
    public static void main(String args[])throws Exception{
        String ip[] = { "165.165.80.80", "165.165.79.1" };
        String mac[] = { "6A:08:AA:C2", "8A:BC:E3:FA" };
        
        ServerSocket server = new ServerSocket(6777);
        Socket s = server.accept();
        BufferedReader ds
        = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        System.out.println("Connected");
        System.out.println("from");
        String ipp = ds.readLine();
        System.out.println("out"+ipp+ip.length);
        for(int i = 0;i<ip.length;i++){
            System.out.println("helloe");
            if (ipp.equals(ip[i])){
                System.out.println("hai");
                dout.writeBytes(mac[i]);
                break;
            }
        }
        System.out.println("out");
        din.close();
        dout.close();
        s.close();
    }
}
