package assit.america.com.turismo.views.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import assit.america.com.turismo.R;
import assit.america.com.turismo.database.ContractSitios;
import assit.america.com.turismo.views.fragments.DetalleSitioFragment;

public class DetalleSitioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_sitio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DetalleSitioFragment fragment = new DetalleSitioFragment();

        if(fragment != null){
            String idSitio = getIntent().getStringExtra(ContractSitios.SitiosEntry.ID);
            fragment = DetalleSitioFragment.newInstance(idSitio);
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor, fragment).commit();
        }
    }
}
