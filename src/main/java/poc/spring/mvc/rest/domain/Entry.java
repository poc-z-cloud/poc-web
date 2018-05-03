package poc.spring.mvc.rest.domain;

import java.util.List;

public class Entry {
	private Long id;
	private String word;
	private String explanation;
	private List<Example> samples;
	private String mediaPath;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public List<Example> getSamples() {
		return samples;
	}
	public void setSamples(List<Example> samples) {
		this.samples = samples;
	}
	public String getMediaPath() {
		return mediaPath;
	}
	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}
	
	
}
