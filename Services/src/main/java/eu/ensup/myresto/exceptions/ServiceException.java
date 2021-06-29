package eu.ensup.myresto.exceptions;

public class ServiceException extends Exception{

    private String classWhereError;
    private String methodeWhereError;
    private String messageError;
    private String messageViewForUser;

    public ServiceException(String classWhereError, String methodeWhereError, String messageError, String messageViewForUser) {
        super(messageError);
        this.classWhereError = classWhereError;
        this.methodeWhereError = methodeWhereError;
        this.messageError = messageError;
        this.messageViewForUser = messageViewForUser;
    }

    public String getClassWhereError() {
        return classWhereError;
    }

    public void setClassWhereError(String classWhereError) {
        this.classWhereError = classWhereError;
    }

    public String getMethodeWhereError() {
        return methodeWhereError;
    }

    public void setMethodeWhereError(String methodeWhereError) {
        this.methodeWhereError = methodeWhereError;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public String getMessageViewForUser() {
        return messageViewForUser;
    }

    public void setMessageViewForUser(String messageViewForUser) {
        this.messageViewForUser = messageViewForUser;
    }
}
