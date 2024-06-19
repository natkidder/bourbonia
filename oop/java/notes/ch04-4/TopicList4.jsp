<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!-- the uri (universal resource identifier) is the tag library in web.xml, and the prefix is the <prefix: -->

<%@ taglib uri="/questionsLib" prefix="faq4" %>

<html>
	<head><title>Topic Questions 4</title></head>
	<body>
		<h1>Topic Questions 4</h1>
		
		<faq4:faqData topic="${param.topic}">
			<p>Question <a href="Questions.jsp?qid=${qid}">${qid}</a>
				${question}<p>
		</faq4:faqData>
		<p>Click a link to get the answer.</p>
	</body>
</html>
