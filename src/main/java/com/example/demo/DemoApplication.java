package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.files.FileExample;
import com.example.demo.formatters.FormatterExample;
import com.example.demo.recursion.RecursionExample;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		List<OneInterfaceToRunThemAll> theList = new ArrayList<>();
		// theList.add(new RecursionExample());
		// theList.add(new FormatterExample());
		theList.add(new FileExample());

		for (OneInterfaceToRunThemAll theOneInterface : theList) {
			theOneInterface.runExample();
		}
	}
}