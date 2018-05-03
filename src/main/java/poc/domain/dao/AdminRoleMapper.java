package poc.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import poc.domain.model.AdminRole;

public interface AdminRoleMapper extends BaseMapper<AdminRole, Long>{

	List<AdminRole> retrieveGrantedRolesByUserId(Long userId);

	List<AdminRole> retrieveAvailableRolesByUserId(Long userId);

	List<AdminRole> retrieveGrantedRolesBySystemId(Long systemId);

	List<AdminRole> retrieveAvailableRolesBySystemId(Long systemId);
	
	void deleteRolesByUserId(Long userId);
	void deleteUserByRoleId(Long roleId);
	void deleteRolesBySystemId(Long systemId);
	void deleteSystemByRoleId(Long roleId);
	
	void insertUserRole(@Param("userId")Long userId,@Param("roleId")Long roleId);
	void insertSystemRole(@Param("systemId")Long systemId,@Param("roleId")Long roleId);

}