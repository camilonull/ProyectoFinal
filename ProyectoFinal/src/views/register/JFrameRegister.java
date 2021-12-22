package views.register;

import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controllers.CentralController;
import controllers.PersonController;

public class JFrameRegister extends JFrame {
	
	private RegisterListener registerListener;
    private JLabel jLabelName;
    private JLabel jLabelLastName;
    private JLabel jLabelTypeDocument;
    private JLabel jLabelNumberDocument;
    private JLabel jLabelDateBirth;
    private JLabel jLabelYear;
    private JLabel jLabelMonth;
    private JLabel jLabelDay;    
    private JTextField jTextFieldName;
    private JTextField jTextFieldLastName;
    private JTextField jTextFieldNumeberDocument;
    private JButton jButtonSave;
    private JComboBox jComboBoxYear;
    private JComboBox jComboBoxMonth;
    private JComboBox jComboBoxDay;
    private JComboBox jComboBoxTypeDocument;
    private JOptionPane jPaneMessage;
    private PersonController personController;
 
	public JFrameRegister(PersonController personController) throws HeadlessException {
		this.personController = personController;
        registerListener = new RegisterListener(this, this.personController);
        setLayout(null);
        this.setBounds(0, 0, 650, 340);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        init();
    }

    private void init() {
    	this.setTitle("Registro");
    		  
        jLabelName = new JLabel();
        jLabelName.setBounds(30, 40, 60, 30);
        jLabelName.setText("Nombres");
        this.add(jLabelName);
        
        jLabelLastName = new JLabel();
        jLabelLastName.setBounds(30, 80, 60, 30);
        jLabelLastName.setText("Apellidos");
        this.add(jLabelLastName);
        
        jLabelTypeDocument = new JLabel();
        jLabelTypeDocument.setBounds(30, 120, 120, 30);
        jLabelTypeDocument.setText("Tipo de documento");
        this.add(jLabelTypeDocument);
        
        jLabelNumberDocument = new JLabel();
        jLabelNumberDocument.setBounds(30, 160, 130, 30);
        jLabelNumberDocument.setText("Numero de documento");
        this.add(jLabelNumberDocument);
        
        jLabelDateBirth = new JLabel();
        jLabelDateBirth.setBounds(30, 200, 130, 30);
        jLabelDateBirth.setText("Fecha de nacimiento");
        this.add(jLabelDateBirth);
        
        jLabelYear = new JLabel();
        jLabelYear.setBounds(170, 200, 30, 30);
        jLabelYear.setText("Año");
        this.add(jLabelYear);
        
        jLabelMonth = new JLabel();
        jLabelMonth.setBounds(290, 200, 30, 30);
        jLabelMonth.setText("Mes");
        this.add(jLabelMonth);
        
        jLabelDay = new JLabel();
        jLabelDay.setBounds(410, 200, 30, 30);
        jLabelDay.setText("Dia");
        this.add(jLabelDay);
        
        jTextFieldName = new JTextField();
        jTextFieldName.setBounds(170, 40, 450, 30);
        this.add(jTextFieldName);
        
        jTextFieldLastName = new JTextField();
        jTextFieldLastName.setBounds(170, 80, 450, 30);
        this.add(jTextFieldLastName);
        
        jTextFieldNumeberDocument = new JTextField();
        jTextFieldNumeberDocument.setBounds(170, 160, 450, 30);
        this.add(jTextFieldNumeberDocument);

        jButtonSave = new JButton("Guardar");
        jButtonSave.setBounds(510, 250, 110, 40);
        jButtonSave.addActionListener(registerListener);
        this.add(jButtonSave);
        
        jComboBoxTypeDocument = new JComboBox<Integer>();
        jComboBoxTypeDocument.addItem("CC-Cedula De Ciudadania");
        jComboBoxTypeDocument.addItem("CE-Cedula De Extranjeria");
        jComboBoxTypeDocument.addItem("PA-Pasaporte");
        jComboBoxTypeDocument.setBounds(170, 120, 450, 30);
        jComboBoxTypeDocument.addActionListener(registerListener);
        this.add(jComboBoxTypeDocument);
        
        
        setJComboBox();
    }
    
	public void setJComboBox() {
		jComboBoxYear = new JComboBox<Integer>();
	    for (int i = 1871; i < 2022; i++) {
	    	jComboBoxYear.addItem(i);
		}   
	    jComboBoxYear.setBounds(200, 200, 80, 30);
	    jComboBoxYear.addActionListener(registerListener);
	    jComboBoxYear.setSelectedItem(2000);
	    this.add(jComboBoxYear);
	    
	    jComboBoxMonth = new JComboBox<Integer>();
	    for (int i = 1; i < 13; i++) {
	    	jComboBoxMonth.addItem(i);
		}   
	    jComboBoxMonth.setBounds(320, 200, 80, 30);
	    jComboBoxMonth.addActionListener(registerListener);
	    jComboBoxMonth.setSelectedItem(3);
	    this.add(jComboBoxMonth);
	    
	    jComboBoxDay = new JComboBox<Integer>();
	    for (int i = 1; i <= 31; i++) {
			jComboBoxDay.addItem(i); 		
		}
		jComboBoxDay.setBounds(440, 200, 80, 30);
	    jComboBoxDay.addActionListener(registerListener);
	    jComboBoxDay.setSelectedItem(12);
	    this.add(jComboBoxDay);
	    
	}
	
	public JTextField getjTextFieldName() {
		return jTextFieldName;
	}

	public void setjTextFieldName(JTextField jTextFieldName) {
		this.jTextFieldName = jTextFieldName;
	}

	public JTextField getjTextFieldLastName() {
		return jTextFieldLastName;
	}

	public void setjTextFieldLastName(JTextField jTextFieldLastName) {
		this.jTextFieldLastName = jTextFieldLastName;
	}

	public JTextField getjTextFieldNumeberDocument() {
		return jTextFieldNumeberDocument;
	}

	public void setjTextFieldNumeberDocument(JTextField jTextFieldNumeberDocument) {
		this.jTextFieldNumeberDocument = jTextFieldNumeberDocument;
	}

	public JButton getjButtonSave() {
		return jButtonSave;
	}

	public void setjButtonSave(JButton jButtonSave) {
		this.jButtonSave = jButtonSave;
	}

	public JComboBox getjComboBoxYear() {
		return jComboBoxYear;
	}

	public void setjComboBoxYear(JComboBox jComboBoxYear) {
		this.jComboBoxYear = jComboBoxYear;
	}

	public JComboBox getjComboBoxMonth() {
		return jComboBoxMonth;
	}

	public void setjComboBoxMonth(JComboBox jComboBoxMonth) {
		this.jComboBoxMonth = jComboBoxMonth;
	}

	public JComboBox getjComboBoxDay() {
		return jComboBoxDay;
	}

	public void setjComboBoxDay(JComboBox jComboBoxDay) {
		this.jComboBoxDay = jComboBoxDay;
	}
	
	 public JOptionPane getjPaneError() {
		return jPaneMessage;
	}

	public void showjPaneError(String message) {
		jPaneMessage.showMessageDialog(null, message);
	}

	public JComboBox getjComboBoxTypeDocument() {
		return jComboBoxTypeDocument;
	}

	public void setjComboBoxTypeDocument(JComboBox jComboBoxTypeDocument) {
		this.jComboBoxTypeDocument = jComboBoxTypeDocument;
	}

}
