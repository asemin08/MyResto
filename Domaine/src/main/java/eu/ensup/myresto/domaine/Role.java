package eu.ensup.myresto.domaine;

public enum Role
{
    GUEST ("Visiteur"),
    CUSTOMER ("Client");

    private String text;

    Role(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Role getRoleByName(String name)
    {
        for( Role role : Role.values() )
        {
            if( role.name().equals(name) )
                return role;
        }
        return null;
    }

    public static Role getRoleByText(String text)
    {
        for( Role role : Role.values() )
        {
            if( role.getText().equals(text) )
                return role;
        }
        return null;
    }

    public static Role getRoleByNum(int num)
    {
        for( Role role : Role.values() )
        {
            if( role.ordinal() == num )
                return role;
        }
        return null;
    }
}
