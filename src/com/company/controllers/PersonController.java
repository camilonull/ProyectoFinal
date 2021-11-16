package com.company.controllers;

import com.company.models.Person;
import com.google.gson.Gson;

public class PersonController {
    public String personToJson(Person person) {
        Gson gson = new Gson();
        return gson.toJson(person);
    }

    public Person jsonToPerson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Person.class);
    }
}
