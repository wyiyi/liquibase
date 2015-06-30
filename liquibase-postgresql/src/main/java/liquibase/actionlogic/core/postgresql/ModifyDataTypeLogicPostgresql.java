package liquibase.actionlogic.core.postgresql;

import liquibase.Scope;
import liquibase.action.core.ModifyDataTypeAction;
import liquibase.actionlogic.core.ModifyDataTypeLogic;
import liquibase.database.Database;
import liquibase.database.core.postgresql.PostgresDatabase;
import liquibase.util.StringClauses;

public class ModifyDataTypeLogicPostgresql extends ModifyDataTypeLogic {
    @Override
    protected Class<? extends Database> getRequiredDatabase() {
        return PostgresDatabase.class;
    }

    @Override
    protected StringClauses generateSql(ModifyDataTypeAction action, Scope scope) {
        StringClauses clauses = super.generateSql(action, scope);

        clauses.prepend("TYPE");
        clauses.append("USING ("
                +action.columnName
                +"::"
                +action.newDataType
                +")");

        return clauses;
    }
}
