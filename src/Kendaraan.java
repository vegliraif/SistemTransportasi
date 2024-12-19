import java.io.Serializable;

public abstract class Kendaraan implements Serializable {
    private String id;
    private int kapasitas;
    private String statusOperasional;
    private String namaRute;
    private double harga;
    private String waktuKeberangkatan;
    private String waktuTiba;
    private String tanggal;
    private double pendapatanHarian;

    // Constructor
    public Kendaraan(String id, int kapasitas, String statusOperasional, String namaRute, double harga, String waktuKeberangkatan, String waktuTiba, String tanggal, double pendapatanHarian) {
        this.id = id;
        this.kapasitas = kapasitas;
        this.statusOperasional = statusOperasional;
        this.namaRute = namaRute;
        this.harga = harga;
        this.waktuKeberangkatan = waktuKeberangkatan;
        this.waktuTiba = waktuTiba;
        this.tanggal = tanggal;
        this.pendapatanHarian = pendapatanHarian;
    }

    // Getter dan Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getHarga() {
        return harga;
    }

    public String getWaktuKeberangkatan() {
        return waktuKeberangkatan;
    }

    public String getWaktuTiba() {
        return waktuTiba;
    }

    public String getTanggal() {
        return tanggal;
    }

    public double getPendapatanHarian() {
        return pendapatanHarian;
    }

    // Metode abstract untuk jenis kendaraan
    public abstract String getJenis();
}
