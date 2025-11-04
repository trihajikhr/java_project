import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Transaksi {
    long nominal;
    String kategori;
    ArrayList<Riwayat> riwayat = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    public void pemasukan() {
        long val;
        String sumber;
        String tanggal = LocalDateTime.now().toString();

        System.out.println("=== PEMASUKAN ===");
        while (true) {
            try {
                System.out.print("Masukkan Nominal : ");
                val = scan.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid!");
                scan.nextLine();
            }
        }
        scan.nextLine();
        System.out.print("Masukan Sumber    : ");
        sumber = scan.nextLine();

        Riwayat data = new Riwayat(val, sumber, tanggal, 1);
        riwayat.add(data);
    }

    public void pengeluaran(int val, String kategori){
         this.nominal = this.nominal - val;
    }

    public void tampilRiwayat() {
        System.out.println("=== TAMPIL RIWAYAT ===");
        for(int i=0; i<riwayat.size(); i++){
            System.out.println("Transaksi ke        : " + (i+1));
            System.out.print("Tipe transaksi      : ");
            if(riwayat.get(i).tipe == 1) {
                System.out.println("Pemasukan");
            } else {
                System.out.println("Pengeluaran");
            }
            System.out.println("Nominal transaksi   : " + riwayat.get(i).nominal);
            System.out.println("Sumber transaksi    : " + riwayat.get(i).sumber);
            System.out.println("Tanggal transaksi   : " + riwayat.get(i).date + "\n");
        }
    }
}
