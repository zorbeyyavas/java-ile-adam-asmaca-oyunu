import java.util.Random;
import java.util.Scanner;

public class adamasmaca {

    static String harf;
    static int dogru;
    static int sec;
    static int hak;
    static boolean kontrol = true;
    static int puan;
    public static void main(String[] args) {
        
         String hayvanlar[] = {"balık", "zürafa","aslan","kaplan","kaplumbağ","yılan"};
        String esya[] = {"dolap", "yatak","kitap","askılık"};
        String kelimeler[] = {"masa", "telefon", "sandelye", "perde", "halı", "kalemlik", "kupa", "bilgisayar"};
        Random rastgele = new Random();
        Scanner bilgioku = new Scanner(System.in);

        while (kontrol) {
            dogru = 0;  
            sec = rastgele.nextInt(3) + 1;  
            String tutulankelime = "";

            if (sec == 1) {
                int kacincikelime = rastgele.nextInt(kelimeler.length);
                tutulankelime = kelimeler[kacincikelime];
                System.out.print(tutulankelime.length() + " harfli kelime: ");
            } else if (sec == 2) {
                int kacincikelime = rastgele.nextInt(hayvanlar.length);
                tutulankelime = hayvanlar[kacincikelime];
                System.out.print(tutulankelime.length() + " harfli hayvan: ");
            } else if (sec == 3) {
                int kacincikelime = rastgele.nextInt(esya.length);
                tutulankelime = esya[kacincikelime];
                System.out.print(tutulankelime.length() + " harfli eşya: ");
            }

            hak = tutulankelime.length();
            String altcizgi[] = new String[tutulankelime.length()];

            for (int i = 0; i < tutulankelime.length(); i++) {
                altcizgi[i] = "-";
                System.out.print(altcizgi[i] + " ");
            }
            System.out.println();

            while (hak > 0 && dogru < tutulankelime.length()) {
                System.out.print("Bir harf giriniz: ");
                harf = bilgioku.next();
                boolean harfbulundu = false;

                for (int i = 0; i < tutulankelime.length(); i++) {
                    if (tutulankelime.charAt(i) == harf.charAt(0)) {
                        if (altcizgi[i].equals("-")) {
                            altcizgi[i] = harf.charAt(0) + "";
                            dogru++;
                            harfbulundu = true;
                        }
                    }
                }

                if (harfbulundu) {
                    System.out.println("Doğru bildiniz, tebrikler!");
                    puan=puan+10;
                    System.out.println(puan);
                } else {
                    hak--;
                    System.out.println("Yanlış cevap, kalan hak: " + hak);
                }

                for (String karakter : altcizgi) {
                    System.out.print(karakter + " ");
                }
                System.out.println();
            }

            if (dogru == tutulankelime.length()) {
                System.out.println("Tebrikler, kelimeyi doğru bildiniz: " + tutulankelime);
            } else {
                System.out.println("Üzgünüm, hakkınız doldu. Doğru kelime: " + tutulankelime);
            }

            System.out.println("Devam etmek için 1, çıkmak için 2 giriniz:");
            int devam = bilgioku.nextInt();
            if (devam == 2) {
                kontrol = false;
                System.out.println("Oyun bitti. Teşekkürler!");
            }

    }
    
    }
}
