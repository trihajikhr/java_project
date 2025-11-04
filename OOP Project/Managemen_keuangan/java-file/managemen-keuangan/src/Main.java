import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    Transaksi trans = new Transaksi();
    int pil = 1;
    do {
        System.out.println("== PROGRAM MANAGEMEN KEUANGAN PRIBADI ==");
        System.out.println("1. Pemasukan");
        System.out.println("2. Pengeluaran");
        System.out.println("3. Tabungan");
        System.out.println("4. Analisis");
        System.out.println("5. Riwayat");
        System.out.println("0. Keluar");
        System.out.print("Masukan pilihan anda: ");
        pil = scan.nextInt();

        System.out.println("\n");
        if(pil == 1){
            trans.pemasukan();
        }

    } while(pil != 0);
    }
}