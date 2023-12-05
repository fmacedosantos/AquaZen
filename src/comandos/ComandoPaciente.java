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
                    String linha = resultado.getInt(1) + "\t" + resultado.getString(2) +
                            "\t" + resultado.getString(3) + "\t" + resultado.getString(4) +
                            "\t" + resultado.getString(5) + "\t" + resultado.getString(6) +
                            "\t\t" + resultado.getDouble(10) + "\t" + resultado.getDouble(11) +
                            "\t" + resultado.getDouble(12);
                    resultados.add(linha);
                }
            } else { // caso não, os de Estética
                while (resultado.next()) {
                    String linha = resultado.getInt(1) + "\t" + resultado.getString(2) +
                            "\t" + resultado.getString(3) + "\t" + resultado.getString(4) +
                            "\t" + resultado.getString(5) + "\t" + resultado.getString(6) +
                            "\t\t" + resultado.getString(7) + "\t" + resultado.getString(8) +
                            "\t" + resultado.getString(9);
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
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                String valor = result.getString("objetivo");
                if (valor.equals("Emagrecimento")) {
                    cabecalho = "Código\tObjetivo\t\tNome\tTelefone\t\tSexo\tTipo de Atividade\tPeso\tAltura\tPeso Ideal (%)\n";
                    linha = result.getInt(1) + "\t" + result.getString(2) +
                            "\t" + result.getString(3) + "\t" + result.getString(4) +
                            "\t" + result.getString(5) + "\t" + result.getString(6) +
                            "\t\t" + result.getDouble(10) + "\t" + result.getDouble(11) +
                            "\t" + result.getDouble(12);
                } else {
                    cabecalho = "Código\tObjetivo\tNome\tTelefone\t\tSexo\tTipo de Atividade\tSeriço 1\t\tServiço 2\t\tSeriço 3\n";
                    linha = result.getInt(1) + "\t" + result.getString(2) +
                            "\t" + result.getString(3) + "\t" + result.getString(4) +
                            "\t" + result.getString(5) + "\t" + result.getString(6) +
                            "\t\t" + result.getString(7) + "\t" + result.getString(8) +
                            "\t" + result.getString(9);
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

