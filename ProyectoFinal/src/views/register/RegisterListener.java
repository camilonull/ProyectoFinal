package views.register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.CentralController;
import controllers.PersonController;
import models.PersonModel;
import views.principal.JFramePrincipal;

public class RegisterListener implements ActionListener {
	

	private JFrameRegister jFrameRegister;
    private PersonController personController;

    public RegisterListener(JFrameRegister jFrameRegister, PersonController personController) {
        this.jFrameRegister = jFrameRegister;
        this.personController = personController;
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	int count = 0;
    	if(e.getSource() == jFrameRegister.getjButtonSave()) {
    		String entry = jFrameRegister.getjTextFieldName().getText();
    		boolean verify = personController.verifyText(entry);
    		if(entry.equals("")) {
    			jFrameRegister.showjPaneError("Por favor llenar el espacio solicitado(Nombres)");
    		}else {
    			if(verify == false) {
    				jFrameRegister.showjPaneError("Por favor, no ingresar numeros en el nombre");
    			}else {
    				count++;
    			}
			}
    		String entryLast = jFrameRegister.getjTextFieldLastName().getText();
    		boolean verifyLast = personController.verifyText(entry);
    		if(entry.equals("")) {
    			jFrameRegister.showjPaneError("Por favor llenar el espacio solicitado(Apellidos)");
    		}else {
    			if(verify == false) {
    				jFrameRegister.showjPaneError("Por favor, no ingresar numeros en el nombre");
    			}else {
    				count++;
    			}
			}
    		try {
    			int num = Integer.parseInt(jFrameRegister.getjTextFieldNumeberDocument().getText());
    			count++;
			} catch (NumberFormatException numberFormatException) {
				jFrameRegister.showjPaneError("Por favor solo numeros(No Documento)");
			}
    	}
    	if(count == 3) {
    		PersonModel personModel = new PersonModel();
    		int day = (int) jFrameRegister.getjComboBoxDay().getSelectedItem();
    		int month = (int) jFrameRegister.getjComboBoxMonth().getSelectedItem();
    		int year = (int) jFrameRegister.getjComboBoxYear().getSelectedItem();
    		personModel.setDayBirth(day);
    		personModel.setMonthBirth(month);
    		personModel.setYearBirth(year);
    		int age = personController.getYears(year, month-1, day);
    		if(age > 17) {
    			personModel.setFirstName(jFrameRegister.getjTextFieldName().getText());
        		personModel.setLastName(jFrameRegister.getjTextFieldLastName().getText());
        		personModel.setDocumnetType(jFrameRegister.getjComboBoxTypeDocument().getSelectedItem().toString());
        		personModel.setDocumentNumber(jFrameRegister.getjTextFieldNumeberDocument().getText());
        		personController.addPerson(personModel);
        		jFrameRegister.showjPaneError("Guardado con exito");
        		jFrameRegister.setVisible(false);
    		}else {
    			jFrameRegister.showjPaneError("Tienes que ser mayor de edad");
    		}
    	}
    }
}
