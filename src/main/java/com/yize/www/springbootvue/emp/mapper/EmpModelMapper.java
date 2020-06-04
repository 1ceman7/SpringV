package com.yize.www.springbootvue.emp.mapper;

import com.yize.www.springbootvue.dept.pojo.DeptModel;
import com.yize.www.springbootvue.emp.pojo.EmpModel;
import com.yize.www.springbootvue.utils.PageModel;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface EmpModelMapper{
    /* 查询总数据 */
    @Select("select count(id) from emp")
    Long findCount ();
    /*=============================================================*/

    /* 根据地址id查询部门 */
    @Select("SELECT id,name FROM dept WHERE id = #{empModel.deptid}")
    DeptModel findDeptNameById(EmpModel empModel);

    /* 分页,模糊查询,一对一级联查询员工与部门*/
    @Select("<script>"+"SELECT * FROM emp where 1=1"
            +"<if test='empModel.name!=null'>and emp.name like concat('%',#{empModel.name},'%')</if>"
            +"limit #{pageModel.start},#{pageModel.pageCount}"
            +"</script>")
    @Results({
            @Result(property = "dm", column = "deptid",
                    one = @One(select = "com.yize.www.springbootvue.emp.mapper.EmpModelMapper.findDeptNameById")) })
    List<EmpModel> findAllEmp(@Param("empModel") EmpModel empModel,PageModel pageModel);
/*=============================================================*/

    @Select("SELECT id,name FROM emp")
    List<EmpModel> findAllEmpBySup();

    @Select("SELECT id,name,tel,gender,email,inTime,outTime,deptId " +
            "FROM emp " +
            "WHERE id = #{id}")
    EmpModel findEmp(String id);

    @Select("UPDATE emp SET " +
                    "name = #{empModel.name}," +
                    "tel = #{empModel.tel}," +
                    "gender = #{empModel.gender}," +
                    "email = #{empModel.email}," +
                    "inTime = #{empModel.intime}," +
                    "outTime = #{empModel.outtime}," +
                    "deptId = #{empModel.deptid} WHERE id = #{empModel.id}")
    void update(@Param("empModel") EmpModel empModel);

    @Select("DELETE FROM emp WHERE id = #{id}")
    void delete(String id);

    @Insert("INSERT INTO emp(name,tel,gender,email,inTime,outTime,deptId)" +
            "VALUES(#{empModel.name},#{empModel.tel},#{empModel.gender},#{empModel.email},#{empModel.intime},#{empModel.outtime},#{empModel.deptid})")
    /*增加这个注解插入记录后会返回自增长的id*/
    @Options(useGeneratedKeys = true, keyProperty = "empModel.id", keyColumn="id")
    void save(@Param("empModel") EmpModel empModel);

    void deleteManyEmp(@Param("ids") String[] ids);
}
