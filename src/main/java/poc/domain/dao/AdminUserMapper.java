package poc.domain.dao;

import java.util.List;

import poc.domain.model.AdminSystem;
import poc.domain.model.AdminUser;

public interface AdminUserMapper extends BaseMapper<AdminUser, Long>{

	List<AdminUser> retrieveGrantedUsersByRoleId(Long roleId);
	
	List<AdminUser> retrieveAvailableRolesByRoleId(Long roleId);
  
}