import java.io.Serializable;

public class Penumpang implements Serializable {
    private String idOperator;       // Menyimpan ID operator
    private int jumlahPenumpang;     // Menyimpan jumlah penumpang
    private String tanggal;          // Menyimpan tanggal perjalanan

    // Konstruktor untuk menginisialisasi atribut
    public Penumpang(String idOperator, int jumlahPenumpang, String tanggal) {
        this.idOperator = idOperator;
        this.jumlahPenumpang = jumlahPenumpang;
        this.tanggal = tanggal;
    }

    // Getter dan Setter untuk idOperator
    public String getIdOperator() {
        return idOperator;
    }

    public void setIdOperator(String idOperator) {
        this.idOperator = idOperator;
    }

    // Getter dan Setter untuk jumlahPenumpang
    public int getJumlahPenumpang() {
        return jumlahPenumpang;
    }

    public void setJumlahPenumpang(int jumlahPenumpang) {
        this.jumlahPenumpang = jumlahPenumpang;
    }

    // Getter dan Setter untuk tanggal
    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    // Metode untuk menampilkan informasi Penumpang
    public void tampilkanInformasi() {
        System.out.println("ID Operator       : " + idOperator);
        System.out.println("Jumlah Penumpang  : " + jumlahPenumpang);
        System.out.println("Tanggal Perjalanan: " + tanggal);
    }
}
