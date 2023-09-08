package com.example.pract2.dao;

import com.example.pract2.dao.GenericDAO;
import com.example.pract2.model.PersonModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDAO implements GenericDAO<PersonModel> {
    private final List<PersonModel> people = new ArrayList<>();
    private int idCounter = 1;

    public PersonDAO() {
        // Добавим 5 человек при инициализации DAO
        create(new PersonModel("Иван", 25, "ivan@example.com"));
        create(new PersonModel("Мария", 30, "maria@example.com"));
        create(new PersonModel("Петр", 22, "petr@example.com"));
        create(new PersonModel("Анна", 28, "anna@example.com"));
        create(new PersonModel("Сергей", 35, "sergey@example.com"));
    }

    @Override
    public List<PersonModel> getAll() {
        return people;
    }

    @Override
    public PersonModel getById(int id) {
        return people.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void create(PersonModel person) {
        person.setId(idCounter++);
        people.add(person);
    }

    @Override
    public void update(int id, PersonModel updatedPerson) {
        PersonModel existingPerson = getById(id);
        if (existingPerson != null) {
            existingPerson.setName(updatedPerson.getName());
            existingPerson.setAge(updatedPerson.getAge());
            existingPerson.setEmail(updatedPerson.getEmail());
        }
    }

    @Override
    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
