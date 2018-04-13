package assit.america.com.turismo.database.model;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.UUID;

import assit.america.com.turismo.database.ContractSitios;

public class Sitio {
    private String id;
    private String nombre;
    private String imagen;
    private String descripcion;
    private String latitud;
    private String longitud;

    public Sitio(String nombre, String imagen, String descripcion, String latitud, String longitud) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(ContractSitios.SitiosEntry.ID, id);
        values.put(ContractSitios.SitiosEntry.NOMBRE, nombre);
        values.put(ContractSitios.SitiosEntry.IMAGEN, imagen);
        values.put(ContractSitios.SitiosEntry.DESCRIPCION, descripcion);
        values.put(ContractSitios.SitiosEntry.LATITUD, latitud);
        values.put(ContractSitios.SitiosEntry.LONGITUD, longitud);
        return values;
    }

    public Sitio (Cursor cursor){
        id = cursor.getString(cursor.getColumnIndex(ContractSitios.SitiosEntry.ID));
        nombre = cursor.getString(cursor.getColumnIndex(ContractSitios.SitiosEntry.NOMBRE));
        imagen = cursor.getString(cursor.getColumnIndex(ContractSitios.SitiosEntry.IMAGEN));
        descripcion = cursor.getString(cursor.getColumnIndex(ContractSitios.SitiosEntry.DESCRIPCION));
        latitud = cursor.getString(cursor.getColumnIndex(ContractSitios.SitiosEntry.LATITUD));
        longitud = cursor.getString(cursor.getColumnIndex(ContractSitios.SitiosEntry.LONGITUD));
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }
}
