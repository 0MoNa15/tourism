package assit.america.com.turismo.adapters;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import assit.america.com.turismo.R;
import assit.america.com.turismo.database.ContractSitios;

public class SitiosCursorAdapter extends CursorAdapter{
    public SitiosCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.card_sitio, viewGroup, false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        TextView txtNombre = view.findViewById(R.id.textViewNombre);
        TextView txtDescripcion = view.findViewById(R.id.textViewDescripcion);
        TextView txtLatitud = view.findViewById(R.id.textViewLatitud);
        final ImageView imageViewImagen = view.findViewById(R.id.imageViewList);

        String nombre = cursor.getString(cursor.getColumnIndex(ContractSitios.SitiosEntry.NOMBRE));
        String desripcion = cursor.getString(cursor.getColumnIndex(ContractSitios.SitiosEntry.DESCRIPCION));
        String latitud = cursor.getString(cursor.getColumnIndex(ContractSitios.SitiosEntry.LATITUD));
        final String imagen = cursor.getString(cursor.getColumnIndex(ContractSitios.SitiosEntry.IMAGEN));

        txtNombre.setText(nombre);
        txtDescripcion.setText(desripcion);
        txtLatitud.setText(latitud);

        /*Glide
                .with(context)
                .load(Uri.parse("file:///android_asset/" + imagen))
                .asBitmap()
                .error(R.drawable.ic_menu_camera)
                .centerCrop()
                .into(new BitmapImageViewTarget(imageViewImagen){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);

                        RoundedBitmapDrawable roundedBitmapDrawableFactory =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        roundedBitmapDrawableFactory.setCircular(true);
                        imageViewImagen.setImageDrawable(roundedBitmapDrawableFactory);

                    }
                });
*/
        Glide
                .with(context)
                .load(Uri.parse("file:///android_asset/" + imagen))
                .asBitmap()
                .error(R.drawable.ic_menu_manage)
                .centerCrop()
                .into(new BitmapImageViewTarget(imageViewImagen) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable drawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        drawable.setCircular(true);
                        imageViewImagen.setImageDrawable(drawable);
                    }
                });
    }
}
