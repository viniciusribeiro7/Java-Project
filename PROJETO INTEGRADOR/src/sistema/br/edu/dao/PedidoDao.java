package sistema.br.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sistema.br.edu.classes.Pedido;
import sistema.br.edu.util.Conexao;

public class PedidoDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public PedidoDao() throws Exception {
		con = Conexao.conectar();
	}

	public void realizarPedidoPadrao(Pedido pedido) throws Exception {
		if (pedido == null) {
			throw new Exception("Objeto vazio");
		}
		try {
			String sql = "select * from pedido where massa = ?, sabor = ?, tamanho = ?, borda = ?, bebidas=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, pedido.getMassa());
			ps.setString(2, pedido.getSabor());
			ps.setString(3, pedido.getTamanho());
			ps.setString(4, pedido.getBorda());
			ps.setString(5, pedido.getBebidas());
			rs = ps.executeQuery();
		} catch (Exception e) {
			throw new Exception("Erro" + e);
		} finally {
			ps.close();
			rs.close();
		}
	}
}