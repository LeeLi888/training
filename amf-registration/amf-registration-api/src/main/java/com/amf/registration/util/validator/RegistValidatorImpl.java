package com.amf.registration.util.validator;

 import com.amf.registration.exception.AmfRegistrationValidationException;
 import com.amf.registration.validator.RegistValidator;
 import com.liferay.portal.kernel.exception.NoSuchUserException;
 import com.liferay.portal.kernel.exception.PortalException;
 import com.liferay.portal.kernel.model.User;
 import com.liferay.portal.kernel.service.UserLocalService;
 import com.liferay.portal.kernel.util.DateUtil;
 import com.liferay.portal.kernel.util.Validator;

 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;
 import java.util.Locale;
 import java.util.Map;

 import org.osgi.service.component.annotations.Component;
 import org.osgi.service.component.annotations.Reference;

@Component(
     immediate = true, 
     service = RegistValidator.class
 )
 public class RegistValidatorImpl implements RegistValidator {

     @Reference
     private UserLocalService _userLocalService;

     @Override
     public void validate(long companyId, String username, Date birthday) throws PortalException {
         List<String> errors = new ArrayList<>();

         try {
             User user = _userLocalService.getUserByScreenName(companyId, username);
             errors.add("usernameAlreadyRegisted");
         } catch (NoSuchUserException e) {
            //Nothing to do
         }

         if (DateUtil.getDaysBetween(birthday, new Date())/365 < 13) {
             errors.add("over13age");
         }

         if (errors.size() > 0) {
             throw new AmfRegistrationValidationException(errors);
         }
     }


 }