package sistema.br.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sistema.br.edu.classes.Funcionario;
import sistema.br.edu.util.Conexao;

public class FuncionarioDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public FuncionarioDao() throws Exception {
		con = Conexao.conectar();
	}

	public List<Funcionario> consultarFuncionario(String nome) throws Exception {
		try {
			String sql = "select * from funcionario where nome like = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + nome + "%");
			rs = ps.executeQuery();
			List<Funcionario> lista = new ArrayList<Funcionario>();
			while (rs.next()) {
				Integer idfuncionario = rs.getInt("idfuncionario");
				String nome2 = rs.getString("nome");
				String funcao = rs.getString("funcao");
				String telefone = rs.getString("telefone");
				String endereco = rs.getString("endereco");
				lista.add(new Funcionario(idfuncionario, nome2, funcao, telefone, endereco));
			}
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			rs.close();
			ps.close();
		}
	}

	public List<Funcionario> consultarTodosFuncionarios() throws Exception {
		try {
			String sql = "select * from funcionario";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Funcionario> lista = new ArrayList<Funcionario>();
			while (rs.next()) {
				Integer idfuncionario = rs.getInt("idfuncionario");
				String nome = rs.getString("nome");
				String funcao = rs.getString("funcao");
				String telefone = rs.getString("telefone");
				String endereco = rs.getString("endereco");
				lista.add(new Funcionario(idfuncionario, nome, funcao, telefone, endereco));
			}
			return lista;
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			rs.close();
			ps.close();
		}
	}

	public void incluirFuncionario(Funcionario funcionario) throws Exception {
		if (funcionario == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "insert into funcionario (nome, funcao, telefone, endereco) values (?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getFuncao());
			ps.setString(3, funcionario.getTelefone());
			ps.setString(4, funcionario.getEndereco());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			ps.close();
		}
	}

	public void excluirFuncionario(Funcionario funcionario) throws Exception {
		if (funcionario == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "delete from funcionario where idfuncionario = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, funcionario.getIdfuncionario());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			ps.close();
		}
	}

	public void alterarFuncionario(Funcionario funcionario) throws Exception {
		if (funcionario == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "update funcionario set nome = ?, funcao = ?, telefone = ?, endereco = ? where idfuncionario = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getFuncao());
			ps.setString(3, funcionario.getTelefone());
			ps.setString(4, funcionario.getEndereco());
			ps.setInt(5, funcionario.getIdfuncionario());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			ps.close();
		}
	}

}