<%@ include file="/META-INF/resources/init.jsp" %>

<portlet:actionURL name="sendMessage" var="sendMessage" >
	<portlet:param name="redirect" value="${param.redirect}" />
</portlet:actionURL>

<div class="container-fluid container-fluid-max-xl edit-assignment">
	<aui:form name="frm" action="${sendMessage}" method="post">

		<aui:input name="message" type="text" label="Enter US ZIP">
			<aui:validator name="required" />
			<aui:validator name="maxLength">5</aui:validator>
			<aui:validator name="digits" />
		</aui:input>
		<aui:button-row>
			<aui:button name="Search" value="Search" type="submit"></aui:button>
		</aui:button-row>

	</aui:form>
</div>
