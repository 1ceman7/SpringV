package com.yize.www.springbootvue.dept.web;

import com.yize.www.springbootvue.dept.pojo.DeptModel;
import com.yize.www.springbootvue.dept.service.DeptService;
import com.yize.www.springbootvue.utils.LoggerUtils;
import com.yize.www.springbootvue.utils.PageModel;
import com.yize.www.springbootvue.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("dept")
@CrossOrigin //允许跨域
public class deptController {
    @Autowired
    private DeptService deptService;
    /**
     * 查询所有
     * @param pageModel
     * @param deptModel
     * @return
     */
    @RequestMapping("list")
    public PageModel getAll(PageModel pageModel, DeptModel deptModel){
        System.out.println("获取到起始页是："+pageModel.getPageNum());
        return deptService.findByPage(deptModel, pageModel);

    }

    @RequestMapping("delete")
    public Result dele(String id){
        Result result = new Result();
        Long empCount = deptService.findEmpCount(id);
        if (empCount == 0){
            deptService.dele(id);
            result.setMsg("删除成功");
        }else{
            result.setState(false);
            result.setMsg("删除失败，还有"+empCount+"名员工为调离");
        }
        return result;
    }

    /**
     * 查找单个部门信息
     * @param id
     * @return
     */
    @RequestMapping("findDept")
    public DeptModel findDept(String id){
        return deptService.findDept(id);
    }

    @RequestMapping("update")
    public Result update(@RequestBody DeptModel deptModel){
        Result result = new Result();
        try{
            deptService.update(deptModel);
            result.setMsg("修改成功");
        }catch (Exception e){
            LoggerUtils.logger.info("修改部门失败");
            result.setState(false);
            result.setMsg("修改失败了，请重试");
        }
        return result;
    }

    @RequestMapping("findAllDeptByEmp")
    public List<DeptModel> findAllDeptByEmp(){
        List deptByEmp = deptService.findAllDeptByEmp();
        /*deptByEmp.forEach(dep->{
            System.out.println(dep);
        });*/
        return deptByEmp;
    }

}
