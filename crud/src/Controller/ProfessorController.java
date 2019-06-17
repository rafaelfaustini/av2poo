package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Banco.Conexao;
import Model.Disciplina;
import Model.Professor;

public class ProfessorController {
	public void create(Professor professor)
	{
		if(canCreate(professor)) {
			int id = professor.getDisciplina().getId();
			try {
				Conexao con = new Conexao();
				Statement st = con.conexao.createStatement();
				String query = "INSERT INTO professor values('"+professor.getCpf()+"', "
						+ "'"+professor.getNome()+"', '"+professor.getEmail()+"', "+id+" )";
				st = con.conexao.createStatement();
				st.execute(query);
				ResultSet r = st.getResultSet();
				con.conexao.close();
				
			} catch (SQLException e) {
				System.out.println("PC");
				e.printStackTrace();
			} finally {
			
			}	
			
			
			
		}
		

	}
	public void remover(Professor professor)
	{
		
		try {
			Conexao con = new Conexao();
			Statement st = con.conexao.createStatement();
			String query = "DELETE FROM professor WHERE cpf = '"+professor.getCpf()+"';";
			st = con.conexao.createStatement();
			st.execute(query);
			ResultSet r = st.getResultSet();
			con.conexao.close();
		} catch (SQLException e) {
			System.out.println("PR");
			e.printStackTrace();
		} finally {
		
		}	
	
		

	}
	public void editar(Professor professor)
	{
		
		
		try {
			Conexao con = new Conexao();
			Statement st = con.conexao.createStatement();
			int id = professor.getDisciplina().getId();
			String query = "UPDATE professor set nome='"+professor.getNome()+"', email='"+professor.getEmail()+"', disciplina='"+id+"' where cpf="+professor.getCpf();
			st = con.conexao.createStatement();
			st.execute(query);
			ResultSet r = st.getResultSet();
			con.conexao.close();
		} catch (SQLException e) {
			System.out.println("PE");
			e.printStackTrace();
		} finally {
		
		}	
		

	}
	
	
	public boolean canCreate(Professor professor) {
		
		try {
			Conexao con = new Conexao();
			Statement st = con.conexao.createStatement();
			String query = "SELECT * FROM professor where cpf='" +professor.getCpf() +"'";
			st = con.conexao.createStatement();
			st.executeQuery(query);
			ResultSet r = st.getResultSet();

			if(!r.next()) {
				con.conexao.close();
				return true;
			} else {
				con.conexao.close();
				return false;
			}
			
		} catch (SQLException e) {
			System.out.println("ERRO");
			e.printStackTrace();
			
		} finally {
		
		}	
		return false;
	}
	
	public Disciplina getDisciplina(int id) {
		try {
			Conexao con = new Conexao();
			String query = "SELECT * from disciplina where id="+id;
			Statement st = con.conexao.createStatement();
			ResultSet r = st.executeQuery(query);
			r.next();
			Disciplina disciplina = new Disciplina(r.getString("nome"));
			
			disciplina.setId(r.getInt("id"));
			con.conexao.close();
			return disciplina;


		} catch (SQLException e) {
			
			System.out.println("GetDisciplina");
			e.printStackTrace();
		} finally {
		
		}
		return null;
	}

	public List<Professor> listar() {
		
		
		List<Professor> l= new ArrayList<Professor>();
		try {
			Conexao con = new Conexao();
			String query = "SELECT * from professor";
			Statement st = con.conexao.createStatement();
			ResultSet r = st.executeQuery(query);
		    while (r.next())
		      {
		    	Professor professor = new Professor(r.getString("cpf"), r.getString("nome"), getDisciplina(r.getInt("disciplina")), r.getString("email"));
		        l.add(professor);
		      }	
			con.conexao.close();

		} catch (SQLException e) {
			System.out.println("PL");
			e.printStackTrace();
		} finally {
		
		}
		return l;
	}
	
	
	}

