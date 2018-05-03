package poc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poc.domain.dao.AdminRoleMapper;
import poc.domain.dao.AdminSystemMapper;
import poc.domain.dao.AdminUserMapper;
import poc.domain.model.AdminRole;
import poc.domain.model.AdminSystem;
import poc.domain.model.AdminUser;
import poc.service.AuthorizationService;

@Service("authorizationService")
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {

	@Autowired
	AdminRoleMapper adminRoleMapper;
	
	@Autowired
	AdminUserMapper adminUserMapper;

	@Autowired
	AdminSystemMapper adminSystemMapper;

	@Override
	public List<AdminRole> retrieveGrantedRolesByUserId(Long userId) {
		return adminRoleMapper.retrieveGrantedRolesByUserId(userId);
	}

	@Override
	public List<AdminRole> retrieveAvailableRolesByUserId(Long userId) {
		return adminRoleMapper.retrieveAvailableRolesByUserId(userId);
	}

	@Override
	public List<AdminRole> retrieveGrantedRolesBySystemId(Long systemId) {
		return adminRoleMapper.retrieveGrantedRolesBySystemId(systemId);
	}

	@Override
	public List<AdminRole> retrieveAvailableRolesBySystemId(Long systemId) {
		return adminRoleMapper.retrieveAvailableRolesBySystemId(systemId);
	}

	@Override
	public List<AdminUser> retrieveGrantedUsersByRoleId(Long roleId) {
		return adminUserMapper.retrieveGrantedUsersByRoleId(roleId);
	}

	@Override
	public List<AdminUser> retrieveAvailableRolesByRoleId(Long roleId) {
		return adminUserMapper.retrieveAvailableRolesByRoleId(roleId);
	}

	@Override
	public List<AdminSystem> retrieveGrantedSystemsByRoleId(Long roleId) {
		return adminSystemMapper.retrieveGrantedSystemsByRoleId(roleId);
	}

	@Override
	public List<AdminSystem> retrieveAvailableSystemsByRoleId(Long roleId) {
		return adminSystemMapper.retrieveAvailableSystemsByRoleId(roleId);
	}

	@Override
	public void updateUserRole(Long userId, List<Long> roleIds) {
		adminRoleMapper.deleteRolesByUserId(userId);
		for(Long roleId:roleIds)
		{
			adminRoleMapper.insertUserRole(userId, roleId);
		}
	}

	@Override
	public void updateUserRole(List<Long> userIds, Long roleId) {
		adminRoleMapper.deleteUserByRoleId(roleId);
		for(Long userId:userIds)
		{
			adminRoleMapper.insertUserRole(userId, roleId);
		}

	}

	@Override
	public void updateSystemRole(Long systemId, List<Long> roleIds) {
		adminRoleMapper.deleteRolesBySystemId(systemId);
		for(Long roleId:roleIds)
		{
			adminRoleMapper.insertSystemRole(systemId, roleId);
		}

	}

	@Override
	public void updateSystemRole(List<Long> systemIds, Long roleId) {
		adminRoleMapper.deleteSystemByRoleId(roleId);
		for(Long systemId:systemIds)
		{
			adminRoleMapper.insertSystemRole(systemId, roleId);
		}

	}

	@Override
	public void updateUserRole(AdminUser user, List<AdminRole> roles) {
		List<Long> roleIds = new ArrayList<Long>();
		for(AdminRole role:roles)
		{
			roleIds.add(role.getId());
		}
		
		this.updateUserRole(user.getId(), roleIds);

	}

	@Override
	public void updateUserRole(List<AdminUser> users, AdminRole role) {
		List<Long> userIds = new ArrayList<Long>();
		for(AdminUser user:users)
		{
			userIds.add(user.getId());
		}
		
		this.updateUserRole(userIds, role.getId());
	}

	@Override
	public void updateSystemRole(AdminSystem system, List<AdminRole> roles) {
		List<Long> roleIds = new ArrayList<Long>();
		for(AdminRole role:roles)
		{
			roleIds.add(role.getId());
		}

		this.updateSystemRole(system.getId(), roleIds);
	}

	@Override
	public void updateSystemRole(List<AdminSystem> systems, AdminRole role) {
		List<Long> systemIds = new ArrayList<Long>();
		for(AdminSystem system:systems)
		{
			systemIds.add(system.getId());
		}
		
		this.updateSystemRole(systemIds, role.getId());

	}

}
