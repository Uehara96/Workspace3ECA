package dao;
/*Essa classe será usada para manipularmos nossa conexã/operacao com o banco de dados!
 * Nela faremos a conexão
 * O envio de instruções que modificam os dados de uma tabela
 * O envio de instruções que retornam dados de uma tabela
 * */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String servidor;
	private String porta;
	private String usuario;
	private String senha;
	
	private Connection conexao;
	
	public Conexao() {
		servidor = "oracle.fiap.com.br";
		porta = "1521";
		usuario = "PF0737";
		senha = "C68C94";
	}
	
	
	public void abrirConexao() {
		/*Vou criar meus parametros de conexao para
		 * depois tentar abrir a conexao em si.*/
		
		//String de conexao
		String url="jdbc:oracle:thin:@"+servidor+":"+porta+":orcl";
		
		
		/*Como uma atividade que envolve manipular o banco pode retornar uma excecao,
		 * vamos usar o bloco try, que tenta executar algo.
		 * Caso a execucao de erro, o programa nao trava. O bloco catch e executado.*/
		try{
			/*Essa linha abaixo registra o driver que faz a 
			 * comunicacao com o banco Oracle. 
			 * Mas ela so funciona se add o arquivo do driver(ojdbc6.jar) 
			 * ao Build Path do projeto.*/
		
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			/*A linha abaixo que efetivamente realiza a conexao com o banco.
			 * Se ela for sucedida, a conexao e aberta.*/
			conexao = DriverManager.getConnection(url, usuario, senha);
		}catch(SQLException erro) {
			erro.printStackTrace();
		}
		
	}
	
	//Getters E Setters
	public String getServidor() {
		return servidor;
	}
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
       
}
