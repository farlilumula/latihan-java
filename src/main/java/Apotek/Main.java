package Apotek;

import Apotek.entity.Obat;

public class Main {

    public static void main(String[] args) {
        Obat paracetamol = Obat.buat("paracetamol", 100, 2500);
        Obat amoxycillin = Obat.buat("Amoxycillin", 100, 3500);


        paracetamol.kurangiStock(25);
        amoxycillin.kurangiStock(35);

        System.out.println(paracetamol);
        System.out.println(amoxycillin);
        System.out.println("Total Obat Paracetamol adalah : " + paracetamol.hitungTotal(10));
    }


}