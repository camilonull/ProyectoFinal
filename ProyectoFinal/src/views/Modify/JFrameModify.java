package views.Modify;

import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.PersonController;
import models.PersonModel;
import views.register.RegisterListener;

public class JFrameModify extends JFrame {
	
	private PersonController personController;
	private PersonModel personModel;
	private ModifyListener modifyListener;
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
    private JTextField jTextFieldNumberDocument;
    private JButton jButtonUpdate;
    private JButton jButtonDelete;
    private JButton jButtonExit;
    private JComboBox jComboBoxYear;
    private JComboBox jComboBoxMonth;
    private JComboBox jComboBoxDay;
    private JComboBox jComboBoxTypeDocument;
    private JOptionPane jPaneMessage;
	
	
	public JFrameModify(PersonModel personModel,PersonController personController) throws HeadlessException {
		this.personController = personController;
		this.personModel = personModel;
        modifyListener = new ModifyListener(this, this.personController);
        setLayout(null);
        this.setBounds(0, 0, 650, 360);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        init();
    }
	
	private void init() {
		this.setTitle("Informacion");
			jLabelName = new JLabel();
	        jLabelName.setBounds(30, 20, 60, 30);
	        jLabelName.setText("Nombres");
	        this.add(jLabelName);
	        
	        jLabelLastName = new JLabel();
	        jLabelLastName.setBounds(30, 60, 60, 30);
	        jLabelLastName.setText("Apellidos");
	        this.add(jLabelLastName);
	        
	        jLabelTypeDocument = new JLabel();
	        jLabelTypeDocument.setBounds(30, 100, 120, 30);
	        jLabelTypeDocument.setText("Tipo de documento");
	        this.add(jLabelTypeDocument);
	        
	        jLabelNumberDocument = new JLabel();
	        jLabelNumberDocument.setBounds(30, 140, 130, 30);
	        jLabelNumberDocument.setText("Numero de documento");
	        this.add(jLabelNumberDocument);
	        
	        jLabelDateBirth = new JLabel();
	        jLabelDateBirth.setBounds(30, 180, 130, 30);
	        jLabelDateBirth.setText("Fecha de nacimiento");
	        this.add(jLabelDateBirth);
	        
	        jLabelYear = new JLabel();
	        jLabelYear.setBounds(170, 180, 30, 30);
	        jLabelYear.setText("Año");
	        this.add(jLabelYear);
	        
	        jLabelMonth = new JLabel();
	        jLabelMonth.setBounds(290, 180, 30, 30);
	        jLabelMonth.setText("Mes");
	        this.add(jLabelMonth);
	        
	        jLabelDay = new JLabel();
	        jLabelDay.setBounds(410, 180, 30, 30);
	        jLabelDay.setText("Dia");
	        this.add(jLabelDay);
	        
	        jTextFieldName = new JTextField();
	        jTextFieldName.setBounds(170, 20, 450, 30);
	        jTextFieldName.setText(personModel.getFirstName());
	        this.add(jTextFieldName);
	        
	        jTextFieldLastName = new JTextField();
	        jTextFieldLastName.setBounds(170, 60, 450, 30);
	        jTextFieldLastName.setText(personModel.getLastName());
	        this.add(jTextFieldLastName);
	        
	        jTextFieldNumberDocument = new JTextField();
	        jTextFieldNumberDocument.setBounds(170, 140, 450, 30);
	        jTextFieldNumberDocument.setText(personModel.getDocumentNumber());
	        this.add(jTextFieldNumberDocument);

	        jButtonExit = new JButton("Cerrar");
	        jButtonExit.setBounds(510, 260, 110, 40);
	        jButtonExit.addActionListener(modifyListener);
	        this.add(jButtonExit);
	        
	        jButtonUpdate = new JButton("Actualizar");
	        jButtonUpdate.setBounds(380, 260, 110, 40);
	        jButtonUpdate.addActionListener(modifyListener);
	        this.add(jButtonUpdate);

	        jButtonDelete = new JButton("Eliminar");
	        jButtonDelete.setBounds(250, 260, 110, 40);
	        jButtonDelete.addActionListener(modifyListener);
	        this.add(jButtonDelete);    
	        
	        jComboBoxTypeDocument = new JComboBox<Integer>();
	        jComboBoxTypeDocument.addItem("CC-Cedula De Ciudadania");
	        jComboBoxTypeDocument.addItem("CE-Cedula De Extranjeria");
	        jComboBoxTypeDocument.addItem("PA-Pasaporte");
	        String typeString = personModel.getDocumnetType();
	        if(typeString.equals("CC")) {
	        	jComboBoxTypeDocument.setSelectedItem("CC-Cedula De Ciudadania");
	        }else if(typeString.equals("CE")) {
	        	jComboBoxTypeDocument.setSelectedItem("CE-Cedula De Extranjeria");
	        }else {
	        	jComboBoxTypeDocument.setSelectedItem("PA-Pasaporte");
	        }
	        jComboBoxTypeDocument.setBounds(170, 100, 450, 30);
	        jComboBoxTypeDocument.addActionListener(modifyListener);
	        this.add(jComboBoxTypeDocument);
	        
	        
	        setJComboBox();
	    }
	    
