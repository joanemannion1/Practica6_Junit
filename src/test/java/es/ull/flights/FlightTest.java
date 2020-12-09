package es.ull.flights;
import org.junit.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import es.ull.passengers.Passenger;

public class FlightTest {

	@DisplayName("Given there is a flight")
	@Nested
	class RegularFlightTest {

		private Flight f1;
		private Flight f2;
		private Flight f3;
		private Passenger joane;
		private Passenger olatz;

		@BeforeEach
		void setUp() {
			f1 = new Flight("VF", 10);
			f3 = new Flight("VF", 1);
			joane = new Passenger("id1", "joane", "ES");
			olatz = new Passenger("id2", "olatz", "ES");
		}
		

		@Nested
		@DisplayName("When we have a regular passenger")
		class RegularPassenger {

			@Test
			@DisplayName("Then you can add and remove him from a flight")
			public void testFlightRegularPassenger() {
				assertAll("Verify all conditions for a regular passenger and a regular flight",
						() -> assertEquals("VF", f1.getFlightNumber()),
						() -> assertEquals(true, f1.addPassenger(joane)),
						() -> assertEquals(1, f1.getNumberOfPassengers()),
						() -> assertEquals(true, f1.removePassenger(joane)),
						() -> assertEquals(0, f1.getNumberOfPassengers())
						);
			}
			
			@Test
			@DisplayName("Testing errors of the flight")
			public void testFlightErrors() {
				assertAll("Assertion to test errors",
						() -> assertThrows(RuntimeException.class, () -> {
							f2 = new Flight("AAA", 1);
						  }),
						() -> assertEquals(true, f3.addPassenger(joane)),
						() -> assertEquals(1, f3.getNumberOfPassengers()),
						() -> assertThrows(RuntimeException.class, () -> {
							f3.addPassenger(olatz);
						})
						);
			}
		}
	}
}
