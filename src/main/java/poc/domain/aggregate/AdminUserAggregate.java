package poc.domain.aggregate;

import java.util.List;

import poc.domain.model.AdminUser;

public class AdminUserAggregate extends AdminUser {
	private static final long serialVersionUID = 5511736265437996002L;

	private List<AdminSystemCategoryAggregate> grantedSystemCategories;

	public List<AdminSystemCategoryAggregate> getGrantedSystemCategories() {
		return grantedSystemCategories;
	}

	public void setGrantedSystemCategories(
			List<AdminSystemCategoryAggregate> grantedSystemCategories) {
		this.grantedSystemCategories = grantedSystemCategories;
	}
	
}
