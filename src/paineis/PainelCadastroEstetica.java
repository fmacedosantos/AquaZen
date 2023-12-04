package paineis;

import classes.Estetica;
import classes.Paciente;
import comandos.ComandoPaciente;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PainelCadastroEstetica extends JPanel {

    private Set<Paciente> pacientes;
    private Estetica esteticas;
    String[] opcoesAtividades = {"Caminhada", "Natação", "Treino"};
    private JLabel jlNome, jlTelefone, jlSexo, jlTipoAtividade, jlTipoServico;
    private JTextField jtfNome, jtfTelefone;
    //private JFormattedTextField jftfTelefone;
    private MaskFormatter mkfTelefone;
    private ButtonGroup sexoGroup;
    private JRadioButton jrbMasculino, jrbFeminino;
    private JComboBox<String> jcbAtividades;
    private JCheckBox jcbxDrenagemLinfatica, jcbxHidratacaoPesMaos, jcbxLimpezaPele, jcbxBanhoLua, jcbxPeeling, jcbxCuidadosCabelo, jcbxMassagemEsfolianteFacialCorporal;
    JCheckBox[] checkBoxes;

    List<String> checkBoxesSelecionadas = new ArrayList<>();
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

        // Adiciona uma máscara de telefone ao campo de telefone
        try {
            mkfTelefone = new MaskFormatter("(##)#####-####");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Cria os rótulos e campos de entrada
        jlNome = new JLabel("Nome:");
        jtfNome = new JTextField();

        jlTelefone = new JLabel("Telefone:");
        jtfTelefone = new JTextField();
        jtfTelefone = new JFormattedTextField(mkfTelefone);

        jlSexo = new JLabel("Sexo:");
        sexoGroup = new ButtonGroup();
        jrbMasculino = new JRadioButton("Masculino", true);
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
        jcbxMassagemEsfolianteFacialCorporal = new JCheckBox("Massagem Esfoliante");
        jcbxMassagemEsfolianteFacialCorporal.setOpaque(false);

        // Add the checkboxes to the array after they are created
        checkBoxes = new JCheckBox[]{jcbxDrenagemLinfatica, jcbxHidratacaoPesMaos, jcbxLimpezaPele, jcbxBanhoLua, jcbxPeeling, jcbxCuidadosCabelo, jcbxMassagemEsfolianteFacialCorporal};

        // jbCadastrar + Personalização
        jbCadastrar = new JButton("Cadastrar");
        jbCadastrar.setForeground(Color.WHITE);
        jbCadastrar.setBackground(new Color(105, 168, 204));


        // Adiciona os rótulos e campos de entrada ao painel
        add(jlNome);
        add(jtfNome);
        add(jlTelefone);
        add(jtfTelefone);
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

        // Define a posição e o tamanho dos componentes
        int xJLabels = 50;
        int xJFormattedTextFields = 170;
        int y = 20;
        int width = 100;
        int height = 20;
        jlNome.setBounds(xJLabels, y, width, height);
        jtfNome.setBounds(xJFormattedTextFields, y, width, height);
        y += 40;
        jlTelefone.setBounds(xJLabels, y, width, height);
        jtfTelefone.setBounds(xJFormattedTextFields, y, width, height);
        y += 40;
        jlSexo.setBounds(xJLabels, y, width, height);
        jrbMasculino.setBounds(130, y, width, height);
        jrbFeminino.setBounds(230, y, width, height);
        y += 40;
        jlTipoAtividade.setBounds(xJLabels, y, width, height);
        jcbAtividades.setBounds(xJFormattedTextFields, y, width, height);
        y += 40;
        jlTipoServico.setBounds(xJLabels, y, 130, height);
        jcbxDrenagemLinfatica.setBounds(190, y, 140, height);
        y += 30;
        jcbxHidratacaoPesMaos.setBounds(xJLabels, y, 170, height); // 70 de distancia
        jcbxLimpezaPele.setBounds(230, y, 160, height);
        y += 30;
        jcbxBanhoLua.setBounds(xJLabels, y, 120, height);
        jcbxPeeling.setBounds(170, y, 80, height);
        jcbxCuidadosCabelo.setBounds(260, y, 160, height);
        y += 30;
        jcbxMassagemEsfolianteFacialCorporal.setBounds(xJLabels, y, 350, height);
        y += 40;

        jbCadastrar.setBounds(140, y, width, height);

    }


    private void criarEventos() {
        jbCadastrar.addActionListener(new ActionListener() {
            // conta quantas check boxes estão selecionadas
            @Override
            public void actionPerformed(ActionEvent e) {
                // atribuições
                String nome = jtfNome.getText(),
                        telefone = jtfTelefone.getText(),
                        telfoneSemMascara = telefone.replaceAll("\\D", ""),
                        sexo = jrbMasculino.isSelected() ? "Masculino" : "Feminino",
                        tipoAtividade,
                        servico1 = "Serviço ñ selecionado",
                        servico2 = "Serviço ñ selecionado",
                        servico3 = "Serviço ñ selecionado";

                tipoAtividade = jcbAtividades.getSelectedIndex() == 0 ?
                        "Caminhada" : jcbAtividades.getSelectedIndex() == 1 ?
                        "Natação" : "Treino";


                // percorre as checkboxes e adiciona as selecionadas à uma lista
                int selectedCount = 0;
                for (JCheckBox checkBox : checkBoxes) {
                    if (checkBox.isSelected()) {
                        checkBoxesSelecionadas.add(checkBox.getText());
                        selectedCount++;
                    }
                }

                if (!checkBoxesSelecionadas.isEmpty()) {
                    servico1 = checkBoxesSelecionadas.get(0);
                    if (checkBoxesSelecionadas.size() > 1) {
                        servico2 = checkBoxesSelecionadas.get(1);
                    }
                    if (checkBoxesSelecionadas.size() > 2) {
                        servico3 = checkBoxesSelecionadas.get(2);
                    }
                }


                // verificação de dados preenchidos
                if (!nome.isEmpty() && !telfoneSemMascara.isEmpty() && !servico1.equals("Serviço ñ selecionado")) {

                    // faz o processo correpondente à quantidade de check boxes
                    ComandoPaciente comandoPaciente = new ComandoPaciente();
                    if (selectedCount >= 3) {
                        esteticas = new Estetica(nome, telefone, sexo, tipoAtividade, servico1, servico2, servico3);
                        pacientes.add(esteticas);
                        comandoPaciente.inserirEsteticaBD(nome, telefone, sexo, tipoAtividade, servico1, servico2, servico3);
                    } else if (selectedCount >= 2) {
                        esteticas = new Estetica(nome, telefone, sexo, tipoAtividade, servico1, servico2);
                        pacientes.add(esteticas);
                        comandoPaciente.inserirEsteticaBD(nome, telefone, sexo, tipoAtividade, servico1, servico2, servico3);
                    } else if (selectedCount == 1) {
                        esteticas = new Estetica(nome, telefone, sexo, tipoAtividade, servico1);
                        pacientes.add(esteticas);
                        comandoPaciente.inserirEsteticaBD(nome, telefone, sexo, tipoAtividade, servico1, servico2, servico3);
                    }
                    if (selectedCount > 3) {
                        JOptionPane.showMessageDialog(null, "Selecione " + "no máximo 3 serviços.", "Aviso:", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha " + "todos os dados.", "Aviso:", JOptionPane.WARNING_MESSAGE);
                }
                checkBoxesSelecionadas.clear();
                servico1 = "Serviço não selecionado";
                servico2 = "Serviço não selecionado";
                servico3 = "Serviço não selecionado";
            }
        });
    }
}

