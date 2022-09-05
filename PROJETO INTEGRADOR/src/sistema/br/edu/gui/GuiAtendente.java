package sistema.br.edu.gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiAtendente extends JFrame {

	private JPanel paneMenuAtendente;
	private PanelCadastroCliente panelMenu;
	private PanelPedidos panelPedidos;
	private PanelPedidoPersonalizado panelPedidoPersonalizado;
	
	Timer tm2;
	Integer pl2 = 60;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiAtendente guiAtendente = new GuiAtendente();
					guiAtendente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GuiAtendente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 418);
		setUndecorated(true);
		setLocationRelativeTo(null);
		paneMenuAtendente = new JPanel();
		paneMenuAtendente.setBackground(new Color(128, 0, 0));
		paneMenuAtendente.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(paneMenuAtendente);
		paneMenuAtendente.setLayout(null);

		panelMenu = new PanelCadastroCliente();
		panelMenu.setBounds(0, 0, 538, 382);
		panelPedidos = new PanelPedidos();
		panelPedidos.setBounds(0, 0, 538, 382);
		panelPedidoPersonalizado = new PanelPedidoPersonalizado();
		panelPedidoPersonalizado.setBounds(0, 0, 538, 382);

		JPanel panelPrincipalMenu = new JPanel();
		panelPrincipalMenu.setBackground(new Color(128, 0, 0));
		panelPrincipalMenu.setBounds(0, 0, 249, 418);
		paneMenuAtendente.add(panelPrincipalMenu);
		panelPrincipalMenu.setLayout(null);

		JLabel lblPizzaLogo = new JLabel("");
		lblPizzaLogo.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\pizza (2).png"));
		lblPizzaLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizzaLogo.setBounds(10, 10, 229, 120);
		panelPrincipalMenu.add(lblPizzaLogo);

		JPanel PanelMenu = new JPanel();
		PanelMenu.addMouseListener(new PanelButtonMouseAdapter(PanelMenu) {

			public void mouseClicked(MouseEvent e) {
				menuClicked(panelMenu);
			}
		});
		PanelMenu.setBackground(new Color(128, 0, 0));
		PanelMenu.setBounds(0, 140, 249, 40);
		panelPrincipalMenu.add(PanelMenu);
		PanelMenu.setLayout(null);

		JLabel lblNewLabel = new JLabel("CADASTRO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(76, 11, 163, 18);
		PanelMenu.add(lblNewLabel);

		JLabel lblIconMenu = new JLabel("");
		lblIconMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconMenu.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\casa (2).png"));
		lblIconMenu.setBounds(10, 0, 56, 40);
		PanelMenu.add(lblIconMenu);

		JPanel PanelPedidos = new JPanel();
		PanelPedidos.addMouseListener(new PanelButtonMouseAdapter(PanelPedidos) {
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelPedidos);
			}
		});
		PanelPedidos.setBackground(new Color(128, 0, 0));
		PanelPedidos.setBounds(0, 182, 249, 40);
		panelPrincipalMenu.add(PanelPedidos);
		PanelPedidos.setLayout(null);

		JLabel lblIconPedidos = new JLabel("");
		lblIconPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPedidos.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\bicicleta-de-entrega.png"));
		lblIconPedidos.setBounds(10, 0, 56, 40);
		PanelPedidos.add(lblIconPedidos);

		JPanel PedidoPersonalizado = new JPanel();
		PedidoPersonalizado.addMouseListener(new PanelButtonMouseAdapter(PedidoPersonalizado) {
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelPedidoPersonalizado);
			}
		});

		PedidoPersonalizado.setBackground(new Color(47, 79, 79));
		PedidoPersonalizado.setBounds(0, 40, 249, 40);
		PanelPedidos.add(PedidoPersonalizado);
		PedidoPersonalizado.setLayout(null);

		JLabel lblPedidoPersonalizado = new JLabel("     PEDIDO PERSONALIZADO");
		lblPedidoPersonalizado.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidoPersonalizado.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\pizza.png"));
		lblPedidoPersonalizado.setForeground(Color.WHITE);
		lblPedidoPersonalizado.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPedidoPersonalizado.setBounds(0, 0, 249, 40);
		PedidoPersonalizado.add(lblPedidoPersonalizado);
		
				JLabel lblPedidos = new JLabel("PEDIDOS");
				lblPedidos.setBounds(76, 11, 163, 18);
				PanelPedidos.add(lblPedidos);
				lblPedidos.setBackground(new Color(47, 79, 79));
				lblPedidos.setForeground(Color.WHITE);
				lblPedidos.setFont(new Font("Dialog", Font.BOLD, 14));

		tm2 = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (pl2 > 100) {
					tm2.stop();
				} else {
					PanelPedidos.setSize(panelPrincipalMenu.getWidth(), pl2);
					pl2 += 10;
				}
			}
		});

		PanelPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {

				tm2.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				tm2.stop();
				pl2 = 60;
			}
		});

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
		PanelSair.setBounds(0, 378, 249, 40);
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
		paneMenuAtendente.add(lblX);

		JPanel PanePrincipal = new JPanel();
		PanePrincipal.setBounds(259, 11, 538, 396);
		paneMenuAtendente.add(PanePrincipal);
		PanePrincipal.setLayout(null);

		PanePrincipal.add(panelMenu);
		
		PanePrincipal.add(panelPedidos);
		
		PanePrincipal.add(panelPedidoPersonalizado);
		
		menuClicked(panelMenu);
	}

	public void menuClicked(JPanel button) {
		panelMenu.setVisible(false);
		panelPedidoPersonalizado.setVisible(false);
		panelPedidos.setVisible(false);
		
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
///////////// ESTOU AQUI
		public void mousePressed(MouseEvent e) {
			button.setBackground(new Color(255, 0, 0));
		}

		public void mouseReleased(MouseEvent e) {
			button.setBackground(new Color(112, 128, 144));
		}
	}
}