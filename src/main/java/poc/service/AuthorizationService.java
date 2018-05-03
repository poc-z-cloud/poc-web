package poc.service;

import java.util.List;

import poc.domain.model.AdminRole;
import poc.domain.model.AdminSystem;
import poc.domain.model.AdminUser;

public interface AuthorizationService {
	List<AdminRole> retrieveGrantedRolesByUserId(Long userId);
	List<AdminRole> retrieveAvailableRolesByUserId(Long userId);

	List<AdminRole> retrieveGrantedRolesBySystemId(Long systemId);
	List<AdminRole> retrieveAvailableRolesBySystemId(Long systemId);

	List<AdminUser> retrieveGrantedUsersByRoleId(Long roleId);
	List<AdminUser> retrieveAvailableRolesByRoleId(Long roleId);

	List<AdminSystem> retrieveGrantedSystemsByRoleId(Long roleId);
	List<AdminSystem> retrieveAvailableSystemsByRoleId(Long roleId);
	
	void updateUserRole(Long userId,List<Long> roleIds);
	void updateUserRole(List<Long> userIds,Long roleId);
	
	void updateSystemRole(Long systemId,List<Long> roleIds);
	void updateSystemRole(List<Long> systems, Long roleId);

	void updateUserRole(AdminUser user,List<AdminRole> roles);
	void updateUserRole(List<AdminUser> users, AdminRole role);
	
	void updateSystemRole(AdminSystem system,List<AdminRole> roles);
	void updateSystemRole(List<AdminSystem> systems, AdminRole role);
}
