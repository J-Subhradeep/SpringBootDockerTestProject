package learn.spring.docker;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import jakarta.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {

	@GetMapping("/get")
	public String getMessage(HttpServletRequest request) {
		String clientIpAddress = request.getRemoteAddr();
		String serverHostname = "";
		try {
			serverHostname = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hello world Done build with ci cd docker-compose with nginx load balance, Request IP : "+clientIpAddress +", Server HOSTNAME : "+serverHostname;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerApplication.class, args);
	}

}
