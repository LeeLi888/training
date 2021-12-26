package com.amf.registration.validator;

 import com.amf.registration.exception.AmfRegistrationValidationException;
 import com.liferay.portal.kernel.exception.PortalException;

 import java.util.Date;
 import java.util.Locale;
 import java.util.Map;

 public interface RegistValidator {

     public void validate(long companyId, String username, Date birthday)
             throws PortalException;

 }