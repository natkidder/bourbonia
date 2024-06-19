<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/simplequestions" prefix="faq"%>
<html>
  <head><title>Topic Questions 2</title></head>
  <body>
  
    <h1>Topic Questions 2</h1>

    <faq:simplelist topic="${param.topic}">
      <p>Question <a href="Questions.jsp?qid=${qid}">${qid}</a>
      ${question}</p>
    </faq:simplelist>
    <p>Click a link to get the answer.</p>
  </body>
</html>
