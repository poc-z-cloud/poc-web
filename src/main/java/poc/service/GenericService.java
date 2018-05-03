package poc.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService <T, PK extends Serializable>{
	int deleteByPrimaryKey(PK id);

	int insert(T record);

	int insertSelective(T record);

	T selectByPrimaryKey(PK id);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);

	List<T> selectAll();
}
