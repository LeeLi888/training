<%@ include file="/META-INF/resources/init.jsp" %>

<div class="container-fluid container-fluid-max-xl container-userprofile">

    <h1>
        View Profile
    </h1>

    <aui:fieldset label="Basic Info">
        <c:set value="${basicInfoPermission.contains(permissionChecker, userProfile.basicInfo, 'VIEW_BASIC_INFO')}" var="permissionBasicInfo"/>

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

        <c:if test="${userProfile.generalProfile != null}">
            <c:set value="${generalProfilePermission.contains(permissionChecker, userProfile.generalProfile, 'VIEW_GENERAL_PROFILE')}" var="permissionGeneralProfile"/>
        </c:if>

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

        <c:if test="${userProfile.movieInterest != null}">
            <c:set value="${movieInterestPermission.contains(permissionChecker, userProfile.movieInterest, 'VIEW_MOVIE_INTEREST')}" var="permissionMovieInterest"/>
        </c:if>

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
    </aui:button-row>

</div>
