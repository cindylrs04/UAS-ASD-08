import java.util.Scanner;

import Code.TransaksiPajak08;

public class KendaraanMain08 {
    LinkedList08 transaksiList = new LinkedList08();
    Kendaraan08[] daftarKendaraan = {
        new Kendaraan08("S 4567 YV", "Basko", "Mobil", 2000, 2012, 4),
        new Kendaraan08("N 4511 VS", "Arta", "Mobil", 2500, 2015,3),
        new Kendaraan08("AB 4321 A", "Wisnu", "Motor", 125, 2010, 2),
        new Kendaraan08("B 1234 AG", "Sisa", "Motor", 150, 2020, 1)
    };
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Bayar Pajak");
            System.out.println("3. Tampilkan seluruh transaksi");
            System.out.println("4. Urutkan Transaksi berdasarkan nama Pemilik");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    daftarKendaraan();
                    break;
                case 2:
                    lakukanTransaksiPajak();
                    break;
                case 3:
                    transaksiList.display();
                    break;
                case 4:
                    transaksiList.sortByName();
                    transaksiList.display();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    
    public void daftarKendaraan() {
        for (Kendaraan08 kendaraan : daftarKendaraan) {
            System.out.println("No TNKB: " + kendaraan.getNoTNKB());
            System.out.println("Nama: " + kendaraan.getNama());
            System.out.println("Jenis: " + kendaraan.getJenis());
            System.out.println("Tahun: " + kendaraan.getTahun());
            System.out.println("Bulan Harus Bayar: " + kendaraan.getBulanHarusBayar());
            System.out.println();
        }
    }

    public void lakukanTransaksiPajak() {
        System.out.print("Masukkan nomor TNKB kendaraan: ");
        String noTNKB = scanner.next();

        Kendaraan08 kendaraan = null;
        for (Kendaraan08 k : daftarKendaraan) {
            if (k.getNoTNKB().equals(noTNKB)) {
                Kendaraan08 = k;
                break;
            }
        }

        if (kendaraan == null) {
            System.out.println("Kendaraan tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan bulan bayar: ");
        int bulanBayar = scanner.nextInt();

        long nominalBayar = hitungTarifPajak(kendaraan);
        long denda = hitungDenda(kendaraan.getBulanHarusBayar(), bulanBayar);

        TransaksiPajak08 transaksi = new TransaksiPajak08(nominalBayar, denda, bulanBayar, kendaraan);
        transaksiList.add(transaksi);

        System.out.println("Transaksi berhasil dilakukan.");
        System.out.println("Kode Transaksi: " + transaksi.getKode());
        System.out.println("Nominal Bayar: " + transaksi.getNominalBayar());
        System.out.println("Denda: " + transaksi.getDenda());
    }

    public static long hitungTarifPajak(Kendaraan08 kendaraan) {
        String jenis = kendaraan.getJenis();
        int eet = kendaraan.getEet();

        if (jenis.equalsIgnoreCase("Motor")) {
            if (eet < 100) {
                return 100000;
            } else if (eet <= 250) {
                return 250000;
            } else {
                return 500000;
            }
        } else if (jenis.equalsIgnoreCase("Mobil")) {
            if (eet < 1000) {
                return 750000;
            } else if (eet <= 2500) {
                return 1000000;
            } else {
                return 1500000;
            }
        }
        return 0;
    }

    public static long hitungDenda(int bulanHarusBayar, int bulanBayar) {
        int selisihBulan = bulanBayar - bulanHarusBayar;
        if (selisihBulan > 0) {
            if (selisihBulan <= 3) {
                return 50000 * selisihBulan;
            } else {
                return 50000 * 3 + 50000 * (selisihBulan - 3);
            }
        }
        return 0;
    }
}