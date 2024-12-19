public class LaporanHarian {
    private double pendapatan;
    private int jumlahPenumpang;

    public LaporanHarian(double pendapatan, int jumlahPenumpang) {
        this.pendapatan = pendapatan;
        this.jumlahPenumpang = jumlahPenumpang;
    }

    public double getPendapatan() { return pendapatan; }
    public void setPendapatan(double pendapatan) { this.pendapatan = pendapatan; }

    public int getJumlahPenumpang() { return jumlahPenumpang; }
    public void setJumlahPenumpang(int jumlahPenumpang) { this.jumlahPenumpang = jumlahPenumpang; }

    public void tampilkanLaporan() {
        System.out.println("Pendapatan: " + pendapatan + ", Jumlah Penumpang: " + jumlahPenumpang);
    }
}
