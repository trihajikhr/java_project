class Kendaraan {
    public String merk;

    public void namaMerk(){
        System.out.println("Nama merk: " + this.merk);
    }
}

// konsep Inheritance
class Mobil extends Kendaraan {
    public String varian;
    Mobil(String merk, String varian){
        this.merk = merk;
        this.varian = varian;
    }

    public void namaVarian(){
        System.out.println("Nama varian: " + this.varian);
    }

    // konsep override
    @Override
    public void namaMerk(){
        System.out.println("Nama merk: " + this.merk);
    }

    // konsep overload (difungsi)
    public void namaMerk(String merk){
        System.out.println("Nama merk: " + merk);
    }

    public void namaVarian(String varian){
        System.out.println("Nama varian: " + varian);
    }
}

public class Main {
    public static void main(String[] args) {
        // konsep polimorphysm
        Kendaraan car =  new Mobil("Mitsubishi", "Xpander");
        car.namaMerk();

        // konsep overload (ketika dipanggil)
        Mobil person = new Mobil("Toyota", "SpaceY");
        person.namaMerk();
        person.namaMerk("Honda");
        person.namaVarian();
        person.namaVarian("CRF");
    }
}