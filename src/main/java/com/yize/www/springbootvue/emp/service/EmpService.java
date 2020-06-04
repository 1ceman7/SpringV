package com.yize.www.springbootvue.emp.service;

import com.yize.www.springbootvue.emp.pojo.EmpModel;
import com.yize.www.springbootvue.utils.PageModel;

import java.util.List;

public interface EmpService {
    PageModel getAllEmp(EmpModel empModel,PageModel pageModel);

    List findAllEmp();

    EmpModel findEmp(String id);

    void update(EmpModel empModel);

    void delete(String id);

    void save(EmpModel empModel);

    void deleteManyEmp(String[] ids);

}
