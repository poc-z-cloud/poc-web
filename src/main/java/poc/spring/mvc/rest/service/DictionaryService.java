package poc.spring.mvc.rest.service;

import poc.spring.mvc.rest.domain.Entry;

public interface DictionaryService {
	Entry lookup(String word);
}
