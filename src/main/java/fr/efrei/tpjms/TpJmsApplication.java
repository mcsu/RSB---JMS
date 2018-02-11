package fr.efrei.tpjms;
//前端 端口8081 两层结构 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {
		"fr.efrei.tpjms",
		"fr.efrei.tpjms.service",
		"fr.efrei.tpjms.web"
		}) 
public class TpJmsApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		SpringApplication.run(TpJmsApplication.class, args);
	}
}
