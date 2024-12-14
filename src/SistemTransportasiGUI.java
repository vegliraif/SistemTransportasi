import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
public class SistemTransportasiGUI {

    private JFrame frame;
    private JTextField tfIDOperator, tfNamaOperator, tfKontakOperator, tfIDKendaraan, tfKapasitas, tfNamaRute, tfTitikAwal, tfTitikAkhir, tfDaftarPemberhentian,
            tfWaktuKeberangkatan, tfWaktuTiba, tfHarga, tfTanggal, tfIDPenumpang, tfJumlahPenumpang, tfPendapatanHarian;
    private JComboBox<String> cbJenisKendaraan, cbStatusOperasional;
    private JTable tableTransportasiBus, tableTransportasiKereta, tableTransportasiTaksi, tablePenumpangBus, tablePenumpangKereta, tablePenumpangTaksi, tableLaporanBus, tableLaporanKereta, tableLaporanTaksi, tableOperator;
    private DefaultTableModel modelTransportasiBus, modelTransportasiKereta, modelTransportasiTaksi, modelPenumpangBus, modelPenumpangKereta, modelPenumpangTaksi, modelLaporanBus, modelLaporanKereta, modelLaporanTaksi, modelOperator;

    private static final String FILE_OPERATOR = "data_operator.csv";
    private static final String FILE_TRANSPORTASI_BUS = "data_transportasi_bus.csv";
    private static final String FILE_TRANSPORTASI_KERETA = "data_transportasi_kereta.csv";
    private static final String FILE_TRANSPORTASI_TAKSI = "data_transportasi_taksi.csv";
    private static final String FILE_PENUMPANG_BUS = "data_penumpang_bus.csv";
    private static final String FILE_PENUMPANG_KERETA = "data_penumpang_kereta.csv";
    private static final String FILE_PENUMPANG_TAKSI = "data_penumpang_taksi.csv";
    private static final String FILE_LAPORAN_BUS = "data_laporan_bus.csv";
    private static final String FILE_LAPORAN_KERETA = "data_laporan_kereta.csv";
    private static final String FILE_LAPORAN_TAKSI = "data_laporan_taksi.csv";



    public SistemTransportasiGUI() {
        
        frame = new JFrame("Sistem Manajemen Transportasi Kota");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 800);
        frame.setLayout(new BorderLayout());

        // Judul
        JLabel labelJudul = new JLabel("SISTEM MANAJEMEN TRANSPORTASI KOTA", SwingConstants.CENTER);
        labelJudul.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(labelJudul, BorderLayout.NORTH);

        // Panel input operator
        JPanel panelInputOperator = new JPanel(new GridLayout(1, 6, 10, 10));
        panelInputOperator.setBorder(BorderFactory.createTitledBorder("Input Data Operator"));

        tfIDOperator = new JTextField();
        tfNamaOperator = new JTextField();
        tfKontakOperator = new JTextField();

        panelInputOperator.add(new JLabel("ID Operator:"));
        panelInputOperator.add(tfIDOperator);
        panelInputOperator.add(new JLabel("Nama Operator:"));
        panelInputOperator.add(tfNamaOperator);
        panelInputOperator.add(new JLabel("Kontak Operator:"));
        panelInputOperator.add(tfKontakOperator);

        // Panel input data
        JPanel panelInput = new JPanel(new GridLayout(5, 6, 10, 10));
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

        panelInput.add(new JLabel("ID Kendaraan:"));
        panelInput.add(tfIDKendaraan);
        panelInput.add(new JLabel("Nama Rute:"));
        panelInput.add(tfNamaRute);
        panelInput.add(new JLabel("Waktu Keberangkatan:"));
        panelInput.add(tfWaktuKeberangkatan);
        panelInput.add(new JLabel("Jenis Kendaraan:"));
        panelInput.add(cbJenisKendaraan);
        panelInput.add(new JLabel("Titik Awal:"));
        panelInput.add(tfTitikAwal);
        panelInput.add(new JLabel("Waktu Tiba:"));
        panelInput.add(tfWaktuTiba);
        panelInput.add(new JLabel("Kapasitas:"));
        panelInput.add(tfKapasitas);
        panelInput.add(new JLabel("Titik Akhir:"));
        panelInput.add(tfTitikAkhir);
        panelInput.add(new JLabel("Harga:"));
        panelInput.add(tfHarga);
        panelInput.add(new JLabel("Status Operasional:"));
        panelInput.add(cbStatusOperasional);
        panelInput.add(new JLabel("Daftar Pemberhentian:"));
        panelInput.add(tfDaftarPemberhentian);
        panelInput.add(new JLabel("Tanggal:"));
        panelInput.add(tfTanggal);
        panelInput.add(new JLabel("Jumlah Penumpang:"));
        panelInput.add(tfJumlahPenumpang);
        panelInput.add(new JLabel("ID Tiket Penumpang:"));
        panelInput.add(tfIDPenumpang);
        panelInput.add(new JLabel("Pendapatan Harian:"));
        panelInput.add(tfPendapatanHarian);

