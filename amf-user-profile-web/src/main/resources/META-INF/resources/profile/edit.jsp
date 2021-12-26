<%@ include file="/init.jsp" %>

<div class="container-fluid container-fluid-max-xl container-userprofile">

	<h1>
		Edit Profile
	</h1>

	<portlet:actionURL var="actionURL" name="<%=MVCCommandNames.PROFILE_ACTION_UPDATE %>">
		<portlet:param name="redirect" value="${MVCCommandNames.PROFILE_VIEW}" />
	</portlet:actionURL>

	<aui:form action="${actionURL}" name="fm" method="post">
		<aui:fieldset label="Basic Info">
			<aui:row>
				<aui:col span="4">
					<aui:input label="First Name" name="firstName" value="${userProfile.basicInfo.firstName}">
						<aui:validator name="required" />
					</aui:input>
				</aui:col>
				<aui:col span="4">
					<aui:input label="Last Name" name="lastName" value="${userProfile.basicInfo.lastName}">
						<aui:validator name="required" />
					</aui:input>
				</aui:col>
				<aui:col span="4">
					<aui:select label="Gender" name="gender" required="true">
						<aui:option label="Male" value="0" selected="${(userProfile.basicInfo.male == true)?'true':'false'}" />
						<aui:option label="FeMale" value="1" selected="${(userProfile.basicInfo.male == true)?'false':'true'}" />
					</aui:select>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="12">
					<fmt:formatDate value="${userProfile.basicInfo.birthday}" var="b_year" type="date" pattern="yyyy" />
					<fmt:formatDate value="${userProfile.basicInfo.birthday}" var="b_month" type="date" pattern="MM" />
					<fmt:formatDate value="${userProfile.basicInfo.birthday}" var="b_day" type="date" pattern="dd" />

					<div class="form-group">
						<label class="control-label">Birthday</label>
						<liferay-ui:input-date name="birthday"
											   required="true"
											   yearValue="${b_year}"
											   yearParam="b_year"
											   monthValue="${b_month}"
											   monthParam="b_month"
											   dayValue="${b_day}"
											   dayParam="b_day"
						>
						</liferay-ui:input-date>
					</div>

				</aui:col>
			</aui:row>
		</aui:fieldset>

		<aui:fieldset label="General Information">
			<aui:row>
				<aui:col span="12">
					<aui:input label="About me" type="textarea" name="aboutMe" value="${userProfile.generalProfile.aboutMe}">
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="12">
					<aui:input label="Favorite Quotes" type="textarea" name="favoriteQuotes" value="${userProfile.generalProfile.favoriteQuotes}">
					</aui:input>
				</aui:col>
			</aui:row>
		</aui:fieldset>

		<aui:fieldset label="Movie Interest">
			<aui:row>
				<aui:col span="12">
					<aui:input label="Favorite Movie" name="favoriteMovie" value="${userProfile.movieInterest.favoriteMovie}">
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="12">
					<aui:select label="Favorite Genre" name="favoriteGenreId" required="true">
						<c:forEach items="${genres}" var="genre">
							<aui:option label="${genre.favoriteGenreName}"
										value="${genre.favoriteGenreId}"
										selected="${(genre.favoriteGenreId eq userProfile.movieInterest.favoriteGenreId)?'true':'false'}" />
						</c:forEach>
					</aui:select>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="12">
					<aui:input label="Least Favorite Movie" name="leastFavoriteMovie" value="${userProfile.movieInterest.leastFavoriteMovie}">
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:row>
				<aui:col span="12">
					<aui:input label="Favorite Actor/Actress" name="favoriteActor" value="${userProfile.movieInterest.favoriteActor}">
					</aui:input>
				</aui:col>
			</aui:row>

		</aui:fieldset>

		<portlet:renderURL var="homeURL">
			<portlet:param name="jspPage" value="/view.jsp" />
		</portlet:renderURL>

		<aui:button-row>
			<aui:button href="${homeURL}" primary="false"
						value="Return" />
			<aui:button primary="true" type="submit"
						value="Update" />
		</aui:button-row>

		<aui:input type="hidden" name="userId" value="${userProfile.basicInfo.userId}" />
	</aui:form>
</div>
