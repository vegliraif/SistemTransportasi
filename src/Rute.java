public class Rute {
    private String titikAwal;
    private String titikAkhir;
    private String daftarPemberhentian;

    public Rute(String titikAwal, String titikAkhir, String daftarPemberhentian) {
        this.titikAwal = titikAwal;
        this.titikAkhir = titikAkhir;
        this.daftarPemberhentian = daftarPemberhentian;
    }

    public String getTitikAwal() { return titikAwal; }
    public void setTitikAwal(String titikAwal) { this.titikAwal = titikAwal; }

    public String getTitikAkhir() { return titikAkhir; }
    public void setTitikAkhir(String titikAkhir) { this.titikAkhir = titikAkhir; }

    public String getDaftarPemberhentian() { return daftarPemberhentian; }
    public void setDaftarPemberhentian(String daftarPemberhentian) { this.daftarPemberhentian = daftarPemberhentian; }
}
