import com.mysql.cj.xdevapi.SessionFactory;
import com.proberen.www.Starter;
import com.proberen.www.config.C3p0DBConfig;
import com.proberen.www.dao.CnUserDao;
import com.proberen.www.entity.CnUser;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class DbTest {
    @Test
    public void Test(){

    }
}
