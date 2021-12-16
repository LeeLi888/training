<%@ include file="../init.jsp"%>

<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' key="error.regist-service-error" />
</liferay-ui:error>
<liferay-ui:success key="registed" message="registed-successfully" />
<liferay-ui:error key="usernameAlreadyRegisted" message="error.username-already-registed" />
<liferay-ui:error key="over13age" message="error.over-13-age" />

<portlet:actionURL var="registActionURL" name="<%=MVCCommandNames.REGIST_SUBMIT %>">
	<portlet:param name="redirect" value="${param.redirect}" />
</portlet:actionURL>

<div class="container-fluid container-fluid-max-xl edit-assignment">

	<h1>
		<liferay-ui:message key="regist-title" />
	</h1>

	<aui:form action="${registActionURL}" name="fm" method="post">
		<aui:fieldset label="Basic Info">
			<aui:row>
				<aui:col span="6">
					<aui:input label="First Name" name="first_name">
						<aui:validator name="required" />
						<aui:validator name="maxLength">50</aui:validator>
						<aui:validator name="alphanum" />
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input label="Last Name" name="last_name">
						<aui:validator name="required" />
						<aui:validator name="maxLength">50</aui:validator>
						<aui:validator name="alphanum" />
					</aui:input>
				</aui:col>
			</aui:row>

			<aui:input label="Email Address" name="email_address">
				<aui:validator name="required" />
				<aui:validator name="maxLength">50</aui:validator>
				<aui:validator name="email" />
			</aui:input>

			<aui:input label="User Name" name="username">
				<aui:validator name="required" />
				<aui:validator name="minLength">4</aui:validator>
				<aui:validator name="maxLength">16</aui:validator>
				<aui:validator name="alphanum" />
			</aui:input>

			<aui:input label="Male" name="male" type="checkbox" value="1">
			</aui:input>

			<div class="form-group">
				<label class="control-label">Birthday</label>
				<liferay-ui:input-date name="birthday"
									   required="true"
									   yearParam="b_year"
									   monthParam="b_month"
									   dayParam="b_day"
				>
				</liferay-ui:input-date>
			</div>

			<aui:row>
				<aui:col span="6">
					<aui:input label="Password" name="password1" type="password">
						<aui:validator name="required" />
						<aui:validator name="minLength">6</aui:validator>
					</aui:input>
				</aui:col>
				<aui:col span="6">
					<aui:input label="Confirm Password" name="password2" type="password">
						<aui:validator name="required" />
						<aui:validator errorMessage="error.password-not-match"
									   name="custom">
							function(val, fieldNode, ruleValue) {
                                let password1 = document.querySelector('#<portlet:namespace />password1').value;
                                return val === password1;
							}
						</aui:validator>
					</aui:input>
				</aui:col>
			</aui:row>
		</aui:fieldset>

		<aui:fieldset label="Phone">
			<%-- Title field. --%>
			<aui:input label="Home Phone" name="home_phone">
				<aui:validator name="number" />
				<aui:validator name="minLength">10</aui:validator>
				<aui:validator name="maxLength">10</aui:validator>
			</aui:input>
			<aui:input label="Mobile Phone" name="mobile_phone">
				<aui:validator name="number" />
				<aui:validator name="minLength">10</aui:validator>
				<aui:validator name="maxLength">10</aui:validator>
			</aui:input>
		</aui:fieldset>

		<aui:fieldset label="Address">
			<aui:input label="Address 1" name="address1">
				<aui:validator name="required" />
				<aui:validator name="alphanum" />
				<aui:validator name="maxLength">255</aui:validator>
			</aui:input>

			<aui:input label="Address 2" name="address2">
				<aui:validator name="alphanum" />
				<aui:validator name="maxLength">255</aui:validator>
			</aui:input>

			<aui:input label="City" name="city">
				<aui:validator name="required" />
				<aui:validator name="alphanum" />
				<aui:validator name="maxLength">255</aui:validator>
			</aui:input>

			<aui:select label="State" name="state" required="true">
				<c:forEach items="${regions}" var="region" varStatus="regionStatus">
					<aui:option label="${region.name}" value="${region.regionCode}"/>
				</c:forEach>
			</aui:select>

			<aui:input label="Zip Code" name="zip_code">
				<aui:validator name="required" />
				<aui:validator name="number" />
				<aui:validator name="minLength">5</aui:validator>
				<aui:validator name="maxLength">5</aui:validator>
			</aui:input>
		</aui:fieldset>

		<aui:fieldset label="Misc">

			<aui:select label="Security Question" name="security_question" required="true">
				<aui:option label="security-question.what-is-your-mother's-maiden-name" value="security-question.what-is-your-mother's-maiden-name"/>
				<aui:option label="security-question.what-is-the-make-of-your-first-car" value="security-question.what-is-the-make-of-your-first-car"/>
				<aui:option label="security-question.what-is-your-high-school-mascot" value="security-question.what-is-your-high-school-mascot"/>
				<aui:option label="security-question.who-is-your-favorite-actor" alue="security-question.who-is-your-favorite-actor"/>
			</aui:select>

			<aui:input label="Answer" name="security_answer">
				<aui:validator name="required" />
				<aui:validator name="alphanum" />
				<aui:validator name="maxLength">255</aui:validator>
			</aui:input>

			<aui:input label="I have read, understand, and agree with the Terms of Use governing my access to and use of the Acme Movie Fanatics 	web site." name="accepted_tou" type="checkbox">
				<aui:validator name="required" />
			</aui:input>

		</aui:fieldset>

		<%--Buttons. --%>
		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit"
						value="signup-button-value" />
		</aui:button-row>
	</aui:form>


</div>
