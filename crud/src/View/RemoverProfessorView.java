package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DisciplinaController;
import Controller.ProfessorController;
import Model.Professor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoverProfessorView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverProfessorView frame = new RemoverProfessorView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void atualizar(JComboBox c) {
		ProfessorController controller = new ProfessorController();
		c.setModel(new JComboBox(controller.listar().toArray()).getModel());
	}
	/**
	 * Create the frame.
	 */
	public RemoverProfessorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoverProfessor = new JLabel("Remover Professor");
		lblRemoverProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverProfessor.setBounds(33, 11, 366, 14);
		contentPane.add(lblRemoverProfessor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(159, 53, 107, 20);
		contentPane.add(comboBox);
		atualizar(comboBox);
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProfessorController controller = new ProfessorController();
				Professor professor = (Professor)comboBox.getSelectedItem();
				controller.remover(professor);
				atualizar(comboBox);
				
			}
		});
		btnRemover.setBounds(159, 94, 107, 23);
		contentPane.add(btnRemover);
	}

}
