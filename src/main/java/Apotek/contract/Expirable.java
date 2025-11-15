package Apotek.contract;

import java.time.LocalDate;

public interface Expirable {
    LocalDate getExpiryDate();
    boolean isKadarLuarsa();
}
