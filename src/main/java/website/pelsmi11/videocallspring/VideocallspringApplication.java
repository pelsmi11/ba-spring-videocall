package website.pelsmi11.videocallspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import website.pelsmi11.videocallspring.user.User;
import website.pelsmi11.videocallspring.user.UserService;

@SpringBootApplication
public class VideocallspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocallspringApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService service){
		return args -> {
			service.register(User.builder()
					.username("pelsmi11")
					.email("hmartinezmoreira81@gmail.com")
					.password("pokesoni")
					.build());
			service.register(User.builder()
					.username("jhon")
					.email("jhon@gmail.com")
					.password("test123")
					.build());
			service.register(User.builder()
					.username("anny")
					.email("anny@gmail.com")
					.password("test123")
					.build());
		};
	}

}
