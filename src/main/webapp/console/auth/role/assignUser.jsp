<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.sql.*"%>
<%@ page import="greateq.web.console.util.*"%>
<%@ page import="greateq.web.console.dao.AdminUserDAO"%>
<%@ page import="greateq.web.console.dao.AdminRoleDAO"%>
<%@ page import="greateq.web.console.domain.AdminRole"%>

<%

Connection cn=ConnPool.getInstance().getConnection();
AdminUserDAO userDao= new AdminUserDAO(cn);
AdminRoleDAO roleDao= new AdminRoleDAO(cn);

String sMsg="";
int iNext=0;
String sAction="",ID="";


ID=GenAPI.x_toString(request.getParameter("ID"),"0");
Long id= Long.parseLong(ID);
sMsg=GenAPI.x_toString(request.getParameter("sMsg"),"");
sAction=GenAPI.x_toString(request.getParameter("sAction"),"");

AdminRole role=roleDao.selectById(id);

Long[] assignedUserIds=GenAPI.string2Long(request.getParameterValues("lstSeleted"));

if ("GRANT".equals(sAction)){
	roleDao.assignUsers(id, assignedUserIds);
	iNext=2;
}


switch(iNext)
{
  case 2:	//go to list.jsp
    response.sendRedirect("list.jsp");


//	out.println("OK");
		break;
  case 1: //current page.show err message.��ǰҳ����ʾ������Ϣ
//    out.println("path:"+request.getServletPath());

}
%>
<html>
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
<META HTTP-EQUIV="Expires" CONTENT="0">
<TITLE>Detail Page</TITLE> 
<LINK href="<%=request.getContextPath()%>/console/css/adminconsole.css" rel="stylesheet" type="text/css"/>
<SCRIPT type="text/javascript" LANGUAGE="javascript" src="<%=request.getContextPath()%>/console/js/list_edit.js"></SCRIPT>
<script type="text/javascript" LANGUAGE="javascript">
<!--

function CheckInput()
{
	var obj=document.frmAction.lstSeleted;
	
	for (var i=0; i<obj.options.length; i++) {
	    obj.options[i].selected = true;
	}	
	
	return true;
}

function btnAssign_onclick() {
	if (!CheckInput()) return false;
	frmAction.sAction.value='GRANT';
	frmAction.submit()

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
	<TH class="wpsPortletTitle" width="100%">Role Management</TH>
	</TR>

	<TBODY ID="wasUniPortlet">
	<TR>   
	  <TD CLASS="wpsPortletArea" COLSPAN="3" >
        <h1 id="title-bread-crumb"><a href='list.jsp'>Role Management</a> > <%=role.getName() %></h1>
        <p class="instruction-text">Use this page to edit the Details.</p>
        
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

							<form name="frmAction"  action="<%=request.getRequestURI()%>" method=post language=javascript onsubmit="return CheckInput()">
								<table class="framing-table" border="0" cellpadding="5" cellspacing="0" width="100%" summary="Properties Table" >
								    <TR>
								        <TD class="table-text"  scope="row" valign="top" width=20% >Roles:</TD>
								        <TD class="table-text"  scope="row" valign="top" width=80% >
											<table border="0" width="100%">
												<tr>
													<td width="40%">Granted:</td>
													<td width="20%">��</td>
													<td width="40%">Available:</td>
												</tr>
												<tr>
													<td width="40%">
								      					<SELECT id="lstSeleted" name="lstSeleted" multiple="multiple" size=10 style="height: 141; width: 150"   LANGUAGE=javascript  ondblclick="return lstSeleted_ondblclick()" >
														<%=GenAPI.getOptionsHtml(userDao.getAssignedUserListByRoleId(id),"")%>
														</SELECT>
													</td>
													<td width="20%">
								      					<P align="center"><INPUT id=btnGrant name=btnGrant style="WIDTH: 80px" type=button value="&lt;"  LANGUAGE=javascript onclick="return btnGrant_onclick()"></P>
								      					<P align="center"><INPUT id=btnGrantAll name=btnGrantAll style="WIDTH: 80px" type=button value="&lt;&lt;"  LANGUAGE=javascript onclick="return btnGrantAll_onclick()"></P>
								      					<P align="center"><INPUT  id=btnRevoke name=btnRevoke style="WIDTH: 80px" type=button value="&gt;"  LANGUAGE=javascript onclick="return btnRevoke_onclick()"></P>
								      					<P align="center"><INPUT  id=btnRevokeAll name=btnRevokeAll style="WIDTH: 80px" type=button value="&gt;&gt;"  LANGUAGE=javascript onclick="return btnRevokeAll_onclick()"></P>
									   				</td>
													<td width="40%">
										  				<SELECT id="lstUnSeleted" name="lstUnSeleted" multiple="multiple" size=10 style="height: 141; width: 150"   LANGUAGE=javascript ondblclick="return lstUnSeleted_ondblclick()">
														<%=GenAPI.getOptionsHtml(userDao.getAvailableUserListByRoleId(id),"")%>
											            </SELECT>
													</td>
												</tr>
											</table>
								        </TD>
								   </TR>
								   
									<tr>
										<td class="navigation-button-section" nowrap align="middle" vAlign=center colspan=4>
											<INPUT type="button" id=btnOK name=btnOK value=" OK " class="buttons" onclick="return btnAssign_onclick()">
											&nbsp;&nbsp;&nbsp;&nbsp;
											<INPUT type="button" value="Cancel" id=btnCancel name=btnCancel  class="buttons" onclick="return btnCancel_onclick()">
								        </td>
								    </tr>
								</table>
								<INPUT id=sAction name=sAction type=hidden value="<%=sAction%>">
								<INPUT id=ID name=ID type=hidden value="<%=ID%>">
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
<%cn.close();%>