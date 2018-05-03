<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="greateq.web.misc.Max"%>
<%@ page import="greateq.web.console.util.*"%>

<%

String sMsg=GenAPI.x_toString(request.getParameter("sMsg"),"");
String sAction=GenAPI.x_toString(request.getParameter("sAction"),"");

List<Integer> maxNumbers = Max.generateMax();
if ("GENERATE".equals(sAction)){
	//TODO: may do something later
	//maxNumbers= Max.generateMax();
}
%>
<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
<META HTTP-EQUIV="Expires" CONTENT="0">
<TITLE>Max</TITLE> 
<LINK href="<%=request.getContextPath()%>/console/css/adminconsole.css" rel="stylesheet" type="text/css"/>
<SCRIPT type="text/javascript" LANGUAGE="javascript" src="<%=request.getContextPath()%>/console/js/list_edit.js"></SCRIPT>
<script type="text/javascript" LANGUAGE="javascript">
//<!--

function CheckInput()
{
	frmAction.sAction.value='GENERATE';
}

function window_onload() {
	if("<%=sMsg%>">"")
		alert("<%=(sMsg)%>")
}

//-->
</script>
</head>
                                  
<body CLASS="content"  leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="return window_onload()"> 

  <TABLE WIDTH="98%" CELLPADDING="0" CELLSPACING="0" BORDER="0" class="portalPage">
      <TR>
          <TD CLASS="pageTitle">Greateq Console
          </TD>
      </TR>
  </TABLE>

  <TABLE WIDTH="98%" CELLPADDING="0" CELLSPACING="0" BORDER="0" CLASS="wasPortlet">
	<TR>
	<TH class="wpsPortletTitle" width="100%">Max</TH>
	</TR>

	<TBODY ID="wasUniPortlet">
	<TR>   
	  <TD CLASS="wpsPortletArea" COLSPAN="3" >
        <h1 id="title-bread-crumb"><a href='max.jsp'>Max</a></h1>
        <p class="instruction-text">Use this page to get a set of numbers.</p>
        
		<table border="0" cellpadding="0" cellspacing="0"  width="100%" >
			<tr valign="top"> 
			    <td class="tabs-on" width="1%" nowrap height="12"> Details  </td>
		    	<td class="blank-tab" width="99%" nowrap height="12">
		        	<img src="<%=request.getContextPath()%>/console/images/onepix.gif" width="1" height="10" align="absmiddle" alt="">
		    	</td>
			</tr>
		</table>

		<table border="0" cellpadding="10" cellspacing="0" valign="top" width="100%" summary="Framing Table">
			<tr> 
				<td class="layout-manager">
					<TABLE WIDTH="100%" BORDER="0" CELLPADDING="5" cellspacing="10">
					   <TR>
					   	<TD VALIGN="top">
					   		<h2>General Properties</H2>  

							<form name="frmAction"  action="<%=request.getRequestURI()%>" method=post language="javascript" onsubmit="return CheckInput();">
								<table class="framing-table" border="0" cellpadding="5" cellspacing="0" width="100%" summary="Properties Table" >
									<tr valign="top">
								        <td class="table-text"  scope="row" valign="top"width="60%" >
								        <%
										for (Integer i:maxNumbers){
											out.print(i+" : ");
										}
								        
								        %>
								        </TD>
								        <TD class="navigation-button-section"  align="middle" vAlign="center" width="40%" ><INPUT type="submit" id=btnOK name=btnOK value=" Generate " class="buttons"></TD>
								   	</TR>
								</table>
								<INPUT id=sAction name=sAction type=hidden value="<%=sAction%>">
							</form>    
      					</TD>
      
					</TR>   
				</TABLE> 

			</td> 
		</tr>
	</table>
 	</td>
 	</tr>
  </TBODY>
</table>
 </body>
 </html>
