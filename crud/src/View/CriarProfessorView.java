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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CriarProfessorView extends JFrame {

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
					CriarProfessorView frame = new CriarProfessorView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void atualizar(JComboBox c) {
		DisciplinaController controller = new DisciplinaController();
		c.setModel(new JComboBox(controller.listar().toArray()).getModel());
	}
	
	
	/**
	 * Create the frame.
	 */
	public CriarProfessorView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInserirProfessor = new JLabel("Inserir Professor");
		lblInserirProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProfessor.setBounds(57, 11, 291, 14);
		contentPane.add(lblInserirProfessor);
		
		textField = new JTextField();
		textField.setBounds(122, 60, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(122, 46, 89, 14);
		contentPane.add(lblCpf);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(122, 91, 89, 14);
		contentPane.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 105, 143, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(122, 150, 143, 20);
		contentPane.add(textField_2);
		
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(122, 136, 89, 14);
		contentPane.add(lblEmail);
		
		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(122, 181, 111, 14);
		contentPane.add(lblDisciplina);
		
		JComboBox<Disciplina> comboBox = new JComboBox<Disciplina>();
		atualizar(comboBox);
		comboBox.setBounds(122, 195, 144, 20);
		contentPane.add(comboBox);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfessorController controller = new ProfessorController();
				Professor professor = new Professor(textField.getText(), textField_1.getText(), (Disciplina)comboBox.getSelectedItem(), textField_2.getText());
				controller.create(professor);
				JOptionPane.showMessageDialog(null, "Professor "+professor.getNome()+" criado com sucesso");
			}
		});
		btnInserir.setBounds(144, 246, 89, 23);
		contentPane.add(btnInserir);
	}
}
