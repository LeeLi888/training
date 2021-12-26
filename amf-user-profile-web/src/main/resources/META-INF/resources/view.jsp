<%@ include file="/init.jsp" %>

<%
	//you can change screenName here
	request.setAttribute("screenName", "test");
%>

<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' key="error" />
</liferay-ui:error>

<portlet:renderURL var="userProfileViewURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.PROFILE_VIEW %>" />
	<portlet:param name="screenName" value="${screenName}" />
</portlet:renderURL>

<portlet:renderURL var="userProfileEditURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.PROFILE_EDIT %>" />
	<portlet:param name="screenName" value="${screenName}" />
</portlet:renderURL>

<portlet:renderURL var="userProfilePrivacyURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.PROFILE_PRIVACY %>" />
	<portlet:param name="screenName" value="${screenName}" />
</portlet:renderURL>

<div class="container-fluid container-fluid-max-xl edit-assignment">

	<div style="margin: 30px; text-align: center;">

			<h2>
				User ScreenName: ${screenName}
			</h2>

			<%--Buttons. --%>
			<aui:button-row>
				<aui:button href="${userProfileViewURL}" primary="false"
							value="View" />

				<aui:button href="${userProfileEditURL}" primary="true"
							value="Edit" />

				<aui:button href="${userProfilePrivacyURL}" primary="true"
							value="Privacy" />

			</aui:button-row>

	</div>
</div>


