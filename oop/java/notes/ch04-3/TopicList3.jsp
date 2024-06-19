<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!-- the uri (universal resource identifier) is the tag library in web.xml, and the prefix is the <prefix: -->

<%@ taglib uri="/questions" prefix="faq2" %>  <%-- faq2 here is the action namespace given below --%>

<html>
	<head><title>Topic Questions</title></head>
	<body>
	<%-- no Java scriptlets -- ListQuestions does all the business logic --%>
		<h1>Topic Questions</h1>

		<faq2:listFaqs topic="${param.topic}">
		</faq2:listFaqs>
	</body>
</html>
