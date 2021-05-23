package pl.lodz.p.edu.krs.task2;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sourceforge.jFuzzyLogic.rule.*;
import net.sourceforge.jFuzzyLogic.membership.*;

@SpringBootApplication
@RestController
public class Task2Application {

	public static void main(String[] args) {
//		SpringApplication.run(Task2Application.class, args);

		Variable var = new Variable("danceability");


		LinguisticTerm smallDanceable = new LinguisticTerm(
				"small danceable",
				new MembershipFunctionTrapetzoidal(
						new Value(0),
						new Value(10),
						new Value(18),
						new Value(30))
		);

		LinguisticTerm mediumDanceable = new LinguisticTerm(
				"medium danceable",
				new MembershipFunctionTrapetzoidal(
						new Value(29),
						new Value(34),
						new Value(44),
						new Value(60)
				)
		);

		LinguisticTerm veryDanceable = new LinguisticTerm(
				"very danceable",
				new MembershipFunctionTrapetzoidal(
						new Value(59),
						new Value(65),
						new Value(80),
						new Value(100)
				)
		);

		var.add(smallDanceable).add(mediumDanceable).add(veryDanceable);

		var.setValue(12);
		System.out.println(var.getMembership("small danceable"));


//		System.out.println(var);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

}
