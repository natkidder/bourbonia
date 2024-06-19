<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>

<c:set var="xml">
  <paragraph>
     This document uses <bold>unusual</bold> markup,
     which we want to replace with <bold>HTML</bold>.
  </paragraph>
</c:set>

<c:set var="xsl">
  <?xml version="1.0"?>
  <xsl:stylesheet
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"> 

  <xsl:template match="paragraph">
    <p><xsl:apply-templates/></p>
  </xsl:template>

  <xsl:template match="bold">
    <b><xsl:value-of select="."/></b>
  </xsl:template>

  </xsl:stylesheet>
</c:set>

<x:transform xml="${xml}" xslt="${xsl}"/>

