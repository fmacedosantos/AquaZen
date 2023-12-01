package telas;

import classes.Paciente;
import paineis.PainelCadastroEmagrecimento;
import paineis.PainelCadastroEstetica;
import paineis.PainelExibirDados;

import javax.swing.*;
import javax.swing.plaf.basic.BasicMenuItemUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Set;

public class TelaAquaZen extends JFrame {

    // instanciação dos componentes
    private JMenuBar jMenuBar;
    private JMenu jmPacienteCadastro;
    private JMenuItem jmiEmagrecimentoCadastro, jmiEsteticaCadastro, jmiDados, jmiPesquisar, jmiSair;
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

        // OBJETOS
        iiTelaFundo = new ImageIcon("src/imagens/telaFundoSpa.png");
        jlTelaFundo = new JLabel(iiTelaFundo);

        // Personalização
        Color textoCabecalho = Color.BLACK;
        jMenuBar = new JMenuBar();

        // jmPaciente + Personalização
        jmPacienteCadastro = new JMenu("Paciente");
        jmPacienteCadastro.setForeground(textoCabecalho); // Define a cor do texto

        // jmiDados + Peronalização
        jmiDados = new JMenuItem("Exibir Dados");
        jmiDados.setForeground(textoCabecalho);
        jmiDados.setOpaque(false); // Define a opacidade para false

        // jmiPesquisar + Personalização
        jmiPesquisar = new JMenuItem("Pesquisar");
        jmiPesquisar.setForeground(textoCabecalho);
        jmiPesquisar.setOpaque(false);

        // jmiSair + Personalização
        jmiSair = new JMenuItem("Sair");
        jmiSair.setForeground(Color.WHITE);
        jmiSair.setBackground(Color.RED);
        jmiSair.setOpaque(true);

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

        add(jlTelaFundo);

        jlTelaFundo.setBounds(0, 0, getWidth(), getHeight());

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
