package paineis;

import classes.Paciente;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.util.Set;

public class PainelCadastroEmagrecimento extends JPanel {

    private Set<Paciente> pacientes;
    String[] opcoesAtividades = {"Caminhada", "Natação", "Treino"};
    private JLabel jlNome, jlTelefone, jlSexo, jlTipoAtividade, jlPeso, jlAltura;
    private JTextField jtfNome, jtfPeso, jtfAltura;
    private JComboBox<String> jcbAtividades;
    private JFormattedTextField jftfTelefone;
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

        // Cria os rótulos e campos de entrada
        jlNome = new JLabel("Nome:");
        jtfNome = new JTextField();
        jlTelefone = new JLabel("Telefone:");
        jftfTelefone = new JFormattedTextField();
        jlSexo = new JLabel("Sexo:");
        bgSexo = new ButtonGroup();
        jrbMasculino = new JRadioButton("Masculino");
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

        // Adiciona uma máscara de telefone ao campo de telefone
        try {
            MaskFormatter formatter = new MaskFormatter("(##) #####-####");
            formatter.install(jftfTelefone);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Define a posição e o tamanho dos componentes
        int y = 20;
        int xJtf = 170;
        jlNome.setBounds(50, y, 100, 20);
        jtfNome.setBounds(xJtf, y, 100, 20);
        y += 40;
        jlTelefone.setBounds(50, y, 100, 20);
        jftfTelefone.setBounds(xJtf, y, 100, 20);
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

        // Adiciona os rótulos e campos de entrada ao painel
        add(jlNome);
        add(jtfNome);
        add(jlTelefone);
        add(jftfTelefone);
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
    }


    private void criarEventos() {
        // Aqui você pode adicionar os listeners para os eventos
    }
}


