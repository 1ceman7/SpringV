package com.yize.www.springbootvue.supplies.service;

import com.yize.www.springbootvue.utils.PageModel;

public interface SuppliesService {
    PageModel findByEmp(String id, PageModel pageModel);
}
