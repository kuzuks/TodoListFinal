package Todo.list.Todo.list.exception;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalControllerAdvice {
    private final Logger logger = LoggerFactory.getLogger((GlobalControllerAdvice.class));

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity handleBadRequestException(HttpServletRequest request, Exception ex){
        logger.error(">>>> Data Integrity Violation Exception <<<<");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(generateResponse(request.getRequestURI(),ex));
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity NoSuchElementException(HttpServletRequest request, Exception ex){
        logger.error(">>>> Not Found Exception <<<<");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(generateResponse(request.getRequestURI(),ex));
    }

    private String generateResponse( String uri, Exception ex){
        return new StringBuilder().append("Error on: ").append(uri).append(" -> ").append(ex.getMessage()).toString();
    }
}
