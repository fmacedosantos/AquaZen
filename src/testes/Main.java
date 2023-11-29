package testes;

import classes.Emagrecimento;
import classes.Estetica;
import telas.AquaZen;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Emagrecimento> emagrecimentos = new HashSet<>();
        Set<Estetica> esteticas = new HashSet<>();
        AquaZen aquaZen = new AquaZen("AquaZen Spa", emagrecimentos, esteticas);
        aquaZen.setVisible(true);
    }
}
