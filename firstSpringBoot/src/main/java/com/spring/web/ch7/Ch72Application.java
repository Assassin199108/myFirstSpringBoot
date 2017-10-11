package com.spring.web.ch7;

import com.spring.entity.ch7.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangwei on 2017/10/11.
 */
@Controller
@SpringBootApplication
public class Ch72Application {

    @RequestMapping("/bootstrap")
    public String index(Model model){
        Person single = new Person("aa",11);

        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("xx",11);
        Person p2 = new Person("yy",22);
        Person p3 = new Person("zz",33);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);

        return "test";
    }

    public static void main(String[] args){
        SpringApplication.run(Ch72Application.class,args);
    }
    
}
