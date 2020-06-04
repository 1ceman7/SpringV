package com.yize.www.springbootvue.dept.mapper;

import com.yize.www.springbootvue.dept.pojo.DeptModel;
import com.yize.www.springbootvue.utils.PageModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
//@Repository
public interface DeptModelMapper extends baseMapper<DeptModel,PageModel,String > {

    @Select("SELECT id,name FROM dept")
    List<DeptModel> findAllDeptByEmp();

    @Select("SELECT count(id) FROM emp WHERE deptId=#{id}")
    Long findEmpCount(String id);
}

