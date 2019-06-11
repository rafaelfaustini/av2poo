package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Disciplina;
import Banco.Conexao;

public class DisciplinaController {
	public void create(Disciplina disciplina)
	{
		try {
			Conexao con = new Conexao();
			String query = "INSERT INTO disciplina(nome) VALUES ('" + disciplina.getNome()+"')";
			Statement st = con.conexao.createStatement();
			st.executeUpdate(query);
			con.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}
		

	}
	public void remover(String disciplina)
	{
		
		
		try {
			Conexao con = new Conexao();
			Statement st = con.conexao.createStatement();
			String query = "DELETE FROM disciplina where nome='" + disciplina+"'";
			st = con.conexao.createStatement();
			st.executeUpdate(query);
			con.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}
		

	}
	public void editar(String antes, String nome)
	{
		
		
		try {
			Conexao con = new Conexao();
			Statement st = con.conexao.createStatement();
			String query = "UPDATE disciplina SET nome='"+nome+"' where nome='" + antes+"'";
			st = con.conexao.createStatement();
			st.executeUpdate(query);
			con.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}
		

	}
	
	public List<String> listar() {
		List<String> l= new ArrayList<String>();
		try {
			Conexao con = new Conexao();
			String query = "SELECT nome from disciplina";
			Statement st = con.conexao.createStatement();
			ResultSet r = st.executeQuery(query);
		    while (r.next())
		      {
		        l.add( r.getString("nome") );
		      }	
			con.conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}
		return l;
	}
	
}


