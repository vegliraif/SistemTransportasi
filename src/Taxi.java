public class Taxi extends Kendaraan {
    public Taxi(String id, int kapasitas, String statusOperasional, String namaRute) {
        super(id, kapasitas, statusOperasional, namaRute);
    }

    @Override
    public String getJenis() {
        return "Taxi";
    }
}
