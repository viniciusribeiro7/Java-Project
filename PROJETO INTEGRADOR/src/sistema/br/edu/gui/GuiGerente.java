package sistema.br.edu.gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel paneMenuGerente;
	
	private PanelSabores panelSabores;
	private PanelRelatorio panelRelatorio;
	private PanelFuncionarios panelFuncionarios;
	private PanelEstoque panelEstoque;
	JPanel button;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiGerente guiGerente = new GuiGerente();
					guiGerente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 418);
		setUndecorated(true);
		setLocationRelativeTo(null);
		paneMenuGerente = new JPanel();
		paneMenuGerente.setBackground(new Color(128, 0, 0));
		paneMenuGerente.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(paneMenuGerente);
		paneMenuGerente.setLayout(null);

		//panelMenu = new PanelCadastroCliente();
		panelSabores = new PanelSabores();
		panelRelatorio = new PanelRelatorio();
		panelFuncionarios = new PanelFuncionarios();
		panelEstoque = new PanelEstoque();

		JPanel panelPrincipalMenu = new JPanel();
		panelPrincipalMenu.setBackground(new Color(128, 0, 0));
		panelPrincipalMenu.setBounds(0, 0, 249, 418);
		paneMenuGerente.add(panelPrincipalMenu);
		panelPrincipalMenu.setLayout(null);

		JLabel lblPizzaLogo = new JLabel("");
		lblPizzaLogo.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\pizza (2).png"));
		lblPizzaLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizzaLogo.setBounds(10, 10, 229, 160);
		panelPrincipalMenu.add(lblPizzaLogo);

		JPanel PanelSabores = new JPanel();
		PanelSabores.setForeground(Color.WHITE);
		PanelSabores.addMouseListener(new PanelButtonMouseAdapter(PanelSabores) {

			public void mouseClicked(MouseEvent e) {
				menuClicked(panelSabores);
			}
		});
		PanelSabores.setBackground(new Color(128, 0, 0));
		PanelSabores.setBounds(0, 180, 249, 40);
		panelPrincipalMenu.add(PanelSabores);
		PanelSabores.setLayout(null);

		JLabel lblSabores = new JLabel("SABORES");
		lblSabores.setForeground(Color.WHITE);
		lblSabores.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSabores.setBounds(76, 10, 163, 18);
		PanelSabores.add(lblSabores);

		JLabel lblIconSabores = new JLabel("");
		lblIconSabores.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSabores.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\cozinha (2).png"));
		lblIconSabores.setBounds(10, 0, 56, 40);
		PanelSabores.add(lblIconSabores);

		JPanel PanelRelatorio = new JPanel();
		PanelRelatorio.addMouseListener(new PanelButtonMouseAdapter(PanelRelatorio) {
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelRelatorio);
			}
		});
		PanelRelatorio.setBackground(new Color(128, 0, 0));
		PanelRelatorio.setBounds(0, 220, 249, 40);
		panelPrincipalMenu.add(PanelRelatorio);
		PanelRelatorio.setLayout(null);

		JLabel lblRelatorio = new JLabel("RELATÓRIOS");
		lblRelatorio.setForeground(Color.WHITE);
		lblRelatorio.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRelatorio.setBounds(76, 10, 163, 18);
		PanelRelatorio.add(lblRelatorio);

		JLabel lblIconRelatorio = new JLabel("");
		lblIconRelatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconRelatorio.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\prancheta.png"));
		lblIconRelatorio.setBounds(10, 0, 56, 40);
		PanelRelatorio.add(lblIconRelatorio);

		
		JPanel PanelFuncionarios = new JPanel();
		PanelFuncionarios.addMouseListener(new PanelButtonMouseAdapter(PanelFuncionarios) {
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelFuncionarios);
			}
		});
		PanelFuncionarios.setBackground(new Color(128, 0, 0));
		PanelFuncionarios.setBounds(0, 260, 249, 40);
		panelPrincipalMenu.add(PanelFuncionarios);
		PanelFuncionarios.setLayout(null);

		JLabel lblFuncionrios = new JLabel("FUNCIONÁRIOS");
		lblFuncionrios.setForeground(Color.WHITE);
		lblFuncionrios.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFuncionrios.setBounds(76, 10, 163, 18);
		PanelFuncionarios.add(lblFuncionrios);

		JLabel lblIconFuncionarios = new JLabel("");
		lblIconFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconFuncionarios.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\companhia.png"));
		lblIconFuncionarios.setBounds(10, 0, 56, 40);
		PanelFuncionarios.add(lblIconFuncionarios);

		JPanel PanelEstoque = new JPanel();
		PanelEstoque.addMouseListener(new PanelButtonMouseAdapter(PanelEstoque) {

			public void mouseClicked(MouseEvent e) {
				menuClicked(panelEstoque);
			}
		});
		PanelEstoque.setBackground(new Color(128, 0, 0));
		PanelEstoque.setBounds(0, 300, 249, 40);
		panelPrincipalMenu.add(PanelEstoque);
		PanelEstoque.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("ESTOQUE");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_4.setBounds(76, 10, 163, 18);
		PanelEstoque.add(lblNewLabel_4);

		JLabel lblIconEstoque = new JLabel("");
		lblIconEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconEstoque.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\doacao-de-alimentos.png"));
		lblIconEstoque.setBounds(10, 0, 56, 40);
		PanelEstoque.add(lblIconEstoque);

		JPanel PanelSair = new JPanel();
		PanelSair.addMouseListener(new PanelButtonMouseAdapter(PanelSair) {

			GuiLogin login = new GuiLogin();

			public void mouseClicked(MouseEvent e) {

				if (JOptionPane.showConfirmDialog(null, "Deseja realmente retornar ao login?", "Confirme",
						JOptionPane.YES_NO_OPTION) == 0) {

					setVisible(false);
					login.setVisible(true);

				}

			}

		});
		PanelSair.setBackground(new Color(128, 0, 0));
		PanelSair.setBounds(0, 340, 249, 40);
		panelPrincipalMenu.add(PanelSair);
		PanelSair.setLayout(null);

		JLabel lblSair = new JLabel("SAIR");
		lblSair.setForeground(Color.WHITE);
		lblSair.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSair.setBounds(76, 10, 163, 18);

		PanelSair.add(lblSair);

		JLabel lblIconSair = new JLabel("");
		lblIconSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSair.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\sair.png"));
		lblIconSair.setBounds(10, 0, 56, 40);
		PanelSair.add(lblIconSair);

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				if (JOptionPane.showConfirmDialog(null, "Deseja realmente fechar o aplicativo?", "Confirme",
						JOptionPane.YES_NO_OPTION) == 0) {
					System.exit(0);
				}

			}

			public void mouseEntered(MouseEvent arg0) {
				lblX.setForeground(Color.red);
			}

			public void mouseExited(MouseEvent arg0) {
				lblX.setForeground(Color.white);
			}
		});

		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(new Color(241, 57, 83));
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblX.setBounds(777, 0, 54, 27);
		paneMenuGerente.add(lblX);

		JPanel PanePrincipal = new JPanel();
		PanePrincipal.setBounds(259, 11, 538, 396);
		paneMenuGerente.add(PanePrincipal);
		PanePrincipal.setLayout(null);

		
		PanePrincipal.add(panelSabores);
		PanePrincipal.add(panelRelatorio);
		PanePrincipal.add(panelFuncionarios);
		PanePrincipal.add(panelEstoque);

		//menuClicked(panelMenu);
	}

	public void menuClicked(JPanel button) {
		
		panelSabores.setVisible(false);
		panelRelatorio.setVisible(false);
		panelFuncionarios.setVisible(false);
		panelEstoque.setVisible(false); 

		button.setVisible(true);

	}

	private class PanelButtonMouseAdapter extends MouseAdapter {
		private JPanel button;

		public PanelButtonMouseAdapter(JPanel panelMenu1) {
			this.button = panelMenu1;
		}

		public void mouseEntered(MouseEvent e) {
			button.setBackground(new Color(112, 128, 144));
		}

		public void mouseExited(MouseEvent e) {
			button.setBackground(new Color(128, 0, 0));
		}

		public void mousePressed(MouseEvent e) {
			button.setBackground(new Color(255, 0, 0));
		}

		public void mouseReleased(MouseEvent e) {
			button.setBackground(new Color(112, 128, 144));
		}
	}
}