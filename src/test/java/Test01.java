import com.mcj010.bean.Emp;
import com.mcj010.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Test01 {

    @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlsesson = sqlSessionFactory.openSession();
        EmpDao dao = sqlsesson.getMapper(EmpDao.class);
        Emp emp = dao.selectEmpByEmpNo(1);
        System.out.println(emp);
        sqlsesson.close();
    }
}
