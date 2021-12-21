<%@ include file="./init.jsp" %>

<div class="container-fluid container-fluid-max-xl edit-assignment">
<%
	String curTab = ParamUtil.getString(request, "curTab");
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("curTab", curTab);
%>
	<!-- tabs -->
	<liferay-ui:tabs names="All,Registration,Login" param="curTab" value="${curTab}">
	</liferay-ui:tabs>

	<!-- search container -->
	<liferay-ui:search-container
			emptyResultsMessage="no-events"
			id="eventEntries"
			curParam="cur"
			deltaParam="delta"
			iteratorURL="<%=iteratorURL%>"
			cssClass="amf-search-container"
			total="${eventCount}">
		<liferay-ui:search-container-results results="${events}" />
		<liferay-ui:search-container-row
				className="com.amf.event.monitor.model.Event"
				modelVar="entry">

			<%@include file="/event/entry_columns.jspf"%>

		</liferay-ui:search-container-row>

		<%-- Iterator / Paging --%>
		<liferay-ui:search-iterator
				markupView="lexicon" />
	</liferay-ui:search-container>

</div>
