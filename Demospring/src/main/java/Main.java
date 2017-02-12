import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.UserService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UserService service = (UserService) context.getBean("userservice");
        System.out.println(service.getUserFullNameById(1));
        System.out.println(service.getLastId());

        UserService service1 = (UserService) context.getBean("userservice");
        System.out.println(service1.getUserFullNameById(2));
        System.out.println(service.getLastId());
    }

}
