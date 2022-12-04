import java.net.*;
import javax.swing.*;
import javax.xml.crypto.Data;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;

public class adhiServer {
    public  static void main(String args[]){
        try{
            ServerSocket server ;
            Socket soc;
            server = new ServerSocket(4000);
            soc  = server.accept();
            InputStream in = soc.getInputStream();
            DataInputStream ds = new DataInputStream(in);
            BufferedImage img;
            int len  = ds.readInt();
            System.out.println("hghh"+len);
            byte []bytes = new byte[len];
            ds.readFully(bytes);
            InputStream ian = new ByteArrayInputStream(bytes);
            img = ImageIO.read(ian);
            JFrame fr = new JFrame();
            JLabel l = new JLabel();
            ImageIcon ic = new ImageIcon(img);
            l.setIcon(ic);
            fr.add(l);
            fr.pack();

        }
        catch(Exception E){
            System.out.println(E);
        }
    }
}
