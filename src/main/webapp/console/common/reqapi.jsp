<%!
String getFromDate(HttpServletRequest request)
{
    String fromDate=request.getParameter("fromYear")
                    +"."+(Integer.parseInt(request.getParameter("fromMonth"))+1)
                    +"."+request.getParameter("fromDate");
    return fromDate;
}
String getToDate(HttpServletRequest request)
{
    String toDate=request.getParameter("toYear")
                 +"."+(Integer.parseInt(request.getParameter("toMonth"))+1)
                    +"."+request.getParameter("toDate");
    return toDate;
}

//�жϵ�ǰ״̬
//0:�ǿ��У��ǽ��㣻1:���У�2������
//-1.����
int getMarketStatus(Connection cn)
{
    int ret=0;
    String sql="exec MQ_STATUS 0";
    String[][] aList=DBAPI.getList(cn,sql,0,0);
    if(aList==null) return -1;
    else if(aList.length==0) return -1;
    else if(aList[0][0].equals("1"))
        return 1;//����

    sql="exec MQ_STATUS 1";
    aList=DBAPI.getList(cn,sql,0,0);
    if(aList==null) return -1;
    else if(aList.length==0) return -1;
    else if(aList[0][0].equals("1"))
        return 2;//����
    return 0;
}

String[][] getYearArray()
{
    Calendar today=Calendar.getInstance();
    String[][] aYear=new String[10][2];
    for(int i=0;i<10;i++)
    {
        aYear[i][0]=Integer.toString(today.get(today.YEAR)-2+i);
        aYear[i][1]=Integer.toString(today.get(today.YEAR)-2+i);
    }

    return aYear;

}
String[][] getMonthArray()
{
    String[][] aMonth=new String[12][2];
    for(int i=0;i<12;i++)
    {
        aMonth[i][0]=Integer.toString(i);
        aMonth[i][1]=Integer.toString(i+1);
    }
    return aMonth;
}
String[][] getDateArray()
{
    String[][] aDate=new String[31][2];
    for(int i=0;i<31;i++)
    {
        aDate[i][0]=Integer.toString(i+1);
        aDate[i][1]=Integer.toString(i+1);
    }
    return aDate;
}
String getMoneyAccount(String department,String account)
{
    if(account.length()>8) return account;
    while(account.length()<8)
        account="0"+account;

    account=department+account;
    return account;

}

String getShowDateHtml(int year,int month,int date,boolean isTrading,String pre)
{
    return com.genweb.util.ServerletAPI.getShowDateHtml(year,month,date,isTrading,pre);
/*
    StringBuffer sb=new StringBuffer();
    if(isTrading)
    {
        sb.append(year);
        sb.append("��");
        sb.append(month+1);
        sb.append("��");
        sb.append(date);
        sb.append("��");

        sb.append("<input type=hidden name=");
        sb.append(pre);
        sb.append("Year value=");
        sb.append(year);
        sb.append(">");

        sb.append("<input type=hidden name=");
        sb.append(pre);
        sb.append("Month value=");
        sb.append(month);
        sb.append(">");

        sb.append("<input type=hidden name=");
        sb.append(pre);
        sb.append("Date value=");
        sb.append(date);
        sb.append(">");
    }
    else
    {
        sb.append(GenAPI.getSelectHtml(pre+"Year",getYearArray(),Integer.toString(year),1));
        sb.append("��");

        sb.append(GenAPI.getSelectHtml(pre+"Month",getMonthArray(),Integer.toString(month),1));
        sb.append("��");

        sb.append(GenAPI.getSelectHtml(pre+"Date",getDateArray(),Integer.toString(date),1));
        sb.append("��");
    }
    return sb.toString();
    */
}

//tdLength:����
//flag:1STAT;0:QUERY
void showList(javax.servlet.jsp.JspWriter out,Vector columnNames,String[][] aList,String tdLength,int flag) throws Exception
{
    com.genweb.util.ServerletAPI.showList(out,columnNames,aList,tdLength,flag);
/*    out.println("<div align=center>");
    if(aList==null)//ͳ����Ϣ
    {
        out.println("δ�ҵ����ʼ�¼��");
    }
    else if(aList.length==0)//ͳ����Ϣ
    {
        out.println("δ�ҵ����ʼ�¼��");

    }
    else if(flag==1)//ͳ����Ϣ
    {
        out.println("���м�¼"+aList[0][0]+"�ʣ����ʽ����"+aList[0][1]);
    }
    else if(aList.length==1 && aList[0].length==1)//��������
    {
        if(Long.parseLong(aList[0][0])==-999)
        {
            out.println("��ѯ������࣬�����¹����ѯ������");
        }
    }
    else//������ʾ�б�
    {
        out.println("<TABLE border=1 cellPadding=1 cellSpacing=1 width=650 bgcolor=Ivory>");
        out.println("<TR bgcolor=SteelBlue>");
        for(int i=0;i<columnNames.size();i++)
//            out.println("<TD align=center width="+tdLength+"><B>"+columnNames.get(i)+"</B></TD>");
            out.println("<TD align=center><B>"+columnNames.get(i)+"</B></TD>");

        out.println("</TR>");

        if(aList!=null)
        {
            for(int i=0;i<aList.length;i++)
            {
                out.println("<TR bgcolor=MintCream>");

                for(int j=0;j<aList[0].length;j++)
                {
                    if(aList[i][j]==null)
                        out.println("<TD>&nbsp;</TD>");
                    else if(aList[i][j].equals(""))
                        out.println("<TD>&nbsp;</TD>");
                    else
                        out.println("<TD>"+aList[i][j]+"</TD>");
                }

                out.println("</TR>");
            }
            out.println("</TABLE>");
        }
        out.println("���м�¼"+aList.length+"��");
    }
    out.println("<p>");
    out.println("<input type=button name=\"btnPrint\" value=\"��ӡ\" onclick=\"return btnPrint_onclick();\">");
    out.println("<input type=button name=\"btnReturn\" value=\"����\" onclick=\"history.back();\">");
    out.println("</div>");
    return;
    */
}

String getMaskString()
{
    return "YSY,ZY,STKH,GTEL,DKLC,GOOD,DKLC2,JGB,ZJB,SX,QT";
}
%>
