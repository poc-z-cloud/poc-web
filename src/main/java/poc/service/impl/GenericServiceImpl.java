package poc.service.impl;

import java.io.Serializable;
import java.util.List;

import poc.domain.dao.BaseMapper;
import poc.service.GenericService;

public abstract class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {

	protected abstract BaseMapper<T,PK> getMapper();
	
	@Override
	public int deleteByPrimaryKey(PK id) {
		try {
			return getMapper().deleteByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int insert(T record) {
		try {
			return getMapper().insert(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int insertSelective(T record) {
		try {
			return getMapper().insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public T selectByPrimaryKey(PK id) {
		try {
			return getMapper().selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		try {
			return getMapper().updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateByPrimaryKey(T record) {
		try {
			return getMapper().updateByPrimaryKey(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<T> selectAll() {
		try {
			return getMapper().selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
