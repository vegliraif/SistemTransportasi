public class Kereta extends Kendaraan {
    public Kereta(String id, int kapasitas, String statusOperasional, String namaRute) {
        super(id, kapasitas, statusOperasional, namaRute);
    }

    @Override
    public String getJenis() {
        return "Kereta";
    }
}
