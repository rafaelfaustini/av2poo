package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDe = new JLabel("Trabalho Programa\u00E7\u00E3o Orientada a Objetos");
		lblCadastroDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDe.setBounds(41, 11, 342, 14);
		contentPane.add(lblCadastroDe);
		
		JButton btnDisciplinas = new JButton("Disciplinas");
		btnDisciplinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DisciplinaView disciplina = new DisciplinaView();
				disciplina.setVisible(true);
			}
		});
		btnDisciplinas.setBounds(152, 69, 140, 23);
		contentPane.add(btnDisciplinas);
		
		JButton btnNewButton = new JButton("Professores");
		btnNewButton.setBounds(152, 103, 140, 23);
		contentPane.add(btnNewButton);
	}
}
