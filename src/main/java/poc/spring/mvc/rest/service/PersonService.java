package poc.spring.mvc.rest.service;

import java.util.List;

import poc.spring.mvc.rest.domain.Person;

public interface PersonService {
	public Person getRandom();
	public Person getById(Long id);
	public List<Person> getPersonList();
	public void save(Person person);
}