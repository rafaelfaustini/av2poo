package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DisciplinaController;
import Model.Disciplina;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoverDisciplinaView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverDisciplinaView frame = new RemoverDisciplinaView();
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
	public RemoverDisciplinaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoverDisciplina = new JLabel("Remover Disciplina");
		lblRemoverDisciplina.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverDisciplina.setBounds(44, 11, 340, 14);
		contentPane.add(lblRemoverDisciplina);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(119, 54, 202, 20);
		DisciplinaController controller = new DisciplinaController();
		comboBox.setModel(new JComboBox(controller.listar().toArray()).getModel());
		
		contentPane.add(comboBox);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DisciplinaController controller = new DisciplinaController();
				Disciplina disciplina = (Disciplina)comboBox.getSelectedItem();
				controller.remover(disciplina);
				comboBox.setModel(new JComboBox(controller.listar().toArray()).getModel());
				JOptionPane.showMessageDialog(null, "Disciplina excluida com sucesso");
			}
		});
		btnRemover.setBounds(176, 113, 89, 23);
		contentPane.add(btnRemover);
	}
}
