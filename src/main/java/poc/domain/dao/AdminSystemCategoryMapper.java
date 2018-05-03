package poc.domain.dao;

import java.util.List;

import poc.domain.aggregate.AdminSystemCategoryAggregate;
import poc.domain.model.AdminSystemCategory;

public interface AdminSystemCategoryMapper extends BaseMapper<AdminSystemCategory, Long>{
    List<AdminSystemCategoryAggregate> selectAllWithSystems();
}