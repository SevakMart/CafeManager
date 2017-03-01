package cafemanager.exceptionhandler;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Sevak on 2/25/2017.
 */

@Component
public class ExceptionHandler implements HandlerExceptionResolver {
    private static Logger logger = Logger.getLogger(ExceptionHandler.class);

    /**
     * resolve all exceptions and redirect to error page
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        logger.error(e.toString());
        return new ModelAndView("/error", "errMessage", e.getMessage());
    }
}
