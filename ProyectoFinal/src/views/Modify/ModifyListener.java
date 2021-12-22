package views.Modify;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.PersonController;
import models.PersonModel;
import views.register.JFrameRegister;

public class ModifyListener implements ActionListener{
	
    private PersonController personController;
    private JFrameModify jFrameModify;

    public ModifyListener(JFrameModify jFrameModify, PersonController personController) {
        this.jFrameModify = jFrameModify;
        this.personController = personController;
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	int count = 0;
    	if(e.getSource() == jFrameModify.getjButtonUpdate()) {
    		String entry = jFrameModify.getjTextFieldName().getText();
    		boolean verify = personController.verifyText(entry);
    		if(entry.equals("")) {
    			jFrameModify.showjPaneError("Por favor llenar el espacio solicitado(Nombres)");
    		}else {
    			if(verify == false) {
    				jFrameModify.showjPaneError("Por favor, no ingresar numeros en el nombre");
    			}else {
    				count++;
    			}
			}
    		String entryLast = jFrameModify.getjTextFieldLastName().getText();
    		boolean verifyLast = personController.verifyText(entry);
    		if(entry.equals("")) {
    			jFrameModify.showjPaneError("Por favor llenar el espacio solicitado(Apellidos)");
    		}else {
    			if(verify == false) {
    				jFrameModify.showjPaneError("Por favor, no ingresar numeros en el nombre");
    			}else {
    				count++;
    			}
			}
    		try {
    			int num = Integer.parseInt(jFrameModify.getjTextFieldNumberDocument().getText());
    			count++;
			} catch (NumberFormatException numberFormatException) {
				jFrameModify.showjPaneError("Por favor solo numeros(No Documento)");
			}
    	}
    	if(count == 3) {
    		PersonModel personModel = new PersonModel();
    		int day = (int) jFrameModify.getjComboBoxDay().getSelectedItem();
    		int month = (int) jFrameModify.getjComboBoxMonth().getSelectedItem();
    		int year = (int) jFrameModify.getjComboBoxYear().getSelectedItem();
    		personModel.setDayBirth(day);
    		personModel.setMonthBirth(month);
    		personModel.setYearBirth(year);
    		int age = personController.getYears(year, month-1, day);
    		if(age > 17) {
    			personModel.setFirstName(jFrameModify.getjTextFieldName().getText());
        		personModel.setLastName(jFrameModify.getjTextFieldLastName().getText());
        		personModel.setDocumnetType(jFrameModify.getjComboBoxTypeDocument().getSelectedItem().toString());
        		personModel.setDocumentNumber(jFrameModify.getjTextFieldNumberDocument().getText());
        		personController.addPerson(personModel);
        		jFrameModify.setVisible(false);
    		}else {
    			jFrameModify.showjPaneError("Tienes que ser mayor de edad");
    		}
    	}
    }
}
