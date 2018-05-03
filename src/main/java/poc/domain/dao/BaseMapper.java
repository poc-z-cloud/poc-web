package poc.domain.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T, PK extends Serializable> {
	int deleteByPrimaryKey(PK id) throws Exception;

	int insert(T record) throws Exception;

	int insertSelective(T record) throws Exception;

	T selectByPrimaryKey(PK id) throws Exception;

	int updateByPrimaryKeySelective(T record) throws Exception;

	int updateByPrimaryKey(T record) throws Exception;
	
	List<T> selectAll();
}
