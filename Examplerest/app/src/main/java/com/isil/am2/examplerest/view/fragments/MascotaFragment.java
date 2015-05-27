package com.isil.am2.examplerest.view.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.isil.am2.examplerest.MainActivity;
import com.isil.am2.examplerest.R;
import com.isil.am2.examplerest.model.entity.MascotaEntity;
import com.isil.am2.examplerest.view.adapter.MascotaAdapter;
import com.isil.am2.examplerest.view.listeners.OnFragmentListener;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MascotaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MascotaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MascotaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG ="MascotaFragment" ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentListener mListener;
    private ListView lviMascotas;
    private View vLoading;
    private RequestQueue queue;
    private List<MascotaEntity> data;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MascotaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MascotaFragment newInstance(String param1, String param2) {
        MascotaFragment fragment = new MascotaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MascotaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mascota, container, false);
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lviMascotas= (ListView)getView().findViewById(R.id.lviMascotas);
        vLoading= getView().findViewById(R.id.vLoading);



        loadData();
        lviMascotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MascotaEntity mascotaEntity= (MascotaEntity)adapterView.getAdapter().getItem(i);
                Bundle bundle =new Bundle();
                bundle.putSerializable("ENTITY",mascotaEntity);
                mListener.changeFragment(bundle, MainActivity.FDETMASCOTA,
                        MainActivity.FMASCOTA);
            }
        });
    }

    private void loadData() {

        queue = Volley.newRequestQueue(getActivity());


        String url = getString(R.string.url_mascota);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {


                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, response.toString());
                        GsonBuilder builder = new GsonBuilder();
                        Gson gson = builder.create();
                        /*
                        {"results":[{"createdAt":"2015-05-27T00:26:37.271Z","detalle":"Perro extraviado en el parque.","distrito":"San Isidro","estado":true,"fec_encontrado":"","fec_extravio":"24\/01\/2015","id_user":"JOFcaW5OOz","name":"Fido","objectId":"sZXoKAwyxI","updatedAt":"2015-05-27T00:28:12.278Z"},
                        {"createdAt":"2015-05-27T00:28:24.895Z","detalle":"Perro Robado en la puerta de su casa.","distrito":"Surco","estado":true,"fec_extravio":"10\/03\/2015","id_user":"S85qqjR3fc","name":"Ruffo","objectId":"j7jk18Jvfu","updatedAt":"2015-05-27T00:29:15.858Z"}]}
                         */
                        MascotaResponse objects = gson.fromJson(response.toString(), MascotaResponse.class);


                        data= objects.getResults();
                        populateMascota();


                        vLoading.setVisibility(View.GONE);


                    }




                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Speaker", "Error: " + error.getMessage());
                // hide the progress dialog


                vLoading.setVisibility(View.GONE);


            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-Parse-Application-Id", getString(R.string.app_id));
                params.put("X-Parse-REST-API-Key", getString(R.string.rest_key));


                return params;
            }
        };
        queue.add(jsonObjReq);

        vLoading.setVisibility(View.VISIBLE);
    }

    private void populateMascota() {

        MascotaAdapter adapter= new MascotaAdapter(getActivity(),R.layout.row_mascota,data);

        lviMascotas.setAdapter(adapter);

    }

    private class MascotaResponse implements Serializable
    {
        private List<MascotaEntity> results;

        public List<MascotaEntity> getResults() {
            return results;
        }

        public void setResults(List<MascotaEntity> results) {
            this.results = results;
        }
    }
}
