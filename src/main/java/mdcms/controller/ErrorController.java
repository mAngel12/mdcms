package mdcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

    @RequestMapping(value = "error", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

        ModelAndView errorPage = new ModelAndView("error");
        String errorMsg = "";
        String errorMsgLong = "";
        int httpErrorCode = getErrorCode(httpRequest);

        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Error Code: 400. Bad Request!";
                errorMsgLong = "The request could not be understood by the server due to malformed syntax. The client SHOULD NOT repeat the request without modifications.";
                break;
            }
            case 401: {
                errorMsg = "Error Code: 401. Unauthorized!";
                errorMsgLong = "The request requires user authentication. The response MUST include a WWW-Authenticate header field (section 14.47) containing a challenge applicable to the requested resource. The client MAY repeat the request with a suitable Authorization header field (section 14.8). If the request already included Authorization credentials, then the 401 response indicates that authorization has been refused for those credentials. If the 401 response contains the same challenge as the prior response, and the user agent has already attempted authentication at least once, then the user SHOULD be presented the entity that was given in the response, since that entity might include relevant diagnostic information. HTTP access authentication is explained in \"HTTP Authentication: Basic and Digest Access Authentication\".";
                break;
            }
            case 404: {
                errorMsg = "Error Code: 404. Resource not found!";
                errorMsgLong = "The server has not found anything matching the Request-URI. No indication is given of whether the condition is temporary or permanent. The 410 (Gone) status code SHOULD be used if the server knows, through some internally configurable mechanism, that an old resource is permanently unavailable and has no forwarding address. This status code is commonly used when the server does not wish to reveal exactly why the request has been refused, or when no other response is applicable.";
                break;
            }
            case 500: {
                errorMsg = "Error Code: 500. Internal Server Error!";
                errorMsgLong = "The server encountered an unexpected condition which prevented it from fulfilling the request.";
                break;
            }
        }
        errorPage.addObject("errorMsg", errorMsg);
        errorPage.addObject("errorMsgLong", errorMsgLong);
        return errorPage;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }
}