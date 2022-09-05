package sistema.br.edu.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import sistema.br.edu.classes.Cliente;
import sistema.br.edu.classes.Funcionario;
import sistema.br.edu.dao.ClienteDao;
import sistema.br.edu.dao.FuncionarioDao;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelCadastroCliente extends JPanel {
	private JTextField txfNome;
	private JTextField txfEndereco;
	private JTextField txfTelefone;
	//private JTable table;
	private JTable JtableCliente;
	private JButton btnIncluir;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private Cliente cliente;
	private ClienteDao clienteDao;
	private List<Cliente> lista;
	private DefaultTableModel modeloTabela;
	private JButton btnNewButton;
	private JButton btnAlterar1;
	private JTextField txfId;

	/**
	 * Create the panel.
	 */
	public PanelCadastroCliente() {

		setBounds(0, 0, 594, 382);
		setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setBounds(21, 24, 54, 14);
		add(lblNome);

		txfNome = new JTextField();
		txfNome.setBounds(85, 23, 381, 20);
		add(txfNome);
		txfNome.setColumns(10);

		txfEndereco = new JTextField();
		txfEndereco.setColumns(10);
		txfEndereco.setBounds(92, 94, 434, 20);
		add(txfEndereco);

		txfTelefone = new JTextField();
		txfTelefone.setColumns(10);
		txfTelefone.setBounds(96, 62, 170, 20);
		add(txfTelefone);

		JScrollPane scrPanelCliente = new JScrollPane();
		scrPanelCliente.addMouseListener(new MouseAdapter() {
		});
		scrPanelCliente.setBounds(21, 161, 505, 205);
		add(scrPanelCliente);

		JtableCliente = new JTable();
		JtableCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Integer ItemSelecionado = JtableCliente.getSelectionModel().getLeadSelectionIndex();
				cliente = lista.get(ItemSelecionado);
				txfId.setText(cliente.getId_cliente().toString());
				txfNome.setText(cliente.getNome());
				txfTelefone.setText(cliente.getTelefone());
				txfEndereco.setText(cliente.getEndereco());
			}
		});
		
			
		
		
		scrPanelCliente.setViewportView(JtableCliente);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelefone.setBounds(21, 63, 71, 14);
		add(lblTelefone);

		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEndereco.setBounds(8, 97, 84, 14);
		add(lblEndereco);

		btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					cliente = new Cliente();
					clienteDao = new ClienteDao();
					cliente.setNome(txfNome.getText());
					cliente.setTelefone(txfTelefone.getText());
					cliente.setEndereco(txfEndereco.getText());
					clienteDao.incluirCliente(cliente);
					limparCampos();
					popularTabela();

				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, "Erro!" + e2);
				}

			}
		});
		btnIncluir.setBounds(85, 127, 89, 23);
		add(btnIncluir);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int ConfirmarExcluir = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir?");
					if (ConfirmarExcluir == 0) {
						cliente = new Cliente();
						clienteDao = new ClienteDao();
						cliente.setId_cliente(Integer.parseInt(txfId.getText()));
						cliente.setNome(txfNome.getText());
						cliente.setTelefone(txfTelefone.getText());
						cliente.setEndereco(txfEndereco.getText());
						clienteDao.excluirCliente(cliente);
						limparCampos();
						popularTabela();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro" + ex);
				}

			}
		});
		btnExcluir.setBounds(417, 127, 89, 23);
		add(btnExcluir);

		btnAlterar1 = new JButton("Alterar");
		btnAlterar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Integer confirma = JOptionPane.showConfirmDialog(null, "Deseja alterar?");
					if (confirma == 0) {
						cliente = new Cliente();
						clienteDao = new ClienteDao();
						cliente.setNome(txfNome.getText());
						cliente.setTelefone(txfTelefone.getText());
						cliente.setEndereco(txfEndereco.getText());
						cliente.setId_cliente(Integer.parseInt(txfId.getText()));
						clienteDao.alterarCliente(cliente);

						limparCampos();
						popularTabela();
					}
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, "Erro!" + e2);
				}
			}

		});
		btnAlterar1.setBounds(239, 125, 89, 23);
		add(btnAlterar1);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(344, 69, 46, 14);
		add(lblNewLabel);
		
		txfId = new JTextField();
		txfId.setEditable(false);
		txfId.setBounds(400, 63, 86, 20);
		add(txfId);
		txfId.setColumns(10);
		
		popularTabela();

	}

	public void limparCampos() {
		txfId.setText(null);
		txfNome.setText(null);
		txfTelefone.setText(null);
		txfEndereco.setText(null);

	}

	public void popularTabela() {

		try {
			clienteDao = new ClienteDao();
			lista = clienteDao.consultarTodosCliente();
			modeloTabela = new DefaultTableModel();
			modeloTabela.addColumn("Id");
			modeloTabela.addColumn("Nome");
			modeloTabela.addColumn("Telefone");
			modeloTabela.addColumn("Endereço");

			for (Cliente cliente : lista) {
				modeloTabela.addRow(new String[] { cliente.getId_cliente().toString(), cliente.getNome(), cliente.getTelefone(), cliente.getEndereco()});
			}
			
			JtableCliente.setModel(modeloTabela);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO!"+e);
		}

	}
}