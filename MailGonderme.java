import java.util.Scanner;

public class MailGonderme {
    public static void mailGonderme(){
        System.out.println("lütfen yapmak istediğiniz işlemi seçiniz\n1-elit üyelere mail gönderme\n2-Genel üyelere mail gönderme\n3-tüm kullanıcılara mail gönderme");
        //2. menü
        Scanner input =new Scanner(System.in);
        int b=input.nextInt();
        switch (b){
            case 1:
            case 2:
            case 3:
            default:
                System.out.println("yanlış sayı tuşladınız");
        }
    }
}
