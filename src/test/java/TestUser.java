import com.mcj010.bean.User;
import com.mcj010.dao.UserDao;
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

@FixMethodOrder(MethodSorters.DEFAULT)
public class TestUser {
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
        UserDao dao = sqlsesson.getMapper(UserDao.class);
        User user = dao.selectUserById(1);
        System.out.println(user);
        sqlsesson.close();
    }

}
