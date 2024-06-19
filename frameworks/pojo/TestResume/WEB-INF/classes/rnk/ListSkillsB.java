package rnk;

import java.util.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class ListSkillsB extends BodyTagSupport  {

	private ArrayList<Skill> skills = new ArrayList<Skill>();

	Iterator iterator;
	private String sTest;  private String sTest2;
	private int i = 0;   ////
	private Integer j = 0;

	public int doStartTag() throws JspTagException {  // process/evaluate the start tag
		skills.clear();
	    skills = ListSkills.populateSkills(skills, "B");
	    iterator = skills.iterator();
		if ( iterator.hasNext() )  {
			this.setVariables();
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}

	public int doAfterBody() throws JspTagException  {
        if ( iterator.hasNext() )  {
			this.setVariables();
			return EVAL_BODY_BUFFERED;
		} else {
			return SKIP_BODY;
		}
	}

	public int doEndTag() throws JspTagException  {
		// allow it to evaluate the rest of the page
		return EVAL_PAGE;
	}

	void setVariables()  {
		Skill skill;
		skill = (Skill)iterator.next();
		pageContext.setAttribute( "skill1", skill.getSkill1() );
		pageContext.setAttribute( "level1", skill.getLevel1() );
		pageContext.setAttribute( "experience1", skill.getExperience1() );
		pageContext.setAttribute( "skill2", skill.getSkill2() );
		pageContext.setAttribute( "level2", skill.getLevel2() );
		pageContext.setAttribute( "experience2", skill.getExperience2() );
	}

}
