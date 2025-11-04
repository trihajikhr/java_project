public class Riwayat {
    public int tipe;
    public long nominal;
    public String sumber;
    public String date;

    Riwayat(long val, String sum, String date, int tipe){
        this.nominal = val;
        this.sumber = sum;
        this.date = date;
        this.tipe = tipe;
    }
}
