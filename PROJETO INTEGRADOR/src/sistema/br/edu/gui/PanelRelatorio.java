package sistema.br.edu.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class PanelRelatorio extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable JtableRelatorio;
	private JTable JtableRelatorioPersonalizadas;

	public PanelRelatorio() {
		setSize(538, 396);
		setLayout(null);

		JScrollPane scrlRelatorio = new JScrollPane();
		scrlRelatorio.setBounds(20, 64, 229, 212);
		add(scrlRelatorio);

		JtableRelatorio = new JTable();
		scrlRelatorio.setViewportView(JtableRelatorio);

		JLabel lblVendas = new JLabel("VENDAS PADRÃO");
		lblVendas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVendas.setBounds(20, 10, 229, 44);
		add(lblVendas);

		JButton btnRelatorio = new JButton("Importar Vendas");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String filePath = "C:\\Users\\vinic\\OneDrive\\Área de Trabalho\\vendas\\relatorio.txt";

				File file = new File(filePath);

				try {
					BufferedReader br = new BufferedReader(new FileReader(file));

					DefaultTableModel model = (DefaultTableModel) JtableRelatorio.getModel();
					model.addColumn("Pedido");
					model.addColumn("Preço");

					Object[] tableLines = br.lines().toArray();

					for (int i = 0; i < tableLines.length; i++) {
						String line = tableLines[i].toString().trim();
						String[] dataRow = line.split("/");
						model.addRow(dataRow);
					}

					br.close();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao buscar arquivo");
				}
			}

		});
		btnRelatorio.setBounds(55, 314, 130, 21);
		add(btnRelatorio);

		JScrollPane scrlRelatorioPersonalizadas = new JScrollPane();
		scrlRelatorioPersonalizadas.setBounds(272, 64, 229, 212);
		add(scrlRelatorioPersonalizadas);

		JtableRelatorioPersonalizadas = new JTable();
		scrlRelatorioPersonalizadas.setViewportView(JtableRelatorioPersonalizadas);
		
		JButton btnPersonalizadas = new JButton("Importar Vendas Personalizadas");
		btnPersonalizadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String filePath = "C:\\Users\\vinic\\OneDrive\\Área de Trabalho\\vendas\\relatorioVendasPersonalizada.txt";

				File file = new File(filePath);

				try {
					BufferedReader br = new BufferedReader(new FileReader(file));

					DefaultTableModel model = (DefaultTableModel) JtableRelatorioPersonalizadas.getModel();
					model.addColumn("Pedido");
					model.addColumn("Preço");

					Object[] tableLines = br.lines().toArray();

					for (int i = 0; i < tableLines.length; i++) {
						String line = tableLines[i].toString().trim();
						String[] dataRow = line.split("/");
						model.addRow(dataRow);
					}

					br.close();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro ao buscar arquivo");
				}
				
			}
		});
		btnPersonalizadas.setBounds(284, 314, 206, 21);
		add(btnPersonalizadas);
		
		JLabel lblVendasPersonalizadas = new JLabel("VENDAS PERSONALIZADAS");
		lblVendasPersonalizadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendasPersonalizadas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVendasPersonalizadas.setBounds(272, 10, 229, 44);
		add(lblVendasPersonalizadas);

	}
}