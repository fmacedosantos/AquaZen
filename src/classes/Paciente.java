package classes;

public class Paciente {

    protected String nome;
    protected String telefone;
    protected String sexo;
    protected String tipoAtividade;

    public Paciente(String nome, String telefone, String sexo, String tipoAtividade) {
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.tipoAtividade = tipoAtividade;
    }

    public String mostrarDados(){
        return "Nome: " + this.nome
                + "\nTelefone: " + this.telefone
                + "\nSexo: " + this.sexo
                + "\nTipo de Atividade: " + this.tipoAtividade;
    }


}
