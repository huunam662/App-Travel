package app.travel.config.mybatis.inteceptor;

import app.travel.advice.exception.templates.ErrorHolderException;
import app.travel.common.constant.Error;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.context.annotation.Configuration;

@Slf4j(topic = "MYBATIS-INTERCEPTOR")
@Configuration
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "update",
                args = {
                        MappedStatement.class,
                        Object.class,
                        RowBounds.class,
                        ResultHandler.class
                }
        )
})
public class MyBatisInterceptorConfig implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Object result = invocation.proceed();

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];

        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();

        boolean isInsertOrUpdateOrDelete = sqlCommandType.equals(SqlCommandType.INSERT) ||
                sqlCommandType.equals(SqlCommandType.UPDATE) ||
                sqlCommandType.equals(SqlCommandType.DELETE);

        if(!isInsertOrUpdateOrDelete) return result;

        if(result instanceof Integer effectedRow && effectedRow < 1){

            BoundSql boundSql = mappedStatement.getBoundSql(invocation.getArgs()[1]);

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
