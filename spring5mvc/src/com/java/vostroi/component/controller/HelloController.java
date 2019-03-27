package com.java.vostroi.component.controller;

import com.java.vostroi.component.beans.Address;
import com.java.vostroi.component.beans.Person;
import com.java.vostroi.component.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author tk
 * @date 2019/3/20 21:58
 * @desc
 */
@Controller
@RequestMapping(value = "/init")
/**
 * @SessionAttributes只能使用在类上
 * 用value来指定要放在session中的数据,可以用数组的方式指定多个数据--以名称来指定数据
 * 用types数据来指定要放在session中的数据类型--以类型来指定数据
 */
@SessionAttributes(value = {"person","",""}, types = {String.class, Date.class})
public class HelloController {
    private static final String SUCCESS = "success";

    /**
     * 1.使用@RequestMapping来映射请求
     * 2.返回值通过视图解析器（InternalResourceViewResolver）来解析到物理视图
     * @return
     */
    @RequestMapping(value = "/hello")
    public String hello(String name) {
        System.out.println("Hello SpringMvc..." + name);
        return SUCCESS;
    }

    /**
     * PostMapping/GetMapping/RequestMapping还可以指定params和headers
     * params:可以指定必须有哪些参数 如此处的"age"
     *        可以指定参数必须等于(=/)不等于(!=)个值 如此处 "name!=abcd"
     * headers: 类似params， 用来指定请求头的参数限制
     * @param name
     * @return
     */
    @PostMapping(value = "/save", params = {"name!=abcd","age"})
    public String helloPost(String name) {
        System.out.println("Hello SpringMvc Post Requset..." + name);
        return SUCCESS;
    }

    /**
     * @PathVariable 可以映射url中的点位符到目标方法的参数中（SpringMvc支持REST风格的请求）
     * @param id
     * @return
     */
    @GetMapping(value = "/delete/{id}")
    public String helloPathVariable(@PathVariable(value="id") String id) {
        System.out.println("id = " + id);
        return SUCCESS;
    }

    /*
       需要配置filter HiddenHttpMethodFilter 来处理post请求的隐藏参数_method
     */
    /**
     * rest风格的get请求--表示获取数据
     * @param name
     * @return
     */
    @GetMapping(value = "/testRest/{name}")
    public String restGet(@PathVariable(value="name") String name) {
        System.out.println("REST GET name = " + name);
        return SUCCESS;
    }

    /**
     * rest风格的post请求--表示新增数据
     * @param name
     * @return
     */
    @PostMapping(value="/testRest")
    public String restPost(String name) {
        System.out.println("REST POST name = " + name);
        return SUCCESS;
    }

    /**
     * rest风格的put请求--表示更新数据
     * springmvc会检查post请求中的_method参数 根据其值转换为PUT请求
     * @param name
     * @return
     */
    @PutMapping(value = "/testRest")
    public String restPut(String name) {
        System.out.println("REST PUT name = " + name);
        return SUCCESS;
    }

    /**
     * rest风格的delete请求--表示删除数据
     * springmvc会检查post请求中的_method参数 根据其值转换为DELETE请求
     * @param name
     * @return
     */
    @DeleteMapping(value = "/testRest/{name}")
    public String restDelete(String name) {
        System.out.println("REST DELETE name = " + name);
        return SUCCESS;
    }

    @GetMapping(value = "testRequestParam")
    public String testRequestParam(@RequestParam(value = "name", required = false, defaultValue = "no body") String name,
                                   @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("testRequestParam name = " + name + ", age = " + age);
        return SUCCESS;
    }

    /**
     * @RequestHeader 用法与 @RequestParam一样，映射请求头的参数
     * @param referer
     * @return
     */
    @GetMapping(value = "testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "JSESSIONID", required = true) String referer) {
        System.out.println("testRequestHeader referer = " + referer);
        return SUCCESS;
    }

