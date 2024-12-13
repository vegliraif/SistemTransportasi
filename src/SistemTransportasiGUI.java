import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SistemTransportasiGUI {
    

    // Komponen GUI
    private JFrame frame;
    private JTextField tfIDKendaraan, tfKapasitas, tfNamaRute, tfTitikAwal, tfTitikAkhir, tfDaftarPemberhentian,
            tfWaktuKeberangkatan, tfWaktuTiba, tfHarga, tfTanggal, tfIDPenumpang, tfJumlahPenumpang, tfPendapatanHarian, tfCari;
    private JComboBox<String> cbJenisKendaraan, cbStatusOperasional;
    private JTable tableTransportasi, tablePenumpang, tableLaporan;
    private DefaultTableModel modelTransportasi, modelPenumpang, modelLaporan;

    // Data backend
    private ArrayList<Object[]> dataTransportasi = new ArrayList<>();
    private ArrayList<Object[]> dataPenumpang = new ArrayList<>();
    private ArrayList<Object[]> dataLaporan = new ArrayList<>();

    public SistemTransportasiGUI() {
        // Frame utama
        frame = new JFrame("Sistem Manajemen Transportasi Kota");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setLayout(new BorderLayout());

        // Panel input data
        JPanel panelInput = new JPanel(new GridLayout(6, 4, 10, 10));
        panelInput.setBorder(BorderFactory.createTitledBorder("Input Data"));

        // Komponen input data
        tfIDKendaraan = new JTextField();
        cbJenisKendaraan = new JComboBox<>(new String[]{"Bus", "Kereta", "Taksi"});
        tfKapasitas = new JTextField();
        cbStatusOperasional = new JComboBox<>(new String[]{"Aktif", "Tidak Aktif"});
        tfNamaRute = new JTextField();
        tfTitikAwal = new JTextField();
        tfTitikAkhir = new JTextField();
        tfDaftarPemberhentian = new JTextField();
        tfWaktuKeberangkatan = new JTextField();
        tfWaktuTiba = new JTextField();
        tfHarga = new JTextField();
        tfTanggal = new JTextField();
        tfIDPenumpang = new JTextField();
        tfJumlahPenumpang = new JTextField();
        tfPendapatanHarian = new JTextField();

        // Menambahkan komponen ke panel input
        panelInput.add(new JLabel("ID Kendaraan:"));
        panelInput.add(tfIDKendaraan);
        panelInput.add(new JLabel("Nama Rute:"));
        panelInput.add(tfNamaRute);
        panelInput.add(new JLabel("Jenis Kendaraan:"));
        panelInput.add(cbJenisKendaraan);
        panelInput.add(new JLabel("Titik Awal:"));
        panelInput.add(tfTitikAwal);
        panelInput.add(new JLabel("Kapasitas:"));
        panelInput.add(tfKapasitas);
        panelInput.add(new JLabel("Titik Akhir:"));
        panelInput.add(tfTitikAkhir);
        panelInput.add(new JLabel("Status Operasional:"));
        panelInput.add(cbStatusOperasional);
        panelInput.add(new JLabel("Daftar Pemberhentian:"));
        panelInput.add(tfDaftarPemberhentian);
        panelInput.add(new JLabel("Waktu Keberangkatan:"));
        panelInput.add(tfWaktuKeberangkatan);
        panelInput.add(new JLabel("Waktu Tiba:"));
        panelInput.add(tfWaktuTiba);
        panelInput.add(new JLabel("Harga:"));
        panelInput.add(tfHarga);
        panelInput.add(new JLabel("Tanggal:"));
        panelInput.add(tfTanggal);
        panelInput.add(new JLabel("ID Tiket Penumpang:"));
        panelInput.add(tfIDPenumpang);
        panelInput.add(new JLabel("Jumlah Penumpang:"));
        panelInput.add(tfJumlahPenumpang);
        panelInput.add(new JLabel("Pendapatan Harian:"));
        panelInput.add(tfPendapatanHarian);

        // Panel tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        JButton btnSimpan = new JButton("Simpan");
        JButton btnEdit = new JButton("Edit");
        JButton btnHapus = new JButton("Hapus");
        JButton btnBatal = new JButton("Batal");
        JButton btnCari = new JButton("Cari");
        tfCari = new JTextField(15);

        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnBatal);
        panelTombol.add(new JLabel("Cari (ID):"));
        panelTombol.add(tfCari);
        panelTombol.add(btnCari);

        // Panel tabel
        JTabbedPane tabbedPane = new JTabbedPane();

        modelTransportasi = new DefaultTableModel(new String[]{"Jenis", "Kapasitas", "Status", "Rute", "Awal", "Akhir", "Pemberhentian", "Berangkat", "Tiba", "Harga"}, 0);
        tableTransportasi = new JTable(modelTransportasi);
        tabbedPane.addTab("Manajemen Transportasi", new JScrollPane(tableTransportasi));

        modelPenumpang = new DefaultTableModel(new String[]{"ID Penumpang", "Jumlah", "Tanggal"}, 0);
        tablePenumpang = new JTable(modelPenumpang);
        tabbedPane.addTab("Manajemen Penumpang", new JScrollPane(tablePenumpang));

        modelLaporan = new DefaultTableModel(new String[]{"Jumlah Penumpang", "Pendapatan Harian"}, 0);
        tableLaporan = new JTable(modelLaporan);
        tabbedPane.addTab("Laporan", new JScrollPane(tableLaporan));

        // Tambahkan komponen ke frame
        frame.add(panelInput, BorderLayout.NORTH);
        frame.add(panelTombol, BorderLayout.CENTER);
        frame.add(tabbedPane, BorderLayout.SOUTH);

        // Event tombol
        btnSimpan.addActionListener(e -> simpanData());
        btnEdit.addActionListener(e -> editData());
        btnHapus.addActionListener(e -> hapusData());
        btnBatal.addActionListener(e -> batalInput());
        btnCari.addActionListener(e -> cariData());

        frame.setVisible(true);
    }

    // Fungsi tombol
    private void simpanData() {
        // Ambil data dari inputan
        Object[] dataTransportasiRow = {
                cbJenisKendaraan.getSelectedItem().toString(),
                tfKapasitas.getText(),
                cbStatusOperasional.getSelectedItem().toString(),
                tfNamaRute.getText(),
                tfTitikAwal.getText(),
                tfTitikAkhir.getText(),
                tfDaftarPemberhentian.getText(),
                tfWaktuKeberangkatan.getText(),
                tfWaktuTiba.getText(),
                tfHarga.getText()
        };
        modelTransportasi.addRow(dataTransportasiRow);
        dataTransportasi.add(dataTransportasiRow);

        Object[] dataPenumpangRow = {
                tfIDPenumpang.getText(),
                tfJumlahPenumpang.getText(),
                tfTanggal.getText()
        };
        modelPenumpang.addRow(dataPenumpangRow);
        dataPenumpang.add(dataPenumpangRow);

        Object[] dataLaporanRow = {
                tfJumlahPenumpang.getText(),
                tfPendapatanHarian.getText()
        };
        modelLaporan.addRow(dataLaporanRow);
        dataLaporan.add(dataLaporanRow);

        JOptionPane.showMessageDialog(frame, "Data berhasil disimpan.");
        batalInput();
    }

    private void editData() {
        String idCari = tfCari.getText();
        // Implementasi pencarian dan pengeditan data berdasarkan ID
    }

    private void hapusData() {
        // Implementasi hapus data
    }

    private void batalInput() {
        tfIDKendaraan.setText("");
        tfKapasitas.setText("");
        tfNamaRute.setText("");
        tfTitikAwal.setText("");
        tfTitikAkhir.setText("");
        tfDaftarPemberhentian.setText("");
        tfWaktuKeberangkatan.setText("");
        tfWaktuTiba.setText("");
        tfHarga.setText("");
        tfTanggal.setText("");
        tfIDPenumpang.setText("");
        tfJumlahPenumpang.setText("");
        tfPendapatanHarian.setText("");
    }

    private void cariData() {
        String idCari = tfCari.getText();
        // Implementasi pencarian data berdasarkan ID
    }

    public static void main(String[] args) {
        new SistemTransportasiGUI();
    }
}
