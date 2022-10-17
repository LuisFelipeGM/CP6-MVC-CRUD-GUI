package fiap.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

import fiap.controller.FilmeController;

@SuppressWarnings("serial")
public class GUIFilmes extends JPanel {
	private JLabel lbCodigo, lbTitulo, lbProdutora, lbGenero, lbImagem;
	private JTextField tfCodigo, tfTitulo;
	private JRadioButton rbWarner, rbFox, rbDisney, rbUniversal;
	private JList<String> liFotos;
	private ImageIcon imagem1;
	private JScrollPane sp;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga;
	private ButtonGroup btGroup;
	
	public GUIFilmes() {
		inicializarComponentes();
		definirEventos();
	}
	
	public void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.lightGray);
		lbCodigo = new JLabel("Codigo:");
		lbTitulo = new JLabel("Titulo:");
		tfCodigo = new JTextField();
		tfTitulo = new JTextField();
		
		btPesquisa = new JButton(new ImageIcon(getClass().getResource("imagens/search_icon.png")));
		btNovo = new JButton(new ImageIcon(getClass().getResource("imagens/new_icon.png")));
		btAtualiza = new JButton(new ImageIcon(getClass().getResource("imagens/update_icon.png")));
		btApaga = new JButton(new ImageIcon(getClass().getResource("imagens/delete_icon.png")));
		
		lbProdutora = new JLabel("Produtora:");
		rbWarner = new JRadioButton("Warner");
		rbWarner.setBackground(getBackground());
		rbFox = new JRadioButton("Fox");
		rbFox.setBackground(getBackground());
		rbDisney = new JRadioButton("Disney");
		rbDisney.setBackground(getBackground());
		rbUniversal= new JRadioButton("Universal");
		rbUniversal.setBackground(getBackground());
		btGroup = new ButtonGroup();
		btGroup.add(rbWarner);
		btGroup.add(rbFox);
		btGroup.add(rbDisney);
		btGroup.add(rbUniversal);
		
		String[] fotos = new String[5];
		fotos[0] = "Fantasia";
		fotos[1] = "Infantil";
		fotos[2] = "Medieval";
		fotos[3] = "Nordico";
		fotos[4] = "Terror";
        
        liFotos = new JList<String>(fotos);
        sp = new JScrollPane(liFotos);
        lbGenero = new JLabel("Genero:");
        imagem1 = new ImageIcon();
        lbImagem = new JLabel(imagem1);
		
		
		lbCodigo.setBounds(20, 40, 60, 25);
		tfCodigo.setBounds(80, 40, 60, 25);
		lbTitulo.setBounds(20, 75, 60, 25);
		tfTitulo.setBounds(80, 75, 230, 25);
		
		lbProdutora.setBounds(20, 150, 70, 25);
		rbWarner.setBounds(30, 175, 100, 25);
		rbFox.setBounds(30, 200, 100, 25);
		rbDisney.setBounds(30, 225, 100, 25);
		rbUniversal.setBounds(30, 250, 100, 25);
		
		lbGenero.setBounds(375, 30, 60, 25);
		sp.setBounds(375, 75, 120, 110);
		lbImagem.setBounds(520, 20, 220, 220);
		
		btPesquisa.setBounds(150,350,60,40);
		btNovo.setBounds(290,350,60,40);
		btAtualiza.setBounds(430,350,60,40);
		btApaga.setBounds(570,350,60,40);
		
		add(lbCodigo);
		add(tfCodigo);
		add(lbTitulo);
		add(tfTitulo);
		add(lbProdutora);
		add(rbWarner);
		add(rbFox);
		add(rbDisney);
		add(rbUniversal);
		add(lbGenero);
		add(sp);
		add(lbImagem);
		add(btPesquisa);
		add(btNovo);
		add(btAtualiza);
		add(btApaga);

		
	}
	
	public void definirEventos() {
		
		 liFotos.addListSelectionListener(new ListSelectionListener() {
	            public void valueChanged(ListSelectionEvent e) {
	                imagem1 = new ImageIcon(getClass().getResource("Imagens/" + 
	                					liFotos.getSelectedValue() + ".png"));
	                lbImagem.setIcon(imagem1);
	            }
	     });
	        
	    
		btApaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmeController filme = new FilmeController();
				if (tfCodigo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha a Placa");
					tfCodigo.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, filme.excluiFilme(tfCodigo.getText()));
					tfCodigo.setText("");
					tfTitulo.setText("");
				}
				
			}
		});
		
		btAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmeController filme = new FilmeController();
				if (tfCodigo.getText().equals("") || tfTitulo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					String prod = "";
					if(rbWarner.isSelected()) {
						prod = "Warner";
					}else if(rbFox.isSelected()){
						prod = "Fox";
					}else if(rbDisney.isSelected()){
						prod = "Disney";
					}else if(rbUniversal.isSelected()){
						prod = "Universal";
					}
					
					JOptionPane.showMessageDialog(null, filme.alteraFilme(tfCodigo.getText(), tfTitulo.getText(),
							liFotos.getSelectedValue(), prod));
					tfCodigo.setText("");
					tfTitulo.setText("");
				}
				
			}
		});
		
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmeController filme = new FilmeController();
				String prod = "";
				if(rbWarner.isSelected()) {
					prod = "Warner";
				}else if(rbFox.isSelected()){
					prod = "Fox";
				}else if(rbDisney.isSelected()){
					prod = "Disney";
				}else if(rbUniversal.isSelected()){
					prod = "Universal";
				}else {
					prod = "";
				}
				if (tfCodigo.getText().equals("") || tfTitulo.getText().equals("") || prod.equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					
					JOptionPane.showMessageDialog(null, filme.insereFilme(tfCodigo.getText(), tfTitulo.getText(),
							liFotos.getSelectedValue(), prod));
					tfCodigo.setText("");
					tfTitulo.setText("");
				}
				
			}
		});
		
		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmeController filme = new FilmeController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfCodigo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha a Placa");
					tfCodigo.requestFocus();
				} else {
					dados = filme.listaFilme(tfCodigo.getText());
					if (dados != null) {
						tfTitulo.setText(dados.get(1));
						
						if(dados.get(3).equals("Warner")) {
							rbWarner.setSelected(true);
						}else if(dados.get(3).equals("Fox")){
							rbFox.setSelected(true);
						}else if(dados.get(3).equals("Disney")){
							rbDisney.setSelected(true);
						}else if(dados.get(3).equals("Universal")){
							rbUniversal.setSelected(true);
						}
						
						if (dados.get(2).equals("Fantasia")) {
							imagem1 = new ImageIcon(getClass().getResource("Imagens/Fantasia.png"));
							lbImagem.setIcon(imagem1);
						} else if(dados.get(2).equals("Infantil")){
							imagem1 = new ImageIcon(getClass().getResource("Imagens/Infantil.png"));
							lbImagem.setIcon(imagem1);
						} else if (dados.get(2).equals("Medieval")) {
							imagem1 = new ImageIcon(getClass().getResource("Imagens/Medieval.png"));
							lbImagem.setIcon(imagem1);
						} else if (dados.get(2).equals("Nordico")) {
							imagem1 = new ImageIcon(getClass().getResource("Imagens/Nordico.png"));
							lbImagem.setIcon(imagem1);
						} else if (dados.get(2).equals("Terror")) {
							imagem1 = new ImageIcon(getClass().getResource("Imagens/Terror.png"));
							lbImagem.setIcon(imagem1);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
				}
				
				
			}
		});
		
		
		
	}
}