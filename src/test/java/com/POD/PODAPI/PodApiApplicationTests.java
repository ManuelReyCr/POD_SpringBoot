package com.POD.PODAPI;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import com.POD.PODAPI.Dto.DTOPersona;
import com.POD.PODAPI.Servicio.ServicioPersona;
import com.POD.PODAPI.Servicio.ServicioPersonaImpl;

@SpringBootTest
class PodApiApplicationTests {

	@Mock
	private ServicioPersona servicioPersona;
	@InjectMocks
	private ServicioPersonaImpl servicioPersonaImpl;

	private DTOPersona personaDto;

	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this);
		personaDto = new DTOPersona();
		personaDto.setNombre("manuel");
		personaDto.setPrimerApellido("rey");
		personaDto.setSegundoApellido("cruz");
		personaDto.setFechaNacimiento("2002");
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
