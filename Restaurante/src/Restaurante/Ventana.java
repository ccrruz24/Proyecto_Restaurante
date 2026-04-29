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
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Float;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
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

	// Boton redondeado
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

		public RoundedButton(String text, int arc, Icon icon) {
			super(text, icon);
			setup(arc);
		}

		private void setup(int arc) {
			this.arc = arc;
			setOpaque(false);
			setBorderPainted(false);
			setFocusPainted(false);
			setContentAreaFilled(false);
			setHorizontalTextPosition(SwingConstants.RIGHT);
			setIconTextGap(10);
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

	// Campo de imagen boton redondeada
	public static class RoundedImageButton extends JButton {
		private int arc;

		public RoundedImageButton(ImageIcon icon, int arc) {
			super(icon);
			this.arc = arc;
			setContentAreaFilled(false);
			setBorderPainted(false);
			setFocusPainted(false);
			setOpaque(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			Float forma = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

			g2.setClip(forma);

			g2.setColor(getBackground());
			g2.fill(forma);

			super.paintComponent(g2);

			g2.dispose();
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
		// this.editarPlatilloTacosalpastor();
		// this.verPlatilloTacosalpastor();
		// this.verOrdenesGrady();
		// this.editarOrdenesGrady();
		// this.nuevaOrden();
		// this.verClientesGrady();
		// this.editarClienteGrady();
		// this.agregarCliente();
		// this.verInventarioTortilla();
		// this.editarInventarioTortilla();
		// this.agregarIngrediente();
		// this.verPlatilloEnchiladasrojas();
		// this.editarPlatilloEnchiladasrojas();
		// this.verOrdenesMarta();
		// this.editarOrdenesMarta();
		// this.verOrdenesSalma();
		 this.editarOrdenesSalma();

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

		// Rutas fijas	
		if (target.equals("inicioSesion")) this.inicioSesion();
	    else if (target.equals("registro")) this.registro();
	    else if (target.equals("panelControl")) this.panelControl();
	    else if (target.equals("platillos")) this.platillos();
	    else if (target.equals("ordenes")) this.ordenes();
	    else if (target.equals("clientes")) this.clientes();
	    else if (target.equals("inventario")) this.inventario();
		

	    else if (target.equals("agregarPlatillo")) {
	        this.agregarPlatillo();
	    }
	    else if (target.equals("editarPlatilloTacosalpastor")) {
	        this.editarPlatilloTacosalpastor();
	    }
		else if (target.equals("verPlatilloTacosalpastor")) {
	        this.verPlatilloTacosalpastor();
	    }
		
		else if (target.equals("verPlatilloEnchiladasrojas")) {
			this.verPlatilloEnchiladasrojas();
		}
		
		else if (target.equals("editarPlatilloEnchiladasrojas")) {
			this.editarPlatilloEnchiladasrojas();
		}

		else if (target.equals("verOrden1GradyRodríguez")) {
	        this.verOrdenesGrady(); 
	    }

		else if (target.equals("editarOrden1")) {
			this.editarOrdenesGrady();
		}
		
		else if (target.equals("verOrden2MartaMeza")) {
	        this.verOrdenesMarta(); 
	    }

		else if (target.equals("editarOrden2")) {
			this.editarOrdenesMarta();
		}
		
		else if (target.equals("verOrden3SalmaCastillo")) {
	        this.verOrdenesSalma(); 
	    }

		else if (target.equals("editarOrden3")) {
			this.editarOrdenesSalma();
		}

		else if (target.equals("nuevaOrden")) {
			this.nuevaOrden();
		}

		if (target.equals("verClientesGrady"))
			this.verClientesGrady();

		if (target.equals("editarClienteGrady"))
			this.editarClienteGrady();

		if (target.equals("agregarCliente"))
			this.agregarCliente();

		if (target.equals("verInventarioTortilla"))
			this.verInventarioTortilla();

		if (target.equals("editarInventarioTortilla"))
			this.editarInventarioTortilla();

		if (target.equals("agregarIngrediente"))
			this.agregarIngrediente();
		
		
		// Filtro dinamico para ver
		else if (target.startsWith("verPlatillo")) {
	        String nombre = target.replace("verPlatillo", "");
	        
	        if(nombre.equals("Tacosalpastor")) this.verPlatilloTacosalpastor();
	        else if(nombre.equals("Enchiladasrojas")) this.verPlatilloEnchiladasrojas();

	    } 
	    
	    // Filtro dinámico para editar
	    else if (target.startsWith("editarPlatillo")) {
	        String nombre = target.replace("editarPlatillo", "");
	        
	        if(nombre.equals("Tacosalpastor")) this.editarPlatilloTacosalpastor();
	        else if(nombre.equals("Enchiladasrojas")) this.editarPlatilloEnchiladasrojas();
	    }
	

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
		correo.setFont(new Font("belanosima", Font.BOLD, 20));
		panel.add(correo);

		// Cuadro de texto de correo
		RoundedTextField textCorreo = new RoundedTextField(20, 20);
		textCorreo.setSize(400, 50);
		textCorreo.setLocation(40, 185);
		textCorreo.setBackground(Color.decode("#FFB25B"));
		textCorreo.setFont(new Font("belanosima", Font.BOLD, 16));
		textCorreo.setOpaque(false);
		textCorreo.setBorder(null);
		panel.add(textCorreo);

		// Etiqueta de contraseña
		JLabel contra = new JLabel("Contraseña");
		contra.setBounds(40, 230, 200, 100);
		contra.setFont(new Font("belanosima", Font.BOLD, 20));
		panel.add(contra);

		// Cuadro de contraseña
		RoundedPasswordField textContra = new RoundedPasswordField(20, 20);
		textContra.setSize(400, 50);
		textContra.setLocation(40, 305);
		textContra.setBackground(Color.decode("#FFB25B"));
		textContra.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOlvido.setFont(new Font("belanosima", Font.BOLD, 14));
		panel.add(btnOlvido);

		// Boton de iniciar sesion
		RoundedButton btnInicio = new RoundedButton("Iniciar sesión", 20);
		btnInicio.setSize(250, 50);
		btnInicio.setLocation(115, 430);
		btnInicio.setBackground(Color.decode("#B6200D"));
		btnInicio.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnnoCuenta.setFont(new Font("belanosima", Font.BOLD, 16));
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
		nombre.setFont(new Font("belanosima", Font.BOLD, 20));
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
		apellido.setFont(new Font("belanosima", Font.BOLD, 20));
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
		correo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		contra.setFont(new Font("belanosima", Font.BOLD, 20));
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
		contra1.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnRegistro.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnsiCuenta.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		Titulo.setFont(new Font("belanosima", Font.BOLD, 26));
		contenido.add(Titulo);

		// Boton de pendiente
		RoundedButton btnPendiente = new RoundedButton("Pendiente", 20);
		btnPendiente.setSize(250, 200);
		btnPendiente.setLocation(340, 160);
		btnPendiente.setBackground(Color.decode("#DC542B"));
		btnPendiente.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnPreparado.setFont(new Font("belanosima", Font.BOLD, 20));
		btnPreparado.setForeground(Color.decode("#DC542B"));
		btnPreparado.setBackground(Color.WHITE);
		contenido.add(btnPreparado);

		// Boton de entregados
		RoundedButton btnEntregado = new RoundedButton("Entregado", 20);
		btnEntregado.setSize(250, 200);
		btnEntregado.setLocation(900, 160);
		btnEntregado.setBackground(Color.decode("#DC542B"));
		btnEntregado.setFont(new Font("belanosima", Font.BOLD, 20));
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
				g2.setFont(new Font("belanosima", Font.BOLD, 18));
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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		Titulo.setFont(new Font("belanosima", Font.BOLD, 26));
		contenido.add(Titulo);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("+ Agregar platillo", 40);
		btnAgregar.setSize(250, 50);
		btnAgregar.setLocation(900, 70);
		btnAgregar.setBackground(Color.decode("#DC542B"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 26));
		btnAgregar.setForeground(Color.white);

		btnAgregar.addActionListener(e -> {
			router("agregarPlatillo");
		});

		contenido.add(btnAgregar);

		// Datos
		String[] columnas = { "Foto", "Nombre", "Categoría", "Precio", "Estado", "Acciones" };
		Object[][] datos = { { "/images/pozole.jpg", "Pozole verde", "Pozoles", "$125", "Disponible", "" },
				{ "/images/tacos pastor.jpg", "Tacos al pastor", "Tacos", "$85", "Disponible", "" },
				{ "/images/enchiladas.jpg", "Enchiladas rojas", "Enchiladas", "$105", "No disponible", "" },
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
		header.setFont(new Font("belanosima", Font.BOLD, 14));
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
				lbl.setFont(new Font("belanosima", Font.BOLD, 12));
				lbl.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

				if ("Disponible".equals(v)) {
					lbl.setBackground(Color.decode("#EAEFE4"));
					lbl.setForeground(Color.decode("#558B2F"));
				} else if ("No disponible".equals(v)) {
					lbl.setBackground(Color.decode("#FAEAEA"));
					lbl.setForeground(Color.decode("#C62828"));
				}

				JPanel p = new JPanel(new GridBagLayout());
				p.setBackground(Color.WHITE);
				p.add(lbl);
				return p;
			}
		});

		class PanelBotones extends JPanel {
		    JButton btnVer, btnEdit, btnDel;

		    public PanelBotones(int fila, JTable tabla) { 
		        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 40));
		        setBackground(Color.WHITE);

		        btnVer = crearBoton("/images/detalles.png");
		        btnEdit = crearBoton("/images/editar.png");
		        btnDel = crearBoton("/images/borrar.png");

		        btnVer.addActionListener(e -> {
		            if (tabla.isEditing()) tabla.getCellEditor().stopCellEditing();

		            
		            String nombreRaw = tabla.getValueAt(fila, 1).toString(); 
		            String nombreLimpio = nombreRaw.replace(" ", "");		            
		            
		            router("verPlatillo" + nombreLimpio); 
		        });

		        btnEdit.addActionListener(e -> {
		            if (tabla.isEditing()) tabla.getCellEditor().stopCellEditing();

		            String nombreRaw = tabla.getValueAt(fila, 1).toString();
		            String nombreLimpio = nombreRaw.replace(" ", "");
		            
		            router("editarPlatillo" + nombreLimpio); 
		        });
		        
		        btnDel.addActionListener(e -> {
		            if (tabla.isEditing()) tabla.getCellEditor().stopCellEditing();
		            ((DefaultTableModel) tabla.getModel()).removeRow(fila);
		        });

		        add(btnVer); add(btnEdit); add(btnDel);

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
		        return new PanelBotones(r, t); 
		    }
		});
		
		tabla.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
		    @Override
		    public Component getTableCellEditorComponent(JTable t, Object v, boolean s, int r, int c) {
		        return new PanelBotones(r, t); 
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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		Titulo.setFont(new Font("belanosima", Font.BOLD, 26));
		contenido.add(Titulo);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("+ Nueva orden", 40);
		btnAgregar.setSize(250, 50);
		btnAgregar.setLocation(900, 70);
		btnAgregar.setBackground(Color.decode("#DC542B"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 26));
		btnAgregar.setForeground(Color.white);

		btnAgregar.addActionListener(e -> {
			router("nuevaOrden");
		});

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
		headerO.setFont(new Font("belanosima", Font.BOLD, 13));

		// Renderer de estado pills
		tablaOrdenes.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				JLabel label = new JLabel(v.toString(), SwingConstants.CENTER);
				label.setOpaque(true);
				label.setFont(new Font("belanosima", Font.BOLD, 11));
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

		    public AccionesOrdenes(int fila, JTable tabla) { // Recibe fila y tabla
		        setLayout(new FlowLayout(FlowLayout.CENTER, 8, 15));
		        setBackground(Color.WHITE);
		        btnVer = crearBoton("/images/detalles.png");
		        btnEdit = crearBoton("/images/editar.png");
		        btnDel = crearBoton("/images/borrar.png");

		        // BOTÓN VER 
		        btnVer.addActionListener(e -> {
		            if (tabla.isEditing()) tabla.getCellEditor().stopCellEditing();
		            
		            
		            String idOrden = tabla.getValueAt(fila, 0).toString().replace("#", ""); 
		            String cliente = tabla.getValueAt(fila, 1).toString().replace(" ", "");
		            
		            router("verOrden" + idOrden + cliente);
		        });

		        // BOTÓN EDITAR 
		        btnEdit.addActionListener(e -> {
		            if (tabla.isEditing()) tabla.getCellEditor().stopCellEditing();
		            String idOrden = tabla.getValueAt(fila, 0).toString().replace("#", "");
		            router("editarOrden" + idOrden);
		        });

		        add(btnVer);
		        add(btnEdit);
		        add(btnDel);
		    }

		    private JButton crearBoton(String ruta) {
		        JButton btn;
		        try {
		            ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
		            btn = new JButton(new ImageIcon(icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		        } catch (Exception e) { btn = new JButton("?"); }
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
		        return new AccionesOrdenes(r, t); // Pasamos r y t
		    }
		});

		// Aplicar editor
		tablaOrdenes.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
		    @Override
		    public Component getTableCellEditorComponent(JTable t, Object v, boolean s, int r, int c) {
		        AccionesOrdenes botones = new AccionesOrdenes(r, t); // Creamos panel con la fila actual
		        
		        // Configurar eliminar aquí mismo para mayor precisión
		        botones.btnDel.addActionListener(e -> {
		            stopCellEditing();
		            String id = t.getValueAt(r, 0).toString();
		            int confirm = JOptionPane.showConfirmDialog(t, "¿Eliminar orden " + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
		            if (confirm == JOptionPane.YES_OPTION) {
		                ((DefaultTableModel) t.getModel()).removeRow(r);
		            }
		        });
		        return botones;
		    }

		    @Override
		    public Object getCellEditorValue() { return ""; }
		});
			
			
		// Centrar texto
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i <= 3; i++) {
			tablaOrdenes.getColumnModel().getColumn(i).setCellRenderer(centro);
		}

		// Agregar panel
		JScrollPane scroll = new JScrollPane(tablaOrdenes);
		scroll.setBounds(350, 150, 800, 250);
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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		Titulo.setFont(new Font("belanosima", Font.BOLD, 26));
		contenido.add(Titulo);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("+ Agregar cliente", 40);
		btnAgregar.setSize(250, 50);
		btnAgregar.setLocation(900, 70);
		btnAgregar.setBackground(Color.decode("#DC542B"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 26));
		btnAgregar.setForeground(Color.white);

		btnAgregar.addActionListener(e -> {
			router("agregarCliente");
		});

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
		headerC.setFont(new Font("belanosima", Font.BOLD, 14));
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

				btnVer.addActionListener(e -> {
					router("verClientesGrady");
				});

				btnEdit.addActionListener(e -> {
					router("editarClienteGrady");
				});

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		Titulo.setFont(new Font("belanosima", Font.BOLD, 26));
		contenido.add(Titulo);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("+ Agregar ingredientes", 40);
		btnAgregar.setSize(350, 50);
		btnAgregar.setLocation(800, 70);
		btnAgregar.setBackground(Color.decode("#DC542B"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 26));
		btnAgregar.setForeground(Color.white);
		
		btnAgregar.addActionListener(e -> {
			router("agregarIngrediente");
		});
		
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
		btnLimon.setFont(new Font("belanosima", Font.BOLD, 22));
		btnLimon.setHorizontalAlignment(SwingConstants.LEFT);
		btnLimon.setVerticalAlignment(SwingConstants.TOP);
		btnLimon.setMargin(new Insets(20, 25, 0, 0));
		btnLimon.setBackground(Color.WHITE);
		btnLimon.setLayout(null);
		contenido.add(btnLimon);

		JLabel textLimon = new JLabel("0 kg");
		textLimon.setBounds(25, 55, 100, 30);
		textLimon.setFont(new Font("belanosima", Font.BOLD, 18));
		textLimon.setForeground(Color.GRAY);
		btnLimon.add(textLimon);

		JLabel textQuedan = new JLabel("Quedan: 0");
		textQuedan.setBounds(25, 110, 80, 20);
		textQuedan.setFont(new Font("belanosima", Font.PLAIN, 13));
		textQuedan.setForeground(Color.DARK_GRAY);
		btnLimon.add(textQuedan);

		JPanel barraNaranja = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.decode("#F5F0E6"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraNaranja.setOpaque(false);
		barraNaranja.setBounds(25, 140, 150, 8);
		barraNaranja.setLayout(null);
		btnLimon.add(barraNaranja);

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
		BotonConBorde btnPollo = new BotonConBorde("Pollo", 40);
		btnPollo.setBounds(540, 160, 200, 170);
		btnPollo.setFont(new Font("belanosima", Font.BOLD, 22));
		btnPollo.setHorizontalAlignment(SwingConstants.LEFT);
		btnPollo.setVerticalAlignment(SwingConstants.TOP);
		btnPollo.setMargin(new Insets(20, 25, 0, 0));
		btnPollo.setBackground(Color.WHITE);
		btnPollo.setLayout(null);
		contenido.add(btnPollo);

		JLabel textPollo = new JLabel("1.5 kg");
		textPollo.setBounds(25, 55, 100, 30);
		textPollo.setFont(new Font("belanosima", Font.BOLD, 18));
		textPollo.setForeground(Color.GRAY);
		btnPollo.add(textPollo);

		JLabel textQuedan1 = new JLabel("Quedan: 1");
		textQuedan1.setBounds(25, 110, 80, 20);
		textQuedan1.setFont(new Font("belanosima", Font.PLAIN, 13));
		textQuedan1.setForeground(Color.DARK_GRAY);
		btnPollo.add(textQuedan1);

		JLabel textAgotado1 = new JLabel("<html>Stock<br>bajo<br></html>");
		textAgotado1.setBounds(140, 95, 80, 40);
		textAgotado1.setFont(new Font("belanosima", Font.BOLD, 13));
		textAgotado1.setForeground(Color.decode("#F57C00"));
		btnPollo.add(textAgotado1);

		JPanel barraNaranja1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.decode("#F5F0E6"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraNaranja1.setOpaque(false);
		barraNaranja1.setBounds(25, 140, 150, 8);
		barraNaranja1.setLayout(null);
		btnPollo.add(barraNaranja1);

		JPanel barraProgreso1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#F57C00"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraProgreso1.setOpaque(false);
		barraProgreso1.setBounds(0, 0, 45, 8);
		barraNaranja1.add(barraProgreso1);

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
		btnCebolla.setFont(new Font("belanosima", Font.BOLD, 22));
		btnCebolla.setHorizontalAlignment(SwingConstants.LEFT);
		btnCebolla.setVerticalAlignment(SwingConstants.TOP);
		btnCebolla.setMargin(new Insets(20, 25, 0, 0));
		btnCebolla.setBackground(Color.WHITE);
		btnCebolla.setLayout(null);
		contenido.add(btnCebolla);

		JLabel textCebolla = new JLabel("0.3 kg");
		textCebolla.setBounds(25, 55, 100, 30);
		textCebolla.setFont(new Font("belanosima", Font.BOLD, 18));
		textCebolla.setForeground(Color.GRAY);
		btnCebolla.add(textCebolla);

		JLabel textQuedan2 = new JLabel("Quedan: 3");
		textQuedan2.setBounds(25, 110, 80, 20);
		textQuedan2.setFont(new Font("belanosima", Font.PLAIN, 13));
		textQuedan2.setForeground(Color.DARK_GRAY);
		btnCebolla.add(textQuedan2);

		JLabel textAgotado2 = new JLabel("<html>Stock<br>bajo<br></html>");
		textAgotado2.setBounds(140, 95, 80, 40);
		textAgotado2.setFont(new Font("belanosima", Font.BOLD, 13));
		textAgotado2.setForeground(Color.decode("#F57C00"));
		btnCebolla.add(textAgotado2);

		// barra de progreso
		JPanel barraNaranja2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.decode("#F5F0E6"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraNaranja2.setOpaque(false);
		barraNaranja2.setBounds(25, 140, 150, 8);
		barraNaranja2.setLayout(null);
		btnCebolla.add(barraNaranja2);

		JPanel barraProgreso2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#F57C00"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraProgreso2.setOpaque(false);
		barraProgreso2.setBounds(0, 0, 45, 8);
		barraNaranja2.add(barraProgreso2);

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
		btnTomate.setFont(new Font("belanosima", Font.BOLD, 22));
		btnTomate.setHorizontalAlignment(SwingConstants.LEFT);
		btnTomate.setVerticalAlignment(SwingConstants.TOP);
		btnTomate.setMargin(new Insets(20, 25, 0, 0));
		btnTomate.setBackground(Color.WHITE);
		btnTomate.setLayout(null);
		contenido.add(btnTomate);

		JLabel textTomate = new JLabel("0.3 kg");
		textTomate.setBounds(25, 55, 100, 30);
		textTomate.setFont(new Font("belanosima", Font.BOLD, 18));
		textTomate.setForeground(Color.GRAY);
		btnTomate.add(textTomate);

		JLabel textQuedan3 = new JLabel("Quedan: 3");
		textQuedan3.setBounds(25, 110, 80, 20);
		textQuedan3.setFont(new Font("belanosima", Font.PLAIN, 13));
		textQuedan3.setForeground(Color.DARK_GRAY);
		btnTomate.add(textQuedan3);

		JLabel textAgotado3 = new JLabel("<html>Stock<br>bajo<br></html>");
		textAgotado3.setBounds(140, 95, 80, 40);
		textAgotado3.setFont(new Font("belanosima", Font.BOLD, 13));
		textAgotado3.setForeground(Color.decode("#F57C00"));
		btnTomate.add(textAgotado3);

		// barra de progreso
		JPanel barraNaranja3 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.decode("#F5F0E6"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraNaranja3.setOpaque(false);
		barraNaranja3.setBounds(25, 140, 150, 8);
		barraNaranja3.setLayout(null);
		btnTomate.add(barraNaranja3);

		JPanel barraProgreso3 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#F57C00"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraProgreso3.setOpaque(false);
		barraProgreso3.setBounds(0, 0, 45, 8);
		barraNaranja3.add(barraProgreso3);

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
		header.setFont(new Font("belanosima", Font.BOLD, 14));
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

				btnVer.addActionListener(e -> {
					router("verInventarioTortilla");
				});

				btnEdit.addActionListener(e -> {
					router("editarInventarioTortilla");
				});

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
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

				g2d.setColor(Color.decode("#DEDEDE"));
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
		textNuevoplatillo.setFont(new Font("belanosima", Font.BOLD, 36));
		textNuevoplatillo.setOpaque(false);
		panel.add(textNuevoplatillo);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Nombre");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 110);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 20));
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
		tituloCategoria.setFont(new Font("belanosima", Font.BOLD, 20));
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
		tituloDescripcion.setFont(new Font("belanosima", Font.BOLD, 20));
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
		tituloPrecio.setFont(new Font("belanosima", Font.BOLD, 20));
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
		tituloImagen.setFont(new Font("belanosima", Font.BOLD, 20));
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
		tituloIngredientes.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloIngredientes.setOpaque(false);
		panel.add(tituloIngredientes);

		// Boton agregar ingrediente
		RoundedButton btnAgregaring = new RoundedButton("+ Agregar ingrediente", 20);
		btnAgregaring.setSize(250, 30);
		btnAgregaring.setLocation(500, 550);
		btnAgregaring.setBackground(Color.decode("#FFFFFF"));
		btnAgregaring.setOpaque(false);
		btnAgregaring.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregaring.setForeground(Color.decode("#DC542B"));
		panel.add(btnAgregaring);

		// Boton guardar cambio
		RoundedButton btnGuardar = new RoundedButton("Guardar cambio", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 630);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			router("platillos");
		});

		panel.add(btnCancelar);

	}

	public void editarPlatilloTacosalpastor() {
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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
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

				g2d.setColor(Color.decode("#DEDEDE"));
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

		JLabel textNuevoplatillo = new JLabel("Editar platillo");
		textNuevoplatillo.setSize(300, 50);
		textNuevoplatillo.setLocation(50, 40);
		textNuevoplatillo.setFont(new Font("belanosima", Font.BOLD, 36));
		textNuevoplatillo.setOpaque(false);
		panel.add(textNuevoplatillo);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Nombre");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 110);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		RoundedTextField textNombre = new RoundedTextField(20, 20);
		textNombre.setSize(300, 40);
		textNombre.setLocation(50, 150);
		textNombre.setText("Tacos al pastor");
		textNombre.setForeground(Color.gray);
		textNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		textNombre.setHorizontalAlignment(JTextField.CENTER);
		textNombre.setBackground(Color.decode("#E8E2DD"));
		textNombre.setOpaque(false);
		textNombre.setBorder(null);
		panel.add(textNombre);

		// Campo categoria
		JLabel tituloCategoria = new JLabel("Categoria");
		tituloCategoria.setSize(300, 40);
		tituloCategoria.setLocation(500, 110);
		tituloCategoria.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCategoria.setOpaque(false);
		panel.add(tituloCategoria);

		RoundedTextField textCategoria = new RoundedTextField(20, 20);
		textCategoria.setSize(300, 40);
		textCategoria.setLocation(500, 150);
		textCategoria.setText("Tacos");
		textCategoria.setForeground(Color.gray);
		textCategoria.setFont(new Font("belanosima", Font.BOLD, 20));
		textCategoria.setHorizontalAlignment(JTextField.CENTER);
		textCategoria.setBackground(Color.decode("#E8E2DD"));
		textCategoria.setOpaque(false);
		textCategoria.setBorder(null);
		panel.add(textCategoria);

		// Campo descripcion
		JLabel tituloDescripcion = new JLabel("Descripción");
		tituloDescripcion.setSize(300, 200);
		tituloDescripcion.setLocation(50, 130);
		tituloDescripcion.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDescripcion.setOpaque(false);
		panel.add(tituloDescripcion);

		RoundedTextArea textDescripcion = new RoundedTextArea(20);
		textDescripcion.setSize(750, 80);
		textDescripcion.setLocation(50, 250);
		textDescripcion.setText("Tres tacos con carne de pastor, cilantro, cebolla y piña");
		textDescripcion.setForeground(Color.gray);
		textDescripcion.setFont(new Font("belanosima", Font.BOLD, 18));
		textDescripcion.setBackground(Color.decode("#E8E2DD"));
		textDescripcion.setOpaque(false);
		textDescripcion.setBorder(null);
		panel.add(textDescripcion);

		// Campo precio
		JLabel tituloPrecio = new JLabel("Precio");
		tituloPrecio.setSize(300, 40);
		tituloPrecio.setLocation(50, 360);
		tituloPrecio.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloPrecio.setOpaque(false);
		panel.add(tituloPrecio);

		RoundedTextField textPrecio = new RoundedTextField(20, 20);
		textPrecio.setSize(300, 40);
		textPrecio.setLocation(50, 400);
		textPrecio.setText("$85");
		textPrecio.setForeground(Color.gray);
		textPrecio.setFont(new Font("belanosima", Font.BOLD, 20));
		textPrecio.setHorizontalAlignment(JTextField.CENTER);
		textPrecio.setBackground(Color.decode("#E8E2DD"));
		textPrecio.setOpaque(false);
		textPrecio.setBorder(null);
		panel.add(textPrecio);

		// Campo imagen
		JLabel tituloImagen = new JLabel("Imagen");
		tituloImagen.setSize(300, 40);
		tituloImagen.setLocation(500, 360);
		tituloImagen.setFont(new Font("belanosima", Font.BOLD, 20));
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
		tituloIngredientes.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloIngredientes.setOpaque(false);
		panel.add(tituloIngredientes);

		// Boton agregar ingrediente
		RoundedButton btnAgregaring = new RoundedButton("+ Agregar ingrediente", 20);
		btnAgregaring.setSize(250, 30);
		btnAgregaring.setLocation(500, 530);
		btnAgregaring.setBackground(Color.decode("#FFFFFF"));
		btnAgregaring.setOpaque(false);
		btnAgregaring.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregaring.setForeground(Color.decode("#DC542B"));
		panel.add(btnAgregaring);

		// Texto ingrediente tortilla
		RoundedTextField textIngTortilla = new RoundedTextField(20, 20);
		textIngTortilla.setSize(400, 60);
		textIngTortilla.setLocation(50, 625);
		textIngTortilla.setText("Tortilla de maíz (piezas)");
		textIngTortilla.setForeground(Color.gray);
		textIngTortilla.setFont(new Font("belanosima", Font.BOLD, 20));
		textIngTortilla.setHorizontalAlignment(JTextField.CENTER);
		textIngTortilla.setBackground(Color.decode("#E8E2DD"));
		textIngTortilla.setOpaque(false);
		textIngTortilla.setBorder(null);
		panel.add(textIngTortilla);

		RoundedTextField textNumTortilla = new RoundedTextField(20, 20);
		textNumTortilla.setSize(100, 60);
		textNumTortilla.setLocation(500, 625);
		textNumTortilla.setText("3");
		textNumTortilla.setForeground(Color.gray);
		textNumTortilla.setFont(new Font("belanosima", Font.BOLD, 20));
		textNumTortilla.setHorizontalAlignment(JTextField.CENTER);
		textNumTortilla.setBackground(Color.decode("#E8E2DD"));
		textNumTortilla.setOpaque(false);
		textNumTortilla.setBorder(null);
		panel.add(textNumTortilla);
		
		ImageIcon iconX = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX = iconX.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX = new ImageIcon(imgX);

		JButton btnImagenX = new JButton(scaledIconX);
		btnImagenX.setSize(50, 50);
		btnImagenX.setLocation(625, 625);
		btnImagenX.setBackground(Color.decode("#E8E2DD"));
		btnImagenX.setForeground(Color.white);
		btnImagenX.setIconTextGap(10);
		btnImagenX.setBorder(null);
		btnImagenX.setFocusPainted(false);
		panel.add(btnImagenX);

		// Texto carne de res
		RoundedTextField textCarneRes = new RoundedTextField(20, 20);
		textCarneRes.setSize(400, 60);
		textCarneRes.setLocation(50, 725);
		textCarneRes.setText("Carne de Res (Kg)");
		textCarneRes.setForeground(Color.gray);
		textCarneRes.setFont(new Font("belanosima", Font.BOLD, 20));
		textCarneRes.setHorizontalAlignment(JTextField.CENTER);
		textCarneRes.setBackground(Color.decode("#E8E2DD"));
		textCarneRes.setOpaque(false);
		textCarneRes.setBorder(null);
		panel.add(textCarneRes);

		RoundedTextField textCarne = new RoundedTextField(20, 20);
		textCarne.setSize(100, 60);
		textCarne.setLocation(500, 725);
		textCarne.setText("0.2");
		textCarne.setForeground(Color.gray);
		textCarne.setFont(new Font("belanosima", Font.BOLD, 20));
		textCarne.setHorizontalAlignment(JTextField.CENTER);
		textCarne.setBackground(Color.decode("#E8E2DD"));
		textCarne.setOpaque(false);
		textCarne.setBorder(null);
		panel.add(textCarne);
		
		ImageIcon iconX1 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX1 = iconX1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX1 = new ImageIcon(imgX1);

		JButton btnImagenX1 = new JButton(scaledIconX1);
		btnImagenX1.setSize(50, 50);
		btnImagenX1.setLocation(625, 725);
		btnImagenX1.setBackground(Color.decode("#E8E2DD"));
		btnImagenX1.setForeground(Color.white);
		btnImagenX1.setIconTextGap(10);
		btnImagenX1.setBorder(null);
		btnImagenX1.setFocusPainted(false);
		panel.add(btnImagenX1);

		// Texto cebolla
		RoundedTextField textIngCebolla = new RoundedTextField(20, 20);
		textIngCebolla.setSize(400, 60);
		textIngCebolla.setLocation(50, 825);
		textIngCebolla.setText("Cebolla (Kg)");
		textIngCebolla.setForeground(Color.gray);
		textIngCebolla.setFont(new Font("belanosima", Font.BOLD, 20));
		textIngCebolla.setHorizontalAlignment(JTextField.CENTER);
		textIngCebolla.setBackground(Color.decode("#E8E2DD"));
		textIngCebolla.setOpaque(false);
		textIngCebolla.setBorder(null);
		panel.add(textIngCebolla);

		RoundedTextField textCebolla = new RoundedTextField(20, 20);
		textCebolla.setSize(100, 60);
		textCebolla.setLocation(500, 825);
		textCebolla.setText("0.05");
		textCebolla.setForeground(Color.gray);
		textCebolla.setFont(new Font("belanosima", Font.BOLD, 20));
		textCebolla.setHorizontalAlignment(JTextField.CENTER);
		textCebolla.setBackground(Color.decode("#E8E2DD"));
		textCebolla.setOpaque(false);
		textCebolla.setBorder(null);
		panel.add(textCebolla);
		
		ImageIcon iconX2 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX2 = iconX2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX2 = new ImageIcon(imgX2);

		JButton btnImagenX2 = new JButton(scaledIconX2);
		btnImagenX2.setSize(50, 50);
		btnImagenX2.setLocation(625, 825);
		btnImagenX2.setBackground(Color.decode("#E8E2DD"));
		btnImagenX2.setForeground(Color.white);
		btnImagenX2.setIconTextGap(10);
		btnImagenX2.setBorder(null);
		btnImagenX2.setFocusPainted(false);
		panel.add(btnImagenX2);

		// Texto cilantro
		RoundedTextField textIngCilantro = new RoundedTextField(20, 20);
		textIngCilantro.setSize(400, 60);
		textIngCilantro.setLocation(50, 925);
		textIngCilantro.setText("Cilantro (manojo)");
		textIngCilantro.setForeground(Color.gray);
		textIngCilantro.setFont(new Font("belanosima", Font.BOLD, 20));
		textIngCilantro.setHorizontalAlignment(JTextField.CENTER);
		textIngCilantro.setBackground(Color.decode("#E8E2DD"));
		textIngCilantro.setOpaque(false);
		textIngCilantro.setBorder(null);
		panel.add(textIngCilantro);

		RoundedTextField textCilantro = new RoundedTextField(20, 20);
		textCilantro.setSize(100, 60);
		textCilantro.setLocation(500, 925);
		textCilantro.setText("0.02");
		textCilantro.setForeground(Color.gray);
		textCilantro.setFont(new Font("belanosima", Font.BOLD, 20));
		textCilantro.setHorizontalAlignment(JTextField.CENTER);
		textCilantro.setBackground(Color.decode("#E8E2DD"));
		textCilantro.setOpaque(false);
		textCilantro.setBorder(null);
		panel.add(textCilantro);
		
		ImageIcon iconX3 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX3 = iconX3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX3 = new ImageIcon(imgX3);

		JButton btnImagenX3 = new JButton(scaledIconX3);
		btnImagenX3.setSize(50, 50);
		btnImagenX3.setLocation(625, 925);
		btnImagenX3.setBackground(Color.decode("#E8E2DD"));
		btnImagenX3.setForeground(Color.white);
		btnImagenX3.setIconTextGap(10);
		btnImagenX3.setBorder(null);
		btnImagenX3.setFocusPainted(false);
		panel.add(btnImagenX3);

		RoundedButton btnGuardar = new RoundedButton("Guardar cambio", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 1025);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			router("platillos");
		});
		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(270, 1025);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			router("platillos");
		});
		panel.add(btnCancelar);
	}

	public void verPlatilloTacosalpastor() {
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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
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

				g2d.setColor(Color.decode("#DEDEDE"));
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

		// Campo imagen
		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/tacos pastor.jpg"));
		Image img9 = icon9.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);
		RoundedImageButton btnImagen = new RoundedImageButton(scaledIcon9, 40);

		btnImagen.setSize(350, 350);
		btnImagen.setLocation(50, 50);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		panel.add(btnImagen);

		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/disponible.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(scaledImage);
		JLabel labelImagen = new JLabel(finalIcon);
		labelImagen.setBounds(690, 45, 150, 50);
		panel.add(labelImagen);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Tacos al pastor");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(415, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo nombre tacos
		JLabel tituloNombre1 = new JLabel("Tacos");
		tituloNombre1.setSize(300, 40);
		tituloNombre1.setLocation(420, 95);
		tituloNombre1.setFont(new Font("belanosima", Font.BOLD, 18));
		tituloNombre1.setOpaque(false);
		panel.add(tituloNombre1);

		// Campo nombre precio
		JLabel tituloPrecio = new JLabel("Precio");
		tituloPrecio.setSize(300, 40);
		tituloPrecio.setLocation(420, 150);
		tituloPrecio.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloPrecio.setOpaque(false);
		panel.add(tituloPrecio);

		// Campo nombre precio
		JLabel tituloPrecio1 = new JLabel("$85");
		tituloPrecio1.setSize(300, 40);
		tituloPrecio1.setLocation(420, 190);
		tituloPrecio1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloPrecio1.setForeground(Color.decode("#DC542B"));
		tituloPrecio1.setOpaque(false);
		panel.add(tituloPrecio1);

		// Campo nombre precio
		JLabel tituloDescripcion = new JLabel("Descripción");
		tituloDescripcion.setSize(300, 40);
		tituloDescripcion.setLocation(420, 250);
		tituloDescripcion.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloDescripcion.setOpaque(false);
		panel.add(tituloDescripcion);

		// Campo nombre precio
		JLabel tituloDescripcion1 = new JLabel(
				"<html> Tres tacos con carne al pastor,<br> cilantro, cebolla y piña.</html>");
		tituloDescripcion1.setSize(300, 40);
		tituloDescripcion1.setLocation(420, 300);
		tituloDescripcion1.setFont(new Font("belanosima", Font.BOLD, 18));
		tituloDescripcion1.setOpaque(false);
		panel.add(tituloDescripcion1);

		ImageIcon icon10 = new ImageIcon(getClass().getResource("/images/editar.png"));
		Image img10 = icon10.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon10 = new ImageIcon(img10);

		RoundedButton btnEditar = new RoundedButton("Editar", 20, scaledIcon10);
		btnEditar.setSize(170, 50);
		btnEditar.setLocation(380, 420);
		btnEditar.setBackground(Color.decode("#DC542B"));
		btnEditar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEditar.setVerticalTextPosition(SwingConstants.CENTER);
		btnEditar.setForeground(Color.white);

		btnEditar.addActionListener(e -> {
			router("editarPlatilloTacosalpastor");
		});

		panel.add(btnEditar);

		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/download.png"));
		Image img11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnDescargar = new RoundedButton("Descargar PDF", 20, scaledIcon11);
		btnDescargar.setSize(250, 50);
		btnDescargar.setLocation(570, 420);
		btnDescargar.setBackground(Color.decode("#DC542B"));
		btnDescargar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnDescargar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDescargar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDescargar.setVerticalTextPosition(SwingConstants.CENTER);
		btnDescargar.setForeground(Color.white);
		panel.add(btnDescargar);

		JPanel linea2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#DEDEDE"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea2.setBounds(0, 500, 1000, 1);
		linea2.setOpaque(false);
		panel.add(linea2);

		// Campo ingrediente
		JLabel tituloIngredientes = new JLabel("Ingredientes");
		tituloIngredientes.setSize(300, 40);
		tituloIngredientes.setLocation(50, 530);
		tituloIngredientes.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloIngredientes.setOpaque(false);
		panel.add(tituloIngredientes);

		// Texto ingrediente tortilla
		RoundedTextField textTortilla = new RoundedTextField(20, 20);
		textTortilla.setSize(700, 90);
		textTortilla.setLocation(50, 625);
		textTortilla.setText("Tortillaz de maíz");
		textTortilla.setForeground(Color.black);
		textTortilla.setFont(new Font("belanosima", Font.BOLD, 20));
		textTortilla.setHorizontalAlignment(JTextField.LEFT);
		textTortilla.setBackground(Color.decode("#E8E2DD"));
		textTortilla.setOpaque(false);
		textTortilla.setBorder(null);
		textTortilla.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textTortilla);

		JLabel tituloCantidad = new JLabel("3 piezas requeridas");
		tituloCantidad.setSize(300, 40);
		tituloCantidad.setLocation(15, 40);
		tituloCantidad.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad.setForeground(Color.gray);
		tituloCantidad.setOpaque(false);
		textTortilla.add(tituloCantidad);

		// Texto ingrediente carne
		RoundedTextField textCarne = new RoundedTextField(20, 20);
		textCarne.setSize(700, 90);
		textCarne.setLocation(50, 750);
		textCarne.setText("Carne de res");
		textCarne.setForeground(Color.black);
		textCarne.setFont(new Font("belanosima", Font.BOLD, 20));
		textCarne.setHorizontalAlignment(JTextField.LEFT);
		textCarne.setBackground(Color.decode("#E8E2DD"));
		textCarne.setOpaque(false);
		textCarne.setBorder(null);
		textCarne.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textCarne);

		JLabel tituloCantidad1 = new JLabel("0.2 Kg requeridos");
		tituloCantidad1.setSize(300, 40);
		tituloCantidad1.setLocation(15, 40);
		tituloCantidad1.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad1.setForeground(Color.gray);
		tituloCantidad1.setOpaque(false);
		textCarne.add(tituloCantidad1);

		// Texto ingrediente cebolla
		RoundedTextField textCebolla = new RoundedTextField(20, 20);
		textCebolla.setSize(700, 90);
		textCebolla.setLocation(50, 875);
		textCebolla.setText("Cebolla");
		textCebolla.setForeground(Color.black);
		textCebolla.setFont(new Font("belanosima", Font.BOLD, 20));
		textCebolla.setHorizontalAlignment(JTextField.LEFT);
		textCebolla.setBackground(Color.decode("#E8E2DD"));
		textCebolla.setOpaque(false);
		textCebolla.setBorder(null);
		textCebolla.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textCebolla);

		JLabel tituloCantidad2 = new JLabel("0.05 Kg requerido");
		tituloCantidad2.setSize(300, 40);
		tituloCantidad2.setLocation(15, 40);
		tituloCantidad2.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad2.setForeground(Color.gray);
		tituloCantidad2.setOpaque(false);
		textCebolla.add(tituloCantidad2);

		// Texto ingrediente cebolla
		RoundedTextField textCilantro = new RoundedTextField(20, 20);
		textCilantro.setSize(700, 90);
		textCilantro.setLocation(50, 1000);
		textCilantro.setText("Cilantro");
		textCilantro.setForeground(Color.black);
		textCilantro.setFont(new Font("belanosima", Font.BOLD, 20));
		textCilantro.setHorizontalAlignment(JTextField.LEFT);
		textCilantro.setBackground(Color.decode("#E8E2DD"));
		textCilantro.setOpaque(false);
		textCilantro.setBorder(null);
		textCilantro.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textCilantro);

		JLabel tituloCantidad3 = new JLabel("0.25 kg requerido");
		tituloCantidad3.setSize(300, 40);
		tituloCantidad3.setLocation(15, 40);
		tituloCantidad3.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad3.setForeground(Color.gray);
		tituloCantidad3.setOpaque(false);
		textCilantro.add(tituloCantidad3);

	}

	public void verOrdenesGrady() {
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
		contenido.setPreferredSize(new Dimension(930, 900));

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("ordenes");
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

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 800);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/preparando.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(scaledImage);
		JLabel labelImagen = new JLabel(finalIcon);
		labelImagen.setBounds(690, 45, 150, 50);
		panel.add(labelImagen);

		// Campo orden
		JLabel tituloNombre = new JLabel("Orden #1");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo detalles
		JLabel tituloDetalle = new JLabel("5 de abril, 2026 a las 15:32");
		tituloDetalle.setSize(300, 40);
		tituloDetalle.setLocation(50, 80);
		tituloDetalle.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle.setForeground(Color.decode("#756B64"));
		tituloDetalle.setOpaque(false);
		panel.add(tituloDetalle);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Información del cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(50, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 150);
		textDatos.setLocation(50, 200);
		textDatos.setText("Grady  Rodríguez");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-90, 20, 0, 0)); // Los valores son arriba, izquierda,abajo,
																				// derecha
		panel.add(textDatos);

		JLabel tituloEmail = new JLabel("grady4217@gmail.com");
		tituloEmail.setSize(300, 40);
		tituloEmail.setLocation(20, 50);
		tituloEmail.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloEmail.setForeground(Color.decode("#756B64"));
		tituloEmail.setOpaque(false);
		textDatos.add(tituloEmail);

		JLabel tituloNumero = new JLabel("5512345678");
		tituloNumero.setSize(300, 40);
		tituloNumero.setLocation(20, 95);
		tituloNumero.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNumero.setForeground(Color.decode("#756B64"));
		tituloNumero.setOpaque(false);
		textDatos.add(tituloNumero);

		// Campo resumen
		JLabel tituloResumen = new JLabel("Resumen");
		tituloResumen.setSize(300, 40);
		tituloResumen.setLocation(500, 150);
		tituloResumen.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloResumen.setOpaque(false);
		panel.add(tituloResumen);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(350, 200);
		textDatosResu.setLocation(480, 200);
		textDatosResu.setText("Platillos");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-200, 20, -50, 10)); // Los valores son arriba,
																						// izquierda, abajo, derecha
		panel.add(textDatosResu);

		JLabel tituloNum = new JLabel("2");
		tituloNum.setSize(300, 40);
		tituloNum.setLocation(300, 5);
		tituloNum.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNum.setForeground(Color.decode("#756B64"));
		tituloNum.setOpaque(false);
		textDatosResu.add(tituloNum);

		JLabel tituloItems = new JLabel("Items totales");
		tituloItems.setSize(300, 40);
		tituloItems.setLocation(20, 50);
		tituloItems.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloItems.setForeground(Color.decode("#756B64"));
		tituloItems.setOpaque(false);
		textDatosResu.add(tituloItems);

		JLabel tituloNum2 = new JLabel("3");
		tituloNum2.setSize(300, 40);
		tituloNum2.setLocation(300, 50);
		tituloNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNum2.setForeground(Color.decode("#756B64"));
		tituloNum2.setOpaque(false);
		textDatosResu.add(tituloNum2);

		JPanel linea3 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea3.setBounds(20, 100, 300, 1);
		linea3.setOpaque(false);
		textDatosResu.add(linea3);

		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(20, 120);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal.setForeground(Color.decode("#000000"));
		tituloTotal.setOpaque(false);
		textDatosResu.add(tituloTotal);

		JLabel tituloTotalnum = new JLabel("$355");
		tituloTotalnum.setSize(300, 40);
		tituloTotalnum.setLocation(270, 120);
		tituloTotalnum.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotalnum.setForeground(Color.decode("#D44B28"));
		tituloTotalnum.setOpaque(false);
		textDatosResu.add(tituloTotalnum);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 450);
		tituloPlatillos.setFont(new Font("Arial", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Texto enchiladas
		RoundedTextField textEnchilada = new RoundedTextField(20, 20);
		textEnchilada.setSize(700, 90);
		textEnchilada.setLocation(40, 500);
		textEnchilada.setText("Enchiladas rojas");
		textEnchilada.setForeground(Color.black);
		textEnchilada.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchilada.setHorizontalAlignment(JTextField.LEFT);
		textEnchilada.setBackground(Color.decode("#E8E2DD"));
		textEnchilada.setForeground(Color.decode("#756B64"));
		textEnchilada.setOpaque(false);
		textEnchilada.setBorder(null);
		textEnchilada.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textEnchilada);

		JLabel tituloCantidad = new JLabel("$105 x 1");
		tituloCantidad.setSize(300, 40);
		tituloCantidad.setLocation(15, 40);
		tituloCantidad.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCantidad.setForeground(Color.decode("#756B64"));
		tituloCantidad.setOpaque(false);
		textEnchilada.add(tituloCantidad);

		JLabel tituloTotal1 = new JLabel("$105");
		tituloTotal1.setSize(300, 40);
		tituloTotal1.setLocation(630, 25);
		tituloTotal1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal1.setForeground(Color.decode("#756B64"));
		tituloTotal1.setOpaque(false);
		textEnchilada.add(tituloTotal1);

		// Texto pozole verde
		RoundedTextField textPozole = new RoundedTextField(20, 20);
		textPozole.setSize(700, 90);
		textPozole.setLocation(40, 600);
		textPozole.setText("Pozole verde");
		textPozole.setForeground(Color.black);
		textPozole.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozole.setHorizontalAlignment(JTextField.LEFT);
		textPozole.setBackground(Color.decode("#E8E2DD"));
		textPozole.setForeground(Color.decode("#756B64"));
		textPozole.setOpaque(false);
		textPozole.setBorder(null);
		textPozole.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textPozole);

		JLabel tituloCantidad1 = new JLabel("$125 x 2");
		tituloCantidad1.setSize(300, 40);
		tituloCantidad1.setLocation(15, 40);
		tituloCantidad1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCantidad1.setForeground(Color.decode("#756B64"));
		tituloCantidad1.setOpaque(false);
		textPozole.add(tituloCantidad1);

		JLabel tituloTotal2 = new JLabel("$125");
		tituloTotal2.setSize(300, 40);
		tituloTotal2.setLocation(630, 25);
		tituloTotal2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal2.setForeground(Color.decode("#756B64"));
		tituloTotal2.setOpaque(false);
		textPozole.add(tituloTotal2);

		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/download.png"));
		Image img11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnDescargar = new RoundedButton("Descargar PDF", 20, scaledIcon11);
		btnDescargar.setSize(220, 50);
		btnDescargar.setLocation(50, 730);
		btnDescargar.setBackground(Color.decode("#DC542B"));
		btnDescargar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnDescargar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDescargar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDescargar.setVerticalTextPosition(SwingConstants.CENTER);
		btnDescargar.setForeground(Color.white);
		panel.add(btnDescargar);

	}

	public void editarOrdenesGrady() {
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
		contenido.setPreferredSize(new Dimension(930, 900));

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// Boton de volver
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("ordenes");
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

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 800);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Editar orden");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(40, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(40, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 60);
		textDatos.setLocation(40, 200);
		textDatos.setText("Grady  Rodríguez");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setForeground(Color.decode("#756B64"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0)); // Los valores son arriba, izquierda,abaj,
																			// // derecha
		panel.add(textDatos);

		// Campo estado
		JLabel tituloEstado = new JLabel("Estado");
		tituloEstado.setSize(300, 40);
		tituloEstado.setLocation(460, 150);
		tituloEstado.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloEstado.setOpaque(false);
		panel.add(tituloEstado);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(320, 60);
		textDatosResu.setLocation(460, 200);
		textDatosResu.setText("Preparando");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textDatosResu);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 300);
		tituloPlatillos.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Botone de agregar
		RoundedButton btnAgregarP = new RoundedButton("+ Agregar platillo", 20);
		btnAgregarP.setSize(200, 50);
		btnAgregarP.setLocation(600, 300);
		btnAgregarP.setBackground(Color.decode("#FFFFFF"));
		btnAgregarP.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregarP.setForeground(Color.decode("#DC542B"));
		btnAgregarP.setOpaque(false);
		panel.add(btnAgregarP);

		// Texto enchiladas
		RoundedTextField textEnchilada = new RoundedTextField(20, 20);
		textEnchilada.setSize(380, 60);
		textEnchilada.setLocation(40, 400);
		textEnchilada.setText("Enchiladas rojas - $105");
		textEnchilada.setForeground(Color.black);
		textEnchilada.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchilada.setHorizontalAlignment(JTextField.LEFT);
		textEnchilada.setBackground(Color.decode("#E8E2DD"));
		textEnchilada.setForeground(Color.decode("#756B64"));
		textEnchilada.setOpaque(false);
		textEnchilada.setBorder(null);
		textEnchilada.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textEnchilada);

		RoundedTextField textEnchiladaNum = new RoundedTextField(20, 20);
		textEnchiladaNum.setSize(100, 60);
		textEnchiladaNum.setLocation(450, 400);
		textEnchiladaNum.setText("1");
		textEnchiladaNum.setForeground(Color.black);
		textEnchiladaNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchiladaNum.setHorizontalAlignment(JTextField.LEFT);
		textEnchiladaNum.setBackground(Color.decode("#E8E2DD"));
		textEnchiladaNum.setForeground(Color.decode("#756B64"));
		textEnchiladaNum.setOpaque(false);
		textEnchiladaNum.setBorder(null);
		textEnchiladaNum.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textEnchiladaNum.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textEnchiladaNum);

		RoundedTextField textEnchiladaNum2 = new RoundedTextField(20, 20);
		textEnchiladaNum2.setSize(150, 60);
		textEnchiladaNum2.setLocation(580, 400);
		textEnchiladaNum2.setText("$105");
		textEnchiladaNum2.setForeground(Color.black);
		textEnchiladaNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchiladaNum2.setHorizontalAlignment(JTextField.LEFT);
		textEnchiladaNum2.setBackground(Color.decode("#E8E2DD"));
		textEnchiladaNum2.setForeground(Color.decode("#756B64"));
		textEnchiladaNum2.setOpaque(false);
		textEnchiladaNum2.setBorder(null);
		textEnchiladaNum2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textEnchiladaNum2.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textEnchiladaNum2);

		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image img9 = icon9.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);

		JButton btnImagen = new JButton(scaledIcon9);
		btnImagen.setSize(50, 50);
		btnImagen.setLocation(750, 400);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		btnImagen.setForeground(Color.white);
		btnImagen.setIconTextGap(10);
		btnImagen.setBorder(null);
		btnImagen.setFocusPainted(false);
		panel.add(btnImagen);

		// Texto pozole
		RoundedTextField textPozole = new RoundedTextField(20, 20);
		textPozole.setSize(380, 60);
		textPozole.setLocation(40, 500);
		textPozole.setText("Pozole verde - $125");
		textPozole.setForeground(Color.black);
		textPozole.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozole.setHorizontalAlignment(JTextField.LEFT);
		textPozole.setBackground(Color.decode("#E8E2DD"));
		textPozole.setForeground(Color.decode("#756B64"));
		textPozole.setOpaque(false);
		textPozole.setBorder(null);
		textPozole.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textPozole);

		RoundedTextField textPozoleNum = new RoundedTextField(20, 20);
		textPozoleNum.setSize(100, 60);
		textPozoleNum.setLocation(450, 500);
		textPozoleNum.setText("2");
		textPozoleNum.setForeground(Color.black);
		textPozoleNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozoleNum.setHorizontalAlignment(JTextField.LEFT);
		textPozoleNum.setBackground(Color.decode("#E8E2DD"));
		textPozoleNum.setForeground(Color.decode("#756B64"));
		textPozoleNum.setOpaque(false);
		textPozoleNum.setBorder(null);
		textPozoleNum.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textPozoleNum.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textPozoleNum);

		RoundedTextField textPozoleNum2 = new RoundedTextField(20, 20);
		textPozoleNum2.setSize(150, 60);
		textPozoleNum2.setLocation(580, 500);
		textPozoleNum2.setText("$125");
		textPozoleNum2.setForeground(Color.black);
		textPozoleNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozoleNum2.setHorizontalAlignment(JTextField.LEFT);
		textPozoleNum2.setBackground(Color.decode("#E8E2DD"));
		textPozoleNum2.setForeground(Color.decode("#756B64"));
		textPozoleNum2.setOpaque(false);
		textPozoleNum2.setBorder(null);
		textPozoleNum2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textPozoleNum2.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textPozoleNum2);

		ImageIcon icon10 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image img10 = icon10.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon10 = new ImageIcon(img10);

		JButton btnImagen2 = new JButton(scaledIcon10);
		btnImagen2.setSize(50, 50);
		btnImagen2.setLocation(750, 500);
		btnImagen2.setBackground(Color.decode("#E8E2DD"));
		btnImagen2.setForeground(Color.white);
		btnImagen2.setIconTextGap(10);
		btnImagen2.setBorder(null);
		btnImagen2.setFocusPainted(false);
		panel.add(btnImagen2);

		JPanel linea2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea2.setBounds(50, 600, 730, 1);
		linea2.setOpaque(false);
		panel.add(linea2);

		// Campo total
		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(40, 620);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotal.setOpaque(false);
		panel.add(tituloTotal);

		// Campo numero total
		JLabel tituloTotalNum = new JLabel("$355");
		tituloTotalNum.setSize(300, 40);
		tituloTotalNum.setLocation(720, 620);
		tituloTotalNum.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotalNum.setForeground(Color.decode("#DC542B"));
		tituloTotalNum.setOpaque(false);
		panel.add(tituloTotalNum);

		// Botones guardar y cancelar
		RoundedButton btnGuardar = new RoundedButton("Guardar cambios", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 720);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			router("ordenes");
		});
		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(280, 720);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			router("ordenes");
		});
		panel.add(btnCancelar);

	}

	public void nuevaOrden() {
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
		contenido.setPreferredSize(new Dimension(930, 900));

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// Boton de volver
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("ordenes");
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

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 600);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Nueva orden");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(40, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(40, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 60);
		textDatos.setLocation(40, 200);
		textDatos.setText("");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setForeground(Color.decode("#756B64"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0)); // Los valores son arriba, izquierda,abaj,
																			// // derecha
		panel.add(textDatos);

		// Campo estado
		JLabel tituloEstado = new JLabel("Estado");
		tituloEstado.setSize(300, 40);
		tituloEstado.setLocation(460, 150);
		tituloEstado.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloEstado.setOpaque(false);
		panel.add(tituloEstado);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(320, 60);
		textDatosResu.setLocation(460, 200);
		textDatosResu.setText("");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textDatosResu);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 300);
		tituloPlatillos.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Botone de agregar
		RoundedButton btnAgregarP = new RoundedButton("+ Agregar platillo", 20);
		btnAgregarP.setSize(200, 50);
		btnAgregarP.setLocation(600, 300);
		btnAgregarP.setBackground(Color.decode("#FFFFFF"));
		btnAgregarP.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregarP.setForeground(Color.decode("#DC542B"));
		btnAgregarP.setOpaque(false);
		panel.add(btnAgregarP);

		JPanel linea2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea2.setBounds(50, 380, 730, 1);
		linea2.setOpaque(false);
		panel.add(linea2);

		// Campo total
		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(40, 420);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotal.setOpaque(false);
		panel.add(tituloTotal);

		// Campo numero total
		JLabel tituloTotalNum = new JLabel("$0.00");
		tituloTotalNum.setSize(300, 40);
		tituloTotalNum.setLocation(720, 420);
		tituloTotalNum.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotalNum.setForeground(Color.decode("#DC542B"));
		tituloTotalNum.setOpaque(false);
		panel.add(tituloTotalNum);

		// Botones guardar y cancelar
		RoundedButton btnCrear = new RoundedButton("Crear orden", 20);
		btnCrear.setSize(200, 50);
		btnCrear.setLocation(50, 500);
		btnCrear.setBackground(Color.decode("#DC542B"));
		btnCrear.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCrear.setForeground(Color.white);

		btnCrear.addActionListener(e -> {
			router("ordenes");
		});
		panel.add(btnCrear);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(280, 500);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			router("ordenes");
		});
		panel.add(btnCancelar);
	}

	public void verClientesGrady() {
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
		contenido.setPreferredSize(new Dimension(930, 900));

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		RoundedButton btnAgregar = new RoundedButton("<- Volver a Clientes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("clientes");
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

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 750);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Grady Rodríguez");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo detalles
		JLabel tituloDetalle = new JLabel("grady4217@gmail.com");
		tituloDetalle.setSize(300, 40);
		tituloDetalle.setLocation(50, 80);
		tituloDetalle.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle.setForeground(Color.decode("#756B64"));
		tituloDetalle.setOpaque(false);
		panel.add(tituloDetalle);

		JLabel tituloDetalle1 = new JLabel("5512345678");
		tituloDetalle1.setSize(300, 40);
		tituloDetalle1.setLocation(50, 110);
		tituloDetalle1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle1.setForeground(Color.decode("#756B64"));
		tituloDetalle1.setOpaque(false);
		panel.add(tituloDetalle1);

		// boton editar
		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/editar.png"));
		Image img11 = icon11.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnEditar = new RoundedButton("Editar", 20, scaledIcon11);
		btnEditar.setSize(160, 50);
		btnEditar.setLocation(680, 50);
		btnEditar.setBackground(Color.decode("#DC542B"));
		btnEditar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEditar.setVerticalTextPosition(SwingConstants.CENTER);
		btnEditar.setForeground(Color.white);

		btnEditar.addActionListener(e -> {
			router("editarClienteGrady");
		});

		panel.add(btnEditar);

		// Boton de ordenes
		ImageIcon icon12 = new ImageIcon(getClass().getResource("/images/órdenesN.png"));
		Image img12 = icon12.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon12 = new ImageIcon(img12);
		RoundedButton btnPreparado = new RoundedButton("Órdenes ", 20, scaledIcon12) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.black);
				g2.drawString("1", 120, 100);

				g2.dispose();
			}
		};
		btnPreparado.setSize(250, 150);
		btnPreparado.setLocation(50, 200);
		btnPreparado.setFont(new Font("belanosima", Font.BOLD, 26));
		btnPreparado.setForeground(Color.decode("#000000"));
		btnPreparado.setBackground(Color.decode("#E8E2DD"));
		btnPreparado.setLayout(null);
		btnPreparado.setBorder(BorderFactory.createEmptyBorder(-35, -5, 0, 0));
		panel.add(btnPreparado);

		// Boton direcciones
		ImageIcon icon13 = new ImageIcon(getClass().getResource("/images/direcciones.png"));
		Image img13 = icon13.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon13 = new ImageIcon(img13);
		RoundedButton btnDirecciones = new RoundedButton("Direcciones", 20, scaledIcon12) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.black);
				g2.drawString("1", 120, 100);

				g2.dispose();
			}
		};
		btnDirecciones.setSize(250, 150);
		btnDirecciones.setLocation(315, 200);
		btnDirecciones.setFont(new Font("belanosima", Font.BOLD, 26));
		btnDirecciones.setForeground(Color.decode("#000000"));
		btnDirecciones.setBackground(Color.decode("#E8E2DD"));
		btnDirecciones.setLayout(null);
		btnDirecciones.setBorder(BorderFactory.createEmptyBorder(-35, -5, 0, 0));
		panel.add(btnDirecciones);

		// Boton Total
		RoundedButton btnTotal = new RoundedButton("Total gastado", 20) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.decode("#D44B28"));
				g2.drawString("$355", 90, 100);

				g2.dispose();
			}
		};
		btnTotal.setSize(250, 150);
		btnTotal.setLocation(580, 200);
		btnTotal.setFont(new Font("belanosima", Font.BOLD, 26));
		btnTotal.setForeground(Color.decode("#000000"));
		btnTotal.setBackground(Color.decode("#E8E2DD"));
		btnTotal.setLayout(null);
		btnTotal.setBorder(BorderFactory.createEmptyBorder(-35, -5, 0, 0));
		panel.add(btnTotal);

		// Campo direcciones registradas
		JLabel tituloPlatillos = new JLabel("Direcciones registradas");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 400);
		tituloPlatillos.setFont(new Font("belanosima", Font.BOLD, 22));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Texto direccion
		RoundedTextField textDirecc = new RoundedTextField(20, 20);
		textDirecc.setSize(800, 90);
		textDirecc.setLocation(40, 450);
		textDirecc.setText("Av. Insurgentes Sur 123");
		textDirecc.setForeground(Color.black);
		textDirecc.setFont(new Font("belanosima", Font.BOLD, 20));
		textDirecc.setHorizontalAlignment(JTextField.LEFT);
		textDirecc.setBackground(Color.decode("#E8E2DD"));
		textDirecc.setOpaque(false);
		textDirecc.setBorder(null);
		textDirecc.setBorder(BorderFactory.createEmptyBorder(-25, 60, 0, 0));
		panel.add(textDirecc);

		JLabel tituloDatos = new JLabel("CDMX, CP 06600");
		tituloDatos.setSize(300, 40);
		tituloDatos.setLocation(60, 40);
		tituloDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos.setForeground(Color.decode("#756B64"));
		tituloDatos.setOpaque(false);
		textDirecc.add(tituloDatos);

		// imagen de dirrecion
		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/direccionesR.png"));
		Image imgEscalada = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon iconoFinal = new ImageIcon(imgEscalada);
		JLabel etiquetaImagen = new JLabel(iconoFinal);
		etiquetaImagen.setBounds(10, 20, 50, 50);
		textDirecc.add(etiquetaImagen);

		// Campo historial
		JLabel tituloHistorial = new JLabel("Historial de pedidos");
		tituloHistorial.setSize(300, 40);
		tituloHistorial.setLocation(40, 575);
		tituloHistorial.setFont(new Font("belanosima", Font.BOLD, 22));
		tituloHistorial.setOpaque(false);
		panel.add(tituloHistorial);

		// Texto direccion
		RoundedTextField textDirecc1 = new RoundedTextField(20, 20);
		textDirecc1.setSize(800, 90);
		textDirecc1.setLocation(40, 625);
		textDirecc1.setText("Orden #1");
		textDirecc1.setForeground(Color.black);
		textDirecc1.setFont(new Font("belanosima", Font.BOLD, 20));
		textDirecc1.setHorizontalAlignment(JTextField.LEFT);
		textDirecc1.setBackground(Color.decode("#E8E2DD"));
		textDirecc1.setOpaque(false);
		textDirecc1.setBorder(null);
		textDirecc1.setBorder(BorderFactory.createEmptyBorder(-25, 60, 0, 0));
		panel.add(textDirecc1);

		JLabel tituloDatos1 = new JLabel("5 de abril, 2026");
		tituloDatos1.setSize(300, 40);
		tituloDatos1.setLocation(60, 40);
		tituloDatos1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos1.setForeground(Color.decode("#756B64"));
		tituloDatos1.setOpaque(false);
		textDirecc1.add(tituloDatos1);

		JLabel tituloDatos2 = new JLabel("$355");
		tituloDatos2.setSize(300, 40);
		tituloDatos2.setLocation(700, 12);
		tituloDatos2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos2.setForeground(Color.black);
		tituloDatos2.setOpaque(false);
		textDirecc1.add(tituloDatos2);

		JLabel tituloDatos3 = new JLabel("preparando");
		tituloDatos3.setSize(300, 40);
		tituloDatos3.setLocation(635, 40);
		tituloDatos3.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos3.setForeground(Color.decode("#756B64"));
		tituloDatos3.setOpaque(false);
		textDirecc1.add(tituloDatos3);

	}

	public void editarClienteGrady() {
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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		RoundedButton btnAgregar = new RoundedButton("<- Volver a clientes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("clientes");
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

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 950);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		JLabel textEditarCliente = new JLabel("Editar cliente");
		textEditarCliente.setSize(300, 50);
		textEditarCliente.setLocation(50, 40);
		textEditarCliente.setFont(new Font("belanosima", Font.BOLD, 36));
		textEditarCliente.setOpaque(false);
		panel.add(textEditarCliente);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Nombre completo");
		tituloNombre.setSize(300, 50);
		tituloNombre.setLocation(50, 110);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		RoundedTextField textNombre = new RoundedTextField(20, 20);
		textNombre.setSize(300, 50);
		textNombre.setLocation(50, 150);
		textNombre.setText("Grady Rodríguez");
		textNombre.setForeground(Color.gray);
		textNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		textNombre.setBackground(Color.decode("#E8E2DD"));
		textNombre.setOpaque(false);
		textNombre.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		panel.add(textNombre);

		// Campo telefono
		JLabel tituloTelefono = new JLabel("Telefono");
		tituloTelefono.setSize(300, 40);
		tituloTelefono.setLocation(500, 110);
		tituloTelefono.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTelefono.setOpaque(false);
		panel.add(tituloTelefono);

		RoundedTextField textTelefono = new RoundedTextField(20, 20);
		textTelefono.setSize(300, 50);
		textTelefono.setLocation(500, 150);
		textTelefono.setText("5512345678");
		textTelefono.setForeground(Color.gray);
		textTelefono.setFont(new Font("belanosima", Font.BOLD, 20));
		textTelefono.setBackground(Color.decode("#E8E2DD"));
		textTelefono.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		textTelefono.setOpaque(false);
		panel.add(textTelefono);

		// Campo email
		JLabel tituloEmail = new JLabel("Email");
		tituloEmail.setSize(300, 200);
		tituloEmail.setLocation(50, 140);
		tituloEmail.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloEmail.setOpaque(false);
		panel.add(tituloEmail);

		RoundedTextArea textEmail = new RoundedTextArea(20);
		textEmail.setSize(750, 50);
		textEmail.setLocation(50, 260);
		textEmail.setText("grady4217@gmail.com");
		textEmail.setForeground(Color.gray);
		textEmail.setFont(new Font("belanosima", Font.BOLD, 20));
		textEmail.setBackground(Color.decode("#E8E2DD"));
		textEmail.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 0));
		textEmail.setOpaque(false);
		panel.add(textEmail);

		// Campo direccion
		JLabel tituloDirecc = new JLabel("Direcciones");
		tituloDirecc.setSize(300, 40);
		tituloDirecc.setLocation(50, 330);
		tituloDirecc.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloDirecc.setOpaque(false);
		panel.add(tituloDirecc);

		// Boton agregar direccion
		RoundedButton btnAgregaring = new RoundedButton("+ Agregar dirección", 20);
		btnAgregaring.setSize(250, 30);
		btnAgregaring.setLocation(570, 330);
		btnAgregaring.setBackground(Color.decode("#FFFFFF"));
		btnAgregaring.setOpaque(false);
		btnAgregaring.setFont(new Font("belanosima", Font.BOLD, 24));
		btnAgregaring.setForeground(Color.decode("#DC542B"));
		panel.add(btnAgregaring);

		// funcion de panel de dirreciones
		RoundedTextField DireccPanel = new RoundedTextField(20, 20);
		DireccPanel.setSize(750, 400);
		DireccPanel.setLocation(50, 400);
		DireccPanel.setForeground(Color.gray);
		DireccPanel.setFont(new Font("belanosima", Font.BOLD, 26));
		DireccPanel.setHorizontalAlignment(JTextField.CENTER);
		DireccPanel.setBackground(Color.decode("#E8E2DD"));
		DireccPanel.setOpaque(false);
		DireccPanel.setBorder(null);
		panel.add(DireccPanel);

		// Campo direccion 1
		JLabel tituloDirecc1 = new JLabel("Dirección 1");
		tituloDirecc1.setSize(300, 40);
		tituloDirecc1.setLocation(50, 50);
		tituloDirecc1.setFont(new Font("belanosima", Font.BOLD, 28));
		tituloDirecc1.setOpaque(false);
		DireccPanel.add(tituloDirecc1);

		// Campo calle y num
		JLabel tituloCalleyNum = new JLabel("Calle y número ");
		tituloCalleyNum.setSize(300, 40);
		tituloCalleyNum.setLocation(50, 120);
		tituloCalleyNum.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCalleyNum.setOpaque(false);
		DireccPanel.add(tituloCalleyNum);

		RoundedTextField textCalleyNum = new RoundedTextField(20, 20);
		textCalleyNum.setSize(675, 50);
		textCalleyNum.setLocation(50, 170);
		textCalleyNum.setText("Av. Insurgentes Sur 123");
		textCalleyNum.setForeground(Color.gray);
		textCalleyNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textCalleyNum.setBackground(Color.decode("#D4CEC7"));
		textCalleyNum.setOpaque(false);
		textCalleyNum.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel.add(textCalleyNum);

		// Campo ciudad
		JLabel tituloCiudad = new JLabel("Ciudad");
		tituloCiudad.setSize(300, 40);
		tituloCiudad.setLocation(50, 250);
		tituloCiudad.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCiudad.setOpaque(false);
		DireccPanel.add(tituloCiudad);

		RoundedTextField textCiudad = new RoundedTextField(20, 20);
		textCiudad.setSize(300, 50);
		textCiudad.setLocation(50, 300);
		textCiudad.setText("CDMX");
		textCiudad.setForeground(Color.gray);
		textCiudad.setFont(new Font("belanosima", Font.BOLD, 20));
		textCiudad.setBackground(Color.decode("#D4CEC7"));
		textCiudad.setOpaque(false);
		textCiudad.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel.add(textCiudad);

		// Campo codigo
		JLabel tituloCodigo = new JLabel("Codigo");
		tituloCodigo.setSize(300, 40);
		tituloCodigo.setLocation(420, 250);
		tituloCodigo.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCodigo.setOpaque(false);
		DireccPanel.add(tituloCodigo);

		RoundedTextField textCodigo = new RoundedTextField(20, 20);
		textCodigo.setSize(300, 50);
		textCodigo.setLocation(420, 300);
		textCodigo.setText("06600");
		textCodigo.setForeground(Color.gray);
		textCodigo.setFont(new Font("belanosima", Font.BOLD, 20));
		textCodigo.setBackground(Color.decode("#D4CEC7"));
		textCodigo.setOpaque(false);
		textCodigo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel.add(textCodigo);

		RoundedButton btnGuardar = new RoundedButton("Guardar cambios", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 850);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			router("clientes");
		});
		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(270, 850);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			router("clientes");
		});
		panel.add(btnCancelar);
	}

	public void agregarCliente() {
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
		contenido.setPreferredSize(new Dimension(930, 900));

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// Boton de volver
		RoundedButton btnAgregar = new RoundedButton("<- Volver a clientes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("clientes");
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

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 600);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Nueva cliente");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(40, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Nombre completo");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(40, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 60);
		textDatos.setLocation(40, 200);
		textDatos.setText("");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setForeground(Color.decode("#756B64"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0)); // Los valores son arriba, izquierda,abaj,
																			// // // derecha
		panel.add(textDatos);

		// Campo telefono
		JLabel tituloEstado = new JLabel("Telefono");
		tituloEstado.setSize(300, 40);
		tituloEstado.setLocation(460, 150);
		tituloEstado.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloEstado.setOpaque(false);
		panel.add(tituloEstado);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(320, 60);
		textDatosResu.setLocation(460, 200);
		textDatosResu.setText("");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textDatosResu);

		// Campo email
		JLabel tituloEmail = new JLabel("Email");
		tituloEmail.setSize(300, 40);
		tituloEmail.setLocation(40, 280);
		tituloEmail.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloEmail.setOpaque(false);
		panel.add(tituloEmail);

		// Texto datos
		RoundedTextField textEmail = new RoundedTextField(20, 20);
		textEmail.setSize(600, 60);
		textEmail.setLocation(40, 320);
		textEmail.setText("");
		textEmail.setForeground(Color.black);
		textEmail.setFont(new Font("belanosima", Font.BOLD, 20));
		textEmail.setHorizontalAlignment(JTextField.LEFT);
		textEmail.setBackground(Color.decode("#E8E2DD"));
		textEmail.setForeground(Color.decode("#756B64"));
		textEmail.setOpaque(false);
		textEmail.setBorder(null);
		textEmail.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0)); // Los valores son arriba, izquierda,abaj,
																			// // // derecha
		panel.add(textEmail);

		// Campo dirrecion
		JLabel tituloDirecciones = new JLabel("Dirrecciones");
		tituloDirecciones.setSize(300, 40);
		tituloDirecciones.setLocation(40, 400);
		tituloDirecciones.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloDirecciones.setOpaque(false);
		panel.add(tituloDirecciones);

		// Botone de agregar
		RoundedButton btnAgregarP = new RoundedButton("+ Agregar dirección", 20);
		btnAgregarP.setSize(250, 50);
		btnAgregarP.setLocation(550, 400);
		btnAgregarP.setBackground(Color.decode("#FFFFFF"));
		btnAgregarP.setFont(new Font("belanosima", Font.BOLD, 24));
		btnAgregarP.setForeground(Color.decode("#DC542B"));
		btnAgregarP.setOpaque(false);
		panel.add(btnAgregarP);

		// Botones guardar y cancelar
		RoundedButton btnCrear = new RoundedButton("Crear cliente", 20);
		btnCrear.setSize(200, 50);
		btnCrear.setLocation(50, 500);
		btnCrear.setBackground(Color.decode("#DC542B"));
		btnCrear.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCrear.setForeground(Color.white);

		btnCrear.addActionListener(e -> {
			router("clientes");
		});
		panel.add(btnCrear);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(280, 500);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			router("clientes");
		});
		panel.add(btnCancelar);

	}

	public void verInventarioTortilla() {
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
		contenido.setPreferredSize(new Dimension(930, 900));

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		RoundedButton btnAgregar = new RoundedButton("<- Volver a inventario", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("inventario");
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

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 600);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo tortilla
		JLabel tituloNombre = new JLabel("Tortilla de maíz");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/suficiente.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(130, 40, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(scaledImage);
		JLabel labelImagen = new JLabel(finalIcon);
		labelImagen.setBounds(50, 90, 130, 40);
		panel.add(labelImagen);

		// boton editar
		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/editar.png"));
		Image img11 = icon11.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnEditar = new RoundedButton("Editar", 20, scaledIcon11);
		btnEditar.setSize(180, 70);
		btnEditar.setLocation(640, 50);
		btnEditar.setBackground(Color.decode("#DC542B"));
		btnEditar.setFont(new Font("belanosima", Font.BOLD, 28));
		btnEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEditar.setVerticalTextPosition(SwingConstants.CENTER);
		btnEditar.setForeground(Color.white);

		btnEditar.addActionListener(e -> {
			router("editarInventarioTortilla");
		});

		panel.add(btnEditar);

		// Boton de ordenes
		RoundedButton btnPreparado = new RoundedButton("Cantidad actual ", 20) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(1));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.black);
				g2.drawString("450", 100, 90);

				g2.dispose();
			}
		};
		btnPreparado.setSize(250, 150);
		btnPreparado.setLocation(50, 200);
		btnPreparado.setFont(new Font("belanosima", Font.BOLD, 20));
		btnPreparado.setForeground(Color.gray);
		btnPreparado.setBackground(Color.decode("#FEF9F3"));
		btnPreparado.setLayout(null);
		btnPreparado.setBorder(BorderFactory.createEmptyBorder(0, -5, 60, 0));
		panel.add(btnPreparado);

		RoundedButton btnDirecciones = new RoundedButton("Cantidad maxima", 20) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(1));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.black);
				g2.drawString("500", 100, 90);

				g2.dispose();
			}
		};
		btnDirecciones.setSize(250, 150);
		btnDirecciones.setLocation(315, 200);
		btnDirecciones.setFont(new Font("belanosima", Font.BOLD, 20));
		btnDirecciones.setForeground(Color.gray);
		btnDirecciones.setBackground(Color.decode("#FEF9F3"));
		btnDirecciones.setLayout(null);
		btnDirecciones.setBorder(BorderFactory.createEmptyBorder(0, -5, 60, 0));
		panel.add(btnDirecciones);

		// Boton porcentaje
		RoundedButton btnTotal = new RoundedButton("Porcentaje", 20) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(1));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.black);
				g2.drawString("%90", 90, 100);

				g2.dispose();
			}
		};
		btnTotal.setSize(250, 150);
		btnTotal.setLocation(580, 200);
		btnTotal.setFont(new Font("belanosima", Font.BOLD, 20));
		btnTotal.setForeground(Color.gray);
		btnTotal.setBackground(Color.decode("#FEF9F3"));
		btnTotal.setLayout(null);
		btnTotal.setBorder(BorderFactory.createEmptyBorder(0, -5, 60, 0));
		panel.add(btnTotal);

		// Campo direcciones registradas
		JLabel tituloPlatillos = new JLabel("Nivel de stock");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 400);
		tituloPlatillos.setFont(new Font("belanosima", Font.BOLD, 22));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Texto direccion
		RoundedTextField textDirecc = new RoundedTextField(20, 20);
		textDirecc.setSize(800, 90);
		textDirecc.setLocation(40, 450);
		textDirecc.setText("0 piezas");
		textDirecc.setForeground(Color.decode("#756B64"));
		textDirecc.setFont(new Font("belanosima", Font.BOLD, 20));
		textDirecc.setHorizontalAlignment(JTextField.LEFT);
		textDirecc.setBackground(Color.decode("#E8E2DD"));
		textDirecc.setOpaque(false);
		textDirecc.setBorder(null);
		textDirecc.setBorder(BorderFactory.createEmptyBorder(-25, 60, 0, 0));
		panel.add(textDirecc);

		JLabel tituloDatos = new JLabel("100 piezas");
		tituloDatos.setSize(300, 40);
		tituloDatos.setLocation(680, 11);
		tituloDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos.setForeground(Color.decode("#756B64"));
		tituloDatos.setOpaque(false);
		textDirecc.add(tituloDatos);

		// barra de progreso
		JPanel barraVerde = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.decode("#FFFFFF"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

				g2.dispose();
			}
		};
		barraVerde.setOpaque(false);
		barraVerde.setBounds(50, 60, 725, 15);
		barraVerde.setLayout(null);
		textDirecc.add(barraVerde);

		JPanel barraProgreso = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#558B2F"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

				g2.dispose();
			}
		};
		barraProgreso.setOpaque(false);
		barraProgreso.setBounds(0, 0, 680, 15);
		barraVerde.add(barraProgreso);

	}

	public void editarInventarioTortilla() {
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
		contenido.setPreferredSize(new Dimension(930, 900));

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// Boton de volver
		RoundedButton btnAgregar = new RoundedButton("<- Volver a inventario", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("inventario");
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

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 700);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Editar ingrediente");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(40, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo informacion
		JLabel tituloInformacion = new JLabel("Nombre del ingrediente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(40, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(750, 60);
		textDatos.setLocation(40, 200);
		textDatos.setText("Tortilla de maíz");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 24));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setForeground(Color.decode("#756B64"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0)); // Los valores son arriba, izquierda,abaj,
																			// // // derecha
		panel.add(textDatos);

		// Campo cantidad
		JLabel tituloCantidad = new JLabel("Cantidad actual");
		tituloCantidad.setSize(300, 40);
		tituloCantidad.setLocation(40, 280);
		tituloCantidad.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCantidad.setOpaque(false);
		panel.add(tituloCantidad);

		RoundedTextField textNum = new RoundedTextField(20, 20);
		textNum.setSize(350, 60);
		textNum.setLocation(40, 340);
		textNum.setText("450");
		textNum.setForeground(Color.black);
		textNum.setFont(new Font("belanosima", Font.BOLD, 24));
		textNum.setHorizontalAlignment(JTextField.LEFT);
		textNum.setBackground(Color.decode("#E8E2DD"));
		textNum.setForeground(Color.decode("#756B64"));
		textNum.setOpaque(false);
		textNum.setBorder(null);
		textNum.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textNum);

		// Campo unidad
		JLabel tituloUnidad = new JLabel("Unidad de medida");
		tituloUnidad.setSize(300, 40);
		tituloUnidad.setLocation(450, 280);
		tituloUnidad.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloUnidad.setOpaque(false);
		panel.add(tituloUnidad);

		// Texto pieza
		RoundedTextField textPieza = new RoundedTextField(20, 20);
		textPieza.setSize(350, 60);
		textPieza.setLocation(450, 340);
		textPieza.setText("Piezas");
		textPieza.setForeground(Color.black);
		textPieza.setFont(new Font("belanosima", Font.BOLD, 24));
		textPieza.setHorizontalAlignment(JTextField.LEFT);
		textPieza.setBackground(Color.decode("#E8E2DD"));
		textPieza.setForeground(Color.decode("#756B64"));
		textPieza.setOpaque(false);
		textPieza.setBorder(null);
		textPieza.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textPieza);

		// Campo platillo
		JLabel tituloCantidad1 = new JLabel("Cantidad minima");
		tituloCantidad1.setSize(300, 40);
		tituloCantidad1.setLocation(40, 440);
		tituloCantidad1.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCantidad1.setOpaque(false);
		panel.add(tituloCantidad1);

		// Texto num
		RoundedTextField textNum2 = new RoundedTextField(20, 20);
		textNum2.setSize(760, 60);
		textNum2.setLocation(40, 500);
		textNum2.setText("500");
		textNum2.setForeground(Color.black);
		textNum2.setFont(new Font("belanosima", Font.BOLD, 24));
		textNum2.setHorizontalAlignment(JTextField.LEFT);
		textNum2.setBackground(Color.decode("#E8E2DD"));
		textNum2.setForeground(Color.decode("#756B64"));
		textNum2.setOpaque(false);
		textNum2.setBorder(null);
		textNum2.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textNum2);

		// Botones guardar y cancelar
		RoundedButton btnGuardar = new RoundedButton("Guardar cambios", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 620);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			router("inventario");
		});
		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(280, 620);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			router("inventario");
		});
		panel.add(btnCancelar);
	}

	public void agregarIngrediente() {
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
		contenido.setPreferredSize(new Dimension(930, 900));

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// Boton de volver
		RoundedButton btnAgregar = new RoundedButton("<- Volver a inventario", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("inventario");
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

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 700);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Nuevo ingrediente");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(40, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo informacion
		JLabel tituloInformacion = new JLabel("Nombre del ingrediente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(40, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(750, 60);
		textDatos.setLocation(40, 200);
		textDatos.setText("");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 24));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setForeground(Color.decode("#756B64"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0)); // Los valores son arriba, izquierda,abaj,
																			// // // derecha
		panel.add(textDatos);

		// Campo cantidad
		JLabel tituloCantidad = new JLabel("Cantidad actual");
		tituloCantidad.setSize(300, 40);
		tituloCantidad.setLocation(40, 280);
		tituloCantidad.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCantidad.setOpaque(false);
		panel.add(tituloCantidad);

		RoundedTextField textNum = new RoundedTextField(20, 20);
		textNum.setSize(350, 60);
		textNum.setLocation(40, 340);
		textNum.setText("");
		textNum.setForeground(Color.black);
		textNum.setFont(new Font("belanosima", Font.BOLD, 24));
		textNum.setHorizontalAlignment(JTextField.LEFT);
		textNum.setBackground(Color.decode("#E8E2DD"));
		textNum.setForeground(Color.decode("#756B64"));
		textNum.setOpaque(false);
		textNum.setBorder(null);
		textNum.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textNum);

		// Campo unidad
		JLabel tituloUnidad = new JLabel("Unidad de medida");
		tituloUnidad.setSize(300, 40);
		tituloUnidad.setLocation(450, 280);
		tituloUnidad.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloUnidad.setOpaque(false);
		panel.add(tituloUnidad);

		// Texto pieza
		RoundedTextField textPieza = new RoundedTextField(20, 20);
		textPieza.setSize(350, 60);
		textPieza.setLocation(450, 340);
		textPieza.setText("");
		textPieza.setForeground(Color.black);
		textPieza.setFont(new Font("belanosima", Font.BOLD, 24));
		textPieza.setHorizontalAlignment(JTextField.LEFT);
		textPieza.setBackground(Color.decode("#E8E2DD"));
		textPieza.setForeground(Color.decode("#756B64"));
		textPieza.setOpaque(false);
		textPieza.setBorder(null);
		textPieza.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textPieza);

		// Campo platillo
		JLabel tituloCantidad1 = new JLabel("Cantidad minima");
		tituloCantidad1.setSize(300, 40);
		tituloCantidad1.setLocation(40, 440);
		tituloCantidad1.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCantidad1.setOpaque(false);
		panel.add(tituloCantidad1);

		// Texto num
		RoundedTextField textNum2 = new RoundedTextField(20, 20);
		textNum2.setSize(760, 60);
		textNum2.setLocation(40, 500);
		textNum2.setText("");
		textNum2.setForeground(Color.black);
		textNum2.setFont(new Font("belanosima", Font.BOLD, 24));
		textNum2.setHorizontalAlignment(JTextField.LEFT);
		textNum2.setBackground(Color.decode("#E8E2DD"));
		textNum2.setForeground(Color.decode("#756B64"));
		textNum2.setOpaque(false);
		textNum2.setBorder(null);
		textNum2.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textNum2);

		// Botones guardar y cancelar
		RoundedButton btnGuardar = new RoundedButton("Guardar cambios", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 620);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			router("inventario");
		});
		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(280, 620);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			router("inventario");
		});
		panel.add(btnCancelar);
	}
	
	public void verPlatilloEnchiladasrojas() {
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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
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

				g2d.setColor(Color.decode("#DEDEDE"));
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

		// Campo imagen
		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/enchiladas.jpg"));
		Image img9 = icon9.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);
		RoundedImageButton btnImagen = new RoundedImageButton(scaledIcon9, 40);

		btnImagen.setSize(350, 350);
		btnImagen.setLocation(50, 50);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		panel.add(btnImagen);

		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/no_disponible.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(scaledImage);
		JLabel labelImagen = new JLabel(finalIcon);
		labelImagen.setBounds(690, 45, 150, 50);
		panel.add(labelImagen);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Enchiladas rojas");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(415, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo nombre tacos
		JLabel tituloNombre1 = new JLabel("Enchiladas");
		tituloNombre1.setSize(300, 40);
		tituloNombre1.setLocation(420, 95);
		tituloNombre1.setFont(new Font("belanosima", Font.BOLD, 18));
		tituloNombre1.setOpaque(false);
		panel.add(tituloNombre1);

		// Campo nombre precio
		JLabel tituloPrecio = new JLabel("Precio");
		tituloPrecio.setSize(300, 40);
		tituloPrecio.setLocation(420, 150);
		tituloPrecio.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloPrecio.setOpaque(false);
		panel.add(tituloPrecio);

		// Campo nombre precio
		JLabel tituloPrecio1 = new JLabel("$105");
		tituloPrecio1.setSize(300, 40);
		tituloPrecio1.setLocation(420, 190);
		tituloPrecio1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloPrecio1.setForeground(Color.decode("#DC542B"));
		tituloPrecio1.setOpaque(false);
		panel.add(tituloPrecio1);

		// Campo nombre precio
		JLabel tituloDescripcion = new JLabel("Descripción");
		tituloDescripcion.setSize(300, 40);
		tituloDescripcion.setLocation(420, 250);
		tituloDescripcion.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloDescripcion.setOpaque(false);
		panel.add(tituloDescripcion);

		// Campo nombre precio
		JLabel tituloDescripcion1 = new JLabel(
				"<html> Tortilla de maíz, pollo, queso fresco y cilantro.</html>");
		tituloDescripcion1.setSize(350, 50);
		tituloDescripcion1.setLocation(420, 300);
		tituloDescripcion1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDescripcion1.setOpaque(false);
		panel.add(tituloDescripcion1);

		ImageIcon icon10 = new ImageIcon(getClass().getResource("/images/editar.png"));
		Image img10 = icon10.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon10 = new ImageIcon(img10);

		RoundedButton btnEditar = new RoundedButton("Editar", 20, scaledIcon10);
		btnEditar.setSize(170, 50);
		btnEditar.setLocation(380, 420);
		btnEditar.setBackground(Color.decode("#DC542B"));
		btnEditar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEditar.setVerticalTextPosition(SwingConstants.CENTER);
		btnEditar.setForeground(Color.white);

		btnEditar.addActionListener(e -> {
			router("editarPlatilloEnchiladasrojas");
		});

		panel.add(btnEditar);

		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/download.png"));
		Image img11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnDescargar = new RoundedButton("Descargar PDF", 20, scaledIcon11);
		btnDescargar.setSize(250, 50);
		btnDescargar.setLocation(570, 420);
		btnDescargar.setBackground(Color.decode("#DC542B"));
		btnDescargar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnDescargar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDescargar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDescargar.setVerticalTextPosition(SwingConstants.CENTER);
		btnDescargar.setForeground(Color.white);
		panel.add(btnDescargar);

		JPanel linea2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#DEDEDE"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea2.setBounds(0, 500, 1000, 1);
		linea2.setOpaque(false);
		panel.add(linea2);

		// Campo ingrediente
		JLabel tituloIngredientes = new JLabel("Ingredientes");
		tituloIngredientes.setSize(300, 40);
		tituloIngredientes.setLocation(50, 530);
		tituloIngredientes.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloIngredientes.setOpaque(false);
		panel.add(tituloIngredientes);

		// Texto ingrediente tortilla
		RoundedTextField textTortilla = new RoundedTextField(20, 20);
		textTortilla.setSize(700, 90);
		textTortilla.setLocation(50, 625);
		textTortilla.setText("Tortillaz de maíz");
		textTortilla.setForeground(Color.black);
		textTortilla.setFont(new Font("belanosima", Font.BOLD, 20));
		textTortilla.setHorizontalAlignment(JTextField.LEFT);
		textTortilla.setBackground(Color.decode("#E8E2DD"));
		textTortilla.setOpaque(false);
		textTortilla.setBorder(null);
		textTortilla.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textTortilla);

		JLabel tituloCantidad = new JLabel("3 piezas requeridas");
		tituloCantidad.setSize(300, 40);
		tituloCantidad.setLocation(15, 40);
		tituloCantidad.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad.setForeground(Color.gray);
		tituloCantidad.setOpaque(false);
		textTortilla.add(tituloCantidad);

		// Texto ingrediente carne
		RoundedTextField textCarne = new RoundedTextField(20, 20);
		textCarne.setSize(700, 90);
		textCarne.setLocation(50, 750);
		textCarne.setText("Pollo");
		textCarne.setForeground(Color.black);
		textCarne.setFont(new Font("belanosima", Font.BOLD, 20));
		textCarne.setHorizontalAlignment(JTextField.LEFT);
		textCarne.setBackground(Color.decode("#E8E2DD"));
		textCarne.setOpaque(false);
		textCarne.setBorder(null);
		textCarne.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textCarne);

		JLabel tituloCantidad1 = new JLabel("0.15 Kg requeridos");
		tituloCantidad1.setSize(300, 40);
		tituloCantidad1.setLocation(15, 40);
		tituloCantidad1.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad1.setForeground(Color.gray);
		tituloCantidad1.setOpaque(false);
		textCarne.add(tituloCantidad1);

		// Texto ingrediente cebolla
		RoundedTextField textCebolla = new RoundedTextField(20, 20);
		textCebolla.setSize(700, 90);
		textCebolla.setLocation(50, 875);
		textCebolla.setText("Queso fresco");
		textCebolla.setForeground(Color.black);
		textCebolla.setFont(new Font("belanosima", Font.BOLD, 20));
		textCebolla.setHorizontalAlignment(JTextField.LEFT);
		textCebolla.setBackground(Color.decode("#FAEAEA"));
		textCebolla.setForeground(Color.decode("#C62828"));
		textCebolla.setOpaque(false);
		textCebolla.setBorder(null);
		textCebolla.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textCebolla);

		JLabel tituloCantidad2 = new JLabel("0.05 Kg requerido");
		tituloCantidad2.setSize(300, 40);
		tituloCantidad2.setLocation(15, 40);
		tituloCantidad2.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad2.setForeground(Color.decode("#C62828"));
		tituloCantidad2.setOpaque(false);
		textCebolla.add(tituloCantidad2);
		
		JLabel tituloInsuficiente = new JLabel("Insuficiente");
		tituloInsuficiente.setSize(300, 40);
		tituloInsuficiente.setLocation(580, 13);
		tituloInsuficiente.setFont(new Font("belanosima", Font.BOLD, 18));
		tituloInsuficiente.setForeground(Color.decode("#C62828"));
		tituloInsuficiente.setOpaque(false);
		textCebolla.add(tituloInsuficiente);

		// Texto ingrediente cebolla
		RoundedTextField textCilantro = new RoundedTextField(20, 20);
		textCilantro.setSize(700, 90);
		textCilantro.setLocation(50, 1000);
		textCilantro.setText("Cilantro");
		textCilantro.setForeground(Color.black);
		textCilantro.setFont(new Font("belanosima", Font.BOLD, 20));
		textCilantro.setHorizontalAlignment(JTextField.LEFT);
		textCilantro.setBackground(Color.decode("#E8E2DD"));
		textCilantro.setOpaque(false);
		textCilantro.setBorder(null);
		textCilantro.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textCilantro);

		JLabel tituloCantidad3 = new JLabel("0.25 kg requerido");
		tituloCantidad3.setSize(300, 40);
		tituloCantidad3.setLocation(15, 40);
		tituloCantidad3.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad3.setForeground(Color.gray);
		tituloCantidad3.setOpaque(false);
		textCilantro.add(tituloCantidad3);
	}
	
	public void editarPlatilloEnchiladasrojas() {
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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
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

				g2d.setColor(Color.decode("#DEDEDE"));
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

		JLabel textNuevoplatillo = new JLabel("Editar platillo");
		textNuevoplatillo.setSize(300, 50);
		textNuevoplatillo.setLocation(50, 40);
		textNuevoplatillo.setFont(new Font("belanosima", Font.BOLD, 36));
		textNuevoplatillo.setOpaque(false);
		panel.add(textNuevoplatillo);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Nombre");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 110);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		RoundedTextField textNombre = new RoundedTextField(20, 20);
		textNombre.setSize(300, 40);
		textNombre.setLocation(50, 150);
		textNombre.setText("Enchiladas rojas");
		textNombre.setForeground(Color.gray);
		textNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		textNombre.setHorizontalAlignment(JTextField.CENTER);
		textNombre.setBackground(Color.decode("#E8E2DD"));
		textNombre.setOpaque(false);
		textNombre.setBorder(null);
		panel.add(textNombre);

		// Campo categoria
		JLabel tituloCategoria = new JLabel("Categoria");
		tituloCategoria.setSize(300, 40);
		tituloCategoria.setLocation(500, 110);
		tituloCategoria.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCategoria.setOpaque(false);
		panel.add(tituloCategoria);

		RoundedTextField textCategoria = new RoundedTextField(20, 20);
		textCategoria.setSize(300, 40);
		textCategoria.setLocation(500, 150);
		textCategoria.setText("Enchiladas");
		textCategoria.setForeground(Color.gray);
		textCategoria.setFont(new Font("belanosima", Font.BOLD, 20));
		textCategoria.setHorizontalAlignment(JTextField.CENTER);
		textCategoria.setBackground(Color.decode("#E8E2DD"));
		textCategoria.setOpaque(false);
		textCategoria.setBorder(null);
		panel.add(textCategoria);

		// Campo descripcion
		JLabel tituloDescripcion = new JLabel("Descripción");
		tituloDescripcion.setSize(300, 200);
		tituloDescripcion.setLocation(50, 130);
		tituloDescripcion.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDescripcion.setOpaque(false);
		panel.add(tituloDescripcion);

		RoundedTextArea textDescripcion = new RoundedTextArea(20);
		textDescripcion.setSize(750, 80);
		textDescripcion.setLocation(50, 250);
		textDescripcion.setText("Enchiladas bañadas en salsa roja con pollo y crema");
		textDescripcion.setForeground(Color.gray);
		textDescripcion.setFont(new Font("belanosima", Font.BOLD, 18));
		textDescripcion.setBackground(Color.decode("#E8E2DD"));
		textDescripcion.setOpaque(false);
		textDescripcion.setBorder(null);
		panel.add(textDescripcion);

		// Campo precio
		JLabel tituloPrecio = new JLabel("Precio");
		tituloPrecio.setSize(300, 40);
		tituloPrecio.setLocation(50, 360);
		tituloPrecio.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloPrecio.setOpaque(false);
		panel.add(tituloPrecio);

		RoundedTextField textPrecio = new RoundedTextField(20, 20);
		textPrecio.setSize(300, 40);
		textPrecio.setLocation(50, 400);
		textPrecio.setText("$105");
		textPrecio.setForeground(Color.gray);
		textPrecio.setFont(new Font("belanosima", Font.BOLD, 20));
		textPrecio.setHorizontalAlignment(JTextField.CENTER);
		textPrecio.setBackground(Color.decode("#E8E2DD"));
		textPrecio.setOpaque(false);
		textPrecio.setBorder(null);
		panel.add(textPrecio);

		// Campo imagen
		JLabel tituloImagen = new JLabel("Imagen");
		tituloImagen.setSize(300, 40);
		tituloImagen.setLocation(500, 360);
		tituloImagen.setFont(new Font("belanosima", Font.BOLD, 20));
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
		tituloIngredientes.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloIngredientes.setOpaque(false);
		panel.add(tituloIngredientes);

		// Boton agregar ingrediente
		RoundedButton btnAgregaring = new RoundedButton("+ Agregar ingrediente", 20);
		btnAgregaring.setSize(250, 30);
		btnAgregaring.setLocation(500, 530);
		btnAgregaring.setBackground(Color.decode("#FFFFFF"));
		btnAgregaring.setOpaque(false);
		btnAgregaring.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregaring.setForeground(Color.decode("#DC542B"));
		panel.add(btnAgregaring);

		// Texto ingrediente tortilla
		RoundedTextField textIngTortilla = new RoundedTextField(20, 20);
		textIngTortilla.setSize(400, 60);
		textIngTortilla.setLocation(50, 625);
		textIngTortilla.setText("Tortilla de maíz (piezas)");
		textIngTortilla.setForeground(Color.gray);
		textIngTortilla.setFont(new Font("belanosima", Font.BOLD, 20));
		textIngTortilla.setHorizontalAlignment(JTextField.CENTER);
		textIngTortilla.setBackground(Color.decode("#E8E2DD"));
		textIngTortilla.setOpaque(false);
		textIngTortilla.setBorder(null);
		panel.add(textIngTortilla);

		RoundedTextField textNumTortilla = new RoundedTextField(20, 20);
		textNumTortilla.setSize(100, 60);
		textNumTortilla.setLocation(500, 625);
		textNumTortilla.setText("4");
		textNumTortilla.setForeground(Color.gray);
		textNumTortilla.setFont(new Font("belanosima", Font.BOLD, 20));
		textNumTortilla.setHorizontalAlignment(JTextField.CENTER);
		textNumTortilla.setBackground(Color.decode("#E8E2DD"));
		textNumTortilla.setOpaque(false);
		textNumTortilla.setBorder(null);
		panel.add(textNumTortilla);
		
		ImageIcon iconX = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX = iconX.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX = new ImageIcon(imgX);

		JButton btnImagenX = new JButton(scaledIconX);
		btnImagenX.setSize(50, 50);
		btnImagenX.setLocation(625, 625);
		btnImagenX.setBackground(Color.decode("#E8E2DD"));
		btnImagenX.setForeground(Color.white);
		btnImagenX.setIconTextGap(10);
		btnImagenX.setBorder(null);
		btnImagenX.setFocusPainted(false);
		panel.add(btnImagenX);

		// Texto carne de res
		RoundedTextField textCarneRes = new RoundedTextField(20, 20);
		textCarneRes.setSize(400, 60);
		textCarneRes.setLocation(50, 725);
		textCarneRes.setText("Pollo (Kg)");
		textCarneRes.setForeground(Color.gray);
		textCarneRes.setFont(new Font("belanosima", Font.BOLD, 20));
		textCarneRes.setHorizontalAlignment(JTextField.CENTER);
		textCarneRes.setBackground(Color.decode("#E8E2DD"));
		textCarneRes.setOpaque(false);
		textCarneRes.setBorder(null);
		panel.add(textCarneRes);

		RoundedTextField textCarne = new RoundedTextField(20, 20);
		textCarne.setSize(100, 60);
		textCarne.setLocation(500, 725);
		textCarne.setText("0.15");
		textCarne.setForeground(Color.gray);
		textCarne.setFont(new Font("belanosima", Font.BOLD, 20));
		textCarne.setHorizontalAlignment(JTextField.CENTER);
		textCarne.setBackground(Color.decode("#E8E2DD"));
		textCarne.setOpaque(false);
		textCarne.setBorder(null);
		panel.add(textCarne);
		
		ImageIcon iconX1 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX1 = iconX1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX1 = new ImageIcon(imgX1);

		JButton btnImagenX1 = new JButton(scaledIconX1);
		btnImagenX1.setSize(50, 50);
		btnImagenX1.setLocation(625, 725);
		btnImagenX1.setBackground(Color.decode("#E8E2DD"));
		btnImagenX1.setForeground(Color.white);
		btnImagenX1.setIconTextGap(10);
		btnImagenX1.setBorder(null);
		btnImagenX1.setFocusPainted(false);
		panel.add(btnImagenX1);

		// Texto cebolla
		RoundedTextField textIngCebolla = new RoundedTextField(20, 20);
		textIngCebolla.setSize(400, 60);
		textIngCebolla.setLocation(50, 825);
		textIngCebolla.setText("Queso fresco (Kg)");
		textIngCebolla.setForeground(Color.decode("#C62828"));
		textIngCebolla.setFont(new Font("belanosima", Font.BOLD, 20));
		textIngCebolla.setHorizontalAlignment(JTextField.CENTER);
		textIngCebolla.setBackground(Color.decode("#E8E2DD"));
		textIngCebolla.setOpaque(false);
		textIngCebolla.setBorder(null);
		panel.add(textIngCebolla);

		RoundedTextField textCebolla = new RoundedTextField(20, 20);
		textCebolla.setSize(100, 60);
		textCebolla.setLocation(500, 825);
		textCebolla.setText("0.05");
		textCebolla.setForeground(Color.decode("#C62828"));
		textCebolla.setFont(new Font("belanosima", Font.BOLD, 20));
		textCebolla.setHorizontalAlignment(JTextField.CENTER);
		textCebolla.setBackground(Color.decode("#E8E2DD"));
		textCebolla.setOpaque(false);
		textCebolla.setBorder(null);
		panel.add(textCebolla);
		
		ImageIcon iconX2 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX2 = iconX2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX2 = new ImageIcon(imgX2);

		JButton btnImagenX2 = new JButton(scaledIconX2);
		btnImagenX2.setSize(50, 50);
		btnImagenX2.setLocation(625, 825);
		btnImagenX2.setBackground(Color.decode("#E8E2DD"));
		btnImagenX2.setForeground(Color.white);
		btnImagenX2.setIconTextGap(10);
		btnImagenX2.setBorder(null);
		btnImagenX2.setFocusPainted(false);
		panel.add(btnImagenX2);

		// Texto cilantro
		RoundedTextField textIngCilantro = new RoundedTextField(20, 20);
		textIngCilantro.setSize(400, 60);
		textIngCilantro.setLocation(50, 925);
		textIngCilantro.setText("Cilantro (manojo)");
		textIngCilantro.setForeground(Color.gray);
		textIngCilantro.setFont(new Font("belanosima", Font.BOLD, 20));
		textIngCilantro.setHorizontalAlignment(JTextField.CENTER);
		textIngCilantro.setBackground(Color.decode("#E8E2DD"));
		textIngCilantro.setOpaque(false);
		textIngCilantro.setBorder(null);
		panel.add(textIngCilantro);

		RoundedTextField textCilantro = new RoundedTextField(20, 20);
		textCilantro.setSize(100, 60);
		textCilantro.setLocation(500, 925);
		textCilantro.setText("0.02");
		textCilantro.setForeground(Color.gray);
		textCilantro.setFont(new Font("belanosima", Font.BOLD, 20));
		textCilantro.setHorizontalAlignment(JTextField.CENTER);
		textCilantro.setBackground(Color.decode("#E8E2DD"));
		textCilantro.setOpaque(false);
		textCilantro.setBorder(null);
		panel.add(textCilantro);
		
		ImageIcon iconX3 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX3 = iconX3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX3 = new ImageIcon(imgX3);

		JButton btnImagenX3 = new JButton(scaledIconX3);
		btnImagenX3.setSize(50, 50);
		btnImagenX3.setLocation(625, 925);
		btnImagenX3.setBackground(Color.decode("#E8E2DD"));
		btnImagenX3.setForeground(Color.white);
		btnImagenX3.setIconTextGap(10);
		btnImagenX3.setBorder(null);
		btnImagenX3.setFocusPainted(false);
		panel.add(btnImagenX3);

		RoundedButton btnGuardar = new RoundedButton("Guardar cambio", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 1025);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			router("platillos");
		});
		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(270, 1025);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			router("platillos");
		});
		panel.add(btnCancelar);
	}
	
	public void verOrdenesMarta() {
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
		contenido.setPreferredSize(new Dimension(930, 900));

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("ordenes");
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

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 750);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/entregado.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(scaledImage);
		JLabel labelImagen = new JLabel(finalIcon);
		labelImagen.setBounds(690, 45, 150, 50);
		panel.add(labelImagen);

		// Campo orden
		JLabel tituloNombre = new JLabel("Orden #2");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo detalles
		JLabel tituloDetalle = new JLabel("5 de abril, 2026 a las 13:02");
		tituloDetalle.setSize(300, 40);
		tituloDetalle.setLocation(50, 80);
		tituloDetalle.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle.setForeground(Color.decode("#756B64"));
		tituloDetalle.setOpaque(false);
		panel.add(tituloDetalle);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Información del cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(50, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 150);
		textDatos.setLocation(50, 200);
		textDatos.setText("Marta Meza");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-90, 20, 0, 0)); // Los valores son arriba, izquierda,abajo,
																				// derecha
		panel.add(textDatos);

		JLabel tituloEmail = new JLabel("martahabla67@gmail.com");
		tituloEmail.setSize(300, 40);
		tituloEmail.setLocation(20, 50);
		tituloEmail.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloEmail.setForeground(Color.decode("#756B64"));
		tituloEmail.setOpaque(false);
		textDatos.add(tituloEmail);

		JLabel tituloNumero = new JLabel("5523456789");
		tituloNumero.setSize(300, 40);
		tituloNumero.setLocation(20, 95);
		tituloNumero.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNumero.setForeground(Color.decode("#756B64"));
		tituloNumero.setOpaque(false);
		textDatos.add(tituloNumero);

		// Campo resumen
		JLabel tituloResumen = new JLabel("Resumen");
		tituloResumen.setSize(300, 40);
		tituloResumen.setLocation(500, 150);
		tituloResumen.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloResumen.setOpaque(false);
		panel.add(tituloResumen);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(350, 200);
		textDatosResu.setLocation(480, 200);
		textDatosResu.setText("Platillos");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-200, 20, -50, 10)); // Los valores son arriba,
																						// izquierda, abajo, derecha
		panel.add(textDatosResu);

		JLabel tituloNum = new JLabel("1");
		tituloNum.setSize(300, 40);
		tituloNum.setLocation(300, 5);
		tituloNum.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNum.setForeground(Color.decode("#756B64"));
		tituloNum.setOpaque(false);
		textDatosResu.add(tituloNum);

		JLabel tituloItems = new JLabel("Items totales");
		tituloItems.setSize(300, 40);
		tituloItems.setLocation(20, 50);
		tituloItems.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloItems.setForeground(Color.decode("#756B64"));
		tituloItems.setOpaque(false);
		textDatosResu.add(tituloItems);

		JLabel tituloNum2 = new JLabel("1");
		tituloNum2.setSize(300, 40);
		tituloNum2.setLocation(300, 50);
		tituloNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNum2.setForeground(Color.decode("#756B64"));
		tituloNum2.setOpaque(false);
		textDatosResu.add(tituloNum2);

		JPanel linea3 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea3.setBounds(20, 100, 300, 1);
		linea3.setOpaque(false);
		textDatosResu.add(linea3);

		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(20, 120);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal.setForeground(Color.decode("#000000"));
		tituloTotal.setOpaque(false);
		textDatosResu.add(tituloTotal);

		JLabel tituloTotalnum = new JLabel("$85");
		tituloTotalnum.setSize(300, 40);
		tituloTotalnum.setLocation(270, 120);
		tituloTotalnum.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotalnum.setForeground(Color.decode("#D44B28"));
		tituloTotalnum.setOpaque(false);
		textDatosResu.add(tituloTotalnum);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 450);
		tituloPlatillos.setFont(new Font("Arial", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Texto enchiladas
		RoundedTextField textEnchilada = new RoundedTextField(20, 20);
		textEnchilada.setSize(700, 90);
		textEnchilada.setLocation(40, 500);
		textEnchilada.setText("Tacos al pastor");
		textEnchilada.setForeground(Color.black);
		textEnchilada.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchilada.setHorizontalAlignment(JTextField.LEFT);
		textEnchilada.setBackground(Color.decode("#E8E2DD"));
		textEnchilada.setForeground(Color.decode("#756B64"));
		textEnchilada.setOpaque(false);
		textEnchilada.setBorder(null);
		textEnchilada.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textEnchilada);

		JLabel tituloCantidad = new JLabel("$85 x 1");
		tituloCantidad.setSize(300, 40);
		tituloCantidad.setLocation(15, 40);
		tituloCantidad.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCantidad.setForeground(Color.decode("#756B64"));
		tituloCantidad.setOpaque(false);
		textEnchilada.add(tituloCantidad);

		JLabel tituloTotal1 = new JLabel("$85");
		tituloTotal1.setSize(300, 40);
		tituloTotal1.setLocation(630, 25);
		tituloTotal1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal1.setForeground(Color.decode("#756B64"));
		tituloTotal1.setOpaque(false);
		textEnchilada.add(tituloTotal1);


		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/download.png"));
		Image img11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnDescargar = new RoundedButton("Descargar PDF", 20, scaledIcon11);
		btnDescargar.setSize(220, 50);
		btnDescargar.setLocation(50, 650);
		btnDescargar.setBackground(Color.decode("#DC542B"));
		btnDescargar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnDescargar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDescargar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDescargar.setVerticalTextPosition(SwingConstants.CENTER);
		btnDescargar.setForeground(Color.white);
		panel.add(btnDescargar);

	}
	
	public void editarOrdenesMarta() {
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
		contenido.setPreferredSize(new Dimension(930, 900));

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// Boton de volver
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("ordenes");
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

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 700);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Editar orden");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(40, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(40, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 60);
		textDatos.setLocation(40, 200);
		textDatos.setText("Marta Meza");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setForeground(Color.decode("#756B64"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0)); // Los valores son arriba, izquierda,abaj,
																			// // derecha
		panel.add(textDatos);

		// Campo estado
		JLabel tituloEstado = new JLabel("Estado");
		tituloEstado.setSize(300, 40);
		tituloEstado.setLocation(460, 150);
		tituloEstado.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloEstado.setOpaque(false);
		panel.add(tituloEstado);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(320, 60);
		textDatosResu.setLocation(460, 200);
		textDatosResu.setText("Entregado");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textDatosResu);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 300);
		tituloPlatillos.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Botone de agregar
		RoundedButton btnAgregarP = new RoundedButton("+ Agregar platillo", 20);
		btnAgregarP.setSize(200, 50);
		btnAgregarP.setLocation(600, 300);
		btnAgregarP.setBackground(Color.decode("#FFFFFF"));
		btnAgregarP.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregarP.setForeground(Color.decode("#DC542B"));
		btnAgregarP.setOpaque(false);
		panel.add(btnAgregarP);

		// Texto enchiladas
		RoundedTextField textEnchilada = new RoundedTextField(20, 20);
		textEnchilada.setSize(380, 60);
		textEnchilada.setLocation(40, 400);
		textEnchilada.setText("Tacos al pastor - $85");
		textEnchilada.setForeground(Color.black);
		textEnchilada.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchilada.setHorizontalAlignment(JTextField.LEFT);
		textEnchilada.setBackground(Color.decode("#E8E2DD"));
		textEnchilada.setForeground(Color.decode("#756B64"));
		textEnchilada.setOpaque(false);
		textEnchilada.setBorder(null);
		textEnchilada.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textEnchilada);

		RoundedTextField textEnchiladaNum = new RoundedTextField(20, 20);
		textEnchiladaNum.setSize(100, 60);
		textEnchiladaNum.setLocation(450, 400);
		textEnchiladaNum.setText("1");
		textEnchiladaNum.setForeground(Color.black);
		textEnchiladaNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchiladaNum.setHorizontalAlignment(JTextField.LEFT);
		textEnchiladaNum.setBackground(Color.decode("#E8E2DD"));
		textEnchiladaNum.setForeground(Color.decode("#756B64"));
		textEnchiladaNum.setOpaque(false);
		textEnchiladaNum.setBorder(null);
		textEnchiladaNum.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textEnchiladaNum.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textEnchiladaNum);

		RoundedTextField textEnchiladaNum2 = new RoundedTextField(20, 20);
		textEnchiladaNum2.setSize(150, 60);
		textEnchiladaNum2.setLocation(580, 400);
		textEnchiladaNum2.setText("$85");
		textEnchiladaNum2.setForeground(Color.black);
		textEnchiladaNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchiladaNum2.setHorizontalAlignment(JTextField.LEFT);
		textEnchiladaNum2.setBackground(Color.decode("#E8E2DD"));
		textEnchiladaNum2.setForeground(Color.decode("#756B64"));
		textEnchiladaNum2.setOpaque(false);
		textEnchiladaNum2.setBorder(null);
		textEnchiladaNum2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textEnchiladaNum2.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textEnchiladaNum2);

		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image img9 = icon9.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);

		JButton btnImagen = new JButton(scaledIcon9);
		btnImagen.setSize(50, 50);
		btnImagen.setLocation(750, 400);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		btnImagen.setForeground(Color.white);
		btnImagen.setIconTextGap(10);
		btnImagen.setBorder(null);
		btnImagen.setFocusPainted(false);
		panel.add(btnImagen);

		
		JPanel linea2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea2.setBounds(50, 500, 730, 1);
		linea2.setOpaque(false);
		panel.add(linea2);

		// Campo total
		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(40, 520);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotal.setOpaque(false);
		panel.add(tituloTotal);

		// Campo numero total
		JLabel tituloTotalNum = new JLabel("$85");
		tituloTotalNum.setSize(300, 40);
		tituloTotalNum.setLocation(720, 520);
		tituloTotalNum.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotalNum.setForeground(Color.decode("#DC542B"));
		tituloTotalNum.setOpaque(false);
		panel.add(tituloTotalNum);

		// Botones guardar y cancelar
		RoundedButton btnGuardar = new RoundedButton("Guardar cambios", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 620);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			router("ordenes");
		});
		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(280, 620);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			router("ordenes");
		});
		panel.add(btnCancelar);

	}
	
	public void verOrdenesSalma() {
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
		contenido.setPreferredSize(new Dimension(930, 900));

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
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
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("ordenes");
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

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 800);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/listo.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(scaledImage);
		JLabel labelImagen = new JLabel(finalIcon);
		labelImagen.setBounds(690, 45, 150, 50);
		panel.add(labelImagen);

		// Campo orden
		JLabel tituloNombre = new JLabel("Orden #3");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo detalles
		JLabel tituloDetalle = new JLabel("5 de abril, 2026 a las 15:24");
		tituloDetalle.setSize(300, 40);
		tituloDetalle.setLocation(50, 80);
		tituloDetalle.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle.setForeground(Color.decode("#756B64"));
		tituloDetalle.setOpaque(false);
		panel.add(tituloDetalle);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Información del cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(50, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 150);
		textDatos.setLocation(50, 200);
		textDatos.setText("Salma Castillo");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-90, 20, 0, 0)); // Los valores son arriba, izquierda,abajo,
																				// derecha
		panel.add(textDatos);

		JLabel tituloEmail = new JLabel("sss.alma@gmail.com");
		tituloEmail.setSize(300, 40);
		tituloEmail.setLocation(20, 50);
		tituloEmail.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloEmail.setForeground(Color.decode("#756B64"));
		tituloEmail.setOpaque(false);
		textDatos.add(tituloEmail);

		JLabel tituloNumero = new JLabel("553456789");
		tituloNumero.setSize(300, 40);
		tituloNumero.setLocation(20, 95);
		tituloNumero.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNumero.setForeground(Color.decode("#756B64"));
		tituloNumero.setOpaque(false);
		textDatos.add(tituloNumero);

		// Campo resumen
		JLabel tituloResumen = new JLabel("Resumen");
		tituloResumen.setSize(300, 40);
		tituloResumen.setLocation(500, 150);
		tituloResumen.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloResumen.setOpaque(false);
		panel.add(tituloResumen);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(350, 200);
		textDatosResu.setLocation(480, 200);
		textDatosResu.setText("Platillos");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-200, 20, -50, 10)); // Los valores son arriba,
																						// izquierda, abajo, derecha
		panel.add(textDatosResu);

		JLabel tituloNum = new JLabel("2");
		tituloNum.setSize(300, 40);
		tituloNum.setLocation(300, 5);
		tituloNum.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNum.setForeground(Color.decode("#756B64"));
		tituloNum.setOpaque(false);
		textDatosResu.add(tituloNum);

		JLabel tituloItems = new JLabel("Items totales");
		tituloItems.setSize(300, 40);
		tituloItems.setLocation(20, 50);
		tituloItems.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloItems.setForeground(Color.decode("#756B64"));
		tituloItems.setOpaque(false);
		textDatosResu.add(tituloItems);

		JLabel tituloNum2 = new JLabel("2");
		tituloNum2.setSize(300, 40);
		tituloNum2.setLocation(300, 50);
		tituloNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNum2.setForeground(Color.decode("#756B64"));
		tituloNum2.setOpaque(false);
		textDatosResu.add(tituloNum2);

		JPanel linea3 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea3.setBounds(20, 100, 300, 1);
		linea3.setOpaque(false);
		textDatosResu.add(linea3);

		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(20, 120);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal.setForeground(Color.decode("#000000"));
		tituloTotal.setOpaque(false);
		textDatosResu.add(tituloTotal);

		JLabel tituloTotalnum = new JLabel("$240");
		tituloTotalnum.setSize(300, 40);
		tituloTotalnum.setLocation(270, 120);
		tituloTotalnum.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotalnum.setForeground(Color.decode("#D44B28"));
		tituloTotalnum.setOpaque(false);
		textDatosResu.add(tituloTotalnum);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 450);
		tituloPlatillos.setFont(new Font("Arial", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Texto enchiladas
		RoundedTextField textEnchilada = new RoundedTextField(20, 20);
		textEnchilada.setSize(700, 90);
		textEnchilada.setLocation(40, 500);
		textEnchilada.setText("Sopes");
		textEnchilada.setForeground(Color.black);
		textEnchilada.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchilada.setHorizontalAlignment(JTextField.LEFT);
		textEnchilada.setBackground(Color.decode("#E8E2DD"));
		textEnchilada.setForeground(Color.decode("#756B64"));
		textEnchilada.setOpaque(false);
		textEnchilada.setBorder(null);
		textEnchilada.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textEnchilada);

		JLabel tituloCantidad = new JLabel("$115 x 1");
		tituloCantidad.setSize(300, 40);
		tituloCantidad.setLocation(15, 40);
		tituloCantidad.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCantidad.setForeground(Color.decode("#756B64"));
		tituloCantidad.setOpaque(false);
		textEnchilada.add(tituloCantidad);

		JLabel tituloTotal1 = new JLabel("$115");
		tituloTotal1.setSize(300, 40);
		tituloTotal1.setLocation(630, 25);
		tituloTotal1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal1.setForeground(Color.decode("#756B64"));
		tituloTotal1.setOpaque(false);
		textEnchilada.add(tituloTotal1);

		// Texto pozole verde
		RoundedTextField textPozole = new RoundedTextField(20, 20);
		textPozole.setSize(700, 90);
		textPozole.setLocation(40, 600);
		textPozole.setText("Pozole verde");
		textPozole.setForeground(Color.black);
		textPozole.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozole.setHorizontalAlignment(JTextField.LEFT);
		textPozole.setBackground(Color.decode("#E8E2DD"));
		textPozole.setForeground(Color.decode("#756B64"));
		textPozole.setOpaque(false);
		textPozole.setBorder(null);
		textPozole.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textPozole);

		JLabel tituloCantidad1 = new JLabel("$125 x 1");
		tituloCantidad1.setSize(300, 40);
		tituloCantidad1.setLocation(15, 40);
		tituloCantidad1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCantidad1.setForeground(Color.decode("#756B64"));
		tituloCantidad1.setOpaque(false);
		textPozole.add(tituloCantidad1);

		JLabel tituloTotal2 = new JLabel("$125");
		tituloTotal2.setSize(300, 40);
		tituloTotal2.setLocation(630, 25);
		tituloTotal2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal2.setForeground(Color.decode("#756B64"));
		tituloTotal2.setOpaque(false);
		textPozole.add(tituloTotal2);

		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/download.png"));
		Image img11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnDescargar = new RoundedButton("Descargar PDF", 20, scaledIcon11);
		btnDescargar.setSize(220, 50);
		btnDescargar.setLocation(50, 730);
		btnDescargar.setBackground(Color.decode("#DC542B"));
		btnDescargar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnDescargar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDescargar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDescargar.setVerticalTextPosition(SwingConstants.CENTER);
		btnDescargar.setForeground(Color.white);
		panel.add(btnDescargar);

	}
	
	public void editarOrdenesSalma() {
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
		contenido.setPreferredSize(new Dimension(930, 900));

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
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
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
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
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
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
			router("inicioSesion");
		});

		opciones.add(btnCerrar);

		// Boton de volver
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			router("ordenes");
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

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 800);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Editar orden");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(40, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(40, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 60);
		textDatos.setLocation(40, 200);
		textDatos.setText("Salma Castillo");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setForeground(Color.decode("#756B64"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0)); // Los valores son arriba, izquierda,abaj,
																			// // derecha
		panel.add(textDatos);

		// Campo estado
		JLabel tituloEstado = new JLabel("Estado");
		tituloEstado.setSize(300, 40);
		tituloEstado.setLocation(460, 150);
		tituloEstado.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloEstado.setOpaque(false);
		panel.add(tituloEstado);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(320, 60);
		textDatosResu.setLocation(460, 200);
		textDatosResu.setText("Listo");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textDatosResu);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 300);
		tituloPlatillos.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Botone de agregar
		RoundedButton btnAgregarP = new RoundedButton("+ Agregar platillo", 20);
		btnAgregarP.setSize(200, 50);
		btnAgregarP.setLocation(600, 300);
		btnAgregarP.setBackground(Color.decode("#FFFFFF"));
		btnAgregarP.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregarP.setForeground(Color.decode("#DC542B"));
		btnAgregarP.setOpaque(false);
		panel.add(btnAgregarP);

		// Texto enchiladas
		RoundedTextField textEnchilada = new RoundedTextField(20, 20);
		textEnchilada.setSize(380, 60);
		textEnchilada.setLocation(40, 400);
		textEnchilada.setText("Sopes - $115");
		textEnchilada.setForeground(Color.black);
		textEnchilada.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchilada.setHorizontalAlignment(JTextField.LEFT);
		textEnchilada.setBackground(Color.decode("#E8E2DD"));
		textEnchilada.setForeground(Color.decode("#756B64"));
		textEnchilada.setOpaque(false);
		textEnchilada.setBorder(null);
		textEnchilada.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textEnchilada);

		RoundedTextField textEnchiladaNum = new RoundedTextField(20, 20);
		textEnchiladaNum.setSize(100, 60);
		textEnchiladaNum.setLocation(450, 400);
		textEnchiladaNum.setText("1");
		textEnchiladaNum.setForeground(Color.black);
		textEnchiladaNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchiladaNum.setHorizontalAlignment(JTextField.LEFT);
		textEnchiladaNum.setBackground(Color.decode("#E8E2DD"));
		textEnchiladaNum.setForeground(Color.decode("#756B64"));
		textEnchiladaNum.setOpaque(false);
		textEnchiladaNum.setBorder(null);
		textEnchiladaNum.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textEnchiladaNum.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textEnchiladaNum);

		RoundedTextField textEnchiladaNum2 = new RoundedTextField(20, 20);
		textEnchiladaNum2.setSize(150, 60);
		textEnchiladaNum2.setLocation(580, 400);
		textEnchiladaNum2.setText("$115");
		textEnchiladaNum2.setForeground(Color.black);
		textEnchiladaNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchiladaNum2.setHorizontalAlignment(JTextField.LEFT);
		textEnchiladaNum2.setBackground(Color.decode("#E8E2DD"));
		textEnchiladaNum2.setForeground(Color.decode("#756B64"));
		textEnchiladaNum2.setOpaque(false);
		textEnchiladaNum2.setBorder(null);
		textEnchiladaNum2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textEnchiladaNum2.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textEnchiladaNum2);

		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image img9 = icon9.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);

		JButton btnImagen = new JButton(scaledIcon9);
		btnImagen.setSize(50, 50);
		btnImagen.setLocation(750, 400);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		btnImagen.setForeground(Color.white);
		btnImagen.setIconTextGap(10);
		btnImagen.setBorder(null);
		btnImagen.setFocusPainted(false);
		panel.add(btnImagen);

		// Texto pozole
		RoundedTextField textPozole = new RoundedTextField(20, 20);
		textPozole.setSize(380, 60);
		textPozole.setLocation(40, 500);
		textPozole.setText("Pozole verde - $125");
		textPozole.setForeground(Color.black);
		textPozole.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozole.setHorizontalAlignment(JTextField.LEFT);
		textPozole.setBackground(Color.decode("#E8E2DD"));
		textPozole.setForeground(Color.decode("#756B64"));
		textPozole.setOpaque(false);
		textPozole.setBorder(null);
		textPozole.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textPozole);

		RoundedTextField textPozoleNum = new RoundedTextField(20, 20);
		textPozoleNum.setSize(100, 60);
		textPozoleNum.setLocation(450, 500);
		textPozoleNum.setText("1");
		textPozoleNum.setForeground(Color.black);
		textPozoleNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozoleNum.setHorizontalAlignment(JTextField.LEFT);
		textPozoleNum.setBackground(Color.decode("#E8E2DD"));
		textPozoleNum.setForeground(Color.decode("#756B64"));
		textPozoleNum.setOpaque(false);
		textPozoleNum.setBorder(null);
		textPozoleNum.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textPozoleNum.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textPozoleNum);

		RoundedTextField textPozoleNum2 = new RoundedTextField(20, 20);
		textPozoleNum2.setSize(150, 60);
		textPozoleNum2.setLocation(580, 500);
		textPozoleNum2.setText("$125");
		textPozoleNum2.setForeground(Color.black);
		textPozoleNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozoleNum2.setHorizontalAlignment(JTextField.LEFT);
		textPozoleNum2.setBackground(Color.decode("#E8E2DD"));
		textPozoleNum2.setForeground(Color.decode("#756B64"));
		textPozoleNum2.setOpaque(false);
		textPozoleNum2.setBorder(null);
		textPozoleNum2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textPozoleNum2.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textPozoleNum2);

		ImageIcon icon10 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image img10 = icon10.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon10 = new ImageIcon(img10);

		JButton btnImagen2 = new JButton(scaledIcon10);
		btnImagen2.setSize(50, 50);
		btnImagen2.setLocation(750, 500);
		btnImagen2.setBackground(Color.decode("#E8E2DD"));
		btnImagen2.setForeground(Color.white);
		btnImagen2.setIconTextGap(10);
		btnImagen2.setBorder(null);
		btnImagen2.setFocusPainted(false);
		panel.add(btnImagen2);

		JPanel linea2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea2.setBounds(50, 600, 730, 1);
		linea2.setOpaque(false);
		panel.add(linea2);

		// Campo total
		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(40, 620);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotal.setOpaque(false);
		panel.add(tituloTotal);

		// Campo numero total
		JLabel tituloTotalNum = new JLabel("$240");
		tituloTotalNum.setSize(300, 40);
		tituloTotalNum.setLocation(720, 620);
		tituloTotalNum.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotalNum.setForeground(Color.decode("#DC542B"));
		tituloTotalNum.setOpaque(false);
		panel.add(tituloTotalNum);

		// Botones guardar y cancelar
		RoundedButton btnGuardar = new RoundedButton("Guardar cambios", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 720);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			router("ordenes");
		});
		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(280, 720);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			router("ordenes");
		});
		panel.add(btnCancelar);

	}
	
	

}
