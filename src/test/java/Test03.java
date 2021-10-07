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


}