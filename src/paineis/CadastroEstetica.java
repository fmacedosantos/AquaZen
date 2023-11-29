package paineis;

import classes.Emagrecimento;
import classes.Estetica;
import classes.Paciente;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.Set;

public class CadastroEstetica extends JPanel {

    private Set<Paciente> pacientes;
    JLabel nomeLabel, telefoneLabel, sexoLabel, tipoAtividadeLabel;
    private JTextField nomeField, tipoAtividadeField;
    private JFormattedTextField telefoneField;
    ButtonGroup sexoGroup;
    private JRadioButton masculinoButton, femininoButton;
    private JButton cadastrarButton;

    public CadastroEstetica(Set<Paciente> pacientes) {
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
        nomeLabel = new JLabel("Nome:");
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
        tipoAtividadeField = new JTextField();

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
        int y = 50;
        nomeLabel.setBounds(50, y, 100, 20);
        nomeField.setBounds(150, y, 100, 20);
        y += 30;
        telefoneLabel.setBounds(50, y, 100, 20);
        telefoneField.setBounds(150, y, 100, 20);
        y += 30;
        sexoLabel.setBounds(50, y, 100, 20);
        masculinoButton.setBounds(150, y, 100, 20);
        femininoButton.setBounds(250, y, 100, 20);
        y += 30;
        tipoAtividadeLabel.setBounds(50, y, 100, 20);
        tipoAtividadeField.setBounds(150, y, 100, 20);
        y += 30;
        cadastrarButton.setBounds(50, y, 100, 20);

        // Adiciona os rótulos e campos de entrada ao painel
        add(nomeLabel);
        add(nomeField);
        add(telefoneLabel);
        add(telefoneField);
        add(sexoLabel);
        add(masculinoButton);
        add(femininoButton);
        add(tipoAtividadeLabel);
        add(tipoAtividadeField);

        // Adiciona o botão ao painel
        add(cadastrarButton);
    }


    private void criarEventos() {
        // Aqui você pode adicionar os listeners para os eventos
    }
}

