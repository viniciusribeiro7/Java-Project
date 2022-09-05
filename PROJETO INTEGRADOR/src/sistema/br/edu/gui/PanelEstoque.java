package sistema.br.edu.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sistema.br.edu.classes.Estoque;
import sistema.br.edu.dao.EstoqueDao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelEstoque extends JPanel {
	private JTextField txfProduto;
	private JTable table;
	private JTextField txfFornecedor;
	private JTextField txfTipo;
	private JTextField txfQuantidade;
	private List<Estoque> estoqueLista;
	private DefaultTableModel modeloTabela;
	private Estoque estoque;
	private EstoqueDao estoqueDao;
	private JTextField txfId;
	private JTextField txfPreco;
	

	/**
	 * Create the panel.
	 */
	public PanelEstoque() {

		setBounds(0, 0, 557, 411);
		setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Produto");
		lblNewLabel_1.setBounds(23, 14, 46, 14);
		add(lblNewLabel_1);

		txfProduto = new JTextField();
		txfProduto.setBounds(79, 11, 148, 20);
		add(txfProduto);
		txfProduto.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 521, 253);
		add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				Integer ItemSelecionado = table.getSelectionModel().getLeadSelectionIndex();
				estoque = estoqueLista.get(ItemSelecionado);
				txfId.setText(estoque.getId_estoque().toString());
				txfProduto.setText(estoque.getIngrediente().toString());
				txfFornecedor.setText(estoque.getFornecedor().toString());
				txfTipo.setText(estoque.getTipo().toString());
				txfQuantidade.setText(estoque.getQuantidade().toString());
				txfPreco.setText(estoque.getPreco().toString());
				
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1_2 = new JLabel("Fornecedor");
		lblNewLabel_1_2.setBounds(237, 11, 69, 14);
		add(lblNewLabel_1_2);

		txfFornecedor = new JTextField();
		txfFornecedor.setColumns(10);
		txfFornecedor.setBounds(316, 11, 199, 20);
		add(txfFornecedor);

		JLabel lblNewLabel_1_1 = new JLabel("Tipo");
		lblNewLabel_1_1.setBounds(23, 62, 46, 14);
		add(lblNewLabel_1_1);

		txfTipo = new JTextField();
		txfTipo.setColumns(10);
		txfTipo.setBounds(79, 59, 101, 20);
		add(txfTipo);

		JLabel lblNewLabel_1_3 = new JLabel("Quantidade");
		lblNewLabel_1_3.setBounds(203, 59, 69, 14);
		add(lblNewLabel_1_3);

		txfQuantidade = new JTextField();
		txfQuantidade.setColumns(10);
		txfQuantidade.setBounds(282, 56, 74, 20);
		add(txfQuantidade);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					estoque = new Estoque();
					estoque.setIngrediente(txfProduto.getText());
					estoque.setFornecedor(txfFornecedor.getText());
					estoque.setTipo(txfTipo.getText());
					estoque.setQuantidade(Integer.parseInt(txfQuantidade.getText()));
					estoque.setPreco(Double.parseDouble(txfPreco.getText()));
					estoqueDao.incluirEstoque(estoque);
					limparCampos();
					popularTabela();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro!"+ ex);
				}

				

			}
		});
		btnIncluir.setBounds(32, 99, 89, 23);
		add(btnIncluir);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer confirma = JOptionPane.showConfirmDialog(null, "Deseja alterar?");
					if (confirma == 0) {
						estoque = new Estoque();
						estoqueDao = new EstoqueDao();
						estoque.setId_estoque(Integer.parseInt(txfId.getText()));
						estoque.setIngrediente(txfProduto.getText());
						estoque.setFornecedor(txfFornecedor.getText());
						estoque.setTipo(txfTipo.getText());
						estoque.setQuantidade(Integer.parseInt(txfQuantidade.getText()));
						estoque.setPreco(Double.parseDouble(txfPreco.getText()));
						estoqueDao.alterarEstoque(estoque);
						limparCampos();
						popularTabela();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro!"+ex);
				}
			}
		});
		btnAlterar.setBounds(208, 99, 89, 23);
		add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ConfirmarExcluir = 	JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir?");
					if (ConfirmarExcluir == 0) { 
					estoque = new Estoque();
					estoqueDao = new EstoqueDao();
					estoque.setId_estoque(Integer.parseInt(txfId.getText()));
					estoque.setIngrediente(txfProduto.getText());
					estoque.setFornecedor(txfFornecedor.getText());
					estoque.setQuantidade(Integer.parseInt(txfQuantidade.getText()));
					estoque.setTipo(txfTipo.getText());
					estoque.setPreco(Double.parseDouble(txfPreco.getText()));
					estoqueDao.excluirEstoque(estoque);
					limparCampos();
					popularTabela();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro" + ex);
				}

			}
		});
		btnExcluir.setBounds(375, 99, 89, 23);
		add(btnExcluir);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(400, 45, 46, 14);
		add(lblNewLabel);
		
		txfId = new JTextField();
		txfId.setEditable(false);
		txfId.setBounds(425, 42, 39, 20);
		add(txfId);
		txfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Preço");
		lblNewLabel_2.setBounds(365, 74, 46, 14);
		add(lblNewLabel_2);
		
		txfPreco = new JTextField();
		txfPreco.setBounds(400, 68, 73, 20);
		add(txfPreco);
		txfPreco.setColumns(10);
		setVisible(true);
		popularTabela();
	}

	public void limparCampos() {
		 txfProduto.setText(null);
		 txfFornecedor.setText(null);
		 txfTipo.setText(null);
		 txfQuantidade.setText(null);
		
	}
	
	public void popularTabela() {

		try {
			estoqueDao = new EstoqueDao();
			estoqueLista = estoqueDao.consultarEstoque();
			modeloTabela = new DefaultTableModel();
			modeloTabela.addColumn("Ingrediente");
			modeloTabela.addColumn("Tipo");
			modeloTabela.addColumn("Fornecedor");
			modeloTabela.addColumn("Quantidade");
			modeloTabela.addColumn("Preço");

			for (Estoque estoque : estoqueLista) {
				modeloTabela.addRow(new String[] {
						estoque.getIngrediente(), estoque.getTipo(),
						estoque.getFornecedor(), estoque.getQuantidade().toString(), estoque.getPreco().toString()});
			}
			table.setModel(modeloTabela);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO!" + e);
		}

	}
}