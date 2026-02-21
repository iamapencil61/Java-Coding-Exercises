import java.util.Scanner;

interface AsciiHesaplayici {
    int hesapla(char c);
    int hesapla(char... karakterler);
    int hesapla(String metin);
}

abstract class AsciiHesapTemel implements AsciiHesaplayici {

    public int hesapla(char c) {
        return c;
    }

    protected int charArrayToplam(char[] chars) {
        int toplam = 0;
        for (char c : chars) {
            toplam += c;
        }
        return toplam;
    }
}

class AsciiHesaplayiciImpl extends AsciiHesapTemel {

    @Override
    public int hesapla(char... karakterler) {
        return charArrayToplam(karakterler);
    }

    @Override
    public int hesapla(String metin) {
        return charArrayToplam(metin.toCharArray());
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AsciiHesaplayici asciiHesaplayici = new AsciiHesaplayiciImpl();

        System.out.println("Hangi tür input girmek istersiniz?");
        System.out.println("1: Tek karakter");
        System.out.println("2: Birden fazla karakter (aralarında boşlukla)");
        System.out.println("3: Bir kelime/cümle (String)");
        System.out.print("Seçiminiz (1, 2, 3): ");
        int secim = scanner.nextInt();
        scanner.nextLine();

        switch (secim) {
            case 1:
                System.out.print("Bir karakter girin: ");
                char c = scanner.nextLine().charAt(0);
                System.out.println("ASCII Değeri: " + asciiHesaplayici.hesapla(c));
                break;
            case 2:
                System.out.print("Karakterleri boşlukla ayırarak girin (ör: A B C): ");
                String input = scanner.nextLine();
                String[] karakterDizisi = input.split(" ");
                char[] chars = new char[karakterDizisi.length];
                for (int i = 0; i < karakterDizisi.length; i++) {
                    chars[i] = karakterDizisi[i].charAt(0);
                }
                System.out.println("ASCII Toplamı: " + asciiHesaplayici.hesapla(chars));
                break;
            case 3:
                System.out.print("Bir kelime veya cümle girin: ");
                String metin = scanner.nextLine();
                System.out.println("ASCII Toplamı: " + asciiHesaplayici.hesapla(metin));
                break;
            default:
                System.out.println("Geçersiz seçim!");
        }
    }
}