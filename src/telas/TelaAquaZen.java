package telas;

import classes.Paciente;
import paineis.PainelCadastroEmagrecimento;
import paineis.PainelCadastroEstetica;
import paineis.PainelExibirDadosSalvos;
import paineis.PainelPesquisarPacientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class TelaAquaZen extends JFrame {

    // instanciação dos componentes
    private JMenuBar jMenuBar;
    private JMenu jmPacienteCadastro, jmOpcoes;
    private JMenuItem jmiEmagrecimentoCadastro, jmiEsteticaCadastro, jmiDados, jmiPesquisar, jmiInicio, jmiSair;
    private JLabel jlTelaFundo;
    private ImageIcon iiTelaFundo, logo;
    private String iconeUrl;
    private Set<Paciente> pacientes;

    public TelaAquaZen(String title, Set<Paciente> pacientes) throws HeadlessException {
        super(title);
        this.pacientes = pacientes;
        setSize(400, 450);
        setResizable(false);
        setLayout(null);
        this.getContentPane().setBackground(Color.DARK_GRAY); // Define a cor de fundo
        setLocationRelativeTo(getContentPane());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        iconeUrl = "src/imagens/logoSpaAquaZen.png";
        logo = new ImageIcon(iconeUrl);
        setIconImage(logo.getImage());
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {

        // Personalização
        Color textoCabecalho = Color.black;

        // OBJETOS
        iiTelaFundo = new ImageIcon("src/imagens/telaFundoSpa.png");
        jlTelaFundo = new JLabel(iiTelaFundo);

        jMenuBar = new JMenuBar();

        // jmOpcoes + Personalização
        jmOpcoes = new JMenu("Opções");
        jmOpcoes.setForeground(textoCabecalho);
        jmOpcoes.setOpaque(false);

        // jmPaciente + Personalização
        jmPacienteCadastro = new JMenu("Paciente");
        jmPacienteCadastro.setForeground(textoCabecalho);
        jmPacienteCadastro.setOpaque(false);

        // jmiDados + Peronalização
        jmiDados = new JMenuItem("Exibir Dados Salvos");
        jmiDados.setForeground(textoCabecalho);
        jmiDados.setOpaque(false);

        // jmiPesquisar + Personalização
        jmiPesquisar = new JMenuItem("Pesquisar Pacientes");
        jmiPesquisar.setForeground(textoCabecalho);
        jmiPesquisar.setOpaque(false);

        jmiInicio = new JMenuItem("Início");

        // jmiSair + Personalização
        jmiSair = new JMenuItem("Sair");

        jmiEmagrecimentoCadastro = new JMenuItem("Emagrecimento");
        jmiEsteticaCadastro = new JMenuItem("Estética");

        // Adiciona a barra de menus ao JFrame
        setJMenuBar(jMenuBar);

        // Adiciona os menus à barra de menus
        jMenuBar.add(jmOpcoes);
        jMenuBar.add(jmPacienteCadastro);
        jMenuBar.add(jmiDados);
        jMenuBar.add(jmiPesquisar);

        // Adiciona os itens de menu aos menus
        jmPacienteCadastro.add(jmiEmagrecimentoCadastro);
        jmPacienteCadastro.add(jmiEsteticaCadastro);
        jmOpcoes.add(jmiInicio);
        jmOpcoes.add(jmiSair);

        add(jlTelaFundo);

        jlTelaFundo.setBounds(0, 0, getWidth(), getHeight());

    }



    private void criarEventos() {

        jmiInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll(); // remove todos os componentes da tela
                getContentPane().add(jlTelaFundo); // adiciona o novo painel
                getContentPane().validate(); // valida os componentes
                repaint(); // atualiza a tela
            }
        });

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
                getContentPane().removeAll();
                getContentPane().add(painelCadastroEsteticas);
                getContentPane().validate();
                repaint();
            }
        });

        jmiDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelExibirDadosSalvos dados = new PainelExibirDadosSalvos(pacientes);
                getContentPane().removeAll();
                getContentPane().add(dados);
                getContentPane().validate();
                repaint();
            }
        });

        jmiPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelPesquisarPacientes pesquisa = new PainelPesquisarPacientes(pacientes);
                getContentPane().removeAll();
                getContentPane().add(pesquisa);
                getContentPane().validate();
                repaint();
            }
        });

    }
}
