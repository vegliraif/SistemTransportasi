public class Tiket {
    private String kodeTiket;
    private Penumpang penumpang;
    private double harga;

    public Tiket(String kodeTiket, Penumpang penumpang, double harga) {
        this.kodeTiket = kodeTiket;
        this.penumpang = penumpang;
        this.harga = harga;
    }

    public void tampilkanTiket() {
        System.out.println("Kode Tiket: " + kodeTiket + ", Penumpang: " + penumpang.getNama() + ", Harga: " + harga);
    }
}
