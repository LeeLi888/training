package com.amf.user.profile.web.model;

import com.amf.user.profile.model.BasicInfo;
import com.amf.user.profile.model.GeneralProfile;
import com.amf.user.profile.model.MovieInterest;
import com.amf.user.profile.web.constants.AmfUserProfilePrivacy;

public class UserProfile {
    private BasicInfo basicInfo;
    private GeneralProfile generalProfile;
    private MovieInterest movieInterest;
    private int privacyBasicInfo = AmfUserProfilePrivacy.PRIVATE;
    private int privacyGeneralProfile = AmfUserProfilePrivacy.PRIVATE;
    private int privacyMovieInterest = AmfUserProfilePrivacy.PRIVATE;

    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public GeneralProfile getGeneralProfile() {
        return generalProfile;
    }

    public void setGeneralProfile(GeneralProfile generalProfile) {
        this.generalProfile = generalProfile;
    }

    public MovieInterest getMovieInterest() {
        return movieInterest;
    }

    public void setMovieInterest(MovieInterest movieInterest) {
        this.movieInterest = movieInterest;
    }

    public int getPrivacyBasicInfo() {
        return privacyBasicInfo;
    }

    public void setPrivacyBasicInfo(int privacyBasicInfo) {
        this.privacyBasicInfo = privacyBasicInfo;
    }

    public int getPrivacyGeneralProfile() {
        return privacyGeneralProfile;
    }

    public void setPrivacyGeneralProfile(int privacyGeneralProfile) {
        this.privacyGeneralProfile = privacyGeneralProfile;
    }

    public int getPrivacyMovieInterest() {
        return privacyMovieInterest;
    }

    public void setPrivacyMovieInterest(int privacyMovieInterest) {
        this.privacyMovieInterest = privacyMovieInterest;
    }
}
