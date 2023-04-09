import java.io.*;
import java.util.Scanner;
public class Main {
    private String elitKisiBilgileri;
    private String genelKisiBilgileri;
    public boolean deger = true;
    public int x = 0;
    public int y = 0;

    public String getElitKisiBilgileri() {
        return this.elitKisiBilgileri;
    }

    public void setElitKisiBilgileri(String elitKisiBilgileri) {
        this.elitKisiBilgileri = elitKisiBilgileri;
    }

    public String getgenelKisiBilgileri() {
        return this.genelKisiBilgileri;
    }

    public void setgenelKisiBilgileri(String genelKisiBilgileri) {
        this.genelKisiBilgileri = genelKisiBilgileri;
    }

    public static void main(String[] args) throws IOException {
        //diğer clasların nesneleri
        Main main = new Main();
        DosyaIslemleri dosyaIslemleri = new DosyaIslemleri();
        MailGonderme mailGonderme = new MailGonderme();
        while (main.deger == true) {     //birden fazla kullanıcı girmek için
            System.out.println("lütfen yapmak istediğiniz işlemi seçiniz \n1-elit üye ekleme\n2-Genel üye ekleme\n3-Mail gönderme");
            //1.menü
            Scanner input = new Scanner(System.in);
            int a = input.nextInt();
            switch (a) {
                case 1:
                    //elit üye eklemeden önce #elit üye# başlığı oluşturması için dosya işlemi
                    if (main.x < 1)   //yalnızca 1 kere oluşturulması için
                    {
                        File p = new File("kullanıcılar.txt");
                        if (!p.exists())
                        {
                            p.createNewFile();
                        }
                        FileWriter fWriter = new FileWriter(p, false);
                        BufferedWriter bWriter = new BufferedWriter(fWriter);
                        bWriter.write("#elit üyeler#\n");
                        bWriter.close();
                        main.x++;
                    }

                    //kullanıcı bilgilerini alır
                    System.out.println("lütfen ad soyad email giriniz");
                    Scanner b = new Scanner(System.in);
                    String elitKisiBilgileri = b.nextLine();
                    dosyaIslemleri.elitUyeEkleme(elitKisiBilgileri);
                    main.x++;
                    break;

                case 2:
                    //genel üye eklemeden önce #genel üye# başlığı oluşturması için dosya işlemi
                    if (main.y < 1) {      //yalnızca 1 kere oluşturulması için
                        File f = new File("kullanıcılar.txt");
                        if (!f.exists()) {
                            f.createNewFile();
                        }
                        FileWriter fileWriter = new FileWriter(f, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write("\n#genel üyeler#\n");
                        bufferedWriter.close();
                        main.y++;
                    }

                    //kullanıcı bilgilerini alır
                    System.out.println("lütfen ad soyad email giriniz");
                    Scanner c = new Scanner(System.in);
                    String genelKisiBilgileri = c.nextLine();
                    dosyaIslemleri.genelUyeEkleme(genelKisiBilgileri);
                    main.y++;
                    break;

                case 3:
                    mailGonderme.mailGonderme(main.x,main.y);
                    main.deger = false;
                    break;

                default:
                    System.out.println("yanlış sayı tuşladınız");
                    break;
            }
        }
    }
}
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
