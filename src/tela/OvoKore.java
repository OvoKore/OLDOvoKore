package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OvoKore {

	private JFrame frmOvokore;

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
	}

	private void initialize() {
		frmOvokore = new JFrame();
		frmOvokore.setResizable(false);
		frmOvokore.setTitle("OvoKore");
		frmOvokore.setIconImage(Toolkit.getDefaultToolkit().getImage(OvoKore.class.getResource("/img/yoshi.png")));
		frmOvokore.setBounds(100, 100, 230, 245);
		frmOvokore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOvokore.getContentPane().setLayout(null);
		
		JButton btnOrdemKore = new JButton("OrdemKore");
		btnOrdemKore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrdemKore ordemKore = new OrdemKore();
				ordemKore.OpenOrdemKore();
			}
		});
		btnOrdemKore.setBounds(10, 11, 194, 54);
		frmOvokore.getContentPane().add(btnOrdemKore);
		
		JButton btnCriaKore = new JButton("CriaKore");
		btnCriaKore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriaKore criaKore = new CriaKore();
				criaKore.OpenCriaKore();
			}
		});
		btnCriaKore.setBounds(10, 76, 194, 54);
		frmOvokore.getContentPane().add(btnCriaKore);
		
		JButton btnStartKore = new JButton("StartKore");
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