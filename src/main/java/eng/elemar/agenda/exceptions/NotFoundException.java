package eng.elemar.agenda.exceptions;

import eng.elemar.agenda.utils.MessageUtils;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }
    
}
