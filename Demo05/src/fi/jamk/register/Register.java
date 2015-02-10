/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.jamk.register;

import java.util.ArrayList;

/**
 *
 * @author h3090
 */
public class Register {
    
    private final ArrayList<Person> people;
    
    public Register() {
        this.people = new ArrayList<>();
    }
    
    public int getPeopleCount() {
        return this.people.size();
    }
    public boolean addPerson(Person person) {
        return this.people.add(person);
    }
    
    public Person getPerson(int index) {
        if(index < getPeopleCount()) {
            return this.people.get(index);
        }
        else return null;
    }
    public Person findPerson(String ssn) {
        for (Person person : this.people) {
            if (ssn.equalsIgnoreCase(person.getSsn())) {
                return person;
            }
        }
        return null;
    }
    
}
