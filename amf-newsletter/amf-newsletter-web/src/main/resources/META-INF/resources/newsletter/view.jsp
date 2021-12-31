<%@ include file="/init.jsp" %>

<div class="container-fluid container-fluid-max-xl container-newsletter">

    <p class="issue-date">
        Issue: #${newsletter.issueNumber}, <fmt:formatDate value="${newsletter.issueDate}" pattern="yyyy-MM-dd"/>
    </p>
    <h2>
        ${newsletter.title}
    </h2>
    <p class="byline">
        ${byline}
    </p>
    <p class="description">
        ${newsletter.description}
    </p>

    <ul class="articles">
        <c:forEach items="${articles}" var="article">
            <li>
                <h3>
                    ${article.title}
                </h3>
                <p>
                    ${article.content}
                </p>
            </li>
        </c:forEach>
    </ul>

</div>
