import java.io.*;
import java.net.*;

public class adhiEclient {
    public static void main(String args[]){
    try{
        Socket s = null;
        try{
        InetAddress ia = InetAddress.getLocalHost();
        s = new Socket(ia,9000);
        }
        catch(IOException e){
            System.out.println("from " +e);
        }
        String line;
        DataInputStream is,isi;
        PrintStream os;
        is = new DataInputStream(System.in);
        isi = new DataInputStream(s.getInputStream());
        os = new PrintStream(s.getOutputStream());
        while(true){
            System.out.print("Client: ");
            line  = is.readLine();
            System.out.println(line);
            os.println(line);
            System.out.println("hh");
            try{
                System.out.println("hlo  "+isi.readLine());
            }
            catch(IOException E){
                System.out.println(E);
            }

        }
        

    }
    catch (Exception e) {
        System.out.println("from 3 "+e);
    }
}
}
