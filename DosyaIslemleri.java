import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class DosyaIslemleri {
    public static void elitUyeEkleme(String ElitKisiBilgileri) throws IOException
        {
            //girilen bilgilerin tanımlanması
            Main main=new Main();
            main.setElitKisiBilgileri(ElitKisiBilgileri);
            String adSoyadEmail = main.getElitKisiBilgileri();

            //elit üyeler için dosya işlemleri
            File f=new File("kullanıcılar.txt");
            if(!f.exists())
            {
                f.createNewFile();
            }
            FileWriter fWriter=new FileWriter(f,true);
            BufferedWriter bWriter=new BufferedWriter(fWriter);
            bWriter.write(adSoyadEmail+"\n");
            bWriter.close();

        }
    public static void genelUyeEkleme(String GenelKisiBilgileri) throws IOException
    {
        //girilen bilgilerin tanımlanması
        Main main=new Main();
        main.setgenelKisiBilgileri(GenelKisiBilgileri);
        String adSoyadEmail=main.getgenelKisiBilgileri();
        //genel üyeler için dosya işlemleri
        File p=new File("kullanıcılar.txt");
        if(!p.exists())
        {
            p.createNewFile();
        }
        FileWriter fWriter=new FileWriter(p,true);
        BufferedWriter bWriter=new BufferedWriter(fWriter);
        bWriter.write(adSoyadEmail+"\n");
        bWriter.close();
    }
}
