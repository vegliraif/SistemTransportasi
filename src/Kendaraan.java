public class Kendaraan {
    private String id;
    private String jenis;
    private int kapasitas;
    private String statusOperasional;
    private String namaRute;
    private String titikAwal;
    private String titikAkhir;
    private String pemberhentian;
    private String waktuBerangkat;
    private String waktuTiba;
    private double harga;

    public Kendaraan(String id, String jenis, int kapasitas, String statusOperasional, String namaRute,
                     String titikAwal, String titikAkhir, String pemberhentian, String waktuBerangkat,
                     String waktuTiba, double harga) {
        this.id = id;
        this.jenis = jenis;
        this.kapasitas = kapasitas;
        this.statusOperasional = statusOperasional;
        this.namaRute = namaRute;
        this.titikAwal = titikAwal;
        this.titikAkhir = titikAkhir;
        this.pemberhentian = pemberhentian;
        this.waktuBerangkat = waktuBerangkat;
        this.waktuTiba = waktuTiba;
        this.harga = harga;
    }

    // Getter dan Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getStatusOperasional() {
        return statusOperasional;
    }

    public void setStatusOperasional(String statusOperasional) {
        this.statusOperasional = statusOperasional;
    }

    public String getNamaRute() {
        return namaRute;
    }

    public void setNamaRute(String namaRute) {
        this.namaRute = namaRute;
    }

    public String getTitikAwal() {
        return titikAwal;
    }

    public void setTitikAwal(String titikAwal) {
        this.titikAwal = titikAwal;
    }

    public String getTitikAkhir() {
        return titikAkhir;
    }

    public void setTitikAkhir(String titikAkhir) {
        this.titikAkhir = titikAkhir;
    }

    public String getPemberhentian() {
        return pemberhentian;
    }

    public void setPemberhentian(String pemberhentian) {
        this.pemberhentian = pemberhentian;
    }

    public String getWaktuBerangkat() {
        return waktuBerangkat;
    }

    public void setWaktuBerangkat(String waktuBerangkat) {
        this.waktuBerangkat = waktuBerangkat;
    }

    public String getWaktuTiba() {
        return waktuTiba;
    }

    public void setWaktuTiba(String waktuTiba) {
        this.waktuTiba = waktuTiba;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}
