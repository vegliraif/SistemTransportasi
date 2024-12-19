import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Main {
    private static final String FILE_NAME = "data.txt";
    private static List<Map<String, Object>> dataList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Memuat data dari file jika file ada
        loadFromFile(FILE_NAME);

        while (running) {
            System.out.println("=== Menu ===");
            System.out.println("1. Input Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Hapus Data");
            System.out.println("4. Simpan dan Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (choice) {
                case 1:
                    Map<String, Object> data = new HashMap<>();
                    System.out.print("Masukkan ID Operator: ");
                    data.put("idOperator", scanner.nextLine());
                    System.out.print("Masukkan Nama Operator: ");
                    data.put("namaOperator", scanner.nextLine());
                    System.out.print("Masukkan Kontak Operator: ");
                    data.put("kontakOperator", scanner.nextLine());
                    System.out.print("Masukkan ID Kendaraan: ");
                    data.put("idKendaraan", scanner.nextLine());
                    System.out.print("Masukkan Jenis Kendaraan: ");
                    data.put("jenisKendaraan", scanner.nextLine());
                    System.out.print("Masukkan Kapasitas: ");
                    data.put("kapasitas", scanner.nextInt());
                    scanner.nextLine(); // Membersihkan buffer
                    System.out.print("Masukkan Status Operasional: ");
                    data.put("statusOperasional", scanner.nextLine());
                    System.out.print("Masukkan Jumlah Penumpang: ");
                    data.put("jumlahPenumpang", scanner.nextInt());
                    scanner.nextLine(); 
                    System.out.print("Masukkan Nama Rute: ");
                    data.put("namaRute", scanner.nextLine());
                    System.out.print("Masukkan Titik Awal: ");
                    data.put("titikAwal", scanner.nextLine());
                    System.out.print("Masukkan Titik Akhir: ");
                    data.put("titikAkhir", scanner.nextLine());
                    System.out.print("Masukkan Daftar Pemberhentian: ");
                    data.put("daftarPemberhentian", scanner.nextLine());
                    System.out.print("Masukkan Harga: ");
                    data.put("harga", scanner.nextDouble());
                    scanner.nextLine(); 
                    System.out.print("Masukkan Waktu Keberangkatan: ");
                    data.put("waktuKeberangkatan", scanner.nextLine());
                    System.out.print("Masukkan Waktu Tiba: ");
                    data.put("waktuTiba", scanner.nextLine());
                    System.out.print("Masukkan Tanggal: ");
                    data.put("tanggal", scanner.nextLine());
                    System.out.print("Masukkan Pendapatan Harian: ");
                    data.put("pendapatanHarian", scanner.nextDouble());
                    scanner.nextLine();

                    // Menambahkan label Data ke- (otomatis)
                    int dataNumber = dataList.size() + 1; // Data ke-1, ke-2, ...
                    data.put("dataLabel", "Data " + dataNumber);

                    dataList.add(data);
                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("=== Data ===");
                    for (int i = 0; i < dataList.size(); i++) {
                        Map<String, Object> d = dataList.get(i);
                        System.out.println(d.get("dataLabel") + " ");
                        System.out.println("ID Operator         : " + d.get("idOperator"));
                        System.out.println("Nama Operator       : " + d.get("namaOperator"));
                        System.out.println("Kontak Operator     : " + d.get("kontakOperator"));
                        System.out.println("ID Kendaraan        : " + d.get("idKendaraan"));
                        System.out.println("Jenis Kendaraan     : " + d.get("jenisKendaraan"));
                        System.out.println("Kapasitas           : " + d.get("kapasitas"));
                        System.out.println("Status Operasional  : " + d.get("statusOperasional"));
                        System.out.println("Jumlah Penumpang    : " + d.get("jumlahPenumpang"));
                        System.out.println("Nama Rute           : " + d.get("namaRute"));
                        System.out.println("Titik Awal          : " + d.get("titikAwal"));
                        System.out.println("Titik Akhir         : " + d.get("titikAkhir"));
                        System.out.println("Daftar Pemberhentian: " + d.get("daftarPemberhentian"));

                        // Format harga dan pendapatan harian
                        DecimalFormat df = new DecimalFormat("#,###");
                        double harga = (double) d.get("harga");
                        double pendapatanHarian = (double) d.get("pendapatanHarian");

                        System.out.println("Harga               : " + df.format(harga));
                        System.out.println("Waktu Keberangkatan : " + d.get("waktuKeberangkatan"));
                        System.out.println("Waktu Tiba          : " + d.get("waktuTiba"));
                        System.out.println("Tanggal             : " + d.get("tanggal"));
                        System.out.println("Pendapatan Harian   : " + df.format(pendapatanHarian));

                        System.out.println("====================================");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nomor data yang ingin dihapus : ");
                    String dataLabelToDelete = scanner.nextLine();
                    boolean dataDeleted = false;

                    // Mencari data berdasarkan label
                    for (int i = 0; i < dataList.size(); i++) {
                        Map<String, Object> d = dataList.get(i);
                        String dataLabel = (String) d.get("dataLabel");

                        if (dataLabel.equals(dataLabelToDelete)) {
                            dataList.remove(i);
                            System.out.println("Data berhasil dihapus: " + dataLabel);
                            dataDeleted = true;
                            break;
                        }
                    }

                    if (!dataDeleted) {
                        System.out.println("Data dengan label tersebut tidak ditemukan.");
                    }
                    break;

                case 4:
                    try {
                        saveToFile(dataList, FILE_NAME);
                        System.out.println("Data berhasil disimpan.");
                    } catch (IOException e) {
                        System.out.println("Terjadi kesalahan saat menyimpan data.");
                    }
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }

    // Simpan data ke file
    public static void saveToFile(List<Map<String, Object>> dataList, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(dataList);
        }
    }

    // Memuat data dari file
    public static void loadFromFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                    dataList = (List<Map<String, Object>>) ois.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Terjadi kesalahan saat memuat data.");
        }
    }
}
