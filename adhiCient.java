import javax.imageio.*;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import java.net.*;
import java.io.BufferedOutputStream;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage.*;
import java.awt.image.BufferedImage;
class adhiClient{
    public static void main(String args[]){
        Socket soc = null;
        BufferedImage img = null;
        try{
        soc  = new Socket("localhost",4000);
        
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            System.out.println("Client is running ");
            img  = ImageIO.read(new File ("hai.jpg"));
            ByteArrayOutputStream baos  = new ByteArrayOutputStream();
            ImageIO.write(img,"jpg", baos);
            baos.flush();
            byte bytes[] = baos.toByteArray();
            OutputStream ot = soc.getOutputStream();
            DataOutputStream ds = new DataOutputStream(ot);
            ds.writeInt(bytes.length);
            ds.write(bytes, 0,bytes.length);
            System.out.println("sent successfully");
            ot.close();
            ds.close();
            soc.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}