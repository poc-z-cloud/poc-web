package poc.spring.mvc.rest.domain;

public interface DictionaryDAO {
	Entry lookup(String word);
}
