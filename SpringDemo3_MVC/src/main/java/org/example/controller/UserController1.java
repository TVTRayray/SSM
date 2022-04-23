package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.User;
import org.example.domain.Vo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * SpringMVC获得请求参数的方式：
 * （1）基本类型参数：
 *                  Controller中的业务方法的参数名称要与请求参数的name一致，参数值会自动映射匹配
 * （2）pojo类型参数
 *                  Controller中的业务方法的pojo参数的属性名与请求参数的name一致，参数值会自动映射匹配
 * （3）数组类型参数
 *                  Controller中的业务方法数组名称与请求参数的name一致，参数值会自动映射匹配
 * （4）集合类型参数
 *                  1.要将集合参数包装到一个pojo中才可以
 *                  2.当使用ajax提交时，可以指定contentType为json形式，那么在方法参数位置使用@RequestBody
 *                  可以直接接收集合数据而无需使用pojo进行包装
 */
@Controller
@RequestMapping("/user1")
public class UserController1 {
    @RequestMapping("/quick1")
    @ResponseBody
    //获得基本类型参数
    public void save1(@RequestParam(value = "name",defaultValue = "张三") String username, int age) {
        /**
         * @RequestParam:(参数绑定注解)
         *                 value：与请求参数名称
         *                 required：此在指定的请求参数是否必须包括，默认时true，提交时如果没有此参数则报错
         *                 defaultValue：当没有指定请求参数时，则使用指定的默认值赋值
         */
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/quick2")
    @ResponseBody
    //获得pojo类型参数
    //http://localhost:8080/SpringDemo3/user1/quick2?name="Ray"&add="sc"
    public void save2(User user) {

        System.out.println(user);
    }

    @RequestMapping("/quick3")
    @ResponseBody
    //获得数组类型参数
    //http://localhost:8080/SpringDemo3/user1/quick3?str=111&str=222&str=333
    public void save3(String[] str) {
        System.out.println(Arrays.toString(str));
    }

    @RequestMapping("/quick4")
    @ResponseBody
    //获得集合类型参数1
    /**
     * 需要将集合间接的封装成一个类来进行表示
     */
    public void save4(Vo vo) {
        System.out.println(vo);
    }

    @RequestMapping("/quick5")
    @ResponseBody
    //获得集合类型参数2
    /**
     * 当使用ajax提交时，可以指定contentType为json形式，那么在方法参数位置使用@RequestBody可以直接
     * 接收集合参数而无需使用POJO进行包装
     */
    public void save5(@RequestBody List<User> userList) {
        System.out.println(userList);
    }

    @RequestMapping("/quick6/{username}")
    @ResponseBody
    //Restful风格代码
    /**
     * @RequestMapping("/quick6/{username}")
     * 要对{username}参数进行赋值，可以使用@PathVariable，自动将value的值注入给形参String username
     * 使用method来选择get/post/put/delete
     */
//    http://localhost:8080/SpringDemo3/user1/quick6/zhangsan
    public void save6(@PathVariable(value = "username",required = true) String username) {
        System.out.println(username);
    }

    @RequestMapping("/quick7")
    @ResponseBody
    /**
     * SpringMVC自定义类型转换器步骤：
     *                              1.定义转换器类实现Converter接口
     *                              2.在配置文件中声明转换器
     *                              3.在<annotation-driven>中引用转换器
     */
//    http://localhost:8080/SpringDemo3/user1/quick7?date=2018-12-21
    public void save7(Date date) {
        System.out.println(date);
    }
}
