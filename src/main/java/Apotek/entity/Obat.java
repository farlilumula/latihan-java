package Apotek.entity;

public class Obat {
    private String nama;
    private int stok;
    private double harga;

    public Obat(String nama, int stok, double harga) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public void kurangiStock(int qty) {
        if(qty <= stok){
            stok -= qty;
        } else {
            System.out.println("stok tidak mencukupi");
        }
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public double getHarga() {
        return harga;
    }
}