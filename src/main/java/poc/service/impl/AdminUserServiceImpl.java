package poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poc.domain.dao.AdminUserMapper;
import poc.domain.dao.BaseMapper;
import poc.domain.model.AdminUser;

@Service("adminUserService")
@Transactional
public class AdminUserServiceImpl extends GenericServiceImpl<AdminUser, Long> {

	@Autowired
	private AdminUserMapper adminUserMapper;
	
	@Override
	protected BaseMapper<AdminUser, Long> getMapper() {
		return adminUserMapper;
	}

}
