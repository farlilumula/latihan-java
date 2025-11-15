package Apotek.entity;

import Apotek.contract.Expirable;
import Apotek.contract.ResepRequired;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class ObatPaten extends Obat implements Expirable, ResepRequired {

    private final LocalDate expiryDate;

    public ObatPaten(String nama, double harga, int stok, LocalDate expiryDate) {
        super(nama, harga, stok);
        this.expiryDate = expiryDate;
    }

    @Override
    public BigDecimal hitungHargaJual(int qty) {
        if(isKadarLuarsa()){
            throw new IllegalArgumentException("Obat Sudah ED Tidak bisa dijual");
        }
        BigDecimal subTotal = getHargaDasar().multiply(BigDecimal.valueOf(qty));
        return subTotal.multiply(BigDecimal.valueOf(1.11)).setScale(0, RoundingMode.HALF_UP);
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean isKadarLuarsa() {
        return expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public boolean butuhResep() {
        return true;
    }

    @Override
    public String toString() {
        String status = isKadarLuarsa() ? " [KADALUARSA]" : "";
        return "[PATEN]" + status + " " + super.toString() +
                " | Exp: " + expiryDate;
    }
}
