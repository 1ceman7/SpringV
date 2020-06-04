package com.yize.www.springbootvue.supplies.web;

import com.yize.www.springbootvue.supplies.service.SuppliesService;
import com.yize.www.springbootvue.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("sup")
public class SuppliesController {
    @Autowired
    private SuppliesService suppliesService;
    @RequestMapping("findByEmp")
    public PageModel findByEmp(String id,PageModel pageModel){
        suppliesService.findByEmp(id,pageModel);
        return pageModel;
    }
}
