package classes;

import interfaces.Atividades;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Estetica extends Paciente implements Atividades {
    private List<String> servicos = new ArrayList<>();

    public Estetica(String nome, String telefone, String sexo, String tipoAtividade) {
        super(nome, telefone, sexo, tipoAtividade);
    }

    public void adicionarServico(String servico) {
        servicos.add(servico);
    }

    public void servicos(String servico1){

    }

    public void servicos(String servico1, String servico2){

    }

    public void servicos(String servico1, String servico2, String servico3){

    }

    @Override
    public String mostrarDados() {
        String dados = super.mostrarDados();

        dados += "\nServiços:";
        for (String servico : servicos) {
            dados += "\n- " + servico;
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
