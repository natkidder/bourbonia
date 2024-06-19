package rnk;

import java.util.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class test {

	private ArrayList<Reference> references = new ArrayList<Reference>();
	private Iterator iterator;

	public static void main(String[] args)   {

		test testVar = new test();
		testVar.populateRefs();

		testVar.iterator = testVar.references.iterator();
		Reference reference;
		while ( testVar.iterator.hasNext() )  {
			reference = (Reference)testVar.iterator.next();
			System.out.println( reference.getName() );
			System.out.println( reference.getCompany() );
			System.out.println( reference.getTitle() );
			System.out.println( reference.getPhoneType() );
			System.out.println( reference.getPhoneNbr() );
			System.out.println( reference.getEmail() );
			System.out.println( reference.getRelationship() + "\n" );
		}
	}

	void populateRefs() {
		String[] refProperties;
		Reference reference;
		String[] sRefs = DataStore.getReferences();
//		sRefs = { "a|b", "c|d" };
//		sRefs = {"Dan Zipper|ComputerAid, Inc.|Business Manager|C|703-867-3958|Dan_Zipper@notes.compaid.com|Supervisor at America Online","Chris Wheeler|America Online|Senior System Administrator|C|801-698-0371|chris.wheeler@corp.aol.com|Team Lead at America Online"};
		for ( String line : sRefs )  {
			refProperties = line.split( "\\|" );
			reference = new Reference();
			//System.out.println( line );  ////
			reference.setName( refProperties[0] );
			reference.setCompany( refProperties[1] );
			reference.setTitle( refProperties[2] );
			reference.setPhoneType( refProperties[3] );
			reference.setPhoneNbr( refProperties[4] );
			reference.setEmail( refProperties[5] );
			reference.setRelationship( refProperties[6] );
			references.add( reference );
		}
	}
}