		public void setJComboBox() {
			jComboBoxYear = new JComboBox<Integer>();
		    for (int i = 1871; i < 2022; i++) {
		    	jComboBoxYear.addItem(i);
			}   
		    jComboBoxYear.setBounds(200, 180, 80, 30);
		    jComboBoxYear.addActionListener(modifyListener);
		    jComboBoxYear.setSelectedItem(personModel.getYearBirth());
		    this.add(jComboBoxYear);
		    
		    jComboBoxMonth = new JComboBox<Integer>();
		    for (int i = 1; i < 13; i++) {
		    	jComboBoxMonth.addItem(i);
			}   
		    jComboBoxMonth.setBounds(320, 180, 80, 30);
		    jComboBoxMonth.addActionListener(modifyListener);
		    jComboBoxMonth.setSelectedItem(personModel.getMonthBirth());
		    this.add(jComboBoxMonth);
		    
		    jComboBoxDay = new JComboBox<Integer>();
		    for (int i = 1; i <= 31; i++) {
				jComboBoxDay.addItem(i); 		
			}
			jComboBoxDay.setBounds(440, 180, 80, 30);
		    jComboBoxDay.addActionListener(modifyListener);
		    jComboBoxDay.setSelectedItem(personModel.getDayBirth());
		    this.add(jComboBoxDay);
		}

		public JButton getjButtonUpdate() {
			return jButtonUpdate;
		}

		public void setjButtonUpdate(JButton jButtonUpdate) {
			this.jButtonUpdate = jButtonUpdate;
		}

		public JButton getjButtonDelete() {
			return jButtonDelete;
		}

		public void setjButtonDelete(JButton jButtonDelete) {
			this.jButtonDelete = jButtonDelete;
		}

		public JButton getjButtonExit() {
			return jButtonExit;
		}

		public void setjButtonExit(JButton jButtonExit) {
			this.jButtonExit = jButtonExit;
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

		public JTextField getjTextFieldNumberDocument() {
			return jTextFieldNumberDocument;
		}

		public void setjTextFieldNumberDocument(JTextField jTextFieldNumberDocument) {
			this.jTextFieldNumberDocument = jTextFieldNumberDocument;
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

		public JComboBox getjComboBoxTypeDocument() {
			return jComboBoxTypeDocument;
		}

		public void setjComboBoxTypeDocument(JComboBox jComboBoxTypeDocument) {
			this.jComboBoxTypeDocument = jComboBoxTypeDocument;
		}
		
		public void showjPaneError(String message) {
			jPaneMessage.showMessageDialog(null, message);
		}
}
