package services;

import domains.Person;
import repositories.PersonRepository;

import java.util.List;

public class PersonService {
    PersonRepository personRepository = PersonRepository.getInstance();

    public Person insertPerson(String firstName, String lastName, String phoneNumber) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhoneNumber(phoneNumber);
        return personRepository.save(person);
    }

    public List<Person> selectAllPerson() {
        return personRepository.selectAll();
    }

    public void removeAll() {
        personRepository.removeAll();
    }
}

