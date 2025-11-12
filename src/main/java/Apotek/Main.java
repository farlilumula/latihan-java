package Apotek;

import Apotek.entity.Obat;

public class Main {

    public static void main(String[] args) {
        Obat paracetamol = new Obat("paracetamol", 200, 2500);
        paracetamol.kurangiStock(5);
        System.out.println("Paracetamol: " + paracetamol.getStok());
    }
}