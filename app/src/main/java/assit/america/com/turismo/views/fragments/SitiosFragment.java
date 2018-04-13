package assit.america.com.turismo.views.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import assit.america.com.turismo.R;
import assit.america.com.turismo.adapters.SitiosCursorAdapter;
import assit.america.com.turismo.database.ContractSitios;
import assit.america.com.turismo.database.DbHelper;
import assit.america.com.turismo.views.activities.DetalleSitioActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SitiosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SitiosFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    DbHelper dbHelper;
    SitiosCursorAdapter sitiosCursorAdapter;
    ListView listView;
    public static final int REQUEST_ID = 2;

    public SitiosFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sitios, container, false);

        listView = view.findViewById(R.id.listSitios);
        sitiosCursorAdapter = new SitiosCursorAdapter(getActivity(), null);
        listView.setAdapter(sitiosCursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Cursor currentItem = (Cursor) sitiosCursorAdapter.getItem(i);
            String idSitio = currentItem.getString(currentItem.getColumnIndex(ContractSitios.SitiosEntry.ID));
            showDetail(idSitio);
            }
        });

        dbHelper = new DbHelper(getActivity());

        loadData();

        return view;
    }

    public void showDetail(String isSitio){
        Intent intent = new Intent(getActivity(), DetalleSitioActivity.class);
        intent.putExtra(ContractSitios.SitiosEntry.ID, isSitio);
        startActivityForResult(intent, REQUEST_ID);
    }

    public void loadData(){
        new LoadItemData().execute();
    }

    public class LoadItemData extends AsyncTask<Void, Void, Cursor>{

        @Override
        protected Cursor doInBackground(Void... voids) {
            return dbHelper.getAllSitios();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);
            if(cursor != null && cursor.getCount() > 0){
                sitiosCursorAdapter.swapCursor(cursor);
            }
            else {
                Log.e("NADA", "onPostExecute: ");
            }
        }
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
