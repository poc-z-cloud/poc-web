package poc.spring.mvc.rest.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poc.spring.mvc.rest.domain.DictionaryDAO;
import poc.spring.mvc.rest.domain.Entry;
import poc.spring.mvc.rest.domain.Example;
import poc.spring.mvc.rest.service.DictionaryService;

@Service("dictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired private DictionaryDAO dictionaryDAO;
	
	private static Map<String,Entry> entryMap = new HashMap<String,Entry>();
	static{
		populateDummyMap();
	}
	
	@Override
	public Entry lookup(String word) {
		//return entryMap.get(word);
		return dictionaryDAO.lookup(word);
	}

	private static void populateDummyMap() {
		List<Example> samples = new ArrayList<Example>();
		
		Example sample = new Example();
		sample.setId(1l);
		sample.setSentence("That's good news");
		sample.setMediaPath("mp3/sentences/goodNews.mp3");
		
		samples.add(sample);
		
		sample = new Example();
		sample.setId(2l);
		sample.setSentence("Good quality clothes");
		sample.setMediaPath("mp3/sentences/goodCloth.mp3");
		
		samples.add(sample);
		
		Entry entry = new Entry();
		entry.setId(1l);
		entry.setWord("good");
		entry.setMediaPath("mp3/vocabulary/good.mp3");
		entry.setExplanation("adjective, better, best.\n"
				+ "1. morally excellent; virtuous; righteous; pious:\n"
				+ "a good man."
				+ "2. satisfactory in quality, quantity, or degree:\n"
				+ "a good teacher; good health.\n"
				+ "3. of high quality; excellent."
				+ "4. right; proper; fit:"
				+ "It is good that you are here. His credentials are good."
				+ "5. well-behaved:"
				+ "a good child."
				+ "");
		entry.setSamples(samples);

		entryMap.put(entry.getWord(), entry);
		
		
	}

}
