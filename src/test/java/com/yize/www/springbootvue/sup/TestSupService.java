package com.yize.www.springbootvue.sup;

import com.yize.www.springbootvue.SpringbootVueApplication;
import com.yize.www.springbootvue.emp.pojo.EmpModel;
import com.yize.www.springbootvue.emp.service.EmpService;
import com.yize.www.springbootvue.supplies.service.SuppliesService;
import com.yize.www.springbootvue.utils.PageModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = SpringbootVueApplication.class)
@RunWith(SpringRunner.class)
public class TestSupService {
    @Autowired
    private SuppliesService suppliesService;

    @Test
    public void findByEmp(){
        String id ="1";
        PageModel pageModel = new PageModel();
        pageModel.setStart(0);
        pageModel.setPageCount(5);
        //deptModel.setTel("6");
        //empModel.setName("大");
        PageModel byEmp = suppliesService.findByEmp(id, pageModel);
        System.out.println("结束");

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
