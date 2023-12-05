package classes;

import interfaces.Atividades;

import javax.swing.*;

public class Emagrecimento extends Paciente implements Atividades {

    private Double peso;
    private Double altura;
    private Double pesoIdeal;
    private Double porcentagemPesoIdeal;
    private String mensagemAtividade;

    public Emagrecimento(String nome, String telefone, String sexo, String tipoAtividade, Double peso, Double altura) {
        super(nome, telefone, sexo, tipoAtividade);
        this.peso = peso;
        this.altura = altura;
        CalculoPeso calculoPeso = new CalculoPeso(this.sexo, this.altura, this.peso);
        pesoIdeal = calculoPeso.pesoIdeal();
        porcentagemPesoIdeal = calculoPeso.porcentagemPesoIdeal();
    }

    public double getPesoIdeal() {
        return this.pesoIdeal;
    }

    public Double getPorcentagemPesoIdeal() {return porcentagemPesoIdeal;}

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
        if (this.porcentagemPesoIdeal < 125){
            mensagemAtividade = "Caminhe um total de 130 minutos semanais.";
        } else {
            mensagemAtividade = "Caminhe um total de 250 minutos semanais." +
                    "\nConsulte um nutricionista para uma dieta\nadequada.";
        }
        return mensagemAtividade;
    }

    @Override
    public String nadarPiscina() {
        if (this.porcentagemPesoIdeal < 125){
            mensagemAtividade = "Nade um total de 60 minutos semanais.";
        } else {
            mensagemAtividade = "Nade um total de 140 minutos semanais." +
                    "\nConsulte um nutricionista para uma dieta\nadequada.";
        }
        return mensagemAtividade;
    }

    @Override
    public String exercitarAcademia() {
        if (this.porcentagemPesoIdeal < 125){
            mensagemAtividade = "Treine um total de 5 horas semanais.";
        } else {
            mensagemAtividade = "Treine um total de 10 horas semanais." +
                    "\nConsulte um nutricionista para uma dieta\nadequada.";
        }
        return mensagemAtividade;
    }

    public void exibirMensagens(){
        // mensagens
        // formatando o peso ideal
        String mensagemConclusao = String.format("A porcentagem do seu peso atual\n em relação ao seu peso ideal é: \n%.2f%%", porcentagemPesoIdeal);
        JOptionPane.showMessageDialog(null, mensagemConclusao, "Diagnóstico", JOptionPane.INFORMATION_MESSAGE);
        String mensagemRecomendacao = "";
        if (this.porcentagemPesoIdeal <= 100) {
            mensagemRecomendacao = "Analisando o seu quadro,\n" +
                    "não há a necessidade de emagrecimento.";
        } else if (tipoAtividade.equals("Caminhada")) {
            mensagemRecomendacao = caminharBosque();
        } else if (tipoAtividade.equals("Natação")) {
            mensagemRecomendacao = nadarPiscina();
        } else {
            mensagemRecomendacao = exercitarAcademia();
        }
        JOptionPane.showMessageDialog(null, mensagemRecomendacao, "Recomendações", JOptionPane.WARNING_MESSAGE);
    }
}
