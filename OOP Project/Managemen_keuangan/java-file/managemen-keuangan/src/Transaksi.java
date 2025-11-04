import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Transaksi {
    long nominal;
    String kategori;
    ArrayList<Riwayat> riwayat = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    // ini pemasukan cuy!
    public void pemasukan() {
        long val;
        String sumber;
        String tanggal = LocalDateTime.now().toString();

        System.out.println("=== PEMASUKAN ===");
        while (true) {
            try {
                System.out.print("Masukkan Nominal  : ");
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
        this.nominal = this.nominal + val;
        System.out.println("\n");
    }

    // nah yang ini pengeluaran cuy
    public void pengeluaran(){
        long val;
        String alasan;
        String tanggal = LocalDateTime.now().toString();

        System.out.println("=== PENGELUARAN ===");
        while (true) {
            try {
                System.out.print("Masukkan Nominal  : ");
                val = scan.nextLong();

                // TODO: Ubah ke rupiah nanti
                if(nominal - val < 50) {
                    System.out.println("Saldo kurang!\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid!");
                scan.nextLine();
            }
        }
        scan.nextLine();
        System.out.print("Jenis Pengeluaran : ");
        alasan = scan.nextLine();

        Riwayat data = new Riwayat(val, alasan, tanggal, 0);
        riwayat.add(data);
        this.nominal = this.nominal - val;
        System.out.println("\n");
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

    public void cekSaldo(){
        System.out.println("=== CEK SALD0 ===");
        System.out.println("Saldo sekarang: " + this.nominal + "\n");
    }
}
