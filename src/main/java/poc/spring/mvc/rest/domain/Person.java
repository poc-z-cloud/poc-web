package poc.spring.mvc.rest.domain;

public class Person {

	private String name;
	private Integer age;
	private Integer id;
	
	public Person(){
		
	}
	
	public Person(Integer id, String name, Integer age){
		this.name=name;
		this.id=id;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}