        // Panel tombol
        JPanel panelTombol = new JPanel();
        JButton btnSimpan = new JButton("Simpan");
        JButton btnBatal = new JButton("Batal");
        panelTombol.add(btnSimpan);
        panelTombol.add(btnBatal);

        // Panel tabel utama
        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel transportasi
        JTabbedPane tabTransportasi = new JTabbedPane();

        modelTransportasiBus = new DefaultTableModel(new String[]{"ID Operator", "Jenis", "Kapasitas", "Status", "Rute", "Awal", "Akhir", "Pemberhentian", "Berangkat", "Tiba", "Harga"}, 0);
        tableTransportasiBus = new JTable(modelTransportasiBus);
        tabTransportasi.addTab("Bus", new JScrollPane(tableTransportasiBus));

        modelTransportasiKereta = new DefaultTableModel(new String[]{"ID Operator", "Jenis", "Kapasitas", "Status", "Rute", "Awal", "Akhir", "Pemberhentian", "Berangkat", "Tiba", "Harga"}, 0);
        tableTransportasiKereta = new JTable(modelTransportasiKereta);
        tabTransportasi.addTab("Kereta", new JScrollPane(tableTransportasiKereta));

        modelTransportasiTaksi = new DefaultTableModel(new String[]{"ID Operator", "Jenis", "Kapasitas", "Status", "Rute", "Awal", "Akhir", "Pemberhentian", "Berangkat", "Tiba", "Harga"}, 0);
        tableTransportasiTaksi = new JTable(modelTransportasiTaksi);
        tabTransportasi.addTab("Taksi", new JScrollPane(tableTransportasiTaksi));

        tabbedPane.addTab("Manajemen Transportasi", tabTransportasi);

        // Panel penumpang
        JTabbedPane tabPenumpang = new JTabbedPane();

        modelPenumpangBus = new DefaultTableModel(new String[]{"ID Operator", "ID Penumpang", "Jumlah", "Tanggal"}, 0);
        tablePenumpangBus = new JTable(modelPenumpangBus);
        tabPenumpang.addTab("Bus", new JScrollPane(tablePenumpangBus));

        modelPenumpangKereta = new DefaultTableModel(new String[]{"ID Operator", "ID Penumpang", "Jumlah", "Tanggal"}, 0);
        tablePenumpangKereta = new JTable(modelPenumpangKereta);
        tabPenumpang.addTab("Kereta", new JScrollPane(tablePenumpangKereta));

        modelPenumpangTaksi = new DefaultTableModel(new String[]{"ID Operator", "ID Penumpang", "Jumlah", "Tanggal"}, 0);
        tablePenumpangTaksi = new JTable(modelPenumpangTaksi);
        tabPenumpang.addTab("Taksi", new JScrollPane(tablePenumpangTaksi));

        tabbedPane.addTab("Manajemen Penumpang", tabPenumpang);

        // Panel laporan
        JTabbedPane tabLaporan = new JTabbedPane();

        modelLaporanBus = new DefaultTableModel(new String[]{"ID Operator", "Jumlah Penumpang", "Pendapatan Harian"}, 0);
        tableLaporanBus = new JTable(modelLaporanBus);
        tabLaporan.addTab("Bus", new JScrollPane(tableLaporanBus));

        modelLaporanKereta = new DefaultTableModel(new String[]{"ID Operator", "Jumlah Penumpang", "Pendapatan Harian"}, 0);
        tableLaporanKereta = new JTable(modelLaporanKereta);
        tabLaporan.addTab("Kereta", new JScrollPane(tableLaporanKereta));

        modelLaporanTaksi = new DefaultTableModel(new String[]{"ID Operator", "Jumlah Penumpang", "Pendapatan Harian"}, 0);
        tableLaporanTaksi = new JTable(modelLaporanTaksi);
        tabLaporan.addTab("Taksi", new JScrollPane(tableLaporanTaksi));

        tabbedPane.addTab("Laporan", tabLaporan);

        // Panel operator
        modelOperator = new DefaultTableModel(new String[]{"ID Operator", "Nama Operator", "Kontak Operator"}, 0);
        tableOperator = new JTable(modelOperator);
        tabbedPane.addTab("Data Operator", new JScrollPane(tableOperator));

