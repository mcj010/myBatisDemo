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
import java.util.*;

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

    //1 对1 关联
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
        System.out.println(o.getDept());
        sqlsesson.close();
    }

    //<sql> <include>
    @Test
    public void test03() {
        SqlSession sqlsesson = sqlSessionFactory.openSession();
        EmpDao dao = sqlsesson.getMapper(EmpDao.class);
        List<Emp> l = dao.selectSQLExample();
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

    // foreacrh
    @Test
    public void test06() {
        SqlSession sqlsesson = sqlSessionFactory.openSession();
        EmpDao dao = sqlsesson.getMapper(EmpDao.class);
        List<Emp> list = dao.selectEmpByDeptnos(Arrays.asList(1, 2));
        for (Emp emp : list) {
            System.out.println(emp);
            System.out.println(emp.getDept());
        }
        sqlsesson.close();
    }

    //一级缓存：表示sqlSession级别的缓存，每次查询的时候会开启一个会话，此会话相当于一次连接，关闭之后自动失效
    @Test
    public void test07() {
        SqlSession sqlsesson = sqlSessionFactory.openSession();
        EmpDao dao = sqlsesson.getMapper(EmpDao.class);
        Emp emp = dao.selectEmpByEmpNo(1);
        System.out.println(emp);
        // 清除缓存，失效
        sqlsesson.clearCache();
        Emp emp2 = dao.selectEmpByEmpNo(1);
        System.out.println(emp2);
        sqlsesson.close();
    }

    @Test
    public void test08(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        EmpDao mapper2 = sqlSession2.getMapper(EmpDao.class);

        Emp emp = mapper.selectEmpByEmpNo(1);
        System.out.println(emp);
        sqlSession.close();
        System.out.println("====================");
        Emp emp1 = mapper2.selectEmpByEmpNo(1);
        System.out.println(emp1);
        sqlSession2.close();

    }

}
