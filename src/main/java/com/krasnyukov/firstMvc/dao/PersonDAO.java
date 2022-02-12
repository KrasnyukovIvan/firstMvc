package com.krasnyukov.firstMvc.dao;

import com.krasnyukov.firstMvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 23, "text@mail.eu"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 17, "google@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mary", 89, "mail@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "John", 31, "ru@gmail.ru"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id){
        people.removeIf(person -> person.getId() == id);
    }
}
