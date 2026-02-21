import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface KutuphaneYonetimi {
    void kitapEkle(String kitapAdi);
    void kitapOduncAl(String kitapAdi, String uyeAdi);
    void kitapIadeEt(String kitapAdi);
    void durumRaporu();
}

abstract class KutuphaneTemel implements KutuphaneYonetimi {

    protected List<String> kitaplar;
    protected List<String> oduncKitaplar;
    protected int islemSayisi;

    protected KutuphaneTemel() {
        kitaplar = new ArrayList<>();
        oduncKitaplar = new ArrayList<>();
        islemSayisi = 0;
    }

    protected boolean kitapEklemeKontrol(String kitapAdi) {
        if (kitaplar.contains(kitapAdi)) {
            return false;
        }
        kitaplar.add(kitapAdi);
        islemSayisi++;
        return true;
    }

    protected boolean oduncAlmaKontrol(String kitapAdi) {
        if (!kitaplar.contains(kitapAdi) || oduncKitaplar.contains(kitapAdi)) {
            return false;
        }
        oduncKitaplar.add(kitapAdi);
        islemSayisi++;
        return true;
    }

    protected boolean iadeKontrol(String kitapAdi) {
        if (!oduncKitaplar.contains(kitapAdi)) {
            return false;
        }
        oduncKitaplar.remove(kitapAdi);
        islemSayisi++;
        return true;
    }
}

class KutuphaneYonetimiImpl extends KutuphaneTemel {

    @Override
    public void kitapEkle(String kitapAdi) {
        if (kitapEklemeKontrol(kitapAdi)) {
            System.out.println(kitapAdi + " kütüphaneye eklendi.");
        }
        else {
            System.out.println("Hata: " + kitapAdi + " zaten kütüphanede!");
        }
    }

    @Override
    public void kitapOduncAl(String kitapAdi, String uyeAdi) {
        if (oduncAlmaKontrol(kitapAdi)) {
            System.out.println(kitapAdi + ", " + uyeAdi + " tarafından ödünç alındı.");
        }
        else {
            System.out.println("Hata: " + kitapAdi + " ödünç alınamaz!");
        }
    }

    @Override
    public void kitapIadeEt(String kitapAdi) {
        if (iadeKontrol(kitapAdi)) {
            System.out.println(kitapAdi + " iade edildi.");
        }
        else {
            System.out.println("Hata: " + kitapAdi + " iade edilemez!");
        }
    }

    @Override
    public void durumRaporu() {
        System.out.println("Kütüphane durumu: ");
        System.out.println("Mevcut kitaplar: " + kitaplar);
        System.out.println("Ödünç alınan kitaplar: " + oduncKitaplar);
        System.out.println("Toplam işlem sayısı: " + islemSayisi);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        KutuphaneYonetimi kutuphaneYonetimi = new KutuphaneYonetimiImpl();

        while (true) {
            System.out.println("\nKütüphane Yönetim Sistemi");
            System.out.println("1: Kitap Ekle");
            System.out.println("2: Kitap Ödünç Al");
            System.out.println("3: Kitap İade Et");
            System.out.println("4: Durum Raporu");
            System.out.println("5: Çıkış");
            System.out.print("Seçiminiz (1-5): ");
            int secim = scanner.nextInt();
            scanner.nextLine();

            if (secim == 5) {
                System.out.println("Sistemden çıkıyor...");
                break;
            }

            switch (secim) {
                case 1:
                    System.out.print("Kitap adını girin: ");
                    String kitapAdi = scanner.nextLine();
                    kutuphaneYonetimi.kitapEkle(kitapAdi);
                    break;
                case 2:
                    System.out.print("Kitap adını girin: ");
                    String oduncKitap = scanner.nextLine();
                    System.out.print("Üye adını girin: ");
                    String uyeAdi = scanner.nextLine();
                    kutuphaneYonetimi.kitapOduncAl(oduncKitap, uyeAdi);
                    break;
                case 3:
                    System.out.print("İade edilecek kitap adını girin: ");
                    String iadeKitap = scanner.nextLine();
                    kutuphaneYonetimi.kitapIadeEt(iadeKitap);
                    break;
                case 4:
                    kutuphaneYonetimi.durumRaporu();
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}
