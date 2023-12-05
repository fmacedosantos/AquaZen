package paineis;

import classes.Paciente;
import comandos.ComandoPaciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        jtaMostrar = new JTextArea(1000, 13);
        jspMostrar = new JScrollPane(jtaMostrar);
        jbAlterar = new JButton("Alterar");
        jbAlterar.setForeground(Color.white);
        jbAlterar.setBackground(Color.GRAY);
        jbExcluir = new JButton("Excluir");
        jbExcluir.setForeground(Color.white);
        jbExcluir.setBackground(Color.red);

        add(jtfNomePesquisa);
        add(jbPesquisar);
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
        jbPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jtfNomePesquisa.getText().isEmpty() && jtfNomePesquisa.getText().matches("[0-9]+")) {
                    int codigo = Integer.parseInt(jtfNomePesquisa.getText());
                    ComandoPaciente comandoPaciente = new ComandoPaciente();

                    if (comandoPaciente.pesquisarPaciente(codigo, jtaMostrar)) {
                        comandoPaciente.pesquisarPaciente(codigo, jtaMostrar);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Insira um código válido!", "Aviso:",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Insira o código do paciente\nque deseja exibir!",
                            "Aviso:", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        jbAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jtfNomePesquisa.getText().isEmpty() && jtfNomePesquisa.getText().matches("[0-9]+")) {
                    int codigo = Integer.parseInt(jtfNomePesquisa.getText());
                    ComandoPaciente comandoPaciente = new ComandoPaciente();
                    // verificar se existe paciente com o código
                    if (comandoPaciente.pesquisarPaciente(codigo, jtaMostrar)){
                        comandoPaciente.alterarAtividadePaciente(codigo);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Insira um código válido!", "Aviso:",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Insira o código do paciente\nque deseja alterar!",
                            "Aviso:", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        jbExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jtfNomePesquisa.getText().isEmpty() && jtfNomePesquisa.getText().matches("[0-9]+")){
                    int codigo = Integer.parseInt(jtfNomePesquisa.getText());
                    ComandoPaciente comandoPaciente = new ComandoPaciente();

                    // verificar se existe paciente com o código
                    if (comandoPaciente.pesquisarPaciente(codigo, jtaMostrar)){
                        Object[] options = {"Sim", "Não"};
                        int opcao = JOptionPane.showOptionDialog(null,
                                "Você irá excluir o paciente " + codigo + ".",
                                "Deseja continuar com a operação?",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE,
                                null,
                                options, // os títulos dos botões
                                options[0]); // botão padrão

                        if (opcao == 0) {
                            comandoPaciente.deletarPaciente(codigo);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "O paciente não foi excluido.",
                                    "Operação cancelada!",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Insira um código válido!", "Aviso:",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Insira o código do paciente\nque deseja excluir.",
                            "Aviso:", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
