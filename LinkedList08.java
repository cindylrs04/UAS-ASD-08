import Code.TransaksiPajak08;

public class LinkedList08 {
    public void add(TransaksiPajak08 transaksi) {
        if (head == null) {
            head = transaksi;
        } else {
            TransaksiPajak08 current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(transaksi);
        }
    }

    public void display() {
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("Daftar Transaksi Pembayaran Pajak");
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.printf("| %-5s | %-10s | %-15s | %-8s | %-8s | %-6s |%n", "Kode", "No TNKB", "Nama", "Nominal", "Denda", "Bulan");
        TransaksiPajak08 current = head;
        while (current != null) {
            System.out.printf("| %-5d | %-10s | %-15s | %-8d | %-8d | %-6d |%n",
                    current.getKode(),
                    current.getKendaraan().getNoTNKB(),
                    current.getKendaraan().getNama(),
                    current.getNominalBayar(),
                    current.getDenda(),
                    current.getBulanBayar());
            current = current.getNext();
        }
        System.out.println("Semua transaksi berhasil dicetak");
    }

    public void sortByName() {
        if (head == null || head.getNext() == null) {
            return;
        }

        boolean swapped;
        do {
            TransaksiPajak08 current = head;
            TransaksiPajak08 previous = null;
            TransaksiPajak08 next = head.getNext();
            swapped = false;

            while (next != null) {
                if (current.getKendaraan().getNama().compareTo(next.getKendaraan().getNama()) > 0) {
                    swapped = true;
                    if (previous == null) {
                        TransaksiPajak08 temp = next.getNext();
                        next.setNext(current);
                        current.setNext(temp);
                        head = next;
                        previous = next;
                    } else {
                        TransaksiPajak08 temp = next.getNext();
                        next.setNext(current);
                        current.setNext(temp);
                        previous.setNext(next);
                        previous = next;
                    }
                } else {
                    previous = current;
                    current = next;
                }
                next = current.getNext();
            }
        } while (swapped);
    }
}
