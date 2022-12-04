import java.net.*;
import java.io.*;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.PrintStream;

class adhiEserver{
    public static void main(String args[]){
        try{
            String line;
            ServerSocket server = new ServerSocket(9000);
            System.out.println("Server is connecting ");
            Socket s = server.accept();
            System.out.println("Server started");
            DataInputStream ds = new DataInputStream(s.getInputStream());
            PrintStream ps  = new PrintStream(s.getOutputStream());
            while (true){
                System.out.println("SERVER READING ");
                line  = ds.readLine();
                System.out.println("Server : "+line);
                ps.println(line);
            }

        }
        catch(Exception E){
            System.out.println(E);
        }

    }
}