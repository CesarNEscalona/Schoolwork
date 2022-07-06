package edu.greenriver.sdev.morespringproj;

import edu.greenriver.sdev.morespringproj.model.BookShelf;
import edu.greenriver.sdev.morespringproj.model.House;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class MoreSpringProjApplication {

	public static void main(String[] args) {
		// the context contains and manages all spring beans
		ApplicationContext context = SpringApplication.run(MoreSpringProjApplication.class, args);

		for (String beanName: context.getBeanDefinitionNames()
			 ) {
			System.out.println(beanName);
		}

		// we can ask the context for a spring bean
		BookShelf shelf = context.getBean(BookShelf.class);
		shelf.setMaterial("wooden");
		shelf.setFullOfBooks(false);

		System.out.println(shelf);

		// ask the spring context for the shelf again
		BookShelf copyOfShelf = context.getBean(BookShelf.class);
		System.out.println(copyOfShelf);

		House myHouse = context.getBean(House.class);
		System.out.println(myHouse);
	}

}
