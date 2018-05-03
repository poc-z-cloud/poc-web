package poc.spring.mvc.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import poc.spring.mvc.rest.domain.Entry;
import poc.spring.mvc.rest.service.DictionaryService;

@RestController
@RequestMapping("rest")
public class DictionaryController {
	
	@Autowired DictionaryService dictionaryService;

	@RequestMapping(value = "dictionary/{word}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Entry> getEntry(@PathVariable("word") String word) {
		System.out.println("Fetching Entry with word " + word);
		Entry entry = dictionaryService.lookup(word);
		if (entry == null) {
			System.out.println("Entry with word " + word + " not found");
			return new ResponseEntity<Entry>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Entry>(entry, HttpStatus.OK);
	}

}
