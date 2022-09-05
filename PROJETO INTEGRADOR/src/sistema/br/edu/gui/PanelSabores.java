package sistema.br.edu.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sistema.br.edu.classes.Funcionario;
import sistema.br.edu.classes.Sabor;
import sistema.br.edu.dao.FuncionarioDao;
import sistema.br.edu.dao.SaborDao;

public class PanelSabores extends JPanel {
	private JTextField txfSabor;
	private JTable table;
	private JTextField txfPreco;

	private Sabor sabor;
	private SaborDao saborDao;
	private List<Sabor> saborLista;
	private JTextField txfId;
	private DefaultTableModel modeloTabela;

	/**
	 * Create the panel.
	 */
	public PanelSabores() {

		setBounds(0, 0, 545, 399);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Sabor");
		lblNewLabel.setBounds(37, 47, 46, 14);
		add(lblNewLabel);

		txfSabor = new JTextField();
		txfSabor.setBounds(99, 44, 158, 20);
		add(txfSabor);
		txfSabor.setColumns(10);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sabor = new Sabor();
					sabor.setIdsabor(Integer.parseInt(txfId.getText()));
					sabor.setNome(txfSabor.getText());
					sabor.setPreco(Double.parseDouble(txfPreco.getText()));
					saborDao.incluirSabor(sabor);
					limparCampos();
					popularTabela();

				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, "Erro ao incluir!" + e2);
				}
			}
		});
		btnIncluir.setBounds(37, 72, 89, 23);
		add(btnIncluir);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ConfirmarExcluir = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir?");
					if (ConfirmarExcluir == 0) {
						sabor = new Sabor();
						saborDao = new SaborDao();
						sabor.setIdsabor(Integer.parseInt(txfId.getText()));
						saborDao.excluirSabor(sabor);
						limparCampos();
						popularTabela();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao Excluir!" + ex);
				}
			}
		});
		btnExcluir.setBounds(193, 72, 89, 23);
		add(btnExcluir);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer confirma = JOptionPane.showConfirmDialog(null, "Deseja alterar?");
					if (confirma == 0) {
						sabor = new Sabor();
						saborDao = new SaborDao();
						sabor.setIdsabor(Integer.parseInt(txfId.getText()));
						sabor.setNome(txfSabor.getText());
						sabor.setPreco(Double.parseDouble(txfPreco.getText()));
						saborDao.alterarSabor(sabor);
						limparCampos();
						popularTabela();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao Alterar!" + ex);
				}
			}
		});
		btnAlterar.setBounds(347, 72, 89, 23);
		add(btnAlterar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 126, 498, 249);
		add(scrollPane);

		table = new JTable();

		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				Integer ItemSelecionado = table.getSelectionModel().getLeadSelectionIndex();
				sabor = saborLista.get(ItemSelecionado);
				txfId.setText(sabor.getIdsabor().toString());
				txfSabor.setText(sabor.getNome().toString());
				txfPreco.setText(sabor.getPreco().toString());

			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("Preço");
		lblNewLabel_1.setBounds(298, 44, 46, 14);
		add(lblNewLabel_1);

		txfPreco = new JTextField();
		txfPreco.setBounds(367, 41, 86, 20);
		add(txfPreco);
		txfPreco.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Id");
		lblNewLabel_2.setBounds(24, 11, 46, 14);
		add(lblNewLabel_2);

		txfId = new JTextField();
		txfId.setEditable(false);
		txfId.setBounds(101, 8, 86, 20);
		add(txfId);
		txfId.setColumns(10);
		setVisible(true);
		popularTabela();
	}

	public void limparCampos() {
		txfSabor.setText(null);
		txfPreco.setText(null);

	}

	public void popularTabela() {

		try {
			saborDao = new SaborDao();
			saborLista = saborDao.consultarSabor();
			modeloTabela = new DefaultTableModel();
			modeloTabela.addColumn("ID");
			modeloTabela.addColumn("Nome");
			modeloTabela.addColumn("Preço");

			for (Sabor sabor : saborLista) {
				modeloTabela.addRow(new String[] { sabor.getIdsabor().toString(), sabor.getNome().toString(),
						sabor.getPreco().toString() });
			}
			table.setModel(modeloTabela);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO!" + e);
		}

	}

}