package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Banco.Conexao;
import Model.Professor;

public class ProfessorController {
	public void create(Professor professor)
	{
		if(canCreate(professor)) {
			
			
			
			
		}
		

	}
	public void remover(String disciplina)
	{
		
		
	
		

	}
	public void editar(String antes, String nome)
	{
		
		

		

	}
	
	public boolean canCreate(Professor professor) {
		
		try {
			Conexao con = new Conexao();
			Statement st = con.conexao.createStatement();
			String query = "SELECT * FROM professor where cpf='" +professor.getCpf() +"'";
			st = con.conexao.createStatement();
			st.executeQuery(query);
			ResultSet r = st.getResultSet();
			con.conexao.close();
			if(!r.next()) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}	
		return false;
	}

	
	
	
	}

