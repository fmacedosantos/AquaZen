package paineis;

import classes.Paciente;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class PainelPesquisarPacientes extends JPanel {
    Set<Paciente> pacientes;
    private JTextField jtfNomePesquisa;
    private JButton jbPesquisar, jbAlterar, jbExcluir;
    private JTextArea jtaMostrar;
    private JScrollPane jspMostrar;

    public PainelPesquisarPacientes(Set<Paciente> pacientes) {
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

        jtfNomePesquisa = new JTextField();
        jbPesquisar = new JButton("Exibir");
        jbPesquisar.setForeground(Color.WHITE);
        jbPesquisar.setBackground(new Color(105, 168, 204));
        jtaMostrar = new JTextArea();
        jspMostrar = new JScrollPane(jtaMostrar);
        jbAlterar = new JButton("Alterar");
        jbAlterar.setForeground(Color.white);
        jbAlterar.setBackground(Color.GRAY);
        jbExcluir = new JButton("Excluir");
        jbExcluir.setForeground(Color.white);
        jbExcluir.setBackground(Color.red);

        add(jtfNomePesquisa);
        add(jbPesquisar);
        add(jtaMostrar);
        add(jspMostrar);
        add(jbAlterar);
        add(jbExcluir);

        int y = 20;
        int wid = 100;
        int hei = 20;
        jtfNomePesquisa.setBounds(10, y, 255, hei);
        jbPesquisar.setBounds(275, y, wid, hei);
        y += 40;
        jspMostrar.setBounds(10, y, 365, 260);
        y += 285;
        jbAlterar.setBounds(80, y, wid, hei);
        jbExcluir.setBounds(200, y, wid, hei);
    }

    private void criarEventos() {
    }
}
