package com.yize.www.springbootvue.emp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yize.www.springbootvue.dept.pojo.DeptModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpModel {
    /*-----------------------数据字典-----------------------------*/
    public static final Integer CUSTOMER_GENDER_MAN = 1;
    public static final Integer CUSTOMER_GENDER_WOMAN = 0;

    public static final String CUSTOMER_GENDER_MAN_VIEW = "男";
    public static final String CUSTOMER_GENDER_WOMAN_VIEW = "女";

    public static final Map<Integer, String> GENDER_MAP = new HashMap<Integer, String>();

    static {
        GENDER_MAP.put(CUSTOMER_GENDER_MAN, CUSTOMER_GENDER_MAN_VIEW);
        GENDER_MAP.put(CUSTOMER_GENDER_WOMAN, CUSTOMER_GENDER_WOMAN_VIEW);
    }
    private String genderView;
    public String getGenderView() {
        return genderView;
    }
    /*----------------------------------------------------------*/
    public void setGender(Integer gender) {
        this.gender = gender;
        this.genderView = GENDER_MAP.get(gender);
    }

    public Integer getGender() {
        return gender ;
    }

    private Integer id;

    private String name;

    private String tel;

    private Integer gender;

    private String email;

    private Integer deptid;

    //入职时间
    /*注解@JsonFormat后台到前台的时间格式的转换
      注解@DataFormAT前后到后台的时间格式的转换*/
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date intime;
    //离职时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date outtime;

/*----------------   多对一   --------------------------------*/
    private DeptModel dm;
/*-----------------------------------------------------------*/


}