package rnk;

import java.util.*;
import java.io.*;

public class ListSkills {

	static Iterator iterator;
	private static String sTest;  
	private static String sTest2;
	private static int i = 0;   ////
	private static Integer j = 0;

	public static ArrayList<Skill> populateSkills(ArrayList<Skill> arSkills, String dataStore) {
		String[] skillProperties;
		Skill skill;
		String[] sSkills;
		try {
		    sTest = "in populateSkills";
			if (dataStore.equals("A"))  {
				sSkills = DataStore.getSkillsA();
			} else {  // B
				sSkills = DataStore.getSkillsB();
			}
			for ( String s : sSkills )  {
				j++;  sTest = j.toString();
				skillProperties = s.split( "\\|" );
				skill = new Skill();
				//System.out.println( line );  ////
				skill.setSkill1( skillProperties[0].trim() );
				skill.setLevel1( skillProperties[1].trim() );
				skill.setExperience1( skillProperties[2].trim() );
				skill.setSkill2( skillProperties[3].trim() );
				skill.setLevel2( skillProperties[4].trim() );
				skill.setExperience2( skillProperties[5].trim() );
				arSkills.add( skill );
			}
			return arSkills;

		}
		catch ( Exception e )  {
			System.out.println(e.getMessage());
			arSkills.clear();
			return arSkills;
		}
	}
}
