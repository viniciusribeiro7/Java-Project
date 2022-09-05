package sistema.br.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;

//import sistema.br.edu.classes.Atendente;
//import sistema.br.edu.classes.Funcionario;
import sistema.br.edu.classes.Usuario;
import sistema.br.edu.util.Conexao;

public class AtendenteDao {

	private Connection con;
	private PreparedStatement ps;
	//private ResultSet rs;

	public AtendenteDao() throws Exception {
		con = Conexao.conectar();
	}

	public void incluirAtendente(Usuario usuario) throws Exception {
		if (usuario == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "insert into atendente (login, senha) values (?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			ps.close();
		}
	}

}