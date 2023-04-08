import java.io.*;
import java.util.Scanner;
public class Main {
    private String elitKisiBilgileri;
    private String genelKisiBilgileri;
    public String getElitKisiBilgileri(){
        return this.elitKisiBilgileri;
    }
    public void setElitKisiBilgileri(String elitKisiBilgileri){
        this.elitKisiBilgileri=elitKisiBilgileri;
    }
    public String getgenelKisiBilgileri(){
        return this.genelKisiBilgileri;
    }
    public void setgenelKisiBilgileri(String genelKisiBilgileri){
        this.genelKisiBilgileri=genelKisiBilgileri;
    }
    public static void main(String[] args) throws IOException
    {
        //diğer clasların nesneleri
        Main main=new Main();
        DosyaIslemleri dosyaIslemleri=new DosyaIslemleri();
        MailGonderme mailGonderme=new MailGonderme();
        System.out.println("lütfen yapmak istediğiniz işlemi seçiniz \n1-elit üye ekleme\n2-Genel üye ekleme\n3-Mail gönderme");
        //1.menü
        Scanner input=new Scanner(System.in);
        int a= input.nextInt();
        switch (a)
            {
            case 1:
                System.out.println("lütfen ad soyad email giriniz");
                Scanner b =new Scanner(System.in);
                String elitKisiBilgileri=b.nextLine();
                dosyaIslemleri.elitUyeEkleme(elitKisiBilgileri);
                break;
            case 2:
                System.out.println("lütfen ad soyad email giriniz");
                Scanner c =new Scanner(System.in);
                String genelKisiBilgileri=c.nextLine();
                dosyaIslemleri.genelUyeEkleme(genelKisiBilgileri);
                break;
            case 3:
                mailGonderme.mailGonderme();
                break;
            default:
                System.out.println("yanlış sayı tuşladınız");
                break;
            }

    }
}
