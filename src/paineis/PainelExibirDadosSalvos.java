package paineis;

import classes.Paciente;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class PainelExibirDadosSalvos extends JPanel {

    private Set<Paciente> pacientes;
    private JLabel jlObjetivoPaciente;
    private JTextArea jtaMostrar; // cria nosso terminal
    private ButtonGroup btPaciente;
    private JRadioButton jrbEmagrecimento, jrbEstetica;
    private JScrollPane jspMostrar; // cria uma barra de rolagem
    private JButton jbMostrarDados;

    public PainelExibirDadosSalvos(Set<Paciente> pacientes) {
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
        jlObjetivoPaciente = new JLabel("Selecione:");
        jtaMostrar = new JTextArea();
        jspMostrar = new JScrollPane(jtaMostrar);
        btPaciente = new ButtonGroup();
        jrbEmagrecimento = new JRadioButton("Emagrecimento");
        jrbEmagrecimento.setOpaque(false);
        jrbEstetica = new JRadioButton("Estetica");
        jrbEstetica.setOpaque(false);
        btPaciente.add(jrbEmagrecimento);
        btPaciente.add(jrbEstetica);
        // jbMostrarDados + Personalização
        jbMostrarDados = new JButton("Mostrar Dados");
        jbMostrarDados.setForeground(Color.WHITE);
        jbMostrarDados.setBackground(new Color(105, 168, 204));

        add(jlObjetivoPaciente);
        add(jtaMostrar);
        add(jspMostrar);
        add(jrbEmagrecimento);
        add(jrbEstetica);
        add(jbMostrarDados);

        jspMostrar.setBounds(10, 10, 365, 270);

        jlObjetivoPaciente.setBounds(10, 290, 100, 20);

        jrbEmagrecimento.setBounds(10, 310, 130, 20);
        jrbEstetica.setBounds(150, 310, 130, 20);

        jbMostrarDados.setBounds(100, 350, 180, 20);
    }

    private void criarEventos() {
    }
}
