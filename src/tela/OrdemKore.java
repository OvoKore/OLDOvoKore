package tela;

import javax.swing.JFrame;
import javax.swing.JTextField;
import org.apache.commons.io.FileUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class OrdemKore {

	private JFrame frame;
	private JFrame frmOrdemkore;
	private JTextField txfRag;
	
	private BufferedReader buffread;
	private BufferedWriter buffwriter;
	private FileWriter writer;
	
	public void OpenOrdemKore() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdemKore window = new OrdemKore();
					window.frmOrdemkore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public OrdemKore() {
		initialize();
	}

	private void initialize() {
		frmOrdemkore = new JFrame();
		frmOrdemkore.setIconImage(Toolkit.getDefaultToolkit().getImage(OrdemKore.class.getResource("/img/yoshi.png")));
		frmOrdemkore.setTitle("OrdemKore");
		frmOrdemkore.setResizable(false);
		frmOrdemkore.setBounds(100, 100, 422, 112);
		frmOrdemkore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmOrdemkore.getContentPane().setLayout(null);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 439, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnStart = new JButton("Contemple o ovo!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iniciar();
			}
		});
		
		btnStart.setBounds(10, 39, 386, 23);
		frmOrdemkore.getContentPane().add(btnStart);
		
		JLabel lblRag = new JLabel("Pasta rag");
		lblRag.setBounds(10, 14, 56, 14);
		frmOrdemkore.getContentPane().add(lblRag);
		
		txfRag = new JTextField();
		txfRag.setColumns(10);
		txfRag.setBounds(76, 8, 215, 20);
		frmOrdemkore.getContentPane().add(txfRag);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home").toString());
					fileChooser.setMultiSelectionEnabled(false);
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int showOpenDialog = fileChooser.showOpenDialog(frame);
					if (showOpenDialog != JFileChooser.APPROVE_OPTION)
						return;
					File uploadDir = fileChooser.getSelectedFile();
					txfRag.setText(uploadDir.getAbsolutePath());;;
			}
		});
		btnSelecionar.setBounds(301, 5, 95, 23);
		frmOrdemkore.getContentPane().add(btnSelecionar);
	}
	
	public void Iniciar() {

		if(new File("poseidon\\ordemkore.txt").exists() == false)
			F00();
		else {
			try {
				buffread = new BufferedReader(new FileReader("poseidon\\ordemkore.txt"));
				String linha = buffread.readLine();
				buffread.close();
				switch (linha) {
					case "01": F01(); break;
					case "02": F02(); break;
					case "03": F03(); break;
					case "04": F04(); break;
					case "05": F05(); break;
					case "06": F06(); break;
					case "07": F07(); break;
					case "08": F08(); break;
					case "09": F09(); break;
					case "10": F10(); break;
					case "11": F11(); break;
					case "12": F12(); break;
					case "13": F13(); break;
					case "14": F14(); break;
					case "15": F15(); break;
					case "16": F16(); break;
					case "17": F17(); break;
					case "18": F18(); break;
					case "19": F19(); break;
					default:
						JOptionPane.showMessageDialog(null, "Valor inválido para o arquivo \"ordemkore.txt\"");
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo \"poseidon\\ordemkore.txt\"");
			}

		}
	}
	
	//MODIFICAORDEMKORE.TXT
	public void Modifica(String valor) {
		try {
			Path path = Paths.get("poseidon\\ordemkore.txt");
			List<String> linhas = new ArrayList<String>();
			linhas.add(valor);
			Files.write(path, linhas);      
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao modificar o \"poseidon\\ordemkore.txt\"");
			return;
		}
		Iniciar();
	}
	
	//COPIA PASTA RAGNAROK E CRIA ORDEMKORE.TXT
	public void F00() {
		
		if(new File(txfRag.getText() + "//Ragnarok.exe").exists() && new File(txfRag.getText() + "//Ragexe.exe").exists()){
			try {
				JOptionPane.showMessageDialog(null, "Copiando a pasta \"Ragnarok\" com o nome \"poseidon\", isso pode demorar um pouco");
				FileUtils.copyDirectory(new File(txfRag.getText()), new File("poseidon\\"));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao copiar a pasta do \"Ragnarok\"");
				return;
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Pasta \"Ragnarok\" não encontrada");
			return;
		}
		
		try {
			writer = new FileWriter(new File("poseidon\\ordemkore.txt"));
			buffwriter = new BufferedWriter(writer);
			buffwriter.write("01");
			buffwriter.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar \"Poseidon\\ordemkore.txt\" na pasta ");
			return;
		}
		Iniciar();
	}
	
	//BAIXA O RGZ
	public void F01() {
		try {
			FileUtils.copyURLToFile(new URL("https://mirror.irowiki.org/ragnarok/RGZ_Tools.zip"), new File("poseidon\\download\\RGZ_Tools.zip"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao baixar o RGZ_Tools.zip");
			return;
		}
		Modifica("02");
	}
	
	//DESCOMPACTA O RGZ
	public void F02() {
		try {
			byte[] by = new byte[1024];
			ZipInputStream zis = new ZipInputStream(new FileInputStream("poseidon\\download\\RGZ_Tools.zip"));
			ZipEntry ze = zis.getNextEntry();
			while (ze != null) {
				File newFile = new File("poseidon\\download\\RGZ_Tools" + File.separator + ze.getName());
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(by)) > 0)
					fos.write(by, 0, len);
				fos.close();
				ze = zis.getNextEntry();
			}
			zis.closeEntry();
			zis.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao descompactar o RGZ_Tools.zip");
			return;
		}
		
		Modifica("03");
	}
	
	//CRIA O GERADOR.BAT
	public void F03() {
		try {
			writer = new FileWriter("poseidon\\download\\RGZ_Tools\\Gerador.bat");
			buffwriter = new BufferedWriter(writer);
			buffwriter.write("gzip -dc 2016-11-03aRagexe.rgz | rat -d\nexit");
			buffwriter.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro na criação do \"poseidon\\download\\RGZ_Tools\\Gerador.bat\"");
			return;
		}
		Modifica("04");
	}
	
	//BAIXA O RAGEXE.RGZ
	public void F04() {
		try {
			FileUtils.copyURLToFile(new URL("ftp://download.levelupgames.com.br/patch/2016-11-03aRagexe.rgz"), new File("poseidon\\download\\RGZ_Tools\\2016-11-03aRagexe.rgz"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao baixar o 2016-11-03aRagexe.rgz");
			return;
		}
		Modifica("05");
	}
	
	//EXECUTA O GERADOR.BAT
	public void F05() {
		try {
			Runtime.getRuntime().exec(new String[] { "cmd", "/C", "Gerador.bat" }, null, new File("poseidon\\download\\RGZ_Tools"));	
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao executar o \"poseidon\\download\\RGZ_Tools\\Gerador.bat\"");
			return;
		}
		
		try {
			new Thread();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Erro ao esperar o \"poseidon\\download\\RGZ_Tools\\Gerador.bat\" executar");
			return;
		}
		Modifica("06");
	}
	
	//COPIA O POSEIDON.EXE PARA A PASTA POSEIDON
	public void F06() {
		try {
	    	FileUtils.copyFile(new File("poseidon\\download\\RGZ_Tools\\Ragexe.exe"), new File("poseidon\\Poseidon.exe"));
	    } catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao copiar o \"Ragexe.exe\" como \"Poseidon.exe\" para a pasta \"Poseidon\"");
			return;
	    }
		Modifica("07");
	}
	
	//CRIA ARQUIVO STARTPOSEIDON.BAT NA PASTA POSEIDON
	public void F07() {
		try {
			FileWriter ger = new FileWriter(new File("poseidon\\startPoseidon.bat"));
			buffwriter = new BufferedWriter(ger);
			buffwriter.write("start Poseidon.exe 1rag1 /account:../data/poseidon.xml\r\nexit");
			buffwriter.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao startPoseidon.bat na pasta \"Poseidon\"");
			return;
		}
		Modifica("08");
	}
	
	//BAIXA O HADES DO GITHUB
	public void F08() {
		try {
			FileUtils.copyURLToFile(new URL("https://github.com/marcelothebuilder/hades/archive/master.zip"), new File("poseidon\\download\\hades-master.zip"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao baixar o hades-master.zip");
			return;
		}
		Modifica("09");
	}
	
	//DESCOMPACTA O HADES
	public void F09() {
		try(ZipFile file = new ZipFile("poseidon//download//hades-master.zip")) {
            FileSystem fileSystem = FileSystems.getDefault();
            Enumeration<? extends ZipEntry> entries = file.entries();
            String uncompressedDirectory = "poseidon//download//";
            while (entries.hasMoreElements())
            {
                ZipEntry entry = entries.nextElement();
                if (entry.isDirectory())
                    Files.createDirectories(fileSystem.getPath(uncompressedDirectory + entry.getName()));
                else
                {
                    InputStream is = file.getInputStream(entry);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    String uncompressedFileName = uncompressedDirectory + entry.getName();
                    Path uncompressedFilePath = fileSystem.getPath(uncompressedFileName);
                    Files.createFile(uncompressedFilePath);
                    FileOutputStream fileOutput = new FileOutputStream(uncompressedFileName);
                    while (bis.available() > 0)
                        fileOutput.write(bis.read());
                    fileOutput.close();
                }
            }
        } catch(IOException e) {
        	JOptionPane.showMessageDialog(null, "Erro ao descompactar o hades-master.zip");
        	return;
        }
		Modifica("10");
	}
	
    //MOVE A PASTA PLUGINS EXTRAIDA PARA A PASTA RAIZ DO OPENKORE
	public void F10() {
		try {
			FileUtils.copyDirectory(new File("poseidon\\download\\hades-master\\plugins"), new File("plugins"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao mover a pasta plugins do hades-master para a pasta raiz do openkore");
			return;		
		}
		Modifica("11");
	}
	
	//MODIFICA O CONTROL\SYS.TXT
	public void F11() {
		try {
			Path path = Paths.get("control\\sys.txt");
			List<String> linhas = new ArrayList<String>();
			buffread = new BufferedReader(
			new FileReader("control\\sys.txt"));
			while (buffread.ready()) {
				String linha = buffread.readLine();
				if (linha.length() > 16 && linha.substring(0, 16).equals("loadPlugins_list")) 
					linhas.add(linha + ",hades");
				else
					linhas.add(linha);
			}
			Files.write(path, linhas);
			buffread.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao modificar o \"control\\sys.txr\"");
			return;
		}
		Modifica("12");
	}
	
	//MODIFICAR O CONTROL\CONFIG.TXT
	public void F12() {		
		try {
			Path path = Paths.get("control\\config.txt");
			List<String> linhas = new ArrayList<String>();
			buffread = new BufferedReader(
			new FileReader("control\\config.txt"));
			while (buffread.ready()) {
				String linha = buffread.readLine();
				if (linha.length() >= 16 && linha.substring(0, 16).equals("XKore_listenPort")) 
					linhas.add("XKore_listenPort 6902");
				else
					linhas.add(linha);
			}
			Files.write(path, linhas);
			buffread.close();
			
			writer = new FileWriter(new File("control\\config.txt"), true);
			buffwriter = new BufferedWriter(writer);
			buffwriter.write("\ngameGuard 0\nhadesServer 127.0.0.1\nhadesPort 24666\n");
			buffwriter.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao modificar o arquivo \"control\\config.txt\"");
			return;
		}
		
		Modifica("13");
	}
	
	//MODIFICAR O CONTROL\POSEIDON.TXT
	public void F13() {		
		try {
			Path path = Paths.get("control\\poseidon.txt");
			List<String> linhas = new ArrayList<String>();
			buffread = new BufferedReader(
			new FileReader("control\\poseidon.txt"));
			while (buffread.ready()) {
				String linha = buffread.readLine();
				if (linha.equals("queryserver_port=24390")) 
					linhas.add("queryserver_port=24666");
				else
					linhas.add(linha);
			}
			Files.write(path, linhas);
			buffread.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao modificar o arquivo \"control\\poseidon.txt\"");
			return;
		}
		Modifica("14");
	}
	
	//MUDA SENHA DO PLUGINS\HADES.PL
	public void F14() {
		try {
			Path path = Paths.get("plugins\\hades.pl");
			List<String> linhas = new ArrayList<String>();
			buffread = new BufferedReader(
			new FileReader("plugins\\hades.pl"));
			while (buffread.ready()) {
				String linha = buffread.readLine();
				if (linha.length() > 13 && linha.substring(0, 13).equals("my $secretKey")) 
					linhas.add("my $secretKey = \"HADESNEW0987654321\";");
				else
					linhas.add(linha);
			}
			Files.write(path, linhas);
			buffread.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao modifica o \"plugins\\hades.pl\"");
			return;
		}
		Modifica("15");
	}
	
	//CRIA O POSEIDON.XML
	public void F15() {
		try {
			FileWriter fw = new FileWriter("poseidon\\data\\poseidon.xml");
			BufferedWriter conexao = new BufferedWriter(fw);
			conexao.write("<?xml version=\"1.0\" encoding=\"euc-kr\" ?>\r\n" + 
					"\r\n" + 
					"<clientinfo>\r\n" + 
					"    <servicetype>brazil</servicetype>\r\n" + 
					"    <servertype>primary</servertype>\r\n" + 
					"    <extendedslot></extendedslot>\r\n" + 
					"\t<connection>\r\n" + 
					"\t\t<display>Hades [6902]</display>\r\n" + 
					"\t\t<desc>None</desc>\r\n" + 
					"\t\t<address>127.0.0.1</address>\r\n" + 
					"\t\t<port>6902</port>\r\n" + 
					"\t\t<version>1</version>\r\n" + 
					"\t</connection>" +
					"\n</clientinfo>");
			conexao.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar poseidon.xml na pasta \"Poseidon\\Data\"");
			return;
		}
		Modifica("16");
	}
	
	//MODIFICAR O HADES-MASTER\CONF\SERVERTYPES.TXT
	public void F16() {
		try {
			writer = new FileWriter(new File("poseidon\\download\\hades-master\\conf\\servertypes.txt"), true);
			buffwriter = new BufferedWriter(writer);
			buffwriter.write("[bRO_2016-11-08a]\r\n" + 
					"decrypt_mid 1\r\n" + 
					"decrypt_mid_keys 0x17AC78C2 0x1ADE5C66 0x2A84793C\r\n" + 
					"charBlockSize 124\r\n" + 
					"charListPacket 0x82d\r\n" + 
					"maploginPacket 088E");
			buffwriter.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao modificar o arquivo \"hades-master\\conf\\servertypes.txt\"");
			return;
		}
		Modifica("17");
	}
	
	//MODIFICAR O HADES-MASTER\CONF\RECVPACKETS.TXT
	public void F17() {
		try {
			FileUtils.copyURLToFile(new URL("https://raw.githubusercontent.com/OpenKore/openkore/d5f277c0ca17221c92c268c5c4560d3844404ff6/tables/bRO/recvpackets.txt"), 
					new File("poseidon\\download\\hades-master\\conf\\recvpackets.txt"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao modificar o \"poseidon\\download\\hades-master\\conf\\recvpackets.txt\"");
			return;
		}
		Modifica("18");
	}
	
	//MODIFICAR O HADES-MASTER\CONF\POSEIDON.TXT
	public void F18() {
		try {
			Path path = Paths.get("poseidon\\download\\hades-master\\conf\\poseidon.txt");
			List<String> linhas = new ArrayList<String>();
			buffread = new BufferedReader(
			new FileReader("poseidon\\download\\hades-master\\conf\\poseidon.txt"));
			while (buffread.ready()) {
				String linha = buffread.readLine();
				if (linha.equals("ServerType=bRO_2016-04-03a")) 
					linhas.add("ServerType=bRO_2016-11-08a");
				else
					linhas.add(linha);
			}
			Files.write(path, linhas);
			buffread.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao modificar o \"poseidon\\download\\hades-master\\conf\\poseidon.txt\"");
			return;
		}
		Modifica("19");
	}
	
	//TUDO OK!
	public void F19() {
		JOptionPane.showMessageDialog(null, "Tudo pronto");
	}
}
