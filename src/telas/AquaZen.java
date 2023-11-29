package telas;

import classes.Emagrecimento;
import classes.Estetica;
import classes.Paciente;
import paineis.CadastroEmagrecimento;
import paineis.CadastroEstetica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class AquaZen extends JFrame {

    private JMenuBar jMenuBar;
    private JMenu jmPacienteCadastro, jmPacienteDados, jmOpcoes;
    private JMenuItem jmiEmagrecimentoCadastro, jmiEsteticaCadastro, jmiEmagrecimentoDados, jmiEsteticaDados, jmiSair; // Alterar e Remover
    private Set<Paciente> pacientes;
    public AquaZen(String title, Set<Paciente> pacientes) throws HeadlessException {
        super(title);
        this.pacientes = pacientes;
        setSize(400, 450);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(getContentPane());
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {
        // obj
        jMenuBar = new JMenuBar();
        jmPacienteCadastro = new JMenu("Cadastro");
        jmPacienteDados = new JMenu("Dados");
        jmOpcoes = new JMenu("Opções");
        jmiEmagrecimentoCadastro = new JMenuItem("Emagrecimento");
        jmiEsteticaCadastro = new JMenuItem("Estética");
        jmiEmagrecimentoDados = new JMenuItem("Emagrecimento");
        jmiEsteticaDados = new JMenuItem("Estética");
        jmiSair = new JMenuItem("Sair");

        // Adiciona a barra de menus ao JFrame
        setJMenuBar(jMenuBar);

        // Adiciona os menus à barra de menus
        jMenuBar.add(jmPacienteCadastro);
        jMenuBar.add(jmPacienteDados);
        jMenuBar.add(jmOpcoes);

        // Adiciona os itens de menu aos menus
        jmPacienteCadastro.add(jmiEmagrecimentoCadastro);
        jmPacienteCadastro.add(jmiEsteticaCadastro);
        jmPacienteDados.add(jmiEmagrecimentoDados);
        jmPacienteDados.add(jmiEsteticaDados);
        jmOpcoes.add(jmiSair);


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
                CadastroEmagrecimento painelCadastroEmagrecimentos = new CadastroEmagrecimento(pacientes);
                getContentPane().removeAll(); // remove todos os componentes da tela
                getContentPane().add(painelCadastroEmagrecimentos); // adiciona o novo painel
                getContentPane().validate(); // valida os componentes
                repaint(); // atualiza a tela
            }
        });

        jmiEsteticaCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroEstetica painelCadastroEsteticas = new CadastroEstetica(pacientes);
                getContentPane().removeAll(); // remove todos os componentes da tela
                getContentPane().add(painelCadastroEsteticas); // adiciona o novo painel
                getContentPane().validate(); // valida os componentes
                repaint(); // atualiza a tela
            }
        });

    }
}
