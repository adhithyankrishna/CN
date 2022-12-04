import java.io.*;
import java.net.*;


public class FileClient {
    public static void main(String args[])throws Exception{
        Socket s = new Socket("LocalHost",4500);
        FileOutputStream file  =  new FileOutputStream("neww.docx");
        BufferedOutputStream ba = new BufferedOutputStream(file);
        InputStream is = s.getInputStream();
        byte content[] = new byte[10000];
        int bytesRead = 0;
        while((bytesRead = is.read(content)) != -1){
            ba.write(content);
        }
        ba.flush();
        s.close();
        ba.close();
    }
}
