package com.yize.www.springbootvue.emp.service;

import com.yize.www.springbootvue.emp.mapper.EmpModelMapper;
import com.yize.www.springbootvue.emp.pojo.EmpModel;
import com.yize.www.springbootvue.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpModelMapper empModelMapper;
    @Override
    public PageModel getAllEmp( EmpModel empModel,PageModel pageModel) {
        Long count = empModelMapper.findCount();
        pageModel.setPageTotal(count);
        //empModel.setDeptid(2);
        //DeptModel dept = empModelMapper.findDeptNameById(empModel.getDeptid());
        List<EmpModel> allEmp = empModelMapper.findAllEmp(empModel, pageModel);
        allEmp.forEach(allE ->{
            System.out.println(allE);

        });
        pageModel.setRows(allEmp);
        return pageModel;
    }

    /* 为 物资模块 查询所有用户名字*/
    @Override
    public List<EmpModel> findAllEmp() {
        List<EmpModel> allEmpBySup = empModelMapper.findAllEmpBySup();
        return allEmpBySup;
    }

    /*查询单一用户*/
    @Override
    public EmpModel findEmp(String id) {
        return empModelMapper.findEmp(id);
    }

    @Override
    public void update(EmpModel empModel) {
        empModelMapper.update(empModel);
    }

    @Override
    public void delete(String id) {
        empModelMapper.delete(id);
    }

    @Override
    public void save(EmpModel empModel) {
        System.out.println(empModel);
        empModelMapper.save(empModel);
    }

    @Override
    public void deleteManyEmp(String[] ids) {
        empModelMapper.deleteManyEmp(ids);
    }
}
