package sistema.br.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sistema.br.edu.classes.Cliente;
import sistema.br.edu.util.Conexao;

public class ClienteDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public ClienteDao() throws Exception {
		con = Conexao.conectar();
	}

	public List<Cliente> consultarCliente(String telefone) throws Exception {
		try {
			String sql = "select * from cliente where telefone like = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + telefone + "%");
			rs = ps.executeQuery();
			List<Cliente> lista = new ArrayList<Cliente>();
			while (rs.next()) {
				Integer id_cliente = rs.getInt("id_cliente");
				String nome = rs.getString("nome");
				String telefone1 = rs.getString("telefone");
				String endereco = rs.getString("endereco");
				lista.add(new Cliente(id_cliente, nome, telefone1, endereco));
			}
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			rs.close();
			ps.close();
		}
	}

	public List<Cliente> consultarTodosCliente() throws Exception {
		try {
			String sql = "select * from cliente";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Cliente> lista = new ArrayList<Cliente>();
			while (rs.next()) {
				Integer id_cliente = rs.getInt("id_cliente");
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");
				String endereco = rs.getString("endereco");
				lista.add(new Cliente(id_cliente, nome, telefone, endereco));
			}
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			rs.close();
			ps.close();
		}
	}

	public void incluirCliente(Cliente cliente) throws Exception {
		if (cliente == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "insert into cliente (nome, endereco, telefone) values (?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco());
			ps.setString(3, cliente.getTelefone());
	
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao incluir" + e);
		} finally {
			ps.close();
		}
	}

	public void excluirCliente(Cliente cliente) throws Exception {
		if (cliente == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "delete from cliente where id_cliente = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, cliente.getId_cliente());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao excluir" + e);
		} finally {
			ps.close();
		}
	}

	public void alterarCliente(Cliente cliente) throws Exception {
		if (cliente == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "update cliente set nome = ?, telefone = ?, endereco = ? where id_cliente = ?";

			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getTelefone());
			ps.setString(3, cliente.getEndereco());
			ps.setInt(4, cliente.getId_cliente());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro ao alterar" + e);
		} finally {
			ps.close();
		}
	}

}