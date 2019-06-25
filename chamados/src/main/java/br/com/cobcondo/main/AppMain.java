package br.com.cobcondo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import br.com.cobcondo.main.utils.AppContext;

@SpringBootApplication
public class AppMain extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppContext.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}

}
