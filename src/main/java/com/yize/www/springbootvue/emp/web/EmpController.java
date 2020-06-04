package com.yize.www.springbootvue.emp.web;

import com.yize.www.springbootvue.dept.web.deptController;
import com.yize.www.springbootvue.emp.pojo.EmpModel;
import com.yize.www.springbootvue.emp.service.EmpService;
import com.yize.www.springbootvue.utils.LoggerUtils;
import com.yize.www.springbootvue.utils.PageModel;
import com.yize.www.springbootvue.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("emp")
@CrossOrigin
public class EmpController {
    @Autowired
    private EmpService empService;


    @RequestMapping("list")
    public PageModel list(PageModel pageModel, EmpModel empModel) {
        PageModel allEmp = empService.getAllEmp(empModel, pageModel);
        return allEmp;
    }

    @RequestMapping("findAllEmp")
    public List findAllEmp() {
        List allEmp = empService.findAllEmp();
        /*allEmp.forEach(allE ->{
            System.out.println(allE);
        });*/
        //allEmp.forEach(System.out::println);
        return allEmp;
    }

    @RequestMapping("findEmp")
    public EmpModel findEmp(String id) {
        return empService.findEmp(id);
    }

    @RequestMapping("update")
    public Result update(@RequestBody EmpModel empModel) {
        Result result = new Result();
        if (empModel.getId() != null) {
            try {
                empService.update(empModel);
                result.setMsg("修改成功");
            } catch (Exception e) {
                LoggerUtils.logger.info("修改用户失败");
                result.setState(false);
                result.setMsg("修改失败");
            }
        }else{
            try {
                empService.save(empModel);
                result.setMsg("增加成功");
            }catch (Exception e){
                LoggerUtils.logger.info("增加用户失败");
                result.setState(false);
                result.setMsg("增加失败");
            }
        }
        return result;
    }

    @RequestMapping("delete")
    public Result delete(String id) {
        Result result = new Result();
        try {
            empService.delete(id);
            result.setMsg("删除成功");
        } catch (Exception e) {
            result.setMsg("删除失败");
            result.setState(false);
        }
        /*for (int i:emp){
            System.out.println(i);
        };*/
        return result;
    }
    @RequestMapping("deleteManyEmp")
    public Result deleteManyEmp(@RequestBody String[] ids){
        Result result = new Result();
        /*for(int i=0;i<ids.length;i++){
            System.out.println(i);
        }*/
        try{
            empService.deleteManyEmp(ids);
            result.setMsg("批量删除成功");
        }catch (Exception e){
            result.setMsg("批量删除失败");
            result.setState(false);
        }
        return result;
    }
    @RequestMapping("deleteEmp")
    public Result deleteEmp(@RequestBody String[] ids){
        Result result = new Result();
        /*for(int i=0;i<ids.length;i++){
            System.out.println(i);
        }*/
        try{
            empService.deleteManyEmp(ids);
            result.setMsg("批量删除成功");
        }catch (Exception e){
            result.setMsg("批量删除失败");
            result.setState(false);
        }
        return result;


}
