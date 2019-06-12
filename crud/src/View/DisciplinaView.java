package View;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisciplinaView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisciplinaView frame = new DisciplinaView();
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
	public DisciplinaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarDisciplinaView criardisciplina = new CriarDisciplinaView();
				criardisciplina.setVisible(true);
			}
		});
		btnCriar.setBounds(176, 71, 89, 23);
		contentPane.add(btnCriar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarDisciplinaView n = new EditarDisciplinaView();
				n.setVisible(true);
			}
		});
		btnEditar.setBounds(176, 105, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoverDisciplinaView n = new RemoverDisciplinaView();
				n.setVisible(true);
			}
		});
		btnRemover.setBounds(176, 139, 89, 23);
		contentPane.add(btnRemover);
		
		JLabel lblDiscplina = new JLabel("Discplina");
		lblDiscplina.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscplina.setBounds(40, 11, 345, 14);
		contentPane.add(lblDiscplina);
	}
}
