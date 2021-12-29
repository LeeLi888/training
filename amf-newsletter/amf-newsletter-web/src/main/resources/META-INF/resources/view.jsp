<%@ include file="/META-INF/resources/init.jsp" %>

<div class="container-fluid container-fluid-max-xl container-newsletter">

	<!-- tabs -->
	<liferay-ui:tabs names="${fn:join(years, ',')}" param="curTab" value="${curTab}">
	</liferay-ui:tabs>

	<c:if test="${empty list}">
		<p>
			No data.
		</p>
	</c:if>

	<ul class="newletter-months">
		<c:forEach items="${list}" var="month">
			<li>
				<h1>
					<liferay-ui:message key="month-${month.month}"/>
				</h1>

				<ul class="newsletter-group">
					<c:forEach items="${month.newsletterGroups}" var="group">

						<portlet:renderURL var="renderURL">
							<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.NEWLETTER_VIEW %>" />
							<portlet:param name="issueNumber" value="${group.newsletter.issueNumber}" />
						</portlet:renderURL>

						<li>
							<a href="${renderURL}">
								<p>
									Issue: #${group.newsletter.issueNumber}, <fmt:formatDate value="${group.newsletter.issueDate}" pattern="yyyy-MM-dd"/>
								</p>
								<h2>
									${group.newsletter.title}
								</h2>

								<ul class="articles">
									<c:forEach items="${group.articles}" var="article">
										<li>
											<h3>
												${article.title}
											</h3>
										</li>
									</c:forEach>
								</ul>
							</a>
						</li>
					</c:forEach>
				</ul>
			</li>
		</c:forEach>
	</ul>

</div>
