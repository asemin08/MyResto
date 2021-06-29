package exceptions;

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

}
