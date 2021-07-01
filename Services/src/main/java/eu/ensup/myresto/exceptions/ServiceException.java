package eu.ensup.myresto.exceptions;

/**
 * The type Service exception.
 */
public class ServiceException extends Exception {

    private final String classWhereError;
    private final String methodeWhereError;
    private final String messageError;
    private final String messageViewForUser;

    /**
     * Instantiates a new Service exception.
     *
     * @param classWhereError    the class where error
     * @param methodeWhereError  the methode where error
     * @param messageError       the message error
     * @param messageViewForUser the message view for user
     */
    public ServiceException(String classWhereError, String methodeWhereError, String messageError, String messageViewForUser) {
        super(messageError);
        this.classWhereError = classWhereError;
        this.methodeWhereError = methodeWhereError;
        this.messageError = messageError;
        this.messageViewForUser = messageViewForUser;
    }

    /**
     * Gets class where error.
     *
     * @return the class where error
     */
    public String getClassWhereError() {
        return classWhereError;
    }

    /**
     * Gets methode where error.
     *
     * @return the methode where error
     */
    public String getMethodeWhereError() {
        return methodeWhereError;
    }

    /**
     * Gets message error.
     *
     * @return the message error
     */
    public String getMessageError() {
        return messageError;
    }

    /**
     * Gets message view for user.
     *
     * @return the message view for user
     */
    public String getMessageViewForUser() {
        return messageViewForUser;
    }
}
