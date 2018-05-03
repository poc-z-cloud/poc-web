package poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poc.domain.dao.AdminSystemMapper;
import poc.domain.dao.BaseMapper;
import poc.domain.model.AdminSystem;

@Service("adminSystemService")
@Transactional
public class AdminSystemServiceImpl extends GenericServiceImpl<AdminSystem, Long> {

	@Autowired
	private AdminSystemMapper adminSystemMapper;
	
	@Override
	protected BaseMapper<AdminSystem, Long> getMapper() {
		return adminSystemMapper;
	}

}
