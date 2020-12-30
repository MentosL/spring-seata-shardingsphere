## spring-seata-shardingsphere
 >seata与shardingsphere整合


## 版本说明

|  依赖   | 版本说明  |
|  ----  | ----  |
| jdk  | ⩾	1.8 |
| seata  | ⩾ 1.4.0 |
| shardingsphere  | ⩾ 4.1.0 |

## 说明

目前seata结合shardingsphere有版本不支持的问题。
会出现以下问题：

### Q1 shardingsphere太低，不支持seata。
#### 产生错误日志

```java
Error updating database. Cause: java.sql.SQLException: io.seata.common.exception.ShouldNeverHappenException: [xid:192.168.5.209:8091:2031433650]get tablemeta failed
The error may exist in file [E:\lvya\project\sy-new-cloud\sy-db\target\classes\mybatis\task\TaskInfoMapper.xml]
The error may involve defaultParameterMap
The error occurred while setting parameters
SQL: UPDATE task_info SET flg='N' WHERE id = ?
Cause: java.sql.SQLException: io.seata.common.exception.ShouldNeverHappenException: [xid:192.168.5.209:8091:2031433650]get tablemeta failed
; uncategorized SQLException; SQL state [null]; error code [0]; io.seata.common.exception.ShouldNeverHappenException: [xid:192.168.5.209:8091:2031433650]get tablemeta failed; nested exception is java.sql.SQLException: io.seata.common.exception.ShouldNeverHappenException: [xid:192.168.5.209:8091:2031433650]get tablemeta failed
org.springframework.jdbc.UncategorizedSQLException:

Error updating database. Cause: java.sql.SQLException: io.seata.common.exception.ShouldNeverHappenException: [xid:192.168.5.209:8091:2031433650]get tablemeta failed
The error may exist in file [E:\lvya\project\sy-new-cloud\sy-db\target\classes\mybatis\task\TaskInfoMapper.xml]
The error may involve defaultParameterMap
The error occurred while setting parameters
SQL: UPDATE task_info SET flg='N' WHERE id = ?
Cause: java.sql.SQLException: io.seata.common.exception.ShouldNeverHappenException: [xid:192.168.5.209:8091:2031433650]get tablemeta failed
; uncategorized SQLException; SQL state [null]; error code [0]; io.seata.common.exception.ShouldNeverHappenException: [xid:192.168.5.209:8091:2031433650]get tablemeta failed; nested exception is java.sql.SQLException: io.seata.common.exception.ShouldNeverHappenException: [xid:192.168.5.209:8091:2031433650]get tablemeta failed
at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:89)
at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:88)
at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:440)
at com.sun.proxy.$Proxy155.delete(Unknown Source)
at org.mybatis.spring.SqlSessionTemplate.delete(SqlSessionTemplate.java:303)
at com.baomidou.mybatisplus.core.override.MybatisMapperMethod.execute(MybatisMapperMethod.java:70)
at com.baomidou.mybatisplus.core.override.MybatisMapperProxy.invoke(MybatisMapperProxy.java:96)
at com.sun.proxy.$Proxy166.deleteByPrimaryKey(Unknown Source)
at com.dh.wxapi.contorller.seata.Task2Controller.deduct(Task2Controller.java:39)
at com.dh.wxapi.contorller.seata.Task2Controller$$FastClassBySpringCGLIB$$34173d.invoke()
at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)
at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:771)
at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)
at com.alibaba.druid.support.spring.stat.DruidStatInterceptor.invoke(DruidStatInterceptor.java:73)
at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)
at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:691)
at com.dh.wxapi.contorller.seata.Task2Controller$$EnhancerBySpringCGLIB$$e3377f3e.deduct()
at com.dh.wxapi.contorller.seata.Task2Controller$$FastClassBySpringCGLIB$$34173d.invoke()
at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)
at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:771)
at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)
at com.alibaba.druid.support.spring.stat.DruidStatInterceptor.invoke(DruidStatInterceptor.java:73)
at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)
at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:691)
at com.dh.wxapi.contorller.seata.Task2Controller$$EnhancerBySpringCGLIB$$b9271dfa.deduct()
at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.lang.reflect.Method.invoke(Method.java:498)
at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)
at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)
at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:105)
at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:879)
at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)
at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
at javax.servlet.http.HttpServlet.service(HttpServlet.java:503)
at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
at javax.servlet.http.HttpServlet.service(HttpServlet.java:590)
at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:74)
at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:129)
at com.dh.wxapi.contorller.seata.SeataFilter.doFilter(SeataFilter.java:29)
at com.dh.wxapi.contorller.seata.SeataFilter$$FastClassBySpringCGLIB$$9e443008.invoke()
at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)
at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:771)
at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)
at com.alibaba.druid.support.spring.stat.DruidStatInterceptor.invoke(DruidStatInterceptor.java:73)
at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)
at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:691)
at com.dh.wxapi.contorller.seata.SeataFilter$$EnhancerBySpringCGLIB$$288c207f.doFilter()
at com.dh.wxapi.contorller.seata.SeataFilter$$FastClassBySpringCGLIB$$9e443008.invoke()
at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)
at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:771)
at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)
at com.alibaba.druid.support.spring.stat.DruidStatInterceptor.invoke(DruidStatInterceptor.java:73)
at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)
at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:691)
at com.dh.wxapi.contorller.seata.SeataFilter$$EnhancerBySpringCGLIB$$397148cd.doFilter()
at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:61)
at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:124)
at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:61)
at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:61)
at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:61)
at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:61)
at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
at io.undertow.servlet.handlers.FilterHandler.handleRequest(FilterHandler.java:84)
at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
at io.undertow.servlet.handlers.ServletChain$1.handleRequest(ServletChain.java:68)
at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
at io.undertow.servlet.handlers.RedirectDirHandler.handleRequest(RedirectDirHandler.java:68)
at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:132)
at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:269)
at io.undertow.servlet.handlers.ServletInitialHandler.access$100(ServletInitialHandler.java:78)
at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:133)
at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:130)
at io.undertow.servlet.core.ServletRequestContextThreadSetupAction$1.call(ServletRequestContextThreadSetupAction.java:48)
at io.undertow.servlet.core.ContextClassLoaderSetupAction$1.call(ContextClassLoaderSetupAction.java:43)
at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:249)
at io.undertow.servlet.handlers.ServletInitialHandler.access$000(ServletInitialHandler.java:78)
at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:99)
at io.undertow.server.Connectors.executeRootHandler(Connectors.java:376)
at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:830)
at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
at java.lang.Thread.run(Thread.java:748)
Caused by: java.sql.SQLException: io.seata.common.exception.ShouldNeverHappenException: [xid:192.168.5.209:8091:2031433650]get tablemeta failed
at io.seata.rm.datasource.exec.ExecuteTemplate.execute(ExecuteTemplate.java:115)
at io.seata.rm.datasource.exec.ExecuteTemplate.execute(ExecuteTemplate.java:50)
at io.seata.rm.datasource.PreparedStatementProxy.execute(PreparedStatementProxy.java:55)
at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.lang.reflect.Method.invoke(Method.java:498)
at org.apache.ibatis.logging.jdbc.PreparedStatementLogger.invoke(PreparedStatementLogger.java:59)
at com.sun.proxy.$Proxy465.execute(Unknown Source)
at org.apache.ibatis.executor.statement.PreparedStatementHandler.update(PreparedStatementHandler.java:47)
at org.apache.ibatis.executor.statement.RoutingStatementHandler.update(RoutingStatementHandler.java:74)
at com.baomidou.mybatisplus.core.executor.MybatisSimpleExecutor.doUpdate(MybatisSimpleExecutor.java:54)
at org.apache.ibatis.executor.BaseExecutor.update(BaseExecutor.java:117)
at com.baomidou.mybatisplus.core.executor.MybatisCachingExecutor.update(MybatisCachingExecutor.java:83)
at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.lang.reflect.Method.invoke(Method.java:498)
at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
at com.eos.sdk.common.autoid.AutoIdInterceptor.intercept(AutoIdInterceptor.java:55)
at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
at com.sun.proxy.$Proxy463.update(Unknown Source)
at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.lang.reflect.Method.invoke(Method.java:498)
at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
at com.sun.proxy.$Proxy463.update(Unknown Source)
at org.apache.ibatis.session.defaults.DefaultSqlSession.update(DefaultSqlSession.java:197)
at org.apache.ibatis.session.defaults.DefaultSqlSession.delete(DefaultSqlSession.java:212)
at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.lang.reflect.Method.invoke(Method.java:498)
at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:426)
... 112 common frames omitted
Caused by: io.seata.common.exception.ShouldNeverHappenException: [xid:192.168.5.209:8091:2031433650]get tablemeta failed
at io.seata.rm.datasource.sql.struct.cache.AbstractTableMetaCache.getTableMeta(AbstractTableMetaCache.java:69)
at io.seata.rm.datasource.exec.BaseTransactionalExecutor.getTableMeta(BaseTransactionalExecutor.java:215)
at io.seata.rm.datasource.exec.BaseTransactionalExecutor.getTableMeta(BaseTransactionalExecutor.java:200)
at io.seata.rm.datasource.exec.UpdateExecutor.beforeImage(UpdateExecutor.java:70)
at io.seata.rm.datasource.exec.AbstractDMLBaseExecutor.executeAutoCommitFalse(AbstractDMLBaseExecutor.java:101)
at io.seata.rm.datasource.exec.AbstractDMLBaseExecutor.lambda$executeAutoCommitTrue$2(AbstractDMLBaseExecutor.java:142)
at io.seata.rm.datasource.ConnectionProxy$LockRetryPolicy.doRetryOnLockConflict(ConnectionProxy.java:302)
at io.seata.rm.datasource.exec.AbstractDMLBaseExecutor$LockRetryPolicy.execute(AbstractDMLBaseExecutor.java:186)
at io.seata.rm.datasource.exec.AbstractDMLBaseExecutor.executeAutoCommitTrue(AbstractDMLBaseExecutor.java:141)
at io.seata.rm.datasource.exec.AbstractDMLBaseExecutor.doExecute(AbstractDMLBaseExecutor.java:84)
at io.seata.rm.datasource.exec.BaseTransactionalExecutor.execute(BaseTransactionalExecutor.java:113)
at io.seata.rm.datasource.exec.ExecuteTemplate.execute(ExecuteTemplate.java:111)
... 146 common frames omitted`
```
#### 解决方案
 将对应的版本升级至`4.1.0`以上。




注：项目脱胎于原Seata官方demo：[spring-cloud-alibaba-seata-demo](https://gitee.com/itCjb/spring-cloud-alibaba-seata-demo.git)