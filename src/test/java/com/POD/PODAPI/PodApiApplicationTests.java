package com.POD.PODAPI;

import static org.mockito.Mockito.when;

import java.util.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import com.POD.PODAPI.Dto.DTOPersona;
import com.POD.PODAPI.Servicio.ServicioPersona;;

@SpringBootTest
class PodApiApplicationTests {

	@Mock
	private ServicioPersona servicioPersona;
	@InjectMocks

	private DTOPersona personaDto;
	private Date date = new GregorianCalendar(2002, Calendar.OCTOBER, 18).getTime();

	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this);
		personaDto = new DTOPersona();
		personaDto.setNombre("manuel");
		personaDto.setPrimerApellido("rey");
		personaDto.setSegundoApellido("cruz");
		personaDto.setFechaNacimiento(date);
		personaDto.setDomicilio("av.siempre viva #111");

	}

	@Test
	void guardadPersona(){
		when(servicioPersona.guardarPersona(personaDto));
	}

	// @Test
	// void obtenerPersona(){
	// 	when(servicioPersona.obtenerPersona(id)).thenReturn(ArrayList<Persona>);
	// }

}
