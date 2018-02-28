package info.francoisandre.testmockito;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

	@Bean
	public IMonService getMonService() {
		IMonService monService = Mockito.mock(IMonService.class);
		Mockito.when(monService.getAge("John")).thenReturn(40);
		Mockito.when(monService.getAge("Paul")).thenReturn(70);
		Mockito.when(monService.getNote(Mockito.anyString())).thenReturn(20);
		return monService;
	}

}
