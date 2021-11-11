import com.mcj010.bean.Dept;
import com.mcj010.bean.Emp;
import com.mcj010.dao.DeptDao;
import com.mcj010.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FixMethodOrder(MethodSorters.DEFAULT)
public class Test03 {
    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test01() {
        SqlSession sqlsesson = sqlSessionFactory.openSession();
        EmpDao dao = sqlsesson.getMapper(EmpDao.class);
        Emp o = dao.selectEmpByStep(2);
        System.out.println(o);
        sqlsesson.close();
    }

    //懒加载
    @Test
    public void test02() {
        SqlSession sqlsesson = sqlSessionFactory.openSession();
        EmpDao dao = sqlsesson.getMapper(EmpDao.class);
        Emp o = dao.selectEmpByStep(2);
        System.out.println(o.getEmpno());
        sqlsesson.close();
    }

    //<sql> <include>
    @Test
    public void test03() {
        SqlSession sqlsesson = sqlSessionFactory.openSession();
        EmpDao dao = sqlsesson.getMapper(EmpDao.class);
        List<Emp> l= dao.selectSQLExample();
        System.out.println(l.size());
        sqlsesson.close();
    }

    // 动态sql, <if> <where>
    @Test
    public void test04() {
        SqlSession sqlsesson = sqlSessionFactory.openSession();
        EmpDao dao = sqlsesson.getMapper(EmpDao.class);
        Emp emp = new Emp();
//        emp.setEmpno(1);
        emp.setEname("suzan");
        Emp o = dao.selectByCondition(emp);
        System.out.println(o);
        sqlsesson.close();
    }

    // 动态sql, <trim>
    @Test
    public void test05() {
        SqlSession sqlsesson = sqlSessionFactory.openSession();
        EmpDao dao = sqlsesson.getMapper(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpno(1);
        emp.setEname("suzan");
        Emp o = dao.selecctByTrimCondition(emp);
        System.out.println(o);
        sqlsesson.close();
    }

}
