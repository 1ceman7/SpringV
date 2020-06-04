package com.yize.www.springbootvue.supplies.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yize.www.springbootvue.emp.pojo.EmpModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuppliesModel {
    private String id;
    private String name;
    private String merchants;
    private String model;
    private String money;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date buyDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date killDate;
    private String empId;
    private EmpModel em;
}
