<%@ include file="/init.jsp" %>

<div class="container-fluid container-fluid-max-xl container-userprofile">

    <h1>
        Privacy Setting
    </h1>

<portlet:actionURL var="actionURL" name="<%=MVCCommandNames.PROFILE_ACTION_PRIVACY %>">
</portlet:actionURL>

<aui:form action="${actionURL}" name="fm" method="post">
    <c:set value="<%=AmfUserProfilePrivacy.PUBLIC%>" var="privacyPublic" />
    <c:set value="<%=AmfUserProfilePrivacy.PROTECTED%>" var="privacyProtected" />
    <c:set value="<%=AmfUserProfilePrivacy.PRIVATE%>" var="privacyPrivate" />

    <aui:fieldset label="Basic Info">
        <c:set value="<%=AmfActionKeys.VIEW_BASIC_INFO%>" var="actionIdBasicInfo" />
        <c:set value="${basicInfoPermission.contains(permissionChecker, userProfile.basicInfo,  actionIdBasicInfo)}" var="permissionBasicInfo"/>

        <aui:row cssClass="privacy-setting">
            <aui:input name="privacyBasicInfo" type="radio" value="${privacyPublic}" label="Public" checked="${userProfile.privacyBasicInfo == privacyPublic}" />
            <aui:input name="privacyBasicInfo" type="radio" value="${privacyProtected}" label="Protected" checked="${userProfile.privacyBasicInfo == privacyProtected}" />
            <aui:input name="privacyBasicInfo" type="radio" value="${privacyPrivate}" label="Private" checked="${userProfile.privacyBasicInfo == privacyPrivate}" />
        </aui:row>

        <aui:row>
            <aui:col span="4">
                <aui:input label="First Name" name="first_name" disabled="true" value="${permissionBasicInfo == false ? '******' : userProfile.basicInfo.firstName}">
                </aui:input>
            </aui:col>
            <aui:col span="4">
                <aui:input label="Last Name" name="last_name" disabled="true" value="${permissionBasicInfo == false ? '******' : userProfile.basicInfo.lastName}">
                </aui:input>
            </aui:col>
            <aui:col span="4">
                <aui:input label="Gender" name="gender" disabled="true" value="${permissionBasicInfo == false ? '******' : ((userProfile.basicInfo.male == true)?'male':'female')}">
                </aui:input>
            </aui:col>
        </aui:row>

        <aui:row>
            <aui:col span="12">
                <fmt:formatDate value="${userProfile.basicInfo.birthday}" var="birthday" type="date" pattern="MM-dd-yyyy" />
                <aui:input label="Birthday" name="birthday" disabled="true" value="${permissionBasicInfo == false ? '******' : birthday}">
                </aui:input>
            </aui:col>
        </aui:row>
    </aui:fieldset>

    <aui:fieldset label="General Information">
        <c:set value="${true}" var="permissionGeneralProfile"/>
        <c:set value="<%=AmfActionKeys.VIEW_GENERAL_PROFILE%>" var="actionIdGeneralProfile" />

        <c:if test="${userProfile.generalProfile != null}">
            <c:set value="${generalProfilePermission.contains(permissionChecker, userProfile.generalProfile, actionIdGeneralProfile)}" var="permissionGeneralProfile"/>
        </c:if>

        <aui:row cssClass="privacy-setting">
            <aui:input name="privacyGeneralProfile" type="radio" value="${privacyPublic}" label="Public" checked="${userProfile.privacyGeneralProfile == privacyPublic}" />
            <aui:input name="privacyGeneralProfile" type="radio" value="${privacyProtected}" label="Protected" checked="${userProfile.privacyGeneralProfile == privacyProtected}" />
            <aui:input name="privacyGeneralProfile" type="radio" value="${privacyPrivate}" label="Private" checked="${userProfile.privacyGeneralProfile == privacyPrivate}" />
        </aui:row>

        <aui:row>
            <aui:col span="12">
                <aui:input label="About me" type="textarea" name="aboutMe" disabled="true" value="${permissionGeneralProfile == false ? '******' : userProfile.generalProfile.aboutMe}">
                </aui:input>
            </aui:col>
        </aui:row>

        <aui:row>
            <aui:col span="12">
                <aui:input label="Favorite Quotes" type="textarea" name="favoriteQuotes" disabled="true" value="${permissionGeneralProfile == false ? '******' : userProfile.generalProfile.favoriteQuotes}">
                </aui:input>
            </aui:col>
        </aui:row>
    </aui:fieldset>

    <aui:fieldset label="Movie Interest">
        <c:set value="${true}" var="permissionMovieInterest"/>
        <c:set value="<%=AmfActionKeys.VIEW_MOVIE_INTEREST%>" var="actionIdMovieInterest" />

        <c:if test="${userProfile.movieInterest != null}">
            <c:set value="${movieInterestPermission.contains(permissionChecker, userProfile.movieInterest, actionIdMovieInterest)}" var="permissionMovieInterest"/>
        </c:if>

        <aui:row cssClass="privacy-setting">
            <aui:input name="privacyMovieInterest" type="radio" value="${privacyPublic}" label="Public" checked="${userProfile.privacyMovieInterest == privacyPublic}" />
            <aui:input name="privacyMovieInterest" type="radio" value="${privacyProtected}" label="Protected" checked="${userProfile.privacyMovieInterest == privacyProtected}" />
            <aui:input name="privacyMovieInterest" type="radio" value="${privacyPrivate}" label="Private" checked="${userProfile.privacyMovieInterest == privacyPrivate}" />
        </aui:row>

        <aui:row>
            <aui:col span="12">
                <aui:input label="Favorite Movie" name="favoriteMovie" disabled="true" value="${permissionMovieInterest == false ? '******' : userProfile.movieInterest.favoriteMovie}">
                </aui:input>
            </aui:col>
        </aui:row>

        <aui:row>
            <aui:col span="12">
                <c:set value="" var="favoriteGenre" />
                <c:forEach items="${genres}" var="genre">
                    <c:if test="${genre.favoriteGenreId eq userProfile.movieInterest.favoriteGenreId}">
                        <c:set value="${genre.favoriteGenreName}" var="favoriteGenre" />
                    </c:if>
                </c:forEach>

                <aui:input label="Favorite Genre" name="favoriteGenreId" disabled="true" value="${permissionMovieInterest == false ? '******' : favoriteGenre}">
                </aui:input>
            </aui:col>
        </aui:row>

        <aui:row>
            <aui:col span="12">
                <aui:input label="Least Favorite Movie" name="leastFavoriteMovie" disabled="true" value="${permissionMovieInterest == false ? '******' : userProfile.movieInterest.leastFavoriteMovie}">
                </aui:input>
            </aui:col>
        </aui:row>

        <aui:row>
            <aui:col span="12">
                <aui:input label="Favorite Actor/Actress" name="favoriteActor" disabled="true" value="${permissionMovieInterest == false ? '******' : userProfile.movieInterest.favoriteActor}">
                </aui:input>
            </aui:col>
        </aui:row>

    </aui:fieldset>

    <portlet:renderURL var="homeURL">
        <portlet:param name="jspPage" value="/view.jsp" />
    </portlet:renderURL>

    <%--Buttons. --%>
    <aui:button-row>
        <aui:button href="${homeURL}" primary="false"
                    value="Return" />

        <aui:button primary="true" type="submit"
                    value="Privacy Update" />
    </aui:button-row>

    <aui:input type="hidden" name="userId" value="${userProfile.basicInfo.userId}" />
</aui:form>
</div>
