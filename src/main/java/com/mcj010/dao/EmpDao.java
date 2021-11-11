package com.mcj010.dao;

import com.mcj010.bean.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmpDao {

    public Integer save(Emp e);

    public Integer update(Emp emp);

    public Integer delete(Integer empNo);

    public Emp selectEmpByEmpNo(Integer empNo);

    @Select("select * from emp where ename = #{ename} and sal = #{sal}")
    public Emp selectEmpByEnameAndSal(@Param("ename") String ename, @Param("sal") Double sal);

    public List<Emp> getListByEnameAndSal(Map<String, Object> map);

    // 一对一
    public Emp selectEmpAndDeptByEmpno(Integer empno);

    //lesson 3
    public Emp selectEmpByStep(Integer empno);

    // <sql> <inclued>
    public List<Emp> selectSQLExample();

    // 动态sql <if>
    public Emp selectByCondition(Emp emp);

    // 动态sql, <choose> <when> <otherwise>
    public Emp selecctByChooseCondition(Emp emp);
}
