package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;




public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        User user1 = new User("Михаэль ", "Шумахер", "F1@gmail.ru");
        Car car1 = new Car(2101, "Vaz");
        userService.add(user1.setCar(car1).setUser(user1).getCar());

        User user2 = new User("Фернандо ", "Алонсо", "Dtm@gmail.ru");
        Car car2 = new Car(100, "Audi");
        userService.add(user2.setCar(car2).setUser(user2).getCar());

        User user3 = new User("Кими ", "Райкконен", "F1kim@gmail.ru");
        Car car3 = new Car(911, "Porsche");
        userService.add(user3.setCar(car3).setUser(user3).getCar());

        User user4 = new User("Льюис ", "Хемилтон", "Champion@gmail.ru");
        Car car4 = new Car(549, "Bmw");
        userService.add(user4.setCar(car4).setUser(user4).getCar());

        for (User user : userService.listUsers()) {
            System.out.println(user + " " + user.getCar());
            System.out.println("__________________________________________________________________________");

        }

        System.out.println("Владелец авто - " + userService.getUserByCar( "Bmw", 549));
        System.out.println("__________________________________________________________________________");

        context.close();
    }

}
