package paineis;

import classes.Emagrecimento;
import classes.Paciente;
import comandos.ComandoPaciente;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Set;

public class PainelCadastroEmagrecimento extends JPanel {

    private Set<Paciente> pacientes;
    private Emagrecimento emagrecimentos;
    String[] opcoesAtividades = {"Caminhada", "Natação", "Treino"};
    private JLabel jlNome, jlTelefone, jlSexo, jlTipoAtividade, jlPeso, jlAltura;
    private JTextField jtfNome, jtfTelefone, jtfPeso, jtfAltura;
    private MaskFormatter mkfTelefone;
    private JComboBox<String> jcbAtividades;
    //private JFormattedTextField jftfTelefone;
    private ButtonGroup bgSexo;
    private JRadioButton jrbMasculino, jrbFeminino;
    private JButton jbCadastrar;

    public PainelCadastroEmagrecimento(Set<Paciente> pacientes) {
        super();
        this.pacientes = pacientes;
        setSize(400, 450);
        // Configura o layout do painel para null
        setLayout(null);
        // definindo a cor de fundo do painel
        Color fundo = new Color(159, 198, 255);
        this.setBackground(fundo);
        inicarComponentes();
        criarEventos();
    }

    private void inicarComponentes() {

        // Adiciona uma máscara de telefone ao campo de telefone
        try {
            mkfTelefone = new MaskFormatter("(##)#####-####");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Cria os rótulos e campos de entrada
        jlNome = new JLabel("Nome:");
        jtfNome = new JTextField();

        jlTelefone = new JLabel("Telefone:");
        jtfTelefone = new JTextField();
        jtfTelefone = new JFormattedTextField(mkfTelefone);

        jlSexo = new JLabel("Sexo:");
        bgSexo = new ButtonGroup();
        jrbMasculino = new JRadioButton("Masculino", true);
        jrbMasculino.setOpaque(false);
        jrbFeminino = new JRadioButton("Feminino");
        jrbFeminino.setOpaque(false);
        bgSexo.add(jrbMasculino);
        bgSexo.add(jrbFeminino);

        jlTipoAtividade = new JLabel("Tipo de Atividade:");
        jcbAtividades = new JComboBox<>(opcoesAtividades);

        jlPeso = new JLabel("Peso:");
        jtfPeso = new JTextField();

        jlAltura = new JLabel("Altura:");
        jtfAltura = new JTextField();

        // jbCadastrar + Personalização
        jbCadastrar = new JButton("Cadastrar");
        jbCadastrar.setForeground(Color.WHITE);
        jbCadastrar.setBackground(new Color(105, 168, 204));


        // Adiciona os rótulos e campos de entrada ao painel
        add(jlNome);
        add(jtfNome);
        add(jlTelefone);
        add(jtfTelefone);
        add(jlSexo);
        add(jrbMasculino);
        add(jrbFeminino);
        add(jlTipoAtividade);
        add(jcbAtividades);
        add(jlPeso);
        add(jtfPeso);
        add(jlAltura);
        add(jtfAltura);

        // Adiciona o botão ao painel
        add(jbCadastrar);

        // Define a posição e o tamanho dos componentes
        int y = 20;
        int xJtf = 170;
        jlNome.setBounds(50, y, 100, 20);
        jtfNome.setBounds(xJtf, y, 100, 20);
        y += 40;
        jlTelefone.setBounds(50, y, 100, 20);
        jtfTelefone.setBounds(xJtf, y, 100, 20);
        y += 40;
        jlSexo.setBounds(50, y, 100, 20);
        jrbMasculino.setBounds(130, y, 100, 20);
        jrbFeminino.setBounds(230, y, 100, 20);
        y += 40;
        jlTipoAtividade.setBounds(50, y, 100, 20);
        jcbAtividades.setBounds(xJtf, y, 100, 20);
        y += 40;
        jlPeso.setBounds(50, y, 100, 20);
        jtfPeso.setBounds(xJtf, y, 100, 20);
        y += 40;
        jlAltura.setBounds(50, y, 100, 20);
        jtfAltura.setBounds(xJtf, y, 100, 20);
        y += 40;
        jbCadastrar.setBounds(140, y, 100, 20);

    }


    private void criarEventos() {
        jbCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome, telefone, sexo, tipoAtividade;
                Double peso, altura;

                nome = jtfNome.getText();
                telefone = jtfTelefone.getText();
                if (jrbMasculino.isSelected()){
                    sexo = "Masculino";
                } else {
                    sexo = "Feminino";
                }
                if (jcbAtividades.getSelectedIndex() == 0){
                    tipoAtividade = "Caminhada";
                    System.out.println(tipoAtividade);
                } else if (jcbAtividades.getSelectedIndex() == 1) {
                    tipoAtividade = "Natação";
                } else {
                    tipoAtividade = "Treino";
                }
                peso = Double.valueOf(jtfPeso.getText());
                altura = Double.valueOf(jtfAltura.getText());
                emagrecimentos = new Emagrecimento(nome, telefone, sexo, tipoAtividade,
                        peso, altura);
                pacientes.add(emagrecimentos);

                // formatando o peso ideal
                double porcentagemPesoIdeal = emagrecimentos.getPesoIdeal();
                porcentagemPesoIdeal = emagrecimentos.getPorcentagemPesoIdeal();
                String mensagemConclusao = String.format("A porcentagem do seu peso atual\n em relação ao seu peso ideal é: \n%.2f%%", porcentagemPesoIdeal);
                JOptionPane.showMessageDialog(null, mensagemConclusao, "Diagnóstico", JOptionPane.INFORMATION_MESSAGE);
                String mensagemRecomendacao = "";
                if (emagrecimentos.getPesoIdeal() <= 100) {
                    mensagemRecomendacao = "Você está em seu peso ideal,\n" +
                            "não há a necessidade de emagrecimento.";
                } else if (tipoAtividade.equals("Caminhada")){
                    mensagemRecomendacao = emagrecimentos.caminharBosque();
                } else if (tipoAtividade.equals("Natação")) {
                    mensagemRecomendacao = emagrecimentos.nadarPiscina();
                } else {
                    mensagemRecomendacao = emagrecimentos.exercitarAcademia();
                }

                ComandoPaciente comandoPaciente = new ComandoPaciente();
                comandoPaciente.inserirEmagrecimentoBD(nome, telefone, sexo, tipoAtividade, peso, altura, porcentagemPesoIdeal);

                JOptionPane.showMessageDialog(null, mensagemRecomendacao, "Recomendações", JOptionPane.WARNING_MESSAGE);
                // fazer uma recomendação
            }
        });
    }
}


