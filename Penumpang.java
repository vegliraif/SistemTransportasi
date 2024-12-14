import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Penumpang {
    // Atribut personal
    private String nama;
    private String kontak;

    // Atribut operasional
    private String idTiket;
    private int jumlahPenumpang;
    private String tanggal;
    private double pendapatanHarian;

    // Constructor
    public Penumpang(String nama, String kontak, String idTiket, int jumlahPenumpang, String tanggal, double pendapatanHarian) {
        this.nama = nama;
        this.kontak = kontak;
        this.idTiket = idTiket;
        this.jumlahPenumpang = jumlahPenumpang;
        this.tanggal = tanggal;
        this.pendapatanHarian = pendapatanHarian;
    }

    // Constructor sederhana
    public Penumpang(String nama, String kontak) {
        this(nama, kontak, null, 0, null, 0.0);
    }

    // Getter dan Setter (Tidak ditampilkan di sini untuk menghemat ruang)

    // Format data sebagai String
    @Override
    public String toString() {
        return nama + ";" + kontak + ";" + idTiket + ";" + jumlahPenumpang + ";" + tanggal + ";" + pendapatanHarian;
    }

    // Konversi String ke Penumpang
    public static Penumpang fromString(String data) {
        String[] fields = data.split(";");
        return new Penumpang(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], Double.parseDouble(fields[5]));
    }

    // Menyimpan data ke file
    public static void saveToFile(List<Penumpang> penumpangList, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Penumpang p : penumpangList) {
                writer.write(p.toString());
                writer.newLine();
            }
        }
    }

    // Membaca data dari file
    public static List<Penumpang> loadFromFile(String fileName) throws IOException {
        List<Penumpang> penumpangList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                penumpangList.add(Penumpang.fromString(line));
            }
        }
        return penumpangList;
    }
}

