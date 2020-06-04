package com.yize.www.springbootvue.dept.service;

import com.yize.www.springbootvue.dept.pojo.DeptModel;
import com.yize.www.springbootvue.utils.PageModel;

import java.util.List;

public interface DeptService {

    PageModel findByPage(DeptModel deptModel,PageModel pageModel);

    void dele(String id);

    DeptModel findDept(String id);

    void update(DeptModel deptModel);

    List<DeptModel> findAllDeptByEmp();

    Long findEmpCount(String id);
}
