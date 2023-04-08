import java.io.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
        DosyaIslemleri dosyaIslemleri=new DosyaIslemleri();
        MailGonderme mailGonderme=new MailGonderme();
        System.out.println("lütfen yapmak istediğiniz işlemi seçiniz \n1-elit üye ekleme\n2-Genel üye ekleme\n3-Mail gönderme");
        //1.menü
        Scanner input=new Scanner(System.in);
        int a= input.nextInt();
        switch (a){
            case 1:
                dosyaIslemleri.elitUyeEkleme();
                break;
            case 2:
                dosyaIslemleri.genelUyeEkleme();
                break;
            case 3:
                mailGonderme.mailGonderme();
                break;
            default:
                System.out.println("yanlış sayı tuşladınız");
    }
}}