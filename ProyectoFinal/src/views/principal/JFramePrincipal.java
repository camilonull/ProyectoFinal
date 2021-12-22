package views.principal;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionListener;

import controllers.PersonController;
import models.PersonModel;

public class JFramePrincipal extends JFrame{

    private PrincipalListener mainListener;
    private JTextField jTextField;
    private JButton jButtonSearch;
    private JButton jButtonRegister;
    private JLabel jLabelTitle;
    private JLabel jLabelRegister;
    private JOptionPane jPaneError;
    private JList jListPrincipal;
    private JScrollPane jScrollPanePrincipal;
    private PersonController personController;
    

	public JFramePrincipal() throws HeadlessException {
		personController = new PersonController();
        mainListener = new PrincipalListener(this, this.personController);
        setLayout(null);
        this.setBounds(0, 0, 620, 680);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        init();
    }

    private void init() {
    	this.setTitle("Camilo Andres Vargas Rojas-202022580");
    		  
        jLabelTitle = new JLabel();
        jLabelTitle.setBounds(270, 50, 105, 30);
        jLabelTitle.setText("MyRegister");
        this.add(jLabelTitle);
        
        jLabelRegister = new JLabel();
        jLabelRegister.setBounds(270, 140, 60, 30);
        jLabelRegister.setText("Registro");
        this.add(jLabelRegister);
        
        jTextField = new JTextField();
        jTextField.setBounds(20, 110, 470, 30);
        this.add(jTextField);

        jButtonSearch = new JButton("Buscar");
        jButtonSearch.setBounds(510, 110, 90, 30);
        jButtonSearch.addActionListener(mainListener);     
        this.add(jButtonSearch);
        
        jButtonRegister = new JButton("Registrar");
        jButtonRegister.setBounds(510, 585, 90, 30);
        jButtonRegister.addActionListener(mainListener);
        this.add(jButtonRegister);
        
        jListPrincipal = new JList();
        DefaultListModel listModel = new DefaultListModel();
        personController.getPersons().forEach(personModel -> listModel.addElement(personModel));
        jListPrincipal.setModel(listModel);
        jListPrincipal.addListSelectionListener(mainListener);
        jScrollPanePrincipal = new JScrollPane();
        jScrollPanePrincipal.setBounds(20, 170, 580, 380);
        jScrollPanePrincipal.setViewportView(jListPrincipal);
        this.add(jScrollPanePrincipal);
    }

	
	public JList getjListPrincipal() {
		return jListPrincipal;
	}

	public void setjListPrincipal(JList jListPrincipal) {
		this.jListPrincipal = jListPrincipal;
	}

	public JTextField getjTextField() {
		return jTextField;
	}

	public void setjTextField(JTextField jTextField) {
		this.jTextField = jTextField;
	}

	public JButton getjButtonSearch() {
		return jButtonSearch;
	}

	public void setjButtonSearch(JButton jButtonSearch) {
		this.jButtonSearch = jButtonSearch;
	}

	public JLabel getjLabelTitle() {
		return jLabelTitle;
	}

	public void setjLabelTitle(JLabel jLabelTitle) {
		this.jLabelTitle = jLabelTitle;
	}

	public JButton getjButtonRegister() {
		return jButtonRegister;
	}

	public void setjButtonRegister(JButton jButtonRegister) {
		this.jButtonRegister = jButtonRegister;
	}
	
	 public JOptionPane getjPaneError() {
		return jPaneError;
	}

	public void setjPaneError(JOptionPane jPaneError) {
		this.jPaneError = jPaneError;
	}
}