package classes;

import interfaces.Atividades;

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
        if (this.pesoIdeal < 140){
            mensagemAtividade = "Caminhe um total de 130 minutos semanais.";
        } else {
            mensagemAtividade = "Caminhe um total de 250 minutos semanais." +
                    "\nConsulte um nutricionista para uma dieta\nadequada.";
        }
        return mensagemAtividade;
    }

    @Override
    public String nadarPiscina() {
        if (this.pesoIdeal < 140){
            mensagemAtividade = "Nade um total de 60 minutos semanais.";
        } else {
            mensagemAtividade = "Nade um total de 140 minutos semanais." +
                    "\nConsulte um nutricionista para uma dieta\nadequada.";
        }
        return mensagemAtividade;
    }

    @Override
    public String exercitarAcademia() {
        if (this.pesoIdeal < 140){
            mensagemAtividade = "Treine um total de 5 horas semanais.";
        } else {
            mensagemAtividade = "Treine um total de 10 horas semanais." +
                    "\nConsulte um nutricionista para uma dieta\nadequada.";
        }
        return mensagemAtividade;
    }
}
