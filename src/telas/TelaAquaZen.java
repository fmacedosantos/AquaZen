package telas;

import classes.Paciente;
import paineis.PainelCadastroEmagrecimento;
import paineis.PainelCadastroEstetica;
import paineis.PainelExibirDados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class TelaAquaZen extends JFrame {

    private JMenuBar jMenuBar;
    private JMenu jmPacienteCadastro;
    private JMenuItem jmiEmagrecimentoCadastro, jmiEsteticaCadastro, jmiDados, jmiPesquisar, jmiSair;
    private Set<Paciente> pacientes;
    public TelaAquaZen(String title, Set<Paciente> pacientes) throws HeadlessException {
        super(title);
        this.pacientes = pacientes;
        setSize(400, 450);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(getContentPane());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        // obj
        jMenuBar = new JMenuBar();
        jmPacienteCadastro = new JMenu("Paciente");
        jmiDados = new JMenuItem("Exibir Dados");
        jmiPesquisar = new JMenuItem("Pesquisar");
        jmiSair = new JMenuItem("Sair");
        jmiEmagrecimentoCadastro = new JMenuItem("Emagrecimento");
        jmiEsteticaCadastro = new JMenuItem("Estética");

        // Adiciona a barra de menus ao JFrame
        setJMenuBar(jMenuBar);

        // Adiciona os menus à barra de menus
        jMenuBar.add(jmPacienteCadastro);
        jMenuBar.add(jmiDados);
        jMenuBar.add(jmiPesquisar);
        jMenuBar.add(jmiSair);

        // Adiciona os itens de menu aos menus
        jmPacienteCadastro.add(jmiEmagrecimentoCadastro);
        jmPacienteCadastro.add(jmiEsteticaCadastro);


    }

    private void criarEventos() {

        jmiSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jmiEmagrecimentoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelCadastroEmagrecimento painelCadastroEmagrecimentos = new PainelCadastroEmagrecimento(pacientes);
                getContentPane().removeAll(); // remove todos os componentes da tela
                getContentPane().add(painelCadastroEmagrecimentos); // adiciona o novo painel
                getContentPane().validate(); // valida os componentes
                repaint(); // atualiza a tela
            }
        });

        jmiEsteticaCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelCadastroEstetica painelCadastroEsteticas = new PainelCadastroEstetica(pacientes);
                getContentPane().removeAll(); // remove todos os componentes da tela
                getContentPane().add(painelCadastroEsteticas); // adiciona o novo painel
                getContentPane().validate(); // valida os componentes
                repaint(); // atualiza a tela
            }
        });

        jmiDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelExibirDados dados = new PainelExibirDados(pacientes);
                getContentPane().removeAll(); // remove todos os componentes da tela
                getContentPane().add(dados); // adiciona o novo painel
                getContentPane().validate(); // valida os componentes
                repaint(); // atualiza a tela
            }
        });

    }
}
