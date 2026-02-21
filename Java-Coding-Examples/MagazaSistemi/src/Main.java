import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface MagazaYonetimi {

    void urunEkle(String urunAdi, double fiyat, int stok);
    void stokGuncelle(String urunAdi, int miktar);
    double toplamDegerHesapla();
    void envanterRaporu();
}

abstract class MagazaTemel implements MagazaYonetimi {
    protected Map<String, Urun> urunler;
    protected int islemSayisi;

    protected static class Urun {
        double fiyat;
        int stok;

        Urun(double fiyat, int stok) {
            this.fiyat = fiyat;
            this.stok = stok;
        }

        public String toString() {
            return "Fiyat: " + fiyat + ", Stok: " + stok;
        }
    }

    protected MagazaTemel() {
        urunler = new HashMap<>();
        islemSayisi = 0;
    }

    protected boolean urunEklemeKontrol(String urunAdi) {
        return !urunler.containsKey(urunAdi);
    }

    protected boolean stokKontrol(String urunAdi, int miktar) {
        Urun urun = urunler.get(urunAdi);
        if (urun == null || (urun.stok + miktar) < 0) {
            return false;
        }
        return true;
    }
}

class MagazaYonetimiImpl extends MagazaTemel {
    @Override
    public void urunEkle(String urunAdi, double fiyat, int stok) {
        if (stok < 0) {
            System.out.println("Hata: Stok negatif olamaz!");
            return;
        }
        if (urunEklemeKontrol(urunAdi)) {
            urunler.put(urunAdi, new Urun(fiyat, stok));
            islemSayisi++;
            System.out.println(urunAdi + " mağazaya eklendi.");
        }
        else {
            System.out.println("Hata: " + urunAdi + " zaten mağazada!");
        }
    }

    @Override
    public void stokGuncelle(String urunAdi, int miktar) {
        if (stokKontrol(urunAdi, miktar)) {
            Urun urun = urunler.get(urunAdi);
            urun.stok += miktar;
            islemSayisi++;
            System.out.println(urunAdi + " stoku güncellendi: Yeni stok = " + urun.stok);
        }
        else {
            System.out.println("Hata: " + urunAdi + " için stok güncellenemedi!");
        }
    }

    @Override
    public double toplamDegerHesapla() {
        double toplamDeger = 0;
        for (Urun urun : urunler.values()) {
            toplamDeger += urun.fiyat * urun.stok;
        }
        islemSayisi++;
        return toplamDeger;
    }

    @Override
    public void envanterRaporu() {
        System.out.println("Envanter Durumu:");
        if (urunler.isEmpty()) {
            System.out.println("Mağazada ürün yok!");
        } else {
            for (Map.Entry<String, Urun> entry : urunler.entrySet()) {
                System.out.println("Ürün: " + entry.getKey() + ", " + entry.getValue());
            }
        }
        System.out.println("Toplam İşlem Sayısı: " + islemSayisi);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MagazaYonetimi magaza = new MagazaYonetimiImpl();

        while (true) {
            System.out.println("\nOnline Mağaza Envanter Sistemi");
            System.out.println("1: Ürün Ekle");
            System.out.println("2: Stok Güncelle");
            System.out.println("3: Toplam Değeri Hesapla");
            System.out.println("4: Envanter Raporu");
            System.out.println("5: Çıkış");
            System.out.print("Seçiminiz (1-5): ");
            int secim = scanner.nextInt();
            scanner.nextLine(); 

            if (secim == 5) {
                System.out.println("Sistemden çıkılıyor...");
                break;
            }

            switch (secim) {
                case 1:
                    System.out.print("Ürün adını girin: ");
                    String urunAdi = scanner.nextLine();
                    System.out.print("Fiyatı girin: ");
                    double fiyat = scanner.nextDouble();
                    System.out.print("Stok miktarını girin: ");
                    int stok = scanner.nextInt();
                    scanner.nextLine();
                    magaza.urunEkle(urunAdi, fiyat, stok);
                    break;
                case 2:
                    System.out.print("Ürün adını girin: ");
                    String guncelUrun = scanner.nextLine();
                    System.out.print("Stok değişikliğini girin (eklemek için pozitif, çıkarmak için negatif): ");
                    int miktar = scanner.nextInt();
                    scanner.nextLine();
                    magaza.stokGuncelle(guncelUrun, miktar);
                    break;
                case 3:
                    System.out.println("Mağazanın Toplam Değeri: " + magaza.toplamDegerHesapla());
                    break;
                case 4:
                    magaza.envanterRaporu();
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }

        scanner.close();
    }
}
