<%@ include file="/init.jsp" %>

<div class="container-fluid container-fluid-max-xl container-newsletter container-newsletterr-result">

	<portlet:renderURL var="searchURL">
	</portlet:renderURL>

	<aui:form action="${searchURL}" method="post">

		<aui:row>
			<aui:col span="8">
				<aui:input name="keyword" value="${keyword}" label="" placeholder="Please input search keywords.">
					<aui:validator name="required" />
				</aui:input>
			</aui:col>
			<aui:col span="4">
				<aui:button type="submit" value="Search" primary="false" />
			</aui:col>
		</aui:row>

		<h1>
			Search Result for: <label>${keyword}</label>
		</h1>

		<%
			String keyword = (String)request.getAttribute("keyword");
			PortletURL iteratorURL = renderResponse.createRenderURL();
			iteratorURL.setParameter("keyword", keyword);
		%>

		<!-- search container -->
		<liferay-ui:search-container
				emptyResultsMessage="search-result-empty"
				cssClass="amf-search-container"
				delta="5"
				iteratorURL="<%=iteratorURL%>"
				total="${count}">
			<liferay-ui:search-container-results results="${entries}" />
			<liferay-ui:search-container-row
					className="com.amf.newsletter.model.Newsletter"
					modelVar="entry">

				<liferay-ui:search-container-column-text>


					<a href="/newsletter/-/article-issue/${entry.issueNumber}" class="search-result-link">
						<p class="issue-date">
							Issue: #${entry.issueNumber}, <fmt:formatDate value="${entry.issueDate}" pattern="yyyy-MM-dd"/>
						</p>
						<h2>
								${entry.title}
						</h2>
					</a>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<%-- Iterator / Paging --%>
			<liferay-ui:search-iterator markupView="lexicon" />
		</liferay-ui:search-container>

	</aui:form>
</div>


