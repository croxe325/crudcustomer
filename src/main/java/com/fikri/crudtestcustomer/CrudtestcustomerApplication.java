package com.fikri.crudtestcustomer;

import com.fikri.crudtestcustomer.model.Customer;
import com.fikri.crudtestcustomer.repository.CustomerRepository;

import com.fikri.crudtestcustomer.services.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication(scanBasePackages = "com.fikri.crudtestcustomer")

@RestController
public class CrudtestcustomerApplication extends SpringBootServletInitializer {
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CrudtestcustomerApplication.class);
	}
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ReportService reportService;

	@GetMapping ( "/getCustomers" )
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping ( "/report/{format}" )
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return reportService.exportReport(format);
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(CrudtestcustomerApplication.class, args);
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

	@Bean
	public SpringDataDialect springDataDialect() {
		return new SpringDataDialect();

	}
}
