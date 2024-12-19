import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

// Kelas utama
public class Main {
    private static final String FILE_NAME = "data_kendaraan.dat";
    private static List<Kendaraan> kendaraanList = new ArrayList<>();

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
                    System.out.println("Masukkan Jenis Kendaraan (Bus/Kereta/Taxi): ");
                    String jenisKendaraan = scanner.nextLine();

                    Kendaraan kendaraan = null;
                    if (jenisKendaraan.equalsIgnoreCase("Bus")) {
                        kendaraan = inputKendaraan(scanner, "Bus");
                    } else if (jenisKendaraan.equalsIgnoreCase("Kereta")) {
                        kendaraan = inputKendaraan(scanner, "Kereta");
                    } else if (jenisKendaraan.equalsIgnoreCase("Taxi")) {
                        kendaraan = inputKendaraan(scanner, "Taxi");
                    }

                    if (kendaraan != null) {
                        kendaraanList.add(kendaraan);
                        System.out.println("Data kendaraan berhasil ditambahkan!");
                    }
                    break;

                case 2:
                    System.out.println("=== Data Kendaraan ===");
                    for (int i = 0; i < kendaraanList.size(); i++) {
                        Kendaraan k = kendaraanList.get(i);
                        System.out.println("Data ke-" + (i + 1));
                        System.out.println("ID Kendaraan        : " + k.getId());
                        System.out.println("Jenis Kendaraan     : " + k.getJenis());
                        System.out.println("Kapasitas           : " + k.getKapasitas());
                        System.out.println("Status Operasional  : " + k.getStatusOperasional());
                        System.out.println("Nama Rute           : " + k.getNamaRute());

                        // Akses atribut tambahan untuk kendaraan tertentu
                        if (k instanceof Bus) {
                            Bus bus = (Bus) k;
                            System.out.println("Titik Awal          : " + bus.getTitikAwal());
                            System.out.println("Titik Akhir         : " + bus.getTitikAkhir());
                            System.out.println("Daftar Pemberhentian: " + bus.getDaftarPemberhentian());
                        } else if (k instanceof Kereta) {
                            Kereta kereta = (Kereta) k;
                            System.out.println("Titik Awal          : " + kereta.getTitikAwal());
                            System.out.println("Titik Akhir         : " + kereta.getTitikAkhir());
                            System.out.println("Daftar Pemberhentian: " + kereta.getDaftarPemberhentian());
                        } else if (k instanceof Taxi) {
                            Taxi taxi = (Taxi) k;
                            System.out.println("Titik Awal          : " + taxi.getTitikAwal());
                            System.out.println("Titik Akhir         : " + taxi.getTitikAkhir());
                        }

                        // Format harga dan pendapatan harian
                        DecimalFormat df = new DecimalFormat("#,###");
                        System.out.println("Harga               : " + df.format(k.getHarga()));
                        System.out.println("Waktu Keberangkatan : " + k.getWaktuKeberangkatan());
                        System.out.println("Waktu Tiba          : " + k.getWaktuTiba());
                        System.out.println("Tanggal             : " + k.getTanggal());
                        System.out.println("Pendapatan Harian   : " + df.format(k.getPendapatanHarian()));

                        System.out.println("====================================");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nomor data yang ingin dihapus: ");
                    int indexToDelete = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan buffer

                    if (indexToDelete > 0 && indexToDelete <= kendaraanList.size()) {
                        kendaraanList.remove(indexToDelete - 1);
                        System.out.println("Data berhasil dihapus.");
                    } else {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;

                case 4:
                    try {
                        saveToFile(kendaraanList, FILE_NAME);
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

    // Input data kendaraan
    public static Kendaraan inputKendaraan(Scanner scanner, String jenis) {
        System.out.print("Masukkan ID Kendaraan: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Kapasitas: ");
        int kapasitas = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer
        System.out.print("Masukkan Status Operasional: ");
        String statusOperasional = scanner.nextLine();
        System.out.print("Masukkan Nama Rute: ");
        String namaRute = scanner.nextLine();
    
        // Input untuk titik awal, titik akhir, dan daftar pemberhentian
        if (jenis.equalsIgnoreCase("Bus")) {
            System.out.print("Masukkan Titik Awal: ");
            String titikAwal = scanner.nextLine();
            System.out.print("Masukkan Titik Akhir: ");
            String titikAkhir = scanner.nextLine();
            System.out.print("Masukkan Daftar Pemberhentian: ");
            String daftarPemberhentian = scanner.nextLine();
    
            // Input harga dan jumlah penumpang
            System.out.print("Masukkan Harga: ");
            double harga = scanner.nextDouble();
            System.out.print("Masukkan Jumlah Penumpang: ");
            int jumlahPenumpang = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer
            System.out.print("Masukkan Waktu Keberangkatan (contoh: 08:00): ");
            String waktuKeberangkatan = scanner.nextLine();
            System.out.print("Masukkan Waktu Tiba (contoh: 10:00): ");
            String waktuTiba = scanner.nextLine();
            System.out.print("Masukkan Tanggal (contoh: 2024-12-20): ");
            String tanggal = scanner.nextLine();
    
            // Menghitung pendapatan harian
            double pendapatanHarian = harga * jumlahPenumpang;
    
            return new Bus(id, kapasitas, statusOperasional, namaRute, titikAwal, titikAkhir, daftarPemberhentian, harga, waktuKeberangkatan, waktuTiba, tanggal, pendapatanHarian);
        } else if (jenis.equalsIgnoreCase("Kereta")) {
            System.out.print("Masukkan Titik Awal: ");
            String titikAwal = scanner.nextLine();
            System.out.print("Masukkan Titik Akhir: ");
            String titikAkhir = scanner.nextLine();
            System.out.print("Masukkan Daftar Pemberhentian: ");
            String daftarPemberhentian = scanner.nextLine();
    
            // Input harga dan jumlah penumpang
            System.out.print("Masukkan Harga: ");
            double harga = scanner.nextDouble();
            System.out.print("Masukkan Jumlah Penumpang: ");
            int jumlahPenumpang = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer
            System.out.print("Masukkan Waktu Keberangkatan (contoh: 08:00): ");
            String waktuKeberangkatan = scanner.nextLine();
            System.out.print("Masukkan Waktu Tiba (contoh: 10:00): ");
            String waktuTiba = scanner.nextLine();
            System.out.print("Masukkan Tanggal (contoh: 2024-12-20): ");
            String tanggal = scanner.nextLine();
    
            // Menghitung pendapatan harian
            double pendapatanHarian = harga * jumlahPenumpang;
    
            return new Kereta(id, kapasitas, statusOperasional, namaRute, titikAwal, titikAkhir, daftarPemberhentian, harga, waktuKeberangkatan, waktuTiba, tanggal, pendapatanHarian);
        } else if (jenis.equalsIgnoreCase("Taxi")) {
            System.out.print("Masukkan Titik Awal: ");
            String titikAwal = scanner.nextLine();
            System.out.print("Masukkan Titik Akhir: ");
            String titikAkhir = scanner.nextLine();
    
            // Input harga dan jumlah penumpang
            System.out.print("Masukkan Harga: ");
            double harga = scanner.nextDouble();
            System.out.print("Masukkan Jumlah Penumpang: ");
            int jumlahPenumpang = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer
            System.out.print("Masukkan Waktu Keberangkatan (contoh: 08:00): ");
            String waktuKeberangkatan = scanner.nextLine();
            System.out.print("Masukkan Waktu Tiba (contoh: 10:00): ");
            String waktuTiba = scanner.nextLine();
            System.out.print("Masukkan Tanggal (contoh: 2024-12-20): ");
            String tanggal = scanner.nextLine();
    
            // Menghitung pendapatan harian
            double pendapatanHarian = harga * jumlahPenumpang;
    
            return new Taxi(id, kapasitas, statusOperasional, namaRute, titikAwal, titikAkhir, harga, waktuKeberangkatan, waktuTiba, tanggal, pendapatanHarian);
        }
    
        return null;
    }
    
    
    

    // Simpan data ke file
    public static void saveToFile(List<Kendaraan> kendaraanList, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(kendaraanList);
        }
    }

    // Memuat data dari file
    public static void loadFromFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                    kendaraanList = (List<Kendaraan>) ois.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Terjadi kesalahan saat memuat data.");
        }
    }
}
