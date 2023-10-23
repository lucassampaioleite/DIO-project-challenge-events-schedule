package leite.sampaio.lucas.eventsschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EventsScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsScheduleApplication.class, args);
	}

}
