package com.yize.www.springbootvue.dept.service;

import com.yize.www.springbootvue.dept.mapper.DeptModelMapper;
import com.yize.www.springbootvue.dept.pojo.DeptModel;
import com.yize.www.springbootvue.utils.PageModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptModelMapper deptModelMapper;

    @Override
    public PageModel findByPage(DeptModel deptModel, PageModel pageModel) {
        //获取总数
        Long count = deptModelMapper.findCount();
        System.out.println(count);
        pageModel.setPageTotal(count);
        //查询
        List<DeptModel> deptList = deptModelMapper.findByPage(deptModel, pageModel);
        deptList.forEach(dept -> System.out.println(dept));
        pageModel.setRows(deptList);
        return pageModel;
    }

    @Override
    public void dele(String id) {

            deptModelMapper.delete(id);
    }

    @Override
    public DeptModel findDept(String id) {
        DeptModel deptModel = deptModelMapper.findDept(id);
        return deptModel;
    }

    @Override
    public void update(DeptModel deptModel) {
        deptModelMapper.update(deptModel);
    }

    @Override
    public List<DeptModel> findAllDeptByEmp() {
        return deptModelMapper.findAllDeptByEmp();
    }

    @Override
    public Long findEmpCount(String id) {

        return deptModelMapper.findEmpCount(id);
    }
}
