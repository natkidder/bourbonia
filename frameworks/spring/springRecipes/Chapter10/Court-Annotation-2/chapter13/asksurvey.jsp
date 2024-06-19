<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

   The United States has an Attorney General,
   a Surgeon General, and a Postmaster General.
   Should it also have a Programmer General?

    <form method="post"
          action="<c:url value="/chapter12/survey.jsp"/>"
          target="_blank">
      <input type="hidden" name="surveyId" value="7" />
      <input type="submit" name="choice" value="Yes" />
      <input type="submit" name="choice" value="No" />
      <input type="submit" name="choice" value="Not sure" />
    </form>
