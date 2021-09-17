package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import model.Categoria;
import model.EProducto;
import model.EUsuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(122, 30, 161, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario :");
		lblNewLabel.setBounds(10, 33, 102, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblClave = new JLabel("Clave :");
		lblClave.setBounds(10, 64, 102, 14);
		contentPane.add(lblClave);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(122, 61, 161, 20);
		contentPane.add(txtClave);
		
	}

	
	private JTextField txtClave;
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mySql");
	//crea los DAO usando la fabrica
	EntityManager em = fabrica.createEntityManager();
	
	void registrar() {
		String usuario = txtUsuario.getText();
		String password = txtClave.getText();
		String sql2 = "{call usp_validaAcceso(?, ?)}";	
		
		//esto es para JPA
		//TypedQuery<EUsuario> query = em.createQuery(sql2, EUsuario.class);
		Query query = em.createNativeQuery(sql2, EUsuario.class);
		//query.setParameter("xusr", "U002@gmail.com");
		//query.setParameter("xcla", "10002");
		query.setParameter(1, usuario);
		query.setParameter(2, password);
		
		EUsuario u = (EUsuario) query.getSingleResult();
		
		if(u == null) {
			System.out.println("codigo no existe: " + usuario);
		} else {
			System.out.println("Bienvenido: " + u.getNombre());
		}
		
		em.close();
	}
	
	void aviso(String aviso) {
		//JOptionPane.showMessage
	}
}