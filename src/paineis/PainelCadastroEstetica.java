package paineis;

import classes.Paciente;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Set;

public class PainelCadastroEstetica extends JPanel {

    private Set<Paciente> pacientes;
    String[] opcoesAtividades = {"Caminhada", "Natação", "Treino"};
    private JLabel jlNome, jlTelefone, jlSexo, jlTipoAtividade, jlTipoServico;
    private JTextField jtfNome;
    private JFormattedTextField jftTelefone;
    private ButtonGroup sexoGroup;
    private JRadioButton jrbMasculino, jrbFeminino;
    private JComboBox<String> jcbAtividades;
    private JCheckBox jcbxDrenagemLinfatica, jcbxHidratacaoPesMaos, jcbxLimpezaPele,
            jcbxBanhoLua, jcbxPeeling, jcbxCuidadosCabelo, jcbxMassagemEsfolianteFacialCorporal;
    JCheckBox[] checkBoxes = {
            jcbxDrenagemLinfatica,
            jcbxHidratacaoPesMaos,
            jcbxLimpezaPele,
            jcbxBanhoLua,
            jcbxPeeling,
            jcbxCuidadosCabelo,
            jcbxMassagemEsfolianteFacialCorporal
    };
    private JButton jbCadastrar;

    public PainelCadastroEstetica(Set<Paciente> pacientes) {
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
        jftTelefone = new JFormattedTextField();
        jlSexo = new JLabel("Sexo:");
        sexoGroup = new ButtonGroup();
        jrbMasculino = new JRadioButton("Masculino");
        jrbMasculino.setOpaque(false);
        jrbFeminino = new JRadioButton("Feminino");
        jrbFeminino.setOpaque(false);
        sexoGroup.add(jrbMasculino);
        sexoGroup.add(jrbFeminino);
        jlTipoAtividade = new JLabel("Tipo de Atividade:");
        jcbAtividades = new JComboBox<>(opcoesAtividades);

        // Serviços + Personalização
        jlTipoServico = new JLabel("Serviços a Contratar:");
        jcbxDrenagemLinfatica = new JCheckBox("Drenagem Linfática");
        jcbxDrenagemLinfatica.setOpaque(false);
        jcbxHidratacaoPesMaos = new JCheckBox("Hidratação (Pés / Mãos)");
        jcbxHidratacaoPesMaos.setOpaque(false);
        jcbxLimpezaPele = new JCheckBox("Limpeza (Pele)");
        jcbxLimpezaPele.setOpaque(false);
        jcbxBanhoLua = new JCheckBox("Banho de Lua");
        jcbxBanhoLua.setOpaque(false);
        jcbxPeeling = new JCheckBox("Peeling");
        jcbxPeeling.setOpaque(false);
        jcbxCuidadosCabelo = new JCheckBox("Cabelo");
        jcbxCuidadosCabelo.setOpaque(false);
        jcbxMassagemEsfolianteFacialCorporal = new JCheckBox("Massagem Esfoliante (Facial / Corporal)");
        jcbxMassagemEsfolianteFacialCorporal.setOpaque(false);

        // jbCadastrar + Personalização
        jbCadastrar = new JButton("Cadastrar");
        jbCadastrar.setForeground(Color.WHITE);
        jbCadastrar.setBackground(new Color(105, 168, 204));

        // Adiciona uma máscara de telefone ao campo de telefone
        try {
            MaskFormatter formatter = new MaskFormatter("(##) #####-####");
            formatter.install(jftTelefone);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Define a posição e o tamanho dos componentes
        int xJl = 50;
        int xJtf = 170;
        int y = 20;
        int wid = 100;
        int hei = 20;
        jlNome.setBounds(xJl, y, wid, hei);
        jtfNome.setBounds(xJtf, y, wid, hei);
        y += 40;
        jlTelefone.setBounds(xJl, y, wid, hei);
        jftTelefone.setBounds(xJtf, y, wid, hei);
        y += 40;
        jlSexo.setBounds(xJl, y, wid, hei);
        jrbMasculino.setBounds(130, y, wid, hei);
        jrbFeminino.setBounds(230, y, wid, hei);
        y += 40;
        jlTipoAtividade.setBounds(xJl, y, wid, hei);
        jcbAtividades.setBounds(xJtf, y, wid, hei);
        y += 40;
        jlTipoServico.setBounds(xJl, y, 130, hei);
        jcbxDrenagemLinfatica.setBounds(190, y, 140, hei);
        y += 30;
        jcbxHidratacaoPesMaos.setBounds(xJl, y, 170, hei); // 70 de distancia
        jcbxLimpezaPele.setBounds(230, y, 160, hei);
        y += 30;
        jcbxBanhoLua.setBounds(xJl, y, 120, hei);
        jcbxPeeling.setBounds(170, y, 80, hei);
        jcbxCuidadosCabelo.setBounds(260, y, 160, hei);
        y += 30;
        jcbxMassagemEsfolianteFacialCorporal.setBounds(xJl, y, 350, hei);
        y += 40;

        jbCadastrar.setBounds(140, y, wid, hei);

        // Adiciona os rótulos e campos de entrada ao painel
        add(jlNome);
        add(jtfNome);
        add(jlTelefone);
        add(jftTelefone);
        add(jlSexo);
        add(jrbMasculino);
        add(jrbFeminino);
        add(jlTipoAtividade);
        add(jcbAtividades);
        add(jlTipoServico);
        add(jcbxHidratacaoPesMaos);
        add(jcbxDrenagemLinfatica);
        add(jcbxLimpezaPele);
        add(jcbxBanhoLua);
        add(jcbxPeeling);
        add(jcbxCuidadosCabelo);
        add(jcbxMassagemEsfolianteFacialCorporal);

        // Adiciona o botão ao painel
        add(jbCadastrar);
    }


    private void criarEventos() {
        jbCadastrar.addActionListener(new ActionListener() {
            // conta quantas check boxes estão selecionadas
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedCount = 0;
                for (JCheckBox checkBox : checkBoxes) {
                    if (checkBox.isSelected()) {
                        selectedCount++;
                    }
                }

                // faz o processo correpondente à quantidade de check boxes
                if (selectedCount == 1) {
                    // construtor 1
                } else if (selectedCount == 2) {
                    // construtor 2
                } else if (selectedCount == 3) {
                    // construtor 3
                } else {
                    // exibir mensagem
                }
            }
        });
    }
}

