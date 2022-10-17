/*Daniel Henrique Alcantara Oliveira Martins  RM: 94615
* Luis Felipe Garcia Menezes  RM: 94051
* Pedro Victor Saraiva de Sa  RM: 93627
*/

package fiap.model;

public class Filme {

	private String codigo;
	private String titulo;
	private String genero;
	private String produtora;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getProdutora() {
		return produtora;
	}

	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}

}
