public class Penumpang {
    private String idTiket;
    private int jumlahPenumpang;
    private String tanggal;
    private double pendapatanHarian;

    public Penumpang(String idTiket, int jumlahPenumpang, String tanggal, double pendapatanHarian) {
        this.idTiket = idTiket;
        this.jumlahPenumpang = jumlahPenumpang;
        this.tanggal = tanggal;
        this.pendapatanHarian = pendapatanHarian;
    }

    // Getter dan Setter
    public String getIdTiket() {
        return idTiket;
    }

    public void setIdTiket(String idTiket) {
        this.idTiket = idTiket;
    }

    public int getJumlahPenumpang() {
        return jumlahPenumpang;
    }

    public void setJumlahPenumpang(int jumlahPenumpang) {
        this.jumlahPenumpang = jumlahPenumpang;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public double getPendapatanHarian() {
        return pendapatanHarian;
    }

    public void setPendapatanHarian(double pendapatanHarian) {
        this.pendapatanHarian = pendapatanHarian;
    }
}
