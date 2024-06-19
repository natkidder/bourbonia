package com.springinaction.chapter01.knight;

public class KnightOfTheRoundTable  {
	private String name;
	private Quest quest;
	private Minstrel minstrel;

	public KnightOfTheRoundTable(String name) {
		this.name = name;
	}

	public void setQuest(Quest quest)  {
		this.quest = quest;
	}

	public void setMinstrel(Minstel minstrel)  {
		this.minstrel = minstrel;
	}

	public HolyGrail embarkOnQuest() throws QuestFailedException  {
		// minstrel.signBefore(this);  // taken care of in knight.xml -- now the knight need not know about the minstrel
		HolyGrail grail = quest.embark();
		// minstrel.singAfter(this);  // taken care of in knight.xml -- now the knight need not know about the minstrel
		return grail;
	}
}
