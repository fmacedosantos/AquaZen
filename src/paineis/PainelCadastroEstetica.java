package paineis;

import classes.Estetica;
import classes.Paciente;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Set;

public class PainelCadastroEstetica extends JPanel {

    private Set<Paciente> pacientes;
    String[] opcoesAtividades = {"Caminhada", "Natação", "Treino"};
    private JLabel jlNome, telefoneLabel, sexoLabel, tipoAtividadeLabel, jlTipoServico;
    private JTextField nomeField; // Combo box para tipo de serviço
    private JFormattedTextField telefoneField;
    private ButtonGroup sexoGroup;
    private JRadioButton masculinoButton, femininoButton;
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
    private JButton cadastrarButton;

    public PainelCadastroEstetica(Set<Paciente> pacientes) {
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
        jlNome = new JLabel("Nome:");
        nomeField = new JTextField();
        telefoneLabel = new JLabel("Telefone:");
        telefoneField = new JFormattedTextField();
        sexoLabel = new JLabel("Sexo:");
        sexoGroup = new ButtonGroup();
        masculinoButton = new JRadioButton("Masculino");
        femininoButton = new JRadioButton("Feminino");
        sexoGroup.add(masculinoButton);
        sexoGroup.add(femininoButton);
        tipoAtividadeLabel = new JLabel("Tipo de Atividade:");
        jcbAtividades = new JComboBox<>(opcoesAtividades);
        jlTipoServico = new JLabel("Serviços a Contratar:");
        jcbxDrenagemLinfatica = new JCheckBox("Drenagem Linfática");
        jcbxHidratacaoPesMaos = new JCheckBox("Hidratação (Pés / Mãos)");
        jcbxLimpezaPele = new JCheckBox("Limpeza (Pele)");
        jcbxBanhoLua = new JCheckBox("Banho de Lua");
        jcbxPeeling = new JCheckBox("Peeling");
        jcbxCuidadosCabelo = new JCheckBox("Cabelo");
        jcbxMassagemEsfolianteFacialCorporal = new JCheckBox("Massagem Esfoliante (Facial / Corporal)");

        // Cria o botão
        cadastrarButton = new JButton("Cadastrar");

        // Adiciona uma máscara de telefone ao campo de telefone
        try {
            MaskFormatter formatter = new MaskFormatter("(##) #####-####");
            formatter.install(telefoneField);
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
        nomeField.setBounds(xJtf, y, wid, hei);
        y += 40;
        telefoneLabel.setBounds(xJl, y, wid, hei);
        telefoneField.setBounds(xJtf, y, wid, hei);
        y += 40;
        sexoLabel.setBounds(xJl, y, wid, hei);
        masculinoButton.setBounds(130, y, wid, hei);
        femininoButton.setBounds(230, y, wid, hei);
        y += 40;
        tipoAtividadeLabel.setBounds(xJl, y, wid, hei);
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
        cadastrarButton.setBounds(140, y, wid, hei);

        // Adiciona os rótulos e campos de entrada ao painel
        add(jlNome);
        add(nomeField);
        add(telefoneLabel);
        add(telefoneField);
        add(sexoLabel);
        add(masculinoButton);
        add(femininoButton);
        add(tipoAtividadeLabel);
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
        add(cadastrarButton);
    }


    private void criarEventos() {
        cadastrarButton.addActionListener(new ActionListener() {
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

