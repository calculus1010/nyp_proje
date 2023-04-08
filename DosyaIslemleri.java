import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DosyaIslemleri {

    public static void elitUyeEkleme() throws IOException
        {
            //elit üyeler için dosya işlemleri
            System.out.println("lütfen ad soyad email giriniz");
            Scanner input =new Scanner(System.in);
            String adSoyadEmail=input.nextLine();
            //dosya işlemleri
            File f=new File("elitUye.txt");
            if(!f.exists())
            {
                f.createNewFile();
            }
            FileWriter fWriter=new FileWriter(f,false);
            BufferedWriter bWriter=new BufferedWriter(fWriter);
            bWriter.write(adSoyadEmail);
            bWriter.close();
        }
    public static void genelUyeEkleme() throws IOException
    {
        //genel üyeler için dosya işlemleri
        System.out.println("lütfen ad soyad email giriniz");
        Scanner input =new Scanner(System.in);
        String adSoyadEmail=input.nextLine();
        //dosya işlemleri
        File p=new File("genelUye.txt");
        if(!p.exists())
        {
            p.createNewFile();
        }
        FileWriter fWriter=new FileWriter(p,false);
        BufferedWriter bWriter=new BufferedWriter(fWriter);
        bWriter.write(adSoyadEmail);
        bWriter.close();
    }
}
