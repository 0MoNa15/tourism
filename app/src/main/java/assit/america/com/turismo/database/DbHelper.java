package assit.america.com.turismo.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import assit.america.com.turismo.database.model.Sitio;

public class DbHelper extends SQLiteOpenHelper{
    public DbHelper(Context context) {
        super(context, "Turismo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ContractSitios.SitiosEntry.TABLE_NAME+" ("
        + ContractSitios.SitiosEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
        + ContractSitios.SitiosEntry.ID + " TEXT NOT NULL,"
        + ContractSitios.SitiosEntry.NOMBRE + " TEXT NOT NULL,"
        + ContractSitios.SitiosEntry.IMAGEN + " TEXT NOT NULL, "
        + ContractSitios.SitiosEntry.DESCRIPCION + " TEXT NOT NULL, "
        + ContractSitios.SitiosEntry.LATITUD + " TEXT NOT NULL, "
        + ContractSitios.SitiosEntry.LONGITUD + " TEXT NOT NULL, "
        + "UNIQUE ("+ContractSitios.SitiosEntry.ID+"))");

        mockData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void mockData(SQLiteDatabase db){
        mockSitios(db, new Sitio(
                "Calima",
                "calima.png",
                "Es muy bonito",
                "3.4846089",
                "-76.5018099"));

        mockSitios(db, new Sitio(
                "Mamá lulu",
                "granja_mama_lulu.png",
                "Es muy bonito",
                "4.7849641",
                "-75.9352643"));

        mockSitios(db, new Sitio(
                "Los arrieros",
                "los_arrieros.png",
                "Es muy bonito",
                "5.0686937",
                "-75.5536839"));

        mockSitios(db, new Sitio(
                "Parque del café",
                "parque_cafe.png",
                "Es muy bonito",
                "3.4846020",
                "-76.5018099"));

        mockSitios(db, new Sitio(
                "Panaca",
                "panaca.png",
                "Es muy bonito",
                "3.4846030",
                "-76.5018099"));

        mockSitios(db, new Sitio(
                "Peñas blancas",
                "pennas_blancas.png",
                "Es muy bonito",
                "3.4846080",
                "-76.5018099"));

        mockSitios(db, new Sitio(
                "Portal del Quindio",
                "portal_del_quindio.png",
                "Es muy bonito",
                "3.4846087",
                "-76.5018099"));

        mockSitios(db, new Sitio(
                "Salento",
                "salento.png",
                "Es muy bonito",
                "3.484608",
                "-76.5018099"));
    }

    public long mockSitios(SQLiteDatabase db, Sitio sitio){
        return db.insert(
                ContractSitios.SitiosEntry.TABLE_NAME,
                null,
                sitio.toContentValues()
        );
    }

    public Cursor getAllSitios(){
        return getReadableDatabase().query(
                ContractSitios.SitiosEntry.TABLE_NAME,
                null ,
                null ,
                null ,
                null ,
                null ,
                null ,
                null);
    }

    public Cursor getSitioById(String sitioId){
        return getReadableDatabase().query(
                ContractSitios.SitiosEntry.TABLE_NAME,
                null ,
                ContractSitios.SitiosEntry.ID + " Like ?",
                new String[] {sitioId},
                null ,
                null ,
                null ,
                null);
    }
}
