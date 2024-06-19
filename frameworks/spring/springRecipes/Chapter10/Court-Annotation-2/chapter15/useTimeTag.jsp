<%@ taglib prefix="book" uri="/WEB-INF/book.tld" %>

<book:ifTime day="sunday" after="21" before="22">
  "Alias" is on right now on ABC.  What are you doing
  browsing the web?
</book:ifTime>

<book:ifTime day="sunday" after="3" before="4">
  Our site conducts routine maintenance between
  3:00 a.m. and 4:00 a.m. on Sundays.  During this
  time, some services may be unavailable.  We apologize
  for the inconvenience.
</book:ifTime>

