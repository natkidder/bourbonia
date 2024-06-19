package com.oreilly.hh;

import java.io.Serializable;

/**
* A simple structure encapsulating a stereo volume level
*/

public class StereoVolume implements Serializable  {

	/** The minimum legal volume level. */
	public static final short MINIMUM = 0;

	/** The maximum legal volume level. */
	public static final short MAXIMUM = 100;

	/** Stores the volume of the left channel. */
	private short left;

	/** Stores the volume of the right channel. */
	private short right;

	/** Default constructor sets full volume in both channels. */
	public StereoVolume() {
		this(MAXIMUM, MAXIMUM);
	}

	/** Constructor that establishes specific volume levels. */
	public StereoVolume(short left, short right) {
		setLeft(left);
		setRight(right);
	}

	/**
	* Helper method to make sure a volume value is legal.
	* @param volume the level that is being set.
	* @throws IllegalArgumentException if it is out of range.
	*/
	private void checkVolume(short volume)  {
		if (volume < MINIMUM) {
			throw new IllegalArgumentException("volume cannot be less than " + MINIMUM);
		} 
		if (volume > MAXIMUM)  {
			throw new IllegalArgumentException("volume cannote be more than " + MAXIMUM);
		}
	}

	/** Set the volume of the left channel. */
	public void setLeft(short volume)  {
		checkVolume(volume);
		this.left = volume;
	}

	/** Set the volume of the right channel. */
	public void setRight(short volume)  {
		checkVolume(volume);
		this.right = volume;
	}

	/** Get the volume of the left channel. */
	public short getLeft() {
		return left;
	}

	/** Get the volume of the right channel. */
	public short getRight() {
		return right;
	}

	/** Format a readable version of the volume levels, for debugging. */
	public String toString() {
		return "Volume[left = " + left + ", right = " + right + "]";
	}

	/** 
	* Compare whether another object is equal to this one.
	* @param obj the object to be compared.
	* @return true if obj is also a StereoVolume instance, and represents the same volume levels.
	*/
	public boolean equals(Object obj)  {
		if (obj instanceof StereoVolume) {
			StereoVolume other = (StereoVolume)obj;
			return other.getLeft() == getLeft() && other.getRight() == getRight();
		}
		return false;  // it was not a StereoVolume
	}

	/**
	* Returns a hash code for the StereoVolume.  This method MUST be consistent with the {@link #equals} method.
	* The number itself is meaningless by itself--just a unique value encapsulating the two left & right values.
	*/
	public int hashCode() {
		return (int)getLeft() * MAXIMUM * 10 + getRight();
	}
}
