package com.java.vostroi.component.controller;

import com.java.vostroi.component.beans.Person;
import com.java.vostroi.component.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author tk
 * @date 2019/3/24 15:58
 * @desc rest风格的 增 删 改 查
 */
@Controller
@RequestMapping(value = "/restCrud")
public class RestCrudController {
    @Autowired
    private PersonDao personDao;

    @GetMapping(value = "persons")
    public String listAllPerson(Map<String, Object> map) {
        List<Person> persons = personDao.getAllPerson();
        map.put("persons", persons);
        System.out.println("RestCrudController listAllPerson...map = " + map);
        return "listPerson";
    }

    /**
     * 返回json数据
     * @return
     */
    @ResponseBody
    @GetMapping(value = "personsJson")
    public List<Person> listAllPerson() {
        List<Person> persons = personDao.getAllPerson();
        System.out.println("RestCrudController listAllPerson...persons = " + persons);
        return persons;
    }

    /**
     * 使用@DeleteMapping--需要post提交
     * method = RequestMethod.DELETE
     * @param map
     * @param id
     * @return
     */
    @RequestMapping(value = "person/{id}" )
    public String deletePerson(Map<String, Object> map, @PathVariable(value = "id") String id) {
        System.out.println("RestCrudController deletePerson...");
        List<Person> persons = personDao.getAllPerson();
        for (Person person : persons) {
            if (id.equals(person.getId())) {
                persons.remove(person);
                break;
            }
        }
        map.put("persons", persons);
        return "redirect:/restCrud/persons";
    }

    /**
     * 新增Person
     * @Valid Person person, BindingResult result这两个参数必须相邻
     * @param map
     * @return
     */
    @PostMapping(value = "person")
    public String addPerson(Map<String, Object> map, @Valid Person person, BindingResult result) {
        System.out.println("RestCrudController addPerson... person = " + person);
        person.setId(UUID.randomUUID().toString());
        map.put("person", person);
        map.put("persons", personDao.getAllPerson().add(person));

        for (FieldError fieldError : result.getFieldErrors()) {
            System.out.println(fieldError.getField() + " : " + fieldError.getDefaultMessage());
        }
        return "editPerson";
    }

    /**
     * 修改Person
     * @param map
     * @return
     */
    @PutMapping(value = "person")
    public String updatePerson(Map<String, Object> map, Person person) {
        System.out.println("RestCrudController updatePerson... person = " + person);

        map.put("persons", personDao.getAllPerson().add(person));
        map.put("person", person);
        return "editPerson";
    }

    @PostMapping(value = "testConverters")
    public ModelAndView testConverters(@RequestParam(value = "person") Person person) {
        System.out.println("testConverters person =" + person);
        ModelAndView mv = new ModelAndView("editPerson");
        mv.addObject("person", person);
        return mv;
    }

    @InitBinder
    public void initBindDate(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));

    }
}
