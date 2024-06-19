package com.springinaction.chapter01.knight;

import junit.framework.TestCase;

public class KnightOfTheRoundTableTest extends TestCase  {
	
	public void testEmbarkOnQuest() throws GrailNotFoundException  {
		KnightOfTheRoundTable knight = new KnightOfTheRoundTable("Beldivere");
		HolyGrail grail = knight.embarkOnQuest();

		assertNotNull(grail);
		assertTrue(grail.isHoly());
	}
}
