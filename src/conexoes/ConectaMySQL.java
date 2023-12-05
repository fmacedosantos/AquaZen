
package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class ConectaMySQL {

        private final String DRIVER = "com.mysql.cj.jdbc.Driver";
        private final String DBNAME = "aquazen";
        private final String URL = "jdbc:mysql://ESN509VMYSQL:3306/" + DBNAME; //localhost
        private final String LOGIN = "aluno"; // root
        private final String SENHA = "Senai1234"; // root

        /* Objeto da classe Connection que será usado para configurar o IP do banco, usuario e senha //Import java.sql.Connection;*/

        private Connection conexao; //Atalho import: alt enter

        //Metodos

        //O método irá configurar o objeto de conexão
        // O método irá retornar o próprio objeto conexão, ou seja, ao final de
        //tudo será retornado o estado da conexão, isto e, conexao aberta ou não
        public Connection iniciarConexao(){

            //Configuraçao do Driver de banco de dados
            try {
                Class.forName(DRIVER);

                //Configuração do caminho (IP), usuário, senha e banco de dados
                //O método getConnection() tenta iniciar a conexão com os valores
                //passados como parâmetro
                conexao = DriverManager.getConnection(URL,LOGIN,SENHA);
                System.out.println("Conectado!");

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return conexao;
        }

        //Fecha o banco de dado
        public  void close(){
            try {
                conexao.close();
                System.out.println("Desconectou!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
}


