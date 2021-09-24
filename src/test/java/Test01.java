import com.mcj010.bean.Emp;
import com.mcj010.dao.EmpDao;
import junit.framework.TestCase;
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
public class Test01 {
    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() {
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
    public void testASelect() {
        SqlSession sqlsesson = sqlSessionFactory.openSession();
        EmpDao dao = sqlsesson.getMapper(EmpDao.class);
        Emp emp = dao.selectEmpByEmpNo(1);
        System.out.println(emp);
        sqlsesson.close();
    }

    @Test
    public void testBSave() {
        SqlSession ss = sqlSessionFactory.openSession();
        EmpDao dao = ss.getMapper(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpno(3);
        emp.setEname("bb");
        emp.setCommon(12.2);
        Integer i = dao.save(emp);
        System.out.println(i);
        ss.commit();
        ss.close();
    }

    @Test
    public void testCUpdate() {
        SqlSession ss = sqlSessionFactory.openSession(true);
        EmpDao dao = ss.getMapper(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpno(3);
        emp.setSal(1000.1);
        Integer i = dao.update(emp);
        System.out.println(i);
        ss.close();
    }

    @Test
    public void testDDelete() {
        SqlSession ss = sqlSessionFactory.openSession();
        EmpDao dao = ss.getMapper(EmpDao.class);
        Integer i = dao.delete(3);
        System.out.println(i);
        ss.commit();
        ss.close();
    }

    @Test
    public void testESelect() {
        SqlSession sqlsesson = sqlSessionFactory.openSession();
        EmpDao dao = sqlsesson.getMapper(EmpDao.class);
        Emp emp = new Emp();
//        emp.setEname("jack");
//        emp.setSal(1000.0);
        emp = dao.selectEmpByEnameAndSal("jack",1000.0);
        System.out.println(emp);
        sqlsesson.close();
    }

    @Test
    public void testFSelect() {
        SqlSession sqlsesson = sqlSessionFactory.openSession();
        EmpDao dao = sqlsesson.getMapper(EmpDao.class);

        Map map = new HashMap();
        map.put("SAL",900);
        List<Emp> list = dao.getListByEnameAndSal(map);
        System.out.println(list.size());
        sqlsesson.close();
    }

    @Test
    public void testGSelect() {
        SqlSession sqlsesson = sqlSessionFactory.openSession();
        EmpDao dao = sqlsesson.getMapper(EmpDao.class);

        Emp o = dao.selectEmpAndDeptByEmpno(2);
        System.out.println(o);
        sqlsesson.close();
    }

}
