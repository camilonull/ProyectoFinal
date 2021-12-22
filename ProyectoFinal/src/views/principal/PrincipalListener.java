package views.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controllers.PersonController;
import models.PersonModel;
import views.Modify.JFrameModify;
import views.register.JFrameRegister;

public class PrincipalListener implements ActionListener, ListSelectionListener {
    private JFramePrincipal jFrameMain;
    private PersonController personController;
   
    public PrincipalListener(JFramePrincipal jFrameMain, PersonController personController) {
    	this.personController = personController;	
        this.jFrameMain = jFrameMain;
   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == jFrameMain.getjButtonSearch()) {
    		String entry = jFrameMain.getjTextField().getText();
    		boolean verify = personController.verifyText(entry);
    		if(verify == false) {
    			jFrameMain.getjPaneError().showMessageDialog(null, "Por favor, no ingresar numeros");
    		}else {
    			jFrameMain.getjPaneError().showMessageDialog(null, "sirvio pa");
			}
    		jFrameMain.getjTextField().setText("");
			
    	}
    	if(e.getSource() == jFrameMain.getjButtonRegister()) {
    		//jFrameMain.setVisible(false);
    		JFrameRegister jFrameRegister = new JFrameRegister(this.personController);
            jFrameRegister.setVisible(true);
    	}
    	
        
    }
    int count = 0;
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == jFrameMain.getjListPrincipal() && count < 1) {
			JFrameModify jFrameModify = new JFrameModify((PersonModel) jFrameMain.getjListPrincipal().getSelectedValue(), personController);
			jFrameModify.setVisible(true);
			System.out.println("hola");
			System.out.println(count);
			//count++;
		}
	}
}

