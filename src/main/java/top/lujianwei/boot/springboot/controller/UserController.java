package top.lujianwei.boot.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.lujianwei.boot.springboot.dao.UserRepository;
import top.lujianwei.boot.springboot.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*@RequestMapping(value = "user", method = RequestMethod.GET)
    public String user(Model model) {
        Person person = new Person("a", 1);

        List<Person> people = new ArrayList<>();
        Person p = new Person("aaa", 123);
        people.add(p);
        p = new Person("bbb", 234);
        people.add(p);
        p = new Person("ccc", 345);
        people.add(p);

        model.addAttribute("person", person);
        model.addAttribute("people", people);
        model.addAttribute("title", "123");
        return "user";
    }*/

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public User save(User user) {
        User u = userRepository.save(user);
        return u;
    }

}
