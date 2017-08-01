package refactoring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	private Board board;

	@Before
	public void setUp() {
		board = new Board();
	}

	@Test
	public void testCanPut() throws Exception {
		assertTrue("最初は置ける", board.canPut(1, 1, 1));
		board.put(1, 1, 1);
		assertFalse("横列には同じ値は置けない", board.canPut(4, 1, 1));
		assertTrue("横列に違う値ならば置ける", board.canPut(4, 1, 2));
		assertFalse("縦列には同じ値は置けない", board.canPut(1, 4, 1));
		assertTrue("縦列に違う値ならば置ける", board.canPut(1, 4, 2));
		assertFalse("同じブロックに同じ値は置けない", board.canPut(2, 2, 1));
		assertTrue("同じブロックに違う値ならば置ける", board.canPut(2, 2, 2));
	}

	@Test
	public void testPutGet() throws Exception {
		assertEquals("初期値は0", 0, board.getNumber(1, 1));
		board.put(1, 1, 1);
		assertEquals("置いた値が取得できる", 1, board.getNumber(1, 1));
		board.put(1, 1, 2);
		assertEquals("値の上書きが可能", 2, board.getNumber(1, 1));
	}

	@Test
	public void testClear() throws Exception {
		board.put(9, 9, 9);
		board.clear(9, 9);
		assertEquals("0にクリアされる", 0, board.getNumber(9, 9));
	}

	@Test
	public void testCanPutPositionException() throws Exception {
		try {
			board.canPut(0, 1, 1);
			fail("列座標が小さすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}

		try {
			board.canPut(10, 1, 1);
			fail("列座標が大きすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}

		try {
			board.canPut(1, 0, 1);
			fail("行座標が小さすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}

		try {
			board.canPut(1, 10, 1);
			fail("行座標が大きすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}
	}

	@Test
	public void testCanPutValueException() throws Exception {
		try {
			board.canPut(1, 1, 0);
			fail("値が小さすぎる場合は、例外が発生");
		} catch(IllegalNumber expected) {}

		try {
			board.canPut(1, 1, 10);
			fail("値が大きすぎる場合は、例外が発生");
		} catch(IllegalNumber expected) {}
	}

	@Test
	public void testPutPositionException() throws Exception {
		try {
			board.put(0, 1, 1);
			fail("列座標が小さすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}

		try {
			board.put(10, 1, 1);
			fail("列座標が大きすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}

		try {
			board.put(1, 0, 1);
			fail("行座標が小さすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}

		try {
			board.put(1, 10, 1);
			fail("行座標が大きすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}
	}

	@Test
	public void testPutValueException() throws Exception {
		try {
			board.put(1, 1, 0);
			fail("値が小さすぎる場合は、例外が発生");
		} catch(IllegalNumber expected) {}

		try {
			board.put(1, 1, 10);
			fail("値が大きすぎる場合は、例外が発生");
		} catch(IllegalNumber expected) {}
	}

	@Test
	public void testGetNumberPositionException() throws Exception {
		try {
			board.getNumber(0, 1);
			fail("列座標が小さすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}

		try {
			board.getNumber(10, 1);
			fail("列座標が大きすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}

		try {
			board.getNumber(1, 0);
			fail("行座標が小さすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}

		try {
			board.getNumber(1, 10);
			fail("行座標が大きすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}
	}

	@Test
	public void testClearPositionException() throws Exception {
		try {
			board.clear(0, 1);
			fail("列座標が小さすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}

		try {
			board.clear(10, 1);
			fail("列座標が大きすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}

		try {
			board.clear(1, 0);
			fail("行座標が小さすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}

		try {
			board.clear(1, 10);
			fail("行座標が大きすぎる場合は、例外が発生");
		} catch(OutOfBoard expected) {}
	}

	@Test
	public void testIsComplete() throws Exception {
		assertFalse(board.isComplete());

	    board.put(1, 1, 1); board.put(2, 1, 4); board.put(3, 1, 7);
	    board.put(4, 1, 2); board.put(5, 1, 5); board.put(6, 1, 8);
	    board.put(7, 1, 3); board.put(8, 1, 6); board.put(9, 1, 9);

	    board.put(1, 2, 2); board.put(2, 2, 5); board.put(3, 2, 8);
	    board.put(4, 2, 3); board.put(5, 2, 6); board.put(6, 2, 9);
	    board.put(7, 2, 1); board.put(8, 2, 4); board.put(9, 2, 7);

	    board.put(1, 3, 3); board.put(2, 3, 6); board.put(3, 3, 9);
	    board.put(4, 3, 1); board.put(5, 3, 4); board.put(6, 3, 7);
	    board.put(7, 3, 2); board.put(8, 3, 5); board.put(9, 3, 8);

	    board.put(1, 4, 4); board.put(2, 4, 7); board.put(3, 4, 1);
	    board.put(4, 4, 5); board.put(5, 4, 8); board.put(6, 4, 2);
	    board.put(7, 4, 6); board.put(8, 4, 9); board.put(9, 4, 3);

	    board.put(1, 5, 5); board.put(2, 5, 8); board.put(3, 5, 2);
	    board.put(4, 5, 6); board.put(5, 5, 9); board.put(6, 5, 3);
	    board.put(7, 5, 4); board.put(8, 5, 7); board.put(9, 5, 1);

	    board.put(1, 6, 6); board.put(2, 6, 9); board.put(3, 6, 3);
	    board.put(4, 6, 4); board.put(5, 6, 7); board.put(6, 6, 1);
	    board.put(7, 6, 5); board.put(8, 6, 8); board.put(9, 6, 2);

	    board.put(1, 7, 7); board.put(2, 7, 1); board.put(3, 7, 4);
	    board.put(4, 7, 8); board.put(5, 7, 2); board.put(6, 7, 5);
	    board.put(7, 7, 9); board.put(8, 7, 3); board.put(9, 7, 6);

	    board.put(1, 8, 8); board.put(2, 8, 2); board.put(3, 8, 5);
	    board.put(4, 8, 9); board.put(5, 8, 3); board.put(6, 8, 6);
	    board.put(7, 8, 7); board.put(8, 8, 1); board.put(9, 8, 4);

	    board.put(1, 9, 9); board.put(2, 9, 3); board.put(3, 9, 6);
	    board.put(4, 9, 7); board.put(5, 9, 1); board.put(6, 9, 4);
	    board.put(7, 9, 8); board.put(8, 9, 2); board.put(9, 9, 5);
	    assertTrue(board.isComplete());
	}

	@Test
	public void testInit() throws Exception {
		String expected =
			"+---+---+---+\n" +
			"|...|...|...|\n" +
			"|...|...|...|\n" +
			"|...|...|...|\n" +
			"+---+---+---+\n" +
			"|...|...|...|\n" +
			"|...|...|...|\n" +
			"|...|...|...|\n" +
			"+---+---+---+\n" +
			"|...|...|...|\n" +
			"|...|...|...|\n" +
			"|...|...|...|\n" +
			"+---+---+---+";
		assertEquals(expected, board.toString());
	}

	@Test
	public void testToString() throws Exception {
		String expected =
			"+---+---+---+\n" +
			"|1..|...|..9|\n" +
			"|...|...|...|\n" +
			"|...|...|...|\n" +
			"+---+---+---+\n" +
			"|...|...|...|\n" +
			"|...|...|...|\n" +
			"|...|...|...|\n" +
			"+---+---+---+\n" +
			"|...|...|...|\n" +
			"|...|...|...|\n" +
			"|...|...|..9|\n" +
			"+---+---+---+";
		board.put(1, 1, 1);
		board.put(9, 1, 9);
		board.put(9, 9, 9);
		assertEquals(expected, board.toString());
	}
}
