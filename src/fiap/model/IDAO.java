package fiap.model;

import java.util.ArrayList;

public interface IDAO {
	
	public String inserir(Object obj);

	public String alterar(Object obj);

	public String excluir(Object obj);

	public ArrayList<String> listarUm(String id);

}
