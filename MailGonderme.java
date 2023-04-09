import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
public class MailGonderme {
    public int i=0;
    public int j=0;
    public static void  elitdosyaOku(String dosyakonumu,int x)       //dosya okuma işlemleri (mail kısmını yapamadım)
    {
        MailGonderme mailGonderme=new MailGonderme();
        BufferedReader yaz;
        try
            {
            yaz = new BufferedReader(new FileReader(dosyakonumu,Charset.forName("UTF8")));
            String satir = yaz.readLine();
                while(mailGonderme.i<x){
                    System.out.println(satir);
                    satir = yaz.readLine();
                    mailGonderme.i++;
                }
            yaz.close();
            }

        catch (IOException e)
            {
            e.printStackTrace();
            }
    }
    public static void  geneldosyaOku(String dosyakonumu,int x,int y)       //dosya okuma işlemleri (mail kısmını yapamadım)
    {
        MailGonderme mailGonderme=new MailGonderme();
        BufferedReader yaz;
        try
        {
            yaz = new BufferedReader(new FileReader(dosyakonumu,Charset.forName("UTF8")));
            String satir = yaz.readLine();
            int a=x+y+1;
            while(mailGonderme.j<a){
                System.out.println(satir);
                satir = yaz.readLine();
                mailGonderme.j++;

            }
            yaz.close();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void mailGonderme(int x,int y)
    {
        MailGonderme mailGonderme=new MailGonderme();
        Main main=new Main();
        System.out.println("lütfen yapmak istediğiniz işlemi seçiniz\n1-elit üyelere mail gönderme\n2-Genel üyelere mail gönderme\n3-tüm kullanıcılara mail gönderme");
        //2. menü
        Scanner input =new Scanner(System.in);
        int b=input.nextInt();
        switch (b)
            {
            case 1:
                mailGonderme.elitdosyaOku("kullanıcılar.txt",x);

                break;
            case 2:
                mailGonderme.geneldosyaOku("kullanıcılar.txt",x,y);

                break;
            case 3:
                mailGonderme.elitdosyaOku("kullanıcılar.txt",x);
                mailGonderme.geneldosyaOku("kullanıcılar.txt",x,y);
                break;
            default:
                System.out.println("yanlış sayı tuşladınız");
            }

    }
}
