<%@ include file="init.jsp"%>

<portlet:renderURL var="registFormURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.REGIST_FORM %>" />
</portlet:renderURL>

<div class="container-fluid container-fluid-max-xl edit-assignment">

		<div style="margin: 30px; text-align: center;">
			<%--Buttons. --%>
			<aui:button-row>
				<aui:button href="${registFormURL}" primary="true"
							value="signup-button-value" />
			</aui:button-row>
		</div>
</div>
