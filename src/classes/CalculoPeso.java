package classes;

public class  CalculoPeso {

    protected String sexo;
    protected Double altura;
    protected Double pesoIdeal;

    public CalculoPeso(String sexo, Double altura) {
        this.sexo = sexo;
        this.altura = altura;
    }

    public Double pesoIdeal(){
        if (this.sexo.equals("Masculino")){
            this.pesoIdeal = (72.7 * this.altura - 58);
        } else {
            this.pesoIdeal = (62.1 * this.altura - 44.7);
        }
        return this.pesoIdeal;
    }
}
