public class Jadwal {
    private String waktuKeberangkatan;
    private String waktuTiba;

    public Jadwal(String waktuKeberangkatan, String waktuTiba) {
        this.waktuKeberangkatan = waktuKeberangkatan;
        this.waktuTiba = waktuTiba;
    }

    public String getWaktuKeberangkatan() { return waktuKeberangkatan; }
    public void setWaktuKeberangkatan(String waktuKeberangkatan) { this.waktuKeberangkatan = waktuKeberangkatan; }

    public String getWaktuTiba() { return waktuTiba; }
    public void setWaktuTiba(String waktuTiba) { this.waktuTiba = waktuTiba; }
}
