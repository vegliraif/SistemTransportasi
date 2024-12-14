import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "penumpang.txt";

    public static void main(String[] args) {
        List<Penumpang> penumpangList = new ArrayList<>();

        // Coba membaca data dari file
        try {
            penumpangList = Penumpang.loadFromFile(FILE_NAME);
            System.out.println("Data berhasil dimuat dari file.");
        } catch (IOException e) {
            System.out.println("Tidak ada data sebelumnya.");
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== Menu ===");
            System.out.println("1. Tambah Penumpang");
            System.out.println("2. Tampilkan Penumpang");
            System.out.println("3. Simpan dan Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan kontak: ");
                    String kontak = scanner.nextLine();
                    System.out.print("Masukkan ID Tiket: ");
                    String idTiket = scanner.nextLine();
                    System.out.print("Masukkan jumlah penumpang: ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan buffer
                    System.out.print("Masukkan tanggal: ");
                    String tanggal = scanner.nextLine();
                    System.out.print("Masukkan pendapatan harian: ");
                    double pendapatan = scanner.nextDouble();
                    scanner.nextLine(); // Membersihkan buffer

                    penumpangList.add(new Penumpang(nama, kontak, idTiket, jumlah, tanggal, pendapatan));
                    System.out.println("Penumpang berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("=== Daftar Penumpang ===");
                    for (Penumpang p : penumpangList) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    // Simpan data ke file
                    try {
                        Penumpang.saveToFile(penumpangList, FILE_NAME);
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
}
