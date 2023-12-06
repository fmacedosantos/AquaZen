package comandos;

import conexoes.ConectaMySQL;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComandoPaciente {
    Connection conexao;
    ConectaMySQL conecta;

    public boolean inserirEmagrecimentoBD(String nome, String telefone, String sexo, String tipoAtividade,
                                          Double peso, Double altura, Double pesoIdeal) {

        //conexao de banco de dados
        conecta = new ConectaMySQL();
        conexao = conecta.iniciarConexao();
        String comando;
        PreparedStatement ps = null;
        //Criaçao do comando a ser executado no banco de dados
        comando = "INSERT INTO paciente VALUES(null, ?, ?, ?, ?, ?, null, null, null, ?, ?, ?);";

        //Preparar a conexao com o comando que sera executado nela
        try {
            ps = conexao.prepareStatement(comando);
            //Passagem de valores para cada ? do comando INSERT
            String objetivo = "Emagrecimento";
            ps.setString(1, objetivo);
            ps.setString(2, nome);
            ps.setString(3, telefone);
            ps.setString(4, sexo);
            ps.setString(5, tipoAtividade);
            ps.setDouble(6, peso);
            ps.setDouble(7, altura);
            ps.setDouble(8, pesoIdeal);

            if (ps.executeUpdate() != 0) {
                //Se alterou pelo menos 1 linha, entao INSERT deu certo
                conecta.close();//Fecha a conexao e libera o recurso
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean inserirEsteticaBD(String nome, String telefone, String sexo, String tipoAtividade,
                                     String servico1, String servico2, String servico3) {
        //conexao de banco de dados
        conecta = new ConectaMySQL();
        conexao = conecta.iniciarConexao();

        String comando = "INSERT INTO paciente VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, null, null, null);";

        try {
            PreparedStatement ps = null;
            ps = conexao.prepareStatement(comando);
            String objetivo = "Estética";
            ps.setString(1, objetivo);
            ps.setString(2, nome);
            ps.setString(3, telefone);
            ps.setString(4, sexo);
            ps.setString(5, tipoAtividade);
            ps.setString(6, servico1);
            ps.setString(7, servico2);
            ps.setString(8, servico3);

            if (ps.executeUpdate() != 0) {
                conecta.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    public List<String> exibirPaciente(String comando) {
        // lista para guardar os resultados
        List<String> resultados = new ArrayList<>();

        //conexao de banco de dados
        conecta = new ConectaMySQL();
        conexao = conecta.iniciarConexao();


        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ResultSet resultado = ps.executeQuery();
            // caso o comando tenha "Emagrecimento", exibe os pacientes de Emagrecimento
            if (comando.contains("Emagrecimento")) {
                while (resultado.next()) {
                    String linha = "Código: " + resultado.getInt(1) + "\nObjetivo: " + resultado.getString(2) +
                            "\nNome: " + resultado.getString(3) + "\nTelefone: " + resultado.getString(4) +
                            "\nSexo: " + resultado.getString(5) + "\nTipo de Atividade: " + resultado.getString(6) +
                            "\nPeso: " + resultado.getDouble(10) + "\nAltura: " + resultado.getDouble(11) +
                            "\nPeso Ideal (%): " + resultado.getDouble(12) + "\n";
                    resultados.add(linha);
                }
            } else { // caso não, os de Estética
                while (resultado.next()) {
                    String linha = "Código: " + resultado.getInt(1) + "\nObjetivo: " + resultado.getString(2) +
                            "\nNome: " + resultado.getString(3) + "\nTelefone: " + resultado.getString(4) +
                            "\nSexo: " + resultado.getString(5) + "\nTipo de Atividade: " + resultado.getString(6) +
                            "\nServiço 1: " + resultado.getString(7) + "\nServiço 2: " + resultado.getString(8) +
                            "\nServiço 3: " + resultado.getString(9) + "\n";
                    resultados.add(linha);
                }
            }

            conecta.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultados;
    }

    public boolean pesquisarPaciente(int codigo, JTextArea jTextArea) {
        boolean codigoExiste = false;
        //conexao de banco de dados
        conecta = new ConectaMySQL();
        conexao = conecta.iniciarConexao();

        String comando = "SELECT * FROM paciente WHERE codigo = " + codigo;
        String cabecalho = null;
        String linha = null;
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ResultSet resultado = ps.executeQuery();

            if (resultado.next()) {
                String valor = resultado.getString("objetivo");
                if (valor.equals("Emagrecimento")) {
                    linha = "Código: " + resultado.getInt(1) + "\nObjetivo: " + resultado.getString(2) +
                            "\nNome: " + resultado.getString(3) + "\nTelefone: " + resultado.getString(4) +
                            "\nSexo: " + resultado.getString(5) + "\nTipo de Atividade: " + resultado.getString(6) +
                            "\nPeso: " + resultado.getDouble(10) + "\nAltura: " + resultado.getDouble(11) +
                            "\nPeso Ideal (%): " + resultado.getDouble(12) + "\n";
                } else {
                    linha = "Código: " + resultado.getInt(1) + "\nObjetivo: " + resultado.getString(2) +
                            "\nNome: " + resultado.getString(3) + "\nTelefone: " + resultado.getString(4) +
                            "\nSexo: " + resultado.getString(5) + "\nTipo de Atividade: " + resultado.getString(6) +
                            "\nServiço 1: " + resultado.getString(7) + "\nServiço 2: " + resultado.getString(8) +
                            "\nServiço 3: " + resultado.getString(9) + "\n";
                }
            }

            conecta.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jTextArea.setText(cabecalho);
        jTextArea.append(linha);
        if (!jTextArea.getText().isEmpty()){
            codigoExiste = true;
        }
        return codigoExiste;
    }

    public void alterarAtividadePaciente(int codigo) {
        //conexao de banco de dados
        conecta = new ConectaMySQL();
        conexao = conecta.iniciarConexao();

        try (Statement stmt = conexao.createStatement()) {
            // Define um array de opções personalizadas para a caixa de diálogo
            Object[] opcoes = {"Caminhada", "Natação", "Treino"};

            // Exibe uma caixa de diálogo de opções com opções personalizadas
            String escolha = (String) JOptionPane.showInputDialog(null, "Escolha o " +
                            "novo tipo de atividade:", "Alterando o paciente " + codigo, JOptionPane.INFORMATION_MESSAGE, null,
                    opcoes, opcoes[0]);
            String novoTipoAtividade = null;
            switch (escolha) {
                case "Caminhada":
                    novoTipoAtividade = "Caminhada";
                    break;
                case "Natação":
                    novoTipoAtividade = "Natação";
                    break;
                case "Treino":
                    novoTipoAtividade = "Treino";
                    break;
            }
            String comandoNovaAtividade = "UPDATE paciente SET tipoAtividade = '" + novoTipoAtividade +
                    "' WHERE codigo = " + codigo;
            int linhasAfetadas = stmt.executeUpdate(comandoNovaAtividade);

            conecta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarPaciente(int codigo) {
        //conexao de banco de dados
        conecta = new ConectaMySQL();
        conexao = conecta.iniciarConexao();

        String comando = "DELETE FROM paciente WHERE codigo = ?";
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement(comando);
            ps.setInt(1, codigo);
            int linhasAfetadas = ps.executeUpdate();

            System.out.println(linhasAfetadas + " linha(s) deletada(s)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

