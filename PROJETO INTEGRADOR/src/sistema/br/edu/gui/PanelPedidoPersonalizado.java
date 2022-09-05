package sistema.br.edu.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sistema.br.edu.classes.Estoque;
import sistema.br.edu.classes.Sabor;
import sistema.br.edu.dao.EstoqueDao;
import sistema.br.edu.dao.SaborDao;

public class PanelPedidoPersonalizado extends JPanel {

	private JTable JtableIngredientes;
	private JTable JtableBebidas;
	private JTable tableFinalizar;

	private DefaultTableModel modeloTabela;
	private EstoqueDao estoqueDao;
	private Estoque estoque;
	private List<Estoque> estoqueLista;
	private Double soma = 0.0;
	

	public PanelPedidoPersonalizado() {
		setLayout(null);

		JScrollPane scrIngredientes = new JScrollPane();
		scrIngredientes.setBounds(71, 20, 182, 156);
		add(scrIngredientes);

		JtableIngredientes = new JTable();
		scrIngredientes.setViewportView(JtableIngredientes);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(81, 359, 89, 23);
		add(btnAdicionar);
		btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				Adicionar(evt);
			}
		});

		JtableIngredientes.setModel(new javax.swing.table.DefaultTableModel(

				new Object[][] {

				}, new String[] { "Ingredientes" }));

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(221, 359, 89, 23);
		add(btnExcluir);

		JButton btnFinalizarPedido = new JButton("Finalizar");
		btnFinalizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, soma);
				try {
					File file = new File(
							"C:\\Users\\vinic\\OneDrive\\Área de Trabalho\\vendas\\relatorioVendasPersonalizada.txt");
					if (!file.exists()) {
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);

					for (int i = 0; i < tableFinalizar.getRowCount(); i++) {
						for (int j = 0; j < tableFinalizar.getColumnCount(); j++) {
							bw.write(tableFinalizar.getModel().getValueAt(i, j).toString() + "/");
						}

						bw.newLine();
					}

					bw.close();
					fw.close();

					JOptionPane.showMessageDialog(null, "Comprovante de venda gerado com sucesso");
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Erro" + ex);
				}
			}
		});
		
		btnFinalizarPedido.setBounds(363, 359, 107, 23);
		add(btnFinalizarPedido);

		JScrollPane scrlBebidasSelecionadas = new JScrollPane();
		scrlBebidasSelecionadas.setBounds(268, 187, 191, 156);
		add(scrlBebidasSelecionadas);
		btnExcluir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Excluir(evt);
			}
		});

		JScrollPane scrlBebidas = new JScrollPane();
		scrlBebidas.setBounds(71, 187, 187, 156);
		add(scrlBebidas);

		JtableBebidas = new JTable();
		JtableBebidas.setModel(new javax.swing.table.DefaultTableModel(

				new Object[][] {

				}, new String[] { "Bebidas","preços" }));

		scrlBebidas.setViewportView(JtableBebidas);

		tableFinalizar = new JTable();

		tableFinalizar.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Pedido", "Preço" }));
		scrlBebidasSelecionadas.setViewportView(tableFinalizar);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "", "Dinheiro", "Débito", "Crédito", "Pix" }));
		comboBox_1.setBounds(363, 114, 85, 22);
		add(comboBox_1);

		JLabel lblNewLabel_1 = new JLabel("Pagamento");
		lblNewLabel_1.setBounds(373, 82, 120, 14);
		add(lblNewLabel_1);

		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] { "", "B", "P", "M", "G", "F" }));
		comboBox_1_1.setBounds(364, 40, 84, 22);
		add(comboBox_1_1);

		JLabel lblNewLabel_2 = new JLabel("Massa");
		lblNewLabel_2.setBounds(282, 82, 46, 14);
		add(lblNewLabel_2);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "", "Fina", "Normal", "Integral", "Pan" }));
		comboBox_2.setBounds(263, 114, 89, 22);
		add(comboBox_2);

		JLabel lblNewLabel_1_1 = new JLabel("Tamanho");
		lblNewLabel_1_1.setBounds(373, 21, 75, 14);
		add(lblNewLabel_1_1);

		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1
				.setModel(new DefaultComboBoxModel(new String[] { "", "Catupiry", "Cheddar", "Queijo", "Alho poró" }));
		comboBox_2_1.setBounds(261, 40, 89, 22);
		add(comboBox_2_1);

		JLabel lblNewLabel_2_1 = new JLabel("Borda");
		lblNewLabel_2_1.setBounds(282, 21, 46, 14);
		add(lblNewLabel_2_1);
		popularTabela();
		popularTabelaBebida();
		;
	}

	private void Adicionar(java.awt.event.ActionEvent evt) {

		TableModel modelIngredientes = JtableIngredientes.getModel();

		int[] indexs = JtableIngredientes.getSelectedRows();

		TableModel modelBebidas = JtableBebidas.getModel();

		int[] ind = JtableBebidas.getSelectedRows();

		Object[] row = new Object[2];
		Object[] row2 = new Object[2];

		DefaultTableModel model2 = (DefaultTableModel) tableFinalizar.getModel();
		for (int i = 0; i < indexs.length; i++) {
			row[0] = modelIngredientes.getValueAt(indexs[i], 0);
			row[1] = modelIngredientes.getValueAt(indexs[i], 1);
			soma = soma + 15.0;
			Double.parseDouble(modelIngredientes.getValueAt(indexs[i], 1).toString());
			model2.addRow(row);

		}
		DefaultTableModel model3 = (DefaultTableModel) tableFinalizar.getModel();
		for (int j = 0; j < ind.length; j++) {
			row2[0] = modelBebidas.getValueAt(ind[j], 0);
			row2[1] = modelBebidas.getValueAt(ind[j], 1);
			soma = soma + Double.parseDouble(modelBebidas.getValueAt(ind[j], 1).toString());
			model3.addRow(row2);
		}
		popularTabela();
		popularTabelaBebida();
	}

	private void Excluir(java.awt.event.ActionEvent evt) {

		DefaultTableModel model2 = (DefaultTableModel) tableFinalizar.getModel();

		try {
			int SelectedRowIndex = tableFinalizar.getSelectedRow();
			model2.removeRow(SelectedRowIndex);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}

	public void popularTabela() {
		try {
			estoqueDao = new EstoqueDao();
			estoqueLista = estoqueDao.consultarIngrediente();
			modeloTabela = new DefaultTableModel();
			modeloTabela.addColumn("Ingrediente");
			modeloTabela.addColumn("Preço");
			for (Estoque estoque : estoqueLista) {
				modeloTabela.addRow(new String[] { estoque.getIngrediente(), estoque.getPreco().toString() });
			}
			JtableIngredientes.setModel(modeloTabela);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO!" + e);
		}
	}

	public void popularTabelaBebida() {
		try {
			estoqueDao = new EstoqueDao();
			estoqueLista = estoqueDao.consultarBebida();
			modeloTabela = new DefaultTableModel();
			modeloTabela.addColumn("Nome");
			modeloTabela.addColumn("Preço");

			for (Estoque estoque : estoqueLista) {
				modeloTabela.addRow(new String[] { estoque.getIngrediente(), estoque.getPreco().toString() });
			}
			JtableBebidas.setModel(modeloTabela);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO!" + e);
			;
		}
	}

}