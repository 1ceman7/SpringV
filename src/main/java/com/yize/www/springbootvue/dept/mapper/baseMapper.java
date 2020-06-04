package com.yize.www.springbootvue.dept.mapper;
import com.yize.www.springbootvue.dept.pojo.DeptModel;
import com.yize.www.springbootvue.utils.PageModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface baseMapper<T,P,K> {
    List<T> getAll(T t);

    List<T> findByPage(@Param("t") T t, @Param("p") P p);

    T findDept(K k);

    void update (T t);

    void save (T t);

    void delete (K k);

    Long findCount ();

}
