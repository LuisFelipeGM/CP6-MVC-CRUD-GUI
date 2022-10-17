/*Daniel Henrique Alcantara Oliveira Martins  RM: 94615
* Luis Felipe Garcia Menezes  RM: 94051
* Pedro Victor Saraiva de Sa  RM: 93627
*/

package fiap.model;

import java.util.ArrayList;

public interface IDAO {
	
	public String inserir(Object obj);

	public String alterar(Object obj);

	public String excluir(Object obj);

	public ArrayList<String> listarUm(String id);

}
