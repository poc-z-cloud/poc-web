package poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poc.domain.dao.AdminRoleMapper;
import poc.domain.dao.BaseMapper;
import poc.domain.model.AdminRole;

@Service("adminRoleService")
@Transactional
public class AdminRoleServiceImpl extends GenericServiceImpl<AdminRole, Long> {

	@Autowired
	private AdminRoleMapper adminRoleMapper;
	
	@Override
	protected BaseMapper<AdminRole, Long> getMapper() {
		return adminRoleMapper;
	}

}
