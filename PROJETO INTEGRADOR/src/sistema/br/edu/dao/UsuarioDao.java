package sistema.br.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sistema.br.edu.classes.Usuario;
import sistema.br.edu.util.Conexao;

public class UsuarioDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public UsuarioDao() throws Exception {
		con = Conexao.conectar();
	}

	public Boolean validarUsuario(String login, String senha) throws Exception {
		if (login == null || senha == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "select * from usuario where login=? and senha = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			if (rs.next()) {
				Usuario usuario = Usuario.getInstance();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNome(rs.getString("nome"));
				usuario.setTipo(rs.getString("tipo"));

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			ps.close();
			rs.close();
		}
	}
}