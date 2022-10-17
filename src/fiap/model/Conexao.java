/*Daniel Henrique Alcantara Oliveira Martins  RM: 94615
* Luís Felipe Garcia Menezes  RM: 94051
* Pedro Victor Saraiva de Sá  RM: 93627
*/

package fiap.model;

import java.sql.*;

public class Conexao {
	public static Connection abrirConexao() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			final String USER = "RM94615";
			final String PASS = "170504";
			con = DriverManager.getConnection(url, USER, PASS);
			//System.out.println("Conexão Aberta!");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	public static void fecharConexao(Connection con) {
		try {
			con.close();
			//System.out.println("Conexão fechada!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
