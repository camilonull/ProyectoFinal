package controllers;

import javax.swing.*;


import models.PersonModel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class PersonController {

	private ArrayList<PersonModel> persons;
	private final String path;
	
    public PersonController() {
    	path = "person.ser";
        this.persons = new ArrayList<>();
        persons.add(new PersonModel("Pepito", "Sanchez", "CC", "1354654", 25, 5, 2000));
        persons.add(new PersonModel("Maria", "Sanchez", "CE", "15165", 5, 12, 2002));
    }
    
    public void addPerson(PersonModel personModel) {
    	persons.add(personModel);
    }

    public void delete(PersonModel personModel) {
        persons.removeIf(personModel1 -> personModel1.getFirstName().equalsIgnoreCase(personModel.getFirstName()));
    }

    public ArrayList<PersonModel> getPersons() {
        return persons;
    }

    public int getYears(int year, int month, int day) {
        
        GregorianCalendar calendar1 = new GregorianCalendar(year, month, day);
        GregorianCalendar calendar2 = new GregorianCalendar();

        int diffYear = calendar2.get(Calendar.YEAR) - calendar1.get(Calendar.YEAR);

        Period periodo = Period.between(convertToLocalDate(calendar1), convertToLocalDate(calendar2));
        return periodo.getYears();
    }

	private LocalDate convertToLocalDate(GregorianCalendar dateToConvert) {
        return dateToConvert.toZonedDateTime().toLocalDate();
    }
	
	public boolean verifyText(String entry) {
    	String entryM = entry.toUpperCase();
    	boolean result = true;
    	char letter;
    	for (int i = 0; i < entry.length(); i++) {
			letter = entryM.charAt(i);
			if(letter < 'A' || letter > 'Z') {
				System.out.print(letter);
				result = false;
			}
		}
    	
    	return result;
    }
	
	 public void save(PersonController personController) throws IOException {
	        FileOutputStream file= new FileOutputStream(path);
	        ObjectOutputStream output = new ObjectOutputStream(file);
	        output.writeObject(personController);
	        output.close();
	        file.close();
	    }

	    public PersonController read() throws IOException, ClassNotFoundException {
	        FileInputStream file= new FileInputStream(path);
	        ObjectInputStream input = new ObjectInputStream(file);
	        PersonController personController = (PersonController) input.readObject();
	        input.close();
	        file.close();
	        return personController;
	    }

}