        // Tambahkan ke frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panelInputOperator, BorderLayout.NORTH);
        mainPanel.add(panelInput, BorderLayout.CENTER);
        mainPanel.add(panelTombol, BorderLayout.SOUTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(tabbedPane, BorderLayout.SOUTH);

         // Event listener tombol
         btnSimpan.addActionListener(e -> simpanData());
         btnBatal.addActionListener(e -> batalInput());

        frame.setMinimumSize(new Dimension(600, 400));
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                frame.revalidate();
                frame.repaint();
            }
        });

        loadData();

        frame.setVisible(true);
        
    }

    private void simpanData() {
        if (tfIDOperator.getText().isEmpty() || tfNamaOperator.getText().isEmpty() || tfKontakOperator.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Data Operator Harus Diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String idOperator = tfIDOperator.getText();

        Object[] operatorRow = {idOperator, tfNamaOperator.getText(), tfKontakOperator.getText()};
        modelOperator.addRow(operatorRow);

        String jenisKendaraan = cbJenisKendaraan.getSelectedItem().toString();
        Object[] row = {
            idOperator,
            jenisKendaraan,
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


        if (jenisKendaraan.equals("Bus")) {
            modelTransportasiBus.addRow(row);

            Object[] penumpangRow = {
                idOperator,
                tfIDPenumpang.getText(),
                tfJumlahPenumpang.getText(),
                tfTanggal.getText()
            };
            modelPenumpangBus.addRow(penumpangRow);

            Object[] laporanRow = {
                idOperator,
                tfJumlahPenumpang.getText(),
                tfPendapatanHarian.getText()
            };
            modelLaporanBus.addRow(laporanRow);
            saveDataToFile(FILE_TRANSPORTASI_BUS, row);
            saveDataToFile(FILE_PENUMPANG_BUS, penumpangRow);
            saveDataToFile(FILE_LAPORAN_BUS, laporanRow);

        } else if (jenisKendaraan.equals("Kereta")) {
            modelTransportasiKereta.addRow(row);

            Object[] penumpangRow = {
                idOperator,
                tfIDPenumpang.getText(),
                tfJumlahPenumpang.getText(),
                tfTanggal.getText()
            };
            modelPenumpangKereta.addRow(penumpangRow);

            Object[] laporanRow = {
                idOperator,
                tfJumlahPenumpang.getText(),
                tfPendapatanHarian.getText()
            };
            modelLaporanKereta.addRow(laporanRow);
            saveDataToFile(FILE_TRANSPORTASI_KERETA, row);
            saveDataToFile(FILE_PENUMPANG_KERETA, penumpangRow);
            saveDataToFile(FILE_LAPORAN_KERETA, laporanRow);

        } else if (jenisKendaraan.equals("Taksi")) {
            modelTransportasiTaksi.addRow(row);

            Object[] penumpangRow = {
                idOperator,
                tfIDPenumpang.getText(),
                tfJumlahPenumpang.getText(),
                tfTanggal.getText()
            };
            modelPenumpangTaksi.addRow(penumpangRow);

            Object[] laporanRow = {
                idOperator,
                tfJumlahPenumpang.getText(),
                tfPendapatanHarian.getText()
            };
            
            modelLaporanTaksi.addRow(laporanRow);
            saveDataToFile(FILE_TRANSPORTASI_TAKSI, row);
            saveDataToFile(FILE_PENUMPANG_TAKSI, penumpangRow);
            saveDataToFile(FILE_LAPORAN_TAKSI, laporanRow);
        }
        
        saveDataToFile(FILE_OPERATOR, operatorRow);
        JOptionPane.showMessageDialog(frame, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        batalInput();
    }

    private void batalInput() {
        tfIDOperator.setText("");
        tfNamaOperator.setText("");
        tfKontakOperator.setText("");
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

    private void saveDataToFile(String fileName, Object[] data) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            for (Object item : data) {
                writer.write(item + ",");
            }
            writer.write("\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Gagal Menyimpan Data ke File", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadData() {
        loadDataFromFile(FILE_OPERATOR, modelOperator);
        loadDataFromFile(FILE_TRANSPORTASI_BUS, modelTransportasiBus);
        loadDataFromFile(FILE_TRANSPORTASI_KERETA, modelTransportasiKereta);
        loadDataFromFile(FILE_TRANSPORTASI_TAKSI, modelTransportasiTaksi);
        loadDataFromFile(FILE_OPERATOR, modelOperator);
        loadDataFromFile(FILE_TRANSPORTASI_BUS, modelTransportasiBus);
        loadDataFromFile(FILE_TRANSPORTASI_KERETA, modelTransportasiKereta);
        loadDataFromFile(FILE_TRANSPORTASI_TAKSI, modelTransportasiTaksi);
        loadDataFromFile(FILE_PENUMPANG_BUS, modelPenumpangBus);
        loadDataFromFile(FILE_PENUMPANG_KERETA, modelPenumpangKereta);
        loadDataFromFile(FILE_PENUMPANG_TAKSI, modelPenumpangTaksi);
        loadDataFromFile(FILE_LAPORAN_BUS, modelLaporanBus);
        loadDataFromFile(FILE_LAPORAN_KERETA, modelLaporanKereta);
        loadDataFromFile(FILE_LAPORAN_TAKSI, modelLaporanTaksi);
    }

    private void loadDataFromFile(String fileName, DefaultTableModel model) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                model.addRow(row);
            }
        } catch (FileNotFoundException e) {
            // File belum ada, tidak ada masalah.
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Gagal Membaca Data dari File", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new SistemTransportasiGUI();
    }
}