    /**
     * @CookieValue 映射请求的Cookie中的参数
     * @param JSESSIONID
     * @return
     */
    @GetMapping(value = "testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID", required = true) String JSESSIONID) {
        System.out.println("testCookieValue JSESSIONID = " + JSESSIONID);
        return SUCCESS;
    }

    /**
     * 接收pojo参数 post请求  支持级联属性的提交
     * @param person
     * @return
     */
    @PostMapping(value = "person")
    public String testPojo(Person person) {
        System.out.println(person);
        return SUCCESS;
    }


    /**
     * 支持原生的Servlet Api
     * @param request
     * @param response
     * @param session
     * @param witer
     */
    @GetMapping(value = "/testServlet")
    public void testServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session, Writer witer) throws IOException {
        System.out.println("request = " + request + ", response = " + response + ", session = " + session + ", witer = " + witer);
        witer.write(SUCCESS); // 这个writer实际上是response.getWriter
        response.getWriter().write("hello spring mvc");//
    }

    /**
     * 使用ModelAndView返回数据
     * springmvc会把ModelAndView中的数据，遍历，放入Request的域对象中requestScope
     * @return
     */
    @GetMapping(value = "/testModelAndView")
    public ModelAndView testModelAndView(String name) {
        System.out.println("name = " + name);
        // 准备modelAndView
        ModelAndView modelAndView = new ModelAndView(SUCCESS);

        Person person = new Person();
        person.setPassword("123");
        person.setUserName("张小三");
        Address address = new Address();
        address.setCity("成都");
        address.setProvince("四川");
        address.setStreet("华阳");
        person.setAddress(address);
        modelAndView.addObject(person);
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

    /**
     * Map作为方法入参， 并由此Map返回数据
     * @param name
     * @param map
     * @return
     */
    @GetMapping(value = "/testsessionAttributes")
    public String testsessionAttributes(String name, Map<String, Object> map) {
        System.out.println("name = " + name);
        map.put("names", Arrays.asList("张明", "李红", "孙蓝"));
        Person person = new Person(UUID.randomUUID().toString(),"赵四", "123321", new Address("四川", "成都", "华阳"));
        map.put("person", person);
        map.put("time", new Date());
        map.put("des1", "用value来指定要放在session中的数据,可以用数组的方式指定多个数据--以名称来指定数据");
        map.put("des2", "用types数据来指定要放在session中的数据类型--以类型来指定数据");

        return SUCCESS;
    }

    @PostMapping(value = "/testModelAttribute")
    public String testModelAttribute( Person person) {

        System.out.println("修改person数据... person = " + person);

        return SUCCESS;
    }

    /**
     * @ModelAttribute 使用场景：页面修改数据，但某些字段不想修改，没有传入后台，此时方法接收的对象这部分字段的值就为空。直接修改会把这些字段修改为空；或者需要手动查询数据库来手动设置需要修改的字段
     * @ModelAttribute则让Spring帮我们完成查询数据库，并把表单提交的字段参数赋值给查询出来的对象的相应字段，保持不需要修改的字段不变 的操作
     * 有@ModelAttribute注解的方法，会在每个方法被调用之前 由SpringMvc调用
     *
     * 执行过程：
     * 1.Springmvc会依次调用@ModelAttribute注解的方法
     * 2.@ModelAttribute注解的方法的逻辑：从数据库中获取数据，放入Map中，key为获取的对象的类名的驼峰标识名（即第一个字母小字）
     * 3.Springmvc把获取到的该对象传入目标方法（即前台调用的方法）中，并根据前台提交的数据设置到该对象中
     * 4.前台调用的目标方法执行本身的逻辑
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getPerson(@RequestParam(value = "id", required = false) String id, Map<String, Object> map) {
        System.out.println("模拟从数据库中获取 Person id = " + id);
        Person person = new Person(UUID.randomUUID().toString(), "Mr.ZhaoSi", "123321", new Address("四川", "成都", "华阳"));
        map.put("person", person);

    }

    /**
     * 测试自定义视图
     * @return
     */
    @GetMapping(value = "testCustomView")
    public String testCustomView() {
        return "excelView";
    }

    /**
     * 测试重定向--可以重定向到外部应用地址
     * @return
     */
    @GetMapping(value = "testRedirect")
    public String testRedirect() {
        System.out.println("测试重定向...");
        return "redirect:http://baidu.com";
    }

    /**
     * 测试转发--只能跳转到当前应用
     * @return
     */
    @GetMapping(value = "testForward")
    public String testForward(HttpServletResponse response) {
        System.out.println("测试转发...");
        return "forward:/success";
    }

    @PostMapping(value="/testFileupload")
    public String testFileupload(String desc, @RequestParam(value = "file") MultipartFile file) throws IOException {
        System.out.println(desc);
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getInputStream());
        return SUCCESS;
    }

    @GetMapping(value = "/testException/{i}")
    public String testException(@PathVariable(name = "i") int i) {
        System.out.println(10 / i);
        return SUCCESS;
    }

    /**
     * 1.@ExceptionHandler来处理该Controller的异常 本方法可以加入Exception参数
     * 2.@ExceptionHandler方法的参数不能是Map，如果想传递具体异常到页面，需要使用ModelAndView来实现
     * 3.@ExceptionHandler value来指定具体的异常，优先执行指定的更小的异常的方法
     * 4.可以统一处理异常 使用注解ControllerAdvice标记的类 如MyExceptionHandler
     * 5.当前controller中配置的异常处理方法优先级高于统一的异常处理；当前controller如果没有异常处理，则使用统一的异常处理
     * @param ex
     * @return
     */
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView handleException(Exception ex) {
//        System.out.println("handleException handle exception...");
//        ModelAndView modelAndView = new ModelAndView("error");
//        modelAndView.addObject("exception", ex);
//        return modelAndView;
//    }
    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView handleException2(Exception ex) {
        System.out.println("handleException2 handle exception...");
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", ex);
        return modelAndView;
    }

    /**
     * 测试将异常转换为Http请求状态返回
     * @param i
     * @return
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "测试而已")
    @GetMapping(value = "/testResponeStattus/{i}")
    public String testResponeStattus(@PathVariable(name = "i") int i) {
        if (i < 10) {
            System.out.println("testResponeStattus...i="+i);
            throw new MyException();
        }
        return SUCCESS;
    }
}
