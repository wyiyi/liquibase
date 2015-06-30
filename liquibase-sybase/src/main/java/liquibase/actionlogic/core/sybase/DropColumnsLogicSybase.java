package liquibase.actionlogic.core.sybase;

import liquibase.Scope;
import liquibase.action.core.DropColumnsAction;
import liquibase.actionlogic.core.DropColumnsLogic;
import liquibase.database.Database;
import liquibase.database.core.sybase.SybaseDatabase;
import liquibase.util.StringClauses;

public class DropColumnsLogicSybase extends DropColumnsLogic {
    @Override
    protected Class<? extends Database> getRequiredDatabase() {
        return SybaseDatabase.class;
    }

    @Override
    protected StringClauses generateDropSql(String column, DropColumnsAction action, Scope scope) {
        return super.generateDropSql(column, action, scope)
                .replace("DROP COLUMN", "DROP");
    }
}
