package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DisciplinaController;
import Controller.ProfessorController;
import Model.Disciplina;
import Model.Professor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarProfessorView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarProfessorView frame = new EditarProfessorView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void atualizarDisciplina(JComboBox c) {
		DisciplinaController controller = new DisciplinaController();
		c.setModel(new JComboBox(controller.listar().toArray()).getModel());
	}
	public void atualizarProfessor(JComboBox c) {
		ProfessorController controller = new ProfessorController();
		c.setModel(new JComboBox(controller.listar().toArray()).getModel());
	}
	public EditarProfessorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditarProfessor = new JLabel("Editar Professor");
		lblEditarProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarProfessor.setBounds(30, 11, 345, 14);
		contentPane.add(lblEditarProfessor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(134, 36, 155, 20);
		contentPane.add(comboBox);
		atualizarProfessor(comboBox);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(109, 100, 92, 20);
		Professor professor = (Professor)comboBox.getSelectedItem();
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(professor.getCpf());
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(109, 85, 46, 14);
		contentPane.add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setBounds(211, 100, 114, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(professor.getNome());
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(211, 85, 46, 14);
		contentPane.add(lblNome);
		
		textField_2 = new JTextField();
		textField_2.setBounds(109, 145, 114, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(professor.getEmail());
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(109, 131, 46, 14);
		contentPane.add(lblEmail);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(233, 145, 92, 20);
		contentPane.add(comboBox_1);
		atualizarDisciplina(comboBox_1);
		
		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(233, 131, 46, 14);
		contentPane.add(lblDisciplina);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Disciplina disciplina = (Disciplina)comboBox_1.getSelectedItem();
				Professor professor = new Professor(textField.getText(), textField_1.getText(), disciplina ,textField_2.getText());
				ProfessorController controller = new ProfessorController();
				
				controller.editar(professor);
				JOptionPane.showMessageDialog(null, "Professor editado com sucesso");
			}
		});
		btnEditar.setBounds(168, 192, 89, 23);
		contentPane.add(btnEditar);
	}

}
