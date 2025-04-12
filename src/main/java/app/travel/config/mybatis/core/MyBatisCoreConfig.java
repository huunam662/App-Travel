package app.travel.config.mybatis.core;

import app.travel.config.mybatis.hander.MetaObjectHandlerConfig;
import app.travel.config.mybatis.inteceptor.MyBatisInterceptorConfig;
import app.travel.value.MyBatisValue;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Configuration
public class MyBatisCoreConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, MyBatisValue myBatisValue) throws Exception {

        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setGlobalConfig(globalConfig(myBatisValue));
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResource(myBatisValue.getMapperLocations())
        );
        sqlSessionFactoryBean.setConfiguration(mybatisConfiguration(myBatisValue));
        sqlSessionFactoryBean.setTypeHandlers(uuidBaseTypeHandler());
        sqlSessionFactoryBean.setPlugins(new MyBatisInterceptorConfig(), mybatisPlusInterceptor());

        return sqlSessionFactoryBean.getObject();
    }

    public MybatisPlusInterceptor mybatisPlusInterceptor(){

        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();

        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());

        return mybatisPlusInterceptor;
    }

    public BaseTypeHandler<UUID> uuidBaseTypeHandler() {

        return new BaseTypeHandler<>() {

            @Override
            public void setNonNullParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
                ps.setObject(i, parameter);
            }

            @Override
            public UUID getNullableResult(ResultSet rs, String columnName) throws SQLException {
                String uuid = rs.getString(columnName);
                return uuid != null ? UUID.fromString(uuid) : null;
            }

            @Override
            public UUID getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
                String uuid = rs.getString(columnIndex);
                return uuid != null ? UUID.fromString(uuid) : null;
            }

            @Override
            public UUID getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
                String uuid = cs.getString(columnIndex);
                return uuid != null ? UUID.fromString(uuid) : null;
            }
        };
    }

    public MybatisConfiguration mybatisConfiguration(MyBatisValue myBatisValue){

        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        mybatisConfiguration.setJdbcTypeForNull(JdbcType.NULL);
        mybatisConfiguration.setMapUnderscoreToCamelCase(myBatisValue.getMapUnderscoreToCamelCase());
        mybatisConfiguration.setCacheEnabled(myBatisValue.getCacheEnabled());

        return mybatisConfiguration;
    }

    public GlobalConfig globalConfig(MyBatisValue myBatisValue) {

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new MetaObjectHandlerConfig());

        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        dbConfig.setTableUnderline(myBatisValue.getTableUnderline());

        globalConfig.setDbConfig(dbConfig);

        return globalConfig;
    }

}
