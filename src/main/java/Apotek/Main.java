package Apotek;

import Apotek.contract.Expirable;
import Apotek.contract.Sellable;
import Apotek.entity.ObatGenerik;
import Apotek.entity.ObatPaten;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ObatGenerik paracetamol = new ObatGenerik("paracetamol", 2500, 100);

        ObatPaten amoxsan = new ObatPaten("amoxsan", 2500, 100, LocalDate.now().plusMonths(6));
        ObatPaten antiBiotikEd = new ObatPaten("Sporetik", 8800, 100, LocalDate.now().minusDays(1));

        paracetamol.hitungHargaJual(20);
        //coba hitunghargajual untuk barang ed : pasti error
//        antiBiotikEd.hitungHargaJual(1);
        amoxsan.kurangStock(20);

        System.out.println(paracetamol);
        System.out.println(amoxsan);
        System.out.println(antiBiotikEd);

        // Interface usage
        List<Sellable> bisaDijual = new ArrayList<>();
        bisaDijual.add(paracetamol);
        bisaDijual.add(amoxsan);

        System.out.println("\n=== BISA DIJUAL ===");
        for (Sellable obat : bisaDijual) {
            BigDecimal harga = obat.hitungHargaJual(1);
            System.out.printf("%s → Rp. %s%n", obat,formatRupiah(harga));
        }

        // Cek kadaluarsa
        if (amoxsan instanceof Expirable exp) {
            System.out.println(amoxsan.getNama() + " kadaluarsa? " + exp.isKadarLuarsa());
        }
    }

    private static String formatRupiah(BigDecimal amount) {
        return String.format("%,.0f", amount);
    }
}