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
		if (new File("control").exists() == false) {
			JOptionPane.showMessageDialog(null, "O OvoKore não se encontra na pasta raiz do openkore");
			return;
		}

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
					case "20": F20(); break;
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
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao baixar o RGZ_Tools.zip");
			return;
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
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao baixar o 2016-11-03aRagexe.rgz");
			return;
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
			Thread.sleep(2000);
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
	
	//COPIA O XSTOOLS.DLL PARA A PASTA SRC/POSEIDON
	public void F08() {
		try {
			FileUtils.copyFileToDirectory(new File("XSTools.dll"), new File("src\\Poseidon"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao copiar o XSTools.dll para a pasta \"src\\Poseidon\"");
			return;
		}
		Modifica("09");
	}
	
	//BAIXA O HADES DO GITHUB
	public void F09() {
		try {
			FileUtils.copyURLToFile(new URL("https://github.com/marcelothebuilder/hades/archive/master.zip"), new File("poseidon\\download\\hades-master.zip"));
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao baixar o hades-master.zip");
			return;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao baixar o hades-master.zip");
			return;
		}
		Modifica("10");
	}
	
	//DESCOMPACTA O HADES
	public void F10() {
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
		Modifica("11");
	}
	
    //MOVE A PASTA PLUGINS EXTRAIDA PARA A PASTA RAIZ DO OPENKORE
	public void F11() {
		try {
			FileUtils.copyDirectory(new File("poseidon\\download\\hades-master\\plugins"), new File("plugins"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao mover a pasta plugins do hades-master para a pasta raiz do openkore");
			return;		
		}
		Modifica("12");
	}
	
	//MODIFICA O CONTROL\SYS.TXT
	public void F12() {
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
		Modifica("13");
	}
	
	//MODIFICAR O CONTROL\CONFIG.TXT
	public void F13() {		
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
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao modificar o arquivo \"control\\config.txt\"");
			return;
		}
		
		try {
			writer = new FileWriter(new File("control\\config.txt"), true);
			buffwriter = new BufferedWriter(writer);
			buffwriter.write("\ngameGuard 1\nhadesServer 127.0.0.1\nhadesPort 24666\n");
			buffwriter.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao modificar o arquivo \"control\\config.txt\"");
			return;
		}
		Modifica("14");
	}
	
	//MODIFICAR O CONTROL\POSEIDON.TXT
	public void F14() {		
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
		Modifica("15");
	}
	
	//MUDA SENHA DO PLUGINS\HADES.PL
	public void F15() {
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
		Modifica("16");
	}
	
	//CRIA O POSEIDON.XML
	public void F16() {
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
		Modifica("17");
	}
	
	//MODIFICAR O HADES-MASTER\CONF\SERVERTYPES.TXT
	public void F17() {
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
		Modifica("18");
	}
	
	//MODIFICAR O HADES-MASTER\CONF\RECVPACKETS.TXT
	public void F18() {
		try {
			Path path = Paths.get("poseidon\\download\\hades-master\\conf\\recvpackets.txt");
			List<String> linhas = new ArrayList<String>();
			linhas.add("#Packet extractor by lututui\r\n" + 
					"#Date: 08-Nov-16 13:29:38\r\n" + 
					"#Encryption Keys: 0x17AC78C2 0x1ADE5C66 0x2A84793C\r\n" + 
					"0187 6 6 0\r\n" + 
					"0081 3 3 0\r\n" + 
					"01C6 4 4 0\r\n" + 
					"01C7 2 2 1\r\n" + 
					"0064 55 55 0\r\n" + 
					"0069 -1 47 0\r\n" + 
					"006A 23 23 0\r\n" + 
					"01DB 2 2 0\r\n" + 
					"01DC -1 4 0\r\n" + 
					"01DD 47 47 0\r\n" + 
					"01FA 48 48 0\r\n" + 
					"0204 18 18 0\r\n" + 
					"01F1 -1 4 0\r\n" + 
					"0200 26 26 0\r\n" + 
					"01BE 2 2 0\r\n" + 
					"01BF 3 3 0\r\n" + 
					"0065 17 17 0\r\n" + 
					"0066 3 3 0\r\n" + 
					"0067 37 37 0\r\n" + 
					"0970 31 31 0\r\n" + 
					"020D -1 4 0\r\n" + 
					"006B -1 4 0\r\n" + 
					"006C 3 3 0\r\n" + 
					"006D 126 126 0\r\n" + 
					"006E 3 3 0\r\n" + 
					"0071 28 28 0\r\n" + 
					"0068 46 46 0\r\n" + 
					"01FB 56 56 0\r\n" + 
					"006F 2 2 0\r\n" + 
					"0070 3 3 0\r\n" + 
					"02CA 3 3 0\r\n" + 
					"0072 19 19 0\r\n" + 
					"0082 2 2 0\r\n" + 
					"0085 5 5 0\r\n" + 
					"0089 7 7 0\r\n" + 
					"008C -1 4 0\r\n" + 
					"007E 6 6 0\r\n" + 
					"007D 2 2 0\r\n" + 
					"0090 7 7 0\r\n" + 
					"0099 -1 4 0\r\n" + 
					"019C -1 4 0\r\n" + 
					"009B 5 5 0\r\n" + 
					"00CC 6 6 0\r\n" + 
					"00CE 2 2 0\r\n" + 
					"009F 6 6 0\r\n" + 
					"00A2 6 6 0\r\n" + 
					"00A7 8 8 0\r\n" + 
					"00A9 6 6 0\r\n" + 
					"00AB 4 4 0\r\n" + 
					"00B8 7 7 0\r\n" + 
					"00B9 6 6 0\r\n" + 
					"00B2 3 3 0\r\n" + 
					"00BA 2 2 0\r\n" + 
					"00BB 5 5 0\r\n" + 
					"00BF 3 3 0\r\n" + 
					"00C1 2 2 0\r\n" + 
					"00C5 7 7 0\r\n" + 
					"00C8 -1 4 0\r\n" + 
					"00C9 -1 4 0\r\n" + 
					"0096 -1 28 0\r\n" + 
					"00CF 27 27 0\r\n" + 
					"00D0 3 3 0\r\n" + 
					"00D3 2 2 0\r\n" + 
					"00D5 -1 15 0\r\n" + 
					"00D9 14 14 0\r\n" + 
					"00DE -1 15 0\r\n" + 
					"00E0 30 30 0\r\n" + 
					"00E2 26 26 0\r\n" + 
					"00E3 2 2 0\r\n" + 
					"00E4 6 6 0\r\n" + 
					"00E6 3 3 0\r\n" + 
					"00E8 8 8 0\r\n" + 
					"00EB 2 2 0\r\n" + 
					"00ED 2 2 0\r\n" + 
					"00EF 2 2 0\r\n" + 
					"00F3 8 8 0\r\n" + 
					"00F5 8 8 0\r\n" + 
					"00F7 2 2 0\r\n" + 
					"00F9 26 26 0\r\n" + 
					"01E8 28 28 0\r\n" + 
					"00FC 6 6 0\r\n" + 
					"00FF 10 10 0\r\n" + 
					"0102 6 6 0\r\n" + 
					"0100 2 2 0\r\n" + 
					"0103 30 30 0\r\n" + 
					"0108 -1 4 0\r\n" + 
					"0112 4 4 0\r\n" + 
					"0113 10 10 0\r\n" + 
					"0116 10 10 0\r\n" + 
					"0118 2 2 0\r\n" + 
					"011B 20 20 0\r\n" + 
					"011D 2 2 0\r\n" + 
					"0126 8 8 0\r\n" + 
					"0127 8 8 0\r\n" + 
					"0128 8 8 0\r\n" + 
					"0129 8 8 0\r\n" + 
					"012A 2 2 0\r\n" + 
					"012E 2 2 0\r\n" + 
					"012F -1 84 0\r\n" + 
					"01B2 -1 85 0\r\n" + 
					"0134 -1 8 0\r\n" + 
					"0130 6 6 0\r\n" + 
					"0138 3 3 0\r\n" + 
					"013F 26 26 0\r\n" + 
					"0140 22 22 0\r\n" + 
					"0143 10 10 0\r\n" + 
					"0146 6 6 0\r\n" + 
					"0178 4 4 0\r\n" + 
					"017A 4 4 0\r\n" + 
					"017C 6 6 0\r\n" + 
					"01FD 15 15 0\r\n" + 
					"018A 4 4 0\r\n" + 
					"018E 10 10 0\r\n" + 
					"0190 90 90 0\r\n" + 
					"0197 4 4 0\r\n" + 
					"0198 8 8 0\r\n" + 
					"01AE 4 4 0\r\n" + 
					"025B 6 6 0\r\n" + 
					"01AF 4 4 0\r\n" + 
					"01B9 6 6 1\r\n" + 
					"01CD 30 30 1\r\n" + 
					"01CE 6 6 0\r\n" + 
					"0443 8 8 0\r\n" + 
					"01CF 28 28 1\r\n" + 
					"01D0 8 8 1\r\n" + 
					"01E1 8 8 1\r\n" + 
					"01D1 14 14 1\r\n" + 
					"01D2 10 10 1\r\n" + 
					"0094 6 6 0\r\n" + 
					"0095 30 30 1\r\n" + 
					"0195 102 102 1\r\n" + 
					"0193 6 6 0\r\n" + 
					"0175 6 6 0\r\n" + 
					"0176 106 106 0\r\n" + 
					"0079 53 53 1\r\n" + 
					"019D 6 6 0\r\n" + 
					"014C -1 4 1\r\n" + 
					"014D 2 2 0\r\n" + 
					"014E 6 6 1\r\n" + 
					"014F 6 6 0\r\n" + 
					"0150 110 110 1\r\n" + 
					"01B6 114 114 1\r\n" + 
					"0151 6 6 0\r\n" + 
					"0152 -1 12 1\r\n" + 
					"0153 -1 4 0\r\n" + 
					"0154 -1 4 1\r\n" + 
					"0166 -1 4 1\r\n" + 
					"0155 -1 4 0\r\n" + 
					"0156 -1 4 1\r\n" + 
					"0157 6 6 0\r\n" + 
					"0159 54 54 0\r\n" + 
					"015A 66 66 1\r\n" + 
					"015B 54 54 0\r\n" + 
					"015C 90 90 1\r\n" + 
					"015D 42 42 0\r\n" + 
					"015E 6 6 1\r\n" + 
					"015F 42 42 1\r\n" + 
					"0160 -1 4 1\r\n" + 
					"0161 -1 4 0\r\n" + 
					"0162 -1 6 1\r\n" + 
					"0163 -1 4 1\r\n" + 
					"0164 -1 4 1\r\n" + 
					"0165 30 30 0\r\n" + 
					"0167 3 3 1\r\n" + 
					"0168 14 14 0\r\n" + 
					"0169 3 3 1\r\n" + 
					"016A 30 30 1\r\n" + 
					"016B 10 10 0\r\n" + 
					"0149 9 9 0\r\n" + 
					"014A 6 6 1\r\n" + 
					"014B 27 27 1\r\n" + 
					"016E 186 186 0\r\n" + 
					"016F 182 182 1\r\n" + 
					"017E -1 4 0\r\n" + 
					"017F -1 4 1\r\n" + 
					"0165 30 30 0\r\n" + 
					"0166 -1 4 1\r\n" + 
					"0167 3 3 1\r\n" + 
					"0168 14 14 0\r\n" + 
					"0169 3 3 1\r\n" + 
					"016A 30 30 1\r\n" + 
					"016B 10 10 0\r\n" + 
					"016C 43 43 1\r\n" + 
					"016C 43 43 1\r\n" + 
					"016D 14 14 1\r\n" + 
					"01F2 20 20 1\r\n" + 
					"0170 14 14 0\r\n" + 
					"0171 30 30 1\r\n" + 
					"0172 10 10 0\r\n" + 
					"0173 3 3 1\r\n" + 
					"0174 -1 4 1\r\n" + 
					"0180 6 6 0\r\n" + 
					"0181 3 3 1\r\n" + 
					"0182 106 106 1\r\n" + 
					"0183 10 10 0\r\n" + 
					"0184 10 10 1\r\n" + 
					"0185 34 34 1\r\n" + 
					"019E 2 2 1\r\n" + 
					"019F 6 6 0\r\n" + 
					"01A0 3 3 1\r\n" + 
					"01A1 3 3 0\r\n" + 
					"01A2 37 37 1\r\n" + 
					"01A3 5 5 1\r\n" + 
					"01A4 11 11 1\r\n" + 
					"01A5 26 26 0\r\n" + 
					"01A6 -1 4 1\r\n" + 
					"01A7 4 4 0\r\n" + 
					"01A8 4 4 0\r\n" + 
					"01A9 6 6 0\r\n" + 
					"01AA 10 10 1\r\n" + 
					"01CA 3 3 0\r\n" + 
					"01B0 11 11 1\r\n" + 
					"01B1 7 7 1\r\n" + 
					"01BA 26 26 0\r\n" + 
					"01BB 26 26 0\r\n" + 
					"01BC 26 26 0\r\n" + 
					"01BD 26 26 0\r\n" + 
					"01C0 2 2 0\r\n" + 
					"01C1 14 14 1\r\n" + 
					"01C2 10 10 1\r\n" + 
					"01D3 35 35 1\r\n" + 
					"01D5 -1 8 0\r\n" + 
					"01D4 6 6 1\r\n" + 
					"01DF 6 6 0\r\n" + 
					"01F3 10 10 1\r\n" + 
					"0284 14 14 1\r\n" + 
					"01FF 10 10 1\r\n" + 
					"01ED 2 2 0\r\n" + 
					"01E7 2 2 0\r\n" + 
					"01B7 6 6 0\r\n" + 
					"01F7 14 14 0\r\n" + 
					"01E3 14 14 0\r\n" + 
					"01CB 9 9 0\r\n" + 
					"01F9 6 6 0\r\n" + 
					"01E5 6 6 0\r\n" + 
					"0201 -1 4 1\r\n" + 
					"0203 10 10 0\r\n" + 
					"0205 26 26 1\r\n" + 
					"0206 11 11 1\r\n" + 
					"0207 34 34 1\r\n" + 
					"0208 14 14 0\r\n" + 
					"0209 36 36 1\r\n" + 
					"020A 10 10 1\r\n" + 
					"020E 32 32 1\r\n" + 
					"0212 26 26 0\r\n" + 
					"0213 26 26 0\r\n" + 
					"0214 42 42 1\r\n" + 
					"0215 6 6 1\r\n" + 
					"0216 6 6 1\r\n" + 
					"0217 2 2 0\r\n" + 
					"0218 2 2 0\r\n" + 
					"0225 2 2 0\r\n" + 
					"0219 282 282 1\r\n" + 
					"021A 282 282 1\r\n" + 
					"0226 282 282 1\r\n" + 
					"0282 284 284 1\r\n" + 
					"021B 10 10 1\r\n" + 
					"021C 10 10 1\r\n" + 
					"0224 10 10 1\r\n" + 
					"0280 12 12 1\r\n" + 
					"0285 6 6 1\r\n" + 
					"0286 4 4 0\r\n" + 
					"021D 6 6 0\r\n" + 
					"021E 6 6 0\r\n" + 
					"021F 66 66 1\r\n" + 
					"0222 6 6 0\r\n" + 
					"0221 -1 4 1\r\n" + 
					"0220 10 10 1\r\n" + 
					"0223 8 8 1\r\n" + 
					"0073 11 11 1\r\n" + 
					"0074 3 3 0\r\n" + 
					"0075 -1 11 1\r\n" + 
					"0076 9 9 1\r\n" + 
					"0077 5 5 1\r\n" + 
					"0078 55 55 1\r\n" + 
					"007A 58 58 1\r\n" + 
					"007B 60 60 1\r\n" + 
					"007C 44 44 1\r\n" + 
					"007F 6 6 1\r\n" + 
					"0080 7 7 1\r\n" + 
					"0083 2 2 1\r\n" + 
					"0084 2 2 1\r\n" + 
					"0086 16 16 1\r\n" + 
					"0087 12 12 1\r\n" + 
					"0088 10 10 1\r\n" + 
					"08CD 10 10 1\r\n" + 
					"008A 29 29 1\r\n" + 
					"008B 23 23 1\r\n" + 
					"008D -1 8 1\r\n" + 
					"008E -1 4 1\r\n" + 
					"0091 22 22 1\r\n" + 
					"0092 28 28 1\r\n" + 
					"0093 2 2 1\r\n" + 
					"0097 -1 32 1\r\n" + 
					"0098 3 3 1\r\n" + 
					"009A -1 4 1\r\n" + 
					"009C 9 9 1\r\n" + 
					"009D 17 17 1\r\n" + 
					"009E 17 17 1\r\n" + 
					"00A0 23 23 1\r\n" + 
					"00A1 6 6 1\r\n" + 
					"00A3 -1 4 1\r\n" + 
					"00A4 -1 4 1\r\n" + 
					"00A5 -1 4 1\r\n" + 
					"00A6 -1 4 1\r\n" + 
					"00A8 7 7 1\r\n" + 
					"00AA 9 9 1\r\n" + 
					"00AC 7 7 1\r\n" + 
					"00AE -1 4 1\r\n" + 
					"00AF 6 6 1\r\n" + 
					"00B0 8 8 1\r\n" + 
					"00B1 8 8 1\r\n" + 
					"00B3 3 3 0\r\n" + 
					"00B4 -1 8 1\r\n" + 
					"00B5 6 6 1\r\n" + 
					"00B6 6 6 1\r\n" + 
					"00B7 -1 8 1\r\n" + 
					"00BC 6 6 1\r\n" + 
					"00BD 44 44 1\r\n" + 
					"00BE 5 5 1\r\n" + 
					"00C0 7 7 1\r\n" + 
					"00C2 6 6 1\r\n" + 
					"00C3 8 8 1\r\n" + 
					"00C4 6 6 1\r\n" + 
					"00C6 -1 4 1\r\n" + 
					"00C7 -1 4 1\r\n" + 
					"00CA 3 3 1\r\n" + 
					"00CB 3 3 1\r\n" + 
					"00CD 3 3 1\r\n" + 
					"00D1 4 4 1\r\n" + 
					"00D2 4 4 1\r\n" + 
					"00D4 -1 4 1\r\n" + 
					"00D6 3 3 1\r\n" + 
					"00D7 -1 17 1\r\n" + 
					"00D8 6 6 1\r\n" + 
					"00DA 3 3 1\r\n" + 
					"00DB -1 8 1\r\n" + 
					"00DC 28 28 1\r\n" + 
					"00DD 29 29 1\r\n" + 
					"00DF -1 17 1\r\n" + 
					"00E1 30 30 1\r\n" + 
					"00E5 26 26 1\r\n" + 
					"00E7 3 3 1\r\n" + 
					"00E9 19 19 1\r\n" + 
					"00EA 5 5 1\r\n" + 
					"00EC 3 3 1\r\n" + 
					"00EE 2 2 1\r\n" + 
					"00F0 3 3 1\r\n" + 
					"00F1 2 2 1\r\n" + 
					"00F2 6 6 1\r\n" + 
					"00F4 21 21 1\r\n" + 
					"00F6 8 8 1\r\n" + 
					"00F8 2 2 1\r\n" + 
					"00FA 3 3 1\r\n" + 
					"00FB -1 28 1\r\n" + 
					"00FD 27 27 1\r\n" + 
					"00FE 30 30 1\r\n" + 
					"0101 6 6 1\r\n" + 
					"0104 79 79 1\r\n" + 
					"0105 31 31 1\r\n" + 
					"0106 10 10 1\r\n" + 
					"0107 10 10 1\r\n" + 
					"0109 -1 8 1\r\n" + 
					"010A 4 4 1\r\n" + 
					"010B 6 6 1\r\n" + 
					"010C 6 6 1\r\n" + 
					"010D 2 2 1\r\n" + 
					"010E 11 11 1\r\n" + 
					"010F -1 4 1\r\n" + 
					"02B1 -1 8 1\r\n" + 
					"02B2 -1 8 1\r\n" + 
					"02B5 -1 6 1\r\n" + 
					"0110 10 10 1\r\n" + 
					"0111 39 39 1\r\n" + 
					"0114 31 31 1\r\n" + 
					"0115 35 35 1\r\n" + 
					"0117 18 18 1\r\n" + 
					"0119 13 13 1\r\n" + 
					"0229 15 15 1\r\n" + 
					"011A 15 15 1\r\n" + 
					"011C 68 68 1\r\n" + 
					"011E 3 3 1\r\n" + 
					"011F 16 16 1\r\n" + 
					"0120 6 6 1\r\n" + 
					"0121 14 14 1\r\n" + 
					"0122 -1 4 1\r\n" + 
					"0123 -1 4 1\r\n" + 
					"0124 21 21 1\r\n" + 
					"0125 8 8 1\r\n" + 
					"012B 2 2 1\r\n" + 
					"012C 3 3 1\r\n" + 
					"012D 4 4 1\r\n" + 
					"0131 86 86 1\r\n" + 
					"0132 6 6 1\r\n" + 
					"0133 -1 8 1\r\n" + 
					"0135 7 7 1\r\n" + 
					"0136 -1 8 1\r\n" + 
					"0137 6 6 1\r\n" + 
					"0139 16 16 1\r\n" + 
					"013A 4 4 1\r\n" + 
					"013B 4 4 1\r\n" + 
					"013C 4 4 1\r\n" + 
					"013D 6 6 1\r\n" + 
					"013E 24 24 1\r\n" + 
					"0141 14 14 1\r\n" + 
					"0142 6 6 1\r\n" + 
					"0144 23 23 1\r\n" + 
					"0145 19 19 1\r\n" + 
					"0147 39 39 1\r\n" + 
					"0148 8 8 1\r\n" + 
					"0177 -1 4 1\r\n" + 
					"0179 5 5 1\r\n" + 
					"017B -1 4 1\r\n" + 
					"017D 7 7 1\r\n" + 
					"0188 8 8 1\r\n" + 
					"0189 4 4 1\r\n" + 
					"018B 4 4 0\r\n" + 
					"018C 29 29 1\r\n" + 
					"018D -1 4 1\r\n" + 
					"018F 6 6 1\r\n" + 
					"0191 86 86 1\r\n" + 
					"0192 24 24 1\r\n" + 
					"0194 30 30 1\r\n" + 
					"0196 9 9 1\r\n" + 
					"028A 18 18 1\r\n" + 
					"0199 4 4 1\r\n" + 
					"019A 14 14 1\r\n" + 
					"019B 10 10 1\r\n" + 
					"01AB 12 12 1\r\n" + 
					"01AC 6 6 1\r\n" + 
					"01AD -1 4 1\r\n" + 
					"025A -1 4 1\r\n" + 
					"01B3 67 67 1\r\n" + 
					"01B4 12 12 1\r\n" + 
					"01B5 18 18 0\r\n" + 
					"01B8 3 3 1\r\n" + 
					"01C3 -1 16 1\r\n" + 
					"01C4 22 22 1\r\n" + 
					"01C5 22 22 1\r\n" + 
					"01C8 13 13 1\r\n" + 
					"01C9 97 97 1\r\n" + 
					"01CC 9 9 1\r\n" + 
					"01D6 4 4 1\r\n" + 
					"01D7 11 11 1\r\n" + 
					"01D8 54 54 1\r\n" + 
					"022A 58 58 1\r\n" + 
					"01D9 53 53 1\r\n" + 
					"022B 57 57 1\r\n" + 
					"01DA 60 60 1\r\n" + 
					"022C 65 65 1\r\n" + 
					"01DE 33 33 1\r\n" + 
					"01E0 30 30 1\r\n" + 
					"01E2 34 34 1\r\n" + 
					"01E4 2 2 1\r\n" + 
					"01E6 26 26 1\r\n" + 
					"01E9 81 81 1\r\n" + 
					"01EA 6 6 1\r\n" + 
					"01EB 10 10 1\r\n" + 
					"01EC 26 26 1\r\n" + 
					"01EE -1 4 1\r\n" + 
					"01EF -1 4 1\r\n" + 
					"01F0 -1 4 1\r\n" + 
					"01F4 32 32 1\r\n" + 
					"01F5 9 9 1\r\n" + 
					"01F6 34 34 1\r\n" + 
					"0253 3 3 1\r\n" + 
					"0254 3 3 0\r\n" + 
					"01F8 2 2 1\r\n" + 
					"01FC -1 4 1\r\n" + 
					"01FE 5 5 1\r\n" + 
					"0227 18 18 0\r\n" + 
					"0228 18 18 0\r\n" + 
					"0232 9 9 0\r\n" + 
					"0233 11 11 0\r\n" + 
					"0234 6 6 0\r\n" + 
					"0230 12 12 1\r\n" + 
					"022E 71 71 1\r\n" + 
					"027D 62 62 0\r\n" + 
					"0235 -1 4 1\r\n" + 
					"0239 11 11 1\r\n" + 
					"022F 5 5 1\r\n" + 
					"0231 26 26 0\r\n" + 
					"0237 2 2 0\r\n" + 
					"0238 282 282 1\r\n" + 
					"0236 10 10 1\r\n" + 
					"023A 4 4 0\r\n" + 
					"023C 6 6 0\r\n" + 
					"023D 6 6 0\r\n" + 
					"023E 8 8 0\r\n" + 
					"023F 2 2 0\r\n" + 
					"0240 -1 8 1\r\n" + 
					"0241 6 6 0\r\n" + 
					"0242 -1 99 1\r\n" + 
					"0243 6 6 0\r\n" + 
					"0257 8 8 1\r\n" + 
					"0244 6 6 0\r\n" + 
					"0245 3 3 1\r\n" + 
					"0246 4 4 0\r\n" + 
					"0247 8 8 0\r\n" + 
					"0248 -1 68 0\r\n" + 
					"0249 3 3 1\r\n" + 
					"024A 70 70 1\r\n" + 
					"024B 4 4 0\r\n" + 
					"024C 8 8 0\r\n" + 
					"024D 12 12 0\r\n" + 
					"024E 6 6 0\r\n" + 
					"024F 10 10 0\r\n" + 
					"0250 3 3 1\r\n" + 
					"0251 34 34 0\r\n" + 
					"0252 -1 12 1\r\n" + 
					"0255 5 5 1\r\n" + 
					"0256 5 5 1\r\n" + 
					"0258 2 2 0\r\n" + 
					"0259 3 3 0\r\n" + 
					"025C 4 4 0\r\n" + 
					"025D 6 6 1\r\n" + 
					"025E 4 4 0\r\n" + 
					"025F 6 6 1\r\n" + 
					"0260 6 6 1\r\n" + 
					"0261 11 11 0\r\n" + 
					"0262 11 11 0\r\n" + 
					"0263 11 11 0\r\n" + 
					"0264 20 20 0\r\n" + 
					"0265 20 20 0\r\n" + 
					"0266 30 30 0\r\n" + 
					"0267 4 4 0\r\n" + 
					"0268 4 4 0\r\n" + 
					"0269 4 4 0\r\n" + 
					"026A 4 4 0\r\n" + 
					"026B 4 4 0\r\n" + 
					"026C 4 4 0\r\n" + 
					"026D 4 4 0\r\n" + 
					"026F 2 2 0\r\n" + 
					"0270 2 2 0\r\n" + 
					"0271 40 40 0\r\n" + 
					"0272 44 44 0\r\n" + 
					"0273 30 30 0\r\n" + 
					"0274 8 8 1\r\n" + 
					"0275 37 37 0\r\n" + 
					"0276 -1 51 0\r\n" + 
					"0277 84 84 0\r\n" + 
					"0278 2 2 0\r\n" + 
					"0279 2 2 0\r\n" + 
					"027A -1 4 1\r\n" + 
					"027B 14 14 0\r\n" + 
					"027C 60 60 0\r\n" + 
					"027E -1 6 0\r\n" + 
					"027F 8 8 0\r\n" + 
					"0283 6 6 1\r\n" + 
					"0287 -1 8 1\r\n" + 
					"0288 6 6 0\r\n" + 
					"0289 8 8 1\r\n" + 
					"0444 -1 8 1\r\n" + 
					"0445 6 6 0\r\n" + 
					"028B -1 4 0\r\n" + 
					"028C 46 46 0\r\n" + 
					"028D 34 34 0\r\n" + 
					"028E 4 4 0\r\n" + 
					"028F 6 6 0\r\n" + 
					"0290 4 4 0\r\n" + 
					"0291 4 4 1\r\n" + 
					"0292 2 2 0\r\n" + 
					"0293 70 70 1\r\n" + 
					"0294 10 10 1\r\n" + 
					"0295 -1 4 1\r\n" + 
					"0296 -1 4 1\r\n" + 
					"0297 -1 4 1\r\n" + 
					"0298 8 8 1\r\n" + 
					"0299 6 6 1\r\n" + 
					"029A 27 27 1\r\n" + 
					"029B 80 80 1\r\n" + 
					"029C 66 66 0\r\n" + 
					"029D -1 4 1\r\n" + 
					"029E 11 11 1\r\n" + 
					"029F 3 3 0\r\n" + 
					"02A2 8 8 1\r\n" + 
					"02A5 8 8 0\r\n" + 
					"02A6 -1 10 0\r\n" + 
					"02A7 -1 10 0\r\n" + 
					"02AA 4 4 0\r\n" + 
					"02AB 36 36 0\r\n" + 
					"02AC 6 6 0\r\n" + 
					"02AD 8 8 0\r\n" + 
					"02B0 85 85 0\r\n" + 
					"02B8 22 22 1\r\n" + 
					"02BB 8 8 1\r\n" + 
					"02B9 191 191 1\r\n" + 
					"02BA 11 11 0\r\n" + 
					"02BC 6 6 0\r\n" + 
					"02B3 107 107 1\r\n" + 
					"02B4 6 6 1\r\n" + 
					"02B6 7 7 0\r\n" + 
					"02B7 7 7 1\r\n" + 
					"02C1 -1 12 1\r\n" + 
					"02C2 -1 6 1\r\n" + 
					"02C5 30 30 1\r\n" + 
					"02C8 3 3 0\r\n" + 
					"02C9 3 3 1\r\n" + 
					"02C6 30 30 1\r\n" + 
					"02C7 7 7 0\r\n" + 
					"02CB 65 65 1\r\n" + 
					"02CC 4 4 1\r\n" + 
					"02CD 71 71 1\r\n" + 
					"02CE 10 10 1\r\n" + 
					"02CF 6 6 0\r\n" + 
					"02D5 2 2 1\r\n" + 
					"02D0 -1 4 1\r\n" + 
					"02D1 -1 4 1\r\n" + 
					"02D2 -1 4 1\r\n" + 
					"02D3 4 4 1\r\n" + 
					"02D4 29 29 1\r\n" + 
					"02D6 6 6 0\r\n" + 
					"02D7 -1 43 1\r\n" + 
					"02D8 10 10 0\r\n" + 
					"02D9 10 10 1\r\n" + 
					"02DA 3 3 1\r\n" + 
					"02DB -1 4 0\r\n" + 
					"02DC -1 32 1\r\n" + 
					"02DD 32 32 1\r\n" + 
					"02DE 6 6 1\r\n" + 
					"02DF 36 36 1\r\n" + 
					"02E0 34 34 1\r\n" + 
					"02E1 33 33 1\r\n" + 
					"02E2 8 8 0\r\n" + 
					"02E3 10 10 0\r\n" + 
					"02E4 6 6 0\r\n" + 
					"02E5 5 5 0\r\n" + 
					"02E6 6 6 0\r\n" + 
					"02E7 -1 6 1\r\n" + 
					"02E8 -1 4 1\r\n" + 
					"02E9 -1 4 1\r\n" + 
					"02EA -1 4 1\r\n" + 
					"02EB 13 13 1\r\n" + 
					"02EC 67 67 1\r\n" + 
					"02ED 59 59 1\r\n" + 
					"02EE 60 60 1\r\n" + 
					"02EF 8 8 1\r\n" + 
					"02F0 10 10 1\r\n" + 
					"02F1 2 2 0\r\n" + 
					"02F2 2 2 1\r\n" + 
					"035C 2 2 0\r\n" + 
					"035D -1 16 0\r\n" + 
					"035E 2 2 0\r\n" + 
					"03DD 18 18 0\r\n" + 
					"03DE 18 18 0\r\n" + 
					"0439 8 8 0\r\n" + 
					"043D 8 8 1\r\n" + 
					"043E -1 4 1\r\n" + 
					"043F 25 25 1\r\n" + 
					"0440 10 10 1\r\n" + 
					"0441 4 4 1\r\n" + 
					"0442 -1 8 1\r\n" + 
					"0443 8 8 0\r\n" + 
					"0446 14 14 1\r\n" + 
					"0448 -1 4 0\r\n" + 
					"0449 4 4 0\r\n" + 
					"044A 6 6 0\r\n" + 
					"044B 2 2 0\r\n" + 
					"0447 2 2 0\r\n" + 
					"07D7 8 8 0\r\n" + 
					"07D8 8 8 1\r\n" + 
					"07D9 268 268 1\r\n" + 
					"07DA 6 6 0\r\n" + 
					"07DB 8 8 1\r\n" + 
					"07DC 6 6 0\r\n" + 
					"07DD 54 54 1\r\n" + 
					"07DE 30 30 0\r\n" + 
					"07DF 54 54 0\r\n" + 
					"07E0 58 58 0\r\n" + 
					"07E1 15 15 1\r\n" + 
					"07E2 8 8 1\r\n" + 
					"07E3 6 6 1\r\n" + 
					"07E6 8 8 1\r\n" + 
					"07E5 4 4 0\r\n" + 
					"07E8 -1 4 0\r\n" + 
					"07E7 32 32 0\r\n" + 
					"07E9 5 5 0\r\n" + 
					"07EA 2 2 0\r\n" + 
					"07EB -1 8 1\r\n" + 
					"07ED 10 10 1\r\n" + 
					"07EE 6 6 0\r\n" + 
					"07EF 8 8 1\r\n" + 
					"07F0 6 6 0\r\n" + 
					"07F1 18 18 1\r\n" + 
					"07F2 8 8 1\r\n" + 
					"07F3 6 6 1\r\n" + 
					"07F4 3 3 0\r\n" + 
					"07F5 6 6 0\r\n" + 
					"07F6 14 14 1\r\n" + 
					"07F7 -1 69 1\r\n" + 
					"07F8 -1 62 1\r\n" + 
					"07F9 -1 63 1\r\n" + 
					"07FA 8 8 1\r\n" + 
					"07FB 25 25 1\r\n" + 
					"07FC 10 10 1\r\n" + 
					"07FD -1 7 1\r\n" + 
					"07FE 26 26 1\r\n" + 
					"0800 -1 12 1\r\n" + 
					"0801 -1 12 0\r\n" + 
					"0803 4 4 1\r\n" + 
					"0804 14 14 0\r\n" + 
					"0805 -1 5 1\r\n" + 
					"0806 2 2 0\r\n" + 
					"0807 4 4 1\r\n" + 
					"0808 14 14 0\r\n" + 
					"0809 50 50 1\r\n" + 
					"080A 18 18 1\r\n" + 
					"080B 6 6 1\r\n" + 
					"080C 2 2 0\r\n" + 
					"080D 3 3 1\r\n" + 
					"080E 14 14 1\r\n" + 
					"080F 20 20 1\r\n" + 
					"0810 3 3 1\r\n" + 
					"0812 8 8 1\r\n" + 
					"0813 -1 12 1\r\n" + 
					"0814 86 86 1\r\n" + 
					"0816 6 6 1\r\n" + 
					"0818 -1 16 1\r\n" + 
					"081A 4 4 1\r\n" + 
					"0824 6 6 1\r\n" + 
					"081B 10 10 1\r\n" + 
					"081C 10 10 1\r\n" + 
					"081D 22 22 1\r\n" + 
					"081E 8 8 1\r\n" + 
					"081F -1 9 1\r\n" + 
					"0820 11 11 0\r\n" + 
					"0821 2 2 0\r\n" + 
					"0822 9 9 0\r\n" + 
					"0823 -1 6 0\r\n" + 
					"0825 -1 65 0\r\n" + 
					"0826 4 4 0\r\n" + 
					"0836 -1 7 0\r\n" + 
					"0837 3 3 0\r\n" + 
					"0839 66 66 1\r\n" + 
					"083A 5 5 0\r\n" + 
					"083B 2 2 0\r\n" + 
					"083D 6 6 0\r\n" + 
					"083E 26 26 0\r\n" + 
					"0840 -1 4 0\r\n" + 
					"0841 4 4 0\r\n" + 
					"0827 6 6 0\r\n" + 
					"0828 14 14 0\r\n" + 
					"0829 12 12 0\r\n" + 
					"082A 10 10 0\r\n" + 
					"082B 6 6 0\r\n" + 
					"082C 10 10 0\r\n" + 
					"0842 6 6 0\r\n" + 
					"0843 6 6 0\r\n" + 
					"0844 2 2 0\r\n" + 
					"0845 6 6 0\r\n" + 
					"0846 4 4 0\r\n" + 
					"0847 -1 6 0\r\n" + 
					"0848 -1 6 0\r\n" + 
					"0849 12 12 0\r\n" + 
					"084A 2 2 0\r\n" + 
					"084B 19 19 1\r\n" + 
					"084C 10 10 0\r\n" + 
					"084D 10 10 0\r\n" + 
					"084E 5 5 0\r\n" + 
					"084F 6 6 0\r\n" + 
					"0850 7 7 0\r\n" + 
					"0855 6 6 0\r\n" + 
					"0851 -1 4 0\r\n" + 
					"0852 2 2 0\r\n" + 
					"0853 -1 4 0\r\n" + 
					"0854 -1 4 0\r\n" + 
					"0856 -1 71 1\r\n" + 
					"0857 -1 65 1\r\n" + 
					"0858 -1 64 1\r\n" + 
					"0859 -1 45 1\r\n" + 
					"08B1 -1 4 0\r\n" + 
					"082D -1 29 0\r\n" + 
					"08B2 -1 6 0\r\n" + 
					"08AF 10 10 0\r\n" + 
					"08B0 17 17 0\r\n" + 
					"08B3 -1 8 0\r\n" + 
					"08B4 2 2 0\r\n" + 
					"08B5 6 6 0\r\n" + 
					"08B6 3 3 0\r\n" + 
					"02F3 -1 68 0\r\n" + 
					"02F4 3 3 0\r\n" + 
					"02F5 7 7 0\r\n" + 
					"02F6 7 7 0\r\n" + 
					"08B8 10 10 0\r\n" + 
					"08B9 12 12 0\r\n" + 
					"08BA 10 10 0\r\n" + 
					"08BB 8 8 0\r\n" + 
					"08BC 10 10 0\r\n" + 
					"08BD 8 8 0\r\n" + 
					"08BE 14 14 0\r\n" + 
					"08BF 8 8 0\r\n" + 
					"08C3 10 10 0\r\n" + 
					"08C4 8 8 0\r\n" + 
					"08C5 6 6 0\r\n" + 
					"08C6 4 4 0\r\n" + 
					"08C0 -1 10 0\r\n" + 
					"08C1 2 2 0\r\n" + 
					"08C2 2 2 0\r\n" + 
					"08C7 -1 19 1\r\n" + 
					"08C8 34 34 1\r\n" + 
					"08C9 2 2 0\r\n" + 
					"08CA -1 8 0\r\n" + 
					"08CB -1 10 0\r\n" + 
					"097B -1 16 0\r\n" + 
					"08CC 109 109 0\r\n" + 
					"08CE 2 2 0\r\n" + 
					"08CF 10 10 0\r\n" + 
					"08D0 9 9 1\r\n" + 
					"08D1 7 7 1\r\n" + 
					"08D2 10 10 1\r\n" + 
					"08D3 10 10 0\r\n" + 
					"08D4 8 8 0\r\n" + 
					"08D5 -1 8 0\r\n" + 
					"08D6 6 6 0\r\n" + 
					"08D7 28 28 1\r\n" + 
					"08D8 27 27 1\r\n" + 
					"08D9 30 30 1\r\n" + 
					"08DA 26 26 1\r\n" + 
					"08DB 27 27 1\r\n" + 
					"08DC 26 26 1\r\n" + 
					"08DD 27 27 1\r\n" + 
					"08DE 27 27 1\r\n" + 
					"08DF 50 50 1\r\n" + 
					"08E0 51 51 1\r\n" + 
					"08E1 51 51 1\r\n" + 
					"08E2 27 27 0\r\n" + 
					"08E3 126 126 0\r\n" + 
					"08E4 6 6 0\r\n" + 
					"08FC 30 30 0\r\n" + 
					"08FD 6 6 0\r\n" + 
					"08FE -1 4 1\r\n" + 
					"08FF 24 24 1\r\n" + 
					"0900 -1 4 1\r\n" + 
					"0901 -1 4 1\r\n" + 
					"0902 -1 4 1\r\n" + 
					"0903 -1 4 1\r\n" + 
					"0904 -1 4 1\r\n" + 
					"0905 -1 4 1\r\n" + 
					"0906 -1 45 1\r\n" + 
					"0907 5 5 0\r\n" + 
					"0908 5 5 1\r\n" + 
					"090A 26 26 1\r\n" + 
					"090D -1 10 1\r\n" + 
					"090E 2 2 0\r\n" + 
					"0910 10 10 1\r\n" + 
					"0911 30 30 1\r\n" + 
					"0912 10 10 1\r\n" + 
					"0913 30 30 1\r\n" + 
					"0914 -1 80 1\r\n" + 
					"090F -1 73 1\r\n" + 
					"0915 -1 74 1\r\n" + 
					"0916 26 26 1\r\n" + 
					"096B 4 4 1\r\n" + 
					"096C 6 6 1\r\n" + 
					"096D -1 4 1\r\n" + 
					"096E -1 4 1\r\n" + 
					"096F 7 7 1\r\n" + 
					"0971 6 6 1\r\n" + 
					"0972 -1 9 1\r\n" + 
					"0973 7 7 1\r\n" + 
					"0974 2 2 1\r\n" + 
					"0975 -1 28 1\r\n" + 
					"0976 -1 28 1\r\n" + 
					"0977 14 14 1\r\n" + 
					"0978 6 6 0\r\n" + 
					"0979 50 50 0\r\n" + 
					"097A -1 8 1\r\n" + 
					"097C 4 4 0\r\n" + 
					"097D 288 288 1\r\n" + 
					"097E 12 12 1\r\n" + 
					"097F -1 8 1\r\n" + 
					"0980 7 7 1\r\n" + 
					"0981 -1 12 0\r\n" + 
					"0982 7 7 0\r\n" + 
					"0983 29 29 1\r\n" + 
					"0984 28 28 1\r\n" + 
					"0985 -1 4 1\r\n" + 
					"0986 10 10 0\r\n" + 
					"0987 -1 41 0\r\n" + 
					"0988 6 6 0\r\n" + 
					"0989 2 2 0\r\n" + 
					"098A -1 74 0\r\n" + 
					"098D -1 4 0\r\n" + 
					"098E -1 28 0\r\n" + 
					"098B 2 2 0\r\n" + 
					"098C 4 4 0\r\n" + 
					"098F -1 8 0\r\n" + 
					"0990 31 31 1\r\n" + 
					"0991 -1 4 1\r\n" + 
					"0992 -1 4 1\r\n" + 
					"0993 -1 4 1\r\n" + 
					"0994 -1 4 1\r\n" + 
					"0995 -1 28 1\r\n" + 
					"0996 -1 28 1\r\n" + 
					"0997 -1 45 1\r\n" + 
					"0998 8 8 1\r\n" + 
					"0999 11 11 1\r\n" + 
					"099A 9 9 1\r\n" + 
					"099B 8 8 1\r\n" + 
					"099C 6 6 0\r\n" + 
					"099D -1 4 0\r\n" + 
					"099E 12 12 0\r\n" + 
					"099F -1 22 1\r\n" + 
					"09A0 6 6 0\r\n" + 
					"09A1 2 2 0\r\n" + 
					"09A2 6 6 0\r\n" + 
					"09A3 -1 8 0\r\n" + 
					"09A4 18 18 0\r\n" + 
					"09A5 7 7 0\r\n" + 
					"09AB 6 6 0\r\n" + 
					"09A6 12 12 0\r\n" + 
					"09A7 10 10 0\r\n" + 
					"09A8 16 16 0\r\n" + 
					"09A9 10 10 0\r\n" + 
					"09AA 16 16 0\r\n" + 
					"09AC -1 8 0\r\n" + 
					"09AD 10 10 0\r\n" + 
					"09AE 17 17 0\r\n" + 
					"09AF 4 4 0\r\n" + 
					"09B0 8 8 0\r\n" + 
					"09B1 4 4 0\r\n" + 
					"09B2 8 8 0\r\n" + 
					"09B3 4 4 0\r\n" + 
					"09B4 6 6 0\r\n" + 
					"09B5 2 2 0\r\n" + 
					"09B6 6 6 0\r\n" + 
					"09B7 4 4 0\r\n" + 
					"09B8 6 6 0\r\n" + 
					"09B9 4 4 0\r\n" + 
					"09BA 2 2 0\r\n" + 
					"09BB 6 6 0\r\n" + 
					"09BC 6 6 0\r\n" + 
					"09BD 2 2 0\r\n" + 
					"09BE 2 2 0\r\n" + 
					"09BF 4 4 0\r\n" + 
					"09C1 10 10 0\r\n" + 
					"09C2 -1 4 0\r\n" + 
					"09C3 8 8 0\r\n" + 
					"09C4 8 8 0\r\n" + 
					"09C5 1042 1042 0\r\n" + 
					"09C6 -1 16 0\r\n" + 
					"09C7 18 18 0\r\n" + 
					"09C8 -1 13 0\r\n" + 
					"09C9 -1 4 0\r\n" + 
					"09CA -1 23 1\r\n" + 
					"09CB 17 17 1\r\n" + 
					"09CC -1 4 0\r\n" + 
					"09CD 8 8 1\r\n" + 
					"09CE 102 102 1\r\n" + 
					"09CF -1 4 0\r\n" + 
					"09D0 -1 4 0\r\n" + 
					"09D1 14 14 1\r\n" + 
					"09D2 -1 28 0\r\n" + 
					"09D3 -1 28 0\r\n" + 
					"09D4 2 2 0\r\n" + 
					"09D5 -1 4 1\r\n" + 
					"09D6 -1 4 1\r\n" + 
					"09D8 2 2 1\r\n" + 
					"09D7 -1 5 1\r\n" + 
					"09D9 4 4 0\r\n" + 
					"09DA -1 8 0\r\n" + 
					"09DB -1 84 1\r\n" + 
					"09DC -1 77 1\r\n" + 
					"09DD -1 78 1\r\n" + 
					"09DE -1 33 1\r\n" + 
					"09DF 7 7 1\r\n" + 
					"09E0 -1 40 0\r\n" + 
					"09E1 8 8 1\r\n" + 
					"09E2 8 8 1\r\n" + 
					"09E3 8 8 1\r\n" + 
					"09E4 8 8 1\r\n" + 
					"09E5 18 18 1\r\n" + 
					"09E6 22 22 1\r\n" + 
					"09E7 3 3 1\r\n" + 
					"09E8 11 11 1\r\n" + 
					"09E9 2 2 1\r\n" + 
					"09EE 11 11 1\r\n" + 
					"09EF 11 11 1\r\n" + 
					"09F0 -1 7 1\r\n" + 
					"0A7D -1 7 1\r\n" + 
					"09F5 11 11 1\r\n" + 
					"09F6 11 11 1\r\n" + 
					"09EA 11 11 1\r\n" + 
					"09EB -1 24 1\r\n" + 
					"09F7 75 75 1\r\n" + 
					"09EC -1 64 1\r\n" + 
					"09ED 3 3 1\r\n" + 
					"09F3 11 11 1\r\n" + 
					"09F4 12 12 1\r\n" + 
					"09F1 11 11 1\r\n" + 
					"09F2 12 12 1\r\n" + 
					"0A04 6 6 1\r\n" + 
					"0A05 53 53 1\r\n" + 
					"0A06 6 6 1\r\n" + 
					"0A07 9 9 1\r\n" + 
					"0A03 2 2 1\r\n" + 
					"0A08 26 26 1\r\n" + 
					"0A12 27 27 1\r\n" + 
					"0A13 26 26 1\r\n" + 
					"0A14 10 10 1\r\n" + 
					"0A51 34 34 1\r\n" + 
					"0A32 2 2 0\r\n" + 
					"09F8 -1 8 1\r\n" + 
					"09F9 143 143 1\r\n" + 
					"09FA -1 6 1\r\n" + 
					"09FB -1 6 0\r\n" + 
					"09FC 6 6 1\r\n" + 
					"09FD -1 86 1\r\n" + 
					"09FE -1 79 1\r\n" + 
					"09FF -1 80 1\r\n" + 
					"0A00 269 269 1\r\n" + 
					"0A01 3 3 0\r\n" + 
					"0A02 4 4 1\r\n" + 
					"0A09 45 45 1\r\n" + 
					"0A0A 47 47 1\r\n" + 
					"0A0B 47 47 1\r\n" + 
					"0A0C 56 56 1\r\n" + 
					"0A0D -1 4 1\r\n" + 
					"0A0F -1 4 1\r\n" + 
					"0A10 -1 28 1\r\n" + 
					"0A11 -1 28 1\r\n" + 
					"0A0E 14 14 1\r\n" + 
					"0A15 12 12 1\r\n" + 
					"0A16 26 26 0\r\n" + 
					"0A17 6 6 1\r\n" + 
					"0A18 14 14 1\r\n" + 
					"0A19 2 2 1\r\n" + 
					"0A1A 23 23 1\r\n" + 
					"0A1B 2 2 1\r\n" + 
					"0A1C -1 8 1\r\n" + 
					"0A1D 2 2 1\r\n" + 
					"0A1E 3 3 1\r\n" + 
					"0A1F 2 2 1\r\n" + 
					"0A20 21 21 1\r\n" + 
					"0A21 3 3 1\r\n" + 
					"0A22 5 5 1\r\n" + 
					"0A23 -1 22 1\r\n" + 
					"0A24 66 66 1\r\n" + 
					"0A25 6 6 1\r\n" + 
					"0A26 7 7 1\r\n" + 
					"0A27 8 8 1\r\n" + 
					"0A28 3 3 1\r\n" + 
					"0A29 6 6 0\r\n" + 
					"0A2A 6 6 0\r\n" + 
					"0A2B 10 10 0\r\n" + 
					"0A2C 12 12 0\r\n" + 
					"0A2D -1 45 0\r\n" + 
					"0A2E 6 6 1\r\n" + 
					"0A2F 7 7 1\r\n" + 
					"0A30 106 106 1\r\n" + 
					"0A31 -1 6 0\r\n" + 
					"0A33 7 7 0\r\n" + 
					"0A34 6 6 0\r\n" + 
					"0A35 4 4 0\r\n" + 
					"0A36 7 7 1\r\n" + 
					"0A37 57 57 1\r\n" + 
					"0A38 3 3 1\r\n" + 
					"0A68 3 3 1\r\n" + 
					"0A39 36 36 1\r\n" + 
					"0A3A 12 12 1\r\n" + 
					"0A3B -1 12 1\r\n" + 
					"0A3C -1 18 0\r\n" + 
					"0A3D 18 18 0\r\n" + 
					"0A3E -1 16 0\r\n" + 
					"0A3F 9 9 0\r\n" + 
					"0A40 11 11 0\r\n" + 
					"0A41 18 18 0\r\n" + 
					"0A42 43 43 0\r\n" + 
					"0A43 85 85 0\r\n" + 
					"0A44 -1 28 0\r\n" + 
					"0A46 14 14 0\r\n" + 
					"0A47 3 3 0\r\n" + 
					"0A48 2 2 0\r\n" + 
					"0A49 22 22 0\r\n" + 
					"0A4A 6 6 0\r\n" + 
					"0A4B 22 22 0\r\n" + 
					"0A4C 28 28 0\r\n" + 
					"0A8F 2 2 0\r\n" + 
					"0A90 3 3 0\r\n" + 
					"0A4D -1 63 0\r\n" + 
					"0A79 -1 67 0\r\n" + 
					"0A4E 4 4 0\r\n" + 
					"0A70 2 2 0\r\n" + 
					"0A4F -1 6 0\r\n" + 
					"0A50 4 4 0\r\n" + 
					"0A52 20 20 0\r\n" + 
					"0A53 10 10 0\r\n" + 
					"0A54 -1 8 0\r\n" + 
					"0A55 2 2 0\r\n" + 
					"0A56 6 6 0\r\n" + 
					"0A57 6 6 0\r\n" + 
					"0A58 8 8 0\r\n" + 
					"0A59 -1 8 0\r\n" + 
					"0A5A 2 2 0\r\n" + 
					"0A5B 7 7 0\r\n" + 
					"0A5C 18 18 0\r\n" + 
					"0A5D 6 6 0\r\n" + 
					"0A69 6 6 0\r\n" + 
					"0A6A 12 12 0\r\n" + 
					"0A6B -1 8 0\r\n" + 
					"0A6C 7 7 0\r\n" + 
					"0A6D -1 4 0\r\n" + 
					"0A6E -1 68 1\r\n" + 
					"0A6F -1 10 1\r\n" + 
					"0A71 -1 5 0\r\n" + 
					"0A72 61 61 0\r\n" + 
					"0A73 2 2 0\r\n" + 
					"0A74 8 8 0\r\n" + 
					"0A76 80 80 0\r\n" + 
					"0A77 15 15 0\r\n" + 
					"0A78 15 15 0\r\n" + 
					"0A7B -1 4 0\r\n" + 
					"0A7C -1 4 0\r\n" + 
					"0A7E -1 5 1\r\n" + 
					"0A8C 2 2 1\r\n" + 
					"0A80 6 6 1\r\n" + 
					"0A7F -1 88 1\r\n" + 
					"0A8D -1 17 1\r\n" + 
					"0A81 4 4 1\r\n" + 
					"0A92 -1 96 1\r\n" + 
					"0A91 -1 25 1\r\n" + 
					"0A93 3 3 1\r\n" + 
					"0A94 2 2 1\r\n" + 
					"0A89 57 57 1\r\n" + 
					"0A8A 6 6 1\r\n" + 
					"0A82 46 46 1\r\n" + 
					"0A83 46 46 1\r\n" + 
					"0A84 94 94 1\r\n" + 
					"0A85 82 82 1\r\n" + 
					"0A86 -1 4 1\r\n" + 
					"0A87 -1 4 1\r\n" + 
					"0A88 2 2 0\r\n" + 
					"0A8B 2 2 0\r\n" + 
					"0A8E 2 2 0\r\n" + 
					"0A95 4 4 1\r\n" + 
					"0369 7 7 0\r\n" + 
					"083C 10 10 0\r\n" + 
					"0437 5 5 0\r\n" + 
					"035F 6 6 0\r\n" + 
					"0967 5 5 0\r\n" + 
					"07E4 6 6 0\r\n" + 
					"0362 6 6 0\r\n" + 
					"07EC 8 8 0\r\n" + 
					"0364 8 8 0\r\n" + 
					"0438 10 10 0\r\n" + 
					"0366 90 90 0\r\n" + 
					"096A 6 6 0\r\n" + 
					"0368 6 6 0\r\n" + 
					"0838 12 12 0\r\n" + 
					"0835 2 2 0\r\n" + 
					"0819 -1 15 0\r\n" + 
					"0811 -1 12 0\r\n" + 
					"0360 6 6 0\r\n" + 
					"0817 2 2 0\r\n" + 
					"0815 -1 89 0\r\n" + 
					"0365 18 18 0\r\n" + 
					"023B 8 8 0\r\n" + 
					"0281 -1 12 0\r\n" + 
					"088E 19 19 0\r\n" + 
					"0802 26 26 0\r\n" + 
					"0436 4 4 0\r\n" + 
					"0943 26 26 0\r\n" + 
					"0928 5 5 0\r\n" + 
					"0363 36 36 0\r\n" + 
					"0367 2 2 0\r\n" + 
					"085A 2 2 0\r\n" + 
					"085B 2 2 0\r\n" + 
					"085C 2 2 0\r\n" + 
					"085D 2 2 0\r\n" + 
					"085E 2 2 0\r\n" + 
					"085F 2 2 0\r\n" + 
					"0860 2 2 0\r\n" + 
					"0861 2 2 0\r\n" + 
					"0862 2 2 0\r\n" + 
					"0863 2 2 0\r\n" + 
					"0864 2 2 0\r\n" + 
					"0865 2 2 0\r\n" + 
					"0866 2 2 0\r\n" + 
					"0867 2 2 0\r\n" + 
					"0868 2 2 0\r\n" + 
					"0869 2 2 0\r\n" + 
					"086A 2 2 0\r\n" + 
					"086B 2 2 0\r\n" + 
					"086C 2 2 0\r\n" + 
					"086D 2 2 0\r\n" + 
					"086E 2 2 0\r\n" + 
					"086F 2 2 0\r\n" + 
					"0870 2 2 0\r\n" + 
					"0871 2 2 0\r\n" + 
					"0872 2 2 0\r\n" + 
					"0873 2 2 0\r\n" + 
					"0874 2 2 0\r\n" + 
					"0875 2 2 0\r\n" + 
					"0876 2 2 0\r\n" + 
					"0877 2 2 0\r\n" + 
					"0878 2 2 0\r\n" + 
					"0879 2 2 0\r\n" + 
					"087A 2 2 0\r\n" + 
					"087B 2 2 0\r\n" + 
					"087C 2 2 0\r\n" + 
					"087D 2 2 0\r\n" + 
					"087E 2 2 0\r\n" + 
					"087F 2 2 0\r\n" + 
					"0880 2 2 0\r\n" + 
					"0881 2 2 0\r\n" + 
					"0882 2 2 0\r\n" + 
					"0883 2 2 0\r\n" + 
					"0917 2 2 0\r\n" + 
					"0918 2 2 0\r\n" + 
					"0919 2 2 0\r\n" + 
					"091A 2 2 0\r\n" + 
					"091B 2 2 0\r\n" + 
					"091C 2 2 0\r\n" + 
					"091D 2 2 0\r\n" + 
					"091E 2 2 0\r\n" + 
					"091F 2 2 0\r\n" + 
					"0920 2 2 0\r\n" + 
					"0921 2 2 0\r\n" + 
					"0922 2 2 0\r\n" + 
					"0923 2 2 0\r\n" + 
					"0924 2 2 0\r\n" + 
					"0925 2 2 0\r\n" + 
					"0926 2 2 0\r\n" + 
					"0927 2 2 0\r\n" + 
					"022D 2 2 0\r\n" + 
					"0929 2 2 0\r\n" + 
					"092A 2 2 0\r\n" + 
					"092B 2 2 0\r\n" + 
					"092C 2 2 0\r\n" + 
					"092D 2 2 0\r\n" + 
					"092E 2 2 0\r\n" + 
					"092F 2 2 0\r\n" + 
					"0930 2 2 0\r\n" + 
					"0931 2 2 0\r\n" + 
					"0932 2 2 0\r\n" + 
					"0933 2 2 0\r\n" + 
					"0934 2 2 0\r\n" + 
					"0935 2 2 0\r\n" + 
					"0936 2 2 0\r\n" + 
					"0937 2 2 0\r\n" + 
					"0938 2 2 0\r\n" + 
					"0939 2 2 0\r\n" + 
					"093A 2 2 0\r\n" + 
					"093B 2 2 0\r\n" + 
					"093C 2 2 0\r\n" + 
					"093D 2 2 0\r\n" + 
					"093E 2 2 0\r\n" + 
					"093F 2 2 0\r\n" + 
					"02C4 2 2 0\r\n" + 
					"0884 2 2 0\r\n" + 
					"0885 2 2 0\r\n" + 
					"0886 2 2 0\r\n" + 
					"0887 2 2 0\r\n" + 
					"0888 2 2 0\r\n" + 
					"0889 2 2 0\r\n" + 
					"088A 2 2 0\r\n" + 
					"088B 2 2 0\r\n" + 
					"088C 2 2 0\r\n" + 
					"0940 2 2 0\r\n" + 
					"088D 2 2 0\r\n" + 
					"088F 2 2 0\r\n" + 
					"0890 2 2 0\r\n" + 
					"0891 2 2 0\r\n" + 
					"0892 2 2 0\r\n" + 
					"0893 2 2 0\r\n" + 
					"0894 2 2 0\r\n" + 
					"0895 2 2 0\r\n" + 
					"0896 2 2 0\r\n" + 
					"0897 2 2 0\r\n" + 
					"0898 2 2 0\r\n" + 
					"0899 2 2 0\r\n" + 
					"089A 2 2 0\r\n" + 
					"089B 2 2 0\r\n" + 
					"089C 2 2 0\r\n" + 
					"089D 2 2 0\r\n" + 
					"089E 2 2 0\r\n" + 
					"089F 2 2 0\r\n" + 
					"08A0 2 2 0\r\n" + 
					"08A1 2 2 0\r\n" + 
					"08A2 2 2 0\r\n" + 
					"08A3 2 2 0\r\n" + 
					"08A4 2 2 0\r\n" + 
					"08A5 2 2 0\r\n" + 
					"08A6 2 2 0\r\n" + 
					"08A7 2 2 0\r\n" + 
					"08A8 2 2 0\r\n" + 
					"08A9 2 2 0\r\n" + 
					"08AA 2 2 0\r\n" + 
					"08AB 2 2 0\r\n" + 
					"08AC 2 2 0\r\n" + 
					"08AD 2 2 0\r\n" + 
					"0941 2 2 0\r\n" + 
					"0942 2 2 0\r\n" + 
					"0202 2 2 0\r\n" + 
					"0944 2 2 0\r\n" + 
					"0945 2 2 0\r\n" + 
					"0946 2 2 0\r\n" + 
					"0947 2 2 0\r\n" + 
					"0948 2 2 0\r\n" + 
					"0949 2 2 0\r\n" + 
					"094A 2 2 0\r\n" + 
					"094B 2 2 0\r\n" + 
					"094C 2 2 0\r\n" + 
					"094D 2 2 0\r\n" + 
					"094E 2 2 0\r\n" + 
					"094F 2 2 0\r\n" + 
					"0950 2 2 0\r\n" + 
					"0951 2 2 0\r\n" + 
					"0952 2 2 0\r\n" + 
					"0953 2 2 0\r\n" + 
					"0954 2 2 0\r\n" + 
					"0955 2 2 0\r\n" + 
					"0956 2 2 0\r\n" + 
					"0957 2 2 0\r\n" + 
					"0958 2 2 0\r\n" + 
					"0959 2 2 0\r\n" + 
					"095A 2 2 0\r\n" + 
					"095B 2 2 0\r\n" + 
					"095C 2 2 0\r\n" + 
					"095D 2 2 0\r\n" + 
					"095E 2 2 0\r\n" + 
					"095F 2 2 0\r\n" + 
					"0960 2 2 0\r\n" + 
					"0961 2 2 0\r\n" + 
					"0962 2 2 0\r\n" + 
					"0963 2 2 0\r\n" + 
					"0964 2 2 0\r\n" + 
					"0965 2 2 0\r\n" + 
					"0966 2 2 0\r\n" + 
					"0361 2 2 0\r\n" + 
					"0968 2 2 0\r\n" + 
					"0969 2 2 0");
			Files.write(path, linhas);      
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao modificar o \"poseidon\\download\\hades-master\\conf\\recvpackets.txt\"");
			return;
		}
		Modifica("19");
	}
	
	//MODIFICAR O HADES-MASTER\CONF\POSEIDON.TXT
	public void F19() {
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
		Modifica("20");
	}
	
	//TUDO OK!
	public void F20() {
		JOptionPane.showMessageDialog(null, "Tudo pronto");
	}
}