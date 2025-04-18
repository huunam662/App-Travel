package app.travel.config.mybatis.inteceptor;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.other.Error;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;


@Slf4j(topic = "MYBATIS-INTERCEPTOR")
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "update",
                args = {
                        MappedStatement.class,
                        Object.class
                }
        )
})
public class MyBatisInterceptorConfig implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        log.info("MyBatis Interceptor start intercept - Go to DB");

        // Go to db
        Object result = invocation.proceed();
        // back from db

        log.info("MyBatis Interceptor start intercept - Back from DB");

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];

        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();

        boolean isInsertOrUpdateOrDelete = sqlCommandType.equals(SqlCommandType.INSERT) ||
                sqlCommandType.equals(SqlCommandType.UPDATE) ||
                sqlCommandType.equals(SqlCommandType.DELETE);

        BoundSql boundSql = mappedStatement.getBoundSql(invocation.getArgs()[1]);

        log.info("MyBatis Interceptor end intercept - Sql -> {}", boundSql.getSql());

        if(!isInsertOrUpdateOrDelete) return result;

        if(result instanceof Integer effectedRow && effectedRow < 1){

            log.error("{} effected row is less than one with: {}", sqlCommandType, boundSql.getSql());

            throw new ErrorHolderException(Error.SERVER_ERROR);
        }

        return result;
    }


    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

}
