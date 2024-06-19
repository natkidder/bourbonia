<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

  <li>
       <c:if test="${param.excludeLink != 'true'}">
         <a href="<c:url value="/chapter${param.chapter}/${param.file}"/>">
       </c:if>
        <c:out value="${param.file}"/>
       <c:if test="${param.excludeLink != 'true'}">
        </a>
       </c:if>
      (<a href=
         "<c:url value="/source.jsp">
           <c:param name="filename"
                    value="/chapter${param.chapter}/${param.file}"/>
          </c:url>"
       />view source</a>): <c:out value="${param.desc}" escapeXml="false"/>
