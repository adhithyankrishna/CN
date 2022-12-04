import java.io.*;
import java.net.*;


public class Fileserver {
    public static void main(String args[])throws Exception{
        ServerSocket server = new ServerSocket(4500);
        Socket s = server.accept();
        System.out.println("Server connected");
        File file = new File("new.docx");
        FileInputStream fi = new FileInputStream(new File("new.docx"));
        BufferedInputStream ba = new BufferedInputStream(fi);
        OutputStream out = s.getOutputStream();
        byte bytes[];
        long lenght = file.length();
        long current = 0;
        //long start = System.nanoTime();
        while(current<lenght){
            int size = 10000;
            if ((lenght - current) >= size){
                System.out.println(size);
                current+=size;
            }
            else{
                size = (int)(lenght-current);
                current = lenght;
            }
            bytes = new byte[size];
            ba.read(bytes,0,size);
            out.write(bytes);
            System.out.println("FIle sent "+(size*100)/lenght+"% send "+lenght+" "+current+" "+size);
        }
    }
}
