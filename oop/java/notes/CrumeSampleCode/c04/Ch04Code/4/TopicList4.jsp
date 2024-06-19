<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/questions" prefix="faq"%>
<html>
  <head><title>Topic Questions 4</title></head>
  <body>

    <h1>Topic Questions 4</h1>

    <faq:faqData topic="${param.topic}">
      <p>Question <a href="Questions.jsp?qid=${qid}">${qid}</a>
         ${question}</p>
    </faq:faqData>
    <p>Click a link to get the answer.</p>
  </body>
</html>
