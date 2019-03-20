package com.vostroi.java;

import static org.junit.Assert.assertTrue;

import com.vostroi.java.aop.CalculatorService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testAop1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("meta/aop.xml");
        CalculatorService bean = context.getBean(CalculatorService.class);

        System.out.println(bean);
        System.out.println(bean.add(1, 2));
        System.out.println(bean.sub(3, 5));
        System.out.println(bean.div(5, 1));

    }

}
