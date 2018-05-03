package poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poc.domain.dao.AdminSystemCategoryMapper;
import poc.domain.dao.BaseMapper;
import poc.domain.model.AdminSystemCategory;

@Service("adminSystemCategoryService")
@Transactional
public class AdminSystemCategoryServiceImpl extends GenericServiceImpl<AdminSystemCategory, Long> {

	@Autowired
	private AdminSystemCategoryMapper adminSystemCategoryMapper;
	
	@Override
	protected BaseMapper<AdminSystemCategory, Long> getMapper() {
		return adminSystemCategoryMapper;
	}

}
