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


                String nome = jtfNome.getText(),
                        telefone = jtfTelefone.getText(),
                        telfoneSemMascara = telefone.replaceAll("\\D", ""),
                        sexo = jrbMasculino.isSelected() ? "Masculino" : "Feminino",
                        tipoAtividade = jcbAtividades.getSelectedIndex() == 0 ?
                                "Caminhada" : jcbAtividades.getSelectedIndex() == 1 ?
                                "Natação" : "Treino";


                if (!nome.isEmpty() && !telfoneSemMascara.isEmpty() && !jtfPeso.getText().replaceAll("\\D", "").isEmpty() && !jtfAltura.getText().replaceAll("\\D", "").isEmpty()) {
                    Double peso = Double.parseDouble(jtfPeso.getText()),
                            altura = Double.parseDouble(jtfAltura.getText());
                    emagrecimentos = new Emagrecimento(nome, telefone, sexo, tipoAtividade, peso, altura);
                    double porcentagemPesoIdeal = emagrecimentos.getPorcentagemPesoIdeal();
                    pacientes.add(emagrecimentos);
                    ComandoPaciente comandoPaciente = new ComandoPaciente();
                    comandoPaciente.inserirEmagrecimentoBD(nome, telefone, sexo, tipoAtividade, peso, altura, porcentagemPesoIdeal);
                    emagrecimentos.exibirMensagens();
                    jtfNome.setText("");
                    jtfTelefone.setText("");
                    jtfPeso.setText("");
                    jtfAltura.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha todos os dados corretamente.", "Aviso:", JOptionPane.WARNING_MESSAGE);
                }
            }




        });
    }
}


