package Apotek.entity;

import Apotek.contract.Sellable;

import java.math.BigDecimal;

public abstract class Obat implements Sellable {
    private final String nama;
    protected int stok;
    private final BigDecimal harga;

    protected Obat(String nama, double harga, int stok) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("nama tidak boleh kosong");
        }
        if (stok < 0 || harga < 0) {
            throw new IllegalArgumentException("stok dan harga tidak boleh minus");
        }
        this.nama = nama.trim();
        this.harga = BigDecimal.valueOf(harga);
        this.stok = stok;
    }

    public final void kurangStock(int qty){
        if (qty <= 0) throw new IllegalArgumentException("qty harus lebih besar dari nol");
        if (qty > stok) throw new IllegalArgumentException("qty tidak bileh lebih besar dari stok");
        stok -= qty;
    }

    public final void tambahStock(int qty){
        if (qty <= 0) throw new IllegalArgumentException("qty harus > 0");
        stok += qty;
    }

    // DEKLARASIKAN METHOD ABSTRAK DI SINI!
    public abstract BigDecimal hitungHargaJual(int qty);

    public String getNama() {
        return nama;
    }
    public int getStok() { return stok; }
    public BigDecimal getHargaDasar() { return harga; }


    @Override
    public String toString() {
        return String.format("%s | Stok: %d | Harga Dasar: Rp. %.0f", nama, stok, harga);
    }

    protected String formatRupiah(BigDecimal amount) {
        return String.format("%,.0f", amount);
    }

}