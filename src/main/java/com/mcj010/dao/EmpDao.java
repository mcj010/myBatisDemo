package com.mcj010.dao;

import com.mcj010.bean.Emp;

public interface EmpDao {

    public void save(Emp e);
    public Integer update(Emp emp);
    public Integer delete(Integer empNo);
    public Emp selectEmpByEmpNo(Integer empNo);
}
