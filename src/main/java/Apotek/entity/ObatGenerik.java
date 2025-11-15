package Apotek.entity;

import Apotek.contract.Sellable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ObatGenerik extends Obat {

    public ObatGenerik(String nama, double harga, int stok) {
        super(nama, harga, stok);
    }

    @Override
    public BigDecimal hitungHargaJual(int qty) {
        BigDecimal subtotal = getHargaDasar().multiply(BigDecimal.valueOf(qty));
        BigDecimal diskon = subtotal.multiply(BigDecimal.valueOf(0.8)); // 20% off
        return diskon.setScale(0, RoundingMode.HALF_UP); // ← setScale di hasil akhir!
    }

    @Override
    public String toString() {
        return "[GENERIK]" + super.toString();
    }


}
