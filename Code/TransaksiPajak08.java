package Code;

public class TransaksiPajak08 {
    int kode;
    int bulanBayar;
    long nomimalBayar;
    long denda;
    Kendaraan08 kendaraan;
    TransaksiPajak08 next;

    public TransaksiPajak08(long nominalBayar, long denda, int bulanBayar, Kendaraan kendaraan) {
        this.nominalBayar = nominalBayar;
        this.denda = denda;
        this.bulanBayar = bulanBayar;
        this.kendaraan = kendaraan;
    }

    public int getKode() {
        return kode;
    }

    public long getNominalBayar() {
        return nominalBayar;
    }

    public long getDenda() {
        return denda;
    }

    public int getBulanBayar() {
        return bulanBayar;
    }

    public Kendaraan08 getKendaraan() {
        return kendaraan;
    }

    public TransaksiPajak08 getNext() {
        return next;
    }

    public void setNext(TransaksiPajak08 next) {
        this.next = next;
    }
}
