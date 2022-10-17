package fiap.controller;

import java.sql.*;
import fiap.model.*;
import java.util.*;

public class FilmeController {
	
		public String insereFilme(String codigo, String titulo, String genero, String produtora) {
			String resultado;
			Connection con = Conexao.abrirConexao();
			Filme filme = new Filme();
			FilmeDAO filmeDAO = new FilmeDAO(con);
			filme.setCodigo(codigo);
			filme.setTitulo(titulo);
			filme.setGenero(genero);
			filme.setProdutora(produtora);
			resultado = filmeDAO.inserir(filme);
			Conexao.fecharConexao(con);
			return resultado;
		}
		
		public String alteraFilme(String codigo, String titulo, String genero, String produtora) {
			String resultado;
			Connection con = Conexao.abrirConexao();
			Filme filme = new Filme();
			FilmeDAO filmeDAO = new FilmeDAO(con);
			filme.setCodigo(codigo);
			filme.setTitulo(titulo);
			filme.setGenero(genero);
			filme.setProdutora(produtora);
			resultado = filmeDAO.alterar(filme);
			Conexao.fecharConexao(con);
			return resultado;
		}
		
		public String excluiFilme(String codigo) {
			String resultado;
			Connection con = Conexao.abrirConexao();
			Filme filme = new Filme();
			FilmeDAO filmeDAO = new FilmeDAO(con);
			filme.setCodigo(codigo);
			resultado = filmeDAO.excluir(filme);
			Conexao.fecharConexao(con);
			return resultado;
		}
		
		public ArrayList<String> listaFilme(String codigo){
			ArrayList<String> resultado = new ArrayList<String>();
			Connection con = Conexao.abrirConexao();
			FilmeDAO filmeDAO = new FilmeDAO(con);
			resultado = filmeDAO.listarUm(codigo);
			Conexao.fecharConexao(con);
			//System.out.println(resultado);
			if (resultado != null) {
				return resultado;
			} else {
				return null;
			}
			
		}

}
