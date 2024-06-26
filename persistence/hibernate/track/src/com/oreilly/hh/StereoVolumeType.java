package com.oreilly.hh;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

/**
* Manages persistence for the {@link StereoVolume} composite type.
*/
public class StereoVolumeType implements CompositeUserType {

	/**
	* Get the names of the properties that make up this composite type, and that may be used in a query involving it.
	*/
	public String[] getPropertyNames() {
		// Allocate a new response each time, because arrays are normally mutable (changable after being instantiated)
		return new String[] {"left", "right"};
	}

	/**
	* Get the types of the parameters reported by {@link #getPropertyNames}, in the same order.
	*/
	public Type[] getPropertyTypes() {
		return new Type[] { Hibernate.SHORT, Hibernate.SHORT };
	}

	/**
	* Look up the value of one of the properties making up this composite type.
	* @param component a {@link StereoVolume} instance being managed.
	* @param property the index of the desired property.
	* @return the corresponding value.
	* @see #getPropertyNames
	*/
	public Object getPropertyValue(Object component, int property)  {
		StereoVolume volume = (StereoVolume)component;
		short result;

		switch (property) {

			case 0:
			result = volume.getLeft();
			break;

			case 1:
			result = volume.getRight();
			break;

			default:
			throw new IllegalArgumentException("unknown property: " + property);
		}

		return new Short(result);
	}

	/**
	* Set the value of one of the properties making up this composite type.
	*
	* @param component a {@link StereoVolume} instance being managed.
	* @param property the index of the desired property.
	* @object value the new value to be established.
	* @see #getPropertyNames
	*/
	public void setPropertyValue(Object component, int property, Object value)  {
		StereoVolume volume = (StereoVolume)component;
		short newLevel = ((Short)value).shortValue();
		switch (property)  {

			case 0:
			volume.setLeft(newLevel);
			break;

			case 1:
			volume.setRight(newLevel);
			break;

			default:
			throw new IllegalArgumentException("unknown property: " + property);
		}
	}

	/**
	* Determine the class that is returnd by {@link #nullSafeGet}
	* @return {@link StereoVolume}, the actual type returned by {@link #nullSafeGet}.
	*/
	public Class returnedClass()  {
		return StereoVolume.class;
	}

	/**
	* Compare two instances of the class mapped by this type for persistence "equality".
	*
	* @param x first object to be compared.
	* @param y second object to be compared.
	* @return <tt>true</tt> iff both represent the same volume levels
	* @throws ClassCastException if x or y is not a {@link StereoVolume}.
	*/
	public boolean equals(Object x, Object y) {
		if (x == y) { // a trivial success
			return true;
		}
		if (x == null || y == null) { // Don't blow up if either object is null
			return false;
		}
		// Now it's safe to delegate to the object own implementation of equality (see StereoVolume.java)
		return ((StereoVolume)x).equals(y);
	}

	/**
	* Return a deep copy of the persistent state, stopping at entities and collections.
	*
	* @param value the object whose state is to be copied.
	* @return a copy representing the same volume levels as the original.
	* @throws ClassCastException of non- {@link StereoVolume} values.
	*/
	public Object deepCopy(Object value)  {
		if (value == null)
			return null;
		StereoVolume volume = (StereoVolume)value;
		return new StereoVolume(volume.getLeft(), volume.getRight());
	}

	/**
	* Indicates whether objects managed by this type are mutable.
	*
	* @return <tt>true</tt>, since {@link StereoVolume} is mutable (property values can change after its been instantiated).
	*/
	public boolean isMutable() {
		return true;
	}

	/**
	* Retrieve an instance of the mapped class from a JDBC {@link ResultSet}.
	*
	* @param rs the results from which the instance should be retrieved.
	* @param names the colums from which the instance should be retrieved.
	* @param session an extension of th enormal Hibernate session interface that gives you much more access to the internals.
	* @param owner the entiry containg the value being retrieved.
	* @return the retrieved {@link StereoVolume} value, or <tt>null</tt>.
	* @throws SQLException if theres is a problem accessing the database.
	*/
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws SQLException {
		Short left = (Short)Hibernate.SHORT.nullSafeGet(rs, names[0]);
		Short right = (Short)Hibernate.SHORT.nullSafeGet(rs, names[1]);

		if (left == null || right == null) {
			return null;  // We do not have a specified volume for both channels
		}
		return new StereoVolume(left.shortValue(), right.shortValue());
	}

	/**
	* Write an instance of the mapped class to a {@link PreparedStatement}, handling null values.
	*
	* @param pst a JDBC PreparedStatement.
	* @param value the StereoVolume value to write.
	* @param index the parameter index within the prepared statement at which this value is to be written.
	* @param session an extension of the normal Hibernate session interface that gives you much more access to the internals.
	* @throws SQLException if there is a problem accessing the database.
	*/
	public void nullSafeSet(PreparedStatement pst, Object value, int index, SessionImplementor session) throws SQLException {
		if (value == null) {
			Hibernate.SHORT.nullSafeSet(pst, null, index);
			Hibernate.SHORT.nullSafeSet(pst, null, index+1);
		} else {
			StereoVolume volume = (StereoVolume)value;
			Hibernate.SHORT.nullSafeSet(pst, new Short(volume.getLeft()), index);
			Hibernate.SHORT.nullSafeSet(pst, new Short(volume.getRight()), index+1);
		}
	}

	/**
	* Reconstitute a working instance of the managed class from the cache.  
	* A SessionImplementor defines the internal contract between the Session and other parts of Hibernate, such as implementors of Type or EntityPersister. 
	* Serialization enables a composite data type such as StereoVolume to be stored as a collection of simple types (short, in this case) in a database
	*
	* @param cached the serializable version that was in the cache.
	* @param session an extension of the normal Hibernate session interface that gives you much more access to the internals.
	* @param owner the entity containg the value being retrieved.
	* @return a copy of the value as a {@link StereoVolume} instance.
	*/
	public Object assemble(Serializable cached, SessionImplementor session, Object owner) {
		// our value type happens to be serializable, so we don't have to change it to a serializable form, then assemble.
		return deepCopy(cached);
	}

	/**
	* Translate an instance of the managed class into a serializable form to be stored in the cache.
	* Serialization enables a composite data type such as StereoVolume to be stored as a collection of simple types (short, in this case) in a database
	*
	* @param session an extension of the normal Hibernate session interface that gives you much more access to the internals.
	* @param value the StereoVolume value to be cached.
	* @return a serializable copy of the value.
	*/
	public Serializable disassemble(Object value, SessionImplementor session) {
		return (Serializable)deepCopy(value);
	}

	/**
	* Get a hashcode for the instance, consitent with persistence "equality"
	*/
	public int hashCode(Object obj) {
		return obj.hashCode();  // can delegate to our well-behaved object
	}

	/**
	* During merge, replace the existing (target) value in the entity we are merging with a new (original) value from the detached entity we are merging.
	* For immutable objects or null values, it is safe to simply return the first parameter.
	* For mutable objects like this one, it is safe to return a copy of the first parameter.
	* However, since composite user types often define component values, it might make sense to recursively replace component values in the target object.
	*
	* @param original value being merged from
	* @param target value being merged to
	* @param session the hibernate session into which the merge is happening.
	* @param owner the containing entity.
	* @return an independent value that can safely be used in the new contexst.
	*/
	public Object replace(Object original, Object target, SessionImplementor session, Object owner) {
		return deepCopy(original);
	}
}
