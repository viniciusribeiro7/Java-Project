package sistema.br.edu.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import sistema.br.edu.classes.Atendente;
import sistema.br.edu.classes.Gerente;
import sistema.br.edu.classes.Usuario;
import sistema.br.edu.dao.UsuarioDao;
import sistema.br.edu.gui.GuiAtendente;
import sistema.br.edu.gui.GuiGerente;


public class GuiLogin extends JFrame {

	private JPanel contentPane;

	int xx, xy;
	private JTextField txfUsuario;
	private JPasswordField txfSenha;

	private Usuario usuario;
	private Gerente gerente;
	private Atendente atendente;
	private UsuarioDao usuarioDao;
	private GuiGerente gerenteTela;
	private GuiAtendente atendenteTela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiLogin frame = new GuiLogin();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiLogin() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		Button btnEntrar = new Button("Entrar");
		btnEntrar.setForeground(new Color(128, 0, 0));
		btnEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					usuarioDao = new UsuarioDao();
					if (usuarioDao.validarUsuario(txfUsuario.getText(), txfSenha.getText())) {
						usuario = Usuario.getInstance();
						if (usuario.getTipo().equals("gerente")) {
							 gerenteTela = new GuiGerente();							
							gerenteTela.setVisible(true);
						} else if (usuario.getTipo().equals("atendente")) {
							atendenteTela = new GuiAtendente();
							atendenteTela.setVisible(true);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Usuario ou senha inválidos", "Atenção",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro" +e2, "Erro",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnEntrar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEntrar.setBackground(new Color(255, 255, 255));
		btnEntrar.setBounds(395, 298, 283, 36);
		contentPane.add(btnEntrar);

		JLabel lblNewLabel = new JLabel("USUÁRIO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblNewLabel.setBounds(395, 58, 66, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("SENHA");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblNewLabel_1.setBounds(395, 184, 54, 14);
		contentPane.add(lblNewLabel_1);

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
				lblX.setForeground(Color.black);
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(new Color(241, 57, 83));
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblX.setBounds(670, 5, 54, 27);
		contentPane.add(lblX);

		JPanel pnlUsuario = new JPanel();
		pnlUsuario.setBounds(395, 83, 283, 36);
		contentPane.add(pnlUsuario);
		pnlUsuario.setLayout(null);

		txfUsuario = new JTextField();
		txfUsuario.setBounds(0, 0, 225, 36);
		pnlUsuario.add(txfUsuario);
		txfUsuario.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\adicionar-usuario.png"));
		lblNewLabel_4.setBounds(225, 0, 58, 36);
		pnlUsuario.add(lblNewLabel_4);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(395, 208, 283, 36);
		contentPane.add(separator_1);

		JPanel pnlSenha = new JPanel();
		pnlSenha.setLayout(null);
		pnlSenha.setBounds(395, 208, 283, 36);
		contentPane.add(pnlSenha);

		txfSenha = new JPasswordField();
		txfSenha.setBounds(0, 0, 225, 36);
		pnlSenha.add(txfSenha);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\fechadura.png"));
		lblNewLabel_3.setBounds(225, 0, 58, 36);
		pnlSenha.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\tb1.jpg"));
		lblNewLabel_2.setBounds(0, -12, 372, 479);
		contentPane.add(lblNewLabel_2);
	}
}