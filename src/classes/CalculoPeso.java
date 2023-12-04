package classes;

public class  CalculoPeso {

    protected String sexo;
    protected Double altura;
    protected Double peso;
    protected Double pesoIdeal;

    public CalculoPeso(String sexo, Double altura, Double peso) {
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public Double pesoIdeal(){
        if (this.sexo.equals("Masculino")){
            this.pesoIdeal = (72.7 * this.altura - 58);
        } else {
            this.pesoIdeal = (62.1 * this.altura - 44.7);
        }
        return this.pesoIdeal;
    }

    public Double porcentagemPesoIdeal(){
        return (this.peso / this.pesoIdeal) * 100;
    }
}
