package fiap.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class GUIPrincipal extends JFrame {
	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnArquivo, mnCadastros;
	private JMenuItem miSair, miFilmes;
	
	public GUIPrincipal() {
		inicializarComponentes();
		definirEventos();
	}
	
	public void inicializarComponentes() {
		setTitle("Janela Principal");
		setBounds(0, 0, 800, 500);
		contentPane = getContentPane();
		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		mnCadastros = new JMenu("Cadastros");
		mnCadastros.setMnemonic('C');
		miSair = new JMenuItem("Sair", new ImageIcon(getClass().getResource("exit_icon.png")));
		miFilmes = new JMenuItem("Filmes");
		setJMenuBar(mnBarra);
		mnBarra.add(mnArquivo);
		mnBarra.add(mnCadastros);
		mnArquivo.add(miSair);
		mnCadastros.add(miFilmes);
	}
	
	public void definirEventos() {
		
		miSair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		
		miFilmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIFilmes filmes = new GUIFilmes();
				contentPane.removeAll();
				contentPane.add(filmes);
				contentPane.validate();

			}
		});
		
	}
	public static void main(String[] args) {
		GUIPrincipal frame = new GUIPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2,
				(tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}

}