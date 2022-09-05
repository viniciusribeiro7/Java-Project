package sistema.br.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sistema.br.edu.classes.Sabor;
import sistema.br.edu.util.Conexao;

public class SaborDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public SaborDao() throws Exception {
		con = Conexao.conectar();
	}

	public void incluirSabor(Sabor sabor) throws Exception {
		if (sabor == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "insert into sabor (nome, preco) values (?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, sabor.getNome());
			ps.setDouble(2, sabor.getPreco());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			ps.close();
		}

	}

	public void alterarSabor(Sabor sabor) throws Exception {
		if (sabor == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "update sabor set nome = ?, preco = ? where idsabor = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, sabor.getNome());
			ps.setDouble(2, sabor.getPreco());
			ps.setInt(3, sabor.getIdsabor());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			ps.close();
		}
	}

	public void excluirSabor(Sabor sabor) throws Exception {
		if (sabor == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "delete from sabor where idsabor = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, sabor.getIdsabor());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			ps.close();
		}
	}

	public List<Sabor> consultarSabor() throws Exception {
		try {
			String sql = "select * from sabor";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Sabor> saborLista = new ArrayList<Sabor>();
			while (rs.next()) {
				Integer idsabor = rs.getInt("idsabor");
				String nome = rs.getString("nome");
				Double preco = rs.getDouble("preco");
				saborLista.add(new Sabor(idsabor, nome, preco));
			}
			return saborLista;
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			rs.close();
			ps.close();
		}
	}

}