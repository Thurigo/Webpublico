package com.example.WebpublicoCrud;
import  org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.WebpublicoCrud.Service.* ;

import java.io.IOException;

@SpringBootApplication
public class WebpublicoCrudApplication {


	public static void main(String[] args) throws IOException {

		ApplicationContext ctx = SpringApplication.run(WebpublicoCrudApplication.class, args);

		Leituras compras = ctx.getBean(Leituras.class);
		compras.listFolks();


		SpringApplication.run(WebpublicoCrudApplication.class, args);

	}

}
