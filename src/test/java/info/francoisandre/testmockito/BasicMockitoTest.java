package info.francoisandre.testmockito;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class BasicMockitoTest {

	@Autowired
	IMonService monService;

	@Test
	public void testBouchonBasique() {
		// Given - Mon service injecté par Mockito
		// When - N/A
		// Then - Mon service doit avoir le comportement par défaut
		Assert.assertNotNull("Mon service ne doit pas être null", monService);
		Assert.assertEquals("L'age renvoyé doit correspondre à la valeur par défaut de mockito", new Integer(0),
			monService.getAge("Ringo"));
	}

	@Test
	public void testBouchonAmeliore() {
		// Given - Mon service injecté par Mockito
		// When - N/A
		// Then - Mon service doit retourner les valeurs précisée explicitement dans le bouchon
		Assert.assertNotNull("Mon service ne doit pas être null", monService);
		Assert.assertEquals("L'age renvoyé doit être 40 pour John", new Integer(40), monService.getAge("John"));
		Assert.assertEquals("L'age renvoyé doit être 70 pour John", new Integer(70), monService.getAge("Paul"));
		Assert.assertEquals("La note renvoyée pour n'importe quel nom doit etre 20", new Integer(20),
			monService.getNote(RandomStringUtils.random(50)));

	}

}
