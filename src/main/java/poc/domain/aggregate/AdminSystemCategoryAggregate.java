package poc.domain.aggregate;

import java.util.List;

import poc.domain.model.AdminSystem;
import poc.domain.model.AdminSystemCategory;

public class AdminSystemCategoryAggregate extends AdminSystemCategory {

	private List<AdminSystem> systems;

	public List<AdminSystem> getSystems() {
		return systems;
	}

	public void setSystems(List<AdminSystem> systems) {
		this.systems = systems;
	}
	
	
}
