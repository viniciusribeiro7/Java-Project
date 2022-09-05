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

public class PanelPedidos extends JPanel {

	private JTable JtableBebidas;
	private JTable JtableFinalizar;
	private DefaultTableModel modeloTabela;
	private List<Sabor> saborLista;
	private SaborDao saborDao;
	private Sabor sabor;
	private JTable JtableSabores;
	private List<Estoque> estoqueLista;
	private EstoqueDao estoqueDao;
	private Estoque estoque;
	private Double soma = 0.0;

	public PanelPedidos() {

		setLayout(null);
		setVisible(true);

		JScrollPane scrIngredientes = new JScrollPane();
		scrIngredientes.setBounds(41, 23, 185, 158);
		add(scrIngredientes);

		JtableSabores = new JTable();
		scrIngredientes.setViewportView(JtableSabores);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(412, 223, 89, 23);
		add(btnAdicionar);
		btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				Adicionar(evt);
			}
		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(412, 189, 89, 23);
		add(btnExcluir);

		JButton btnFinalizarPedido = new JButton("Finalizar ");
		btnFinalizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					File file = new File("C:\\Users\\vinic\\OneDrive\\Área de Trabalho\\vendas\\relatorio.txt");
					if (file.exists()) {

						file.createNewFile();
					}

					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);

					for (int i = 0; i < JtableFinalizar.getRowCount(); i++) {
						for (int j = 0; j < JtableFinalizar.getColumnCount(); j++) {
							bw.write(JtableFinalizar.getModel().getValueAt(i, j).toString() + " / ");
						}

						bw.newLine();
					}

					bw.close();
					fw.close();
					JOptionPane.showMessageDialog(null, soma);
					JOptionPane.showMessageDialog(null, "Comprovante de venda gerado com sucesso");
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Erro" + ex);
				}
				

			}
		});
		btnFinalizarPedido.setBounds(412, 262, 89, 23);
		add(btnFinalizarPedido);

		JScrollPane scrlBebidasSelecionadas = new JScrollPane();
		scrlBebidasSelecionadas.setBounds(236, 192, 166, 171);
		add(scrlBebidasSelecionadas);
		btnExcluir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Excluir(evt);
			}

		});

		JScrollPane scrlBebidas = new JScrollPane();
		scrlBebidas.setBounds(41, 192, 185, 171);
		add(scrlBebidas);

		JtableBebidas = new JTable();

		scrlBebidas.setViewportView(JtableBebidas);

		JtableFinalizar = new JTable();

		JtableFinalizar.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Pedido", "Preço" }));
		scrlBebidasSelecionadas.setViewportView(JtableFinalizar);

		JLabel lblNewLabel = new JLabel("Massa");
		lblNewLabel.setBounds(238, 99, 46, 14);
		add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "Fina", "Normal", "Integral", "Pan" }));
		comboBox.setBounds(294, 95, 124, 22);
		add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Tamanho");
		lblNewLabel_1.setBounds(238, 41, 87, 14);
		add(lblNewLabel_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "", "B", "P", "M", "G", "F" }));
		comboBox_1.setBounds(324, 37, 68, 22);
		add(comboBox_1);

		JLabel lblNewLabel_2 = new JLabel("Borda");
		lblNewLabel_2.setBounds(237, 70, 46, 14);
		add(lblNewLabel_2);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2
				.setModel(new DefaultComboBoxModel(new String[] { "", "Catupiry", "Cheddar", "Queijo", "Alho poró" }));
		comboBox_2.setBounds(277, 66, 115, 22);
		add(comboBox_2);

		JLabel lblNewLabel_3 = new JLabel("Pagamento");
		lblNewLabel_3.setBounds(236, 131, 89, 14);
		add(lblNewLabel_3);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "", "Dinheiro", "Débito", "Crédito", "Pix" }));
		comboBox_3.setBounds(301, 127, 139, 22);
		add(comboBox_3);
		popularTabela();
		popularTabelaBebida();
	}

	private void Adicionar(java.awt.event.ActionEvent evt) {

		TableModel model1 = JtableSabores.getModel();

		int[] indexs = JtableSabores.getSelectedRows();

		TableModel modelBebidas = JtableBebidas.getModel();

		int[] ind = JtableBebidas.getSelectedRows();

		Object[] row = new Object[2];
		Object[] row2 = new Object[2];

		DefaultTableModel model2 = (DefaultTableModel) JtableFinalizar.getModel();
		for (int i = 0; i < indexs.length; i++) {
			row[0] = model1.getValueAt(indexs[i], 0);
			row[1] = model1.getValueAt(indexs[i], 1);
			soma = soma + Double.parseDouble(model1.getValueAt(indexs[i], 1).toString());
			model2.addRow(row);

		}
		DefaultTableModel model3 = (DefaultTableModel) JtableFinalizar.getModel();
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

		DefaultTableModel model2 = (DefaultTableModel) JtableFinalizar.getModel();

		try {
			int SelectedRowIndex = JtableFinalizar.getSelectedRow();
			model2.removeRow(SelectedRowIndex);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

	}

	public void popularTabela() {
		try {
			saborDao = new SaborDao();
			saborLista = saborDao.consultarSabor();
			modeloTabela = new DefaultTableModel();
			modeloTabela.addColumn("Nome");
			modeloTabela.addColumn("Preço");

			for (Sabor sabor : saborLista) {
				modeloTabela.addRow(new String[] { sabor.getNome().toString(), sabor.getPreco().toString() });
			}
			JtableSabores.setModel(modeloTabela);
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
		}

	}
}