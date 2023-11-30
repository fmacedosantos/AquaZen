package paineis;

import classes.Paciente;

import javax.swing.*;
import java.util.Set;

public class PainelExibirDados extends JPanel {

    private Set<Paciente> pacientes;
    private JLabel selecaoTipoPaciente;
    private JTextArea jtaMostrar; // cria nosso terminal
    private ButtonGroup btPaciente;
    private JRadioButton emagrecimento, estetica;
    private JScrollPane jspMostrar; // cria uma barra de rolagem
    private JButton mostrarDados;

    public PainelExibirDados(Set<Paciente> pacientes) {
        super();
        this.pacientes = pacientes;
        setSize(400, 450);
        // Configura o layout do painel para null
        setLayout(null);
        inicarComponentes();
        criarEventos();
    }

    private void inicarComponentes() {

        // Cria os rótulos e campos de entrada
        selecaoTipoPaciente = new JLabel("Selecione:");
        jtaMostrar = new JTextArea();
        jspMostrar = new JScrollPane(jtaMostrar);
        btPaciente = new ButtonGroup();
        emagrecimento = new JRadioButton("Emagrecimento");
        estetica = new JRadioButton("Estetica");
        btPaciente.add(emagrecimento);
        btPaciente.add(estetica);
        mostrarDados = new JButton("Mostrar Dados");

        add(selecaoTipoPaciente);
        add(jtaMostrar);
        add(jspMostrar);
        add(emagrecimento);
        add(estetica);
        add(mostrarDados);

        jspMostrar.setBounds(10, 10, 365, 270);

        selecaoTipoPaciente.setBounds(10, 290, 100, 20);

        emagrecimento.setBounds(10, 310, 130, 20);
        estetica.setBounds(150, 310, 130, 20);

        mostrarDados.setBounds(100, 350, 180, 20);
    }

    private void criarEventos() {
    }
}
