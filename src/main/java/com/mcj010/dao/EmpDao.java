package com.mcj010.dao;

import com.mcj010.bean.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmpDao {

    public Integer save(Emp e);

    public Integer update(Emp emp);

    public Integer delete(Integer empNo);

    public Emp selectEmpByEmpNo(Integer empNo);

    @Select("select * from emp where ename = #{ename} and sal = #{sal}")
    public Emp selectEmpByEnameAndSal(@Param("ename") String ename, @Param("sal") Double sal);
}
