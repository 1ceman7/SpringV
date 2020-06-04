package com.yize.www.springbootvue.dept;

import com.yize.www.springbootvue.SpringbootVueApplication;
import com.yize.www.springbootvue.dept.pojo.DeptModel;
import com.yize.www.springbootvue.dept.service.DeptService;
import com.yize.www.springbootvue.utils.PageModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SpringBootTest(classes = SpringbootVueApplication.class)
@RunWith(SpringRunner.class)
public class TestDeptService {
    @Autowired
    private DeptService deptService;
    @Test
    public void testUpdate() {
        DeptModel deptModel = new DeptModel();
        deptModel.setName("上");
        deptModel.setTel("8888");
        deptModel.setId("1");
        deptService.update(deptModel);


    }

    @Test
    public void testFindByPage(){
        PageModel pageModel = new PageModel();
        DeptModel deptModel = new DeptModel();
        pageModel.setStart(0);
        pageModel.setPageCount(5);
        //deptModel.setTel("6");
        PageModel byPage = deptService.findByPage(deptModel, pageModel);
        System.out.println("byPage="+byPage.getRows());

    }

    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Test
    public void testLog() {
        System.out.println((" ................."));
        logger.info("用户为绑定就开始缴费");
        logger.error("!!!!");
        /*logger.debug("!!!!");*/
    }

}
