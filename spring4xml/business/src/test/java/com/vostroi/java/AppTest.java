package com.vostroi.java;

import com.vostroi.java.beans.Account;
import com.vostroi.java.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static ApplicationContext context = null;
    private static JdbcTemplate jdbcTemplate = null;
    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;


    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testSpringHibernate() throws SQLException {
        context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        DataSource dataSource = dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource.getConnection());

        com.vostroi.java.beans.ssh.service.BookService bookService = (com.vostroi.java.beans.ssh.service.BookService) context.getBean("bookService");
//        bookService.insertData();
        bookService.updateData();
    }


    @Test
    public void testTransaction() {

        BookService bookService = context.getBean(BookService.class);

        bookService.purchase("Wade", "1", 1);
    }


    @Test
    public void aopTest1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/aop.xml");
        Object calculatorService = context.getBean("calculatorService");
        System.out.println(calculatorService);
    }

    @Test
    public void jdbcTest() {
        init();
        String sqlQuery = "select * from account where id = ?";
        String sqlCount = "select count(*) from account";
        String sqlInsert = "insert into account values (?, ?, ?)";
        String sqlUpdate = "update account set name = ? , balance = ? where id = ?";

        int result = -9;
        // 单条插入
//        result = jdbcTemplate.update(sqlInsert, 5, "张三", 390);

        // 批量插入
//        List<Object[]> args = new ArrayList<>();
//        args.add(new Object[]{6,"小明", 123});
//        args.add(new Object[]{7,"小红", 124});
//        args.add(new Object[]{8,"小王", 125});
//        int[] ints = jdbcTemplate.batchUpdate(sqlInsert, args);
//        System.out.println("int = " + ints);

        // 更新
//        result = jdbcTemplate.update(sqlUpdate, "Wade", 300, 3);
//        System.out.println("result = " + result);

        // 查询
        // queryForObject(sql, Class, args)是返回一个指定字段的方法
        Object account = jdbcTemplate.queryForObject(sqlQuery, new Account(), 1);

        result = jdbcTemplate.queryForObject(sqlCount, Integer.class);
        System.out.println("result = " + result);

        System.out.println(account);

        List<Account> query = namedParameterJdbcTemplate.query("select * from account", new Account());
        for (Account account1 : query) {
            System.out.println(account1);
        }


    }

    public static void init() {
        context = new ClassPathXmlApplicationContext("META-INF/autowired.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) context.getBean("namedParameterJdbcTemplate");
        Account account = (Account) context.getBean("account");
        System.out.println("account=" + account);


    }

}
