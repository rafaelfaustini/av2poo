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
	public void remover(Disciplina disciplina)
	{
		
		
		try {
			Conexao con = new Conexao();
			Statement st = con.conexao.createStatement();
			String query = "DELETE FROM disciplina where id=" + disciplina.getId()+"";
			st = con.conexao.createStatement();
			st.executeUpdate(query);
			con.conexao.close();
		} catch (SQLException e) {
			System.out.println("DR");
			e.printStackTrace();
		} finally {
		
		}
		

	}
	public void editar(Disciplina disciplina)
	{
		
		
		try {
			Conexao con = new Conexao();
			Statement st = con.conexao.createStatement();
			String query = "UPDATE disciplina SET nome='"+disciplina.getNome()+"' where id=" + disciplina.getId()+"";
			st = con.conexao.createStatement();
			st.executeUpdate(query);
			con.conexao.close();
		} catch (SQLException e) {
			System.out.println("DE");
			e.printStackTrace();
		} finally {
		
		}
		

	}
	
	public List<Disciplina> listar() {
		
		List<Disciplina> l= new ArrayList<Disciplina>();
		try {
			Conexao con = new Conexao();
			String query = "SELECT * from disciplina";
			Statement st = con.conexao.createStatement();
			ResultSet r = st.executeQuery(query);
		    while (r.next())
		      {
		    	Disciplina disciplina = new Disciplina(r.getString("nome"));
		    	disciplina.setId(r.getInt("id"));
		        l.add(disciplina);
		      }	
			con.conexao.close();

		} catch (SQLException e) {
			System.out.println("DL");
			e.printStackTrace();
		} finally {
		
		}
		return l;
	}
	
}


