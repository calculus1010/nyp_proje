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
