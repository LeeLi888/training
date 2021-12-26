<%@ include file="/init.jsp" %>

<div class="container-fluid container-fluid-max-xl edit-assignment">

	<h2>
		<liferay-ui:message key="search-result-title" arguments="${zipCode}"/>
	</h2>

	<!-- search container -->
	<liferay-ui:search-container
			emptyResultsMessage="search-result-empty"
			cssClass="amf-search-container"
			delta="5"
			total="${memberCount}">
		<liferay-ui:search-container-results results="${members}" />
		<liferay-ui:search-container-row
				className="com.amf.search.results.model.Member"
				modelVar="entry">

			<liferay-ui:search-container-column-text>
				${entry.lastName} ${entry.firstName} (${entry.screenName}) - ${entry.emailAddress}
			</liferay-ui:search-container-column-text>

		</liferay-ui:search-container-row>

		<%-- Iterator / Paging --%>
		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>

</div>
