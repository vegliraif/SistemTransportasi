abstract class Kendaraan {
    private String id;
    private int kapasitas;
    private String statusOperasional;
    private String namaRute;

    public Kendaraan(String id, int kapasitas, String statusOperasional, String namaRute) {
        this.id = id;
        this.kapasitas = kapasitas;
        this.statusOperasional = statusOperasional;
        this.namaRute = namaRute;
    }

    // Abstract method
    public abstract String getJenis();

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getStatusOperasional() {
        return statusOperasional;
    }

    public void setStatusOperasional(String statusOperasional) {
        this.statusOperasional = statusOperasional;
    }

    public String getNamaRute() {
        return namaRute;
    }

    public void setNamaRute(String namaRute) {
        this.namaRute = namaRute;
    }
}

