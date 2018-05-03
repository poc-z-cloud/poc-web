package poc.domain.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class BaseModel implements Serializable{
	
    private Long id;

    
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}


}
