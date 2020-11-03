package repositories;

import domains.Person;

public class PersonRepository extends BaseRepositoryDAO<Person, Long> {
    private static PersonRepository personRepository;

    private PersonRepository() {
    }

    public static PersonRepository getInstance() {
        if (personRepository == null) {
            personRepository = new PersonRepository();
        }
        return personRepository;
    }

    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }
}
