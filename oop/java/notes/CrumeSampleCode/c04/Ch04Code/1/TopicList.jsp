<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head><title>Topic Questions</title></head>
  <body>
    <h1>Topic Questions</h1>

    <jsp:useBean id="questions" class="Ch04.Questions">
      <jsp:setProperty name="questions" property="topic" />
    </jsp:useBean>

The number of questions in topic ${questions.topic} is ${questions.numTopics}
<%
  for (int i = 1; i <= questions.getNumTopics(); i++) {
    pageContext.setAttribute("count", ""+i);
%>
<p>Question <a href="Questions.jsp?qid=${questions.topic}_${count}">
   ${questions.topic}_${count}</a>: 
   ${questions.questions[count]}
<%
  }
%>
  </body>
</html>
