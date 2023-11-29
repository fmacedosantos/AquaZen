package testes;

import classes.Emagrecimento;
import classes.Estetica;
import classes.Paciente;
import telas.AquaZen;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Paciente> pacientes = new HashSet<>();
        AquaZen aquaZen = new AquaZen("AquaZen Spa", pacientes);
        aquaZen.setVisible(true);
    }
}
