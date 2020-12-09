package es.ull.passengers;
import org.junit.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import es.ull.flights.Flight;
import es.ull.passengers.Passenger;

public class PassengerTest {

	@DisplayName("Given there is a flight")
	@Nested
	class RegularFlightTest {

		private Flight f1;
		private Flight f2;
		private Passenger joane;
		private Passenger olatz;

		@BeforeEach
		void setUp() {
			f1 = new Flight("VF", 10);
			f2 = new Flight("VF", 0);
			joane = new Passenger("id1", "joane", "ES");
			olatz = new Passenger("id2", "olatz", "ES");
			joane.setFlight(f1);
		}
		

		@Nested
		@DisplayName("When we have a regular passenger")
		class RegularPassenger {

			@Test
			@DisplayName("HEMEN RE ETZEKIÑAT")
			public void testFlightRegularPassenger() {
				assertAll("Verify all conditions for a regular passenger",
						() -> assertEquals("id1", joane.getIdentifier()),
						() -> assertEquals("joane", joane.getName()),
						() -> assertEquals("ES", joane.getCountryCode()),
						() -> assertEquals("Passenger joane with identifier: id1 from ES", joane.toString()),
						() -> assertEquals(f1, joane.getFlight())
						);
			}
			
			@Test
			@DisplayName("Testing errors of the passenger")
			public void testPassengerErrors() {
				assertAll("ETZEKIÑAT TXO",
						() -> assertThrows(RuntimeException.class, () -> {
							joane.joinFlight(f1);
							joane.joinFlight(f2);
						  })
						);
			}
		}
	}
}
