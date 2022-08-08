package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UsersRepository usersRepository = context.getBean("usersRepositoryJdbc", UsersRepository.class);
//        System.out.println(usersRepository.findById(2L));
//        System.out.println(usersRepository.findByEmail("bb"));
//        usersRepository.save(new User(6L, "sdfgh"));
//        usersRepository.update(new User(1L, "sytrew"));
//        usersRepository.delete(6L);
        System.out.println(usersRepository.findAll());
        usersRepository = context.getBean("usersRepositoryJdbcTemplate", UsersRepository.class);
//        System.out.println(usersRepository.findById(2L));
//        System.out.println(usersRepository.findByEmail("bb"));
//        usersRepository.save(new User(8L, "fddd"));
//        usersRepository.update(new User(1L, "jjj"));
//        usersRepository.delete(3L);
        System.out.println(usersRepository.findAll());
    }
}
