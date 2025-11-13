package Apotek.entity;

public class Obat {
    private final String nama;
    private int stok;
    private final double harga;

    private Obat(String nama, int stok, double harga) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }


    public static Obat buat(String nama, int stok, double harga) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("nama obat tidak boleh kosong");
        }
        if (stok < 0 ) {
            throw new IllegalArgumentException("stok obat tidak boleh minus");
        }
        if (harga < 0 ) {
            throw new IllegalArgumentException("harga obat tidak boleh minus");
        }
        return new Obat(nama.trim(), stok, harga);
    }

    public void kurangiStock (int qty){
        if (qty <= 0) {
            throw new IllegalArgumentException("qty obat tidak boleh minus");
        }
        if (qty > stok) {
            throw new IllegalArgumentException("stok tidak cukup" + stok);
        }
        stok -= qty;
    }

    public void tambahStock(int qty){
        if (qty <= 0) {
            throw new IllegalArgumentException("qty harus lebih dari 0");
        }
        stok += qty;
    }

    public boolean stokHabis(){
        return stok == 0;
    }

    public double hitungTotal(int qty){
        return harga * qty;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    @Override
    public String toString() {
        return String.format("%s (Stok: %d, Harga: Rp. %.0f)", nama, stok, harga);
    }
}