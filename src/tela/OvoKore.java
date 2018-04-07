package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class OvoKore {

	private JFrame frmOvokore;
	private static JButton btnOrdemKore;
	private static JButton btnCriaKore;
	private static JButton btnStartKore;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OvoKore window = new OvoKore();
					window.frmOvokore.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OvoKore() {
		initialize();
		if (new File("control").exists() == false) {
			JOptionPane.showMessageDialog(frmOvokore, "O OvoKore não se encontra na pasta raiz do openkore\nFecha o Programa, mova-o para a pasta raiz do openkore e tente novamente");
			System.exit(0);
		}
	}

	private void initialize() {
		frmOvokore = new JFrame();
		frmOvokore.setResizable(false);
		frmOvokore.setTitle("OvoKore");
		frmOvokore.setIconImage(Toolkit.getDefaultToolkit().getImage(OvoKore.class.getResource("/img/yoshi.png")));
		frmOvokore.setBounds(100, 100, 230, 245);
		frmOvokore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOvokore.getContentPane().setLayout(null);
		
		btnOrdemKore = new JButton("OrdemKore");
		btnOrdemKore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdemKore ordemKore = new OrdemKore();
				ordemKore.OpenOrdemKore();
			}
		});
		btnOrdemKore.setBounds(10, 11, 194, 54);
		frmOvokore.getContentPane().add(btnOrdemKore);
		
		btnCriaKore = new JButton("CriaKore");
		btnCriaKore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriaKore criaKore = new CriaKore();
				criaKore.OpenCriaKore();
			}
		});
		btnCriaKore.setBounds(10, 76, 194, 54);
		frmOvokore.getContentPane().add(btnCriaKore);
		
		btnStartKore = new JButton("StartKore");
		btnStartKore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartKore startKore = new StartKore();
				startKore.OpenStartKore();
			}
		});
		btnStartKore.setBounds(10, 141, 194, 54);
		frmOvokore.getContentPane().add(btnStartKore);
	}
}