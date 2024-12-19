public class Bus extends Kendaraan {
    private String titikAwal;
    private String titikAkhir;
    private String daftarPemberhentian;

    public Bus(String id, int kapasitas, String statusOperasional, String namaRute, String titikAwal, String titikAkhir, String daftarPemberhentian, double harga, String waktuKeberangkatan, String waktuTiba, String tanggal, double pendapatanHarian) {
        super(id, kapasitas, statusOperasional, namaRute, harga, waktuKeberangkatan, waktuTiba, tanggal, pendapatanHarian);
        this.titikAwal = titikAwal;
        this.titikAkhir = titikAkhir;
        this.daftarPemberhentian = daftarPemberhentian;
    }

    // Getter untuk atribut tambahan
    public String getTitikAwal() {
        return titikAwal;
    }

    public String getTitikAkhir() {
        return titikAkhir;
    }

    public String getDaftarPemberhentian() {
        return daftarPemberhentian;
    }

    @Override
    public String getJenis() {
        return "Bus";
    }
}
