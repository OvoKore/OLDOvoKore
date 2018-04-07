package tela;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartKore {

	private JFrame frmStartKore;
	
	private List<File> pastas = new ArrayList<File>();
	private int cont = 0;
	private JRadioButton botao = null;
	private List<JRadioButton> botoes = new ArrayList<JRadioButton>();
	
	public void OpenStartKore() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartKore window = new StartKore();
					window.frmStartKore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StartKore() {
		initialize();
	}

	private void initialize() {
		if (new File("ordemkore").exists() == false)
			JOptionPane.showMessageDialog(null, "A pasta \"ordemkore\" não existe");
		
		File[] files = new File("ordemkore").listFiles();
		for (File file : files) {
			if (file.isDirectory())
				pastas.add(file);
		}
		
		if(pastas.size() == 0)
			JOptionPane.showMessageDialog(null, "A pasta \"ordemkore\" está vazia");

		frmStartKore = new JFrame();
		frmStartKore.setIconImage(Toolkit.getDefaultToolkit().getImage(StartKore.class.getResource("/img/yoshi.png")));
		frmStartKore.setTitle("StartKore");
		frmStartKore.setBounds(100, 100, 240, 85 + (pastas.size() * 23));
		frmStartKore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmStartKore.getContentPane().setLayout(null);
		
		for (File file : pastas) {
			botao = new JRadioButton(file.getName());
			botao.setBounds(10, 7 + (cont++ * 23), 195, 23);
			frmStartKore.getContentPane().add(botao);
			botoes.add(botao);
		}	
	
		JButton btn = new JButton("Contemple o ovo!");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iniciar();
			}
		});
		btn.setBounds(10, 11 + (pastas.size() * 23), 195, 23);
		frmStartKore.getContentPane().add(btn);
	}
	
	public void Iniciar() {
		try {
			Runtime.getRuntime().exec(new String[] { "cmd", "/C", "start poseidon.pl" }, null, new File("poseidon\\download\\hades-master"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao abrir o \"poseidon\\download\\hades-master\\poseidon.pl\"");
		}
		
		Esperar(1);
		
		int poseidon = 0;
		for(JRadioButton abrir : botoes) {
			if(abrir.isSelected())
				poseidon++;
		}
		
		for(int i = 0; i < poseidon; i++) {
			try {
				JOptionPane.showMessageDialog(null, "Aperte \"ok\" para abrir o client - "  + String.valueOf(i+1) + "/" + poseidon);
				Runtime.getRuntime().exec(new String[] { "cmd", "/C", "startPoseidon.bat" }, null, new File("poseidon"));
				Esperar(5);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao abrir o \"poseidon\\startPoseidon.bat");
			}
		}
		
		JOptionPane.showMessageDialog(null, "Aperte \"ok\" para abrir o(s) bot(s)");
			
		for (JRadioButton selecionado : botoes) {
			String nome = new File(selecionado.getText()).getName();
			if (selecionado.isSelected()) {
				try {
					Runtime.getRuntime().exec(new String[] { "cmd", "/C", "start " + nome }, null, new File("ordemkore\\" + nome));
					Esperar(5);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Erro ao abrir o \"" + nome + "\"");
				}
			}
		}
	}
	
	public void Esperar(int sec) {
		try {
			new Thread();
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Erro");
		}
	}
}