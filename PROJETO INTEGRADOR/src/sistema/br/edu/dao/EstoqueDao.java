package sistema.br.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sistema.br.edu.classes.Estoque;
import sistema.br.edu.util.Conexao;

public class EstoqueDao {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public EstoqueDao() throws Exception {
		con = Conexao.conectar();
	}

	public List<Estoque> consultarEstoque() throws Exception {
		try {
			String sql = "select * from estoque";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Estoque> lista = new ArrayList<Estoque>();
			while (rs.next()) {
				Integer id_estoque = rs.getInt("id_estoque");
				String ingrediente = rs.getString("ingrediente");
				String tipo = rs.getString("tipo");
				String fornecedor = rs.getString("fornecedor");
				Integer quantidade = rs.getInt("quantidade");
				Double preco = rs.getDouble("preco");
				
				lista.add(new Estoque(id_estoque, ingrediente, tipo, fornecedor, quantidade,preco));

			}
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			rs.close();
			ps.close();
		}
	}

	public void incluirEstoque(Estoque estoque) throws Exception {
		if (estoque == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "insert into estoque (ingrediente, tipo, fornecedor,quantidade, preco) values (?,?,?,?, ?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, estoque.getIngrediente());
			ps.setString(2, estoque.getTipo());
			ps.setString(3, estoque.getFornecedor());
			ps.setInt(4, estoque.getQuantidade());
			ps.setDouble(5, estoque.getPreco());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			ps.close();
		}
	}

	public void excluirEstoque(Estoque estoque) throws Exception {
		if (estoque == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "delete from estoque where id_estoque = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, estoque.getId_estoque());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			ps.close();
		}
	}

	public void alterarEstoque(Estoque estoque) throws Exception {
		if (estoque == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "update estoque set ingrediente = ?, tipo = ?, fornecedor = ?, quantidade = ? , preco = ? where id_estoque = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, estoque.getIngrediente());
			ps.setString(2, estoque.getTipo());
			ps.setString(3, estoque.getFornecedor());
			ps.setInt(4, estoque.getQuantidade());
			ps.setDouble(5, estoque.getPreco());
			ps.setInt(6, estoque.getId_estoque());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			ps.close();
		}

	}
	public List<Estoque> consultarBebida() throws Exception {
		try {
			String sql = " select * from estoque where tipo = 'Bebida' ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Estoque> lista = new ArrayList<Estoque>();
			while (rs.next()) {
				Integer id_estoque = rs.getInt("id_estoque");
				String ingrediente = rs.getString("ingrediente");
				String tipo = rs.getString("tipo");
				String fornecedor = rs.getString("fornecedor");
				Integer quantidade = rs.getInt("quantidade");
				Double preco = rs.getDouble("preco");
				
				lista.add(new Estoque(id_estoque, ingrediente, tipo, fornecedor, quantidade, preco));

			}
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			rs.close();
			ps.close();
		}
	}
	public List<Estoque> consultarIngrediente() throws Exception {
		try {
			String sql = " select * from estoque where tipo = 'Ingrediente' ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Estoque> lista = new ArrayList<Estoque>();
			while (rs.next()) {
				Integer id_estoque = rs.getInt("id_estoque");
				String ingrediente = rs.getString("ingrediente");
				String tipo = rs.getString("tipo");
				String fornecedor = rs.getString("fornecedor");
				Integer quantidade = rs.getInt("quantidade");
				Double preco = rs.getDouble("preco");
				
				lista.add(new Estoque(id_estoque, ingrediente, tipo, fornecedor, quantidade, preco));

			}
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			rs.close();
			ps.close();
		}
	}
}