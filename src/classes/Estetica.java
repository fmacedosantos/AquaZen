package classes;

import interfaces.Atividades;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Estetica extends Paciente implements Atividades {

    String servico1;
    String servico2;
    String servico3;

    public Estetica(String nome, String telefone, String sexo, String tipoAtividade, String servico1) {
        super(nome, telefone, sexo, tipoAtividade);
        this.servico1 = servico1;
    }

    public Estetica(String nome, String telefone, String sexo, String tipoAtividade, String servico1,
                    String servico2) {
        super(nome, telefone, sexo, tipoAtividade);
        this.servico1 = servico1;
        this.servico2 = servico2;
    }

    public Estetica(String nome, String telefone, String sexo, String tipoAtividade, String servico1,
                    String servico2, String servico3) {
        super(nome, telefone, sexo, tipoAtividade);
        this.servico1 = servico1;
        this.servico2 = servico2;
        this.servico3 = servico3;
    }

    public String mostrarDados() {
        String dados = super.mostrarDados();
        dados += "\nServiços: ";
        if (this.servico1 != null) {
            dados += this.servico1;
        }
        if (this.servico2 != null) {
            dados += ", " + this.servico2;
        }
        if (this.servico3 != null) {
            dados += ", " + this.servico3;
        }
        return dados;
    }



    @Override
    public String caminharBosque() {
        return tipoAtividade = "Caminhe um total de 90 minutos semanais";
    }

    @Override
    public String nadarPiscina() {
        return tipoAtividade = "Nade um total de 45 minutos semanais";
    }

    @Override
    public String exercitarAcademia() {
        return tipoAtividade = "Treine um total de 3 horas semanais";
    }
}
