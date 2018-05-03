package poc.domain.dao;

import java.util.List;

import poc.domain.model.AdminSystem;

public interface AdminSystemMapper extends BaseMapper<AdminSystem, Long> {

	List<AdminSystem> selectByCategoryId(Long categoryId);

	List<AdminSystem> retrieveGrantedSystemsByRoleId(Long roleId);

	List<AdminSystem> retrieveAvailableSystemsByRoleId(Long roleId);

}