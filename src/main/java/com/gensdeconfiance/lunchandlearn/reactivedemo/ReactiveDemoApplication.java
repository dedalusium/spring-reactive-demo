package com.gensdeconfiance.lunchandlearn.reactivedemo;

import com.gensdeconfiance.lunchandlearn.reactivedemo.domain.Profile;
import com.gensdeconfiance.lunchandlearn.reactivedemo.infrastructure.MongoDBProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
@EnableWebMvc
//@EnableWebFlux
public class ReactiveDemoApplication implements ApplicationRunner {

	private static final int MAX_ITEM = 10;
	private static final Logger logger = LoggerFactory.getLogger(ReactiveDemoApplication.class);
	private final MongoDBProfileRepository repository;

	public ReactiveDemoApplication(MongoDBProfileRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		var newProfiles = IntStream.range(0,MAX_ITEM).mapToObj(Profile::new).collect(Collectors.toList());
		repository.deleteReactiveAll().subscribe((var voidMono) -> {
			logger.info("Init deletion done !");
		});
		repository.saveReactiveProfiles(newProfiles).subscribe((var initP) -> {
			logger.info("One profile inserted!");
		},(var throwable) -> {},() -> {
			logger.info("Init insert done !");
		} );
	}

//	@Override
//	public void run(ApplicationArguments args) {
//		var newProfiles = IntStream.range(0,MAX_ITEM).mapToObj(Profile::new).collect(Collectors.toList());
//		repository.deleteAll();
//		logger.info("Init deletion done !");
//		repository.saveProfiles(newProfiles);
//		logger.info("Init insert done !");
//	}
}
