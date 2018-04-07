package tela;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.apache.commons.io.FileUtils;
import mslinks.ShellLink;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class CriaKore {

	private JFrame frmCriakore;
	private JTextField txf;

	public void OpenCriaKore() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriaKore window = new CriaKore();
					window.frmCriakore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CriaKore() {
		initialize();
	}

	private void initialize() {
		frmCriakore = new JFrame();
		frmCriakore.setTitle("CriaKore");
		frmCriakore.setIconImage(Toolkit.getDefaultToolkit().getImage(CriaKore.class.getResource("/img/yoshi.png")));
		frmCriakore.setResizable(false);
		frmCriakore.setBounds(100, 100, 265, 110);
		frmCriakore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCriakore.getContentPane().setLayout(null);
		
		JLabel lbl = new JLabel("Nome");
		lbl.setBounds(10, 11, 46, 14);
		frmCriakore.getContentPane().add(lbl);
		
		txf = new JTextField();
		txf.setBounds(66, 8, 173, 20);
		frmCriakore.getContentPane().add(txf);
		txf.setColumns(10);
		
		JButton btn = new JButton("Contemple o ovo!");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iniciar();
			}
		});
		btn.setBounds(10, 36, 229, 23);
		frmCriakore.getContentPane().add(btn);
	}
	
	public void Iniciar() {
		if (Pattern.compile("^[A-Za-z0-9]+$").matcher(txf.getText()).matches() == false) {
			JOptionPane.showMessageDialog(null, "Válido somente letras maiúsculas e minúsculas de \"A\" até \"Z\", e números");
			return;
		}
		
		if (new File("ordemkore").exists()) {
			File[] files = new File("ordemkore").listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					if (file.getName().equals(txf.getText())) {
						JOptionPane.showMessageDialog(null, "A pasta \"" + txf.getText() + "\" já existe dentro da pasta \"ordemkore\"");
						return;
					}
				}
			}
		}
		
		try {
			FileUtils.copyDirectory(new File("control"), new File("ordemkore\\" + txf.getText()));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar nova pasta \"control\" dentro da pasta \"ordemkore\"");
			return;
		}
		
		try {
			String caminho = CriaKore.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
			caminho = caminho.substring(1, caminho.lastIndexOf('/') + 1);
			ShellLink sl = ShellLink.createLink(caminho + "openkore.pl");
			sl.setCMDArgs("--config=\"" + caminho + "ordemkore/" + txf.getText() +"//config.txt");
			sl.saveTo(caminho + "ordemkore//" + txf.getText() + "//" + txf.getText() + ".lnk");
		} catch (URISyntaxException e) {
			JOptionPane.showMessageDialog(null, "Erro ao gerar o arquivo \"CriaKore " + txf.getText() + "\"");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao gerar o arquivo \"CriaKore " + txf.getText() + "\"");
		}
		
		JOptionPane.showMessageDialog(null, "Pasta criada com sucesso");
	}
}