package com.mcj010.dao;

import com.mcj010.bean.Dept;

public interface DeptDao {
    public Dept selectDeptByDeptno(Integer deptno);

    public Dept selectDeptByStep(Integer deptno);
}