package assit.america.com.turismo.database;

import android.provider.BaseColumns;

public class ContractSitios {
    public static abstract class SitiosEntry implements BaseColumns{
        public static final String TABLE_NAME = "sitios";
        public static final String ID = "id";
        public static final String IMAGEN = "imagen";
        public static final String NOMBRE = "nombre";
        public static final String DESCRIPCION = "descripcion";
        public static final String LATITUD = "latitud";
        public static final String LONGITUD = "longitud";
    }
}
