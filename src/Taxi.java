public class Taxi extends Kendaraan {
    private String titikAwal;
    private String titikAkhir;

    public Taxi(String id, int kapasitas, String statusOperasional, String namaRute, String titikAwal, String titikAkhir, double harga, String waktuKeberangkatan, String waktuTiba, String tanggal, double pendapatanHarian) {
        super(id, kapasitas, statusOperasional, namaRute, harga, waktuKeberangkatan, waktuTiba, tanggal, pendapatanHarian);
        this.titikAwal = titikAwal;
        this.titikAkhir = titikAkhir;
    }

    // Getter untuk atribut tambahan
    public String getTitikAwal() {
        return titikAwal;
    }

    public String getTitikAkhir() {
        return titikAkhir;
    }

    @Override
    public String getJenis() {
        return "Taxi";
    }
}
