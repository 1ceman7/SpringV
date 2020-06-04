package com.yize.www.springbootvue.supplies.mapper;

import com.yize.www.springbootvue.dept.pojo.DeptModel;
import com.yize.www.springbootvue.emp.pojo.EmpModel;
import com.yize.www.springbootvue.supplies.pojo.SuppliesModel;
import com.yize.www.springbootvue.utils.PageModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SuppliesModelMapper {
    /**
     * 根据员工id查询资产总数
     * @param id
     * @return
     */
    @Select("SELECT count(id) FROM supplies WHERE empId = #{id}")
    Long findCountByEmp(String id);

    /*========================================================================*/
    /**
     * 根据id查询员工(关联部门-findDeptByEmp)
     * @param id
     * @return
     */
    @Select("SELECT id,name,deptId FROM emp WHERE id = #{id}")
    @Results({
            @Result(property = "dm", column = "deptid",
                    one = @One(select = "com.yize.www.springbootvue.supplies.mapper.SuppliesModelMapper.findDeptByEmp")

            )
    })
    EmpModel findEmpById(String id);

    /**
     * 根据findEmpById查询出来的deptid去查询部门
     * @param empModel
     * @return
     */
    @Select("SELECT name FROM dept WHERE id = #{empModel.deptid}")
    DeptModel findDeptByEmp(EmpModel empModel);

    /*========================================================================*/

    /**
     * 根据员工id查询其所有资产关联员工信息以及所在部门并分页
     * @param id
     * @param pageModel
     * @return
     */
    @Select("SELECT id,name,merchants,model,money,buydate,killdate,empId FROM supplies WHERE empId = #{id} " +
            "LIMIT #{pageModel.start},#{pageModel.pageCount}")
    @Results({
            @Result(property = "em", column = "empId",
                    one = @One(select = "com.yize.www.springbootvue.supplies.mapper.SuppliesModelMapper.findEmpById")
            ),

    })
    List<SuppliesModel> findByEmp(String id, PageModel pageModel);
}
