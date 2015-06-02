package com.isil.am2.exampledatosabiertos.view.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.isil.am2.exampledatosabiertos.R;
import com.isil.am2.exampledatosabiertos.model.entity.response.MyResponse;
import com.isil.am2.exampledatosabiertos.utils.ParseData;
import com.isil.am2.exampledatosabiertos.view.adapter.SitioARQAdapter;
import com.isil.am2.exampledatosabiertos.view.listeners.OnFragmentListener;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG ="MainFragment" ;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentListener mListener;
    private TextView tviUsername;
    private ListView lviSitios;

    private RequestQueue queue;
    private List<ArrayList<String>> data;

    private View vLoading;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
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
        return inflater.inflate(R.layout.fragment_main, container, false);
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tviUsername= (TextView)getView().findViewById(R.id.tviUsername);
        lviSitios= (ListView)getView().findViewById(R.id.lviSitios);
        vLoading= getView().findViewById(R.id.vLoading);
        tviUsername.setText("Bienvenido "+"");

        loadData();
    }

    private void loadData()
    {
        queue = Volley.newRequestQueue(getActivity());

        // http://api.lima.datosabiertos.pe/datastreams/invoke/GENER-DE-GASTO-2013?auth_key=TU_AUTH_KEY&output=json_array -->
        //String url = getString(R.string.url_datos_abiertos)+getString(R.string.guid1)+"?auth_key="+getString(R.string.key)+"&"+"output="+getString(R.string.output);
        //String url= "http://api.lima.datosabiertos.pe/datastreams/invoke/SITIO-ARQUE-DE-LIMA?auth_key=e053821c67a9d867390ef71d93d22cd9e6ae556f&output=json_array";
        //http://api.lima.datosabiertos.pe/datastreams/invoke/BASE-DE-DATOS-DE-SITIO?auth_key=e053821c67a9d867390ef71d93d22cd9e6ae556f&output=json_array&limit=100

        String url = getString(R.string.url_datos_abiertos)+getString(R.string.guid1)+"?auth_key="+getString(R.string.key)+"&"+"output="+getString(R.string.output)+"&limit="+100;

        Log.v(TAG, " url "+url);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>()
                {

                    @Override
                    public void onResponse(JSONObject response)
                    {
                        Log.i(TAG, response.toString());
                        GsonBuilder builder = new GsonBuilder();
                        Gson gson = builder.create();
                        MyResponse myResponse = gson.fromJson(response.toString(), MyResponse.class);

                        data= myResponse.getResult();
                        populateSitios();
                        Log.v(TAG, "myResponse "+myResponse.toString());
                        vLoading.setVisibility(View.GONE);

                    }

                }, new Response.ErrorListener()
        {


            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.i("Speaker", "Error: " + error.getMessage());
                // hide the progress dialog
                vLoading.setVisibility(View.GONE);
            }
        });
        queue.add(jsonObjReq);
        vLoading.setVisibility(View.VISIBLE);
    }

    private void populateSitios() {

        ParseData  parseData= new ParseData(data);
        SitioARQAdapter adapter= new SitioARQAdapter(getActivity(),R.layout.row_sitio_arq,parseData.getData());

        lviSitios.setAdapter(adapter);
    }

}
