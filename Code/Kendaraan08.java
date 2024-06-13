package Code;

class Kendaraan08 {
    int cc;
    int tahun; 
    int bulanHarusBayar;
    String nama, jenis, noTNKB;
    
    public Kendaraan08(String noTNKB, String nama, String jenis, int eet, int tahun, int bulanHarusBayar) {
        this.noTNKB = noTNKB;
        this.nama = nama;
        this.jenis = jenis;
        this.tahun = tahun;
        this.bulanHarusBayar = bulanHarusBayar;
    }

    public String getNoTNKB() {
        return noTNKB;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public int getTahun() {
        return tahun;
    }

    public int getBulanHarusBayar() {
        return bulanHarusBayar;
    }
}