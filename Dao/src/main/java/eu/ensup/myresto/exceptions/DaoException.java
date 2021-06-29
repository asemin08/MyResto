package eu.ensup.myresto.exceptions;

public class DaoException extends Exception{

    private String classWhereError;
    private String methodeWhereError;
    private String messageError;
    private String messageViewForUser;

    public DaoException(String classWhereError, String methodeWhereError, String messageError, String messageViewForUser) {
        super(messageError);
        this.classWhereError = classWhereError;
        this.methodeWhereError = methodeWhereError;
        this.messageError = messageError;
        this.messageViewForUser = messageViewForUser;
    }
}
