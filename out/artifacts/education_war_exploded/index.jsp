<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: 1--%>
<%--  Date: 18.04.2022--%>
<%--  Time: 18:17--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--&lt;%&ndash;<%@ page contentType="text/html;charset=UTF-8" language="java" %>&ndash;%&gt;--%>
<%--&lt;%&ndash;<html>&ndash;%&gt;--%>
<%--&lt;%&ndash;<head>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <title>$Title$</title>&ndash;%&gt;--%>
<%--&lt;%&ndash;</head>&ndash;%&gt;--%>
<%--&lt;%&ndash;<body>&ndash;%&gt;--%>
<%--&lt;%&ndash;<h2>Hello World!</h2>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href="hello">Hello Father</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;<br>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href="BD.jsp">This your Node</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href="Base">This your Node</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href="/Base">Хуй</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</body>&ndash;%&gt;--%>
<%--&lt;%&ndash;</html>&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Node</title>
</head>
<body>
<h2>Notes</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
    <tr><th>Sentence</th><th>importance</th><th></th></tr>
    <c:forEach var="sentences" items="${sentences}">
        <tr><td>${sentences.sentence}</td>
            <td>${sentences.importance}</td>

            <td>
                <a href='<c:url value="/edit?id=${sentences.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${sentences.id}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>
</body>
</html>
