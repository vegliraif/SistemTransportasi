public class Penumpang {
    private String nama;
    private String idPenumpang;

    public Penumpang(String nama, String idPenumpang) {
        this.nama = nama;
        this.idPenumpang = idPenumpang;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getIdPenumpang() { return idPenumpang; }
    public void setIdPenumpang(String idPenumpang) { this.idPenumpang = idPenumpang; }
}

