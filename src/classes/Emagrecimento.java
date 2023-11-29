package classes;

import interfaces.Atividades;

public class Emagrecimento extends Paciente implements Atividades {

    private Double peso;
    private Double altura;
    private Double pesoIdeal;

    public Emagrecimento(String nome, String telefone, String sexo, String tipoAtividade, Double peso, Double altura) {
        super(nome, telefone, sexo, tipoAtividade);
        this.peso = peso;
        this.altura = altura;
        CalculoPeso calculoPeso = new CalculoPeso(this.sexo, this.altura);
        pesoIdeal = calculoPeso.pesoIdeal();
    }

    @Override
    public String mostrarDados() {
        return "Nome: " + this.nome
                + "\nTelefone: " + this.telefone
                + "\nSexo: " + this.sexo
                + "\nTipo de Atividade: " + this.tipoAtividade
                + "\nPeso: " + this.peso;
    }

    @Override
    public String caminharBosque() {
        return tipoAtividade = "Caminhe um total de 130 minutos semanais";
    }

    @Override
    public String nadarPiscina() {
        return tipoAtividade = "Nade um total de 60 minutos semanais";
    }

    @Override
    public String exercitarAcademia() {
        return tipoAtividade = "Treine um total de 5 horas semanais";
    }
}
