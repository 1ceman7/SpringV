package com.yize.www.springbootvue.supplies.service;

import com.yize.www.springbootvue.supplies.mapper.SuppliesModelMapper;
import com.yize.www.springbootvue.supplies.pojo.SuppliesModel;
import com.yize.www.springbootvue.utils.PageModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SuppliesServiceImpl implements SuppliesService{
    @Resource
    private SuppliesModelMapper suppliesModelMapper;


    @Override
    public PageModel findByEmp(String id, PageModel pageModel) {
        Long countByEmp = suppliesModelMapper.findCountByEmp(id);
        pageModel.setPageTotal(countByEmp);
        List<SuppliesModel> byEmpList = suppliesModelMapper.findByEmp(id, pageModel);
        /*byEmpList.forEach(byE -> {
            System.out.println(byE);
        });*/
        pageModel.setRows(byEmpList);
        return pageModel;
    }
}
