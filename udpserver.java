import java.net.*;
import java.io.*;


public class udpserver {

    public static int indexof(String array[],String str){
        str = str.trim();
        for(int i = 0;i < array.length;i++){
            if (array[i].equals(str)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[])throws Exception{
        String[] hosts = {"yahoo.com", "gmail.com", "cricinfo.com", "facebook.com","adhi.com"};
        String[] ip = {"68.180.206.184", "209.85.148.19", "80.168.92.140", "69.63.189.16","89.45.32.45"};
        while(true){
            DatagramSocket server = new DatagramSocket(7800);
            byte send[],rece[];
            rece = new byte[1024];
            System.out.println("CTED");
            DatagramPacket rp = new DatagramPacket(rece,rece.length);
            server.receive(rp);
            System.out.println("CONNECTED");
            String ho = new String(rp.getData());
            int port  = rp.getPort();
            InetAddress ipa = rp.getAddress();
            String sendd;
            if ((indexof(hosts,ho))!=-1){
                sendd = ip[indexof(hosts,ho)];
            }
            else{
                sendd = "host not available";
            }
            send = sendd.getBytes();
            DatagramPacket pac = new DatagramPacket(send,send.length,ipa, port);
            server.send(pac);
            server.close();

        }
    }
}
