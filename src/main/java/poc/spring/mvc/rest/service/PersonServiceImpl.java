package poc.spring.mvc.rest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import poc.spring.mvc.rest.domain.Person;


@Service
public class PersonServiceImpl implements PersonService {

	private static Map<Integer,Person> peopleMap= new HashMap<Integer,Person>();
	
	static{
		Person person = new Person();
		person.setAge(1);
		person.setName("Nikolaus Otto");
	}
	
	String[] names = {"Nikolaus Otto", "Robert Ford", "Gottlieb Daimler", "Lt. General Masaharu Homma"};

	@Override
	public Person getRandom() {
		Person person = new Person();
		person.setName(randomName());
		person.setAge(randomAge());
		return person;
	}

	@Override
	public Person getById(Long id) {
		Person person = new Person();
		person.setName(names[id.intValue()]);
		person.setAge(50);
		return person;
	}
	
	@Override
	public void save(Person person) {
		// Save person to database ...
	}
	
	
	@Override
	public List<Person> getPersonList() {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer randomAge() {
		Random random = new Random();
		return 10 + random.nextInt(100);
	}

	private String randomName() {
		Random random = new Random();
		return names[random.nextInt(names.length)];
	}

}