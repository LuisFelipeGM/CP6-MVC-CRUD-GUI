package fiap.model;

import java.sql.*;
import java.util.*;

public class FilmeDAO implements IDAO {
	private Connection con;
	private Filme filme;
	
	
	public FilmeDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		filme = (Filme) obj;
		String sql = "INSERT INTO FILMES (CODIGO, TITULO, GENERO, PRODUTORA) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			ps.setString(2, filme.getTitulo());
			ps.setString(3, filme.getGenero());
			ps.setString(4, filme.getProdutora());
			if (ps.executeUpdate() > 0) {
				return "Inserido com Sucesso";
			} else {
				return "Erro ao Inserir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String alterar(Object obj) {
		filme = (Filme) obj;
		String sql = "UPDATE FILMES SET TITULO = ?, GENERO = ?, PRODUTORA = ? WHERE CODIGO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getTitulo());
			ps.setString(2, filme.getGenero());
			ps.setString(3, filme.getProdutora());
			ps.setString(4, filme.getCodigo());
			if (ps.executeUpdate() > 0) {
				return "Alterado com Sucesso";
			} else {
				return "Erro ao Alterar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String excluir(Object obj) {
		filme = (Filme) obj;
		String sql = "DELETE FROM FILMES WHERE CODIGO = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			if (ps.executeUpdate() > 0) {
				return "Excluido com Sucesso";
			} else {
				return "Erro ao Excluido";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public ArrayList<String> listarUm(String id){
		String sql = "SELECT * FROM FILMES WHERE CODIGO = ?";
		ArrayList<String> resul = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resul.add(rs.getString(1));
				resul.add(rs.getString(2));
				resul.add(rs.getString(3));
				resul.add(rs.getString(4));
				return resul;
			} else {
				return resul;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
