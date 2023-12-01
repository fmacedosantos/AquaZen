package testes;

import classes.Paciente;
import telas.TelaAquaZen;

import java.util.HashSet;
import java.util.Set;

public class TestaAquaZen {

    public static void main(String[] args) {
        Set<Paciente> pacientes = new HashSet<>();
        TelaAquaZen aquaZen = new TelaAquaZen("AquaZen", pacientes);
        aquaZen.setVisible(true);
    }
}
