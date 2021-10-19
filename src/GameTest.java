import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * @author Ravi Trivedi
 * @Student_No 105197609
 *
 */
@DisplayName("This is Game Class Tester")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class TestGame {
	Game game = new Game("Halo 7: Even More Infinite - Diamond Edition", 1099.99, LocalDate.of(2026, 1, 17), 35, "Bungie", false);
	Game game2 = new Game("Halo 7: Even More Infinite - Diamond Edition", 1099.99, LocalDate.of(2026, 1, 17), 35, "Bungie", true);
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(1)
	void testGame() {
		System.out.println("testGame called");
		assertAll("game testing",() -> assertEquals("Halo 7: Even More Infinite - Diamond Edition",game.getTitle()),
				() -> assertEquals(1099.99,game.getRegularPrice()),
				() -> assertEquals(LocalDate.of(2026, 1, 17), game.getReleaseDate()),
				() -> assertEquals(35, game.getQuantity()),
				() -> assertEquals("Bungie", game.getStudio()),
				() -> assertEquals(false,game.isDiscontinued())
				);
	}
	
	@Test
	@Order(2)
	void testGetPrice() {
		System.out.println("testGetPrice of Game called + " + game.getPrice(LocalDate.of(2026, 2, 17)));
		
		assertEquals(1099.99, game.getPrice(LocalDate.of(2027, 10, 22)));	// Discontinued == false
		assertEquals(21999.8, game2.getPrice(LocalDate.of(2027, 10, 22)));	// Discontinued == True 
	}
	
	@Test
	void testdeepcopy() {
		System.out.println("testdeepcopyconstructor called");
		Game game2= (Game) game.makeCopy();
		assertNotEquals(game, game2);
		assertAll("deep copy testing", () -> assertEquals(game.getTitle(), game2.getTitle()),
				() -> assertEquals(game.getRegularPrice(), game2.getRegularPrice()),
				() -> assertEquals(game.getReleaseDate(), game2.getReleaseDate()),
				() -> assertEquals(game.getQuantity(), game2.getQuantity()),
				() -> assertEquals(game.getStudio(), game2.getStudio()),
				() -> assertEquals(game.isDiscontinued(), game2.isDiscontinued()));
	}

}
