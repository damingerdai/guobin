# 一个数据源demo

## 前言
我们重复造轮子，不是为了证明我们比那些造轮子的人牛逼，而是明白那些造轮子的人有多牛逼。

## JDBC介绍

 在JDBC中，我们可以通过DriverManager.getConnection()创建(而不是获取)一个Connection,在完成CRUD之后，再去销毁该Connection。在并发量不高的情况下，创建销毁Connection所花费的时间和资源是可以接受，但是随着并发量的提高，频繁的创建销毁Connection所付出的性能代价太大了，因此在创建一个Connection后能够可以多次使用成了一个很好的选择。在JDBC规范中，通过实现java.sql.Datasource接口，可以屏蔽数据库、操作系统的差异，实现Connection的复用。

 ## 常用开源数据源框架介绍

 目前，我们常用的数据源框架主要有dbcp2、tomcat-jdbc,c3p0,druid、hikariCP：
 1. dbcp2: 由Apache开发的一款优秀数据源;
 2. tomcat-jdbc： tomcat自带的JDBC连接池，是dbcp2的一种替换或备选方案;
 3. c3p0: 一个开源的JDBC连接池，它实现了数据源和JNDI绑定，支持JDBC3规范和JDBC2的标准扩展，![github地址](https://github.com/swaldman/c3p0)
 4. druid: 阿里出品的一款数据源框架，号称Java语言中最好的数据库连接池，能够提供强大的监控和扩展。
 5. hikariCP： 号称史上最快的数据源，Spring Boot2.0默认的数据源

 ## Apache Commons Pool2
 Apache Commons Pool2是Apache出品的一套对象池的开源库，提供课一些Pool接口和辅助实现Pool接口的实现。

 ### PooledObjectFactory

 PooledObjectFactory提供一个管理对象的通用工厂：
 ```Java
public interface PooledObjectFactory<T> {
    PooledObject<T> makeObject();
    void activateObject(PooledObject<T> obj);
    void passivateObject(PooledObject<T> obj);
    boolean validateObject(PooledObject<T> obj);
    void destroyObject(PooledObject<T> obj);
}
 ```
Apache Commons Pool2提供一个抽象的PooledObjectFactory实现: BasePooledObjectFactory,我们需要实现create和wrap这两个方法。

### GenericObjectPool
GenericObjectPool 提供了一个简单的、可扩展的Pool实现

## Guobin DataSource
Guobin是基于Apache Commons Pool2的一个数据源Demo,使用示例：
```Java
public class TestGuobinDataSource {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL  =  "jdbc:mysql://127.0.0.1:3306/world?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "267552";

    private static DataSource ds;

    @BeforeClass
    public static void initDataSource() {
        ds = GuobinDataSourceBuilder.buildSimpleDataSource(DRIVER, URL, USERNAME, PASSWORD);
    }

    @Test
    public void testGetConnection() throws SQLException {
        Assert.assertNotNull(ds.getConnection());
    }
}
```