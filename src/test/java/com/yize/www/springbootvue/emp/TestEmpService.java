package com.yize.www.springbootvue.emp;

import com.yize.www.springbootvue.SpringbootVueApplication;
import com.yize.www.springbootvue.dept.pojo.DeptModel;
import com.yize.www.springbootvue.dept.service.DeptService;
import com.yize.www.springbootvue.emp.pojo.EmpModel;
import com.yize.www.springbootvue.emp.service.EmpService;
import com.yize.www.springbootvue.utils.PageModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest(classes = SpringbootVueApplication.class)
@RunWith(SpringRunner.class)
public class TestEmpService {
    @Autowired
    private EmpService empService;
    @Test
    public void testUpdate() throws ParseException {
        EmpModel empModel = new EmpModel();

        empModel.setName("QQQQ");
        empModel.setDeptid(2);
        empModel.setEmail("123@qq.com");
        empModel.setGender(2);
        String str = "1999-11-02";
        SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
        Date date=format.parse(str);
        empModel.setIntime(date);
        empModel.setOuttime(date);
        empModel.setTel("123123123");
        empService.save(empModel);
        System.out.println("修改成功");


    }

/*    @Test
    public void testFindByPage(){
        PageModel pageModel = new PageModel();
        DeptModel deptModel = new DeptModel();
        pageModel.setStart(0);
        pageModel.setPageCount(5);
        //deptModel.setTel("6");
        PageModel byPage = deptService.findByPage(deptModel, pageModel);
        System.out.println("byPage="+byPage.getRows());

    }*/

    @Test
    public void testFindByCount(){
        PageModel pageModel = new PageModel();
        EmpModel empModel = new EmpModel();
        pageModel.setStart(0);
        pageModel.setPageCount(5);
        //deptModel.setTel("6");
        //empModel.setName("大");
        PageModel allEmp = empService.getAllEmp(empModel, pageModel);
        System.out.println("总数="+allEmp.getPageTotal());

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
