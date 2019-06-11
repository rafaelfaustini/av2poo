package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DisciplinaController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarDisciplinaView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarDisciplinaView frame = new EditarDisciplinaView();
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
	public EditarDisciplinaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditarDisciplina = new JLabel("Editar Disciplina");
		lblEditarDisciplina.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarDisciplina.setBounds(10, 11, 403, 14);
		contentPane.add(lblEditarDisciplina);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(155, 36, 115, 20);
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        textField.setText(comboBox.getSelectedItem().toString());
		    }
		});
		contentPane.add(comboBox);
		DisciplinaController controller = new DisciplinaController();
		comboBox.setModel(new JComboBox(controller.listar().toArray()).getModel());
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex();
				DisciplinaController controller = new DisciplinaController();
				controller.editar(comboBox.getSelectedItem().toString(),textField.getText());
				atualizar(comboBox);
				comboBox.setSelectedIndex(index);
				JOptionPane.showMessageDialog(null, "Disciplina editada com sucesso");
			}
		});
		btnNewButton.setBounds(165, 106, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(155, 75, 115, 20);
		textField.setText(comboBox.getSelectedItem().toString());
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
