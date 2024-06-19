var xmlhttp;

function showHint(str)
{
	return;  // remove if you want the showHint to actually work
	if (str.length==0)
	{
		document.getElementById("txtHint").innerHTML="";
		return;
	}
	xmlhttp=GetXmlHttpObject();
	if (xmlhttp==null)
	{
		alert ("Your browser does not support XMLHTTP!");
		return;
	}
//	var url="getHint.php";
	var url="GetHint";
	url=url+"?q="+str;
	url=url+"&sid="+Math.random();
	xmlhttp.onreadystatechange=stateChanged;
	xmlhttp.open("GET",url,false);
	xmlhttp.send(null);
}

function stateChanged()
{
if (xmlhttp.readyState==4)
  {
  document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
  }
}

function GetXmlHttpObject()
{
	if (window.XMLHttpRequest)
	{
		// code for IE7+, Firefox, Chrome, Opera, Safari
		return new XMLHttpRequest();
	}
	if (window.ActiveXObject)
	{
		// code for IE6, IE5
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
	return null;
}