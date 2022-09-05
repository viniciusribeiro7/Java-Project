package sistema.br.edu.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import sistema.br.edu.classes.Funcionario;
import sistema.br.edu.dao.EstoqueDao;
import sistema.br.edu.dao.FuncionarioDao;

public class PanelFuncionarios extends JPanel {
	private JTextField txfId;
	private JTextField txfNome;
	private JLabel lblNewLabel_2;
	private JTextField txfTelefone;
	private JTextField txfEndereco;
	private JTable table;
	
	
	private JComboBox cbxFuncao;
	private Funcionario funcionario;
	private FuncionarioDao funcionarioDao;
	private List<Funcionario> lista;
	private DefaultTableModel modeloTabela;
	private DefaultComboBoxModel modeloCombo;

	/**
	 * Create the panel.
	 */
	public PanelFuncionarios() {

		setBounds(0, 0, 561, 454);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(47, 14, 80, 14);
		add(lblNewLabel);

		txfId = new JTextField();
		txfId.setEditable(false);
		txfId.setBounds(114, 11, 102, 20);
		add(txfId);
		txfId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(47, 50, 46, 14);
		add(lblNewLabel_1);

		txfNome = new JTextField();
		txfNome.setBounds(114, 47, 267, 20);
		add(txfNome);
		txfNome.setColumns(10);

		lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setBounds(229, 14, 64, 14);
		add(lblNewLabel_2);

		txfTelefone = new JTextField();
		txfTelefone.setBounds(303, 11, 193, 20);
		add(txfTelefone);
		txfTelefone.setColumns(10);

		JComboBox cbxFuncao = new JComboBox();
		cbxFuncao.setModel(new DefaultComboBoxModel(
				new String[] { "", "Atendente", "Cozinheiro", "Garçom", "Faxineiro", "Entregador" }));
		cbxFuncao.setBounds(127, 109, 115, 22);
		add(cbxFuncao);

		JLabel lblNewLabel_3 = new JLabel("Função");
		lblNewLabel_3.setBounds(47, 113, 46, 14);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Endereço");
		lblNewLabel_4.setBounds(47, 84, 60, 14);
		add(lblNewLabel_4);

		txfEndereco = new JTextField();
		txfEndereco.setBounds(117, 78, 337, 20);
		add(txfEndereco);
		txfEndereco.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(23, 142, 511, 52);
		add(panel_1);
		panel_1.setLayout(null);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ConfirmarExcluir = 	JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir?");
					if (ConfirmarExcluir == 0) { 
					funcionario = new Funcionario();
					funcionarioDao = new FuncionarioDao();
					funcionario.setIdfuncionario(Integer.parseInt(txfId.getText()));
					funcionarioDao.excluirFuncionario(funcionario);
					limparCampos();
					popularTabela();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro" + ex);
				}
			}
		});

		btnExcluir.setBounds(26, 11, 89, 23);
		panel_1.add(btnExcluir);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer confirma = JOptionPane.showConfirmDialog(null, "Deseja alterar?");
					if (confirma == 0) {
						funcionario = new Funcionario();
						funcionarioDao = new FuncionarioDao();
						funcionario.setIdfuncionario(Integer.parseInt(txfId.getText()));
						funcionario.setNome(txfNome.getText());
						funcionario.setFuncao(cbxFuncao.getSelectedItem().toString());
						funcionario.setTelefone(txfTelefone.getText());
						funcionario.setEndereco(txfEndereco.getText());
						funcionarioDao.alterarFuncionario(funcionario);
						
						limparCampos();
						popularTabela();
					}
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, "Erro!" + e2);
				}
			}
		});
		btnAlterar.setBounds(197, 11, 89, 23);
		panel_1.add(btnAlterar);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					funcionario = new Funcionario();
					funcionario.setTelefone(txfTelefone.getText());
					funcionario.setNome(txfNome.getText());
					funcionario.setEndereco(txfEndereco.getText());
					funcionario.setFuncao(cbxFuncao.getSelectedItem().toString());
					funcionarioDao.incluirFuncionario(funcionario);
					limparCampos();
					popularTabela();
										
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, "Erro!" + e2);
				}
			}
		});
		btnIncluir.setBounds(390, 11, 89, 23);
		panel_1.add(btnIncluir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 205, 511, 238);
		add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e ) {
				Integer ItemSelecionado = table.getSelectionModel().getLeadSelectionIndex();
				funcionario = lista.get(ItemSelecionado);
				txfId.setText(funcionario.getIdfuncionario().toString());
				txfTelefone.setText(funcionario.getTelefone().toString());
				txfNome.setText(funcionario.getNome().toString());
				txfEndereco.setText(funcionario.getEndereco().toString());
				cbxFuncao.setSelectedItem(funcionario.getFuncao());
			
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(261, 102, 235, 29);
		add(panel);
		setVisible(true);
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
			funcionarioDao= new FuncionarioDao();
			lista = funcionarioDao.consultarTodosFuncionarios();
			modeloTabela = new DefaultTableModel();
			modeloTabela.addColumn("idfuncionario");
			modeloTabela.addColumn("telefone");
			modeloTabela.addColumn("nome");
			modeloTabela.addColumn("endereco");
			modeloTabela.addColumn("funcao");
			
			for(Funcionario funcionario : lista) {
				modeloTabela.addRow( new String[] {funcionario.getIdfuncionario().toString(),funcionario.getTelefone().toString(),funcionario.getNome().toString(),funcionario.getEndereco().toString(),funcionario.getFuncao().toString()});
			}
			table.setModel(modeloTabela);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO!");
		}
		
	}
	
}