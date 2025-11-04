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
    void pemasukan() {
        long val;
        String sumber;
        LocalDateTime tanggal = LocalDateTime.now();

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
    void pengeluaran(){
        long val;
        String alasan;
        LocalDateTime tanggal = LocalDateTime.now();

        System.out.println("=== PENGELUARAN ===");
        while (true) {
            try {
                System.out.print("Masukkan Nominal  : ");
                val = scan.nextLong();

                // TODO: Ubah ke rupiah nanti
                if(nominal - val < 50) {
                    System.out.println("Saldo kurang!\n");
                    System.out.print("0:Cancel - 1:Lanjut: ");
                    int next = scan.nextInt();
                    if(next == 0) {
                        return;
                    }
                    continue;
                }

                val = val * -1;
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

    // bagian tampil riwayat sih
    void tampilRiwayat() {
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

    // bagian cek saldo aja sih
    public void cekSaldo(){
        System.out.println("=== CEK SALD0 ===");
        System.out.println("Saldo sekarang: " + this.nominal + "\n");
    }

    // fungsi untuk analisis, tapi lumyaan susah
    void analisisHelper(long sum) {
        if(sum == 0){
            System.out.println("Saldo Anda Tetap\n");
        } else if(sum > 0){
            System.out.println("Saldo Anda Bertambah, Pertahankan!\n");
        } else if(sum < 0){
            System.out.println("Saldo Anda Berkurang, Lebih Hemat!\n");
        }
    }
    void analisis(){
        System.out.println("=== ANALISIS ===");
        if(riwayat.isEmpty()){
            System.out.println("Tidak ada Riwayat Transaksi\n");
            return;
        }

        System.out.println("Pilih hari analisis: ");
        System.out.println("1. Hari");
        System.out.println("2. Minggu");
        System.out.println("3. Bulan");
        System.out.print("Pilihan anda: ");
        int pil =  scan.nextInt();

        LocalDateTime now = LocalDateTime.now();
        long sum=0;
        if(pil == 1){
            LocalDateTime batas24Jam = LocalDateTime.now().minusHours(24);
            for (Riwayat r : riwayat) {
                if (r.date.isAfter(batas24Jam)) {
                    sum += r.nominal;
                }
            }
            System.out.println("Transaksi selama 24 jam: " + sum);
            analisisHelper(sum);
        } else if(pil == 2){
            LocalDateTime batas7Hari = LocalDateTime.now().minusDays(7);
            for (Riwayat r : riwayat) {
                if(r.date.isAfter(batas7Hari)) {
                    sum += r.nominal;
                }
            }
            System.out.println("Transaksi selama 7 hari: " + sum);
            analisisHelper(sum);
        } else if (pil == 3){
            LocalDateTime batas30Hari =  LocalDateTime.now().minusDays(30);
            for(Riwayat r : riwayat){
                if(r.date.isAfter(batas30Hari)) {
                    sum += r.nominal;
                }
            }
            System.out.println("Transaksi selama 30 hari: " + sum);
            analisisHelper(sum);
        }
    }
}
