package classes;

public class  CalculoPeso {

    protected String sexo;
    protected double altura;
    protected double peso;
    protected double pesoIdeal;

    public CalculoPeso(String sexo, double altura, double peso) {
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public double pesoIdeal(){
        if (this.sexo.equals("Masculino")){
            this.pesoIdeal = (72.7 * this.altura - 58);
        } else {
            this.pesoIdeal = (62.1 * this.altura - 44.7);
        }
        return this.pesoIdeal;
    }

    public double porcentagemPesoIdeal(){
        return (this.peso / this.pesoIdeal) * 100;
    }
}
