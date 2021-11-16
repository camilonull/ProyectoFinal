package com.company;

import com.company.controllers.PersonController;
import com.company.models.Person;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Digite una opción:");
        System.out.println("1. Json a Persona");
        System.out.println("2. Persona a Json");
        System.out.print("Opción: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        PersonController personController = new PersonController();
        switch (option) {
            case 1:
                Person p = personController.jsonToPerson("{\"firstname\":\"William\",\"lastname\":\"Vega\"}");
                System.out.println(p);
                break;
            case 2:
                Person person = new Person("William", "Vega");
                System.out.println(personController.personToJson(person));
                break;
            default:
                System.out.println("Opción no valida");
        }
    }
}
