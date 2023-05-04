package localhost.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

//MyBatis配置类
public class MyBatisConfig {
    //获取mybatis-config.xml文件
    @Value("classpath:mybatis-config.xml")
    private Resource resource;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //代替<dataSource>,设置数据库信息
        factoryBean.setDataSource(dataSource);
        //代替<typeAliases>扫描该包的实体类
        factoryBean.setTypeAliasesPackage("localhost.pojo");
        //扫描XML配置文件
        factoryBean.setConfigLocation(resource);
        return factoryBean.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //代替<mappers>扫描该包的映射文件
        msc.setBasePackage("localhost.mappers");
        return msc;
    }
}