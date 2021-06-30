package eu.ensup.myresto.exceptions;

public class DaoException extends Exception {

    private final String classWhereError;
    private final String methodeWhereError;
    private final String messageError;
    private final String messageViewForUser;

    public DaoException(String classWhereError, String methodeWhereError, String messageError, String messageViewForUser) {
        super(messageError);
        this.classWhereError = classWhereError;
        this.methodeWhereError = methodeWhereError;
        this.messageError = messageError;
        this.messageViewForUser = messageViewForUser;
    }

    public String getClassWhereError() {
        return classWhereError;
    }

    public String getMethodeWhereError() {
        return methodeWhereError;
    }

    public String getMessageError() {
        return messageError;
    }

    public String getMessageViewForUser() {
        return messageViewForUser;
    }
}
