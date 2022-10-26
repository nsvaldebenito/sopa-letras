package org.sitrack.sopaletras.util;


import org.sitrack.sopaletras.dto.ResponseWrapper;
import org.sitrack.sopaletras.exception.ConflictException;
import org.sitrack.sopaletras.exception.NotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;


@Component
public class Utils {

    public static void verifyForConflict(boolean condition, String message)
            throws ConflictException {
        if (condition) {
            throw new ConflictException(message);
        }
    }

    public static void verifyForNotFound(boolean condition, String message)
            throws NotFoundException {
        if (condition) {
            throw new NotFoundException(message);
        }
    }

    public static ResponseWrapper formatResponse(int statusCode, String message, Object payload) {

        return ResponseWrapper.builder().statusCode(statusCode).message(message).payload(payload).build();
    }

    public static Pageable getPageable(String sortName, Long page, Long size, Boolean isAscending) {

        Sort sort = Sort.unsorted();
        if (sortName != null) {
            sort = isAscending ? Sort.by(sortName).ascending() : Sort.by(sortName).descending();
        }
        Pageable pageable;

        if (page == null || size == null) {
            pageable = PageRequest.of(0, Integer.MAX_VALUE, sort);
        } else {
            pageable = PageRequest.of(page.intValue(), size.intValue(), sort);
        }
        return pageable;
    }
}
