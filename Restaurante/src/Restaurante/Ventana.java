package Restaurante;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class Ventana extends JFrame {
	private Font belanosima;

	// Campo de texto redondeado
	public static class RoundedTextField extends JTextField {
		private int arc;

		public RoundedTextField(int columns, int arc) {
			super(columns);
			this.arc = arc;
			setOpaque(false);
			setBorder(null);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
			g2.dispose();
			super.paintComponent(g);
		}
	}

	// Campo de contraseña redondeado
	public static class RoundedPasswordField extends JPasswordField {
		private int arc;

		public RoundedPasswordField(int columns, int arc) {
			super(columns);
			this.arc = arc;
			setOpaque(false);
			setBorder(null);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
			g2.dispose();
			super.paintComponent(g);
		}
	}

	// Boton de iniciar sesion redondeado
	public static class RoundedButton extends JButton {
		private int arc;

		public RoundedButton(String text, int arc) {
			super(text);
			this.arc = arc;
			setOpaque(false);
			setBorderPainted(false); // elimina el borde estándar
			setFocusPainted(false); // elimina el borde de enfoque
			setContentAreaFilled(false); // evita que Swing pinte el área por defecto
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

			super.paintComponent(g);

			g2.dispose();
		}
	}

	// Campo de text area redondeado
	public static class RoundedTextArea extends JTextArea {
		private int arc;

		public RoundedTextArea(int arc) {
			this.arc = arc;
			setOpaque(false);
			setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			setLineWrap(true);
			setWrapStyleWord(true);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

			g2.setColor(new Color(220, 220, 220));
			g2.setStroke(new BasicStroke(1));
			g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

			g2.dispose();

			super.paintComponent(g);
		}
	}

	public Ventana() {

		this.setSize(1200, 839);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(200, 200));
		this.setMaximumSize(new Dimension(1000, 1000));
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setTitle("La casa del maiz");

		// this.inicioSesion();
		// this.registro();
		// this.panelControl();
		// this.platillos();
		// this.ordenes();
		// this.clientes();
		// this.inventario();
		// this.agregarPlatillo();
		// this.editarPlatillo();

		// this.router("inicioSesion");

		try {
			Image iconImage = ImageIO.read(getClass().getResource("/images/LOGO NUDE VR.jpg"));

			this.setIconImage(iconImage);

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			belanosima = Font.createFont(Font.TRUETYPE_FONT,
					getClass().getResourceAsStream("/fonts/Belanosima-Regular.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(belanosima);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.setVisible(true);
		this.repaint();
	}

	public void router(String target) {

		this.getContentPane().removeAll();

		if (target.equals("inicioSesion"))
			this.inicioSesion();

		if (target.equals("registro"))
			this.registro();

		if (target.equals("panelControl"))
			this.panelControl();

		if (target.equals("platillos"))
			this.platillos();

		if (target.equals("ordenes"))
			this.ordenes();

		if (target.equals("clientes"))
			this.clientes();

		if (target.equals("inventario"))
			this.inventario();

		if (target.equals("agregarPlatillo"))
			this.agregarPlatillo();

		this.revalidate();
		this.repaint();

	}

	public void inicioSesion() {
		// Panel principal con imagen de fondo
		JPanel inicio_contenedor = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/fondo login.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		inicio_contenedor.setLayout(null);
		inicio_contenedor.setSize(1200, 800);
		this.add(inicio_contenedor);

		// Panel redondeado blanco
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				int arc = 40;
				g2d.setColor(Color.decode("#FFFFFF"));
				g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
				g2d.dispose();
			}
		};
		panel.setOpaque(false);
		panel.setSize(480, 580);
		panel.setLocation((inicio_contenedor.getWidth() - panel.getWidth()) / 2,
				(inicio_contenedor.getHeight() - panel.getHeight()) / 2);
		panel.setLayout(null);
		inicio_contenedor.add(panel);

		// Añadir componentes

		// Logo
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/LOGO FINAL VR.png"));
		Image img = icon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		JLabel iconLabel = new JLabel(scaledIcon);
		iconLabel.setSize(150, 100);
		iconLabel.setLocation(170, 10);
		iconLabel.setAlignmentX(CENTER_ALIGNMENT);
		iconLabel.setAlignmentY(CENTER_ALIGNMENT);
		panel.add(iconLabel);

		// Etiqueta de correo
		JLabel correo = new JLabel("Correo electrónico");
		correo.setBounds(40, 110, 200, 100);
		correo.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(correo);

		// Cuadro de texto de correo
		RoundedTextField textCorreo = new RoundedTextField(20, 20);
		textCorreo.setSize(400, 50);
		textCorreo.setLocation(40, 185);
		textCorreo.setBackground(Color.decode("#FFB25B"));
		textCorreo.setOpaque(false);
		textCorreo.setBorder(null);
		panel.add(textCorreo);

		// Etiqueta de contraseña
		JLabel contra = new JLabel("Contraseña");
		contra.setBounds(40, 230, 200, 100);
		contra.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(contra);

		// Cuadro de contraseña
		RoundedPasswordField textContra = new RoundedPasswordField(20, 20);
		textContra.setSize(400, 50);
		textContra.setLocation(40, 305);
		textContra.setBackground(Color.decode("#FFB25B"));
		textContra.setOpaque(false);
		textContra.setBorder(null);

		// Botón para mostrar/ocultar contraseña
		ImageIcon eyeIcon = new ImageIcon(getClass().getResource("/images/ojo.png"));

		Image img1 = eyeIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledEyeIcon = new ImageIcon(img1);

		JButton visible = new JButton(scaledEyeIcon);
		visible.setSize(50, 50);
		visible.setLocation(390, 305);
		visible.setFocusPainted(false);
		visible.setBorderPainted(false);
		visible.setContentAreaFilled(false);

		visible.addActionListener(e -> {
			if (textContra.getEchoChar() == '\u0000') {
				// Si ya está visible, vuelve a ocultar
				textContra.setEchoChar('•');
			} else {
				// Si está oculto, mostrar texto
				textContra.setEchoChar((char) 0);
			}
		});
		panel.add(visible);
		panel.add(textContra);

		// Boton de olvidaste tu contraseña
		JButton btnOlvido = new JButton("¿Olvidaste tu contraseña?");
		btnOlvido.setSize(250, 30);
		btnOlvido.setLocation(210, 370);
		btnOlvido.setOpaque(false);
		btnOlvido.setBackground(Color.white);
		btnOlvido.setBorder(null);
		btnOlvido.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(btnOlvido);

		// Boton de iniciar sesion
		RoundedButton btnInicio = new RoundedButton("Iniciar sesión", 20);
		btnInicio.setSize(250, 50);
		btnInicio.setLocation(115, 430);
		btnInicio.setBackground(Color.decode("#B6200D"));
		btnInicio.setFont(new Font("Arial", Font.BOLD, 20));
		btnInicio.setForeground(Color.white);

		btnInicio.addActionListener(e -> {
			router("panelControl");
		});

		panel.add(btnInicio);

		// Boton de no tienes cuenta
		JButton btnnoCuenta = new JButton("¿No tienes cuenta? Regístrate");
		btnnoCuenta.setSize(250, 30);
		btnnoCuenta.setLocation(115, 500);
		btnnoCuenta.setOpaque(false);
		btnnoCuenta.setBackground(Color.white);
		btnnoCuenta.setForeground(Color.decode("#981406"));
		btnnoCuenta.setBorder(null);
		btnnoCuenta.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(btnnoCuenta);
		btnnoCuenta.addActionListener(e -> {
			router("registro");
		});

	}

	public void registro() {

		// Panel principal con imagen de fondo
		JPanel registro_contenedor = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/fondo login.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		registro_contenedor.setLayout(null);
		registro_contenedor.setSize(1200, 800);
		this.add(registro_contenedor);

		// Panel redondeado blanco
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				int arc = 40;
				g2d.setColor(Color.decode("#FFFFFF"));
				g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
				g2d.dispose();
			}
		};
		panel.setOpaque(false);
		panel.setSize(650, 580);
		panel.setLocation((registro_contenedor.getWidth() - panel.getWidth()) / 2,
				(registro_contenedor.getHeight() - panel.getHeight()) / 2);
		panel.setLayout(null);
		registro_contenedor.add(panel);

		// Añadir componentes

		// Logo
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/LOGO FINAL VR.png"));
		Image img = icon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		JLabel iconLabel = new JLabel(scaledIcon);
		iconLabel.setSize(140, 100);
		iconLabel.setLocation(250, 10);
		iconLabel.setAlignmentX(CENTER_ALIGNMENT);
		iconLabel.setAlignmentY(CENTER_ALIGNMENT);
		panel.add(iconLabel);

		// Etiqueta de nombre
		JLabel nombre = new JLabel("Nombre(s)");
		nombre.setBounds(40, 110, 200, 100);
		nombre.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(nombre);

		// Cuadro de texto de nombre
		RoundedTextField textNombre = new RoundedTextField(20, 20);
		textNombre.setSize(250, 50);
		textNombre.setLocation(40, 185);
		textNombre.setBackground(Color.decode("#FFB25B"));
		textNombre.setOpaque(false);
		textNombre.setBorder(null);
		panel.add(textNombre);

		// Etiqueta de apellido
		JLabel apellido = new JLabel("Apellido(s)");
		apellido.setBounds(350, 110, 200, 100);
		apellido.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(apellido);

		// Cuadro de texto de nombre
		RoundedTextField textApellido = new RoundedTextField(20, 20);
		textApellido.setSize(250, 50);
		textApellido.setLocation(350, 185);
		textApellido.setBackground(Color.decode("#FFB25B"));
		textApellido.setOpaque(false);
		textApellido.setBorder(null);
		panel.add(textApellido);

		// Etiqueta de correo electronico
		JLabel correo = new JLabel("Correo electrónico");
		correo.setBounds(40, 210, 300, 100);
		correo.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(correo);

		// Cuadro de texto de correo electronico
		RoundedTextField textCorreo = new RoundedTextField(20, 20);
		textCorreo.setSize(560, 50);
		textCorreo.setLocation(40, 280);
		textCorreo.setBackground(Color.decode("#FFB25B"));
		textCorreo.setOpaque(false);
		textCorreo.setBorder(null);
		panel.add(textCorreo);

		// Etiqueta de contraseña
		JLabel contra = new JLabel("Contraseña");
		contra.setBounds(40, 310, 300, 100);
		contra.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(contra);

		// Cuadro de texto de nombre
		RoundedTextField textContra = new RoundedTextField(20, 20);
		textContra.setSize(250, 50);
		textContra.setLocation(40, 380);
		textContra.setBackground(Color.decode("#FFB25B"));
		textContra.setOpaque(false);
		textContra.setBorder(null);
		panel.add(textContra);

		// Etiqueta de contraseña
		JLabel contra1 = new JLabel("Confirmar contraseña");
		contra1.setBounds(350, 310, 300, 100);
		contra1.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(contra1);

		// Cuadro de texto de nombre
		RoundedTextField textContra1 = new RoundedTextField(20, 20);
		textContra1.setSize(250, 50);
		textContra1.setLocation(350, 380);
		textContra1.setBackground(Color.decode("#FFB25B"));
		textContra1.setOpaque(false);
		textContra1.setBorder(null);
		panel.add(textContra1);

		// Boton de registrarse
		RoundedButton btnRegistro = new RoundedButton("Registrarse", 20);
		btnRegistro.setSize(250, 50);
		btnRegistro.setLocation(190, 460);
		btnRegistro.setBackground(Color.decode("#B6200D"));
		btnRegistro.setFont(new Font("Arial", Font.BOLD, 20));
		btnRegistro.setForeground(Color.white);

		btnRegistro.addActionListener(e -> {
			router("panelControl");
		});

		panel.add(btnRegistro);

		// Boton de ya tienes cuenta
		JButton btnsiCuenta = new JButton("¿Ya tienes cuenta? Inicia sesión");
		btnsiCuenta.setSize(250, 30);
		btnsiCuenta.setLocation(190, 530);
		btnsiCuenta.setOpaque(false);
		btnsiCuenta.setBackground(Color.white);
		btnsiCuenta.setForeground(Color.decode("#981406"));
		btnsiCuenta.setBorder(null);
		btnsiCuenta.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(btnsiCuenta);

		btnsiCuenta.addActionListener(e -> {
			router("inicioSesion");
		});

	}

	public void panelControl() {
		// Panel con imagen de fondo
		JPanel opciones = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/sidebar.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

			}

		};

		opciones.setBackground(Color.decode("#FEF9F3"));
		opciones.setLayout(null);
		opciones.setSize(270, 800);
		this.add(opciones);

		// Panel principal
		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setSize(1200, 800);
		contenido.setBackground(Color.decode("#FEF9F3"));
		this.add(contenido);

		JPanel linea = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea.setBounds(0, 100, 270, 1);
		linea.setOpaque(false);
		opciones.add(linea);

		JPanel linea1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea1.setBounds(0, 620, 270, 1);
		linea1.setOpaque(false);
		opciones.add(linea1);

		// Añadir Componentes

		// Logo
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/LOGO SIDEBAR.png"));
		Image img = icon.getImage().getScaledInstance(220, 80, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		JLabel iconLabel = new JLabel(scaledIcon);
		iconLabel.setSize(220, 80);
		iconLabel.setLocation(30, 10);
		iconLabel.setAlignmentX(CENTER_ALIGNMENT);
		iconLabel.setAlignmentY(CENTER_ALIGNMENT);
		opciones.add(iconLabel);

		// Boton de panel de control
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/dashboard.png"));
		Image img1 = icon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(img1);

		JButton btnControl = new JButton("Panel de control", scaledIcon1);
		btnControl.setSize(200, 50);
		btnControl.setLocation(30, 160);
		btnControl.setFont(new Font("Arial", Font.BOLD, 16));
		btnControl.setOpaque(false);
		btnControl.setBorder(null);
		btnControl.setBackground(Color.decode("#ad3813"));
		btnControl.setForeground(Color.white);
		btnControl.setHorizontalAlignment(SwingConstants.LEFT); // alinea todo el contenido a la izquierda
		btnControl.setHorizontalTextPosition(SwingConstants.RIGHT); // texto a la derecha del icono
		btnControl.setVerticalTextPosition(SwingConstants.CENTER); // texto centrado verticalmente
		btnControl.setIconTextGap(10);
		btnControl.setFocusPainted(false);

		btnControl.addActionListener(e -> {
			router("panelControl");
		});

		opciones.add(btnControl);

		// Boton de platillos
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/platillos.png"));
		Image img2 = icon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(img2);

		JButton btnPlatillos = new JButton("Platillos", scaledIcon2);
		btnPlatillos.setSize(200, 50);
		btnPlatillos.setLocation(30, 250);
		btnPlatillos.setFont(new Font("Arial", Font.BOLD, 16));
		btnPlatillos.setOpaque(false);
		btnPlatillos.setBorder(null);
		btnPlatillos.setBackground(Color.decode("#ad3813"));
		btnPlatillos.setForeground(Color.white);
		btnPlatillos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPlatillos.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPlatillos.setVerticalTextPosition(SwingConstants.CENTER);
		btnPlatillos.setIconTextGap(10);
		btnPlatillos.setFocusPainted(false);

		btnPlatillos.addActionListener(e -> {
			router("platillos");
		});
		opciones.add(btnPlatillos);

		// Boton de ordenes
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/órdenes.png"));
		Image img3 = icon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon3 = new ImageIcon(img3);

		JButton btnOrdenes = new JButton("Órdenes", scaledIcon3);
		btnOrdenes.setSize(200, 50);
		btnOrdenes.setLocation(30, 340);
		btnOrdenes.setFont(new Font("Arial", Font.BOLD, 16));
		btnOrdenes.setOpaque(false);
		btnOrdenes.setBorder(null);
		btnOrdenes.setBackground(Color.decode("#ad3813"));
		btnOrdenes.setForeground(Color.white);
		btnOrdenes.setHorizontalAlignment(SwingConstants.LEFT);
		btnOrdenes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnOrdenes.setVerticalTextPosition(SwingConstants.CENTER);
		btnOrdenes.setIconTextGap(10);
		btnOrdenes.setFocusPainted(false);

		btnOrdenes.addActionListener(e -> {
			router("ordenes");
		});

		opciones.add(btnOrdenes);

		// Boton de clientes
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/clientes.png"));
		Image img4 = icon4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(img4);

		JButton btnClientes = new JButton("Clientes", scaledIcon4);
		btnClientes.setSize(200, 50);
		btnClientes.setLocation(30, 430);
		btnClientes.setFont(new Font("Arial", Font.BOLD, 16));
		btnClientes.setOpaque(false);
		btnClientes.setBorder(null);
		btnClientes.setBackground(Color.decode("#ad3813"));
		btnClientes.setForeground(Color.white);
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnClientes.setVerticalTextPosition(SwingConstants.CENTER);
		btnClientes.setIconTextGap(10);
		btnClientes.setFocusPainted(false);

		btnClientes.addActionListener(e -> {
			router("clientes");
		});

		opciones.add(btnClientes);

		// Boton de clientes
		ImageIcon icon5 = new ImageIcon(getClass().getResource("/images/inventario.png"));
		Image img5 = icon5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon5 = new ImageIcon(img5);

		JButton btnInventario = new JButton("Inventario", scaledIcon5);
		btnInventario.setSize(200, 50);
		btnInventario.setLocation(30, 520);
		btnInventario.setFont(new Font("Arial", Font.BOLD, 16));
		btnInventario.setOpaque(false);
		btnInventario.setBorder(null);
		btnInventario.setBackground(Color.decode("#ad3813"));
		btnInventario.setForeground(Color.white);
		btnInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnInventario.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnInventario.setVerticalTextPosition(SwingConstants.CENTER);
		btnInventario.setIconTextGap(10);
		btnInventario.setFocusPainted(false);

		btnInventario.addActionListener(e -> {
			router("inventario");
		});

		opciones.add(btnInventario);

		// Boton de correo electronico
		ImageIcon icon6 = new ImageIcon(getClass().getResource("/images/user.png"));
		Image img6 = icon6.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon6 = new ImageIcon(img6);

		JButton btnCorreo = new JButton("Correo electrónico", scaledIcon6);
		btnCorreo.setSize(230, 50);
		btnCorreo.setLocation(20, 650);
		btnCorreo.setFont(new Font("Arial", Font.BOLD, 20));
		btnCorreo.setOpaque(false);
		btnCorreo.setBorder(null);
		btnCorreo.setBackground(Color.decode("#ad3813"));
		btnCorreo.setForeground(Color.white);
		btnCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCorreo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCorreo.setVerticalTextPosition(SwingConstants.CENTER);
		btnCorreo.setIconTextGap(10);
		btnCorreo.setFocusPainted(false);
		opciones.add(btnCorreo);

		// Boton de correo electronico
		ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/logout.png"));
		Image img7 = icon7.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon7 = new ImageIcon(img7);

		JButton btnCerrar = new JButton("Cerrar sesión", scaledIcon7);
		btnCerrar.setSize(230, 50);
		btnCerrar.setLocation(10, 720);
		btnCerrar.setFont(new Font("Arial", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// PANEL PRINCIPAL

		// Etiqueta de titulo
		JLabel Titulo = new JLabel("Panel de control");
		Titulo.setBounds(350, -10, 250, 100);
		Titulo.setFont(new Font("Arial", Font.BOLD, 26));
		contenido.add(Titulo);

		// Boton de pendiente
		RoundedButton btnPendiente = new RoundedButton("Pendiente", 20);
		btnPendiente.setSize(250, 200);
		btnPendiente.setLocation(340, 160);
		btnPendiente.setBackground(Color.decode("#DC542B"));
		btnPendiente.setFont(new Font("Arial", Font.BOLD, 20));
		btnPendiente.setForeground(Color.white);
		contenido.add(btnPendiente);

		// Boton de preparandd
		RoundedButton btnPreparado = new RoundedButton("Preparando", 20) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DC542B"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.dispose();
			}
		};
		btnPreparado.setSize(250, 200);
		btnPreparado.setLocation(620, 160);
		btnPreparado.setFont(new Font("Arial", Font.BOLD, 20));
		btnPreparado.setForeground(Color.decode("#DC542B"));
		btnPreparado.setBackground(Color.WHITE);
		contenido.add(btnPreparado);

		// Boton de entregados
		RoundedButton btnEntregado = new RoundedButton("Entregado", 20);
		btnEntregado.setSize(250, 200);
		btnEntregado.setLocation(900, 160);
		btnEntregado.setBackground(Color.decode("#DC542B"));
		btnEntregado.setFont(new Font("Arial", Font.BOLD, 20));
		btnEntregado.setForeground(Color.white);
		contenido.add(btnEntregado);

		// Panel que dibuja la gráfica de pastel
		JPanel grafica = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;

				// Datos de los platillos
				int[] valores = { 40, 25, 15, 10, 10 };
				Color[] colores = { Color.GREEN, Color.RED, Color.YELLOW, Color.BLUE, Color.ORANGE };
				String[] nombres = { "Tacos", "Sopes", "Pozole rojo", "Enchiladas", "Pozole verde" };

				// Calcular total
				int total = 0;
				for (int v : valores)
					total += v;

				// Dibujar pastel
				int startAngle = 0;
				for (int i = 0; i < valores.length; i++) {
					int arcAngle = (int) Math.round(360.0 * valores[i] / total);
					g2.setColor(colores[i]);
					g2.fillArc(50, 50, 200, 200, startAngle, arcAngle);
					startAngle += arcAngle;
				}

				// leyenda a la derecha
				int y = 80;
				int x = 280;
				for (int i = 0; i < nombres.length; i++) {
					g2.setColor(colores[i]);
					g2.fillRect(x, y, 20, 20);
					g2.setColor(Color.BLACK);
					g2.drawString(nombres[i], x + 30, y + 15);
					y += 30;
				}

				// Título
				g2.setFont(new Font("Arial", Font.BOLD, 18));
				g2.drawString("Platillos más vendidos", 50, 30);
			}
		};
		grafica.setBounds(530, 400, 400, 300);
		contenido.add(grafica);

	}

	public void platillos() {

		// Panel con imagen de fondo
		JPanel opciones = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/sidebar.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

			}

		};

		opciones.setBackground(Color.decode("#FEF9F3"));
		opciones.setLayout(null);
		opciones.setSize(270, 800);
		this.add(opciones);

		// Panel principal
		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setSize(1200, 800);
		contenido.setBackground(Color.decode("#FEF9F3"));
		this.add(contenido);

		JPanel linea = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea.setBounds(0, 100, 270, 1);
		linea.setOpaque(false);
		opciones.add(linea);

		JPanel linea1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea1.setBounds(0, 620, 270, 1);
		linea1.setOpaque(false);
		opciones.add(linea1);

		// Añadir Componentes

		// Logo
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/LOGO SIDEBAR.png"));
		Image img = icon.getImage().getScaledInstance(220, 80, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		JLabel iconLabel = new JLabel(scaledIcon);
		iconLabel.setSize(220, 80);
		iconLabel.setLocation(30, 10);
		iconLabel.setAlignmentX(CENTER_ALIGNMENT);
		iconLabel.setAlignmentY(CENTER_ALIGNMENT);
		opciones.add(iconLabel);

		// Boton de panel de control
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/dashboard.png"));
		Image img1 = icon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(img1);

		JButton btnControl = new JButton("Panel de control", scaledIcon1);
		btnControl.setSize(200, 50);
		btnControl.setLocation(30, 160);
		btnControl.setFont(new Font("Arial", Font.BOLD, 16));
		btnControl.setOpaque(false);
		btnControl.setBorder(null);
		btnControl.setBackground(Color.decode("#ad3813"));
		btnControl.setForeground(Color.white);
		btnControl.setHorizontalAlignment(SwingConstants.LEFT); // alinea todo el contenido a la izquierda
		btnControl.setHorizontalTextPosition(SwingConstants.RIGHT); // texto a la derecha del icono
		btnControl.setVerticalTextPosition(SwingConstants.CENTER); // texto centrado verticalmente
		btnControl.setIconTextGap(10);
		btnControl.setFocusPainted(false);

		btnControl.addActionListener(e -> {
			router("panelControl");
		});

		opciones.add(btnControl);

		// Boton de platillos
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/platillos.png"));
		Image img2 = icon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(img2);

		JButton btnPlatillos = new JButton("Platillos", scaledIcon2);
		btnPlatillos.setSize(200, 50);
		btnPlatillos.setLocation(30, 250);
		btnPlatillos.setFont(new Font("Arial", Font.BOLD, 16));
		btnPlatillos.setOpaque(false);
		btnPlatillos.setBorder(null);
		btnPlatillos.setBackground(Color.decode("#ad3813"));
		btnPlatillos.setForeground(Color.white);
		btnPlatillos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPlatillos.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPlatillos.setVerticalTextPosition(SwingConstants.CENTER);
		btnPlatillos.setIconTextGap(10);
		btnPlatillos.setFocusPainted(false);

		btnPlatillos.addActionListener(e -> {
			router("platillos");
		});
		opciones.add(btnPlatillos);

		// Boton de ordenes
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/órdenes.png"));
		Image img3 = icon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon3 = new ImageIcon(img3);

		JButton btnOrdenes = new JButton("Órdenes", scaledIcon3);
		btnOrdenes.setSize(200, 50);
		btnOrdenes.setLocation(30, 340);
		btnOrdenes.setFont(new Font("Arial", Font.BOLD, 16));
		btnOrdenes.setOpaque(false);
		btnOrdenes.setBorder(null);
		btnOrdenes.setBackground(Color.decode("#ad3813"));
		btnOrdenes.setForeground(Color.white);
		btnOrdenes.setHorizontalAlignment(SwingConstants.LEFT);
		btnOrdenes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnOrdenes.setVerticalTextPosition(SwingConstants.CENTER);
		btnOrdenes.setIconTextGap(10);
		btnOrdenes.setFocusPainted(false);

		btnOrdenes.addActionListener(e -> {
			router("ordenes");
		});

		opciones.add(btnOrdenes);

		// Boton de clientes
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/clientes.png"));
		Image img4 = icon4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(img4);

		JButton btnClientes = new JButton("Clientes", scaledIcon4);
		btnClientes.setSize(200, 50);
		btnClientes.setLocation(30, 430);
		btnClientes.setFont(new Font("Arial", Font.BOLD, 16));
		btnClientes.setOpaque(false);
		btnClientes.setBorder(null);
		btnClientes.setBackground(Color.decode("#ad3813"));
		btnClientes.setForeground(Color.white);
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnClientes.setVerticalTextPosition(SwingConstants.CENTER);
		btnClientes.setIconTextGap(10);
		btnClientes.setFocusPainted(false);

		btnClientes.addActionListener(e -> {
			router("clientes");
		});

		opciones.add(btnClientes);

		// Boton de clientes
		ImageIcon icon5 = new ImageIcon(getClass().getResource("/images/inventario.png"));
		Image img5 = icon5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon5 = new ImageIcon(img5);

		JButton btnInventario = new JButton("Inventario", scaledIcon5);
		btnInventario.setSize(200, 50);
		btnInventario.setLocation(30, 520);
		btnInventario.setFont(new Font("Arial", Font.BOLD, 16));
		btnInventario.setOpaque(false);
		btnInventario.setBorder(null);
		btnInventario.setBackground(Color.decode("#ad3813"));
		btnInventario.setForeground(Color.white);
		btnInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnInventario.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnInventario.setVerticalTextPosition(SwingConstants.CENTER);
		btnInventario.setIconTextGap(10);
		btnInventario.setFocusPainted(false);

		btnInventario.addActionListener(e -> {
			router("inventario");
		});

		opciones.add(btnInventario);

		// Boton de correo electronico
		ImageIcon icon6 = new ImageIcon(getClass().getResource("/images/user.png"));
		Image img6 = icon6.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon6 = new ImageIcon(img6);

		JButton btnCorreo = new JButton("Correo electrónico", scaledIcon6);
		btnCorreo.setSize(230, 50);
		btnCorreo.setLocation(20, 650);
		btnCorreo.setFont(new Font("Arial", Font.BOLD, 20));
		btnCorreo.setOpaque(false);
		btnCorreo.setBorder(null);
		btnCorreo.setBackground(Color.decode("#ad3813"));
		btnCorreo.setForeground(Color.white);
		btnCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCorreo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCorreo.setVerticalTextPosition(SwingConstants.CENTER);
		btnCorreo.setIconTextGap(10);
		btnCorreo.setFocusPainted(false);
		opciones.add(btnCorreo);

		// Boton de correo electronico
		ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/logout.png"));
		Image img7 = icon7.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon7 = new ImageIcon(img7);

		JButton btnCerrar = new JButton("Cerrar sesión", scaledIcon7);
		btnCerrar.setSize(230, 50);
		btnCerrar.setLocation(10, 720);
		btnCerrar.setFont(new Font("Arial", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// PANEL PRINCIPAL

		// Etiqueta de titulo
		JLabel Titulo = new JLabel("Platillos");
		Titulo.setBounds(350, -10, 250, 100);
		Titulo.setFont(new Font("Arial", Font.BOLD, 26));
		contenido.add(Titulo);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("+ Agregar platillo", 40);
		btnAgregar.setSize(250, 50);
		btnAgregar.setLocation(900, 70);
		btnAgregar.setBackground(Color.decode("#DC542B"));
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 26));
		btnAgregar.setForeground(Color.white);

		btnAgregar.addActionListener(e -> {
			router("agregarPlatillo");
		});

		contenido.add(btnAgregar);

		// Datos
		String[] columnas = { "Foto", "Nombre", "Categoría", "Precio", "Estado", "Acciones" };
		Object[][] datos = { { "/images/pozole.jpg", "Pozole verde", "Pozoles", "$125", "Disponible", "" },
				{ "/images/tacos pastor.jpg", "Tacos al pastor", "Tacos", "$85", "Agotado", "" },
				{ "/images/enchiladas.jpg", "Enchiladas rojas", "Enchiladas", "$105", "Disponible", "" },
				{ "/images/sopes.jpg", "Sopes", "Sopes", "$115", "Disponible", "" } };

		// Modelo de tabla
		DefaultTableModel modeloPlatillos = new DefaultTableModel(datos, columnas) {
			@Override
			public boolean isCellEditable(int r, int c) {
				return c == 5;
			}
		};

		JTable tabla = new JTable(modeloPlatillos);

		// Estetica
		tabla.setRowHeight(110);
		tabla.setShowGrid(false);
		tabla.setBackground(Color.WHITE);
		tabla.setIntercellSpacing(new Dimension(0, 0));
		tabla.setSelectionBackground(new Color(250, 248, 245));

		// Encabezado
		JTableHeader header = tabla.getTableHeader();
		header.setPreferredSize(new Dimension(0, 50));
		header.setBackground(new Color(245, 240, 230));
		header.setForeground(new Color(100, 100, 100));
		header.setFont(new Font("SansSerif", Font.BOLD, 14));
		header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

		// Renderer
		tabla.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				try {
					java.net.URL imgURL = getClass().getResource(v.toString());
					if (imgURL != null) {
						ImageIcon icon = new ImageIcon(imgURL);
						Image img = icon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
						return new JLabel(new ImageIcon(img), JLabel.CENTER);
					}
				} catch (Exception e) {
				}
				return new JLabel("No image", JLabel.CENTER);
			}
		});

		// Renderer
		tabla.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				JLabel lbl = new JLabel(v.toString(), SwingConstants.CENTER);
				lbl.setOpaque(true);
				lbl.setFont(new Font("SansSerif", Font.BOLD, 12));
				lbl.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

				if ("Disponible".equals(v)) {
					lbl.setBackground(Color.decode("#EAEFE4"));
					lbl.setForeground(Color.decode("#558B2F"));
				} else if ("Agotado".equals(v)) {
					lbl.setBackground(Color.decode("#FAEAEA"));
					lbl.setForeground(Color.decode("#C62828"));
				}

				JPanel p = new JPanel(new GridBagLayout());
				p.setBackground(Color.WHITE);
				p.add(lbl);
				return p;
			}
		});

		// Clase panel
		class PanelBotones extends JPanel {
			JButton btnVer, btnEdit, btnDel;

			public PanelBotones() {
				setLayout(new FlowLayout(FlowLayout.CENTER, 10, 40));
				setBackground(Color.WHITE);

				btnVer = crearBoton("/images/detalles.png");
				btnEdit = crearBoton("/images/editar.png");
				btnDel = crearBoton("/images/borrar.png");

				add(btnVer);
				add(btnEdit);
				add(btnDel);
			}

			private JButton crearBoton(String ruta) {
				JButton btn;
				try {
					ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
					Image img = icon.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
					btn = new JButton(new ImageIcon(img));
				} catch (Exception e) {
					btn = new JButton("?");
				}
				btn.setPreferredSize(new Dimension(30, 30));
				btn.setContentAreaFilled(false);
				btn.setBorderPainted(false);
				btn.setFocusPainted(false);
				btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				return btn;
			}
		}

		tabla.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				return new PanelBotones();
			}
		});

		tabla.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
			PanelBotones botones = new PanelBotones();

			@Override
			public Component getTableCellEditorComponent(JTable t, Object v, boolean s, int r, int c) {
				botones.btnDel.addActionListener(e -> {
					stopCellEditing();
					((DefaultTableModel) t.getModel()).removeRow(r);
				});
				return botones;
			}

			@Override
			public Object getCellEditorValue() {
				return "";
			}
		});

		// Alineacion final
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 1; i < 4; i++)
			tabla.getColumnModel().getColumn(i).setCellRenderer(centro);

		// Integracion panel
		JScrollPane scrollPlatillos = new JScrollPane(tabla);
		scrollPlatillos.setBounds(350, 150, 800, 550);
		scrollPlatillos.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		scrollPlatillos.getViewport().setBackground(Color.WHITE);

		contenido.add(scrollPlatillos);

	}

	public void ordenes() {
		// Panel con imagen de fondo
		JPanel opciones = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/sidebar.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

			}

		};

		opciones.setBackground(Color.decode("#FEF9F3"));
		opciones.setLayout(null);
		opciones.setSize(270, 800);
		this.add(opciones);

		// Panel principal
		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setSize(1200, 800);
		contenido.setBackground(Color.decode("#FEF9F3"));
		this.add(contenido);

		JPanel linea = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea.setBounds(0, 100, 270, 1);
		linea.setOpaque(false);
		opciones.add(linea);

		JPanel linea1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea1.setBounds(0, 620, 270, 1);
		linea1.setOpaque(false);
		opciones.add(linea1);

		// Añadir Componentes

		// Logo
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/LOGO SIDEBAR.png"));
		Image img = icon.getImage().getScaledInstance(220, 80, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		JLabel iconLabel = new JLabel(scaledIcon);
		iconLabel.setSize(220, 80);
		iconLabel.setLocation(30, 10);
		iconLabel.setAlignmentX(CENTER_ALIGNMENT);
		iconLabel.setAlignmentY(CENTER_ALIGNMENT);
		opciones.add(iconLabel);

		// Boton de panel de control
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/dashboard.png"));
		Image img1 = icon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(img1);

		JButton btnControl = new JButton("Panel de control", scaledIcon1);
		btnControl.setSize(200, 50);
		btnControl.setLocation(30, 160);
		btnControl.setFont(new Font("Arial", Font.BOLD, 16));
		btnControl.setOpaque(false);
		btnControl.setBorder(null);
		btnControl.setBackground(Color.decode("#ad3813"));
		btnControl.setForeground(Color.white);
		btnControl.setHorizontalAlignment(SwingConstants.LEFT); // alinea todo el contenido a la izquierda
		btnControl.setHorizontalTextPosition(SwingConstants.RIGHT); // texto a la derecha del icono
		btnControl.setVerticalTextPosition(SwingConstants.CENTER); // texto centrado verticalmente
		btnControl.setIconTextGap(10);
		btnControl.setFocusPainted(false);

		btnControl.addActionListener(e -> {
			router("panelControl");
		});

		opciones.add(btnControl);

		// Boton de platillos
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/platillos.png"));
		Image img2 = icon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(img2);

		JButton btnPlatillos = new JButton("Platillos", scaledIcon2);
		btnPlatillos.setSize(200, 50);
		btnPlatillos.setLocation(30, 250);
		btnPlatillos.setFont(new Font("Arial", Font.BOLD, 16));
		btnPlatillos.setOpaque(false);
		btnPlatillos.setBorder(null);
		btnPlatillos.setBackground(Color.decode("#ad3813"));
		btnPlatillos.setForeground(Color.white);
		btnPlatillos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPlatillos.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPlatillos.setVerticalTextPosition(SwingConstants.CENTER);
		btnPlatillos.setIconTextGap(10);
		btnPlatillos.setFocusPainted(false);

		btnPlatillos.addActionListener(e -> {
			router("platillos");
		});
		opciones.add(btnPlatillos);

		// Boton de ordenes
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/órdenes.png"));
		Image img3 = icon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon3 = new ImageIcon(img3);

		JButton btnOrdenes = new JButton("Órdenes", scaledIcon3);
		btnOrdenes.setSize(200, 50);
		btnOrdenes.setLocation(30, 340);
		btnOrdenes.setFont(new Font("Arial", Font.BOLD, 16));
		btnOrdenes.setOpaque(false);
		btnOrdenes.setBorder(null);
		btnOrdenes.setBackground(Color.decode("#ad3813"));
		btnOrdenes.setForeground(Color.white);
		btnOrdenes.setHorizontalAlignment(SwingConstants.LEFT);
		btnOrdenes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnOrdenes.setVerticalTextPosition(SwingConstants.CENTER);
		btnOrdenes.setIconTextGap(10);
		btnOrdenes.setFocusPainted(false);

		btnOrdenes.addActionListener(e -> {
			router("ordenes");
		});

		opciones.add(btnOrdenes);

		// Boton de clientes
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/clientes.png"));
		Image img4 = icon4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(img4);

		JButton btnClientes = new JButton("Clientes", scaledIcon4);
		btnClientes.setSize(200, 50);
		btnClientes.setLocation(30, 430);
		btnClientes.setFont(new Font("Arial", Font.BOLD, 16));
		btnClientes.setOpaque(false);
		btnClientes.setBorder(null);
		btnClientes.setBackground(Color.decode("#ad3813"));
		btnClientes.setForeground(Color.white);
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnClientes.setVerticalTextPosition(SwingConstants.CENTER);
		btnClientes.setIconTextGap(10);
		btnClientes.setFocusPainted(false);

		btnClientes.addActionListener(e -> {
			router("clientes");
		});

		opciones.add(btnClientes);

		// Boton de clientes
		ImageIcon icon5 = new ImageIcon(getClass().getResource("/images/inventario.png"));
		Image img5 = icon5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon5 = new ImageIcon(img5);

		JButton btnInventario = new JButton("Inventario", scaledIcon5);
		btnInventario.setSize(200, 50);
		btnInventario.setLocation(30, 520);
		btnInventario.setFont(new Font("Arial", Font.BOLD, 16));
		btnInventario.setOpaque(false);
		btnInventario.setBorder(null);
		btnInventario.setBackground(Color.decode("#ad3813"));
		btnInventario.setForeground(Color.white);
		btnInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnInventario.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnInventario.setVerticalTextPosition(SwingConstants.CENTER);
		btnInventario.setIconTextGap(10);
		btnInventario.setFocusPainted(false);

		btnInventario.addActionListener(e -> {
			router("inventario");
		});

		opciones.add(btnInventario);

		// Boton de correo electronico
		ImageIcon icon6 = new ImageIcon(getClass().getResource("/images/user.png"));
		Image img6 = icon6.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon6 = new ImageIcon(img6);

		JButton btnCorreo = new JButton("Correo electrónico", scaledIcon6);
		btnCorreo.setSize(230, 50);
		btnCorreo.setLocation(20, 650);
		btnCorreo.setFont(new Font("Arial", Font.BOLD, 20));
		btnCorreo.setOpaque(false);
		btnCorreo.setBorder(null);
		btnCorreo.setBackground(Color.decode("#ad3813"));
		btnCorreo.setForeground(Color.white);
		btnCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCorreo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCorreo.setVerticalTextPosition(SwingConstants.CENTER);
		btnCorreo.setIconTextGap(10);
		btnCorreo.setFocusPainted(false);
		opciones.add(btnCorreo);

		// Boton de correo electronico
		ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/logout.png"));
		Image img7 = icon7.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon7 = new ImageIcon(img7);

		JButton btnCerrar = new JButton("Cerrar sesión", scaledIcon7);
		btnCerrar.setSize(230, 50);
		btnCerrar.setLocation(10, 720);
		btnCerrar.setFont(new Font("Arial", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// PANEL PRINCIPAL

		// Etiqueta de titulo
		JLabel Titulo = new JLabel("Ordenes");
		Titulo.setBounds(350, -10, 250, 100);
		Titulo.setFont(new Font("Arial", Font.BOLD, 26));
		contenido.add(Titulo);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("+ Nueva orden", 40);
		btnAgregar.setSize(250, 50);
		btnAgregar.setLocation(900, 70);
		btnAgregar.setBackground(Color.decode("#DC542B"));
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 26));
		btnAgregar.setForeground(Color.white);
		contenido.add(btnAgregar);

		// Datos
		String[] colOrdenes = { "#", "Cliente", "Fecha", "Total", "Estado", "Acciones" };
		Object[][] datosOrdenes = { { "#1", "Grady Rodríguez", "5 de abril, 2026", "$355", "Preparando", "" },
				{ "#2", "Marta Meza", "5 de abril, 2026", "$85", "Entregado", "" },
				{ "#3", "Salma Castillo", "5 de abril, 2026", "$240", "Listo", "" } };

		// Permite edicion columna 5
		DefaultTableModel modeloOrdenes = new DefaultTableModel(datosOrdenes, colOrdenes) {
			@Override
			public boolean isCellEditable(int r, int c) {
				return c == 5;
			}
		};

		JTable tablaOrdenes = new JTable(modeloOrdenes);
		tablaOrdenes.setRowHeight(60);
		tablaOrdenes.setShowGrid(false);
		tablaOrdenes.setBackground(Color.WHITE);

		// Encabrzado
		JTableHeader headerO = tablaOrdenes.getTableHeader();
		headerO.setPreferredSize(new Dimension(0, 45));
		headerO.setBackground(new Color(245, 240, 230));
		headerO.setForeground(new Color(100, 100, 100));
		headerO.setFont(new Font("SansSerif", Font.BOLD, 13));

		// Renderer de estado pills
		tablaOrdenes.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				JLabel label = new JLabel(v.toString(), SwingConstants.CENTER);
				label.setOpaque(true);
				label.setFont(new Font("SansSerif", Font.BOLD, 11));
				label.setBorder(BorderFactory.createEmptyBorder(4, 12, 4, 12));

				if ("Preparando".equals(v)) {
					label.setBackground(Color.decode("#FAEAEA"));
					label.setForeground(Color.decode("#C62828"));
				} else if ("Entregado".equals(v)) {
					label.setBackground(Color.decode("#F5F0E9"));
					label.setForeground(Color.decode("#8D6E53"));
				} else if ("Listo".equals(v)) {
					label.setBackground(Color.decode("#EAEFE4"));
					label.setForeground(Color.decode("#558B2F"));
				}

				JPanel p = new JPanel(new GridBagLayout());
				p.setBackground(Color.WHITE);
				p.add(label);
				return p;
			}
		});

		// Renderer y editor de acciones
		class AccionesOrdenes extends JPanel {
			JButton btnVer, btnEdit, btnDel;

			public AccionesOrdenes() {
				setLayout(new FlowLayout(FlowLayout.CENTER, 8, 15));
				setBackground(Color.WHITE);
				btnVer = crearBoton("/images/detalles.png");
				btnEdit = crearBoton("/images/editar.png");
				btnDel = crearBoton("/images/borrar.png");
				add(btnVer);
				add(btnEdit);
				add(btnDel);
			}

			private JButton crearBoton(String ruta) {
				JButton btn;
				try {
					ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
					btn = new JButton(new ImageIcon(icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
				} catch (Exception e) {
					btn = new JButton("?");
				}
				btn.setPreferredSize(new Dimension(25, 25));
				btn.setContentAreaFilled(false);
				btn.setBorderPainted(false);
				btn.setFocusPainted(false);
				btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				return btn;
			}
		}

		// Aplicar renderer
		tablaOrdenes.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				return new AccionesOrdenes();
			}
		});

		// Aplicar editor
		tablaOrdenes.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
			AccionesOrdenes botones = new AccionesOrdenes();

			@Override
			public Component getTableCellEditorComponent(JTable t, Object v, boolean s, int r, int c) {
				// Remover ActionListeners viejos para que no se acumulen
				for (java.awt.event.ActionListener al : botones.btnDel.getActionListeners())
					botones.btnDel.removeActionListener(al);

				botones.btnDel.addActionListener(e -> {
					stopCellEditing();
					int confirm = JOptionPane.showConfirmDialog(t, "¿Eliminar orden " + t.getValueAt(r, 0) + "?");
					if (confirm == JOptionPane.YES_OPTION) {
						((DefaultTableModel) t.getModel()).removeRow(r);
					}
				});
				return botones;
			}

			@Override
			public Object getCellEditorValue() {
				return "";
			}
		});

		// Centrar texto
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i <= 3; i++) {
			tablaOrdenes.getColumnModel().getColumn(i).setCellRenderer(centro);
		}

		// Agregar panel
		JScrollPane scroll = new JScrollPane(tablaOrdenes);
		scroll.setBounds(350, 150, 800, 300);
		scroll.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		scroll.getViewport().setBackground(Color.WHITE);

		contenido.add(scroll);

	}

	public void clientes() {
		// Panel con imagen de fondo
		JPanel opciones = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/sidebar.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

			}

		};

		opciones.setBackground(Color.decode("#FEF9F3"));
		opciones.setLayout(null);
		opciones.setSize(270, 800);
		this.add(opciones);

		// Panel principal
		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setSize(1200, 800);
		contenido.setBackground(Color.decode("#FEF9F3"));
		this.add(contenido);

		JPanel linea = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea.setBounds(0, 100, 270, 1);
		linea.setOpaque(false);
		opciones.add(linea);

		JPanel linea1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea1.setBounds(0, 620, 270, 1);
		linea1.setOpaque(false);
		opciones.add(linea1);

		// Añadir Componentes

		// Logo
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/LOGO SIDEBAR.png"));
		Image img = icon.getImage().getScaledInstance(220, 80, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		JLabel iconLabel = new JLabel(scaledIcon);
		iconLabel.setSize(220, 80);
		iconLabel.setLocation(30, 10);
		iconLabel.setAlignmentX(CENTER_ALIGNMENT);
		iconLabel.setAlignmentY(CENTER_ALIGNMENT);
		opciones.add(iconLabel);

		// Boton de panel de control
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/dashboard.png"));
		Image img1 = icon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(img1);

		JButton btnControl = new JButton("Panel de control", scaledIcon1);
		btnControl.setSize(200, 50);
		btnControl.setLocation(30, 160);
		btnControl.setFont(new Font("Arial", Font.BOLD, 16));
		btnControl.setOpaque(false);
		btnControl.setBorder(null);
		btnControl.setBackground(Color.decode("#ad3813"));
		btnControl.setForeground(Color.white);
		btnControl.setHorizontalAlignment(SwingConstants.LEFT); // alinea todo el contenido a la izquierda
		btnControl.setHorizontalTextPosition(SwingConstants.RIGHT); // texto a la derecha del icono
		btnControl.setVerticalTextPosition(SwingConstants.CENTER); // texto centrado verticalmente
		btnControl.setIconTextGap(10);
		btnControl.setFocusPainted(false);

		btnControl.addActionListener(e -> {
			router("panelControl");
		});

		opciones.add(btnControl);

		// Boton de platillos
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/platillos.png"));
		Image img2 = icon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(img2);

		JButton btnPlatillos = new JButton("Platillos", scaledIcon2);
		btnPlatillos.setSize(200, 50);
		btnPlatillos.setLocation(30, 250);
		btnPlatillos.setFont(new Font("Arial", Font.BOLD, 16));
		btnPlatillos.setOpaque(false);
		btnPlatillos.setBorder(null);
		btnPlatillos.setBackground(Color.decode("#ad3813"));
		btnPlatillos.setForeground(Color.white);
		btnPlatillos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPlatillos.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPlatillos.setVerticalTextPosition(SwingConstants.CENTER);
		btnPlatillos.setIconTextGap(10);
		btnPlatillos.setFocusPainted(false);

		btnPlatillos.addActionListener(e -> {
			router("platillos");
		});
		opciones.add(btnPlatillos);

		// Boton de ordenes
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/órdenes.png"));
		Image img3 = icon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon3 = new ImageIcon(img3);

		JButton btnOrdenes = new JButton("Órdenes", scaledIcon3);
		btnOrdenes.setSize(200, 50);
		btnOrdenes.setLocation(30, 340);
		btnOrdenes.setFont(new Font("Arial", Font.BOLD, 16));
		btnOrdenes.setOpaque(false);
		btnOrdenes.setBorder(null);
		btnOrdenes.setBackground(Color.decode("#ad3813"));
		btnOrdenes.setForeground(Color.white);
		btnOrdenes.setHorizontalAlignment(SwingConstants.LEFT);
		btnOrdenes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnOrdenes.setVerticalTextPosition(SwingConstants.CENTER);
		btnOrdenes.setIconTextGap(10);
		btnOrdenes.setFocusPainted(false);

		btnOrdenes.addActionListener(e -> {
			router("ordenes");
		});

		opciones.add(btnOrdenes);

		// Boton de clientes
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/clientes.png"));
		Image img4 = icon4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(img4);

		JButton btnClientes = new JButton("Clientes", scaledIcon4);
		btnClientes.setSize(200, 50);
		btnClientes.setLocation(30, 430);
		btnClientes.setFont(new Font("Arial", Font.BOLD, 16));
		btnClientes.setOpaque(false);
		btnClientes.setBorder(null);
		btnClientes.setBackground(Color.decode("#ad3813"));
		btnClientes.setForeground(Color.white);
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnClientes.setVerticalTextPosition(SwingConstants.CENTER);
		btnClientes.setIconTextGap(10);
		btnClientes.setFocusPainted(false);

		btnClientes.addActionListener(e -> {
			router("clientes");
		});

		opciones.add(btnClientes);

		// Boton de clientes
		ImageIcon icon5 = new ImageIcon(getClass().getResource("/images/inventario.png"));
		Image img5 = icon5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon5 = new ImageIcon(img5);

		JButton btnInventario = new JButton("Inventario", scaledIcon5);
		btnInventario.setSize(200, 50);
		btnInventario.setLocation(30, 520);
		btnInventario.setFont(new Font("Arial", Font.BOLD, 16));
		btnInventario.setOpaque(false);
		btnInventario.setBorder(null);
		btnInventario.setBackground(Color.decode("#ad3813"));
		btnInventario.setForeground(Color.white);
		btnInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnInventario.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnInventario.setVerticalTextPosition(SwingConstants.CENTER);
		btnInventario.setIconTextGap(10);
		btnInventario.setFocusPainted(false);

		btnInventario.addActionListener(e -> {
			router("inventario");
		});

		opciones.add(btnInventario);

		// Boton de correo electronico
		ImageIcon icon6 = new ImageIcon(getClass().getResource("/images/user.png"));
		Image img6 = icon6.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon6 = new ImageIcon(img6);

		JButton btnCorreo = new JButton("Correo electrónico", scaledIcon6);
		btnCorreo.setSize(230, 50);
		btnCorreo.setLocation(20, 650);
		btnCorreo.setFont(new Font("Arial", Font.BOLD, 20));
		btnCorreo.setOpaque(false);
		btnCorreo.setBorder(null);
		btnCorreo.setBackground(Color.decode("#ad3813"));
		btnCorreo.setForeground(Color.white);
		btnCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCorreo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCorreo.setVerticalTextPosition(SwingConstants.CENTER);
		btnCorreo.setIconTextGap(10);
		btnCorreo.setFocusPainted(false);
		opciones.add(btnCorreo);

		// Boton de correo electronico
		ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/logout.png"));
		Image img7 = icon7.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon7 = new ImageIcon(img7);

		JButton btnCerrar = new JButton("Cerrar sesión", scaledIcon7);
		btnCerrar.setSize(230, 50);
		btnCerrar.setLocation(10, 720);
		btnCerrar.setFont(new Font("Arial", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// PANEL PRINCIPAL

		// Etiqueta de titulo
		JLabel Titulo = new JLabel("Clientes");
		Titulo.setBounds(350, -10, 250, 100);
		Titulo.setFont(new Font("Arial", Font.BOLD, 26));
		contenido.add(Titulo);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("+ Agregar cliente", 40);
		btnAgregar.setSize(250, 50);
		btnAgregar.setLocation(900, 70);
		btnAgregar.setBackground(Color.decode("#DC542B"));
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 26));
		btnAgregar.setForeground(Color.white);
		contenido.add(btnAgregar);

		// Tabla

		// Datos
		String[] columnasClientes = { "Nombre", "Email", "Teléfono", "Dirección", "Acciones" };
		Object[][] datosClientes = { { "Grady Rodríguez", "grady4217@gmail.com", "5512345678", "1 dirección", "" },
				{ "Marta Meza", "martahabla67@gmail.com", "5523456789", "1 dirección", "" },
				{ "Salma castillo", "sss.alma@gmail.com", "5534567890", "2 direcciones", "" } };

		// Modelo de tabla
		DefaultTableModel modeloClientes = new DefaultTableModel(datosClientes, columnasClientes) {
			@Override
			public boolean isCellEditable(int r, int c) {
				return c == 4;
			}
		};

		JTable tablaClientes = new JTable(modeloClientes);

		// Estetica
		tablaClientes.setRowHeight(65);
		tablaClientes.setShowGrid(false);
		tablaClientes.setBackground(Color.WHITE);
		tablaClientes.setIntercellSpacing(new Dimension(0, 0));
		tablaClientes.setSelectionBackground(new Color(250, 248, 245));

		// Encabezado
		JTableHeader headerC = tablaClientes.getTableHeader();
		headerC.setPreferredSize(new Dimension(0, 50));
		headerC.setBackground(new Color(245, 240, 230));
		headerC.setForeground(new Color(100, 100, 100));
		headerC.setFont(new Font("SansSerif", Font.BOLD, 14));
		headerC.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

		// Centrado de texto
		DefaultTableCellRenderer centroC = new DefaultTableCellRenderer();
		centroC.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i <= 3; i++) {
			tablaClientes.getColumnModel().getColumn(i).setCellRenderer(centroC);
		}

		// Panel para las acciones
		class AccionesClientes extends JPanel {
			JButton btnVer, btnEdit, btnDel;

			public AccionesClientes() {
				setLayout(new FlowLayout(FlowLayout.CENTER, 10, 18));
				setBackground(Color.WHITE);

				btnVer = crearBoton("/images/detalles.png");
				btnEdit = crearBoton("/images/editar.png");
				btnDel = crearBoton("/images/borrar.png");

				add(btnVer);
				add(btnEdit);
				add(btnDel);
			}

			private JButton crearBoton(String ruta) {
				JButton btn;
				try {
					ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
					Image img = icon.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
					btn = new JButton(new ImageIcon(img));
				} catch (Exception e) {
					btn = new JButton("?");
				}
				btn.setPreferredSize(new Dimension(28, 28));
				btn.setContentAreaFilled(false);
				btn.setBorderPainted(false);
				btn.setFocusPainted(false);
				btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				return btn;
			}
		}

		// Asignar renderer
		tablaClientes.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				return new AccionesClientes();
			}
		});

		tablaClientes.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
			AccionesClientes botones = new AccionesClientes();

			@Override
			public Component getTableCellEditorComponent(JTable t, Object v, boolean s, int r, int c) {
				for (java.awt.event.ActionListener al : botones.btnDel.getActionListeners())
					botones.btnDel.removeActionListener(al);
				botones.btnDel.addActionListener(e -> {
					stopCellEditing();
					int confirm = JOptionPane.showConfirmDialog(t, "¿Eliminar a " + t.getValueAt(r, 0) + "?");
					if (confirm == JOptionPane.YES_OPTION) {
						((DefaultTableModel) t.getModel()).removeRow(r);
					}
				});
				return botones;
			}

			@Override
			public Object getCellEditorValue() {
				return "";
			}
		});

		// Agregar al panel
		JScrollPane scrollClientes = new JScrollPane(tablaClientes);
		scrollClientes.setBounds(350, 200, 800, 300);
		scrollClientes.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		scrollClientes.getViewport().setBackground(Color.WHITE);
		contenido.add(scrollClientes);
	}

	public void inventario() {
		// Panel con imagen de fondo
		JPanel opciones = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/sidebar.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

			}

		};

		opciones.setBackground(Color.decode("#FEF9F3"));
		opciones.setLayout(null);
		opciones.setSize(270, 800);
		this.add(opciones);

		// Panel principal
		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setSize(1200, 800);
		contenido.setBackground(Color.decode("#FEF9F3"));
		this.add(contenido);

		JPanel linea = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea.setBounds(0, 100, 270, 1);
		linea.setOpaque(false);
		opciones.add(linea);

		JPanel linea1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea1.setBounds(0, 620, 270, 1);
		linea1.setOpaque(false);
		opciones.add(linea1);

		// Añadir Componentes

		// Logo
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/LOGO SIDEBAR.png"));
		Image img = icon.getImage().getScaledInstance(220, 80, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		JLabel iconLabel = new JLabel(scaledIcon);
		iconLabel.setSize(220, 80);
		iconLabel.setLocation(30, 10);
		iconLabel.setAlignmentX(CENTER_ALIGNMENT);
		iconLabel.setAlignmentY(CENTER_ALIGNMENT);
		opciones.add(iconLabel);

		// Boton de panel de control
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/dashboard.png"));
		Image img1 = icon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(img1);

		JButton btnControl = new JButton("Panel de control", scaledIcon1);
		btnControl.setSize(200, 50);
		btnControl.setLocation(30, 160);
		btnControl.setFont(new Font("Arial", Font.BOLD, 16));
		btnControl.setOpaque(false);
		btnControl.setBorder(null);
		btnControl.setBackground(Color.decode("#ad3813"));
		btnControl.setForeground(Color.white);
		btnControl.setHorizontalAlignment(SwingConstants.LEFT); // alinea todo el contenido a la izquierda
		btnControl.setHorizontalTextPosition(SwingConstants.RIGHT); // texto a la derecha del icono
		btnControl.setVerticalTextPosition(SwingConstants.CENTER); // texto centrado verticalmente
		btnControl.setIconTextGap(10);
		btnControl.setFocusPainted(false);

		btnControl.addActionListener(e -> {
			router("panelControl");
		});

		opciones.add(btnControl);

		// Boton de platillos
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/platillos.png"));
		Image img2 = icon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(img2);

		JButton btnPlatillos = new JButton("Platillos", scaledIcon2);
		btnPlatillos.setSize(200, 50);
		btnPlatillos.setLocation(30, 250);
		btnPlatillos.setFont(new Font("Arial", Font.BOLD, 16));
		btnPlatillos.setOpaque(false);
		btnPlatillos.setBorder(null);
		btnPlatillos.setBackground(Color.decode("#ad3813"));
		btnPlatillos.setForeground(Color.white);
		btnPlatillos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPlatillos.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPlatillos.setVerticalTextPosition(SwingConstants.CENTER);
		btnPlatillos.setIconTextGap(10);
		btnPlatillos.setFocusPainted(false);

		btnPlatillos.addActionListener(e -> {
			router("platillos");
		});
		opciones.add(btnPlatillos);

		// Boton de ordenes
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/órdenes.png"));
		Image img3 = icon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon3 = new ImageIcon(img3);

		JButton btnOrdenes = new JButton("Órdenes", scaledIcon3);
		btnOrdenes.setSize(200, 50);
		btnOrdenes.setLocation(30, 340);
		btnOrdenes.setFont(new Font("Arial", Font.BOLD, 16));
		btnOrdenes.setOpaque(false);
		btnOrdenes.setBorder(null);
		btnOrdenes.setBackground(Color.decode("#ad3813"));
		btnOrdenes.setForeground(Color.white);
		btnOrdenes.setHorizontalAlignment(SwingConstants.LEFT);
		btnOrdenes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnOrdenes.setVerticalTextPosition(SwingConstants.CENTER);
		btnOrdenes.setIconTextGap(10);
		btnOrdenes.setFocusPainted(false);

		btnOrdenes.addActionListener(e -> {
			router("ordenes");
		});

		opciones.add(btnOrdenes);

		// Boton de clientes
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/clientes.png"));
		Image img4 = icon4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(img4);

		JButton btnClientes = new JButton("Clientes", scaledIcon4);
		btnClientes.setSize(200, 50);
		btnClientes.setLocation(30, 430);
		btnClientes.setFont(new Font("Arial", Font.BOLD, 16));
		btnClientes.setOpaque(false);
		btnClientes.setBorder(null);
		btnClientes.setBackground(Color.decode("#ad3813"));
		btnClientes.setForeground(Color.white);
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnClientes.setVerticalTextPosition(SwingConstants.CENTER);
		btnClientes.setIconTextGap(10);
		btnClientes.setFocusPainted(false);

		btnClientes.addActionListener(e -> {
			router("clientes");
		});

		opciones.add(btnClientes);

		// Boton de clientes
		ImageIcon icon5 = new ImageIcon(getClass().getResource("/images/inventario.png"));
		Image img5 = icon5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon5 = new ImageIcon(img5);

		JButton btnInventario = new JButton("Inventario", scaledIcon5);
		btnInventario.setSize(200, 50);
		btnInventario.setLocation(30, 520);
		btnInventario.setFont(new Font("Arial", Font.BOLD, 16));
		btnInventario.setOpaque(false);
		btnInventario.setBorder(null);
		btnInventario.setBackground(Color.decode("#ad3813"));
		btnInventario.setForeground(Color.white);
		btnInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnInventario.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnInventario.setVerticalTextPosition(SwingConstants.CENTER);
		btnInventario.setIconTextGap(10);
		btnInventario.setFocusPainted(false);

		btnInventario.addActionListener(e -> {
			router("inventario");
		});

		opciones.add(btnInventario);

		// Boton de correo electronico
		ImageIcon icon6 = new ImageIcon(getClass().getResource("/images/user.png"));
		Image img6 = icon6.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon6 = new ImageIcon(img6);

		JButton btnCorreo = new JButton("Correo electrónico", scaledIcon6);
		btnCorreo.setSize(230, 50);
		btnCorreo.setLocation(20, 650);
		btnCorreo.setFont(new Font("Arial", Font.BOLD, 20));
		btnCorreo.setOpaque(false);
		btnCorreo.setBorder(null);
		btnCorreo.setBackground(Color.decode("#ad3813"));
		btnCorreo.setForeground(Color.white);
		btnCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCorreo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCorreo.setVerticalTextPosition(SwingConstants.CENTER);
		btnCorreo.setIconTextGap(10);
		btnCorreo.setFocusPainted(false);
		opciones.add(btnCorreo);

		// Boton de correo electronico
		ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/logout.png"));
		Image img7 = icon7.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon7 = new ImageIcon(img7);

		JButton btnCerrar = new JButton("Cerrar sesión", scaledIcon7);
		btnCerrar.setSize(230, 50);
		btnCerrar.setLocation(10, 720);
		btnCerrar.setFont(new Font("Arial", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// PANEL PRINCIPAL

		// Etiqueta de titulo
		JLabel Titulo = new JLabel("Inventario");
		Titulo.setBounds(350, -10, 250, 100);
		Titulo.setFont(new Font("Arial", Font.BOLD, 26));
		contenido.add(Titulo);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("+ Agregar ingredientes", 40);
		btnAgregar.setSize(350, 50);
		btnAgregar.setLocation(800, 70);
		btnAgregar.setBackground(Color.decode("#DC542B"));
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 26));
		btnAgregar.setForeground(Color.white);
		contenido.add(btnAgregar);

		// Subclase para botones redondeados
		class BotonConBorde extends RoundedButton {
			public BotonConBorde(String text, int radius) {
				super(text, radius);
			}

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				//
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#E8E2DD"));
				g2.setStroke(new BasicStroke(2));

				g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 40, 40);

				g2.dispose();
			}
		}

		// Boton 1
		BotonConBorde btnLimon = new BotonConBorde("Limón", 40);
		btnLimon.setBounds(340, 160, 200, 170);
		btnLimon.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnLimon.setHorizontalAlignment(SwingConstants.LEFT);
		btnLimon.setVerticalAlignment(SwingConstants.TOP);
		btnLimon.setMargin(new Insets(20, 25, 0, 0));
		btnLimon.setBackground(Color.WHITE);
		btnLimon.setLayout(null);
		contenido.add(btnLimon);

		JLabel textLimon = new JLabel("0 kg");
		textLimon.setBounds(25, 55, 100, 30);
		textLimon.setFont(new Font("SansSerif", Font.BOLD, 18));
		textLimon.setForeground(Color.GRAY);
		btnLimon.add(textLimon);

		JLabel textQuedan = new JLabel("Quedan: 0");
		textQuedan.setBounds(25, 110, 80, 20);
		textQuedan.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textQuedan.setForeground(Color.DARK_GRAY);
		btnLimon.add(textQuedan);

		JLabel textAgotado = new JLabel("Agotado");
		textAgotado.setBounds(110, 110, 80, 20);
		textAgotado.setFont(new Font("SansSerif", Font.BOLD, 13));
		textAgotado.setForeground(Color.decode("#C62828"));
		btnLimon.add(textAgotado);

		JPanel barraGris = new JPanel();
		barraGris.setBackground(Color.decode("#F5F0E6"));
		barraGris.setBounds(25, 140, 150, 6);
		btnLimon.add(barraGris);

		JLabel iconoAlerta = new JLabel();

		try {

			ImageIcon iconRaw = new ImageIcon(getClass().getResource("/images/agotado.png"));

			Image imgEscalada = iconRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			iconoAlerta.setIcon(new ImageIcon(imgEscalada));

		} catch (Exception e) {

		}

		iconoAlerta.setBounds(145, 22, 30, 30);
		btnLimon.add(iconoAlerta);

		// Boton 2
		BotonConBorde btnPollo = new BotonConBorde("Limón", 40);
		btnPollo.setBounds(540, 160, 200, 170);
		btnPollo.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnPollo.setHorizontalAlignment(SwingConstants.LEFT);
		btnPollo.setVerticalAlignment(SwingConstants.TOP);
		btnPollo.setMargin(new Insets(20, 25, 0, 0));
		btnPollo.setBackground(Color.WHITE);
		btnPollo.setLayout(null);
		contenido.add(btnPollo);

		JLabel textPollo = new JLabel("1.5 kg");
		textPollo.setBounds(25, 55, 100, 30);
		textPollo.setFont(new Font("SansSerif", Font.BOLD, 18));
		textPollo.setForeground(Color.GRAY);
		btnPollo.add(textPollo);

		JLabel textQuedan1 = new JLabel("Quedan: 1");
		textQuedan1.setBounds(25, 110, 80, 20);
		textQuedan1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textQuedan1.setForeground(Color.DARK_GRAY);
		btnPollo.add(textQuedan1);

		JLabel textAgotado1 = new JLabel("<html>Stock<br>bajo<br></html>");
		textAgotado1.setBounds(140, 95, 80, 40);
		textAgotado1.setFont(new Font("SansSerif", Font.BOLD, 13));
		textAgotado1.setForeground(Color.decode("#F57C00"));
		btnPollo.add(textAgotado1);

		JPanel barraNaranja = new JPanel();
		barraNaranja.setBackground(Color.decode("#F5F0E6"));
		barraNaranja.setBounds(25, 140, 150, 8);
		barraNaranja.setLayout(null);
		btnPollo.add(barraNaranja);

		JPanel barraProgreso = new JPanel();
		barraProgreso.setBackground(Color.decode("#F57C00"));
		barraProgreso.setBounds(0, 0, 45, 8);
		barraNaranja.add(barraProgreso);

		JLabel iconoAlerta1 = new JLabel();

		try {

			ImageIcon iconRaw = new ImageIcon(getClass().getResource("/images/bajo_stock.png"));

			Image imgEscalada = iconRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			iconoAlerta1.setIcon(new ImageIcon(imgEscalada));

		} catch (Exception e) {

		}

		iconoAlerta1.setBounds(145, 22, 30, 30);
		btnPollo.add(iconoAlerta1);

		// Boton 3
		BotonConBorde btnCebolla = new BotonConBorde("Cebolla", 40);
		btnCebolla.setBounds(740, 160, 200, 170);
		btnCebolla.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnCebolla.setHorizontalAlignment(SwingConstants.LEFT);
		btnCebolla.setVerticalAlignment(SwingConstants.TOP);
		btnCebolla.setMargin(new Insets(20, 25, 0, 0));
		btnCebolla.setBackground(Color.WHITE);
		btnCebolla.setLayout(null);
		contenido.add(btnCebolla);

		JLabel textCebolla = new JLabel("0.3 kg");
		textCebolla.setBounds(25, 55, 100, 30);
		textCebolla.setFont(new Font("SansSerif", Font.BOLD, 18));
		textCebolla.setForeground(Color.GRAY);
		btnCebolla.add(textCebolla);

		JLabel textQuedan2 = new JLabel("Quedan: 3");
		textQuedan2.setBounds(25, 110, 80, 20);
		textQuedan2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textQuedan2.setForeground(Color.DARK_GRAY);
		btnCebolla.add(textQuedan2);

		JLabel textAgotado2 = new JLabel("<html>Stock<br>bajo<br></html>");
		textAgotado2.setBounds(140, 95, 80, 40);
		textAgotado2.setFont(new Font("SansSerif", Font.BOLD, 13));
		textAgotado2.setForeground(Color.decode("#F57C00"));
		btnCebolla.add(textAgotado2);

		JPanel barraNaranja1 = new JPanel();
		barraNaranja1.setBackground(Color.decode("#F5F0E6"));
		barraNaranja1.setBounds(25, 140, 150, 8);
		barraNaranja1.setLayout(null);
		btnCebolla.add(barraNaranja1);

		JPanel barraProgreso2 = new JPanel();
		barraProgreso2.setBackground(Color.decode("#F57C00"));
		barraProgreso2.setBounds(0, 0, 45, 8);
		barraNaranja1.add(barraProgreso2);

		JLabel iconoAlerta2 = new JLabel();

		try {

			ImageIcon iconRaw = new ImageIcon(getClass().getResource("/images/bajo_stock.png"));

			Image imgEscalada = iconRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			iconoAlerta2.setIcon(new ImageIcon(imgEscalada));

		} catch (Exception e) {

		}

		iconoAlerta2.setBounds(145, 22, 30, 30);
		btnCebolla.add(iconoAlerta2);

		// Boton 3
		BotonConBorde btnTomate = new BotonConBorde("Tomate", 40);
		btnTomate.setBounds(940, 160, 200, 170);
		btnTomate.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnTomate.setHorizontalAlignment(SwingConstants.LEFT);
		btnTomate.setVerticalAlignment(SwingConstants.TOP);
		btnTomate.setMargin(new Insets(20, 25, 0, 0));
		btnTomate.setBackground(Color.WHITE);
		btnTomate.setLayout(null);
		contenido.add(btnTomate);

		JLabel textTomate = new JLabel("0.3 kg");
		textTomate.setBounds(25, 55, 100, 30);
		textTomate.setFont(new Font("SansSerif", Font.BOLD, 18));
		textTomate.setForeground(Color.GRAY);
		btnTomate.add(textTomate);

		JLabel textQuedan3 = new JLabel("Quedan: 3");
		textQuedan3.setBounds(25, 110, 80, 20);
		textQuedan3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textQuedan3.setForeground(Color.DARK_GRAY);
		btnTomate.add(textQuedan3);

		JLabel textAgotado3 = new JLabel("<html>Stock<br>bajo<br></html>");
		textAgotado3.setBounds(140, 95, 80, 40);
		textAgotado3.setFont(new Font("SansSerif", Font.BOLD, 13));
		textAgotado3.setForeground(Color.decode("#F57C00"));
		btnTomate.add(textAgotado3);

		JPanel barraNaranja2 = new JPanel();
		barraNaranja2.setBackground(Color.decode("#F5F0E6"));
		barraNaranja2.setBounds(25, 140, 150, 8);
		barraNaranja2.setLayout(null);
		btnTomate.add(barraNaranja2);

		JPanel barraProgreso3 = new JPanel();
		barraProgreso3.setBackground(Color.decode("#F57C00"));
		barraProgreso3.setBounds(0, 0, 45, 8);
		barraNaranja2.add(barraProgreso3);

		JLabel iconoAlerta3 = new JLabel();

		try {

			ImageIcon iconRaw = new ImageIcon(getClass().getResource("/images/bajo_stock.png"));

			Image imgEscalada = iconRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			iconoAlerta3.setIcon(new ImageIcon(imgEscalada));

		} catch (Exception e) {

		}

		iconoAlerta3.setBounds(145, 22, 30, 30);
		btnTomate.add(iconoAlerta3);

		// Datos
		String[] columnas = { "Nombre", "Cantidad", "Unidad", "Minimo", "Estado", "Acciones" };
		Object[][] datos = { { "Tortilla de maíz", "450", "Piezas", "500", "Suficiente", "" },
				{ "Limón", "0", "kg", "1", "Agotado", "" }, { "Pollo", "1", "kg", "10", "Stock bajo", "" },
				{ "Cebolla", "3", "kg", "1", "Stock bajo", "" } };

		// Modelo de tabla
		DefaultTableModel modeloPlatillos = new DefaultTableModel(datos, columnas) {
			@Override
			public boolean isCellEditable(int r, int c) {
				return c == 5;
			}
		};

		JTable tabla = new JTable(modeloPlatillos);

		// Estetica
		tabla.setRowHeight(60);
		tabla.setShowGrid(false);
		tabla.setBackground(Color.WHITE);
		tabla.setIntercellSpacing(new Dimension(0, 0));
		tabla.setSelectionBackground(new Color(250, 248, 245));

		// Encabezado
		JTableHeader header = tabla.getTableHeader();
		header.setPreferredSize(new Dimension(0, 50));
		header.setBackground(new Color(245, 240, 230));
		header.setForeground(new Color(100, 100, 100));
		header.setFont(new Font("SansSerif", Font.BOLD, 14));
		header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

		// Renderer
		tabla.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				JLabel lbl = new JLabel(v.toString(), SwingConstants.CENTER);
				lbl.setOpaque(true);
				lbl.setFont(new Font("SansSerif", Font.BOLD, 12));
				lbl.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

				if ("Suficiente".equals(v)) {
					lbl.setBackground(Color.decode("#EAEFE4"));
					lbl.setForeground(Color.decode("#558B2F"));
				} else if ("Agotado".equals(v)) {
					lbl.setBackground(Color.decode("#FAEAEA"));
					lbl.setForeground(Color.decode("#C62828"));
				} else if ("Stock bajo".equals(v)) {
					lbl.setBackground(Color.decode("#FEF2E6"));
					lbl.setForeground(Color.decode("#F57C00"));
				}

				JPanel p = new JPanel(new GridBagLayout());
				p.setBackground(Color.WHITE);
				p.add(lbl);
				return p;
			}
		});

		// Clase panel
		class PanelBotones extends JPanel {
			JButton btnVer, btnEdit, btnDel;

			public PanelBotones() {
				setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
				setBackground(Color.WHITE);

				btnVer = crearBoton("/images/detalles.png");
				btnEdit = crearBoton("/images/editar.png");
				btnDel = crearBoton("/images/borrar.png");

				add(btnVer);
				add(btnEdit);
				add(btnDel);
			}

			private JButton crearBoton(String ruta) {
				JButton btn;
				try {
					ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
					Image img = icon.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
					btn = new JButton(new ImageIcon(img));
				} catch (Exception e) {
					btn = new JButton("?");
				}
				btn.setPreferredSize(new Dimension(30, 30));
				btn.setContentAreaFilled(false);
				btn.setBorderPainted(false);
				btn.setFocusPainted(false);
				btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				return btn;
			}
		}

		tabla.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				return new PanelBotones();
			}
		});

		tabla.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
			PanelBotones botones = new PanelBotones();

			@Override
			public Component getTableCellEditorComponent(JTable t, Object v, boolean s, int r, int c) {
				botones.btnDel.addActionListener(e -> {
					stopCellEditing();
					((DefaultTableModel) t.getModel()).removeRow(r);
				});
				return botones;
			}

			@Override
			public Object getCellEditorValue() {
				return "";
			}
		});

		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i <= 3; i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(centro);
		}

		((DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		// Integracion panel
		JScrollPane scrollPlatillos = new JScrollPane(tabla);
		scrollPlatillos.setBounds(350, 350, 800, 350);
		scrollPlatillos.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		scrollPlatillos.getViewport().setBackground(Color.WHITE);

		contenido.add(scrollPlatillos);

	}

	public void agregarPlatillo() {
		// Panel con imagen de fondo
		JPanel opciones = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/sidebar.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

			}

		};

		opciones.setBackground(Color.decode("#FEF9F3"));
		opciones.setLayout(null);
		opciones.setSize(270, 800);
		this.add(opciones);

		// Panel principal
		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setSize(1200, 800);
		contenido.setBackground(Color.decode("#FEF9F3"));
		this.add(contenido);

		JPanel linea = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea.setBounds(0, 100, 270, 1);
		linea.setOpaque(false);
		opciones.add(linea);

		JPanel linea1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea1.setBounds(0, 620, 270, 1);
		linea1.setOpaque(false);
		opciones.add(linea1);

		// Añadir Componentes

		// Logo
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/LOGO SIDEBAR.png"));
		Image img = icon.getImage().getScaledInstance(220, 80, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		JLabel iconLabel = new JLabel(scaledIcon);
		iconLabel.setSize(220, 80);
		iconLabel.setLocation(30, 10);
		iconLabel.setAlignmentX(CENTER_ALIGNMENT);
		iconLabel.setAlignmentY(CENTER_ALIGNMENT);
		opciones.add(iconLabel);

		// Boton de panel de control
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/dashboard.png"));
		Image img1 = icon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(img1);

		JButton btnControl = new JButton("Panel de control", scaledIcon1);
		btnControl.setSize(200, 50);
		btnControl.setLocation(30, 160);
		btnControl.setFont(new Font("Arial", Font.BOLD, 16));
		btnControl.setOpaque(false);
		btnControl.setBorder(null);
		btnControl.setBackground(Color.decode("#ad3813"));
		btnControl.setForeground(Color.white);
		btnControl.setHorizontalAlignment(SwingConstants.LEFT); // alinea todo el contenido a la izquierda
		btnControl.setHorizontalTextPosition(SwingConstants.RIGHT); // texto a la derecha del icono
		btnControl.setVerticalTextPosition(SwingConstants.CENTER); // texto centrado verticalmente
		btnControl.setIconTextGap(10);
		btnControl.setFocusPainted(false);

		btnControl.addActionListener(e -> {
			router("panelControl");
		});

		opciones.add(btnControl);

		// Boton de platillos
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/platillos.png"));
		Image img2 = icon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(img2);

		JButton btnPlatillos = new JButton("Platillos", scaledIcon2);
		btnPlatillos.setSize(200, 50);
		btnPlatillos.setLocation(30, 250);
		btnPlatillos.setFont(new Font("Arial", Font.BOLD, 16));
		btnPlatillos.setOpaque(false);
		btnPlatillos.setBorder(null);
		btnPlatillos.setBackground(Color.decode("#ad3813"));
		btnPlatillos.setForeground(Color.white);
		btnPlatillos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPlatillos.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPlatillos.setVerticalTextPosition(SwingConstants.CENTER);
		btnPlatillos.setIconTextGap(10);
		btnPlatillos.setFocusPainted(false);

		btnPlatillos.addActionListener(e -> {
			router("platillos");
		});
		opciones.add(btnPlatillos);

		// Boton de ordenes
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/órdenes.png"));
		Image img3 = icon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon3 = new ImageIcon(img3);

		JButton btnOrdenes = new JButton("Órdenes", scaledIcon3);
		btnOrdenes.setSize(200, 50);
		btnOrdenes.setLocation(30, 340);
		btnOrdenes.setFont(new Font("Arial", Font.BOLD, 16));
		btnOrdenes.setOpaque(false);
		btnOrdenes.setBorder(null);
		btnOrdenes.setBackground(Color.decode("#ad3813"));
		btnOrdenes.setForeground(Color.white);
		btnOrdenes.setHorizontalAlignment(SwingConstants.LEFT);
		btnOrdenes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnOrdenes.setVerticalTextPosition(SwingConstants.CENTER);
		btnOrdenes.setIconTextGap(10);
		btnOrdenes.setFocusPainted(false);

		btnOrdenes.addActionListener(e -> {
			router("ordenes");
		});

		opciones.add(btnOrdenes);

		// Boton de clientes
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/clientes.png"));
		Image img4 = icon4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(img4);

		JButton btnClientes = new JButton("Clientes", scaledIcon4);
		btnClientes.setSize(200, 50);
		btnClientes.setLocation(30, 430);
		btnClientes.setFont(new Font("Arial", Font.BOLD, 16));
		btnClientes.setOpaque(false);
		btnClientes.setBorder(null);
		btnClientes.setBackground(Color.decode("#ad3813"));
		btnClientes.setForeground(Color.white);
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnClientes.setVerticalTextPosition(SwingConstants.CENTER);
		btnClientes.setIconTextGap(10);
		btnClientes.setFocusPainted(false);

		btnClientes.addActionListener(e -> {
			router("clientes");
		});

		opciones.add(btnClientes);

		// Boton de clientes
		ImageIcon icon5 = new ImageIcon(getClass().getResource("/images/inventario.png"));
		Image img5 = icon5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon5 = new ImageIcon(img5);

		JButton btnInventario = new JButton("Inventario", scaledIcon5);
		btnInventario.setSize(200, 50);
		btnInventario.setLocation(30, 520);
		btnInventario.setFont(new Font("Arial", Font.BOLD, 16));
		btnInventario.setOpaque(false);
		btnInventario.setBorder(null);
		btnInventario.setBackground(Color.decode("#ad3813"));
		btnInventario.setForeground(Color.white);
		btnInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnInventario.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnInventario.setVerticalTextPosition(SwingConstants.CENTER);
		btnInventario.setIconTextGap(10);
		btnInventario.setFocusPainted(false);

		btnInventario.addActionListener(e -> {
			router("inventario");
		});

		opciones.add(btnInventario);

		// Boton de correo electronico
		ImageIcon icon6 = new ImageIcon(getClass().getResource("/images/user.png"));
		Image img6 = icon6.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon6 = new ImageIcon(img6);

		JButton btnCorreo = new JButton("Correo electrónico", scaledIcon6);
		btnCorreo.setSize(230, 50);
		btnCorreo.setLocation(20, 650);
		btnCorreo.setFont(new Font("Arial", Font.BOLD, 20));
		btnCorreo.setOpaque(false);
		btnCorreo.setBorder(null);
		btnCorreo.setBackground(Color.decode("#ad3813"));
		btnCorreo.setForeground(Color.white);
		btnCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCorreo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCorreo.setVerticalTextPosition(SwingConstants.CENTER);
		btnCorreo.setIconTextGap(10);
		btnCorreo.setFocusPainted(false);
		opciones.add(btnCorreo);

		// Boton de correo electronico
		ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/logout.png"));
		Image img7 = icon7.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon7 = new ImageIcon(img7);

		JButton btnCerrar = new JButton("Cerrar sesión", scaledIcon7);
		btnCerrar.setSize(230, 50);
		btnCerrar.setLocation(10, 720);
		btnCerrar.setFont(new Font("Arial", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("<- Volver a platillos", 40);
		btnAgregar.setSize(250, 40);
		btnAgregar.setLocation(330, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("platillos");
		});

		contenido.add(btnAgregar);

		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();

				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int arc = 40;

				g2d.setColor(Color.WHITE);
				g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.setColor(Color.black);
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 700);
		panel.setLocation(305, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		JLabel textNuevoplatillo = new JLabel("Nuevo platillo");
		textNuevoplatillo.setSize(300, 50);
		textNuevoplatillo.setLocation(50, 40);
		textNuevoplatillo.setFont(new Font("Arial", Font.BOLD, 36));
		textNuevoplatillo.setOpaque(false);
		panel.add(textNuevoplatillo);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Nombre");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 110);
		tituloNombre.setFont(new Font("Arial", Font.BOLD, 20));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		RoundedTextField textNombre = new RoundedTextField(20, 20);
		textNombre.setSize(300, 40);
		textNombre.setLocation(50, 150);
		textNombre.setBackground(Color.decode("#E8E2DD"));
		textNombre.setOpaque(false);
		textNombre.setBorder(null);
		panel.add(textNombre);

		// Campo categoria
		JLabel tituloCategoria = new JLabel("Categoria");
		tituloCategoria.setSize(300, 40);
		tituloCategoria.setLocation(500, 110);
		tituloCategoria.setFont(new Font("Arial", Font.BOLD, 20));
		tituloCategoria.setOpaque(false);
		panel.add(tituloCategoria);

		RoundedTextField textCategoria = new RoundedTextField(20, 20);
		textCategoria.setSize(300, 40);
		textCategoria.setLocation(500, 150);
		textCategoria.setBackground(Color.decode("#E8E2DD"));
		textCategoria.setOpaque(false);
		textCategoria.setBorder(null);
		panel.add(textCategoria);

		// Campo descripcion
		JLabel tituloDescripcion = new JLabel("Descripción");
		tituloDescripcion.setSize(300, 200);
		tituloDescripcion.setLocation(50, 130);
		tituloDescripcion.setFont(new Font("Arial", Font.BOLD, 20));
		tituloDescripcion.setOpaque(false);
		panel.add(tituloDescripcion);

		RoundedTextArea textDescripcion = new RoundedTextArea(20);
		textDescripcion.setSize(750, 80);
		textDescripcion.setLocation(50, 250);
		textDescripcion.setBackground(Color.decode("#E8E2DD"));
		textDescripcion.setOpaque(false);
		textDescripcion.setBorder(null);
		panel.add(textDescripcion);

		// Campo precio
		JLabel tituloPrecio = new JLabel("Precio");
		tituloPrecio.setSize(300, 40);
		tituloPrecio.setLocation(50, 360);
		tituloPrecio.setFont(new Font("Arial", Font.BOLD, 20));
		tituloPrecio.setOpaque(false);
		panel.add(tituloPrecio);

		RoundedTextField textPrecio = new RoundedTextField(20, 20);
		textPrecio.setSize(300, 40);
		textPrecio.setLocation(50, 400);
		textPrecio.setBackground(Color.decode("#E8E2DD"));
		textPrecio.setOpaque(false);
		textPrecio.setBorder(null);
		panel.add(textPrecio);

		// Campo imagen
		JLabel tituloImagen = new JLabel("Imagen");
		tituloImagen.setSize(300, 40);
		tituloImagen.setLocation(500, 360);
		tituloImagen.setFont(new Font("Arial", Font.BOLD, 20));
		tituloImagen.setOpaque(false);
		panel.add(tituloImagen);

		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/upload.png"));
		Image img9 = icon9.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);

		JButton btnImagen = new JButton(scaledIcon9);
		btnImagen.setSize(80, 80);
		btnImagen.setLocation(500, 400);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		btnImagen.setForeground(Color.white);
		btnImagen.setIconTextGap(10);
		btnImagen.setFocusPainted(false);
		panel.add(btnImagen);

		// Campo ingrediente
		JLabel tituloIngredientes = new JLabel("Ingredientes");
		tituloIngredientes.setSize(300, 40);
		tituloIngredientes.setLocation(50, 550);
		tituloIngredientes.setFont(new Font("Arial", Font.BOLD, 26));
		tituloIngredientes.setOpaque(false);
		panel.add(tituloIngredientes);

		// Boton agregar ingrediente
		RoundedButton btnAgregaring = new RoundedButton("+ Agregar ingrediente", 20);
		btnAgregaring.setSize(250, 30);
		btnAgregaring.setLocation(500, 550);
		btnAgregaring.setBackground(Color.decode("#FFFFFF"));
		btnAgregaring.setOpaque(false);
		btnAgregaring.setFont(new Font("Arial", Font.BOLD, 20));
		btnAgregaring.setForeground(Color.decode("#DC542B"));
		panel.add(btnAgregaring);

		// Boton guardar cambio
		RoundedButton btnGuardar = new RoundedButton("Guardar cambio", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 630);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			router("platillos");
		});

		panel.add(btnGuardar);

		// Boton guardar cambio
		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(270, 630);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			router("platillos");
		});

		panel.add(btnCancelar);

	}

	public void editarPlatillo() {
		JPanel opciones = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/sidebar.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		opciones.setBackground(Color.decode("#FEF9F3"));
		opciones.setLayout(null);
		opciones.setBounds(0, 0, 270, 800);
		this.add(opciones);

		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setBackground(Color.decode("#FEF9F3"));
		contenido.setPreferredSize(new Dimension(930, 1200));

		JScrollPane scrollPrincipal = new JScrollPane(contenido);
		scrollPrincipal.setBounds(270, 0, 930, 800);
		scrollPrincipal.setBorder(null);
		scrollPrincipal.getViewport().setBackground(Color.decode("#FEF9F3"));
		scrollPrincipal.getVerticalScrollBar().setUnitIncrement(20);
		scrollPrincipal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		this.add(scrollPrincipal);

		JPanel linea = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea.setBounds(0, 100, 270, 1);
		linea.setOpaque(false);
		opciones.add(linea);

		JPanel linea1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea1.setBounds(0, 620, 270, 1);
		linea1.setOpaque(false);
		opciones.add(linea1);

		// Añadir Componentes

		// Logo
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/LOGO SIDEBAR.png"));
		Image img = icon.getImage().getScaledInstance(220, 80, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		JLabel iconLabel = new JLabel(scaledIcon);
		iconLabel.setSize(220, 80);
		iconLabel.setLocation(30, 10);
		iconLabel.setAlignmentX(CENTER_ALIGNMENT);
		iconLabel.setAlignmentY(CENTER_ALIGNMENT);
		opciones.add(iconLabel);

		// Boton de panel de control
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/dashboard.png"));
		Image img1 = icon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(img1);

		JButton btnControl = new JButton("Panel de control", scaledIcon1);
		btnControl.setSize(200, 50);
		btnControl.setLocation(30, 160);
		btnControl.setFont(new Font("Arial", Font.BOLD, 16));
		btnControl.setOpaque(false);
		btnControl.setBorder(null);
		btnControl.setBackground(Color.decode("#ad3813"));
		btnControl.setForeground(Color.white);
		btnControl.setHorizontalAlignment(SwingConstants.LEFT); // alinea todo el contenido a la izquierda
		btnControl.setHorizontalTextPosition(SwingConstants.RIGHT); // texto a la derecha del icono
		btnControl.setVerticalTextPosition(SwingConstants.CENTER); // texto centrado verticalmente
		btnControl.setIconTextGap(10);
		btnControl.setFocusPainted(false);

		btnControl.addActionListener(e -> {
			router("panelControl");
		});

		opciones.add(btnControl);

		// Boton de platillos
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/platillos.png"));
		Image img2 = icon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(img2);

		JButton btnPlatillos = new JButton("Platillos", scaledIcon2);
		btnPlatillos.setSize(200, 50);
		btnPlatillos.setLocation(30, 250);
		btnPlatillos.setFont(new Font("Arial", Font.BOLD, 16));
		btnPlatillos.setOpaque(false);
		btnPlatillos.setBorder(null);
		btnPlatillos.setBackground(Color.decode("#ad3813"));
		btnPlatillos.setForeground(Color.white);
		btnPlatillos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPlatillos.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPlatillos.setVerticalTextPosition(SwingConstants.CENTER);
		btnPlatillos.setIconTextGap(10);
		btnPlatillos.setFocusPainted(false);

		btnPlatillos.addActionListener(e -> {
			router("platillos");
		});
		opciones.add(btnPlatillos);

		// Boton de ordenes
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/órdenes.png"));
		Image img3 = icon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon3 = new ImageIcon(img3);

		JButton btnOrdenes = new JButton("Órdenes", scaledIcon3);
		btnOrdenes.setSize(200, 50);
		btnOrdenes.setLocation(30, 340);
		btnOrdenes.setFont(new Font("Arial", Font.BOLD, 16));
		btnOrdenes.setOpaque(false);
		btnOrdenes.setBorder(null);
		btnOrdenes.setBackground(Color.decode("#ad3813"));
		btnOrdenes.setForeground(Color.white);
		btnOrdenes.setHorizontalAlignment(SwingConstants.LEFT);
		btnOrdenes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnOrdenes.setVerticalTextPosition(SwingConstants.CENTER);
		btnOrdenes.setIconTextGap(10);
		btnOrdenes.setFocusPainted(false);

		btnOrdenes.addActionListener(e -> {
			router("ordenes");
		});

		opciones.add(btnOrdenes);

		// Boton de clientes
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/clientes.png"));
		Image img4 = icon4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(img4);

		JButton btnClientes = new JButton("Clientes", scaledIcon4);
		btnClientes.setSize(200, 50);
		btnClientes.setLocation(30, 430);
		btnClientes.setFont(new Font("Arial", Font.BOLD, 16));
		btnClientes.setOpaque(false);
		btnClientes.setBorder(null);
		btnClientes.setBackground(Color.decode("#ad3813"));
		btnClientes.setForeground(Color.white);
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnClientes.setVerticalTextPosition(SwingConstants.CENTER);
		btnClientes.setIconTextGap(10);
		btnClientes.setFocusPainted(false);

		btnClientes.addActionListener(e -> {
			router("clientes");
		});

		opciones.add(btnClientes);

		// Boton de clientes
		ImageIcon icon5 = new ImageIcon(getClass().getResource("/images/inventario.png"));
		Image img5 = icon5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon5 = new ImageIcon(img5);

		JButton btnInventario = new JButton("Inventario", scaledIcon5);
		btnInventario.setSize(200, 50);
		btnInventario.setLocation(30, 520);
		btnInventario.setFont(new Font("Arial", Font.BOLD, 16));
		btnInventario.setOpaque(false);
		btnInventario.setBorder(null);
		btnInventario.setBackground(Color.decode("#ad3813"));
		btnInventario.setForeground(Color.white);
		btnInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnInventario.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnInventario.setVerticalTextPosition(SwingConstants.CENTER);
		btnInventario.setIconTextGap(10);
		btnInventario.setFocusPainted(false);

		btnInventario.addActionListener(e -> {
			router("inventario");
		});

		opciones.add(btnInventario);

		// Boton de correo electronico
		ImageIcon icon6 = new ImageIcon(getClass().getResource("/images/user.png"));
		Image img6 = icon6.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon6 = new ImageIcon(img6);

		JButton btnCorreo = new JButton("Correo electrónico", scaledIcon6);
		btnCorreo.setSize(230, 50);
		btnCorreo.setLocation(20, 650);
		btnCorreo.setFont(new Font("Arial", Font.BOLD, 20));
		btnCorreo.setOpaque(false);
		btnCorreo.setBorder(null);
		btnCorreo.setBackground(Color.decode("#ad3813"));
		btnCorreo.setForeground(Color.white);
		btnCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCorreo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCorreo.setVerticalTextPosition(SwingConstants.CENTER);
		btnCorreo.setIconTextGap(10);
		btnCorreo.setFocusPainted(false);
		opciones.add(btnCorreo);

		// Boton de correo electronico
		ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/logout.png"));
		Image img7 = icon7.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon7 = new ImageIcon(img7);

		JButton btnCerrar = new JButton("Cerrar sesión", scaledIcon7);
		btnCerrar.setSize(230, 50);
		btnCerrar.setLocation(10, 720);
		btnCerrar.setFont(new Font("Arial", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("<- Volver a platillos", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("platillos");
		});

		contenido.add(btnAgregar);

		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();

				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int arc = 40;

				g2d.setColor(Color.WHITE);
				g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.setColor(Color.black);
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 1100);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		JLabel textNuevoplatillo = new JLabel("Nuevo platillo");
		textNuevoplatillo.setSize(300, 50);
		textNuevoplatillo.setLocation(50, 40);
		textNuevoplatillo.setFont(new Font("Arial", Font.BOLD, 36));
		textNuevoplatillo.setOpaque(false);
		panel.add(textNuevoplatillo);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Nombre");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 110);
		tituloNombre.setFont(new Font("Arial", Font.BOLD, 20));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		RoundedTextField textNombre = new RoundedTextField(20, 20);
		textNombre.setSize(300, 40);
		textNombre.setLocation(50, 150);
		//textNombre.setText("Tacos al pastor");
		//textNombre.setForeground(Color.gray);
		//textNombre.setFont(new Font("Arial", Font.BOLD, 20));
		//textNombre.setHorizontalAlignment(JTextField.CENTER);
		textNombre.setBackground(Color.decode("#E8E2DD"));
		textNombre.setOpaque(false);
		textNombre.setBorder(null);
		panel.add(textNombre);

		// Campo categoria
		JLabel tituloCategoria = new JLabel("Categoria");
		tituloCategoria.setSize(300, 40);
		tituloCategoria.setLocation(500, 110);
		tituloCategoria.setFont(new Font("Arial", Font.BOLD, 20));
		tituloCategoria.setOpaque(false);
		panel.add(tituloCategoria);

		RoundedTextField textCategoria = new RoundedTextField(20, 20);
		textCategoria.setSize(300, 40);
		textCategoria.setLocation(500, 150);
		textCategoria.setBackground(Color.decode("#E8E2DD"));
		textCategoria.setOpaque(false);
		textCategoria.setBorder(null);
		panel.add(textCategoria);

		// Campo descripcion
		JLabel tituloDescripcion = new JLabel("Descripción");
		tituloDescripcion.setSize(300, 200);
		tituloDescripcion.setLocation(50, 130);
		tituloDescripcion.setFont(new Font("Arial", Font.BOLD, 20));
		tituloDescripcion.setOpaque(false);
		panel.add(tituloDescripcion);

		RoundedTextArea textDescripcion = new RoundedTextArea(20);
		textDescripcion.setSize(750, 80);
		textDescripcion.setLocation(50, 250);
		textDescripcion.setBackground(Color.decode("#E8E2DD"));
		textDescripcion.setOpaque(false);
		textDescripcion.setBorder(null);
		panel.add(textDescripcion);

		// Campo precio
		JLabel tituloPrecio = new JLabel("Precio");
		tituloPrecio.setSize(300, 40);
		tituloPrecio.setLocation(50, 360);
		tituloPrecio.setFont(new Font("Arial", Font.BOLD, 20));
		tituloPrecio.setOpaque(false);
		panel.add(tituloPrecio);

		RoundedTextField textPrecio = new RoundedTextField(20, 20);
		textPrecio.setSize(300, 40);
		textPrecio.setLocation(50, 400);
		textPrecio.setBackground(Color.decode("#E8E2DD"));
		textPrecio.setOpaque(false);
		textPrecio.setBorder(null);
		panel.add(textPrecio);

		// Campo imagen
		JLabel tituloImagen = new JLabel("Imagen");
		tituloImagen.setSize(300, 40);
		tituloImagen.setLocation(500, 360);
		tituloImagen.setFont(new Font("Arial", Font.BOLD, 20));
		tituloImagen.setOpaque(false);
		panel.add(tituloImagen);

		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/upload.png"));
		Image img9 = icon9.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);

		JButton btnImagen = new JButton(scaledIcon9);
		btnImagen.setSize(80, 80);
		btnImagen.setLocation(500, 400);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		btnImagen.setForeground(Color.white);
		btnImagen.setIconTextGap(10);
		btnImagen.setFocusPainted(false);
		panel.add(btnImagen);

		// Campo ingrediente
		JLabel tituloIngredientes = new JLabel("Ingredientes");
		tituloIngredientes.setSize(300, 40);
		tituloIngredientes.setLocation(50, 530);
		tituloIngredientes.setFont(new Font("Arial", Font.BOLD, 26));
		tituloIngredientes.setOpaque(false);
		panel.add(tituloIngredientes);

		// Boton agregar ingrediente
		RoundedButton btnAgregaring = new RoundedButton("+ Agregar ingrediente", 20);
		btnAgregaring.setSize(250, 30);
		btnAgregaring.setLocation(500, 530);
		btnAgregaring.setBackground(Color.decode("#FFFFFF"));
		btnAgregaring.setOpaque(false);
		btnAgregaring.setFont(new Font("Arial", Font.BOLD, 20));
		btnAgregaring.setForeground(Color.decode("#DC542B"));
		panel.add(btnAgregaring);

		
		// Texto ingrediente tortilla
		RoundedTextField textIngTortilla = new RoundedTextField(20, 20);
		textIngTortilla.setSize(400, 60);
		textIngTortilla.setLocation(50, 625);
		//textIngTortilla.setText("Tortilla de maíz (piezas)");
		textIngTortilla.setForeground(Color.gray);
		textIngTortilla.setFont(new Font("Arial", Font.BOLD, 20));
		textIngTortilla.setHorizontalAlignment(JTextField.CENTER);
		textIngTortilla.setBackground(Color.decode("#E8E2DD"));
		textIngTortilla.setOpaque(false);
		textIngTortilla.setBorder(null);
		panel.add(textIngTortilla);

		RoundedTextField textNumTortilla = new RoundedTextField(20, 20);
		textNumTortilla.setSize(100, 60);
		textNumTortilla.setLocation(500, 625);
		//textNumTortilla.setText("3");
		textNumTortilla.setForeground(Color.gray);
		textNumTortilla.setFont(new Font("Arial", Font.BOLD, 20));
		textNumTortilla.setHorizontalAlignment(JTextField.CENTER);
		textNumTortilla.setBackground(Color.decode("#E8E2DD"));
		textNumTortilla.setOpaque(false);
		textNumTortilla.setBorder(null);
		panel.add(textNumTortilla);

		// Texto carne de res
		RoundedTextField textCarneRes = new RoundedTextField(20, 20);
		textCarneRes.setSize(400, 60);
		textCarneRes.setLocation(50, 725);
		//textCarneRes.setText("Carne de Res (Kg)");
		textCarneRes.setForeground(Color.gray);
		textCarneRes.setFont(new Font("Arial", Font.BOLD, 20));
		textCarneRes.setHorizontalAlignment(JTextField.CENTER);
		textCarneRes.setBackground(Color.decode("#E8E2DD"));
		textCarneRes.setOpaque(false);
		textCarneRes.setBorder(null);
		panel.add(textCarneRes);

		RoundedTextField textCarne = new RoundedTextField(20, 20);
		textCarne.setSize(100, 60);
		textCarne.setLocation(500, 725);
		//textCarne.setText("0.2");
		textCarne.setForeground(Color.gray);
		textCarne.setFont(new Font("Arial", Font.BOLD, 20));
		textCarne.setHorizontalAlignment(JTextField.CENTER);
		textCarne.setBackground(Color.decode("#E8E2DD"));
		textCarne.setOpaque(false);
		textCarne.setBorder(null);
		panel.add(textCarne);

		// Texto cebolla
		RoundedTextField textIngCebolla = new RoundedTextField(20, 20);
		textIngCebolla.setSize(400, 60);
		textIngCebolla.setLocation(50, 825);
		//textIngCebolla.setText("Cebolla (Kg)");
		textIngCebolla.setForeground(Color.gray);
		textIngCebolla.setFont(new Font("Arial", Font.BOLD, 20));
		textIngCebolla.setHorizontalAlignment(JTextField.CENTER);
		textIngCebolla.setBackground(Color.decode("#E8E2DD"));
		textIngCebolla.setOpaque(false);
		textIngCebolla.setBorder(null);
		panel.add(textIngCebolla);

		RoundedTextField textCebolla = new RoundedTextField(20, 20);
		textCebolla.setSize(100, 60);
		textCebolla.setLocation(500, 825);
		//textCebolla.setText("0.05");
		textCebolla.setForeground(Color.gray);
		textCebolla.setFont(new Font("Arial", Font.BOLD, 20));
		textCebolla.setHorizontalAlignment(JTextField.CENTER);
		textCebolla.setBackground(Color.decode("#E8E2DD"));
		textCebolla.setOpaque(false);
		textCebolla.setBorder(null);
		panel.add(textCebolla);

		// Texto cilantro
		RoundedTextField textIngCilantro = new RoundedTextField(20, 20);
		textIngCilantro.setSize(400, 60);
		textIngCilantro.setLocation(50, 925);
		//textIngCilantro.setText("Cilantro (manojo)");
		textIngCilantro.setForeground(Color.gray);
		textIngCilantro.setFont(new Font("Arial", Font.BOLD, 20));
		textIngCilantro.setHorizontalAlignment(JTextField.CENTER);
		textIngCilantro.setBackground(Color.decode("#E8E2DD"));
		textIngCilantro.setOpaque(false);
		textIngCilantro.setBorder(null);
		panel.add(textIngCilantro);

		RoundedTextField textCilantro = new RoundedTextField(20, 20);
		textCilantro.setSize(100, 60);
		textCilantro.setLocation(500, 925);
		//textCilantro.setText("0.02");
		textCilantro.setForeground(Color.gray);
		textCilantro.setFont(new Font("Arial", Font.BOLD, 20));
		textCilantro.setHorizontalAlignment(JTextField.CENTER);
		textCilantro.setBackground(Color.decode("#E8E2DD"));
		textCilantro.setOpaque(false);
		textCilantro.setBorder(null);
		panel.add(textCilantro);
		
		

		
		 RoundedButton btnGuardar = new RoundedButton("Guardar cambio", 20); 
		 btnGuardar.setSize(200, 50);
		 btnGuardar.setLocation(50, 1025);
		 btnGuardar.setBackground(Color.decode("#DC542B")); btnGuardar.setFont(new
		 Font("Arial", Font.BOLD, 20)); btnGuardar.setForeground(Color.white);
		 btnGuardar.addActionListener(e -> { router("platillos"); });
		 panel.add(btnGuardar);
		 

		 RoundedButton btnCancelar = new RoundedButton("Cancelar", 20); btnCancelar.setSize(150, 50);
		 btnCancelar.setLocation(270, 1025);
		 btnCancelar.setBackground(Color.decode("#E8E2DD")); btnCancelar.setFont(new
		 Font("Arial", Font.BOLD, 20)); btnCancelar.setForeground(Color.black);
		 btnCancelar.addActionListener(e -> { router("platillos"); });
		 panel.add(btnCancelar);
		 
	}

}
