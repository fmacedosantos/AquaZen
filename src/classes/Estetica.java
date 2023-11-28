package classes;

import interfaces.Atividades;

import javax.swing.*;

public class Estetica extends Paciente implements Atividades {

    public Estetica(String nome, String telefone, String sexo, String tipoAtividade) {
        super(nome, telefone, sexo, tipoAtividade);
    }

    public void servicos(String servico1){

    }

    public void servicos(String servico1, String servico2){

    }

    public void servicos(String servico1, String servico2, String servico3){

    }

    @Override
    public String mostrarDados() {
        return "Nome: " + this.nome
                + "\nTelefone: " + this.telefone
                + "\nSexo: " + this.sexo
                + "\nTipo de Atividade: " + this.tipoAtividade;
    }

    @Override
    public String caminharBosque() {
        return tipoAtividade = "Caminhe no Bosque";
    }

    @Override
    public String nadarPiscina() {
        return tipoAtividade = "Nade em uma Piscine";
    }

    @Override
    public String exercitarAcademia() {
        return tipoAtividade = "Exercite-se na Academia";
    }
}
